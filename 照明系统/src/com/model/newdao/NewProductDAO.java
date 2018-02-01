package com.model.newdao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.Query;
import org.apache.commons.collections.map.HashedMap;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newentity.NewProduct;
import com.publicentity.Page;

/**
 * A data access object (DAO) providing persistence and search support for
 * Product entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.newentity.NewProduct
 * @author MyEclipse Persistence Tools
 */
// @Entity
// @Table(name = "product", schema = "dbo", catalog = "newlightsystem")
public class NewProductDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(NewProductDAO.class);
	// property constants
	public static final String PRODUCTNAME = "productname";
	public static final String PRODUCTPICTURE = "productpicture";
	public static final String PRODUCTDISCRIBE = "productdiscribe";
	public static final String PRICE = "price";
	public static final String CERTIFIEDPRICE = "certifiedprice";
	public static final String LOGISTICSPRICE = "logisticsprice";
	public static final String SENDPOINTS = "sendpoints";
	public static final String INVENTORYQUANTITY = "inventoryquantity";
	public static final String ISSALE = "issale";
	public static final String ISSNAPUP = "issnapup";
	public static final String ISGROUPON = "isgroupon";
	public static final String ISCROWDFUNDING = "iscrowdfunding";
	public static final String ISHOT = "ishot";
	public static final String ISNEW = "isnew";
	public static final String ISRECOMMEND = "isrecommend";
	public static final String ISPROMOTION = "ispromotion";
	public static final String SNAPUPPRICE = "snapupprice";
	public static final String SNAPUPCERTIFIEDPRICE = "snapupcertifiedprice";
	public static final String SNAPUPLOGISTICSPRICE = "snapuplogisticsprice";
	public static final String SNAPUPQUANTITY = "snapupquantity";
	public static final String GROUPONSTARTQUANTITY = "grouponstartquantity";
	public static final String GROUPONPRICE = "grouponprice";
	public static final String GROUPONCERTIFIEDPRICE = "grouponcertifiedprice";
	public static final String GROUPONLOGISTICSPRICE = "grouponlogisticsprice";
	public static final String GROUPONQUANTITY = "grouponquantity";
	public static final String CROWFUNDINGSTARTQUANTITY = "crowfundingstartquantity";
	public static final String CROWFUNDINGDEPOSITRATE = "crowfundingdepositrate";
	public static final String CROWFUNDINGPRICE = "crowfundingprice";
	public static final String CROWFUNDINGCERTIFIEDPRICE = "crowfundingcertifiedprice";
	public static final String CROWFUNDINGLOGISTICSPRICE = "crowfundinglogisticsprice";
	public static final String CROWFUNDINGQUANTITY = "crowfundingquantity";

	protected void initDao() {
		// do nothing
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	// 名字 描述 价格 图片 结束时间
	public List<Map> getActiveProduct(final String param1, final String param2) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public List<Map> doInHibernate(Session session) {
				String queryString = "select new map(p.productid as productid,p.productname as productname,"
						+ "p.producttype.producttypeid as producttypeid,p.productpicture as productpicture,"
						+ param1
						+ "p.price as price,p.certifiedprice as certifiedprice,p.logisticsprice as logisticsprice)"
						+ " from NewProduct p where  " + param2;
				List<Map> result = session.createQuery(queryString).list();
				return result;
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> getActiveProduct(final String param1, final String param2,
			final Integer pageIndex, final Integer pageSize) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public List<Map> doInHibernate(Session session) {
				String queryString = "select new map(p.productid as productid,p.productname as productname,"
						+ "p.producttype.producttypeid as producttypeid,p.productpicture as productpicture,"
						+ param1
						+ "p.price as price,p.certifiedprice as certifiedprice,p.logisticsprice as logisticsprice)"
						+ " from NewProduct p where  " + param2;
				Query query = session.createQuery(queryString);
				Integer totalPage = query.list().size();
				query = session.createQuery(queryString)
						.setFirstResult(pageIndex).setMaxResults(pageSize);
				List<Map> result = query.list();
				Map map = new HashMap<String, Object>();
				map.put("totalPage", totalPage);
				result.add(map);
				return result;
			}
		});
	}

	// 图片 名称 描述 价格 热销产品
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> getActiveProduct(final String param) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String queryString = "select new map(p.productid as productid,p.productname as productname,"
						+ "p.producttype.producttypeid as producttypeid,p.productpicture as productpicture,"
						+ "p.price as price,p.certifiedprice as certifiedprice,p.logisticsprice as logisticsprice)"
						+ " from NewProduct p where  " + param;
				List<Map> result = session.createQuery(queryString).list();
				return result;
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Map> getProListByType(final Integer typeid,
			final Integer pageIndex, final Integer pageSize) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				String queryString = "select new map(p.productid as productid,p.productname "
						+ "as productname,p.productpicture as productpicture,p.productdiscribe "
						+ "as productdiscribe,p.price as price,p.certifiedprice as certifiedprice,"
						+ "p.logisticsprice as logisticsprice,p.sendpoints as sendpoints,p.issale "
						+ "as issale,p.issnapup as issnapup,p.isgroupon as isgroupon,p.iscrowdfunding "
						+ "as iscrowdfunding ,p.ishot as ishot,p.isnew as isnew ,p.isrecommend as "
						+ "isrecommend,p.snapupstarttime as snapupstarttime,p.snapupendtime as "
						+ "snapupendtime,p.snapupprice as snapupprice,p.snapupcertifiedprice as "
						+ "snapupcertifiedprice,p.snapuplogisticsprice as snapuplogisticsprice,"
						+ "p.snapupquantity as snapupquantity,p.grouponstartquantity as grouponstartquantity"
						+ ",p.grouponstarttime as grouponstarttime,p.grouponendtime as grouponendtime,"
						+ "p.grouponprice as grouponprice,p.grouponcertifiedprice as grouponcertifiedprice,"
						+ "p.grouponlogisticsprice as grouponlogisticsprice,p.grouponquantity as grouponquantity,"
						+ "p.crowfundingstartquantity as crowfundingstartquantity ,p.crowfundingdepositrate "
						+ "as crowfundingdepositrate,p.crowfundingstarttime as crowfundingstarttime,p.crowfundingendtime "
						+ "as crowfundingendtime,p.crowfundingprice as crowfundingprice,p.crowfundingcertifiedprice "
						+ "as crowfundingcertifiedprice,p.crowfundinglogisticsprice as crowfundinglogisticsprice,"
						+ "p.crowfundingquantity as crowfundingquantity,p.inventoryquantity as inventoryquantity"
						+ ") from Product p,Producttype pt where p.producttype.producttypeid = pt.producttypeid and pt.producttypeid = "
						+ typeid;
				// Query query =
				// session.createQuery(queryString).setParameter("typeid",
				// typeid);Producttype pt
				Query query1 = session.createQuery(queryString);
				Integer totalPage = query1.list().size();
				List<Map> result = query1.setFirstResult(pageIndex)
						.setMaxResults(pageSize).list();

				Map map = new HashMap<String, Object>();
				map.put("totalPage", totalPage);
				result.add(map);
				return result;
			}
		});
	}

	public void save(NewProduct transientInstance) {
		log.debug("saving Product instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NewProduct persistentInstance) {
		log.debug("deleting Product instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NewProduct findById(java.lang.Integer id) {
		log.debug("getting Product instance with id: " + id);
		try {
			NewProduct instance = (NewProduct) getHibernateTemplate().get(
					"com.newentity.Product", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<NewProduct> findByExample(NewProduct instance) {
		log.debug("finding Product instance by example");
		try {
			List<NewProduct> results = (List<NewProduct>) getHibernateTemplate()
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
		log.debug("finding Product instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Product as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<NewProduct> findByProductname(Object productname) {
		return findByProperty(PRODUCTNAME, productname);
	}

	public List<NewProduct> findByProductpicture(Object productpicture) {
		return findByProperty(PRODUCTPICTURE, productpicture);
	}

	public List<NewProduct> findByProductdiscribe(Object productdiscribe) {
		return findByProperty(PRODUCTDISCRIBE, productdiscribe);
	}

	public List<NewProduct> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List<NewProduct> findByCertifiedprice(Object certifiedprice) {
		return findByProperty(CERTIFIEDPRICE, certifiedprice);
	}

	public List<NewProduct> findByLogisticsprice(Object logisticsprice) {
		return findByProperty(LOGISTICSPRICE, logisticsprice);
	}

	public List<NewProduct> findBySendpoints(Object sendpoints) {
		return findByProperty(SENDPOINTS, sendpoints);
	}

	public List<NewProduct> findByInventoryquantity(Object inventoryquantity) {
		return findByProperty(INVENTORYQUANTITY, inventoryquantity);
	}

	public List<NewProduct> findByIssale(Object issale) {
		return findByProperty(ISSALE, issale);
	}

	public List<NewProduct> findByIssnapup(Object issnapup) {
		return findByProperty(ISSNAPUP, issnapup);
	}

	public List<NewProduct> findByIsgroupon(Object isgroupon) {
		return findByProperty(ISGROUPON, isgroupon);
	}

	public List<NewProduct> findByIscrowdfunding(Object iscrowdfunding) {
		return findByProperty(ISCROWDFUNDING, iscrowdfunding);
	}

	public List<NewProduct> findByIshot(Object ishot) {
		return findByProperty(ISHOT, ishot);
	}

	public List<NewProduct> findByIsnew(Object isnew) {
		return findByProperty(ISNEW, isnew);
	}

	public List<NewProduct> findByIsrecommend(Object isrecommend) {
		return findByProperty(ISRECOMMEND, isrecommend);
	}

	public List<NewProduct> findByIspromotion(Object ispromotion) {
		return findByProperty(ISPROMOTION, ispromotion);
	}

	public List<NewProduct> findBySnapupprice(Object snapupprice) {
		return findByProperty(SNAPUPPRICE, snapupprice);
	}

	public List<NewProduct> findBySnapupcertifiedprice(
			Object snapupcertifiedprice) {
		return findByProperty(SNAPUPCERTIFIEDPRICE, snapupcertifiedprice);
	}

	public List<NewProduct> findBySnapuplogisticsprice(
			Object snapuplogisticsprice) {
		return findByProperty(SNAPUPLOGISTICSPRICE, snapuplogisticsprice);
	}

	public List<NewProduct> findBySnapupquantity(Object snapupquantity) {
		return findByProperty(SNAPUPQUANTITY, snapupquantity);
	}

	public List<NewProduct> findByGrouponstartquantity(
			Object grouponstartquantity) {
		return findByProperty(GROUPONSTARTQUANTITY, grouponstartquantity);
	}

	public List<NewProduct> findByGrouponprice(Object grouponprice) {
		return findByProperty(GROUPONPRICE, grouponprice);
	}

	public List<NewProduct> findByGrouponcertifiedprice(
			Object grouponcertifiedprice) {
		return findByProperty(GROUPONCERTIFIEDPRICE, grouponcertifiedprice);
	}

	public List<NewProduct> findByGrouponlogisticsprice(
			Object grouponlogisticsprice) {
		return findByProperty(GROUPONLOGISTICSPRICE, grouponlogisticsprice);
	}

	public List<NewProduct> findByGrouponquantity(Object grouponquantity) {
		return findByProperty(GROUPONQUANTITY, grouponquantity);
	}

	public List<NewProduct> findByCrowfundingstartquantity(
			Object crowfundingstartquantity) {
		return findByProperty(CROWFUNDINGSTARTQUANTITY,
				crowfundingstartquantity);
	}

	public List<NewProduct> findByCrowfundingdepositrate(
			Object crowfundingdepositrate) {
		return findByProperty(CROWFUNDINGDEPOSITRATE, crowfundingdepositrate);
	}

	public List<NewProduct> findByCrowfundingprice(Object crowfundingprice) {
		return findByProperty(CROWFUNDINGPRICE, crowfundingprice);
	}

	public List<NewProduct> findByCrowfundingcertifiedprice(
			Object crowfundingcertifiedprice) {
		return findByProperty(CROWFUNDINGCERTIFIEDPRICE,
				crowfundingcertifiedprice);
	}

	public List<NewProduct> findByCrowfundinglogisticsprice(
			Object crowfundinglogisticsprice) {
		return findByProperty(CROWFUNDINGLOGISTICSPRICE,
				crowfundinglogisticsprice);
	}

	public List<NewProduct> findByCrowfundingquantity(Object crowfundingquantity) {
		return findByProperty(CROWFUNDINGQUANTITY, crowfundingquantity);
	}

	public List findAll() {
		log.debug("finding all Product instances");
		try {
			String queryString = "from Product";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public NewProduct merge(NewProduct detachedInstance) {
		log.debug("merging Product instance");
		try {
			NewProduct result = (NewProduct) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NewProduct instance) {
		log.debug("attaching dirty Product instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewProduct instance) {
		log.debug("attaching clean Product instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NewProductDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NewProductDAO) ctx.getBean("ProductDAO");
	}

	/**
	 * 猜你喜欢
	 * 
	 * @param producttypename
	 * @return
	 */
	public List<Map> getProductdetailByType(final String producttypename) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String queryString;
				try {
					queryString = "select new map(p.productid as productid,p.productname as productname,"
							+ "p.productpicture as productpicture,p.productdiscribe as productdiscribe,"
							+ "p.price as price) from NewProduct p,NewProducttype pt where p.producttype.producttypeid"
							+ " = pt.producttypeid and pt.producttypename=?";
					List<Map> result = session.createQuery(queryString)
							.setParameter(0, producttypename).list();
					return result;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// List <Map> result =
				// session.createQuery(queryString).setParameter(0,
				// producttypename).list();
				return null;
			}
		});
	}

	public List<Map> getProductdetailById(final Integer productid) {
		try {
			return this.getHibernateTemplate().executeFind(
					new HibernateCallback() {
						public List<Map> doInHibernate(Session session) {
							String queryString = "select new map(p.productname as productname,p.productpicture as productpicture,p.productdiscribe as productdiscribe,p.price as price,"
									+ "p.certifiedprice as certifiedprice,p.logisticsprice as logisticsprice,p.sendpoints as sendpoints,p.issale as issale,p.issnapup as issnapup,p.isgroupon as isgroupon,p.iscrowdfunding as iscrowdfunding"
									+ ",p.ishot as ishot,p.isnew as isnew ,p.isrecommend as isrecommend,p.snapupstarttime as snapupstarttime,p.snapupendtime as snapupendtime,p.snapupprice as snapupprice,p.snapupcertifiedprice as snapupcertifiedprice,"
									+ "p.snapuplogisticsprice as snapuplogisticsprice,p.snapupquantity as snapupquantity,p.grouponstartquantity as grouponstartquantity,p.grouponstarttime as grouponstarttime,p.grouponendtime as grouponendtime,"
									+ "p.grouponprice as grouponprice,p.grouponcertifiedprice as grouponcertifiedprice,p.grouponlogisticsprice as grouponlogisticsprice,p.grouponquantity as grouponquantity ,p.crowfundingstartquantity as crowfundingstartquantity ,"
									+ "p.crowfundingdepositrate as crowfundingdepositrate,p.crowfundingstarttime as crowfundingstarttime,p.crowfundingendtime as crowfundingendtime,p.crowfundingprice as crowfundingprice,p.crowfundingcertifiedprice as crowfundingcertifiedprice,"
									+ "p.crowfundinglogisticsprice as crowfundinglogisticsprice,p.crowfundingquantity as crowfundingquantity,p.inventoryquantity as inventoryquantity,pt.producttypename as producttypename,pt.producttypeid as producttypeid"
									+ ",pp.power as power,pp.lampholder as lampholder,pp.colortemp as colortemp "
									+ ",pp.voltage as voltage,pp.luminousflux as luminousflux,pp.lightefficiency as lightefficiency,pp.colorrendering as colorrendering,pp.beamangle as beamangle,pp.isemc as isemc) from Product p,Productproperty pp ,Producttype "
									+ "pt where p.productid = pp.productid and p.producttype.producttypeid"
									+ " = pt.producttypeid and p.productid = ?";
							List<Map> result = session.createQuery(queryString)
									.setParameter(0, productid).list();
							return result;
						}
					});
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}
}