package cn.edu.nwsuaf.Service.Interface;

import java.io.Serializable;
import java.util.List;

import cn.edu.nwsuaf.exception.ServiceException;



public interface IBaseService<T> {
	//excel实体导入
	public void batchUpdateResult(Class<T> c, List<T> list);
	//添加
	public void save(T o) throws ServiceException;
	
	//修改
	public void update(T o) throws ServiceException;
	
	//合并
	public void merge(T o) throws ServiceException;
	
	//删除
	public void delete(T o) throws ServiceException;
	
	//根据实体ID查询
	public T findById(Class<T> c, Serializable id);
	
	//查询全部
	public List<T> findAll(Class<T> c) ;
	
	//根据HQL语句查询
	public List<T> findByHQL(String hqlString) ;
	
	//根据SQL语句查询
	public List<T> findBySQL(String sqlString) ;
	
	//执行SQL
	public void execute (String sql) ;
	/*//指定字段模糊查询
	public List<T> findByType(String  tableName,String  type,String value,int page,int rows);*/
	

	/***********************普通查询********************************//*
	//根据HQL及参数数组查询进行查询
	public  List<?> executeQuery(String hql,String[] param);
	
	//根据HQL语句、参数数组、绑定参数进行HQL赋值的Map进行查询
	public  List<?> executeQuery(String hql,String[] param,Map<?, ?> mapParam);

	*//***********************分页查询********************************//*
	//根据HQL语句，参数数组进行分页查询
	public  List<?> executeQueryByPage(String hql,String[] param,int page,int rows);
	
	//根据HQL语句、参数数组、绑定参数进行HQL赋值的Map进行分页查询
	public  List<?> executeQueryByPage(String hql,String[] param,Map<?, ?> mapParam,int page,int rows);
	
	*//**********************模糊查询****************************************************//*
	//分页模糊查询
	public  List<?> findByExampleUsePaging(Object object,int page,int rows);
	
	//模糊查询
	public  List<?> findByExample(Object object);
	
	*//**********************修改****************************************************//*
	
	////根据HQL及参数数组进行修改
	public  void executeUpdate(String hql,String[] param);
	
	//根据HQL语句、参数数组、绑定参数进行HQL赋值的Map进行修改
	public  void executeUpdate(String hql,String[] param,Map<?, ?> mapParam);
	
	*//**********************批量***********************************//*
	//批量插入
	public  void batchInsert(List<Object> objList);
	
	//批量修改
	public  void batchUpdate(List<HqlParam> hqlParamList);
	
	//唯一查询
	public  Object uniqueResult(String hql,String[] param);
	
	*//********************返回查询得到的所有记录总条数   return totalRows；*******************//*
	
	public  int getResultCountForHql(String countHql,String[] param);
	
	public  int getResultCountForHql(String countHql, String[] param, Map<?, ?> mapParam);
	
	//模糊查询得到的记录总条数 return rowCount;
	public  int getResultCountFindByExample(Object object);*/
	
}
