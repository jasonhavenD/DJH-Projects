package com.model.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PropertyPermission;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

import javax.persistence.Entity;
import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.entity.Coustomproduct;
import com.entity.CoustomproductId;
import com.entity.Product;
import com.entity.Productproperty;
import com.newentity.ProductImg;

/**
 * A data access object (DAO) providing persistence and search support for
 * Product entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.entity.Product
 * @author MyEclipse Persistence Tools
 */

@Entity
public class ProductDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ProductDAO.class);	
	protected void initDao() {
		// do nothing
	}
	@SuppressWarnings("unchecked")
	public List<Map>  searchProduct(final String condition){
		try{
			return this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public List<Map> doInHibernate(Session session){
					
					String queryString = "select new map(p.productid as productid ,p.productname as productname," +
							"p.productpicture as productpicture,p.productdiscribe as productdiscribe,p.price as price," +
							"p.certifiedprice as certifiedprice,p.logisticsprice as logisticsprice" +
							" ,pp.power as power) from Product as p,Productproperty as pp ,Producttype " +
							" as pt where (p.productid = pp.productid and p.producttype.producttypeid" +
							" = pt.producttypeid) and (p.productname like ? or pt.producttypename like ? or" +
							" pp.power like ? or pp.lampholder like ? or pp.colortemp like ? or pp.voltage like ? " +
							" or pp.luminousflux like ? or pp.lightefficiency like ? or pp.colorrendering like ? or pp.beamangle like ? )" ;
					Query query= session.createQuery(queryString).setParameter(0, condition).setParameter(1, condition).setParameter(2, condition)
					.setParameter(3, condition).setParameter(4, condition).setParameter(5, condition).setParameter(6, condition).setParameter(7, condition)
					.setParameter(8, condition).setParameter(9, condition);
					return query.list();
				}
			});
		}catch(RuntimeException e){
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * 某一个产品收藏人气
	 */
	public List getFavoritebyProductid(final Integer productid){
		try{
			return this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public List doInHibernate(Session session){
					String queryString = "from Favorite f where f.product.productid=?";
					List result = session.createQuery(queryString).setParameter(0, productid).list();
					return result;
				}
			});
		}catch(RuntimeException e){
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * 物流中心的库存
	 */
	public List getInventory(final Integer companyid){
		try{
			return this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public List doInHibernate(Session session){
					String queryString = "select new map(i.inventoryquantity as inventoryquantity ,p.productname as productname ,pp.power as power,pp.lampholder as lampholder,pp.colortemp as colortemp " +
							",pp.voltage as voltage,pp.luminousflux as luminousflux,pp.lightefficiency as lightefficiency,pp.colorrendering as colorrendering,pp.beamangle as beamangle,pp.isemc as isemc" +
							" ) from Inventory i,Product p,Productproperty pp  where " +
					"i.company.companyid=? and i.product.productid = p.productid and pp.productid = p.productid";
			       List<Map> result = session.createQuery(queryString).setParameter(0, companyid).list();
			       return result;
				}
			});
		}catch(RuntimeException e){
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * 某一个产品库存量
	 */
	public List getInventorybyProductid(final Integer productid,final Integer companyid){
		try{
			return this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public List doInHibernate(Session session){
					String queryString = "select new map(i.inventoryquantity as inventoryquantity) from Inventory i where " +
					"i.company.companyid=? and i.product.productid = ?";
			List result = session.createQuery(queryString).setParameter(0, companyid).setParameter(1, productid).list();
			return result;
				}
			});
		}catch(RuntimeException e){
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * 某一类产品收藏人气
	 */
	public List getFavorite(final Integer typeid){
		try{
			return this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public List doInHibernate(Session session){
					String queryString = "from Favorite f,Product p,Producttype pt where " +
							"f.product.productid = p.productid and p.producttype.producttypeid = pt.producttypeid and " +
							"pt.producttypeid=?";
					List result = session.createQuery(queryString).setParameter(0, typeid).list();
					return result;
				}
			});
		}catch(RuntimeException e){
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * 某一类产品库存量
	 */
	public List getInventory(final Integer typeid,final Integer companyid){
		try{
			return this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public List doInHibernate(Session session){
					String queryString = "from Inventory i,Product p,Producttype pt where " +
					"i.product.productid = p.productid and p.producttype.producttypeid = pt.producttypeid and i.company.companyid=?" +
					"and p.producttype.producttypeid = ?";
			List result = session.createQuery(queryString).setParameter(0, companyid).setParameter(1, typeid).list();
			return result;
				}
			});
		}catch(RuntimeException e){
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * 通过id获得产品
	 */
	public List<Map> getProductdetailById(final Integer productid){
		try{
			return this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public List<Map> doInHibernate(Session session){
					String queryString = "select new map(p.productname as productname,p.productpicture as productpicture,p.productdiscribe as productdiscribe,p.price as price," +
							"p.certifiedprice as certifiedprice,p.logisticsprice as logisticsprice,p.sendpoints as sendpoints,p.issale as issale,p.issnapup as issnapup,p.isgroupon as isgroupon,p.iscrowdfunding as iscrowdfunding" +
							",p.ishot as ishot,p.isnew as isnew ,p.isrecommend as isrecommend,p.snapupstarttime as snapupstarttime,p.snapupendtime as snapupendtime,p.snapupprice as snapupprice,p.snapupcertifiedprice as snapupcertifiedprice," +
							"p.snapuplogisticsprice as snapuplogisticsprice,p.snapupquantity as snapupquantity,p.grouponstartquantity as grouponstartquantity,p.grouponstarttime as grouponstarttime,p.grouponendtime as grouponendtime," +
							"p.grouponprice as grouponprice,p.grouponcertifiedprice as grouponcertifiedprice,p.grouponlogisticsprice as grouponlogisticsprice,p.grouponquantity as grouponquantity ,p.crowfundingstartquantity as crowfundingstartquantity ," +
							"p.crowfundingdepositrate as crowfundingdepositrate,p.crowfundingstarttime as crowfundingstarttime,p.crowfundingendtime as crowfundingendtime,p.crowfundingprice as crowfundingprice,p.crowfundingcertifiedprice as crowfundingcertifiedprice," +
							"p.crowfundinglogisticsprice as crowfundinglogisticsprice,p.crowfundingquantity as crowfundingquantity,p.inventoryquantity as inventoryquantity,pt.producttypename as producttypename,pt.producttypeid as producttypeid" +
							",pp.power as power,pp.lampholder as lampholder,pp.colortemp as colortemp " +
							",pp.voltage as voltage,pp.luminousflux as luminousflux,pp.lightefficiency as lightefficiency,pp.colorrendering as colorrendering,pp.beamangle as beamangle,pp.isemc as isemc) from Product p,Productproperty pp ,Producttype " +
							"pt where p.productid = pp.productid and p.producttype.producttypeid" +
							" = pt.producttypeid and p.productid = ?";
					List <Map> result = session.createQuery(queryString).setParameter(0, productid).list();
					return result;
				}
			});
		}catch(RuntimeException e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public Object updateProduct(final Product product,final Productproperty property){
		try{
			return this.getHibernateTemplate().execute(new HibernateCallback(){
				public Object doInHibernate(Session session){
					session.update(product);
					property.setProductid(product.getProductid());
					session.update(property);
					return null;
				}
			});
		}catch(RuntimeException re){
			throw re;
		}
	}
	public Object save(final Product product,final Productproperty property,final Map map) {
		log.debug("saving Product instance");
		try {
			return this.getHibernateTemplate().execute(new HibernateCallback(){
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
						session.save(product);
						property.setProductid(product.getProductid());
						session.save(property);
						int id=product.getProductid();
						Iterator iter=map.entrySet().iterator();
						while(iter.hasNext())
						{
							Map.Entry entry=(Entry) iter.next();
							String key=(String)entry.getKey();
							String value=(String)entry.getValue();
							CoustomproductId customid=new CoustomproductId(id, key, value);
							Coustomproduct custom=new Coustomproduct(customid);
							session.save(custom);
						}
						
					
					return null;
				}
				
			});
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(final Product product,final Productproperty property) {
		log.debug("deleting Product instance");
		try {
			
			this.getHibernateTemplate().execute(new HibernateCallback(){
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					session.delete(product);
					session.delete(property);
					return null;
				}
				
			});
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public List<Map> getProductByType(final int typeid){
		return getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session){
				String queryString = "select new map(pd.productid as productid,pd.productname as productname,pd.price as price" +
						",pd.certifiedprice as certifiedprice,pd.logisticsprice as logisticsprice,pt.producttypename as producttypename" +
						",pd.inventoryquantity as inventoryquantity,pd.issnapup as issnapup,pd.isgroupon as isgroupon,pd.iscrowdfunding as " +
						"iscrowdfunding) from Product pd,Producttype pt where pd.producttype.producttypeid = pt.producttypeid and pt.producttypeid = ?";
				List<Map> list = session.createQuery(queryString).setParameter(0,typeid).list();
				return list;
			}
		});
	}
	public List<Map> getProductDetailByType(final int typeid){
		return getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session){
				String queryString = "select new map(p.productid as productid,p.productname as productname,p.productpicture as productpicture,p.productdiscribe as productdiscribe," +
				"p.price as price,p.certifiedprice as certifiedprice,p.logisticsprice as logisticsprice,p.sendpoints as sendpoints," +
				"pp.power as power,pp.lampholder as lampholder," +
				"pp.colortemp as colortemp,pp.voltage as voltage,pp.luminousflux as luminousflux,pp.lightefficiency as lightefficiency " +
				",pp.colorrendering as colorrendering,pp.beamangle as beamangle,pp.isemc as isemc) from Product p,Productproperty pp  " +
				"where p.productid = pp.productid and p.producttype.producttypeid = ?";
				List<Map> list = session.createQuery(queryString).setParameter(0,typeid).list();
				System.out.println(list.size());
				return list;
			}
		});
	}
	public Product findById(java.lang.Integer id) {
		log.debug("getting Product instance with id: " + id);
		try {
			Product instance = (Product) getHibernateTemplate().get(
					"com.entity.Product", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public Productproperty findPropertyById(java.lang.Integer id) {
		log.debug("getting Product instance with id: " + id);
		try {
			Productproperty instance = (Productproperty) getHibernateTemplate().get(
					"com.entity.Productproperty", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public List<Product> findByExample(Product instance) {
		log.debug("finding Product instance by example");
		try {
			List<Product> results = (List<Product>) getHibernateTemplate()
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
		log.debug("finding Product instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Product as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List getAll(){
		String hql = "select new List(p.productname,i.inventoryquantity) from Product p, Inventory i where p.productid = i.product.productid";
		return getHibernateTemplate().find(hql); 
	}
	/**
	 * 限时抢购产品管理
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map> getSnapUp(){
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public List<Map> doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql = "select new map(p.productname,i.inventoryquantity) " +
				"from Product p, Inventory i where p.issnapup = 1 and p.productid = " +
				"i.product.productid"; 
				return session.createQuery(hql).list();
			}
			
		});
	}
	/**
	 * 团购产品管理
	 * 
	 */
	public List getgroupon(){
		String hql = "select new List(p.productname,i.inventoryquantity) from Product p, Inventory i where p.isgroupon = 1 and p.productid = i.product.productid";
		return getHibernateTemplate().find(hql);
	}
	/**
	 * 众筹预售产品管理
	 */
	public List getcrowdfunding(){
		String hql = "select new List(p.productname,i.inventoryquantity) from Product p, Inventory i where p.iscrowdfunding = 1 and p.productid = i.product.productid";
		return getHibernateTemplate().find(hql);
	}
	/**
	 * 热门销售
	 */
	public List<Map> gethot_product(String param){
		return common(param);
	}
	/**
	 * 新品销售
	 * @return
	 */
	public List<Map> getnew_prodcut(String param){
		return common(param);
	}
	public List<Map> getRecommendRand(final Integer tot){
		/**
		 * 根据提供的数量获取随机的问题列表
		 * @param totel
		 * @return
		 */
			List<Map> res = null;
			final Integer totel = tot == null ? new Integer(1) : tot;		
			res = getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session s) {
					String hql = "select new map(p.productid as productid,p.productpicture as productpicture) from Product p where (p.isrecommend = 1) or (p.ispromotion = 1)";
					Query query = s.createQuery(hql);
					int resSize =query.list().size();
					Random r=new Random(); 
					int n = resSize - totel.intValue();
				    return query.setFirstResult(r.nextInt(n)+1).setMaxResults(totel.intValue()).list(); 
				}
			});
			if(null != res && res.size() > 0){
				return res;
			}else{
				return null;
			}
	}
	/**
	 * 推荐产品
	 * @param param
	 * @return
	 */
	public List<Map> getJian_product(String param){
		return common(param);
	}
	@SuppressWarnings("unchecked")
	public List<Map> common(final String param){
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public List<Map> doInHibernate(Session session){
				String queryString = "select new map(p.productid as productid,p.productname as productname,p.productpicture as productpicture," +
						"p.price as price,p.certifiedprice as certifiedprice,p.logisticsprice as logisticsprice" +
						") from Product p where "+param;
				return session.createQuery(queryString).list();
			}
		});
	}
	/**
	 * 通过id获得产品
	 */
	@SuppressWarnings("unchecked")
	public List<Map> active_common(final String param,final String param1){
		try{
			return this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public List<Map> doInHibernate(Session session){
					String queryString = "select new map(p.productid as productid,p.productname as productname,p.producttype.producttypeid as" +
							" producttypeid,p.productpicture as productpicture,p.price as price," +
							"p.certifiedprice as certifiedprice,p.logisticsprice as logisticsprice " +param+
							",pp.power as power,pp.lampholder as lampholder,pp.colortemp as colortemp " +
							",pp.voltage as voltage,pp.luminousflux as luminousflux,pp.lightefficiency as lightefficiency,pp.colorrendering as colorrendering,pp.beamangle as beamangle " +
							") from Product p,Productproperty pp  " +
							" where p.productid = pp.productid and " + param1;
					List <Map> result = session.createQuery(queryString).list();
					return result;
				}
			});
		}catch(RuntimeException e){
			e.printStackTrace();
			throw e;
		}
	}
}