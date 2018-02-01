package cn.edu.nwsuaf.dao.Impl;

import java.io.Serializable;
import java.util.List;


import org.apache.poi.ss.formula.functions.T;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.dao.Interface.IBaseDao;
import cn.edu.nwsuaf.exception.DAOException;
import cn.edu.nwsuaf.util.HibernateUtil;


public class BaseDaoImpl<T> implements IBaseDao<T> {
	
	//添加实体T
	public void save(T o) throws DAOException{
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			session.save(o);
			tx.commit();
		}catch(Exception e){
			
			if(tx != null){
				tx.rollback();
			}
			throw new DAOException("添加实体失败",e);
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
	}
	//删除实体T
	public void delete(T o) throws DAOException{
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			session.delete(o);
			tx.commit();
		}catch(Exception e){
			
			if(tx != null){
				tx.rollback();
			}
			throw new DAOException("删除实体失败", e);
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
	}
	//修改实体T
	public void update(T o) throws DAOException{
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			session.update(o);
			tx.commit();
		}catch(Exception e){
			
			if(tx != null){
				tx.rollback();
			}
			throw new DAOException("修改实体失败",e);
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		
	}
	
	//整合实体
	public void merge(T o) throws DAOException{
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			session.merge(o);
			tx.commit();
		}catch(Exception e){
			
			if(tx != null){
				tx.rollback();
			}
			throw new DAOException("整合实体失败", e);
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
	}
	
	//依据主键查找
	@SuppressWarnings("unchecked")
	public T findById(Class<T> c, Serializable id){
		Session session = null;
		Transaction tx = null;
		T t = null;
		try{
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			t = (T)session.get(c, id);
			tx.commit();
		}catch(Exception e){
			
			if(tx != null){
				tx.rollback();
			}
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return t;
	}

	//查找全部信息
	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> c) {
		Session session = null;
		Transaction tx = null;
		List<T> list = null;
		try{
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("from "+c.getName());
			list = query.list();
			tx.commit();
		}catch(Exception e){
			
			if(tx != null){
				tx.rollback();
			}
			
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	//查找不是专业大类以及不是'其他'的所有专业名称
	@SuppressWarnings("unchecked")
	public List<T> findSummaryMajor(Class<T> c){
		Session session = null;
		Transaction tx = null;
		List<T> list = null;
		try{
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("from Major where mname not like '%类' and EnrollmentState='在招'");
			list = query.list();
			tx.commit();
		}catch(Exception e){
			
			if(tx != null){
				tx.rollback();
			}
			
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	//依据HQL语句查询信息
	@SuppressWarnings("unchecked")
	public List<T> findByHQL(String hqlString) {
		Session session = null;
		Transaction tx = null;
		List<T> list = null;
		try{
			session =HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hqlString);
			list = query.list();
			tx.commit();
		}catch(Exception e){
			
			if(tx != null){
				tx.rollback();
			}
			
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	//依据SQL语句查询信息
	@SuppressWarnings("unchecked")
	public List<T> findBySQL(String sqlString) {
		Session session = null;
		Transaction tx = null;
		List<T> list = null;
		try{
			session =HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			System.out.println("sql"+sqlString);
			Query query = session.createSQLQuery(sqlString);
			list = query.list();
			System.out.println("size"+list.size());
			tx.commit();
		}catch(Exception e){
			
			if(tx != null){
				tx.rollback();
			}
			
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	
	//执行sql语句
	public void execute(String sql) {
		
		Session session=null;
		Transaction ts=null;
		try {
			session=HibernateUtil.getCurrentSession();
			ts=session.beginTransaction();
			Query query=session.createSQLQuery(sql);
			query.executeUpdate();
			ts.commit();
		} catch (Exception e) {
			
			if(ts!=null){
				ts.rollback();
			}
			
		}finally{
			session.close();
		}
	}
}
