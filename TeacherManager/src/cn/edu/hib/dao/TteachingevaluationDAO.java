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

import cn.edu.hib.entity.Tteachingevaluation;
import cn.edu.hib.entity.TteachingevaluationId;

/**
 * A data access object (DAO) providing persistence and search support for
 * Tteachingevaluation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.hib.entity.Tteachingevaluation
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TteachingevaluationDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TteachingevaluationDAO.class);
	// property constants
	public static final String TNAME = "tname";
	public static final String TUNIT = "tunit";
	public static final String GENDER = "gender";
	public static final String RANK = "rank";
	public static final String AGE = "age";
	public static final String EDUCATION = "education";
	public static final String DEGREE = "degree";
	public static final String GRADE = "grade";
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

	public void save(Tteachingevaluation transientInstance) {
		log.debug("saving Tteachingevaluation instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Tteachingevaluation persistentInstance) {
		log.debug("deleting Tteachingevaluation instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tteachingevaluation findById(
			cn.edu.hib.entity.TteachingevaluationId id) {
		log.debug("getting Tteachingevaluation instance with id: " + id);
		try {
			Tteachingevaluation instance = (Tteachingevaluation) getCurrentSession()
					.get("cn.edu.hib.entity.Tteachingevaluation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Tteachingevaluation> findByExample(Tteachingevaluation instance) {
		log.debug("finding Tteachingevaluation instance by example");
		try {
			List<Tteachingevaluation> results = (List<Tteachingevaluation>) getCurrentSession()
					.createCriteria("cn.edu.hib.entity.Tteachingevaluation")
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
		log.debug("finding Tteachingevaluation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Tteachingevaluation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Tteachingevaluation> findByTname(Object tname) {
		return findByProperty(TNAME, tname);
	}

	public List<Tteachingevaluation> findByTunit(Object tunit) {
		return findByProperty(TUNIT, tunit);
	}

	public List<Tteachingevaluation> findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List<Tteachingevaluation> findByRank(Object rank) {
		return findByProperty(RANK, rank);
	}

	public List<Tteachingevaluation> findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List<Tteachingevaluation> findByEducation(Object education) {
		return findByProperty(EDUCATION, education);
	}

	public List<Tteachingevaluation> findByDegree(Object degree) {
		return findByProperty(DEGREE, degree);
	}

	public List<Tteachingevaluation> findByGrade(Object grade) {
		return findByProperty(GRADE, grade);
	}

	public List<Tteachingevaluation> findByNote(Object note) {
		return findByProperty(NOTE, note);
	}

	public List findAll() {
		log.debug("finding all Tteachingevaluation instances");
		try {
			String queryString = "from Tteachingevaluation";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Tteachingevaluation merge(Tteachingevaluation detachedInstance) {
		log.debug("merging Tteachingevaluation instance");
		try {
			Tteachingevaluation result = (Tteachingevaluation) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Tteachingevaluation instance) {
		log.debug("attaching dirty Tteachingevaluation instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tteachingevaluation instance) {
		log.debug("attaching clean Tteachingevaluation instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TteachingevaluationDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TteachingevaluationDAO) ctx.getBean("TteachingevaluationDAO");
	}
}