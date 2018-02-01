package com.model.newdao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newentity.NewWalletserial;

/**
 * A data access object (DAO) providing persistence and search support for
 * Walletserial entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.newentity.NewWalletserial
 * @author MyEclipse Persistence Tools
 */
public class NewWalletserialDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(NewWalletserialDAO.class);
	// property constants
	public static final String TYPE = "type";
	public static final String AMOUNT = "amount";

	protected void initDao() {
		// do nothing
	}

	public void save(NewWalletserial transientInstance) {
		log.debug("saving Walletserial instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NewWalletserial persistentInstance) {
		log.debug("deleting Walletserial instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NewWalletserial findById(java.lang.Integer id) {
		log.debug("getting Walletserial instance with id: " + id);
		try {
			NewWalletserial instance = (NewWalletserial) getHibernateTemplate().get("com.newentity.Walletserial", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<NewWalletserial> findByExample(NewWalletserial instance) {
		log.debug("finding Walletserial instance by example");
		try {
			List<NewWalletserial> results = (List<NewWalletserial>) getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Walletserial instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Walletserial as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<NewWalletserial> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<NewWalletserial> findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List findAll() {
		log.debug("finding all Walletserial instances");
		try {
			String queryString = "from Walletserial";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public NewWalletserial merge(NewWalletserial detachedInstance) {
		log.debug("merging Walletserial instance");
		try {
			NewWalletserial result = (NewWalletserial) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NewWalletserial instance) {
		log.debug("attaching dirty Walletserial instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewWalletserial instance) {
		log.debug("attaching clean Walletserial instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NewWalletserialDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NewWalletserialDAO) ctx.getBean("WalletserialDAO");
	}
}