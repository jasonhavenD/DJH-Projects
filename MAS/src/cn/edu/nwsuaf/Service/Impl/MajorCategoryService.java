package cn.edu.nwsuaf.Service.Impl;

import java.util.List;
import cn.edu.nwsuaf.bean.Majorcategory;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class MajorCategoryService extends BaseServiceImpl<Majorcategory> {
	
	//分页显示专业类别信息
	@SuppressWarnings("unchecked")
	public List<Majorcategory>getAllMajorcategoryListByPage(int page ,int rows) throws ServiceException{
		String hql="FROM Majorcategory";
		List list=null;
		try {
			list= (List<Majorcategory>) QueryUtilDaoImpl.executeQueryByPage(hql, null, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//更新专业类别信息
	public void updateMajorcategory(Majorcategory majorcategory)throws ServiceException{
		try {
			this.update(majorcategory);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	//保存专业类别信息
	public void saveMajorcategory(Majorcategory majorcategory)throws ServiceException{
		try {
			this.save(majorcategory);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	//删除专业类别信息
	public void deleteMajorcategory(String majorCategoryId)throws ServiceException{
		Majorcategory majorcategory = null;
		try {
			majorcategory = this.findById(Majorcategory.class, majorCategoryId);
			this.delete(majorcategory);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
