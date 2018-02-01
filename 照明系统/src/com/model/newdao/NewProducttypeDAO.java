package com.model.newdao;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.entity.Producttype;
import com.newentity.NewProducttype;

/**
 * A data access object (DAO) providing persistence and search support for
 * Producttype entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.newentity.NewProducttype
 * @author MyEclipse Persistence Tools
 */

@Entity
public class NewProducttypeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(NewProducttypeDAO.class);
	// property constants
	public static final String PRODUCTTYPENAME = "producttypename";
	public static final String PARENTPRODUCTTYPEID = "parentproducttypeid";
	public static final String PRODUCTTYPEPICTUREPATH = "producttypepicturepath";

	protected void initDao() {
		// do nothing
	}
	//获取产品类别宣传图片
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> getProtypePicture() {
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String query = "select new map(producttypeid as producttypeid,producttypename as "
						+ "producttypename ,parentproducttypeid as parentproducttypeid, "
						+ "producttypepicturepath as producttypepicturepath) from NewProducttype ";
				List<Map> list = session.createQuery(query).list();
				return list;
			}
		});
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getProtypeIdsByParent(int parentProducttypeId) {
		try {
			String sProducttypeIds = "";
			String queryString = "from Producttype as model where model.parentproducttypeid =" + parentProducttypeId ;
			List<Producttype> lstProducttypes = getHibernateTemplate().find(queryString);
			Iterator<Producttype> it = lstProducttypes.iterator();
			while(it.hasNext()) {
				sProducttypeIds += it.next().getProducttypeid().intValue() + ",";
			}
			sProducttypeIds += parentProducttypeId;
			return sProducttypeIds;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
}