package cn.edu.nwsuaf.Service.Impl;

import java.util.List;


import cn.edu.nwsuaf.bean.Majortype;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class MajorTypeService extends BaseServiceImpl<Majortype> {
	/******************************专业类信息管理**************************************************/
	//分页显示专业类信息
	@SuppressWarnings("unchecked")
	public List<Majortype>getAllMajortypesListByPage(int page ,int rows){
		String hql="FROM MajorType";
		return (List<Majortype>)QueryUtilDaoImpl.executeQueryByPage(hql, null, page, rows);
	}
	//更新专业类信息
	public void updateMajorType(Majortype majortype){
		try {
			this.update(majortype);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	//保存专业类信息
	public void saveMajortype(Majortype majortype){
		try {
			this.save(majortype);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	//删除专业类信息
	public void deleteMajortype(String majorTypeId){
		Majortype majortype;
		try {
			majortype = this.findById(Majortype.class, majorTypeId);
			this.delete(majortype);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
