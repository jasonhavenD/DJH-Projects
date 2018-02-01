package com.model.dao;

import java.util.List;
import javax.persistence.Entity;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.entity.Inventory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Inventory entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.entity.Inventory
 * @author MyEclipse Persistence Tools
 */

@Entity
public class InventoryDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(InventoryDAO.class);
	// property constants
	public static final String INVENTORYQUANTITY = "inventoryquantity";

	protected void initDao() {
		// do nothing
	}

	public void save(Inventory transientInstance) {
		log.debug("saving Inventory instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Inventory persistentInstance) {
		log.debug("deleting Inventory instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Inventory findById(java.lang.Integer id) {
		log.debug("getting Inventory instance with id: " + id);
		try {
			Inventory instance = (Inventory) getHibernateTemplate().get(
					"com.entity.Inventory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Inventory> findByExample(Inventory instance) {
		log.debug("finding Inventory instance by example");
		try {
			List<Inventory> results = (List<Inventory>) getHibernateTemplate()
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
		log.debug("finding Inventory instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Inventory as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Inventory> findByInventoryquantity(Object inventoryquantity) {
		return findByProperty(INVENTORYQUANTITY, inventoryquantity);
	}

	public List findAll() {
		log.debug("finding all Inventory instances");
		try {
			String queryString = "from Inventory";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Inventory merge(Inventory detachedInstance) {
		log.debug("merging Inventory instance");
		try {
			Inventory result = (Inventory) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Inventory instance) {
		log.debug("attaching dirty Inventory instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Inventory instance) {
		log.debug("attaching clean Inventory instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static InventoryDAO getFromApplicationContext(ApplicationContext ctx) {
		return (InventoryDAO) ctx.getBean("InventoryDAO");
	}
}