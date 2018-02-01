package com.model.newdao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newentity.NewUserinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Userinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.newentity.NewUserinfo
 * @author MyEclipse Persistence Tools
 */
public class NewUserinfoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(NewUserinfoDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String PHONE = "phone";
	public static final String EMAIL = "email";
	public static final String QQ = "qq";
	public static final String WEIXIN = "weixin";
	public static final String WEIBO = "weibo";
	public static final String TAOBAO = "taobao";
	public static final String ZHIFUBAO = "zhifubao";
	public static final String PASSWORD = "password";
	public static final String MEMBERTYPE = "membertype";
	public static final String STATE = "state";

	protected void initDao() {
		// do nothing
	}

	public void save(NewUserinfo transientInstance) {
		log.debug("saving Userinfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NewUserinfo persistentInstance) {
		log.debug("deleting Userinfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NewUserinfo findById(java.lang.Integer id) {
		log.debug("getting Userinfo instance with id: " + id);
		try {
			NewUserinfo instance = (NewUserinfo) getHibernateTemplate().get("com.newentity.Userinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<NewUserinfo> findByExample(NewUserinfo instance) {
		log.debug("finding Userinfo instance by example");
		try {
			List<NewUserinfo> results = (List<NewUserinfo>) getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Userinfo instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Userinfo as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<NewUserinfo> findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List<NewUserinfo> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<NewUserinfo> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<NewUserinfo> findByQq(Object qq) {
		return findByProperty(QQ, qq);
	}

	public List<NewUserinfo> findByWeixin(Object weixin) {
		return findByProperty(WEIXIN, weixin);
	}

	public List<NewUserinfo> findByWeibo(Object weibo) {
		return findByProperty(WEIBO, weibo);
	}

	public List<NewUserinfo> findByTaobao(Object taobao) {
		return findByProperty(TAOBAO, taobao);
	}

	public List<NewUserinfo> findByZhifubao(Object zhifubao) {
		return findByProperty(ZHIFUBAO, zhifubao);
	}

	public List<NewUserinfo> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<NewUserinfo> findByMembertype(Object membertype) {
		return findByProperty(MEMBERTYPE, membertype);
	}

	public List<NewUserinfo> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all Userinfo instances");
		try {
			String queryString = "from Userinfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public NewUserinfo merge(NewUserinfo detachedInstance) {
		log.debug("merging Userinfo instance");
		try {
			NewUserinfo result = (NewUserinfo) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NewUserinfo instance) {
		log.debug("attaching dirty Userinfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewUserinfo instance) {
		log.debug("attaching clean Userinfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NewUserinfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NewUserinfoDAO) ctx.getBean("UserinfoDAO");
	}
}