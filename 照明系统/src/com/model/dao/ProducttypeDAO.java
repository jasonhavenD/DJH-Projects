package com.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.entity.Producttype0;

/**
 * A data access object (DAO) providing persistence and search support for
 * Producttype entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.entity.Producttype0
 * @author MyEclipse Persistence Tools
 */

@Entity
public class ProducttypeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ProducttypeDAO.class);
	// property constants
	public static final String PRODUCTTYPENAME = "producttypename";
	public static final String TABLENAME = "tablename";

	protected void initDao() {
		// do nothing
	}

	public Object save(final Producttype0 producttype) {
		log.debug("saving Producttype instance");
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
            	session.save(producttype);
                return null;  
			}
		});
	}

	public void delete(Producttype0 persistentInstance) {
		log.debug("deleting Producttype instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Producttype0 findById(java.lang.Integer id) {
		log.debug("getting Producttype instance with id: " + id);
		try {
			Producttype0 instance = (Producttype0) getHibernateTemplate().get(
					"com.entity.Producttype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Producttype0> findByExample(Producttype0 instance) {
		log.debug("finding Producttype instance by example");
		try {
			List<Producttype0> results = (List<Producttype0>) getHibernateTemplate()
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
		log.debug("finding Producttype instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Producttype as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Producttype0> findByProducttypename(Object producttypename) {
		return findByProperty(PRODUCTTYPENAME, producttypename);
	}

	public List<Producttype0> findByTablename(Object tablename) {
		return findByProperty(TABLENAME, tablename);
	}
	public List<Map> findType(){
		String queryString = "select new map(p.producttypeid as producttypeid," +
				"p.producttypename as producttypename) from Producttype p";
		return getHibernateTemplate().find(queryString);
	}
	public static ProducttypeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ProducttypeDAO) ctx.getBean("ProducttypeDAO");
	}
}