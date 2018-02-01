package com.model.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.Entity;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.entity.Cartdetail;
import com.entity.Orderdetail;
import com.entity.Orderinfo;
import com.entity.Product;

/**
 * A data access object (DAO) providing persistence and search support for
 * Orderinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.entity.Orderinfo
 * @author MyEclipse Persistence Tools
 */

@Entity
public class OrderinfoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(OrderinfoDAO.class);
	// property constants
	public static final String ODERSTATE = "oderstate";
	public static final String USEDPOINTS = "usedpoints";
	public static final String USEDWALLETAMOUNT = "usedwalletamount";
	public static final String USEDTHIRDPAYMENT = "usedthirdpayment";
	public static final String LASTPRICE = "lastprice";
	public static final String INVOICETITLE = "invoicetitle";
	public static final String DELIVERYCYCLE = "deliverycycle";
	public static final String COMMENTS = "comments";

	protected void initDao() {
		// do nothing
	}

	@SuppressWarnings("unchecked")
	public Integer save(final Orderinfo order,final List<Orderdetail> list,final List cartdetaillist) {
		return getHibernateTemplate().execute(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
					session.save(order);
					Integer orderid = order.getOrderid();
					Orderinfo orders = new Orderinfo();
					orders.setOrderid(orderid);
					for(int i = 0 ; i < list.size(); i++){
						Orderdetail orderdetail = new Orderdetail();
						orderdetail.setOrderinfo(orders);
						orderdetail.setProduct(new Product( list.get(i).getProduct().getProductid()));
						orderdetail.setQuantity( list.get(i).getQuantity());
						session.save(orderdetail);
						if(i % 10 == 0){
							session.flush();
				            session.clear();
						}
					}
					if(cartdetaillist != null){
							 String hql = "";
					        for(int i=0;i<cartdetaillist.size();i++) {
					            if(i==0) {
					                hql = "id="+cartdetaillist.get(0);
					            } else {
					                hql =hql + " or id="+cartdetaillist.get(i);
					            }
					        }   
					        Query q= session.createQuery("delete from Cartdetail where "+hql);
					        q.executeUpdate();
						}
				return null;
			}
			
		});
	}

	public void delete(Orderinfo persistentInstance) {
		log.debug("deleting Orderinfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Orderinfo findById(java.lang.Integer id) {
		log.debug("getting Orderinfo instance with id: " + id);
		try {
			Orderinfo instance = (Orderinfo) getHibernateTemplate().get(
					"com.entity.Orderinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Orderinfo> findByExample(Orderinfo instance) {
		log.debug("finding Orderinfo instance by example");
		try {
			List<Orderinfo> results = (List<Orderinfo>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Orderinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Orderinfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	/**
	 * 取消一条订单
	 * @param order
	 */
	public void cancelOrder(final Orderinfo order){
		getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.update(order);
				return null;
			}
			
		});
	}
	/**
	 *获取待付款订单(物流中心和平台的获取内容是不同的)
	 *平台查看所有物流中心
	 *物流中心查看该区域所有经销商
	 * @return
		  物流单号	客户名	地址	总价	发票抬头	创建日期	产品价格	产品名称	数量	促销类别
		  物流单号	客户名	地址	使用积分数	平台钱包	第三方支付	总价	发票抬头	创建日期	支付日期	交货周期	备注信息	产品价格	产品名称	数量	促销类别
		物流单号	客户名	地址	使用积分数	平台钱包	第三方支付	总价	发票抬头	创建日期	支付日期	交货周期	备注信息	发货日期	产品价格	产品名称	数量	促销类别
		物流单号	客户名	地址	使用积分数	平台钱包	第三方支付	总价	发票抬头	创建日期	支付日期	交货周期	备注信息	发货日期	确认收货日期	产品价格	产品名称	数量	促销类别
		物流单号	客户名	地址	使用积分数	平台钱包	第三方支付	总价	发票抬头	创建日期	支付日期	交货周期	备注信息	发货日期	确认收货日期	产品价格	产品名称	数量	促销类别	
	 */
	public List<Map> getPendPay(final Integer userType,final Integer orderstate, final  String province){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {  
            public List<Map> doInHibernate(Session session)  
                    throws HibernateException, SQLException { 
            	String hql="";
            	
        		if(userType==1){//平台用户
        			if(orderstate == 0){
        				hql = "select new map(o.orderid as orderid," +
            			"c.companyid as companyid,"+
            			"c.companyname as companyname,"+
            			"c.managername as managername,"+
            			"c.managerphone as managerphone,"+
            			"a.addressid as addressid,"+
            			"a.consigneename as consigneename,"+
            			"a.consigneephone as consigneephone,"+
            			"a.consigneeaddress as consigneeaddress,"+
            			"o.deliveryid as deliveryid," +  
            			"o.deliverycompany as deliverycompany," +
            			"o.usedpoints as usedpoints," +
            			"o.usedwalletamount as usedwalletamount," +//使用平台钱包
            			"o.usedthirdpayment as usedthirdpayment,"+//第三方支付		
            			"o.lastprice as lastprice) " + "from Orderinfo o,Company c, Address a where c.companyid = o.company.companyid and c.state=0 and a.addressid = o.address.addressid and o.oderstate = 2 ";
            		
        			}else{
        				hql = "select new map(o.orderid as orderid," +
            			"c.companyid as companyid,"+
            			"c.companyname as companyname,"+
            			"c.managername as managername,"+
            			"c.managerphone as managerphone,"+
            			"a.addressid as addressid,"+
            			"a.consigneename as consigneename,"+
            			"a.consigneephone as consigneephone,"+
            			"a.consigneeaddress as consigneeaddress,"+
            			"o.deliveryid as deliveryid," +  
            			"o.deliverycompany as deliverycompany," +
            			"o.usedpoints as usedpoints," +
            			"o.usedwalletamount as usedwalletamount," +//使用平台钱包
            			"o.usedthirdpayment as usedthirdpayment,"+//第三方支付		
            			"o.lastprice as lastprice) " + "from Orderinfo o,Company c, Address a where c.companyid = o.company.companyid and a.addressid = o.address.addressid and o.oderstate = " + orderstate + " ";
            		
        			}
        			
        		}else if(userType == 2){//物流中心
        			hql = "select new map(o.orderid as orderid," +
        			"c.companyid as companyid,"+
        			"c.companyname as companyname,"+
        			"c.managername as managername,"+
        			"c.managerphone as managerphone,"+
        			"a.addressid as addressid,"+
        			"a.consigneename as consigneename,"+
        			"a.consigneephone as consigneephone,"+
        			"a.consigneeaddress as consigneeaddress,"+
        			"o.deliveryid as deliveryid," +  
        			"o.deliverycompany as deliverycompany," +
        			"o.usedpoints as usedpoints," +
        			"o.usedwalletamount as usedwalletamount," +//使用平台钱包
        			"o.usedthirdpayment as usedthirdpayment,"+//第三方支付		
        			"o.lastprice as lastprice) " + "from Userinfo u,Orderinfo o,Company c, Address a where c.companyid = o.company.companyid and a.addressid = o.address.addressid and u.userinfoid=c.companyid and u.userinfoid = o.company.companyid and u.membertype!=2  and o.oderstate = " + orderstate + " and c.province like '"+province+"'";
        		
        		}else
        			{
        				return null;
        			}
				Query query = session.createQuery(hql);
				/*System.out.println(hql);
				System.out.println(query.list().size());*/
		        return query.list();  
            }
            });
	}
	/**
	 * 根据订单查询 订单明细
	 * @return
	 */
	public List<Map> getOrderdetail(final Integer userType,final Integer orderid, final  String province){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {  
            public List<Map> doInHibernate(Session session)  
                    throws HibernateException, SQLException { 
            	String hql="";
        		if(userType==1){//平台用户
        			
        			hql = "select new map( p.productname as productname," +
        					"p.price as price," +
        					"od.oderdetailid as oderdetailid," +
        					"od.quantity as quantity," +
        					"od.saletype as saletype," +
        					
                			"o.invoicetitle as invoicetitle," +//发票抬头
                			"o.createdatetime as createdatetime," +//创建日期
                			"o.paydatetime as paydatetime," +//支付日期       
                			
                			"o.deliverycycle as delivercycle," +
                			"o.comments as comments," +
                			"o.startdeliverytime as startdeliverytime," +//发货日期
                			"o.finishidatetime as finishidatetime" +//确认收货日期   
        					") from Orderdetail od,Product p,Orderinfo o where  od.product.productid = p.productid and od.orderinfo.orderid = o.orderid and od.orderinfo.orderid = "+orderid+" ";
        		
        		}else if(userType == 2){//物流中心
        			hql = "select new map( p.productname as productname," +
					"p.price as price," +
					"od.oderdetailid as oderdetailid," +
					"od.quantity as quantity," +
					"od.saletype as saletype," +
					
        			"o.invoicetitle as invoicetitle," +//发票抬头
        			"o.createdatetime as createdatetime," +//创建日期
        			"o.paydatetime as paydatetime," +//支付日期       
        			
        			"o.deliverycycle as delivercycle," +
        			"o.comments as comments," +
        			"o.startdeliverytime as startdeliverytime," +//发货日期
        			"o.finishidatetime as finishidatetime" +//确认收货日期   
					") from Orderdetail od,Product p,Orderinfo o where  od.product.productid = p.productid and od.orderinfo.orderid = o.orderid and od.orderinfo.orderid = "+orderid+" ";
		
        		}else
        			{
        				return null;
        			}
				Query query = session.createQuery(hql);

		        return query.list();  
            }
            });
	}
	/**
	 * 物流中心完善 订单物流信息
	 * @author Admini
	 * unuse
	 */
	public Object updateOrder(Integer orderid,String deliveryid,String deliverycompany, Timestamp startdeliverytime){
		return this.getHibernateTemplate().execute(new HibernateCallback() {  
            public List<Map> doInHibernate(Session session)  
                    throws HibernateException, SQLException { 
		String hql = "update Orderinfo o set o.deliveryid =:deliveryid ,o.deliverycompany =:deliverycompany,o.startdeliverytime=:startdeliverytime,o.oderstate=3 where o.orderid =:orderid ";
		
		session.createQuery(hql).executeUpdate();
        return null;  
            }
		});
	}
	/**
	 * 获取待付款订单(物流中心和经销商的获取内容是不同的)1
	 * @return
	 */
	public List getPendPayForClient(Integer userType,Integer userid){
		String hql="";
		if(userType==2){//物流中心
			hql = "select new list(o.orderid,p.productname,p.logisticsprice,p.productpicture,od.quantity,o.lastprice,pp.power," +
					"pp.lampholder,pp.colortemp,pp.voltage,pp.luminousflux,pp.lightefficiency," +
					"pp.colorrendering,pp.beamangle,pp.isemc,p.productid) " +
			"from Product p,Orderinfo o,Orderdetail od,Productproperty pp where p.productid = od.product.productid and o.orderid" +
			" = od.orderinfo.orderid and od.product.productid = pp.productid and o.oderstate = 1 and o.company.companyid="+userid;
		}else if(userType == 3){//普通经销商
			
			hql = "select new list(o.orderid,p.productname,p.certifiedprice,p.productpicture,od.quantity,o.lastprice,pp.power," +
					"pp.lampholder,pp.colortemp,pp.voltage,pp.luminousflux,pp.lightefficiency," +
					"pp.colorrendering,pp.beamangle,pp.isemc,p.productid) " +
			"from Product p,Orderinfo o,Orderdetail od,Productproperty pp where p.productid = od.product.productid and o.orderid" +
			" = od.orderinfo.orderid and od.product.productid = pp.productid and o.oderstate = 1 and o.company.companyid="+userid;
		}else if(userType == 4){//认证经销商
				hql = "select new list(o.orderid,p.productname,p.price,p.productpicture,od.quantity,o.lastprice,pp.power," +
						"pp.lampholder,pp.colortemp,pp.voltage,pp.luminousflux,pp.lightefficiency," +
						"pp.colorrendering,pp.beamangle,pp.isemc,p.productid) " +
				"from Product p,Orderinfo o,Orderdetail od,Productproperty pp where p.productid = od.product.productid and o.orderid" +
				" = od.orderinfo.orderid and od.product.productid = pp.productid and o.oderstate = 1 and o.company.companyid="+userid;
		}
		else{
			return null;
		}
		return getHibernateTemplate().find(hql);
	}
	/**
	 * 获取待发货订单(物流中心和经销商的获取内容是不同的)2
	 * @return
	 */
	public List<Map> getPendDelivery(final Integer userType,final Integer userid){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException { 
            	String hql="";
        		if(userType==2){//物流中心
        			hql = "select new list(o.orderid,p.productname,p.logisticsprice,p.productpicture,od.quantity,o.lastprice,pp.power," +
					"pp.lampholder,pp.colortemp,pp.voltage,pp.luminousflux,pp.lightefficiency," +
					"pp.colorrendering,pp.beamangle,pp.isemc,o.paydatetime,o.deliverycycle) " +
			"from Product p,Orderinfo o,Orderdetail od,Productproperty pp where p.productid = od.product.productid and o.orderid" +
			" = od.orderinfo.orderid and od.product.productid = pp.productid and o.oderstate = 2 and o.company.companyid="+userid;
        		}else if(userType == 3){//普通经销商
        			
        			hql = "select new list(o.orderid,p.productname,p.certifiedprice,p.productpicture,od.quantity,o.lastprice,pp.power," +
        					"pp.lampholder,pp.colortemp,pp.voltage,pp.luminousflux,pp.lightefficiency," +
        					"pp.colorrendering,pp.beamangle,pp.isemc,o.paydatetime,o.deliverycycle) " +
        			"from Product p,Orderinfo o,Orderdetail od,Productproperty pp where p.productid = od.product.productid and o.orderid" +
        			" = od.orderinfo.orderid and od.product.productid = pp.productid and o.oderstate = 2 and o.company.companyid="+userid;
        		}else if(userType == 4){//认证经销商
        				hql = "select new list(o.orderid,p.productname,p.price,p.productpicture,od.quantity,o.lastprice,pp.power," +
        						"pp.lampholder,pp.colortemp,pp.voltage,pp.luminousflux,pp.lightefficiency," +
        						"pp.colorrendering,pp.beamangle,pp.isemc,o.paydatetime,o.deliverycycle) " +
        				"from Product p,Orderinfo o,Orderdetail od,Productproperty pp where p.productid = od.product.productid and o.orderid" +
        				" = od.orderinfo.orderid and od.product.productid = pp.productid and o.oderstate = 2 and o.company.companyid="+userid;
        		}else
        		{
        			return null;
        		}
            	Query query = session.createQuery(hql);
                return query.list();  
            }  
        });
	}
	/**
	 * 获取待收货订单(物流中心和经销商获取内容是不同的) 3
	 * @return
	 * 	 */
	public List<Map> getPendTakeDelivery(final Integer userType, final Integer userid){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public List<Map> doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql="";
				if(userType==2){//物流中心
					hql = "select new list(o.orderid,p.productname,p.logisticsprice,p.productpicture,od.quantity,o.lastprice,pp.power," +
					"pp.lampholder,pp.colortemp,pp.voltage,pp.luminousflux,pp.lightefficiency," +
					"pp.colorrendering,pp.beamangle,pp.isemc,o.deliveryid,o.deliverycompany) " +
			"from Product p,Orderinfo o,Orderdetail od,Productproperty pp where p.productid = od.product.productid and o.orderid" +
			" = od.orderinfo.orderid and od.product.productid = pp.productid and o.oderstate = 3 and o.company.companyid="+userid;
				}else if(userType == 3){//普通经销商
        			
        			hql = "select new list(o.orderid,p.productname,p.certifiedprice,p.productpicture,od.quantity,o.lastprice,pp.power," +
        					"pp.lampholder,pp.colortemp,pp.voltage,pp.luminousflux,pp.lightefficiency," +
        					"pp.colorrendering,pp.beamangle,pp.isemc,o.deliveryid,o.deliverycompany) " +
        			"from Product p,Orderinfo o,Orderdetail od,Productproperty pp where p.productid = od.product.productid and o.orderid" +
        			" = od.orderinfo.orderid and od.product.productid = pp.productid and o.oderstate = 3 and o.company.companyid="+userid;
        		}else if(userType == 4){//认证经销商
        				hql = "select new list(o.orderid,p.productname,p.price,p.productpicture,od.quantity,o.lastprice,pp.power," +
        						"pp.lampholder,pp.colortemp,pp.voltage,pp.luminousflux,pp.lightefficiency," +
        						"pp.colorrendering,pp.beamangle,pp.isemc,o.deliveryid,o.deliverycompany) " +
        				"from Product p,Orderinfo o,Orderdetail od,Productproperty pp where p.productid = od.product.productid and o.orderid" +
        				" = od.orderinfo.orderid and od.product.productid = pp.productid and o.oderstate = 3 and o.company.companyid="+userid;
        		}else
				{
					return null;
				}
				Query query = session.createQuery(hql);
                return query.list();  
			}
		});
	}
	/**
	 * 获取待评价订单(物流中心和经销商的获取内容是不同的)4
	 * @return
	 */
	public List getPendComment(final Integer userType, final Integer userid){
		return getHibernateTemplate().executeFind(new HibernateCallback(){

			public List<Map> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql="";
				if(userType==2){//物流中心
					hql = "select new list(o.orderid,p.productname,p.logisticsprice,p.productpicture,od.quantity,o.lastprice,pp.power," +
					"pp.lampholder,pp.colortemp,pp.voltage,pp.luminousflux,pp.lightefficiency," +
					"pp.colorrendering,pp.beamangle,pp.isemc,o.finishidatetime,o.deliverycompany,p.productid) " +
			"from Product p,Orderinfo o,Orderdetail od,Productproperty pp where p.productid = od.product.productid and o.orderid" +
			" = od.orderinfo.orderid and od.product.productid = pp.productid and o.oderstate = 4 and o.company.companyid="+userid;
				}else if(userType == 3){//普通经销商
        			
        			hql = "select new list(o.orderid,p.productname,p.certifiedprice,p.productpicture,od.quantity,o.lastprice,pp.power," +
        					"pp.lampholder,pp.colortemp,pp.voltage,pp.luminousflux,pp.lightefficiency," +
        					"pp.colorrendering,pp.beamangle,pp.isemc,o.finishidatetime,o.deliverycompany,p.productid) " +
        			"from Product p,Orderinfo o,Orderdetail od,Productproperty pp where p.productid = od.product.productid and o.orderid" +
        			" = od.orderinfo.orderid and od.product.productid = pp.productid and o.oderstate = 4 and o.company.companyid="+userid;
        		}else if(userType == 4){//认证经销商
        				hql = "select new list(o.orderid,p.productname,p.price,p.productpicture,od.quantity,o.lastprice,pp.power," +
        						"pp.lampholder,pp.colortemp,pp.voltage,pp.luminousflux,pp.lightefficiency," +
        						"pp.colorrendering,pp.beamangle,pp.isemc,o.finishidatetime,o.deliverycompany,p.productid) " +
        				"from Product p,Orderinfo o,Orderdetail od,Productproperty pp where p.productid = od.product.productid and o.orderid" +
        				" = od.orderinfo.orderid and od.product.productid = pp.productid and o.oderstate = 4 and o.company.companyid="+userid;
        		}else
				{
					return null;
				}
				Query query = session.createQuery(hql);
                return query.list();  
			}
		});
	}

	/**
	 * 获取已完成成功订单(物流中心和经销商的获取内容是不同的)6
	 * @return
	 */
	public List<Map> getBookSuccess(final Integer userType,final Integer userid){
		return getHibernateTemplate().executeFind(new HibernateCallback(){

			public List<Map> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql="";
				if(userType==2){//物流中心
					hql = "select new list(o.orderid,p.productname,p.logisticsprice,p.productpicture,od.quantity,o.lastprice,pp.power," +
					"pp.lampholder,pp.colortemp,pp.voltage,pp.luminousflux,pp.lightefficiency," +
					"pp.colorrendering,pp.beamangle,pp.isemc) " +
			"from Product p,Orderinfo o,Orderdetail od,Productproperty pp where p.productid = od.product.productid and o.orderid" +
			" = od.orderinfo.orderid and od.product.productid = pp.productid and o.oderstate = 6 and o.company.companyid="+userid;
				}else if(userType == 3){//普通经销商
        			
        			hql = "select new list(o.orderid,p.productname,p.certifiedprice,p.productpicture,od.quantity,o.lastprice,pp.power," +
        					"pp.lampholder,pp.colortemp,pp.voltage,pp.luminousflux,pp.lightefficiency," +
        					"pp.colorrendering,pp.beamangle,pp.isemc) " +
        			"from Product p,Orderinfo o,Orderdetail od,Productproperty pp where p.productid = od.product.productid and o.orderid" +
        			" = od.orderinfo.orderid and od.product.productid = pp.productid and o.oderstate = 6 and o.company.companyid="+userid;
        		}else if(userType == 4){//认证经销商
        				hql = "select new list(o.orderid,p.productname,p.price,p.productpicture,od.quantity,o.lastprice,pp.power," +
        						"pp.lampholder,pp.colortemp,pp.voltage,pp.luminousflux,pp.lightefficiency," +
        						"pp.colorrendering,pp.beamangle,pp.isemc) " +
        				"from Product p,Orderinfo o,Orderdetail od,Productproperty pp where p.productid = od.product.productid and o.orderid" +
        				" = od.orderinfo.orderid and od.product.productid = pp.productid and o.oderstate = 6 and o.company.companyid="+userid;
        		}else
				{
					return null;
				}
				Query query = session.createQuery(hql);
                return query.list();  
			}
		});
	}
	/**
	 * 对订单支付
	 * @return
	 */
	public List pay(Integer userType){
		String hql="";
		if(userType==1){//平台用户
			hql = "select new list(o.orderid,o.oderstate,o.createdatetime,o.deliverycycle,o.lastprice) " +
					"from Userinfo u,Orderinfo o where u.userinfoid = o.company.companyid and u.membertype=2";
		}else if(userType == 2){//物流中心
			hql = "select new list(o.orderid,o.oderstate,o.createdatetime,o.deliverycycle,o.lastprice) " +
					"from Userinfo u,Orderinfo o where u.userinfoid = o.company.companyid and u.membertype=3 or u.membertype=4";
		}else{
			return null;
		}
		return getHibernateTemplate().find(hql);
	}
	public Object payfinish(final Integer orderid){
		
		return getHibernateTemplate().execute(new HibernateCallback(){
			public List<Map> doInHibernate(Session session)throws HibernateException, SQLException {
				Timestamp nowTime = new Timestamp(System.currentTimeMillis());
				Transaction tran = getSession().beginTransaction();
				String hql = "update Orderinfo o set o.paydatetime = '"+nowTime+"', o.oderstate = 2 where o.orderid="+orderid;
			session.createQuery(hql).executeUpdate();
	        return null;  
			}
		});
	}
	/**
	 * 确认收货
	 * @return
	 */
	public Object affirmTakeDelivery(final Integer orderid){
		
		return getHibernateTemplate().execute(new HibernateCallback(){
			public List<Map> doInHibernate(Session session)throws HibernateException, SQLException {
				Timestamp nowTime = new Timestamp(System.currentTimeMillis());
				Transaction tran = getSession().beginTransaction();
				String hql = "update Orderinfo o set o.finishidatetime = '"+nowTime+"', o.oderstate = 4 where o.orderid="+orderid;
			session.createQuery(hql).executeUpdate();
	        return null;  
			}
		});
		
	}
	/**
	 * 当评价完之后 订单状态的改变
	 * @param orderid
	 * @return
	 */
	public Object finish(final Integer orderid){
		
		return getHibernateTemplate().execute(new HibernateCallback(){
			public List<Map> doInHibernate(Session session)throws HibernateException, SQLException {
				Timestamp nowTime = new Timestamp(System.currentTimeMillis());
				Transaction tran = getSession().beginTransaction();
				String hql = "update Orderinfo o set  o.oderstate = 6 where o.orderid="+orderid;
			session.createQuery(hql).executeUpdate();
	        return null;  
			}
		});
		
	}
	/**
	 * 物流中心操作某个订单发货
	 * @return
	 */
	public void deliver(Orderinfo orderinfo){
		Transaction tran = getSession().beginTransaction();
		String hql = "update Orderinfo o set o.deliveryid = '"+orderinfo.getDeliveryid()+"' , o.deliverycompany = '"
					+orderinfo.getDeliverycompany()+"' ,o.startdeliverytime = ' "+orderinfo.getStartdeliverytime()+" ',o.oderstate = 3  where o.orderid="+orderinfo.getOrderid();
		Query query = getSession().createQuery(hql);
		query.executeUpdate();
		tran.commit();
	}
	/**
	 * 获得本地区物流中心名字
	 * @param oderstate
	 * @return
	 */
	public List<Map> getCompanyName(final Integer id){
		return this.getHibernateTemplate().execute(new HibernateCallback(){
			public List doInHibernate(Session session)
			throws HibernateException,SQLException{
				String queryString="select new map(c.companyid as companyid,c.companyname as companyname,c.province as province)" +
						" from Userinfo u," +
						" Company c where u.userinfoid = c.companyid " +
						"and u.membertype = 2 and c.province in (select province from Company where companyid=?)";//
				Query query = session.createQuery(queryString);
				List<Map> list = query.setParameter(0, id).list();
				if(list.size() >=1){
					return list;
				}else
					return null;
				
			}
		});
	}
	
	public List<Orderinfo> findByOderstate(Object oderstate) {
		return findByProperty(ODERSTATE, oderstate);
	}

	public List<Orderinfo> findByUsedpoints(Object usedpoints) {
		return findByProperty(USEDPOINTS, usedpoints);
	}

	public List<Orderinfo> findByUsedwalletamount(Object usedwalletamount) {
		return findByProperty(USEDWALLETAMOUNT, usedwalletamount);
	}

	@SuppressWarnings("unchecked")
	public List<Orderinfo> findByUsedthirdpayment(Object usedthirdpayment) {
		return findByProperty(USEDTHIRDPAYMENT, usedthirdpayment);
	}

	public List<Orderinfo> findByLastprice(Object lastprice) {
		return findByProperty(LASTPRICE, lastprice);
	}

	public List<Orderinfo> findByInvoicetitle(Object invoicetitle) {
		return findByProperty(INVOICETITLE, invoicetitle);
	}

	public List<Orderinfo> findByDeliverycycle(Object deliverycycle) {
		return findByProperty(DELIVERYCYCLE, deliverycycle);
	}

	public List<Orderinfo> findByComments(Object comments) {
		return findByProperty(COMMENTS, comments);
	}

	public List findAll() {
		log.debug("finding all Orderinfo instances");
		try {
			String queryString = "from Orderinfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Orderinfo merge(Orderinfo detachedInstance) {
		log.debug("merging Orderinfo instance");
		try {
			Orderinfo result = (Orderinfo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Orderinfo instance) {
		log.debug("attaching dirty Orderinfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Orderinfo instance) {
		log.debug("attaching clean Orderinfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OrderinfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (OrderinfoDAO) ctx.getBean("OrderinfoDAO");
	}
}