package com.model.newdao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newentity.NewOrderdetail;

/**
 * A data access object (DAO) providing persistence and search support for
 * Orderdetail entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.newentity.NewOrderdetail
 * @author MyEclipse Persistence Tools
 */
public class NewOrderdetailDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(NewOrderdetailDAO.class);
	// property constants
	public static final String QUANTITY = "quantity";
	public static final String SALETYPE = "saletype";

	protected void initDao() {
		// do nothing
	}

	public void save(NewOrderdetail transientInstance) {
		log.debug("saving Orderdetail instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NewOrderdetail persistentInstance) {
		log.debug("deleting Orderdetail instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NewOrderdetail findById(java.lang.Integer id) {
		log.debug("getting Orderdetail instance with id: " + id);
		try {
			NewOrderdetail instance = (NewOrderdetail) getHibernateTemplate().get("com.newentity.Orderdetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<NewOrderdetail> findByExample(NewOrderdetail instance) {
		log.debug("finding Orderdetail instance by example");
		try {
			List<NewOrderdetail> results = (List<NewOrderdetail>) getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Orderdetail instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Orderdetail as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<NewOrderdetail> findByQuantity(Object quantity) {
		return findByProperty(QUANTITY, quantity);
	}

	public List<NewOrderdetail> findBySaletype(Object saletype) {
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

	public NewOrderdetail merge(NewOrderdetail detachedInstance) {
		log.debug("merging Orderdetail instance");
		try {
			NewOrderdetail result = (NewOrderdetail) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NewOrderdetail instance) {
		log.debug("attaching dirty Orderdetail instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewOrderdetail instance) {
		log.debug("attaching clean Orderdetail instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NewOrderdetailDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NewOrderdetailDAO) ctx.getBean("OrderdetailDAO");
	}
}