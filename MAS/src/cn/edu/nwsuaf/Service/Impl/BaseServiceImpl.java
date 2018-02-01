package cn.edu.nwsuaf.Service.Impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.nwsuaf.Service.Interface.IBaseService;
import cn.edu.nwsuaf.dao.Interface.IBaseDao;
import cn.edu.nwsuaf.exception.DAOException;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.HibernateUtil;


public class BaseServiceImpl<T> implements IBaseService<T> {

	private IBaseDao<T> baseDao;
	
	//excel实体导入
	public void batchUpdateResult(Class<T> c, List<T> list){
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			//tx = session.beginTransaction();
			if(list != null && list.size() > 0){
				//System.out.println("session"+list.size());
				for(T e : list){
					//System.out.println("session开始》》》》");
					tx = session.beginTransaction();
					session.saveOrUpdate(e);
					tx.commit();
					session.flush();
					session.clear();
					//session.clear();
				}
			}
			//tx.commit();
			
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
	public List<T> findEntityByName(Class<T> c, String columnName,String columnValue){
			String hqlString="from "+c.getName()+" where "+columnName+"='"+columnValue+"'";
			//System.out.println("BaseQuery:"+hqlString);
			List<T>EntityList=baseDao.findByHQL(hqlString);
			return EntityList;
		
	}
	public List<T> findEntityByName(Class<T> c, String columnName,int columnValue){
		String hqlString="from "+c.getName()+" where "+columnName+"="+columnValue;
		//System.out.println("BaseQuery:"+hqlString);
		List<T>EntityList=baseDao.findByHQL(hqlString);
		return EntityList;
	
	}
	public void delete(T o) throws ServiceException{
		try {
			baseDao.delete(o);
		} catch (DAOException e) {
			//e.printStackTrace();
			throw new ServiceException("BaseServiceImpl层删除实体失败", e);
		}	
	}

	public List<T> findSummaryMajor(Class<T> c){
		List<T> list=null;
		try {
			list=baseDao.findSummaryMajor(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<T> findAll(Class<T> c){ 
			return baseDao.findAll(c);
	}

	public List<T> findByHQL(String hqlString){
			return baseDao.findByHQL(hqlString);
		
	}
	public T findById(Class<T> c, Serializable id) {
			return baseDao.findById(c, id);
	}

	public List<T> findBySQL(String sqlString){
		
			return baseDao.findBySQL(sqlString);
		
	}
	
	
	public void merge(T o) throws ServiceException{
		try {
			baseDao.merge(o);
		} catch (DAOException e) {
			
			throw new ServiceException("BaseServiceImpl层合并实体失败", e);
		}
		
	}

	public void save(T o) throws ServiceException{
	try {
		baseDao.save(o);
	} catch (DAOException e) {
		
		throw new ServiceException("BaseServiceImpl层保存实体失败", e);
	}
		
	}

	public void update(T o) throws ServiceException{
		try {
			baseDao.update(o);
		} catch (DAOException e) {
			
			throw new ServiceException("BaseServiceImpl层修改实体失败", e);
		}
		
	}
					
	public IBaseDao<T> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	public void execute(String sql){
			baseDao.execute(sql);
	}

}
