package cn.edu.hib.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hib.entity.Tonlinetrain;
import cn.edu.hib.entity.TonlinetrainId;

/**
 * A data access object (DAO) providing persistence and search support for
 * Tonlinetrain entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.hib.dao.Tonlinetrain
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TonlinetrainDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TonlinetrainDAO.class);
	// property constants
	public static final String TNAME = "tname";
	public static final String GENDER = "gender";
	public static final String TUNIT = "tunit";
	public static final String AGE = "age";
	public static final String RANK = "rank";
	public static final String EDUCATION = "education";
	public static final String DEGREE = "degree";
	public static final String PERIOD = "period";
	public static final String AUDITOR = "auditor";
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

	public void save(Tonlinetrain transientInstance) {
		log.debug("saving Tonlinetrain instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Tonlinetrain persistentInstance) {
		log.debug("deleting Tonlinetrain instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tonlinetrain findById(TonlinetrainId id) {
		log.debug("getting Tonlinetrain instance with id: " + id);
		try {
			Tonlinetrain instance = (Tonlinetrain) getCurrentSession().get(
					"cn.edu.hib.entity.Tonlinetrain", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Tonlinetrain> findByExample(Tonlinetrain instance) {
		log.debug("finding Tonlinetrain instance by example");
		try {
			List<Tonlinetrain> results = (List<Tonlinetrain>) getCurrentSession()
					.createCriteria("cn.edu.hib.entity.Tonlinetrain")
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
		log.debug("finding Tonlinetrain instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Tonlinetrain as model where model."
					+ propertyName + " = '" + value + "'";
			Query queryObject = getCurrentSession().createQuery(queryString);
			// queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Tonlinetrain> findByTname(Object tname) {
		return findByProperty(TNAME, tname);
	}

	public List<Tonlinetrain> findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List<Tonlinetrain> findByTunit(Object tunit) {
		return findByProperty(TUNIT, tunit);
	}

	public List<Tonlinetrain> findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List<Tonlinetrain> findByRank(Object rank) {
		return findByProperty(RANK, rank);
	}

	public List<Tonlinetrain> findByEducation(Object education) {
		return findByProperty(EDUCATION, education);
	}

	public List<Tonlinetrain> findByDegree(Object degree) {
		return findByProperty(DEGREE, degree);
	}

	public List<Tonlinetrain> findByPeriod(Object period) {
		return findByProperty(PERIOD, period);
	}

	public List<Tonlinetrain> findByAuditor(Object auditor) {
		return findByProperty(AUDITOR, auditor);
	}

	public List<Tonlinetrain> findByCheckstatus(Object checkstatus) {
		return findByProperty(CHECKSTATUS, checkstatus);
	}

	public List<Tonlinetrain> findByNote(Object note) {
		return findByProperty(NOTE, note);
	}

	public List findAll() {
		log.debug("finding all Tonlinetrain instances");
		try {
			String queryString = "from Tonlinetrain";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Tonlinetrain merge(Tonlinetrain detachedInstance) {
		log.debug("merging Tonlinetrain instance");
		try {
			Tonlinetrain result = (Tonlinetrain) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Tonlinetrain instance) {
		log.debug("attaching dirty Tonlinetrain instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tonlinetrain instance) {
		log.debug("attaching clean Tonlinetrain instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TonlinetrainDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TonlinetrainDAO) ctx.getBean("TonlinetrainDAO");
	}
}