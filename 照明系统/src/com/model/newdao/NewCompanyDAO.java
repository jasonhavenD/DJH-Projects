package com.model.newdao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newentity.NewCompany;

/**
 * A data access object (DAO) providing persistence and search support for
 * Company entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.newentity.NewCompany
 * @author MyEclipse Persistence Tools
 */
public class NewCompanyDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(NewCompanyDAO.class);
	// property constants
	public static final String MONEY = "money";
	public static final String FROZENMONEY = "frozenmoney";
	public static final String PAYPASSWORD = "paypassword";
	public static final String COMPANYNAME = "companyname";
	public static final String MANAGERNAME = "managername";
	public static final String MANAGERPHONE = "managerphone";
	public static final String IDCARDPICTURE = "idcardpicture";
	public static final String COMPANYLICENSEPICTURE = "companylicensepicture";
	public static final String COMPANYPICTURE = "companypicture";
	public static final String LONGITUDE = "longitude";
	public static final String LATITUDE = "latitude";
	public static final String PROVINCE = "province";
	public static final String CITY = "city";
	public static final String DISTRICT = "district";
	public static final String DETAILADDRESS = "detailaddress";
	public static final String EMAIL = "email";
	public static final String FIXPHONE = "fixphone";
	public static final String ZIPCODE = "zipcode";
	public static final String STATE = "state";

	protected void initDao() {
		// do nothing
	}

	public void save(NewCompany transientInstance) {
		log.debug("saving Company instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NewCompany persistentInstance) {
		log.debug("deleting Company instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NewCompany findById(java.lang.Integer id) {
		log.debug("getting Company instance with id: " + id);
		try {
			NewCompany instance = (NewCompany) getHibernateTemplate().get("com.newentity.Company", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<NewCompany> findByExample(NewCompany instance) {
		log.debug("finding Company instance by example");
		try {
			List<NewCompany> results = (List<NewCompany>) getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Company instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Company as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<NewCompany> findByMoney(Object money) {
		return findByProperty(MONEY, money);
	}

	public List<NewCompany> findByFrozenmoney(Object frozenmoney) {
		return findByProperty(FROZENMONEY, frozenmoney);
	}

	public List<NewCompany> findByPaypassword(Object paypassword) {
		return findByProperty(PAYPASSWORD, paypassword);
	}

	public List<NewCompany> findByCompanyname(Object companyname) {
		return findByProperty(COMPANYNAME, companyname);
	}

	public List<NewCompany> findByManagername(Object managername) {
		return findByProperty(MANAGERNAME, managername);
	}

	public List<NewCompany> findByManagerphone(Object managerphone) {
		return findByProperty(MANAGERPHONE, managerphone);
	}

	public List<NewCompany> findByIdcardpicture(Object idcardpicture) {
		return findByProperty(IDCARDPICTURE, idcardpicture);
	}

	public List<NewCompany> findByCompanylicensepicture(Object companylicensepicture) {
		return findByProperty(COMPANYLICENSEPICTURE, companylicensepicture);
	}

	public List<NewCompany> findByCompanypicture(Object companypicture) {
		return findByProperty(COMPANYPICTURE, companypicture);
	}

	public List<NewCompany> findByLongitude(Object longitude) {
		return findByProperty(LONGITUDE, longitude);
	}

	public List<NewCompany> findByLatitude(Object latitude) {
		return findByProperty(LATITUDE, latitude);
	}

	public List<NewCompany> findByProvince(Object province) {
		return findByProperty(PROVINCE, province);
	}

	public List<NewCompany> findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	public List<NewCompany> findByDistrict(Object district) {
		return findByProperty(DISTRICT, district);
	}

	public List<NewCompany> findByDetailaddress(Object detailaddress) {
		return findByProperty(DETAILADDRESS, detailaddress);
	}

	public List<NewCompany> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<NewCompany> findByFixphone(Object fixphone) {
		return findByProperty(FIXPHONE, fixphone);
	}

	public List<NewCompany> findByZipcode(Object zipcode) {
		return findByProperty(ZIPCODE, zipcode);
	}

	public List<NewCompany> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all Company instances");
		try {
			String queryString = "from Company";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public NewCompany merge(NewCompany detachedInstance) {
		log.debug("merging Company instance");
		try {
			NewCompany result = (NewCompany) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NewCompany instance) {
		log.debug("attaching dirty Company instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewCompany instance) {
		log.debug("attaching clean Company instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NewCompanyDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NewCompanyDAO) ctx.getBean("CompanyDAO");
	}
}