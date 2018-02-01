package com.model.newdao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newentity.NewDelivercyclepolicy;

/**
 * A data access object (DAO) providing persistence and search support for
 * Delivercyclepolicy entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.newentity.NewDelivercyclepolicy
 * @author MyEclipse Persistence Tools
 */
public class DelivercyclepolicyDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(DelivercyclepolicyDAO.class);
	// property constants
	public static final String DELIVERCYCLE = "delivercycle";
	public static final String DELIVERCYCLEBENEFITS = "delivercyclebenefits";

	protected void initDao() {
		// do nothing
	}

	public void save(NewDelivercyclepolicy transientInstance) {
		log.debug("saving Delivercyclepolicy instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NewDelivercyclepolicy persistentInstance) {
		log.debug("deleting Delivercyclepolicy instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NewDelivercyclepolicy findById(java.lang.Integer id) {
		log.debug("getting Delivercyclepolicy instance with id: " + id);
		try {
			NewDelivercyclepolicy instance = (NewDelivercyclepolicy) getHibernateTemplate()
					.get("com.newentity.Delivercyclepolicy", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<NewDelivercyclepolicy> findByExample(NewDelivercyclepolicy instance) {
		log.debug("finding Delivercyclepolicy instance by example");
		try {
			List<NewDelivercyclepolicy> results = (List<NewDelivercyclepolicy>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Delivercyclepolicy instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Delivercyclepolicy as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<NewDelivercyclepolicy> findByDelivercycle(Object delivercycle) {
		return findByProperty(DELIVERCYCLE, delivercycle);
	}

	public List<NewDelivercyclepolicy> findByDelivercyclebenefits(Object delivercyclebenefits) {
		return findByProperty(DELIVERCYCLEBENEFITS, delivercyclebenefits);
	}

	public List findAll() {
		log.debug("finding all Delivercyclepolicy instances");
		try {
			String queryString = "from Delivercyclepolicy";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public NewDelivercyclepolicy merge(NewDelivercyclepolicy detachedInstance) {
		log.debug("merging Delivercyclepolicy instance");
		try {
			NewDelivercyclepolicy result = (NewDelivercyclepolicy) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NewDelivercyclepolicy instance) {
		log.debug("attaching dirty Delivercyclepolicy instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewDelivercyclepolicy instance) {
		log.debug("attaching clean Delivercyclepolicy instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DelivercyclepolicyDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DelivercyclepolicyDAO) ctx.getBean("DelivercyclepolicyDAO");
	}
}