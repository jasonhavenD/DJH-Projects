package com.model.newdao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newentity.NewPoint;

/**
 * A data access object (DAO) providing persistence and search support for Point
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.newentity.NewPoint
 * @author MyEclipse Persistence Tools
 */
public class NewPointDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(NewPointDAO.class);
	// property constants
	public static final String PRODUCTID = "productid";
	public static final String TYPE = "type";
	public static final String POINTAMOUNT = "pointamount";

	protected void initDao() {
		// do nothing
	}

	public void save(NewPoint transientInstance) {
		log.debug("saving Point instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NewPoint persistentInstance) {
		log.debug("deleting Point instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NewPoint findById(java.lang.Integer id) {
		log.debug("getting Point instance with id: " + id);
		try {
			NewPoint instance = (NewPoint) getHibernateTemplate().get("com.newentity.Point", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<NewPoint> findByExample(NewPoint instance) {
		log.debug("finding Point instance by example");
		try {
			List<NewPoint> results = (List<NewPoint>) getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Point instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Point as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<NewPoint> findByProductid(Object productid) {
		return findByProperty(PRODUCTID, productid);
	}

	public List<NewPoint> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<NewPoint> findByPointamount(Object pointamount) {
		return findByProperty(POINTAMOUNT, pointamount);
	}

	public List findAll() {
		log.debug("finding all Point instances");
		try {
			String queryString = "from Point";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public NewPoint merge(NewPoint detachedInstance) {
		log.debug("merging Point instance");
		try {
			NewPoint result = (NewPoint) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NewPoint instance) {
		log.debug("attaching dirty Point instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewPoint instance) {
		log.debug("attaching clean Point instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NewPointDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NewPointDAO) ctx.getBean("PointDAO");
	}
}