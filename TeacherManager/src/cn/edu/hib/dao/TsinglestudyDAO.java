package cn.edu.hib.dao;

import java.util.Date;
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

import cn.edu.hib.entity.Tsinglestudy;
import cn.edu.hib.entity.TsinglestudyId;

/**
 * A data access object (DAO) providing persistence and search support for
 * Tsinglestudy entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.hib.entity.Tsinglestudy
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TsinglestudyDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TsinglestudyDAO.class);
	// property constants
	public static final String TNAME = "tname";
	public static final String TUNIT = "tunit";
	public static final String GENDER = "gender";
	public static final String AGE = "age";
	public static final String RANK = "rank";
	public static final String EDUCATION = "education";
	public static final String DEGREE = "degree";
	public static final String STUDYPLACE = "studyplace";
	public static final String STUDYCONTENT = "studycontent";
	public static final String CHECKSTATUS = "checkstatus";
	public static final String SUMMARYMATERIAL = "summarymaterial";
	public static final String PERIOD = "period";
	public static final String AUDITOR = "auditor";
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

	public void save(Tsinglestudy transientInstance) {
		log.debug("saving Tsinglestudy instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Tsinglestudy persistentInstance) {
		log.debug("deleting Tsinglestudy instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tsinglestudy findById(cn.edu.hib.entity.TsinglestudyId id) {
		log.debug("getting Tsinglestudy instance with id: " + id);
		try {
			Tsinglestudy instance = (Tsinglestudy) getCurrentSession().get(
					"cn.edu.hib.entity.Tsinglestudy", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Tsinglestudy> findByExample(Tsinglestudy instance) {
		log.debug("finding Tsinglestudy instance by example");
		try {
			List<Tsinglestudy> results = (List<Tsinglestudy>) getCurrentSession()
					.createCriteria("cn.edu.hib.entity.Tsinglestudy")
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
		log.debug("finding Tsinglestudy instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Tsinglestudy as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Tsinglestudy> findByTname(Object tname) {
		return findByProperty(TNAME, tname);
	}

	public List<Tsinglestudy> findByTunit(Object tunit) {
		return findByProperty(TUNIT, tunit);
	}

	public List<Tsinglestudy> findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List<Tsinglestudy> findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List<Tsinglestudy> findByRank(Object rank) {
		return findByProperty(RANK, rank);
	}

	public List<Tsinglestudy> findByEducation(Object education) {
		return findByProperty(EDUCATION, education);
	}

	public List<Tsinglestudy> findByDegree(Object degree) {
		return findByProperty(DEGREE, degree);
	}

	public List<Tsinglestudy> findByStudyplace(Object studyplace) {
		return findByProperty(STUDYPLACE, studyplace);
	}

	public List<Tsinglestudy> findByStudycontent(Object studycontent) {
		return findByProperty(STUDYCONTENT, studycontent);
	}

	public List<Tsinglestudy> findByCheckstatus(Object checkstatus) {
		return findByProperty(CHECKSTATUS, checkstatus);
	}

	public List<Tsinglestudy> findBySummarymaterial(Object summarymaterial) {
		return findByProperty(SUMMARYMATERIAL, summarymaterial);
	}

	public List<Tsinglestudy> findByPeriod(Object period) {
		return findByProperty(PERIOD, period);
	}

	public List<Tsinglestudy> findByAuditor(Object auditor) {
		return findByProperty(AUDITOR, auditor);
	}

	public List<Tsinglestudy> findByNote(Object note) {
		return findByProperty(NOTE, note);
	}

	public List findAll() {
		log.debug("finding all Tsinglestudy instances");
		try {
			String queryString = "from Tsinglestudy";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Tsinglestudy merge(Tsinglestudy detachedInstance) {
		log.debug("merging Tsinglestudy instance");
		try {
			Tsinglestudy result = (Tsinglestudy) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Tsinglestudy instance) {
		log.debug("attaching dirty Tsinglestudy instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tsinglestudy instance) {
		log.debug("attaching clean Tsinglestudy instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TsinglestudyDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TsinglestudyDAO) ctx.getBean("TsinglestudyDAO");
	}
}