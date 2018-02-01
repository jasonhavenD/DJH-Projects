package com.model.newdao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newentity.ProductImg;

/**
 * A data access object (DAO) providing persistence and search support for
 * ProductImg entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.newentity.ProductImg
 * @author MyEclipse Persistence Tools
 */
public class ProductImgDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ProductImgDAO.class);
	// property constants
	public static final String PRODUCTID = "productid";
	public static final String IMGTYPE = "imgtype";
	public static final String IMGURL = "imgurl";

	protected void initDao() {
		// do nothing
	}

	public void save(ProductImg transientInstance) {
		log.debug("saving ProductImg instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ProductImg persistentInstance) {
		log.debug("deleting ProductImg instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProductImg findById(java.lang.Integer id) {
		log.debug("getting ProductImg instance with id: " + id);
		try {
			ProductImg instance = (ProductImg) getHibernateTemplate().get(
					"com.newentity.ProductImg", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ProductImg> findByExample(ProductImg instance) {
		log.debug("finding ProductImg instance by example");
		try {
			List<ProductImg> results = (List<ProductImg>) getHibernateTemplate()
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
		log.debug("finding ProductImg instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ProductImg as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ProductImg> findByProductid(Object productid) {
		return findByProperty(PRODUCTID, productid);
	}

	public List<ProductImg> findByImgtype(Object imgtype) {
		return findByProperty(IMGTYPE, imgtype);
	}

	public List<ProductImg> findByImgurl(Object imgurl) {
		return findByProperty(IMGURL, imgurl);
	}

	public List findAll() {
		log.debug("finding all ProductImg instances");
		try {
			String queryString = "from ProductImg";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ProductImg merge(ProductImg detachedInstance) {
		log.debug("merging ProductImg instance");
		try {
			ProductImg result = (ProductImg) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ProductImg instance) {
		log.debug("attaching dirty ProductImg instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProductImg instance) {
		log.debug("attaching clean ProductImg instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ProductImgDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ProductImgDAO) ctx.getBean("ProductImgDAO");
	}

	public void delete(Integer productid2) {
		// TODO Auto-generated method stub
		String query = "delete ProductImg where productid = " + productid2;
		Query query1 = getSession().createQuery(query);
		query1.executeUpdate();
	}
}