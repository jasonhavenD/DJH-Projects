package cn.edu.hib.dao;


import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hib.entity.Shorttermtrain;
import cn.edu.hib.entity.ShorttermtrainId;

/**
 * A data access object (DAO) providing persistence and search support for
 * Shorttermtrain entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.hib.dao.Shorttermtrain
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ShorttermtrainDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ShorttermtrainDAO.class);
	// property constants
	public static final String TNAME = "tname";
	public static final String TUNIT = "tunit";
	public static final String AGE = "age";
	public static final String RANK = "rank";
	public static final String EDUCATION = "education";
	public static final String DEGREE = "degree";
	public static final String TRAINTOPIC = "traintopic";
	public static final String TRAINADDR = "trainaddr";
	public static final String PERIOD = "period";
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

	public void save(Shorttermtrain transientInstance) {
		log.debug("saving Shorttermtrain instance");
		try {
			getCurrentSession().save(transientInstance);
			System.out.println("Shorttermtrain save successful");
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Shorttermtrain persistentInstance) {
		log.debug("deleting Shorttermtrain instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Shorttermtrain findById(ShorttermtrainId id) {
		log.debug("getting Shorttermtrain instance with id: " + id);
		try {
			Shorttermtrain instance = (Shorttermtrain) getCurrentSession().get(
					"cn.edu.hib.entity.Shorttermtrain", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Shorttermtrain> findByExample(Shorttermtrain instance) {
		log.debug("finding Shorttermtrain instance by example");
		try {
			List<Shorttermtrain> results = (List<Shorttermtrain>) getCurrentSession()
					.createCriteria("cn.edu.hib.dao.Shorttermtrain")
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
		log.debug("finding Shorttermtrain instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Shorttermtrain as model where model."
					+ propertyName + "= " + value + "";
			Query queryObject = getCurrentSession().createQuery(queryString);
			// queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Shorttermtrain> findByTname(Object tname) {
		return findByProperty(TNAME, tname);
	}

	public List<Shorttermtrain> findByTunit(Object tunit) {
		return findByProperty(TUNIT, tunit);
	}

	public List<Shorttermtrain> findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List<Shorttermtrain> findByRank(Object rank) {
		return findByProperty(RANK, rank);
	}

	public List<Shorttermtrain> findByEducation(Object education) {
		return findByProperty(EDUCATION, education);
	}

	public List<Shorttermtrain> findByDegree(Object degree) {
		return findByProperty(DEGREE, degree);
	}

	public List<Shorttermtrain> findByTraintopic(Object traintopic) {
		return findByProperty(TRAINTOPIC, traintopic);
	}

	public List<Shorttermtrain> findByTrainaddr(Object trainaddr) {
		return findByProperty(TRAINADDR, trainaddr);
	}

	public List<Shorttermtrain> findByPeriod(Object period) {
		return findByProperty(PERIOD, period);
	}

	public List<Shorttermtrain> findByNote(Object note) {
		return findByProperty(NOTE, note);
	}

	public List findAll() {
		log.debug("finding all Shorttermtrain instances");
		try {
			String queryString = "from Shorttermtrain";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Shorttermtrain merge(Shorttermtrain detachedInstance) {
		log.debug("merging Shorttermtrain instance");
		try {
			Shorttermtrain result = (Shorttermtrain) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Shorttermtrain instance) {
		log.debug("attaching dirty Shorttermtrain instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Shorttermtrain instance) {
		log.debug("attaching clean Shorttermtrain instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ShorttermtrainDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ShorttermtrainDAO) ctx.getBean("ShorttermtrainDAO");
	}
}