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

import cn.edu.hib.entity.Promotetrain;

/**
 * A data access object (DAO) providing persistence and search support for
 * Promotetrain entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.hib.entity.Promotetrain
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class PromotetrainDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PromotetrainDAO.class);
	// property constants
	public static final String TRAINNAME = "trainname";
	public static final String TRAINTYPE = "traintype";
	public static final String TRAINADDR = "trainaddr";
	public static final String SPEAKER = "speaker";
	public static final String PERIOD = "period";
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

	public void save(Promotetrain transientInstance) {
		log.debug("saving Promotetrain instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Promotetrain persistentInstance) {
		log.debug("deleting Promotetrain instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Promotetrain findById(java.lang.String id) {
		log.debug("getting Promotetrain instance with id: " + id);
		try {
			Promotetrain instance = (Promotetrain) getCurrentSession().get(
					"cn.edu.hib.entity.Promotetrain", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Promotetrain> findByExample(Promotetrain instance) {
		log.debug("finding Promotetrain instance by example");
		try {
			List<Promotetrain> results = (List<Promotetrain>) getCurrentSession()
					.createCriteria("cn.edu.hib.entity.Promotetrain")
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
		log.debug("finding Promotetrain instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Promotetrain as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Promotetrain> findByTrainname(Object trainname) {
		return findByProperty(TRAINNAME, trainname);
	}

	public List<Promotetrain> findByTraintype(Object traintype) {
		return findByProperty(TRAINTYPE, traintype);
	}

	public List<Promotetrain> findByTrainaddr(Object trainaddr) {
		return findByProperty(TRAINADDR, trainaddr);
	}

	public List<Promotetrain> findBySpeaker(Object speaker) {
		return findByProperty(SPEAKER, speaker);
	}

	public List<Promotetrain> findByPeriod(Object period) {
		return findByProperty(PERIOD, period);
	}

	public List<Promotetrain> findByCheckstatus(Object checkstatus) {
		return findByProperty(CHECKSTATUS, checkstatus);
	}

	public List<Promotetrain> findByNote(Object note) {
		return findByProperty(NOTE, note);
	}

	public List findAll() {
		log.debug("finding all Promotetrain instances");
		try {
			String queryString = "from Promotetrain";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Promotetrain merge(Promotetrain detachedInstance) {
		log.debug("merging Promotetrain instance");
		try {
			Promotetrain result = (Promotetrain) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Promotetrain instance) {
		log.debug("attaching dirty Promotetrain instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Promotetrain instance) {
		log.debug("attaching clean Promotetrain instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PromotetrainDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (PromotetrainDAO) ctx.getBean("PromotetrainDAO");
	}
}