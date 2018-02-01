package com.model.newdao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.entity.Address;
import com.newentity.NewAddress;

/**
 * A data access object (DAO) providing persistence and search support for
 * Address entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.newentity.NewAddress
 * @author MyEclipse Persistence Tools
 */
public class NewAddressDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(NewAddressDAO.class);
	// property constants
	public static final String ISDEFAULT = "isdefault";
	public static final String CONSIGNEENAME = "consigneename";
	public static final String CONSIGNEEADDRESS = "consigneeaddress";
	public static final String CONSIGNEEPHONE = "consigneephone";
	public static final String ZIPCODE = "zipcode";

	protected void initDao() {
		// do nothing
	}
    
	//根据用户id获取配送地址
	@SuppressWarnings("unchecked")
	public List<NewAddress> getAddressByUserId(final Integer userinfoid){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public List<NewAddress> doInHibernate(Session session){
				String queryString = "from NewAddress add where add.company.companyid=" + userinfoid;
				List <NewAddress> result = session.createQuery(queryString).list();
				return result;
			}
		});
	}
	
	public void save(NewAddress transientInstance) {
		log.debug("saving Address instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NewAddress persistentInstance) {
		log.debug("deleting Address instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NewAddress findById(java.lang.Integer id) {
		log.debug("getting Address instance with id: " + id);
		try {
			NewAddress instance = (NewAddress) getHibernateTemplate().get("com.newentity.Address", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<NewAddress> findByExample(NewAddress instance) {
		log.debug("finding Address instance by example");
		try {
			List<NewAddress> results = (List<NewAddress>) getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Address instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Address as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<NewAddress> findByIsdefault(Object isdefault) {
		return findByProperty(ISDEFAULT, isdefault);
	}

	public List<NewAddress> findByConsigneename(Object consigneename) {
		return findByProperty(CONSIGNEENAME, consigneename);
	}

	public List<NewAddress> findByConsigneeaddress(Object consigneeaddress) {
		return findByProperty(CONSIGNEEADDRESS, consigneeaddress);
	}

	public List<NewAddress> findByConsigneephone(Object consigneephone) {
		return findByProperty(CONSIGNEEPHONE, consigneephone);
	}

	public List<NewAddress> findByZipcode(Object zipcode) {
		return findByProperty(ZIPCODE, zipcode);
	}

	public List findAll() {
		log.debug("finding all Address instances");
		try {
			String queryString = "from Address";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public NewAddress merge(NewAddress detachedInstance) {
		log.debug("merging Address instance");
		try {
			NewAddress result = (NewAddress) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NewAddress instance) {
		log.debug("attaching dirty Address instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewAddress instance) {
		log.debug("attaching clean Address instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NewAddressDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NewAddressDAO) ctx.getBean("AddressDAO");
	}
}