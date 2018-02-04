package cn.edu.hib.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hib.entity.Teachingevaluation;

/**
 * A data access object (DAO) providing persistence and search support for
 * Teachingevaluation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.hib.entity.Teachingevaluation
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TeachingevaluationDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TeachingevaluationDAO.class);
	// property constants
	public static final String VALUATIONNAME = "valuationname";
	public static final String CHECKSTATUS = "checkstatus";
	public static final String NOTE = "note";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Teachingevaluation transientInstance) {
		log.debug("saving Teachingevaluation instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Teachingevaluation persistentInstance) {
		log.debug("deleting Teachingevaluation instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Teachingevaluation findById(java.lang.String id) {
		log.debug("getting Teachingevaluation instance with id: " + id);
		try {
			Teachingevaluation instance = (Teachingevaluation) getCurrentSession()
					.get("cn.edu.hib.entity.Teachingevaluation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Teachingevaluation> findByExample(Teachingevaluation instance) {
		log.debug("finding Teachingevaluation instance by example");
		try {
			List<Teachingevaluation> results = (List<Teachingevaluation>) getCurrentSession()
					.createCriteria("cn.edu.hib.entity.Teachingevaluation")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Teachingevaluation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Teachingevaluation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Teachingevaluation> findByValuationname(Object valuationname) {
		return findByProperty(VALUATIONNAME, valuationname);
	}

	public List<Teachingevaluation> findByCheckstatus(Object checkstatus) {
		return findByProperty(CHECKSTATUS, checkstatus);
	}

	public List<Teachingevaluation> findByNote(Object note) {
		return findByProperty(NOTE, note);
	}

	public List findAll() {
		log.debug("finding all Teachingevaluation instances");
		try {
			String queryString = "from Teachingevaluation";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Teachingevaluation merge(Teachingevaluation detachedInstance) {
		log.debug("merging Teachingevaluation instance");
		try {
			Teachingevaluation result = (Teachingevaluation) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Teachingevaluation instance) {
		log.debug("attaching dirty Teachingevaluation instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Teachingevaluation instance) {
		log.debug("attaching clean Teachingevaluation instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TeachingevaluationDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TeachingevaluationDAO) ctx.getBean("TeachingevaluationDAO");
	}
}