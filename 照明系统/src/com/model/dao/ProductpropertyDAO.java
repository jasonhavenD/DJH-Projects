package com.model.dao;

import java.util.List;
import javax.persistence.Entity;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.entity.Productproperty;

/**
 * A data access object (DAO) providing persistence and search support for
 * Productbulb entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.entity.Productproperty
 * @author MyEclipse Persistence Tools
 */

@Entity
public class ProductpropertyDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ProductpropertyDAO.class);
	// property constants
	public static final String POWER = "power";
	public static final String LUMINOUSFLUX = "luminousflux";
	public static final String LIGHTEFFICIENCY = "lightefficiency";
	public static final String COLORRENDERING = "colorrendering";
	public static final String BEAMANGLE = "beamangle";
	public static final String ISEMC = "isemc";

	protected void initDao() {
		// do nothing
	}

	public void save(Productproperty transientInstance) {
		log.debug("saving Productbulb instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Productproperty persistentInstance) {
		log.debug("deleting Productbulb instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Productproperty findById(java.lang.Integer id) {
		log.debug("getting Productbulb instance with id: " + id);
		try {
			Productproperty instance = (Productproperty) getHibernateTemplate().get(
					"com.entity.Productbulb", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Productproperty> findByExample(Productproperty instance) {
		log.debug("finding Productbulb instance by example");
		try {
			List<Productproperty> results = (List<Productproperty>) getHibernateTemplate()
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
		log.debug("finding Productbulb instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Productbulb as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Productproperty> findByPower(Object power) {
		return findByProperty(POWER, power);
	}

	public List<Productproperty> findByLuminousflux(Object luminousflux) {
		return findByProperty(LUMINOUSFLUX, luminousflux);
	}

	public List<Productproperty> findByLightefficiency(Object lightefficiency) {
		return findByProperty(LIGHTEFFICIENCY, lightefficiency);
	}

	public List<Productproperty> findByColorrendering(Object colorrendering) {
		return findByProperty(COLORRENDERING, colorrendering);
	}

	public List<Productproperty> findByBeamangle(Object beamangle) {
		return findByProperty(BEAMANGLE, beamangle);
	}

	public List<Productproperty> findByIsemc(Object isemc) {
		return findByProperty(ISEMC, isemc);
	}

	public List findAll() {
		log.debug("finding all Productbulb instances");
		try {
			String queryString = "from Productbulb";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Productproperty merge(Productproperty detachedInstance) {
		log.debug("merging Productbulb instance");
		try {
			Productproperty result = (Productproperty) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Productproperty instance) {
		log.debug("attaching dirty Productbulb instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Productproperty instance) {
		log.debug("attaching clean Productbulb instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ProductpropertyDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ProductpropertyDAO) ctx.getBean("ProductbulbDAO");
	}
}