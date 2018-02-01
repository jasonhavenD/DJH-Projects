package com.model.dao;

import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.entity.Address;

/**
 * A data access object (DAO) providing persistence and search support for
 * Address entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.entity.Address
 * @author MyEclipse Persistence Tools
 */

@Entity
public class AddressDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(AddressDAO.class);
	// property constants
	public static final String ISDEFAULT = "isdefault";
	public static final String CONSIGNEENAME = "consigneename";
	public static final String CONSIGNEEADDRESS = "consigneeaddress";
	public static final String CONSIGNEEPHONE = "consigneephone";
	public static final String ZIPCODE = "zipcode";

	protected void initDao() {
		// do nothing
	}

	public void save(Address transientInstance) {
		log.debug("saving Address instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Address persistentInstance) {
		log.debug("deleting Address instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Address findById(java.lang.Integer id) {
		log.debug("getting Address instance with id: " + id);
		try {
			Address instance = (Address) getHibernateTemplate().get(
					"com.entity.Address", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Address> findByExample(Address instance) {
		log.debug("finding Address instance by example");
		try {
			List<Address> results = (List<Address>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Address instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Address as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Address> findByIsdefault(Object isdefault) {
		return findByProperty(ISDEFAULT, isdefault);
	}

	public List<Address> findByConsigneename(Object consigneename) {
		return findByProperty(CONSIGNEENAME, consigneename);
	}

	public List<Address> findByConsigneeaddress(Object consigneeaddress) {
		return findByProperty(CONSIGNEEADDRESS, consigneeaddress);
	}

	public List<Address> findByConsigneephone(Object consigneephone) {
		return findByProperty(CONSIGNEEPHONE, consigneephone);
	}

	public List<Address> findByZipcode(Object zipcode) {
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
	/*
	 * 设置地址信息为默认
	 */
	public void updateisdefault(int addressid,int companyid){
		int True=1;
		int False=0;
		log.debug("update Address instance");
		try{
			Transaction tran = getSession().beginTransaction();
			System.out.println("updateisdefault");
			String hql;
			
			hql="update Address a set a.isdefault ="+False+" where a.company.companyid ="+companyid;
			getSession().createQuery(hql).executeUpdate();
			getSession().flush();
			hql="update Address a set a.isdefault ="+True+" where a.addressid ="+addressid;
			getSession().createQuery(hql).executeUpdate();
			tran.commit();
			getSession().flush();
			getSession().close();
			log.debug("update successful");
			
		}
		catch(RuntimeException re){
			log.error("update failed", re);
			re.printStackTrace();
			throw re;
		}
	}
	/*
	 * 编辑地址信息 
	*/
	public void editAddress(int id,String name,String address,String phone,String zipcode){
		log.debug("editAddress Address instance");
		try{
			Transaction tran = getSession().beginTransaction();
			System.out.println("editAddress");
			String hql="update Address a set a.consigneename =:name , a.consigneeaddress =:address , a.consigneephone =:phone , a.zipcode =:zipcode where a.addressid =:id";
			Query query =  getSession().createQuery(hql);
			query.setString("name", name);
			query.setString("address", address);
			query.setString("phone", phone);
			query.setString("zipcode", zipcode);
			query.setInteger("id", id);
			query.executeUpdate();
			tran.commit();
			getSession().flush();
			getSession().close();
			log.debug("update successful");
		}
		catch(RuntimeException re){
			log.error("editAddress failed", re);
			re.printStackTrace();
			throw re;
		}
	}
	public Address merge(Address detachedInstance) {
		log.debug("merging Address instance");
		try {
			Address result = (Address) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Address instance) {
		log.debug("attaching dirty Address instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Address instance) {
		log.debug("attaching clean Address instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AddressDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AddressDAO) ctx.getBean("AddressDAO");
	}
}