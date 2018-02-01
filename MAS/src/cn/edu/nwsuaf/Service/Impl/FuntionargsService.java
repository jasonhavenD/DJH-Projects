package cn.edu.nwsuaf.Service.Impl;

import java.util.List;

import cn.edu.nwsuaf.bean.Funtionargs;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class FuntionargsService extends BaseServiceImpl<Funtionargs> {
	//分页获取全部指标计算F值基本信息
	@SuppressWarnings("unchecked")
	public List<Funtionargs> getAllFuntionargsListByPage(int page, int rows) throws ServiceException{
		String hql = "from Funtionargs";
		List list=null;
		try {
			list= (List<Funtionargs>) QueryUtilDaoImpl.executeQueryByPage(hql, null, page, rows);
		} catch (Exception e) {
			
			throw new ServiceException("Funtionargs层分页获取全部指标F值基本信息失败", e);
		}
		return list;
	}
	
	//获取全部F值基本信息
	@SuppressWarnings("unchecked")
	public List<Funtionargs> getAllFuntionargs() throws ServiceException{
		String hql = "from Funtionargs";
		List list = null;
		try{
		list = (List<Funtionargs>) QueryUtilDaoImpl.executeQuery(hql, null);
		} catch (Exception e) {
			
			throw new ServiceException("Funtionargs层分页获取全部指标F值基本信息失败", e);
		}
		return list;
	}
	
	/*//获取F名称和对应的权重信息
	@SuppressWarnings("unchecked")
	public Map getFnameValue() throws ServiceException{
		String hql = "SELECT new map(F.funName as fName,F.funValue as fValue) FROM Funtionargs F";
		List FMaplist;
		try {
			FMaplist = (List<Map>) QueryUtilDaoImpl.executeQuery(hql, null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Funtionargs层获取F名称和值信息失败", e);
		}
		return FMaplist;
	}*/
	
	
	
	//依据主键获取指标F信息
	public Funtionargs findFuntionargsById(int id) throws ServiceException{
		
			return this.findById(Funtionargs.class, id);
		
	}
	//依据F名字获取指标F信息
	@SuppressWarnings("unchecked")
	public List<Funtionargs> findFuntionargsByNamePage(String fName,int page,int rows) throws ServiceException{
		String hql = "FROM Funtionargs AS F where F.funName=?";
		String param[]={fName};
		return (List<Funtionargs>) QueryUtilDaoImpl.executeQueryByPage(hql, param, page, rows);
	}
	//依据F名字获取指标F信息
	@SuppressWarnings("unchecked")
	public List<Funtionargs> findFuntionargsByName(String fName) throws ServiceException{
		String hql = "FROM Funtionargs AS F where F.funName=?";
		String param[]={fName};
		return (List<Funtionargs>) QueryUtilDaoImpl.executeQuery(hql, param);
	}
	//更新F值信息
	public void updateFuntionargs(Funtionargs funtionargs) throws ServiceException{
		try {
			this.update(funtionargs);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
		
			throw new ServiceException("funtionargs层更新信息失败", e);
		}
	}
	
	//保存F值信息
	public void saveFuntionargs(Funtionargs funtionargs) throws ServiceException{
		try {
			this.save(funtionargs);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			
			throw new ServiceException("funtionargs层保存信息失败", e);
		}
	}
	
	//删除F值信息
	public void deleteFuntionargs(Funtionargs  funtionargs) throws ServiceException{
	
		try {
			this.delete(funtionargs);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			
			throw new ServiceException("funtionargs层删除信息失败", e);
		}
		
	}
}
