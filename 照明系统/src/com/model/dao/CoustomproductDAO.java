package com.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.entity.Coustomproduct;
import com.entity.CoustomproductId;

/**
 * A data access object (DAO) providing persistence and search support for
 * Coustomproduct entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.entity.Coustomproduct
 * @author MyEclipse Persistence Tools
 */

public class CoustomproductDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CoustomproductDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}
	public void add(int id,String key,String value)
	{
		CoustomproductId customid=new CoustomproductId(id, key, value);
		Coustomproduct custom=new Coustomproduct(customid);
		save(custom);
	}

	public void save(Coustomproduct transientInstance) {
		log.debug("saving Coustomproduct instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	public List findByID(final int id)
	{
		
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query=session.createQuery
				("from Coustomproduct as cp where cp.id.productid="+id+"");
				return query.list();
			}
			
		});
	}

	public void delete(Coustomproduct persistentInstance) {
		log.debug("deleting Coustomproduct instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Coustomproduct findById(com.entity.CoustomproductId id) {
		log.debug("getting Coustomproduct instance with id: " + id);
		try {
			Coustomproduct instance = (Coustomproduct) getHibernateTemplate()
					.get("com.entity.Coustomproduct", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Coustomproduct> findByExample(Coustomproduct instance) {
		log.debug("finding Coustomproduct instance by example");
		try {
			List<Coustomproduct> results = (List<Coustomproduct>) getHibernateTemplate()
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
		log.debug("finding Coustomproduct instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Coustomproduct as model where model."
					+ propertyName + "= ?";
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

	public Coustomproduct merge(Coustomproduct detachedInstance) {
		log.debug("merging Coustomproduct instance");
		try {
			Coustomproduct result = (Coustomproduct) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Coustomproduct instance) {
		log.debug("attaching dirty Coustomproduct instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Coustomproduct instance) {
		log.debug("attaching clean Coustomproduct instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CoustomproductDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CoustomproductDAO) ctx.getBean("CoustomproductDAO");
	}
}