package cn.edu.nwsuaf.dao.Interface;

import java.io.Serializable;
import java.util.List;

import cn.edu.nwsuaf.exception.DAOException;


public interface IBaseDao<T> {
	//添加
	public void save(T o) throws DAOException;
	//修改
	public void update(T o) throws DAOException;
	
	//合并
	public void merge(T o) throws DAOException;
	
	//删除
	public void delete(T o) throws DAOException;
	
	//根据实体ID查询
	public T findById(Class<T> c, Serializable id) ;
	
	//查询全部
	public List<T> findAll(Class<T> c) ;
	//统计查询的专业排除'其他'和大类专业
	public List<T> findSummaryMajor(Class<T> c);
	
	//根据HQL语句查询
	public List<T> findByHQL(String hqlString) ;
	
	//根据SQL语句查询
	public List<T> findBySQL(String sqlString) ;
	
	//执行sql语句
	public void execute(String sql) ;
	
}
