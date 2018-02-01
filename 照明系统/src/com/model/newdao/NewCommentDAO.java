package com.model.newdao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newentity.NewComment;

/**
 * A data access object (DAO) providing persistence and search support for
 * Comment entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.newentity.NewComment
 * @author MyEclipse Persistence Tools
 */
public class NewCommentDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(NewCommentDAO.class);
	// property constants
	public static final String STATE = "state";
	public static final String COMMENTCONTENT = "commentcontent";

	protected void initDao() {
		// do nothing
	}
	
	//根据产品ID获取产品评论
	public List<NewComment> getCommentByProductId(Integer productid) {
		String hql = "from Commment com where com.product.productid=" + productid;
		return this.getSession().createQuery(hql).list();
	}
	

	public void save(NewComment transientInstance) {
		log.debug("saving Comment instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NewComment persistentInstance) {
		log.debug("deleting Comment instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NewComment findById(java.lang.Integer id) {
		log.debug("getting Comment instance with id: " + id);
		try {
			NewComment instance = (NewComment) getHibernateTemplate().get("com.newentity.Comment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<NewComment> findByExample(NewComment instance) {
		log.debug("finding Comment instance by example");
		try {
			List<NewComment> results = (List<NewComment>) getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Comment instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Comment as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<NewComment> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<NewComment> findByCommentcontent(Object commentcontent) {
		return findByProperty(COMMENTCONTENT, commentcontent);
	}

	public List findAll() {
		log.debug("finding all Comment instances");
		try {
			String queryString = "from Comment";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public NewComment merge(NewComment detachedInstance) {
		log.debug("merging Comment instance");
		try {
			NewComment result = (NewComment) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NewComment instance) {
		log.debug("attaching dirty Comment instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewComment instance) {
		log.debug("attaching clean Comment instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NewCommentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NewCommentDAO) ctx.getBean("CommentDAO");
	}
}