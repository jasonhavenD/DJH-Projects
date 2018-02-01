package com.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.entity.Comment;

/**
 * A data access object (DAO) providing persistence and search support for
 * Comment entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.entity.Comment
 * @author MyEclipse Persistence Tools
 */

@Entity
public class CommentDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(CommentDAO.class);
	// property constants
	public static final String STATE = "state";
	public static final String COMMENTCONTENT = "commentcontent";

	
	Session session ;
	protected void initDao(){
		session = getSession();
	}
	
	//根据commentid删除评论内容
	public void deleteByCommentId(Integer commentid){
		String hql ="delete from Commment c where c.commentid="+commentid;
		Transaction tran = getSession().beginTransaction();
		getSession().createQuery(hql).executeUpdate();
		tran.commit();
		/*String hql="delete Commment as C where C.id=?";

		Query query=session.createQuery(hql);

		query.setInteger(0,commentid);

		query.executeUpdate();

		session.beginTransaction().commit();
		session.close();*/

		}
	//根据commentid更新state值
	public Object updateStateByCommentId(final Integer commentid){
		return getHibernateTemplate().execute(new HibernateCallback(){
			public List<Map> doInHibernate(Session session)throws HibernateException, SQLException {
				String hql = "update Comment c set c.state = 2 where c.commentid = "+commentid;
			session.createQuery(hql).executeUpdate();
	        return null;  
			}
		});
		/*String hql = "update Comment c set c.state = 2 where c.commentid = ?";
		Query query=session.createQuery(hql);

		query.setInteger(0,commentid);

		query.executeUpdate();

		session.beginTransaction().commit();
		session.close();*/
		
		
	}
	//审核findZero
	public List<Map> findZero(){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public List<Map> doInHibernate(Session session){
				
				String hql = "select new map(cm.commentid as commentid,p.productname as productname,c.companyname as companyname,cm.commentcontent as commentcontent) from Comment cm,Product p,Company c where cm.product.productid=p.productid " +
						"and cm.company.companyid = c.companyid and cm.state = 0" ;
				Query query = session.createQuery(hql);
				return query.list();
			}
		});
	}
	//通过
	public List<Map> findTwo(){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public List<Map> doInHibernate(Session session){
				
				String hql = "select new map(cm.commentid as commentid,p.productname as productname,c.companyname as companyname,cm.commentcontent as commentcontent) from Comment cm,Product p,Company c where cm.product.productid=p.productid " +
						"and cm.company.companyid = c.companyid and cm.state = 2" ;
				Query query = session.createQuery(hql);
				return query.list();
			}
		});
	}
	public void save(Comment transientInstance) {
		log.debug("saving Comment instance");
		try {
			getHibernateTemplate().save(transientInstance);
			
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Comment persistentInstance) {
		log.debug("deleting Comment instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public Comment findById(java.lang.Integer id) {
		log.debug("getting Comment instance with id: " + id);
		try {
			Comment instance = (Comment) getHibernateTemplate().get(
					"com.entity.Comment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Comment> findByExample(Comment instance) {
		log.debug("finding Comment instance by example");
		try {
			List<Comment> results = (List<Comment>) getHibernateTemplate()
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
		log.debug("finding Comment instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Comment as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Comment> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<Comment> findByCommentcontent(Object commentcontent) {
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

	public Comment merge(Comment detachedInstance) {
		log.debug("merging Comment instance");
		try {
			Comment result = (Comment) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Comment instance) {
		log.debug("attaching dirty Comment instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Comment instance) {
		log.debug("attaching clean Comment instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CommentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CommentDAO) ctx.getBean("CommentDAO");
	}
}