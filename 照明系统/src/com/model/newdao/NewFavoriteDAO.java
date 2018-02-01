package com.model.newdao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newentity.NewFavorite;

/**
 * A data access object (DAO) providing persistence and search support for
 * Favorite entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.newentity.NewFavorite
 * @author MyEclipse Persistence Tools
 */
public class NewFavoriteDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(NewFavoriteDAO.class);
	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(NewFavorite transientInstance) {
		log.debug("saving Favorite instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NewFavorite persistentInstance) {
		log.debug("deleting Favorite instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NewFavorite findById(java.lang.Integer id) {
		log.debug("getting Favorite instance with id: " + id);
		try {
			NewFavorite instance = (NewFavorite) getHibernateTemplate().get("com.newentity.Favorite", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<NewFavorite> findByExample(NewFavorite instance) {
		log.debug("finding Favorite instance by example");
		try {
			List<NewFavorite> results = (List<NewFavorite>) getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Favorite instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Favorite as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Favorite instances");
		try {
			String queryString = "from Favorite";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public NewFavorite merge(NewFavorite detachedInstance) {
		log.debug("merging Favorite instance");
		try {
			NewFavorite result = (NewFavorite) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NewFavorite instance) {
		log.debug("attaching dirty Favorite instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewFavorite instance) {
		log.debug("attaching clean Favorite instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NewFavoriteDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NewFavoriteDAO) ctx.getBean("FavoriteDAO");
	}
}