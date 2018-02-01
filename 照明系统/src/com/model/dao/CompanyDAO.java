package com.model.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import com.entity.Cartdetail;
import com.entity.Company;

/**
 * A data access object (DAO) providing persistence and search support for
 * Company entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.entity.Company
 * @author MyEclipse Persistence Tools
 */

@Entity
public class CompanyDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(CompanyDAO.class);
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

	public void save(Company transientInstance) throws RuntimeException{
		log.debug("saving Company instance");
			try {
				transientInstance.getCompanyid();
				Transaction tran = getSession().beginTransaction();
				getHibernateTemplate().save(transientInstance);
				tran.commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				e.printStackTrace();
			}
			log.debug("save successful");
	}
	public void delete(Company persistentInstance) {
		log.debug("deleting Company instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Company findById(java.lang.Integer id) {
		log.debug("getting Company instance with id: " + id);
		try {
			Company instance = (Company) getHibernateTemplate().get(
					"com.entity.Company", id);
			System.out.println("网络请求总是 挂起"+instance);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Company> findByExample(Company instance) {
		log.debug("finding Company instance by example");
		try {
			List<Company> results = (List<Company>) getHibernateTemplate()
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
		log.debug("finding Company instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Company as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Company> findByMoney(Object money) {
		return findByProperty(MONEY, money);
	}

	public List<Company> findByFrozenmoney(Object frozenmoney) {
		return findByProperty(FROZENMONEY, frozenmoney);
	}

	public List<Company> findByPaypassword(Object paypassword) {
		return findByProperty(PAYPASSWORD, paypassword);
	}

	public List<Company> findByCompanyname(Object companyname) {
		return findByProperty(COMPANYNAME, companyname);
	}

	public List<Company> findByManagername(Object managername) {
		return findByProperty(MANAGERNAME, managername);
	}

	public List<Company> findByManagerphone(Object managerphone) {
		return findByProperty(MANAGERPHONE, managerphone);
	}

	public List<Company> findByIdcardpicture(Object idcardpicture) {
		return findByProperty(IDCARDPICTURE, idcardpicture);
	}

	public List<Company> findByCompanylicensepicture(
			Object companylicensepicture) {
		return findByProperty(COMPANYLICENSEPICTURE, companylicensepicture);
	}

	public List<Company> findByCompanypicture(Object companypicture) {
		return findByProperty(COMPANYPICTURE, companypicture);
	}

	public List<Company> findByLongitude(Object longitude) {
		return findByProperty(LONGITUDE, longitude);
	}

	public List<Company> findByLatitude(Object latitude) {
		return findByProperty(LATITUDE, latitude);
	}

	public List<Company> findByProvince(Object province) {
		return findByProperty(PROVINCE, province);
	}

	public List<Company> findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	public List<Company> findByDistrict(Object district) {
		return findByProperty(DISTRICT, district);
	}

	public List<Company> findByDetailaddress(Object detailaddress) {
		return findByProperty(DETAILADDRESS, detailaddress);
	}

	public List<Company> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<Company> findByFixphone(Object fixphone) {
		return findByProperty(FIXPHONE, fixphone);
	}

	public List<Company> findByZipcode(Object zipcode) {
		return findByProperty(ZIPCODE, zipcode);
	}
	public List findByCId(final int id){
		return getHibernateTemplate().executeFind(new HibernateCallback(){
			public List doInHibernate(Session session)
					throws HibernateException, SQLException {
						String hql = "select new list(c.companyname,c.managername,c.managerphone,c.province,c.city,c.district,c.detailaddress,c.email,c.fixphone,c.zipcode,c.paypassword) from Company c where c.companyid = "+id+"";
						Query query = session.createQuery(hql);
		                return query.list();  
			}
		});
	}
	
	
	/**
	 * 查找公司状态
	 * @param state
	 * @return
	 */
	public List findByState(final Object state) {
		return getHibernateTemplate().executeFind(new HibernateCallback(){
			public List<Map> doInHibernate(Session session)
					throws HibernateException, SQLException {
						String hql = "select new list(c.companyid,c.companyname,c.managername,c.managerphone,c.province,c.city,c.district,c.detailaddress,c.email,c.fixphone,c.birthday,c.zipcode,c.idcardpicture,c.companylicensepicture,c.companypicture) from Company c,Userinfo u where c.state="
					+state+" and c.companyid = u.userinfoid and u.membertype!=2";
						Query query = session.createQuery(hql);
		                return query.list();  
			}
		});
	}
	public List findByStateProvince(final Integer state,final String province){
		return getHibernateTemplate().executeFind(new HibernateCallback(){
			public List<Map> doInHibernate(Session session)
					throws HibernateException, SQLException {
					String hql = "select new list(c.companyid,c.companyname,c.managername,c.managerphone,c.province,c.city,c.district,c.detailaddress,c.email,c.fixphone,c.birthday,c.zipcode,c.idcardpicture,c.companylicensepicture,c.companypicture) from Company c,Userinfo u where c.state="+state+" and c.companyid = u.userinfoid and u.membertype!=2 and c.province = '"+province+"' ";
					Query query = session.createQuery(hql);
					return query.list();  
			}
		});
	}
	/**
	 * 平台查看物流中心
	 * @author wsp
	 * @param membertype=2
	 * @return
	 */
	public List checkDelivery() {
		return getHibernateTemplate().executeFind(new HibernateCallback(){
			public List<Map> doInHibernate(Session session)
					throws HibernateException, SQLException {
					String hql = "select new list(c.companyid,c.companyname,c.managername,c.managerphone,c.province,c.detailaddress) from Company c, Userinfo u where c.companyid = u.userinfoid and u.membertype =2";
					Query query = session.createQuery(hql);
			        return query.list();  
			}
		});
	}
	/**
	 * 编辑物流中心
	 */
	public void updateDelivery(Integer companyid) throws RuntimeException{
		/*String hql = "update Company set"*/
	}
	/**
	 * 删除物流中心
	 */
	public Object deleteByDelivery(final Integer cid){
		System.out.println(cid);
		
		
		return getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "delete from Company c where c.companyid=" + cid;
				session.createQuery(hql).executeUpdate();
				return null;
			}
			
		});
	}
	/**
	 * 无用
	 * @param state
	 * @return
	 */
	public List findByStates(Integer state){
		String hql = "select c.companyid,c.companyname,c.managerphone from Company c where c.state=:state";
		return getHibernateTemplate().find(hql);
	}
	/**
	 * 更新经销商的状态
	 */
	@SuppressWarnings("unchecked")
	public Object updateState(final Integer companyid, final Integer state) throws RuntimeException{
		return getHibernateTemplate().execute(new HibernateCallback(){
			public List<Map> doInHibernate(Session session)throws HibernateException, SQLException {
				String hql = null;
				String hqlstr = null;
				if(state == 6){
					hqlstr = "update Userinfo set membertype = 3 where userinfoid = " + companyid;
				}
				hql = "update Company set state = "+ state +" where companyid = " + companyid;
			if(hqlstr != null){
				session.createQuery(hqlstr).executeUpdate();
			}
			session.createQuery(hql).executeUpdate();
	        return null;  
			}
		});
	}
	//物流中心查询state>=4的经销商@author:wsp
	
	public List findYesCompany(final String province){
		return getHibernateTemplate().executeFind(new HibernateCallback(){
			public List<Map> doInHibernate(Session session)throws HibernateException, SQLException {
			String hql = "select new list(c.companyid,c.companyname,c.managername,c.managerphone,c.province,c.city,c.district,c.detailaddress,c.email,c.fixphone,c.birthday,c.zipcode,c.idcardpicture,c.companylicensepicture,c.companypicture) from Company c,Userinfo u where c.state >= 4 and c.companyid = u.userinfoid and u.membertype!=2 and c.province = '"+province+"' ";
			Query query = session.createQuery(hql);
	        return query.list();  
			}
		});
	}
	
	public List<Map> findAll() {
		log.debug("finding all Company instances");
		try {
			String queryString = "from Company";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public Object updateIdcardpicture(final String pictrue,final int id){
		return getHibernateTemplate().execute(new HibernateCallback(){
			public List<Map> doInHibernate(Session session)throws HibernateException, SQLException {
			String hql = "update Company c set c.idcardpicture = '"+pictrue+"' where c.companyid="+id;
			session.createQuery(hql).executeUpdate();
	        return null;  
			}
		});
	}
	public Object updateCompanypicture(final String pictrue,final int id){
		return getHibernateTemplate().execute(new HibernateCallback(){
			public List<Map> doInHibernate(Session session)throws HibernateException, SQLException {
			String hql = "update Company c set c.companypicture = '"+pictrue+"' where c.companyid="+id;
			session.createQuery(hql).executeUpdate();
	        return null;   
			}
		});
	}
	
	public Object updateCompanylicensepicture(final String pictrue,final int id){
		return getHibernateTemplate().execute(new HibernateCallback(){
			public List<Map> doInHibernate(Session session)throws HibernateException, SQLException {
			String hql = "update Company c set c.companylicensepicture = '"+pictrue+"' where c.companyid="+id;
			session.createQuery(hql).executeUpdate();
	        return null;    
			}
		});
	}
	/**
	 * 该经销商是否存在
	 * @author wsp
	 */
	public List isExist(final Integer id){
		return getHibernateTemplate().executeFind(new HibernateCallback(){
			public List<Map> doInHibernate(Session session)throws HibernateException, SQLException {
			String hql = "select new list(c.state) from Company c where c.companyid = '"+id+"' ";
			Query query = session.createQuery(hql);
	        return query.list();  
			}
		});
	}
	
	/**
	 * 获得地图信息
	 * @param province
	 * @return
	 */
	public List<Map> getMap(final String province){
		return getHibernateTemplate().executeFind(new HibernateCallback(){
			public List<Map> doInHibernate(Session session)throws HibernateException, SQLException {
			String hql = "select new map(c.companyname as companyname,c.longitude as longitude,c.latitude as latitude,c.state as state) from Company c";
			/*Transaction tran = getSession().beginTransaction();
			List list = null;*/
			if(province == null || province.equals("")){
				System.out.println("平台1");
				//list = getSession().createQuery(hql).list();
				System.out.println("平台2");
			}else{
				hql = hql+" where c.province = '"+province+"'";
				//list = getSession().createQuery(hql).list();
			}
			Query query = session.createQuery(hql);
	        return query.list();  
			}
		});
	}
	/**
     * 获取收货地址
     * @param detachedInstance
     * @return
     */
	public List getAddress(final int id){
		return getHibernateTemplate().executeFind(new HibernateCallback(){
			public List doInHibernate(Session session)throws HibernateException, SQLException {
				String hql="select new list(a.consigneename,a.consigneeaddress,a.consigneephone,a.zipcode,a.isdefault,a.addressid) from Address a where a.company.companyid =" + id ;
				//String hql="select * from Address ";
					Query query = session.createQuery(hql);
	        return query.list();  
			}
		});
		
	}
    /**
     * 更新或者插入对象
     * @param detachedInstance
     * @return
     */
	public Company merge(Company detachedInstance) {
		log.debug("merging Company instance");
		try {
			Company result = (Company) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Company instance) {
		log.debug("attaching dirty Company instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Company instance) {
		log.debug("attaching clean Company instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanyDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CompanyDAO) ctx.getBean("CompanyDAO");
	}
	/**
	 * 经销商修改信息
	 * @author wsp
	 */
	public Object update(final Company transientInstance) {
		return this.getHibernateTemplate().execute(new HibernateCallback() {  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException { 
            	session.update(transientInstance);
		        return null;
            }
        });		
	}
	/**
	 * 物流中心获取经销商
	 */
	public List findUserByProvince(final String province){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {  
            public List<Map> doInHibernate(Session session)  
                    throws HibernateException, SQLException { 
            	String hql = "select new list(L.username,c.companyid,c.companyname,c.managername,c.managerphone,c.province,c.city,c.district,c.detailaddress,c.email,c.fixphone,c.birthday,c.zipcode) from Company c,Userinfo L where c.companyid = L.userinfoid and L.membertype = 4 and c.province = '"+province+"' ";
            	Query query = session.createQuery(hql);
		        return query.list();  
            }
        });
	}
	/**
	 * 物流中心获取认证经销商
	 * @param province
	 * @return
	 */
	public List findCetiUserByProvince(final String province){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {  
            public List<Map> doInHibernate(Session session)  
                    throws HibernateException, SQLException { 
				String hql = "select new list(L.username,c.companyid,c.companyname,c.managername,c.managerphone,c.province,c.city,c.district,c.detailaddress,c.email,c.fixphone,c.birthday,c.zipcode,c.idcardpicture,c.companylicensepicture,c.companypicture) from Company c,Userinfo L where c.companyid = L.userinfoid and L.membertype = 3 and c.province = '"+province+"' ";
				Query query = session.createQuery(hql);	
		        return query.list();  
            }
		});
	}
	//
	//获取普通经销商流水信息
	public List<Map> GetNormalManagerWaterInfo(){
		List<Map> list =new ArrayList<Map>();
		String hql="select new map(L.state,L.username) from Userinfo L";
		Session sess=getSession();
		sess.beginTransaction();
		list=sess.createQuery(hql).list();
		sess.getTransaction().commit();
		return list;	
	}
	//获取认证经销商流水信息
	public List<Map> GetCertificationManagerWaterInfo(){
		List<Map> list=new ArrayList<Map>();
		String hql="";
		Session sess =getSession();
		sess.beginTransaction();
		list=sess.createQuery(hql).list();
		sess.getTransaction().commit();
		return list;
	}
	
}