package cn.edu.nwsuaf.Service.Impl;

import java.util.List;

import cn.edu.nwsuaf.bean.Disciplinetype;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class DisciplineTypeService extends BaseServiceImpl<Disciplinetype> {

	/****************************** 学科门类信息管理 **************************************************/
	// 分页显示学科门类信息
	@SuppressWarnings("unchecked")
	public List<Disciplinetype> getAllDisciplinetypeListByPage(int page,
			int rows) throws ServiceException{
		String hql = "FROM Disciplinetype";
		List list=null;
		try {
			list= (List<Disciplinetype>) QueryUtilDaoImpl.executeQueryByPage(hql,
					null, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Service层分页显示学科门类信息失败", e);
		}
		return list;
	}

	// 依据主键查询学科门类信息
	public Disciplinetype findDisciplineTypeById(String disciplineTypeId) throws ServiceException{
		Disciplinetype dis = null;
		
			dis = this.findById(Disciplinetype.class, disciplineTypeId);
		
		return dis;
	}

	// 更新学科门类信息
	public void updateDisciplintype(Disciplinetype disciplinetype) throws ServiceException{
		try {
			this.update(disciplinetype);
		} catch (ServiceException e) {
			
			throw new ServiceException("Service层更新学科门类信息失败", e);
		}
	}

	// 保存学科门类信息
	public void saveDisciplinetype(Disciplinetype majorcategory) throws ServiceException{
		try {
			this.save(majorcategory);
		} catch (ServiceException e) {
		
			throw new ServiceException("Service保存学科门类信息失败", e);
		}
	}

	// 删除学科门类信息
	public void deleteDisciplinetype(String disciplinetypeId) throws ServiceException{
		Disciplinetype majorcategory;
		try {
			majorcategory = this.findById(Disciplinetype.class,
					disciplinetypeId);
			this.delete(majorcategory);
		} catch (ServiceException e) {
			
			throw new ServiceException("Service删除学科门类信息失败", e);
		}

	}

}
