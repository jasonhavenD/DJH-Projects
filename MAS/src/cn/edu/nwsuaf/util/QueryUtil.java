package cn.edu.nwsuaf.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;

import cn.edu.nwsuaf.bean.FileinfoAttachment;
import cn.edu.nwsuaf.bean.Sysuserinfo;



public class QueryUtil {

	//返回用户专业代码
	public static Sysuserinfo getUserMno(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Sysuserinfo sysuserinfo=(Sysuserinfo) session.getAttribute("userInfo");
		return sysuserinfo;
	}
	/******************************
	 * 查询方法
	 * @param hql
	 * @param param
	 * @return
	 ******************************/
	public static List<?> executeQuery(String hql,String[] param){
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
			session = HibernateUtil.getSession();
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
			session = HibernateUtil.getCurrentSession();
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
	
/*
	*//**
	 * 上传附件并设置外键关联
	 */
	public static boolean uploadFia(FileinfoAttachment fia) {
		Session session = null;
		Transaction tx = null;
		boolean result = true;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();					
			session.merge(fia);			
			//删除原有的附件记录和文件：
			/*if(fia.getActualPath() != null){
				FileTools.delFile(fia.getActualPath());
				
			}*/
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
			result = false;
		} finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return result;
	}
	
	
}
