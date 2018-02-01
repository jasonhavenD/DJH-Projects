package com.model.newdao;

import java.util.List;

import javax.persistence.Entity;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newentity.Homeslides;

/**
 * A data access object (DAO) providing persistence and search support for
 * Homeslides entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.newentity.Homeslides
 * @author MyEclipse Persistence Tools
 */
@Entity
public class HomeslidesDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(HomeslidesDAO.class);
	// property constants
	public static final String PICTURENAME = "picturename";
	public static final String PICTUREPATH = "picturepath";
	public static final String LOWPICTUREPATH = "lowpicturepath";
	public static final String PICTURESEQUENCE = "picturesequence";

	public void save(Homeslides transientInstance) {
		log.debug("saving Homeslides instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Homeslides persistentInstance) {
		log.debug("deleting Homeslides instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Homeslides findById(java.lang.Integer id) {
		log.debug("getting Homeslides instance with id: " + id);
		try {
			Homeslides instance = (Homeslides) getSession().get(
					"com.model.newdao.Homeslides", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

//	public List<Homeslides> findByExample(Homeslides instance) {
//		log.debug("finding Homeslides instance by example");
//		try {
//			List<Homeslides> results = (List<Homeslides>) getSession()
//					.createCriteria("com.model.newdao.Homeslides").add(
//							create(instance)).list();
//			log.debug("find by example successful, result size: "
//					+ results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Homeslides instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Homeslides as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Homeslides> findByPicturename(Object picturename) {
		return findByProperty(PICTURENAME, picturename);
	}

	public List<Homeslides> findByPicturepath(Object picturepath) {
		return findByProperty(PICTUREPATH, picturepath);
	}

	public List<Homeslides> findByLowpicturepath(Object lowpicturepath) {
		return findByProperty(LOWPICTUREPATH, lowpicturepath);
	}

	public List<Homeslides> findByPicturesequence(Object picturesequence) {
		return findByProperty(PICTURESEQUENCE, picturesequence);
	}

	public List findAll() {
		log.debug("finding all Homeslides instances");
		try {
			String queryString = "from Homeslides";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List<Homeslides> findAllOrderBySeq() {
		log.debug("finding all Homeslides instances order by sequence asc");
		try {
			String queryString = "from Homeslides order by picturesequence asc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("findAllOrderBySeq failed", re);
			throw re;
		}
	}

	public Homeslides merge(Homeslides detachedInstance) {
		log.debug("merging Homeslides instance");
		try {
			Homeslides result = (Homeslides) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Homeslides instance) {
		log.debug("attaching dirty Homeslides instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Homeslides instance) {
		log.debug("attaching clean Homeslides instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}