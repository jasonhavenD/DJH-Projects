package com.model.newdao;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newentity.Customproduct;

/**
 * A data access object (DAO) providing persistence and search support for
 * Customproduct entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.newentity.Customproduct
 * @author MyEclipse Persistence Tools
 */
public class CustomproductDAO2 extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CustomproductDAO2.class);
	// property constants
	public static final String PRODUCTKEY = "productkey";
	public static final String PRODUCTVALUE = "productvalue";
	public static final String PRODUCTID = "productid";

	protected void initDao() {
		// do nothing
	}

	public void save(Customproduct transientInstance) {
		log.debug("saving Customproduct instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Customproduct persistentInstance) {
		log.debug("deleting Customproduct instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Customproduct findById(java.lang.Integer id) {
		log.debug("getting Customproduct instance with id: " + id);
		try {
			Customproduct instance = (Customproduct) getHibernateTemplate()
					.get("com.newentity.Customproduct", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Customproduct> findByExample(Customproduct instance) {
		log.debug("finding Customproduct instance by example");
		try {
			List<Customproduct> results = (List<Customproduct>) getHibernateTemplate()
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
		log.debug("finding Customproduct instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Customproduct as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Customproduct> findByProductkey(Object productkey) {
		return findByProperty(PRODUCTKEY, productkey);
	}

	public List<Customproduct> findByProductvalue(Object productvalue) {
		return findByProperty(PRODUCTVALUE, productvalue);
	}

	public List<Customproduct> findByProductid(Object productid) {
		return findByProperty(PRODUCTID, productid);
	}

	public List findAll() {
		log.debug("finding all Customproduct instances");
		try {
			String queryString = "from Customproduct";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Customproduct merge(Customproduct detachedInstance) {
		log.debug("merging Customproduct instance");
		try {
			Customproduct result = (Customproduct) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Customproduct instance) {
		log.debug("attaching dirty Customproduct instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Customproduct instance) {
		log.debug("attaching clean Customproduct instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CustomproductDAO2 getFromApplicationContext(
			ApplicationContext ctx) {
		return (CustomproductDAO2) ctx.getBean("CustomproductDAO");
	}

	public List findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(int id, String key, String value) {
		// TODO Auto-generated method stub
		
	}
}