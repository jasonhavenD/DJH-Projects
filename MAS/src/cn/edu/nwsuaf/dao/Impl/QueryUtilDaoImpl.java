package cn.edu.nwsuaf.dao.Impl;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;

import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.util.HibernateUtil;
import cn.edu.nwsuaf.util.HqlParam;


public class QueryUtilDaoImpl {
	

	private static JSONArray jsonArray;
	private static List<Major> majorList;
	/******************************
	 * 查询方法
	 * @param hql
	 * @param param
	 * @return
	 ******************************/
	public  static List<?> executeQuery(String hql,String[] param){
		//System.out.println("HQL:"+hql);
		Session session = null;
		Transaction tx = null;
		List<?> list = null;
		try{
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			if(param != null && param.length >0){
				for(int i = 0; i < param.length; i++){
					query.setString(i, param[i]);
				}
			}
			list = query.list();
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
		} finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	
	public static List<?> executeQuery(String hql,String[] param,Map<?, ?> mapParam){
		Session session = null;
		Transaction tx = null;
		List<?> list = null;
		try{
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			if(param != null && param.length > 0){
				for(int i=0; i<param.length; i++){
					query.setString(i, param[i]);
				}
			}
			if(mapParam != null){
				query.setProperties(mapParam);
			}
			list = query.list();
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
		} finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	//根据学院Id查找专业，用于下拉列表
	@SuppressWarnings("unchecked")
	public static JSONArray findMajorByDno(String dno){
		Session session=null;
		Transaction ts=null;
		 try {
			session=HibernateUtil.getCurrentSession();
			ts=session.beginTransaction();String hql="from Major as m where m.department.dno=?";
			String []param={dno};
			Query query=session.createQuery(hql);
			if(param!=null&param.length>0){
				for(int i=0;i<param.length;i++){
					query.setString(i, param[i]);
				}
			}

			majorList=query.list();
			JsonConfig config=new JsonConfig();
			config.setExcludes(new String[]{});//过滤不需要转换的属性
			jsonArray=JSONArray.fromObject(majorList, config);
			ts.commit();
		} catch (Exception e) {
			if(ts!=null){
				ts.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		
		return jsonArray;
	}
	/******************************
	 * 分页查询 
	 * @param hql
	 * @param param
	 * @param page
	 * @param rows
	 * @return
	 ******************************/
	public static List<?> executeQueryByPage(String hql,String[] param,int page,int rows){
		Session session = null;
		List<?> list = null;
		Transaction tx=null;
		try{
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			System.out.println("hql: "+hql);
			if(param != null && param.length > 0){
				for(int i=0; i<param.length; i++){
					query.setString(i, param[i]);
				}
			}
			query.setFirstResult((page-1)*rows).setMaxResults(rows);
			list = query.list();
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
				System.out.println("shieuhuigun");
			}
			throw new RuntimeException(e.getMessage());
		} finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return list;
	}

	public static List<?> executeQueryByPage(String hql,String[] param,Map<?, ?> mapParam,int page,int rows){
		Session session = null;
		Transaction tx = null;
		List<?> list = null;
		try{
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			
			if(param != null && param.length > 0){
				for(int i=0; i<param.length; i++){
					query.setString(i, param[i]);
				}
			}
			if(mapParam != null){
				query.setProperties(mapParam);
			}
			query.setFirstResult((page-1)*rows).setMaxResults(rows);
			list = query.list();
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
		} finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	//依据指定字段模糊查询
	public static List<?> findByType(String tableNames,String  types,String value,int page ,int rows) {
		Session session = null;
		List<?> list = null;
		try{
			session = HibernateUtil.getCurrentSession();
			String hql="FROM "+tableNames+" WHERE "+types+" like '%"+value+"%'";
			System.out.println("hql:"+hql+"\n"+"sessipn"+session.toString());
			Query query = session.createQuery(hql);
			System.out.println("dao语句"+query.getQueryString());
			query.setFirstResult((page-1)*rows).setMaxResults(rows);
			list = query.list();
			System.out.println("查找:"+list.size());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	
	/**
	 * 更新方法
	 * @param hql
	 * @param param
	 */
	public static void executeUpdate(String hql,String[] param){
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			if(param != null && param.length > 0){
				for(int i=0; i<param.length; i++){
					query.setString(i, param[i]);
				}
			}
			query.executeUpdate();
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
		} finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
	}
	
	public static void executeUpdate(String hql,String[] param,Map<?, ?> mapParam){
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			if(param != null && param.length > 0){
				for(int i=0; i<param.length; i++){
					query.setString(i, param[i]);
				}
			}
			if(mapParam != null){
				query.setProperties(mapParam);
			}
			query.executeUpdate();
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
		} finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
	}
	
	
	/******************************
	 * 批量插入方法（对象集合）
	 * @param objList
	 ******************************/
	public static void batchInsert(List<Object> objList){
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			for(Object obj : objList){
				session.save(obj);
			}
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
		} finally {
			if(session != null && session.isOpen()){
				session.close();
			}
		}
	}
	
	
	/******************************
	 * 批量更新方法
	 * @param hqlParamList
	 ******************************/
	public static void batchUpdate(List<HqlParam> hqlParamList){
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			for(HqlParam hqlParam : hqlParamList){
				Query query = session.createQuery(hqlParam.getHql());
				String[] param = hqlParam.getParam();
				if(param != null && param.length > 0){
					for(int i=0; i<param.length; i++){
						query.setString(i, param[i]);
					}
				}
				Map<Object,Object> mapParam = hqlParam.getMapParam();
				if(mapParam != null && mapParam.size() > 0){
					query.setProperties(mapParam);
				}
				query.executeUpdate();
			}
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
		} finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
	}
	
	/*public static void batchUpdateResult(List<Contestscore> contestScoreList){
		Session session = null;
		Transaction tx = null;
		try{
			session =HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			if(contestScoreList != null && contestScoreList.size() > 0){
				for(Contestscore conScore : contestScoreList){
					session.merge(conScore);
				}
			}
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
		} finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
	}*/
	
	/******************************
	 * 查询方法,唯一结果
	 * @param hql
	 * @param param
	 * @return
	 ******************************/
	public static Object uniqueResult(String hql,String[] param){
		Session session = null;
		Transaction tx = null;
		Object object = null;
		try{
			session =HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			if(param != null && param.length > 0){
				for(int i=0; i<param.length; i++){
					query.setString(i, param[i]);
				}
			}
			object = query.uniqueResult();
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
		} finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return object;
	}
	
	/******************************
	 * 查询结果总条数
	 * @param countHql
	 * @return
	 ******************************/
	public static int getResultCountForHql(String countHql,String[] param){
		Session session = null;
		Transaction tx = null;
		int totalRows = 0;
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			Query queryObject = session.createQuery(countHql);
			if(param != null && param.length > 0){
				for(int i = 0; i<param.length;i++){
					queryObject.setString(i, param[i]);
				}
			}
			if(queryObject.uniqueResult()!=null) {
				totalRows = ((Long)queryObject.uniqueResult()).intValue();
			}else{
				totalRows = 0;
			}
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
		} finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}	
		return totalRows;
	}

	public static int getResultCountForHql(String countHql, String[] param, Map<?, ?> mapParam) {
		Session session = null;
		Transaction tx = null;
		int totalRows = 0;
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(countHql);
			if(param != null && param.length > 0){
				for(int i=0; i<param.length; i++){
					query.setString(i, param[i]);
				}
			}
			if(mapParam != null){
				query.setProperties(mapParam);
			}
			if(query.uniqueResult()!=null) {
				totalRows = ((Long)query.uniqueResult()).intValue();
			}else{
				totalRows = 0;
			}
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
		} finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		
		return totalRows;
	}

	
	/******************************
	 * 模糊查询结果的总条数
	 * @param object
	 * @return
	 ******************************/
	public static int getResultCountFindByExample(Object object){
		Session session = HibernateUtil.getCurrentSession();
		Example example = Example.create(object).enableLike(MatchMode.ANYWHERE);
		Criteria criteria = session.createCriteria(object.getClass()).add(example);
		int rowCount = ((Long)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		criteria.setProjection(null);
		session.close();
		return rowCount;
	}
	
	
	/******************************
	 * 分页模糊查询
	 * @param object
	 * @param page
	 * @param rows
	 * @return
	 ******************************/
	public static List<?> findByExampleUsePaging(Object object,int page,int rows) {
		Session session = HibernateUtil.getCurrentSession();
		Example example = Example.create(object).enableLike(MatchMode.ANYWHERE);
		Criteria criteria = session.createCriteria(object.getClass()).add(example);
		criteria.setFirstResult(rows*(page-1));
		criteria.setMaxResults(rows);
		List<?> list = criteria.list();
		session.close();
		return list;
	}
	
	public static List<?> findByExample(Object object) {
		Session session = HibernateUtil.getCurrentSession();
		Example example = Example.create(object).enableLike(MatchMode.ANYWHERE);
		Criteria criteria = session.createCriteria(object.getClass()).add(example);
		List<?> list = criteria.list();
		session.close();
		return list;
	}
}
