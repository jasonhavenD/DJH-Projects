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

import cn.edu.hib.entity.Tpromotetrain;
import cn.edu.hib.entity.TpromotetrainId;

/**
 * A data access object (DAO) providing persistence and search support for
 * Tpromotetrain entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.hib.entity.Tpromotetrain
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TpromotetrainDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TpromotetrainDAO.class);
	// property constants
	public static final String TNAME = "tname";
	public static final String TUNIT = "tunit";
	public static final String GENDER = "gender";
	public static final String AGE = "age";
	public static final String RANK = "rank";
	public static final String EDUCATION = "education";
	public static final String DEGREE = "degree";
	public static final String PERIOD = "period";
	public static final String TRAINGRADE = "traingrade";
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

	public void save(Tpromotetrain transientInstance) {
		log.debug("saving Tpromotetrain instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Tpromotetrain persistentInstance) {
		log.debug("deleting Tpromotetrain instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tpromotetrain findById(cn.edu.hib.entity.TpromotetrainId id) {
		log.debug("getting Tpromotetrain instance with id: " + id);
		try {
			Tpromotetrain instance = (Tpromotetrain) getCurrentSession().get(
					"cn.edu.hib.entity.Tpromotetrain", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Tpromotetrain> findByExample(Tpromotetrain instance) {
		log.debug("finding Tpromotetrain instance by example");
		try {
			List<Tpromotetrain> results = (List<Tpromotetrain>) getCurrentSession()
					.createCriteria("cn.edu.hib.entity.Tpromotetrain")
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
		log.debug("finding Tpromotetrain instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Tpromotetrain as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Tpromotetrain> findByTname(Object tname) {
		return findByProperty(TNAME, tname);
	}

	public List<Tpromotetrain> findByTunit(Object tunit) {
		return findByProperty(TUNIT, tunit);
	}

	public List<Tpromotetrain> findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List<Tpromotetrain> findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List<Tpromotetrain> findByRank(Object rank) {
		return findByProperty(RANK, rank);
	}

	public List<Tpromotetrain> findByEducation(Object education) {
		return findByProperty(EDUCATION, education);
	}

	public List<Tpromotetrain> findByDegree(Object degree) {
		return findByProperty(DEGREE, degree);
	}

	public List<Tpromotetrain> findByPeriod(Object period) {
		return findByProperty(PERIOD, period);
	}

	public List<Tpromotetrain> findByTraingrade(Object traingrade) {
		return findByProperty(TRAINGRADE, traingrade);
	}

	public List<Tpromotetrain> findByCheckstatus(Object checkstatus) {
		return findByProperty(CHECKSTATUS, checkstatus);
	}

	public List<Tpromotetrain> findByNote(Object note) {
		return findByProperty(NOTE, note);
	}

	public List findAll() {
		log.debug("finding all Tpromotetrain instances");
		try {
			String queryString = "from Tpromotetrain";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Tpromotetrain merge(Tpromotetrain detachedInstance) {
		log.debug("merging Tpromotetrain instance");
		try {
			Tpromotetrain result = (Tpromotetrain) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Tpromotetrain instance) {
		log.debug("attaching dirty Tpromotetrain instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tpromotetrain instance) {
		log.debug("attaching clean Tpromotetrain instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TpromotetrainDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TpromotetrainDAO) ctx.getBean("TpromotetrainDAO");
	}
}