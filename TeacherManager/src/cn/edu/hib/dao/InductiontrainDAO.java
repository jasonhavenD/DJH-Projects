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

import cn.edu.hib.entity.Inductiontrain;

/**
 * A data access object (DAO) providing persistence and search support for
 * Inductiontrain entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.hib.entity.Inductiontrain
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class InductiontrainDAO {
	private static final Logger log = LoggerFactory
			.getLogger(InductiontrainDAO.class);
	// property constants
	public static final String TNAME = "tname";
	public static final String TUNIT = "tunit";
	public static final String GENDER = "gender";
	public static final String AGE = "age";
	public static final String RANK = "rank";
	public static final String EDUCATION = "education";
	public static final String DEGREE = "degree";
	public static final String TEACHERETHICS = "teacherethics";
	public static final String TEACHINGEFFECT = "teachingeffect";
	public static final String TEACHINGPRACTICE = "teachingpractice";
	public static final String QUALIFICATIONTESTCOACH = "qualificationtestcoach";
	public static final String QUALIFICATIONTEST = "qualificationtest";
	public static final String PROFESSIONALSKILLSTEST = "professionalskillstest";
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

	public void save(Inductiontrain transientInstance) {
		log.debug("saving Inductiontrain instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Inductiontrain persistentInstance) {
		log.debug("deleting Inductiontrain instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Inductiontrain findById(java.lang.String id) {
		log.debug("getting Inductiontrain instance with id: " + id);
		try {
			Inductiontrain instance = (Inductiontrain) getCurrentSession().get(
					"cn.edu.hib.entity.Inductiontrain", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Inductiontrain> findByExample(Inductiontrain instance) {
		log.debug("finding Inductiontrain instance by example");
		try {
			List<Inductiontrain> results = (List<Inductiontrain>) getCurrentSession()
					.createCriteria("cn.edu.hib.entity.Inductiontrain")
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
		log.debug("finding Inductiontrain instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Inductiontrain as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Inductiontrain> findByTname(Object tname) {
		return findByProperty(TNAME, tname);
	}

	public List<Inductiontrain> findByTunit(Object tunit) {
		return findByProperty(TUNIT, tunit);
	}

	public List<Inductiontrain> findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List<Inductiontrain> findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List<Inductiontrain> findByRank(Object rank) {
		return findByProperty(RANK, rank);
	}

	public List<Inductiontrain> findByEducation(Object education) {
		return findByProperty(EDUCATION, education);
	}

	public List<Inductiontrain> findByDegree(Object degree) {
		return findByProperty(DEGREE, degree);
	}

	public List<Inductiontrain> findByTeacherethics(Object teacherethics) {
		return findByProperty(TEACHERETHICS, teacherethics);
	}

	public List<Inductiontrain> findByTeachingeffect(Object teachingeffect) {
		return findByProperty(TEACHINGEFFECT, teachingeffect);
	}

	public List<Inductiontrain> findByTeachingpractice(Object teachingpractice) {
		return findByProperty(TEACHINGPRACTICE, teachingpractice);
	}

	public List<Inductiontrain> findByQualificationtestcoach(
			Object qualificationtestcoach) {
		return findByProperty(QUALIFICATIONTESTCOACH, qualificationtestcoach);
	}

	public List<Inductiontrain> findByQualificationtest(Object qualificationtest) {
		return findByProperty(QUALIFICATIONTEST, qualificationtest);
	}

	public List<Inductiontrain> findByProfessionalskillstest(
			Object professionalskillstest) {
		return findByProperty(PROFESSIONALSKILLSTEST, professionalskillstest);
	}

	public List<Inductiontrain> findByPeriod(Object period) {
		return findByProperty(PERIOD, period);
	}

	public List<Inductiontrain> findByNote(Object note) {
		return findByProperty(NOTE, note);
	}

	public List findAll() {
		log.debug("finding all Inductiontrain instances");
		try {
			String queryString = "from Inductiontrain";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Inductiontrain merge(Inductiontrain detachedInstance) {
		log.debug("merging Inductiontrain instance");
		try {
			Inductiontrain result = (Inductiontrain) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Inductiontrain instance) {
		log.debug("attaching dirty Inductiontrain instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Inductiontrain instance) {
		log.debug("attaching clean Inductiontrain instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static InductiontrainDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (InductiontrainDAO) ctx.getBean("InductiontrainDAO");
	}
}