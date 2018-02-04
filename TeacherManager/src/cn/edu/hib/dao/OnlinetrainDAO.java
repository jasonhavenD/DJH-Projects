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

import cn.edu.hib.entity.Onlinetrain;

/**
 * A data access object (DAO) providing persistence and search support for
 * Onlinetrain entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.hib.entity.Onlinetrain
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class OnlinetrainDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OnlinetrainDAO.class);
	// property constants
	public static final String TRAINNAME = "trainname";
	public static final String PERIOD = "period";
	public static final String OFFSTATUS = "offstatus";
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

	public void save(Onlinetrain transientInstance) {
		log.debug("saving Onlinetrain instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Onlinetrain persistentInstance) {
		log.debug("deleting Onlinetrain instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Onlinetrain findById(java.lang.String id) {
		log.debug("getting Onlinetrain instance with id: " + id);
		try {
			Onlinetrain instance = (Onlinetrain) getCurrentSession().get(
					"cn.edu.hib.entity.Onlinetrain", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Onlinetrain> findByExample(Onlinetrain instance) {
		log.debug("finding Onlinetrain instance by example");
		try {
			List<Onlinetrain> results = (List<Onlinetrain>) getCurrentSession()
					.createCriteria("cn.edu.hib.entity.Onlinetrain")
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
		log.debug("finding Onlinetrain instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Onlinetrain as model where model."
					+ propertyName + " = '" + value + "'";
			Query queryObject = getCurrentSession().createQuery(queryString);
			// queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Onlinetrain> findByTrainname(Object trainname) {
		return findByProperty(TRAINNAME, trainname);
	}

	public List<Onlinetrain> findByPeriod(Object period) {
		return findByProperty(PERIOD, period);
	}

	public List<Onlinetrain> findByOffstatus(Object offstatus) {
		return findByProperty(OFFSTATUS, offstatus);
	}

	public List<Onlinetrain> findByNote(Object note) {
		return findByProperty(NOTE, note);
	}

	public List findAll() {
		log.debug("finding all Onlinetrain instances");
		try {
			String queryString = "from Onlinetrain";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Onlinetrain merge(Onlinetrain detachedInstance) {
		log.debug("merging Onlinetrain instance");
		try {
			Onlinetrain result = (Onlinetrain) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Onlinetrain instance) {
		log.debug("attaching dirty Onlinetrain instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Onlinetrain instance) {
		log.debug("attaching clean Onlinetrain instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OnlinetrainDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (OnlinetrainDAO) ctx.getBean("OnlinetrainDAO");
	}
}