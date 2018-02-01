package com.model.newdao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

import com.entity.Producttype;

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
public class ProducttypeDAO2 extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ProducttypeDAO2.class);
	// property constants
	public static final String PRODUCTTYPENAME = "producttypename";
	public static final String TABLENAME = "tablename";

	protected void initDao() {
		// do nothing
	}
	
	public Producttype merge(Producttype detachedInstance) {
		log.debug("merging Producttype instance");
		try {
			Producttype result = (Producttype) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Object save(final Producttype producttype) {
		log.debug("saving Producttype instance");
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.save(producttype);
				return null;
			}
		});
	}

	public void delete(Producttype persistentInstance) {
		log.debug("deleting Producttype instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public List<Producttype> findProducttype(int count, int id) {
		String queryString = "from Producttype as model where model.typecount = ? and model.parentproducttypeid = ? order by model.producttypeid ASC";
		return getHibernateTemplate().find(queryString, count, id);

	}

	public List<Producttype> findProducttypeByTypecount(int count) {
		String queryString = "from Producttype as model where model.typecount = ? order by model.producttypeid ASC";
		return getHibernateTemplate().find(queryString, count);

	}

	public Producttype findById(java.lang.Integer id) {
		log.debug("getting Producttype instance with id: " + id);
		try {
			Producttype instance = (Producttype) getHibernateTemplate().get(
					"com.entity.Producttype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Producttype> findByExample(Producttype instance) {
		log.debug("finding Producttype instance by example");
		try {
			List<Producttype> results = (List<Producttype>) getHibernateTemplate()
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

	public List<Producttype> findByParentproducttypeid(Integer id) {
		return findByProperty("parentproducttypeid", id);
	}

	public List<Producttype> findByProducttypename(Object producttypename) {
		return findByProperty(PRODUCTTYPENAME, producttypename);
	}

	public List<Producttype> findByTablename(Object tablename) {
		return findByProperty(TABLENAME, tablename);
	}

	public List<Map> findType() {
		String queryString = "select new map(p.producttypeid as producttypeid,"
				+ "p.producttypename as producttypename) from Producttype p";
		return getHibernateTemplate().find(queryString);
	}

	public static ProducttypeDAO2 getFromApplicationContext(
			ApplicationContext ctx) {
		return (ProducttypeDAO2) ctx.getBean("ProducttypeDAO");
	}

	public List<Producttype> findProducttypesByParentid(int parentproductid) {
		log.debug("finding Producttypes By Parentid");
		try {
			String queryString = "from Producttype as model where model.parentproducttypeid = ? order by model.producttypeid ASC";
			return getHibernateTemplate().find(queryString, parentproductid);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Producttype> findAllProducttypes() {
		log.debug("finding all Producttypes");
		try {
			String queryString = "from Producttype";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Producttype> findAllProducttypesL1() {
		log.debug("finding all Producttypes L1");
		try {
			String queryString = "from Producttype as model where model.parentproducttypeid = -1 order by model.producttypeid ASC";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	// for Ajax ???
	public HashMap<String, ArrayList<String>> findAllProducttypesL2() {
		HashMap<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>();
		try{
			List<Producttype> lstProdTypesL1 = this.findAllProducttypesL1();
			Iterator<Producttype> itPT = lstProdTypesL1.iterator();
			while(itPT.hasNext()) {
				Producttype parentPT = (Producttype)itPT;
				ArrayList<String> lstChildPTs = new ArrayList<String>();
				List<Producttype> lstProdTypesChildren = this.findProducttypesByParentid(parentPT.getProducttypeid());
				Iterator<Producttype> itPTChildren = lstProdTypesChildren.iterator();
				while(itPTChildren.hasNext()) {
					Producttype childPT = (Producttype)itPTChildren;
					lstChildPTs.add(childPT.getProducttypename());
				}
				result.put(parentPT.getProducttypename(), lstChildPTs);
			}
			return result;
		}catch(RuntimeException e){
			e.printStackTrace();
			throw e;
		}
	}
}