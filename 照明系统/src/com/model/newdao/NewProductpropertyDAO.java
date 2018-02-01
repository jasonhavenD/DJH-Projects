package com.model.newdao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newentity.NewProductproperty;

/**
 * A data access object (DAO) providing persistence and search support for
 * Productproperty entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.newentity.NewProductproperty
 * @author MyEclipse Persistence Tools
 */
public class NewProductpropertyDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(NewProductpropertyDAO.class);
	// property constants
	public static final String POWER = "power";
	public static final String LAMPHOLDER = "lampholder";
	public static final String COLORTEMP = "colortemp";
	public static final String VOLTAGE = "voltage";
	public static final String LUMINOUSFLUX = "luminousflux";
	public static final String LIGHTEFFICIENCY = "lightefficiency";
	public static final String COLORRENDERING = "colorrendering";
	public static final String BEAMANGLE = "beamangle";
	public static final String ISEMC = "isemc";

	protected void initDao() {
		// do nothing
	}

	public void save(NewProductproperty transientInstance) {
		log.debug("saving Productproperty instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NewProductproperty persistentInstance) {
		log.debug("deleting Productproperty instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NewProductproperty findById(java.lang.Integer id) {
		log.debug("getting Productproperty instance with id: " + id);
		try {
			NewProductproperty instance = (NewProductproperty) getHibernateTemplate().get("com.newentity.Productproperty",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<NewProductproperty> findByExample(NewProductproperty instance) {
		log.debug("finding Productproperty instance by example");
		try {
			List<NewProductproperty> results = (List<NewProductproperty>) getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Productproperty instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Productproperty as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<NewProductproperty> findByPower(Object power) {
		return findByProperty(POWER, power);
	}

	public List<NewProductproperty> findByLampholder(Object lampholder) {
		return findByProperty(LAMPHOLDER, lampholder);
	}

	public List<NewProductproperty> findByColortemp(Object colortemp) {
		return findByProperty(COLORTEMP, colortemp);
	}

	public List<NewProductproperty> findByVoltage(Object voltage) {
		return findByProperty(VOLTAGE, voltage);
	}

	public List<NewProductproperty> findByLuminousflux(Object luminousflux) {
		return findByProperty(LUMINOUSFLUX, luminousflux);
	}

	public List<NewProductproperty> findByLightefficiency(Object lightefficiency) {
		return findByProperty(LIGHTEFFICIENCY, lightefficiency);
	}

	public List<NewProductproperty> findByColorrendering(Object colorrendering) {
		return findByProperty(COLORRENDERING, colorrendering);
	}

	public List<NewProductproperty> findByBeamangle(Object beamangle) {
		return findByProperty(BEAMANGLE, beamangle);
	}

	public List<NewProductproperty> findByIsemc(Object isemc) {
		return findByProperty(ISEMC, isemc);
	}

	public List findAll() {
		log.debug("finding all Productproperty instances");
		try {
			String queryString = "from Productproperty";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public NewProductproperty merge(NewProductproperty detachedInstance) {
		log.debug("merging Productproperty instance");
		try {
			NewProductproperty result = (NewProductproperty) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NewProductproperty instance) {
		log.debug("attaching dirty Productproperty instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewProductproperty instance) {
		log.debug("attaching clean Productproperty instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NewProductpropertyDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NewProductpropertyDAO) ctx.getBean("ProductpropertyDAO");
	}
}