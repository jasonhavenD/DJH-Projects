package com.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.LockMode;
import org.hibernate.hql.FilterTranslator;
import org.hibernate.hql.QueryTranslatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.entity.Cartdetail;
import com.entity.Company;

/**
 * A data access object (DAO) providing persistence and search support for
 * Cartdetail entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.entity.Cartdetail
 * @author MyEclipse Persistence Tools
 */

@Entity
public class CartdetailDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CartdetailDAO.class);
	// property constants
	public static final String NUMBER = "number";
	public static final String SALETYPE = "saletype";

	protected void initDao() {
		// do nothing
	}

	public void save(Cartdetail transientInstance) {
		log.debug("saving Cartdetail instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Cartdetail persistentInstance) {
		log.debug("deleting Cartdetail instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void delete(int productid,int companyid){
		String hql = "delete from Cartdetail c where c.company.companyid = "+ companyid +" and c.product.productid = " + productid;
		Transaction tran = getSession().beginTransaction();
		getSession().createQuery(hql).executeUpdate();
		tran.commit();
	}
	public Cartdetail findById(java.lang.Integer id) {
		log.debug("getting Cartdetail instance with id: " + id);
		try {
			Cartdetail instance = (Cartdetail) getHibernateTemplate().get(
					"com.entity.Cartdetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Cartdetail> findByExample(Cartdetail instance) {
		log.debug("finding Cartdetail instance by example");
		try {
			List<Cartdetail> results = (List<Cartdetail>) getHibernateTemplate()
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
		log.debug("finding Cartdetail instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cartdetail as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Cartdetail> findByNumber(Object number) {
		return findByProperty(NUMBER, number);
	}
	/**
	 * 获取认证经销商的购物车信息
	 * @param id
	 * @return
	 */
	public List getProductbyCertifiedid(Integer id){
		//System.out.println("getProductbyCertifiedid() of CartdetailDAO: " + id);
		String queryString="select new list(c.cartdetailid,p.productpicture,p.productname,p.certifiedprice,c.number,p.productid,pt.power," +
				"pt.lampholder,pt.colortemp,pt.voltage,pt.luminousflux,pt.lightefficiency,pt.colorrendering,pt.beamangle,pt.isemc) "+
				"from Cartdetail c,Product p,Productproperty pt " + 
				"where c.company.companyid="+id+" and p.productid = c.product.productid and pt.productid = p.productid";
		
		List list = getHibernateTemplate().find(queryString);
		//System.out.println("queryString: " + queryString);
		//System.out.println("list: " + list.size());
		
		return list;
	}
	/**
	 * 获取物流中心的购物车信息
	 * @param id
	 * @return
	 */
	public List getProductbylogisticsid(Integer id){
		String queryString="select new list(c.cartdetailid,p.productpicture,p.productname,p.logisticsprice,c.number,p.productid,pt.power," +
				"pt.lampholder,pt.colortemp,pt.voltage,pt.luminousflux,pt.lightefficiency,pt.colorrendering,pt.beamangle,pt.isemc) "+
		"from Cartdetail c,Product p,Productproperty pt where c.company.companyid="+id+" and p.productid = c.product.productid"+
		" and pt.productid = p.productid";
		return getHibernateTemplate().find(queryString);
	}
	/**
	 * 获取普通经销商的购物车信息
	 * @param id
	 * @return
	 */
	public List getProductbyGeneralid(Integer id){
		String queryString="select new list(c.cartdetailid,p.productpicture,p.productname,p.price,c.number,p.productid,pt.power," +
				"pt.lampholder,pt.colortemp,pt.voltage,pt.luminousflux,pt.lightefficiency,pt.colorrendering,pt.beamangle,pt.isemc) " +
		"from Cartdetail c,Product p,Productproperty pt where c.company.companyid="+id+" and p.productid = c.product.productid"+
		" and pt.productid = p.productid";
		return getHibernateTemplate().find(queryString);
	}
	public List<Cartdetail> findBySaletype(Object saletype) {
		return findByProperty(SALETYPE, saletype);
	}

	public List findAll() {
		log.debug("finding all Cartdetail instances");
		try {
			String queryString = "from Cartdetail";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/*
	 * 更改购物车中产品数量
	 */
	public void updateProductColor(Integer comid,Integer proid,Integer number){
		try{
			String hql = "update Cartdetail c set c.number=:number where c.companyid=:comid and c.productid=proid";
			System.out.println(comid+":"+proid+":"+number);
			Transaction tran = getSession().beginTransaction();
			Query query =  getSession().createQuery(hql);
			query.setInteger("number", number).setInteger("comid", comid).setInteger("proid",proid);
			query.executeUpdate();
			tran.commit();
			getSession().flush();
			getSession().close();
		}
		catch(RuntimeException e){
			e.printStackTrace();
		}
		
	}
	/*
	 * 从购物车中删除一件产品
	 */
	public void deleteOneProduct(int proid,int comid){
		System.out.println(proid+":"+comid);
		String hql="delete from Cartdetail c where c.productid ="+proid+" and c.companyid="+comid;
		getHibernateTemplate().delete(hql);

	}
	public void attachDirty(Cartdetail instance) {
		log.debug("attaching dirty Cartdetail instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public Cartdetail merge(Cartdetail detachedInstance) {
		log.debug("merging Cartdetail instance");
		try {
			Cartdetail result = (Cartdetail) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	

	public void attachClean(Cartdetail instance) {
		log.debug("attaching clean Cartdetail instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public static CartdetailDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CartdetailDAO) ctx.getBean("CartdetailDAO");
	}
	/*public List<Map> queryByModelid(final int modelid){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException { 
            	String queryString="select new map("+
            	"mt.modeltypename as modeltypename , "+
            	"a.nickname as nickname ,"+
            	"m.modelname as modelname , "+
            	"m.description as description , "+
            	"m.uploaddatetime as uploaddatetime , "+
            	"m.praises as praises ,"+
            	"m.comments as comments, "+
            	"m.browses as browses , "+
            	"m.downloads as downloads ,"+
            	"m.size as size ,"+
            	"m.volume as volume ,"+
            	"m.price as price) "+
            	"from Model m , Account a , Modeltype mt "+
            	"where m.modelid="+modelid+" and m.accountid=a.accountid and m.typeid=mt.modeltypeid";
            	Query query = session.createQuery(queryString);
                return query.list();  
            }  
        });
	}*/

	/**
	 * 更改购物记录数量
	 */
	public void changeProductCount(final int id, final int count){
		this.getHibernateTemplate().execute(new HibernateCallback() {  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException { 
            	String queryString = "update Cartdetail c set c.number = " + count + " where c.cartdetailid = "+ id;
            	Query query = session.createQuery(queryString);
            	query.executeUpdate();
                return null;  
            }
        });
		
	}
	/**
	 * 检验 购物车是否重复
	 */
	public List isCartExist(final Integer companyid){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {  
            public List<Map> doInHibernate(Session session)  
                    throws HibernateException, SQLException { 
				String hql = "select (c.product.productid) from Cartdetail c  where c.company.companyid =  '"+companyid+"' ";
				Query query = session.createQuery(hql);	
		        return query.list();  
            }
		});
	}
	/**
	 * 获取购物车已有产品的数量
	 * @param companyid
	 * @param productid
	 * @return
	 */
	public List getCartNum(final int companyid,final int productid){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {  
            public List doInHibernate(Session session)  
                    throws HibernateException, SQLException { 
				String hql = "select c.number from Cartdetail c  where c.company.companyid =  '"+companyid+"' and c.product.productid = '"+productid+"' ";
				Query query = session.createQuery(hql);	
		        return query.list();  
            }
		});
	}
	/**
	 * 把已有产品数量 更新
	 * @param productid
	 * @param companyid
	 * @param number
	 */
	public void updateNum(final int companyid,final int productid,final int number){
		this.getHibernateTemplate().execute(new HibernateCallback() {  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException { 
            	String queryString = "update Cartdetail c set c.number = " + number + " where c.product.productid = "+ productid + " and c.company.companyid = "+ companyid;
            	Query query = session.createQuery(queryString);
            	query.executeUpdate();
                return null;  
            }
        });
	}
	
}