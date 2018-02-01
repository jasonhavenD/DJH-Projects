package com.model.dao;

import java.util.List;
import javax.persistence.Entity;
import org.hibernate.LockMode;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.entity.Orderdetail;
import com.entity.Orderinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Orderdetail entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.entity.Orderdetail
 * @author MyEclipse Persistence Tools
 */

@Entity
public class OrderdetailDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(OrderdetailDAO.class);
	// property constants
	public static final String QUANTITY = "quantity";
	public static final String SALETYPE = "saletype";

	protected void initDao() {
		// do nothing
	}

	public void save(Orderdetail transientInstance) {
		log.debug("saving Orderdetail instance");
		try {
			Transaction tran = getSession().beginTransaction();
			getHibernateTemplate().save(transientInstance);
			System.out.println("detail id"+transientInstance.getOderdetailid());
			tran.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Orderdetail persistentInstance) {
		log.debug("deleting Orderdetail instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Orderdetail findById(java.lang.Integer id) {
		log.debug("getting Orderdetail instance with id: " + id);
		try {
			Orderdetail instance = (Orderdetail) getHibernateTemplate().get(
					"com.entity.Orderdetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Orderdetail> findByExample(Orderdetail instance) {
		log.debug("finding Orderdetail instance by example");
		try {
			List<Orderdetail> results = (List<Orderdetail>) getHibernateTemplate()
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
		log.debug("finding Orderdetail instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Orderdetail as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	/**
	 * 根据orderid获得orderdetail
	 * @param orderid
	 */
	public List getOrderdetail(Integer orderid){
		log.debug("cancel order  ");
		try {
			Orderinfo order = new Orderinfo();
			order.setOrderid(orderid);
			String hql = "select new list(o.product.productname,o.quantity,o.saletype) from Orderdetail o where o.orderinfo.orderid = " +order.getOrderid();
			return getHibernateTemplate().find(hql);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List<Orderdetail> findByQuantity(Object quantity) {
		return findByProperty(QUANTITY, quantity);
	}

	public List<Orderdetail> findBySaletype(Object saletype) {
		return findByProperty(SALETYPE, saletype);
	}

	public List findAll() {
		log.debug("finding all Orderdetail instances");
		try {
			String queryString = "from Orderdetail";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Orderdetail merge(Orderdetail detachedInstance) {
		log.debug("merging Orderdetail instance");
		try {
			Orderdetail result = (Orderdetail) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Orderdetail instance) {
		log.debug("attaching dirty Orderdetail instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Orderdetail instance) {
		log.debug("attaching clean Orderdetail instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OrderdetailDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (OrderdetailDAO) ctx.getBean("OrderdetailDAO");
	}
}