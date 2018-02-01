package com.model.newdao;
// default package

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newentity.Homeslides;
import com.newentity.NewInformation;

/**
 	* A data access object (DAO) providing persistence and search support for NewInformation entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .NewInformation
  * @author MyEclipse Persistence Tools 
 */
public class NewInformationDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(NewInformationDAO.class);
		//property constants
	public static final String INFORMATIONTITLE = "informationtitle";
	public static final String INFORMATIONCONTENT = "informationcontent";
	public static final String PUBLISHUSERID = "publishuserid";
	public static final String ATTCHMENTSPATH = "attchmentspath";
	public static final String TYPE = "type";
	public static final String HITS = "hits";
	public static final String TYPENAME = "typename";



	protected void initDao() {
		//do nothing
	}
    
    public void save(NewInformation transientInstance) {
        log.debug("saving NewInformation instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(NewInformation persistentInstance) {
        log.debug("deleting NewInformation instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public NewInformation findById( java.lang.Integer id) {
        log.debug("getting NewInformation instance with id: " + id);
        try {
            NewInformation instance = (NewInformation) getHibernateTemplate()
                    .get("com.newentity.NewInformation", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<NewInformation> findByExample(NewInformation instance) {
        log.debug("finding NewInformation instance by example");
        try {
            List<NewInformation> results = (List<NewInformation>) getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding NewInformation instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from NewInformation as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<NewInformation> findByInformationtitle(Object informationtitle
	) {
		return findByProperty(INFORMATIONTITLE, informationtitle
		);
	}
	
	public List<NewInformation> findByInformationcontent(Object informationcontent
	) {
		return findByProperty(INFORMATIONCONTENT, informationcontent
		);
	}
	
	public List<NewInformation> findByPublishuserid(Object publishuserid
	) {
		return findByProperty(PUBLISHUSERID, publishuserid
		);
	}
	
	public List<NewInformation> findByAttchmentspath(Object attchmentspath
	) {
		return findByProperty(ATTCHMENTSPATH, attchmentspath
		);
	}
	
	public List<NewInformation> findByType(Object type
	) {
		return findByProperty(TYPE, type
		);
	}
	
	public List<NewInformation> findByHits(Object hits
	) {
		return findByProperty(HITS, hits
		);
	}
	

	public List findAll() {
		log.debug("finding all NewInformation instances");
		try {
			String queryString = "from NewInformation";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public NewInformation merge(NewInformation detachedInstance) {
        log.debug("merging NewInformation instance");
        try {
            NewInformation result = (NewInformation) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(NewInformation instance) {
        log.debug("attaching dirty NewInformation instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(NewInformation instance) {
        log.debug("attaching clean NewInformation instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public List<NewInformation> getInfoListByType(final Integer typeid){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session){
			String queryString = "from NewInformation newinfo where newinfo.type = " + typeid;
			Query query1 = session.createQuery(queryString);
			List<NewInformation> result = (List<NewInformation>)(query1.list());
			return result;
			}
		});
	}
    
    @SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public List<NewInformation> getInfoListByTypename(final String typename){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session){
			String queryString = "from NewInformation newinfo where newinfo.typename = '" + typename + "'";
			Query query1 = session.createQuery(queryString);
			List<NewInformation> result = (List<NewInformation>)(query1.list());
			return result;
			}
		});
	}
    
    @SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public List<NewInformation> getInfoListByType(final Integer typeid,final Integer pageIndex,final Integer pageSize){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session){
			String queryString = "from NewInformation newinfo where newinfo.type = " + typeid;
			Query query1 = session.createQuery(queryString);
			Integer totalPage =  query1.list().size();
			List<NewInformation> result = (List<NewInformation>)(query1.setFirstResult(pageIndex).setMaxResults(pageSize).list());
			return result;
			}
		});
	}
    
    @SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public List<NewInformation> getInfoListByTypename(final String typename,final Integer pageIndex,final Integer pageSize){
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session){
			String queryString = "from NewInformation newinfo where newinfo.typename = '" + typename + "'";
			Query query1 = session.createQuery(queryString);
			Integer totalPage =  query1.list().size();
			List<NewInformation> result = (List<NewInformation>)(query1.setFirstResult(pageIndex).setMaxResults(pageSize).list());
			return result;
			}
		});
	}
    
    public int getInfoCountByType(Integer typeid) {
		log.debug("finding all NewInformation instances");
		try {
			String queryString = "from NewInformation where type = " + typeid;
			return getHibernateTemplate().find(queryString).size();
		} catch (RuntimeException re) {
			log.error("getInfoCountByType failed", re);
			throw re;
		}
	}
    
    public int getInfoCountByTypename(String typename) {
		log.debug("finding all NewInformation instances");
		try {
			String queryString = "from NewInformation where typename = '" + typename + "'";
			return getHibernateTemplate().find(queryString).size();
		} catch (RuntimeException re) {
			log.error("getInfoCountByType failed", re);
			throw re;
		}
	}

	public static NewInformationDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (NewInformationDAO) ctx.getBean("NewInformationDAO");
	}
}