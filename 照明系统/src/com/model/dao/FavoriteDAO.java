package com.model.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.entity.Favorite;

/**
 * A data access object (DAO) providing persistence and search support for
 * Favorite entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.entity.Favorite
 * @author MyEclipse Persistence Tools
 */

@Entity
public class FavoriteDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(FavoriteDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(Favorite transientInstance) {
		log.debug("saving Favorite instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Favorite persistentInstance) {
		log.debug("deleting Favorite instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Favorite findById(java.lang.Integer id) {
		log.debug("getting Favorite instance with id: " + id);
		try {
			Favorite instance = (Favorite) getHibernateTemplate().get(
					"com.entity.Favorite", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Favorite> findByExample(Favorite instance) {
		log.debug("finding Favorite instance by example");
		try {
			List<Favorite> results = (List<Favorite>) getHibernateTemplate()
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
		log.debug("finding Favorite instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Favorite as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Favorite instances");
		try {
			String queryString = "from Favorite";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * 获取收藏信息
	 * @return
	 */
	public List getCollect(int id){
		//String hql ="select new list(f.favoriteid,p.productname,p.productpicture,p.price,f.collectiontime) from Product p,Favorite f where p.productid = f.product.productid and f.company.companyid ="+id ;
		String hql="select new list(f.favoriteid,p.productname,p.productpicture,p.price,p.certifiedprice,p.logisticsprice,f.collectiontime,u.membertype,p.productid,p.producttype.producttypeid) from Product p,Favorite f,Userinfo u where p.productid = f.product.productid and f.company.companyid = u.userinfoid and f.company.companyid ="+id ;
		return getHibernateTemplate().find(hql);
	}
	public Favorite merge(Favorite detachedInstance) {
		log.debug("merging Favorite instance");
		try {
			Favorite result = (Favorite) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Favorite instance) {
		log.debug("attaching dirty Favorite instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Favorite instance) {
		log.debug("attaching clean Favorite instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FavoriteDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FavoriteDAO) ctx.getBean("FavoriteDAO");
	}
	/**
	 * 检验 收藏夹是否重复
	 */
	public List isFavoExist(final Integer companyid){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {  
            public List<Map> doInHibernate(Session session)  
                    throws HibernateException, SQLException { 
				String hql = "select (f.product.productid) from Favorite f  where f.company.companyid =  '"+companyid+"' ";
				Query query = session.createQuery(hql);	
		        return query.list();
            }
		});
		
	}
}