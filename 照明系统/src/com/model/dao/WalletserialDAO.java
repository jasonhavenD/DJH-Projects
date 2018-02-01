package com.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.entity.Walletserial;

/**
 * A data access object (DAO) providing persistence and search support for
 * Walletserial entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.entity.Walletserial
 * @author MyEclipse Persistence Tools
 */

@Entity
public class WalletserialDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(WalletserialDAO.class);
	// property constants
	public static final String TYPE = "type";
	public static final String AMOUNT = "amount";

	protected void initDao() {
		// do nothing
	}

	public void save(Walletserial transientInstance) {
		log.debug("saving Walletserial instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Walletserial persistentInstance) {
		log.debug("deleting Walletserial instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Walletserial findById(java.lang.Integer id) {
		log.debug("getting Walletserial instance with id: " + id);
		try {
			Walletserial instance = (Walletserial) getHibernateTemplate().get(
					"com.entity.Walletserial", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Walletserial> findByExample(Walletserial instance) {
		log.debug("finding Walletserial instance by example");
		try {
			List<Walletserial> results = (List<Walletserial>) getHibernateTemplate()
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
		log.debug("finding Walletserial instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Walletserial as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Walletserial> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<Walletserial> findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List findAll() {
		log.debug("finding all Walletserial instances");
		try {
			String queryString = "from Walletserial";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	 /**
     * 获取充值流水
     * @param 
     * @return
     */
	public List getRechargeInfo(){
		int temp=1;
		String hql="select new list(serialid,updatetime,amount,orderinfo.orderid) from Walletserial where type ="+temp;
		return getHibernateTemplate().find(hql);
	}
	/**
     * 获取提现流水
     * @param 
     * @return
     */
	public List getWithdrawInfo(){
		int temp=2;
		String hql="select new list(serialid,updatetime,amount,orderinfo.orderid) from Walletserial where type ="+temp;
		return getHibernateTemplate().find(hql);
	}
	/**
     * 获取消费流水
     * @param 
     * @return
     */
	public List getConsumeInfo(){
		int temp=3;
		String hql="select new list(serialid,updatetime,amount,orderinfo.orderid) from Walletserial where type ="+temp;
		return getHibernateTemplate().find(hql);
	}
	/**
     * 获取普通会员流水
     * @param 
     * @return
     */
	public List getOrdinaryInfo(){
		/*return this.getHibernateTemplate().executeFind(new HibernateCallback() {  
            public List<Map> doInHibernate(Session session)  
                    throws HibernateException, SQLException {
            	String hql = "select new list(L.username,c.companyid,c.companyname,c.managername,c.managerphone,c.province,c.city,c.district,c.detailaddress,c.email,c.fixphone,c.birthday,c.zipcode) from Userinfo L,Company c where c.companyid = L.userinfoid and L.membertype = 4";
            	Query query = session.createQuery(hql);	
		        return query.list();  
            }
		});*/
		int temp=4;
		String hql="select new list(u.username,u.phone,w.updatetime,p.productname,o.quantity,w.amount,w.type) from Product p,Userinfo u,Walletserial w,Orderdetail o where w.company.companyid=u.userinfoid and w.orderinfo.orderid=o.orderinfo.orderid and p.productid=o.product.productid and u.membertype="+temp;
		return getHibernateTemplate().find(hql);
		/*String hql="select new list(c.companyname,c.phone,p.productname,o.quantity,of.finishidatetime,of.lastprice) from Product p,Userinfo u,Orderdetail o,Orderinfo of," +
				"Company c  where of.orderid =o.orderinfo.orderid and p.productid =o.product.productid and u.userinfoid = of.company.companyid and c.companyid= of.company.companyid and u.membertype="+temp;
		return getHibernateTemplate().find(hql);*/
	}
	/**
     * 获取认证代理商流水
     * @param 
     * @return
     */
	public List getAuthenticateInfo(){
		int temp=3;
		String hql="select new list(u.username,u.phone,w.updatetime,p.productname,o.quantity,w.amount,w.type) from Product p,Userinfo u,Walletserial w,Orderdetail o where w.company.companyid=u.userinfoid and w.orderinfo.orderid=o.orderinfo.orderid and p.productid=o.product.productid and u.membertype="+temp;
		return getHibernateTemplate().find(hql);
	}
	/**
	 * 获取个人消费流水
	 * @param detachedInstance
	 * @return
	 */
	public List getPersonConsumeInfo(int companyid){
		int temp = 1;
		String hql = "select new list(serialid,updatetime,amount,oderinfo.orderid)from Walletserial where temp = "+temp+"and companyid = "+companyid;
		return getHibernateTemplate().find(hql);
	}
	
	public Walletserial merge(Walletserial detachedInstance) {
		log.debug("merging Walletserial instance");
		try {
			Walletserial result = (Walletserial) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	/**
	 * 个人体现流水
	 * @param companyid
	 * @return
	 */
	public List getPersonRechargeInfo(int companyid) {
		// TODO Auto-generated method stub
		//int temp=1;
		//String hql="select new list(serialid,updatetime,amount,orderinfo.orderid) from Walletserial where type ="+temp;
		//return getHibernateTemplate().find(hql);
		int temp = 1;
		String hql = "select new list(serialid,updatetime,amount,orderinfo.orderid) from Walletserial where type = "+temp+"and companyid = "+companyid;
		return getHibernateTemplate().find(hql);
		
	}
	/**
	 * 充值
	 * @param rechargeamount
	 * @return
	 */
	public List RechargeIn(Integer rechargeamount) {
		try {
			// TODO Auto-generated method stub
			//充值是1
			int temp = 1;
			String hql = "update Walletserial w set w.amount=:amount where w.type =:type";
			Transaction tran = getSession().beginTransaction();
			Query query =  getSession().createQuery(hql);
			query.setFloat("amount",rechargeamount);
			query.setInteger("type", temp);
			query.executeUpdate();
			tran.commit();
			getSession().flush();
			getSession().close();
			log.debug("update successful");
		} catch (Exception e) {
			log.error("editAddress failed");
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param withdrawamount
	 * @return
	 */
	public List Withdraw(Integer withdrawamount){
		try {
			// TODO Auto-generated method stub
			//提现是2
			int temp = 2;
			String hql = "update Walletserial w set w.amount=:amount where w.type =:type";
			Transaction tran = getSession().beginTransaction();
			Query query =  getSession().createQuery(hql);
			query.setFloat("amount",withdrawamount);
			query.setInteger("type", temp);
			query.executeUpdate();
			tran.commit();
			getSession().flush();
			getSession().close();
			log.debug("update successful");
		} catch (Exception e) {
			log.error("editAddress failed");
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
	public void attachDirty(Walletserial instance) {
		log.debug("attaching dirty Walletserial instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Walletserial instance) {
		log.debug("attaching clean Walletserial instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static WalletserialDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (WalletserialDAO) ctx.getBean("WalletserialDAO");
	}
}