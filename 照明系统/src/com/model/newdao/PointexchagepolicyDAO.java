package com.model.newdao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newentity.Pointexchagepolicy;
import com.newentity.PointexchagepolicyId;

/**
 * A data access object (DAO) providing persistence and search support for
 * Pointexchagepolicy entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.newentity.Pointexchagepolicy
 * @author MyEclipse Persistence Tools
 */
public class PointexchagepolicyDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(PointexchagepolicyDAO.class);
	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(Pointexchagepolicy transientInstance) {
		log.debug("saving Pointexchagepolicy instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Pointexchagepolicy persistentInstance) {
		log.debug("deleting Pointexchagepolicy instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pointexchagepolicy findById(com.newentity.PointexchagepolicyId id) {
		log.debug("getting Pointexchagepolicy instance with id: " + id);
		try {
			Pointexchagepolicy instance = (Pointexchagepolicy) getHibernateTemplate()
					.get("com.newentity.Pointexchagepolicy", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Pointexchagepolicy> findByExample(Pointexchagepolicy instance) {
		log.debug("finding Pointexchagepolicy instance by example");
		try {
			List<Pointexchagepolicy> results = (List<Pointexchagepolicy>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Pointexchagepolicy instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Pointexchagepolicy as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Pointexchagepolicy instances");
		try {
			String queryString = "from Pointexchagepolicy";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Pointexchagepolicy merge(Pointexchagepolicy detachedInstance) {
		log.debug("merging Pointexchagepolicy instance");
		try {
			Pointexchagepolicy result = (Pointexchagepolicy) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Pointexchagepolicy instance) {
		log.debug("attaching dirty Pointexchagepolicy instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pointexchagepolicy instance) {
		log.debug("attaching clean Pointexchagepolicy instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PointexchagepolicyDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PointexchagepolicyDAO) ctx.getBean("PointexchagepolicyDAO");
	}
}