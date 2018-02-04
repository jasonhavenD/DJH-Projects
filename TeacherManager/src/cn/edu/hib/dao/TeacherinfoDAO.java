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

import cn.edu.hib.entity.Teacherinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Teacherinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.hib.entity.Teacherinfo
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TeacherinfoDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TeacherinfoDAO.class);
	// property constants
	public static final String TNAME = "tname";
	public static final String TYPE = "type";
	public static final String PASSWORD = "password";
	public static final String PHONE = "phone";
	public static final String MAIL = "mail";
	public static final String TUNIT = "tunit";
	public static final String GENDER = "gender";
	public static final String EDUCATION = "education";
	public static final String DEGREE = "degree";
	public static final String RANK = "rank";
	public static final String GRADUATEUNIVERSITY = "graduateuniversity";
	public static final String LOGINSTATUS = "loginstatus";
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

	public void save(Teacherinfo transientInstance) {
		log.debug("saving Teacherinfo instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Teacherinfo persistentInstance) {
		log.debug("deleting Teacherinfo instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Teacherinfo findById(java.lang.String id) {
		log.debug("getting Teacherinfo instance with id: " + id);
		try {
			Teacherinfo instance = (Teacherinfo) getCurrentSession().get(
					"cn.edu.hib.entity.Teacherinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Teacherinfo> findByExample(Teacherinfo instance) {
		log.debug("finding Teacherinfo instance by example");
		try {
			List<Teacherinfo> results = (List<Teacherinfo>) getCurrentSession()
					.createCriteria("cn.edu.hib.entity.Teacherinfo")
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
		log.error("finding Teacherinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Teacherinfo as model where model."
					+ propertyName + " = '" + value + "'";
			Query queryObject = getCurrentSession().createQuery(queryString);
			// queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Teacherinfo> findByTname(Object tname) {
		return findByProperty(TNAME, tname);
	}

	public List<Teacherinfo> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<Teacherinfo> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<Teacherinfo> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<Teacherinfo> findByMail(Object mail) {
		return findByProperty(MAIL, mail);
	}

	public List<Teacherinfo> findByTunit(Object tunit) {
		return findByProperty(TUNIT, tunit);
	}

	public List<Teacherinfo> findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List<Teacherinfo> findByEducation(Object education) {
		return findByProperty(EDUCATION, education);
	}

	public List<Teacherinfo> findByDegree(Object degree) {
		return findByProperty(DEGREE, degree);
	}

	public List<Teacherinfo> findByRank(Object rank) {
		return findByProperty(RANK, rank);
	}

	public List<Teacherinfo> findByGraduateuniversity(Object graduateuniversity) {
		return findByProperty(GRADUATEUNIVERSITY, graduateuniversity);
	}

	public List<Teacherinfo> findByLoginstatus(Object loginstatus) {
		return findByProperty(LOGINSTATUS, loginstatus);
	}

	public List<Teacherinfo> findByNote(Object note) {
		return findByProperty(NOTE, note);
	}

	public List findAll() {
		log.debug("finding all Teacherinfo instances");
		try {
			String queryString = "from Teacherinfo";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Teacherinfo merge(Teacherinfo detachedInstance) {
		log.debug("merging Teacherinfo instance");
		try {
			Teacherinfo result = (Teacherinfo) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Teacherinfo instance) {
		log.debug("attaching dirty Teacherinfo instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Teacherinfo instance) {
		log.debug("attaching clean Teacherinfo instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TeacherinfoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TeacherinfoDAO) ctx.getBean("TeacherinfoDAO");
	}
}