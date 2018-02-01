package com.model.dao;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Entity;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.entity.Point;

/**
 * A data access object (DAO) providing persistence and search support for Point
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.entity.Point
 * @author MyEclipse Persistence Tools
 */

@Entity
public class PointDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(PointDAO.class);
	// property constants
	public static final String PRODUCTID = "productid";
	public static final String TYPE = "type";
	public static final String POINTAMOUNT = "pointamount";

	protected void initDao() {
		// do nothing
	}

	public void save(Point transientInstance) {
		log.debug("saving Point instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Point persistentInstance) {
		log.debug("deleting Point instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Point findById(java.lang.Integer id) {
		log.debug("getting Point instance with id: " + id);
		try {
			Point instance = (Point) getHibernateTemplate().get(
					"com.entity.Point", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Point> findByExample(Point instance) {
		log.debug("finding Point instance by example");
		try {
			List<Point> results = (List<Point>) getHibernateTemplate()
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
		log.debug("finding Point instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Point as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Point> findByProductid(Object productid) {
		return findByProperty(PRODUCTID, productid);
	}

	public List<Point> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<Point> findByPointamount(Object pointamount) {
		return findByProperty(POINTAMOUNT, pointamount);
	}

	public List findAll() {
		log.debug("finding all Point instances");
		try {
			String queryString = "from Point";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Point merge(Point detachedInstance) {
		log.debug("merging Point instance");
		try {
			Point result = (Point) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	/**
	 * 获取积分流水
	 * @return
	 */
   public List findPoint(){
	   String hql ="select new list(updatetime,type,pointamount) from Point";
	   return getHibernateTemplate().find(hql);
   }
	public void attachDirty(Point instance) {
		log.debug("attaching dirty Point instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Point instance) {
		log.debug("attaching clean Point instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PointDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PointDAO) ctx.getBean("PointDAO");
	}
}