package com.model.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import javax.persistence.Entity;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.entity.Company;
import com.entity.Userinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Userinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.entity.Userinfo
 * @author MyEclipse Persistence Tools
 */

@Entity
public class UserinfoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(UserinfoDAO.class);
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
	
	public Object save(final Userinfo transientInstance) {
		return getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.save(transientInstance);
                return null;  
			}
		});
			
	}

	public void delete(Userinfo persistentInstance) {
		log.debug("deleting Userinfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Userinfo findById(java.lang.Integer id) {
		log.debug("getting Userinfo instance with id: " + id);
		try {
			Userinfo instance = (Userinfo) getHibernateTemplate().get(
					"com.entity.Userinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Userinfo> findByExample(Userinfo instance) {
		log.debug("finding Userinfo instance by example");
		try {
			List<Userinfo> results = (List<Userinfo>) getHibernateTemplate()
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
		log.debug("finding Userinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Userinfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Userinfo> findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List<Userinfo> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<Userinfo> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<Userinfo> findByQq(Object qq) {
		return findByProperty(QQ, qq);
	}

	public List<Userinfo> findByWeixin(Object weixin) {
		return findByProperty(WEIXIN, weixin);
	}

	public List<Userinfo> findByWeibo(Object weibo) {
		return findByProperty(WEIBO, weibo);
	}

	public List<Userinfo> findByTaobao(Object taobao) {
		return findByProperty(TAOBAO, taobao);
	}

	public List<Userinfo> findByZhifubao(Object zhifubao) {
		return findByProperty(ZHIFUBAO, zhifubao);
	}

	public List<Userinfo> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<Userinfo> findByMembertype(Object membertype) {
		return findByProperty(MEMBERTYPE, membertype);
	}

	public List<Userinfo> findByState(Object state) {
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
	public void updateUserinfo(Userinfo entity){
		log.debug("update Userinfo instance");
		try {
			Transaction tran = getSession().beginTransaction();
			getHibernateTemplate().update(entity);
			log.debug("update successful");
			tran.commit();
			getSession().flush();
			getSession().close();
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	/**
	 * 修改密码
	 * @param password
	 * @param userid
	 */
	public Object updatePassword(final String password,final int userid){
		return this.getHibernateTemplate().execute(new HibernateCallback() {  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException {
				String hql = "update Userinfo u set u.password=:password where u.userinfoid=:userid";
				System.out.println(password+":"+userid);
				session.createQuery(hql).executeUpdate();	
		        return null;  
	        }
		});
	}
	/**
	 * 修改用户账号状态
	 * @param id
	 * @param state
	 */
	public Object updateState(Integer id, Integer state){
		return this.getHibernateTemplate().execute(new HibernateCallback() {  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException {
				String hql = "update Userinfo u set u.state=? where u.userinfoid=?";
				/*System.out.println(id+":"+state);
				Transaction tran = getSession().beginTransaction();
				Query query =  getSession().createQuery(hql);
				query.setParameter(0, state).setParameter(1, id).executeUpdate();
				tran.commit();
				getSession().flush();
				getSession().close();*/
				session.createQuery(hql).executeUpdate();
		        return null;  
		    }
		});
	}
	public Userinfo merge(Userinfo detachedInstance) {
		log.debug("merging Userinfo instance");
		try {
			Userinfo result = (Userinfo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Userinfo instance) {
		log.debug("attaching dirty Userinfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Userinfo instance) {
		log.debug("attaching clean Userinfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserinfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserinfoDAO) ctx.getBean("UserinfoDAO");
	}
	//平台获取普通经销商
	public List FindAllNormalUser(){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {  
            public List<Map> doInHibernate(Session session)  
                    throws HibernateException, SQLException {
            	String hql = "select new list(L.username,c.companyid,c.companyname,c.managername,c.managerphone,c.province,c.city,c.district,c.detailaddress,c.email,c.fixphone,c.birthday,c.zipcode) from Userinfo L,Company c where c.companyid = L.userinfoid and L.membertype = 4";
            	Query query = session.createQuery(hql);	
		        return query.list();  
            }
		});
	}
	//平台获取认证经销商
	public List FindAllCompanyUser(){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {  
            public List<Map> doInHibernate(Session session)  
                    throws HibernateException, SQLException {
            	String hql = "select new list(L.username,c.companyid,c.companyname,c.managername,c.managerphone,c.province,c.city,c.district,c.detailaddress,c.email,c.fixphone,c.birthday,c.zipcode,c.idcardpicture,c.companylicensepicture,c.companypicture) from Userinfo L,Company c where c.companyid = L.userinfoid and L.membertype = 3";
            	Query query = session.createQuery(hql);	
		        return query.list();  
            }
		});
	}	
}