package com.model.newdao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newentity.NewCoustomproduct;
import com.newentity.NewCoustomproductId;

/**
 * A data access object (DAO) providing persistence and search support for
 * Coustomproduct entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.newentity.NewCoustomproduct
 * @author MyEclipse Persistence Tools
 */
public class NewCoustomproductDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(NewCoustomproductDAO.class);
	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(NewCoustomproduct transientInstance) {
		log.debug("saving Coustomproduct instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NewCoustomproduct persistentInstance) {
		log.debug("deleting Coustomproduct instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NewCoustomproduct findById(com.newentity.NewCoustomproductId id) {
		log.debug("getting Coustomproduct instance with id: " + id);
		try {
			NewCoustomproduct instance = (NewCoustomproduct) getHibernateTemplate().get("com.newentity.Coustomproduct", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<NewCoustomproduct> findByExample(NewCoustomproduct instance) {
		log.debug("finding Coustomproduct instance by example");
		try {
			List<NewCoustomproduct> results = (List<NewCoustomproduct>) getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Coustomproduct instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Coustomproduct as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Coustomproduct instances");
		try {
			String queryString = "from Coustomproduct";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public NewCoustomproduct merge(NewCoustomproduct detachedInstance) {
		log.debug("merging Coustomproduct instance");
		try {
			NewCoustomproduct result = (NewCoustomproduct) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NewCoustomproduct instance) {
		log.debug("attaching dirty Coustomproduct instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewCoustomproduct instance) {
		log.debug("attaching clean Coustomproduct instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NewCoustomproductDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NewCoustomproductDAO) ctx.getBean("CoustomproductDAO");
	}
}