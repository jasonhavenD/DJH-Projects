package com.model.newdao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.entity.Product;
import com.entity.Userinfo;
import com.newentity.NewCartdetail;
import com.newentity.NewUserinfo;
import com.sun.istack.internal.FinalArrayList;

/**
 * A data access object (DAO) providing persistence and search support for
 * Cartdetail entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.newentity.NewCartdetail
 * @author MyEclipse Persistence Tools
 */
public class NewCartdetailDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(NewCartdetailDAO.class);
	// property constants
	public static final String NUMBER = "number";
	public static final String SALETYPE = "saletype";

	protected void initDao() {
		// do nothing
	}
	
	/**
	 * 获取当前用户的购物车信息
	 * @param userinfo
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Map> getCartByUser(final NewUserinfo userinfo){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public List<Map> doInHibernate(Session session)
					throws HibernateException, SQLException {
				//判断当前用户类型，呈现产品不同价格
				String price = "";
				if(userinfo.getMembertype() == 4){//普通经销商
					price = "price";
				}else if(userinfo.getMembertype() == 3){//认证经销商
					price = "certifiedprice";
				}else if(userinfo.getMembertype() == 2){//物流中心
					price = "logisticsprice";
				}
				String queryString="select new map(c.cartdetailid,p.productpicture,p.productname,p." + price + ",c.number,p.productid,pt.power," +
						"pt.lampholder,pt.colortemp,pt.voltage,pt.luminousflux,pt.lightefficiency,pt.colorrendering,pt.beamangle,pt.isemc) " +
				"from NewCartdetail c,NewProduct p,NewProductproperty pt where c.company.companyid=" + userinfo.getUserinfoid() +" and p.productid = c.product.productid"+
				" and pt.productid = p.productid";
				List <Map> result = session.createQuery(queryString).list();
				return result;
			}
		});
	}
	
	public List<NewCartdetail> getCartByUserId2(Integer userid) {
		String hql = "from NewCartdetail where companyid = " + userid;
		return this.getHibernateTemplate().find(hql);
	}
	
	/**
	 * 清空购物车
	 * @param id
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String delAllCart(final Integer userinfoid){
		this.getHibernateTemplate().execute(new HibernateCallback() {  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException { 
            	String queryString = "delete from NewCartdetail c where c.company.companyid =" + userinfoid;
            	Query query = session.createQuery(queryString);
            	query.executeUpdate();
            	String str = "success";
                return str;  
            }
        });
		String str1 = "success"; //"fail";
		return str1;
	}

	public void save(NewCartdetail transientInstance) {
		log.debug("saving Cartdetail instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NewCartdetail persistentInstance) {
		log.debug("deleting Cartdetail instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NewCartdetail findById(java.lang.Integer id) {
		log.debug("getting Cartdetail instance with id: " + id);
		try {
			NewCartdetail instance = (NewCartdetail) getHibernateTemplate().get("com.newentity.NewCartdetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<NewCartdetail> findByExample(NewCartdetail instance) {
		log.debug("finding Cartdetail instance by example");
		try {
			List<NewCartdetail> results = (List<NewCartdetail>) getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Cartdetail instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Cartdetail as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<NewCartdetail> findByNumber(Object number) {
		return findByProperty(NUMBER, number);
	}

	public List<NewCartdetail> findBySaletype(Object saletype) {
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

	public NewCartdetail merge(NewCartdetail detachedInstance) {
		log.debug("merging Cartdetail instance");
		try {
			NewCartdetail result = (NewCartdetail) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NewCartdetail instance) {
		log.debug("attaching dirty Cartdetail instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewCartdetail instance) {
		log.debug("attaching clean Cartdetail instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NewCartdetailDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NewCartdetailDAO) ctx.getBean("CartdetailDAO");
	}
	
	/**
	 * 检查购物车是否重复
	 * @param userinfoid
	 * @return
	 */
	public List isCartExist(final Integer userinfoid) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {  
            public List<Map> doInHibernate(Session session)  
                    throws HibernateException, SQLException { 
				String hql = "select (c.product.productid) from Cartdetail c  where c.company.companyid =  '"+userinfoid+"' ";
			//	String hql = "setect (c.product.productid) from Cartdetail c where c.company.companyid ="+userinfoid;
            	Query query = session.createQuery(hql);	
		        return query.list();  
            }
		});
	}
	
	public boolean isCartExist(Integer userinfoid, Integer productid) {
		// TODO Auto-generated method stub
		List list = this.isCartExist(userinfoid);
		if(list.contains(productid)){
			return true;
		}else
			return false;
	}

	public List getCartNum(final Integer userinfoid,final Integer productid) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {  
            public List doInHibernate(Session session)  
                    throws HibernateException, SQLException { 
				String hql = "select c.number from Cartdetail c  where c.company.companyid =  '"+userinfoid+"' and c.product.productid = '"+productid+"' ";
				Query query = session.createQuery(hql);	
		        return query.list();  
            }
		});
	}

	public void updateNum(final Integer userinfoid,final Integer productid,final int i) {
		this.getHibernateTemplate().execute(new HibernateCallback() {  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException { 
            	String queryString = "update Cartdetail c set c.number = " + i + " where c.product.productid = "+ productid + " and c.company.companyid = "+ userinfoid;
            	Query query = session.createQuery(queryString);
            	query.executeUpdate();
                return null;  
            }
        });
	}

	/**
	 * 更改购物车某条记录的商品数量
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
	 * 获取购物车中某条购物车记录里的商品数量
	 * @param cartid
	 * @return
	 */
	public List findProductById (final Integer cartid) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {  
            public List<Map> doInHibernate(Session session)  
                    throws HibernateException, SQLException { 
				String hql = "select (c.number) from Cartdetail c  where c.cartdetailid =  '"+cartid+"' ";
			//	String hql = "setect (c.product.productid) from Cartdetail c where c.company.companyid ="+userinfoid;
            	Query query = session.createQuery(hql);	
		        return query.list();  
            }
		});
	}
	
	
	/**
	 * 删除某条购物车记录
	 * @param cartid
	 * @return
	 */
	public String deleteCartById(final Integer cartid) {
		// TODO Auto-generated method stub
		Session session = getSession();
		try{
				String hql = "delete from Cartdetail c  where c.cartdetailid =  '"+cartid+"' ";
				//System.out.println("123");
				session.createQuery(hql).executeUpdate();
				String str = "success";
				return str;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String str1 = "fail";
			return "fail";
		}finally{
			session.close();
		}
		//return null;
	}

}