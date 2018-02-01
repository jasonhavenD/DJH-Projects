package com.model.newdao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.entity.Cartdetail;
import com.entity.Orderdetail;
import com.entity.Orderinfo;
import com.entity.Product;
import com.newentity.NewCartdetail;
import com.newentity.NewOrderdetail;
import com.newentity.NewOrderinfo;
import com.newentity.NewProduct;

/**
 * A data access object (DAO) providing persistence and search support for
 * Orderinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.newentity.NewOrderinfo
 * @author MyEclipse Persistence Tools
 */
public class NewOrderinfoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(NewOrderinfoDAO.class);
	// property constants
	public static final String ODERSTATE = "oderstate";
	public static final String USEDPOINTS = "usedpoints";
	public static final String USEDWALLETAMOUNT = "usedwalletamount";
	public static final String USEDTHIRDPAYMENT = "usedthirdpayment";
	public static final String LASTPRICE = "lastprice";
	public static final String INVOICETITLE = "invoicetitle";
	public static final String DELIVERYCYCLE = "deliverycycle";
	public static final String COMMENTS = "comments";
	public static final String DELIVERYID = "deliveryid";
	public static final String DELIVERYCOMPANY = "deliverycompany";

	protected void initDao() {
		// do nothing
	}
	/**
  	 * 确认订单
  	 * @param order list
  	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void saveOrderInfo(final NewOrderinfo orderinfo,final List<NewCartdetail> cartdetaillist) {
		this.getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException{
			    //保存订单信息 产生订单号
				session.save(orderinfo);
				System.out.println("订单号    :" + orderinfo.getOrderid());
				//取购物车中产品信息保存至订单明细，并删除相应购物车信息
				for(NewCartdetail newCartdetail : cartdetaillist){
					//取购物车中产品信息保存至订单明细
					NewOrderdetail newOrderdetail = new NewOrderdetail();
					newOrderdetail.setProduct(newCartdetail.getProduct());
					newOrderdetail.setQuantity(newOrderdetail.getQuantity());
					newOrderdetail.setOrderinfo(orderinfo);
					session.save(newOrderdetail);
					System.out.println("订单明细对应订单号    :" + newOrderdetail.getOrderinfo().getOrderid());
					//删除相应购物车中信息
					session.delete(newCartdetail);
				}
			    return null;
			}
			
		});
	}
	public void save(NewOrderinfo transientInstance) {
		log.debug("saving Orderinfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NewOrderinfo persistentInstance) {
		log.debug("deleting Orderinfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NewOrderinfo findById(java.lang.Integer id) {
		log.debug("getting Orderinfo instance with id: " + id);
		try {
			NewOrderinfo instance = (NewOrderinfo) getHibernateTemplate().get("com.newentity.Orderinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<NewOrderinfo> findByExample(NewOrderinfo instance) {
		log.debug("finding Orderinfo instance by example");
		try {
			List<NewOrderinfo> results = (List<NewOrderinfo>) getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Orderinfo instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Orderinfo as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<NewOrderinfo> findByOderstate(Object oderstate) {
		return findByProperty(ODERSTATE, oderstate);
	}

	public List<NewOrderinfo> findByUsedpoints(Object usedpoints) {
		return findByProperty(USEDPOINTS, usedpoints);
	}

	public List<NewOrderinfo> findByUsedwalletamount(Object usedwalletamount) {
		return findByProperty(USEDWALLETAMOUNT, usedwalletamount);
	}

	public List<NewOrderinfo> findByUsedthirdpayment(Object usedthirdpayment) {
		return findByProperty(USEDTHIRDPAYMENT, usedthirdpayment);
	}

	public List<NewOrderinfo> findByLastprice(Object lastprice) {
		return findByProperty(LASTPRICE, lastprice);
	}

	public List<NewOrderinfo> findByInvoicetitle(Object invoicetitle) {
		return findByProperty(INVOICETITLE, invoicetitle);
	}

	public List<NewOrderinfo> findByDeliverycycle(Object deliverycycle) {
		return findByProperty(DELIVERYCYCLE, deliverycycle);
	}

	public List<NewOrderinfo> findByComments(Object comments) {
		return findByProperty(COMMENTS, comments);
	}

	public List<NewOrderinfo> findByDeliveryid(Object deliveryid) {
		return findByProperty(DELIVERYID, deliveryid);
	}

	public List<NewOrderinfo> findByDeliverycompany(Object deliverycompany) {
		return findByProperty(DELIVERYCOMPANY, deliverycompany);
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

	public NewOrderinfo merge(NewOrderinfo detachedInstance) {
		log.debug("merging Orderinfo instance");
		try {
			NewOrderinfo result = (NewOrderinfo) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NewOrderinfo instance) {
		log.debug("attaching dirty Orderinfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewOrderinfo instance) {
		log.debug("attaching clean Orderinfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NewOrderinfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NewOrderinfoDAO) ctx.getBean("OrderinfoDAO");
	}
}