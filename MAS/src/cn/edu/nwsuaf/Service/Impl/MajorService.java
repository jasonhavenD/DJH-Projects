package cn.edu.nwsuaf.Service.Impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Service.Interface.IMajorService;

import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.Model.MajorModel;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class MajorService extends BaseServiceImpl<Major> implements IMajorService{

	// 分页获取全部专业信息
	@SuppressWarnings("unchecked")
	public List<Major> getAllMajorListByPage(int page, int rows, String mno,String dno){
				
		String hql = "";
		List<Major> list = null;
		if(!mno.equals("000000")){
			hql="from Major t where t.mno=?";
			String param[]={mno};
			list = (List<Major>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Major t where t.department.dno=? ";
			String param[]={dno};
			list = (List<Major>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Major ";
			
			list = (List<Major>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii==="+list.size());
			
		}
		
		
		
		return list;

	}
	
	
	
	// 获取全部专业信息
	@SuppressWarnings("unchecked")
	public List<Major> getAllMajorList() {
		String hql = "FROM Major";
		return (List<Major>) QueryUtilDaoImpl.executeQuery(hql, null);
	}
	
	@SuppressWarnings("unchecked")
	public List<Major> getAllMajorListByNo(String mno,String dno){
				
		String hql = "";
		List<Major> list = null;
		if(!mno.equals("000000")){
			hql="from Major t where t.mno=?";
			String param[]={mno};
			list = (List<Major>) QueryUtilDaoImpl
			.executeQuery(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Major t where t.department.dno=? ";
			String param[]={dno};
			list = (List<Major>) QueryUtilDaoImpl
			.executeQuery(hql, param);
		}else{
			hql="from Major ";
			
			list = (List<Major>) QueryUtilDaoImpl
			.executeQuery(hql, null);
			System.out.println("list.size()iii==="+list.size());
			
		}
		
		return list;

	}
	
	// 依据主键获取专业信息（）
	
	public Major findMajorById(String majorid) {
		Major major=null;
			major= this.findById(Major.class, majorid);
		
		return major;
	}
	public List<Major> findEntityByName(String majorName){
		String hql="from Major as a where a.mname='"+majorName+"'";
		List<Major> major=findByHQL(hql);
		return major;
	}
	// 更新专业信息
	public void updateMajor(Major major) {
		try {
			this.update(major);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	// 保存专业信息
	public void saveMajor(Major major) {
		try {
			this.save(major);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	// 删除专业信息
	public void deleteMajor(String majorId) {
		Major major;
		try {
			major = this.findById(Major.class, majorId);
			this.delete(major);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}
	public int isExist(String mno) {		
		int count=0;
		String hql = "select count(*) from Major as m where "
				+ "m.mno = '"+ mno+"'";
						
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, null);
		return count;
	}
	//根据学院Id查专业，用于下拉列表
	@SuppressWarnings("unchecked")
	public List<Major> findMajorListByDepat(String dno){
		String hql = "FROM Major AS major WHERE major.department.dno = ?";
		String[] param = {dno};
		return (List<Major>) QueryUtilDaoImpl.executeQuery(hql, param);	
	}

	@SuppressWarnings("unchecked")
	public List<String> findYearList() throws ServiceException{
		List list=null;
		try {
			String hql = "SELECT DISTINCT major.year FROM Major AS major";
			 list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			Collections.sort(list);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询年份列表失败",e);
			
		}
		return list;
	}
	//导出
	@SuppressWarnings("unchecked")
	public List<Major> exportallMajorList(MajorModel majormodel)throws ServiceException{
		
		List<Major> list=null;
		try {
			String hql = "from Major as major where major.mno like :tno";
			Map mapParam = new HashMap();
			// 编号
			mapParam.put("tno", "%" + majormodel.getMajorId() + "%");
			
			//年份
			if (majormodel.getYear()!= null && !"".equals(majormodel.getYear())) {

				hql += " and major.year= '" + majormodel.getYear()+"'";
			}
			// 专业代码
			if (majormodel.getMno()!= null && !"".equals(majormodel.getMno())) {

				hql += " and major.mno= '" + majormodel.getMno()+"'";
			}
			// 学科门类
			if (majormodel.getDisciplinetype()!= null && majormodel.getDisciplinetype().getDisciplineTypeId()!= null && !"".equals(majormodel.getDisciplinetype().getDisciplineTypeId())) {

				hql += " and major.disciplinetype.disciplineTypeId= '" + majormodel.getDisciplinetype().getDisciplineTypeId()+"'";
			}
			// 专业类
			if (majormodel.getMajortype()!= null && majormodel.getMajortype().getMajorTypeId()!= null && !"".equals(majormodel.getMajortype().getMajorTypeId())) {

				hql += " and major.majortype.majorTypeId= '" + majormodel.getMajortype().getMajorTypeId()+"'";
			}
			// 专业类别
			if (majormodel.getMajorcategory()!= null && majormodel.getMajorcategory().getMajorCategoryId()!= null && !"".equals(majormodel.getMajorcategory().getMajorCategoryId())) {

				hql += " and major.majorcategory.majorCategoryId= '" + majormodel.getMajorcategory().getMajorCategoryId()+"'";
			}
			// 招生状态
			if (majormodel.getEnrollmentState()!= null && majormodel.getEnrollmentState()!= null && !"".equals(majormodel.getEnrollmentState())) {

				hql += " and major.enrollmentState= '" + majormodel.getEnrollmentState()+"'";
			}
			// 学院
			if (majormodel.getDepartmentId() != null
					&& !"".endsWith(majormodel.getDepartmentId())) {

				hql += " and major.department.dno= '"
						+ majormodel.getDepartmentId()+"'";
			}
			System.out.println(hql);
			list = (List<Major>) QueryUtilDaoImpl
					.executeQuery(hql, null, mapParam);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("导出失败",e);
		}

		return list;
		
	}
	@SuppressWarnings("unchecked")
	// 多条件查询（专利号、专利名称、专业、学院）
	public List<Major> findMajorList(MajorModel majormodel,
			int page, int rows) throws ServiceException{

		List<Major> list=null;
		try {
			String hql = "from Major as major where major.mno like :tno";
			Map mapParam = new HashMap();
			// 编号
			mapParam.put("tno", "%" + majormodel.getMajorId() + "%");
			
			//年份
			if (majormodel.getYear()!= null && !"".equals(majormodel.getYear())) {

				hql += " and major.year= '" + majormodel.getYear()+"'";
			}
			// 专业代码
			if (majormodel.getMno()!= null && !"".equals(majormodel.getMno())) {

				hql += " and major.mno= '" + majormodel.getMno()+"'";
			}
			// 学科门类
			if (majormodel.getDisciplinetype()!= null && majormodel.getDisciplinetype().getDisciplineTypeId()!= null && !"".equals(majormodel.getDisciplinetype().getDisciplineTypeId())) {

				hql += " and major.disciplinetype.disciplineTypeId= '" + majormodel.getDisciplinetype().getDisciplineTypeId()+"'";
			}
			// 专业类
			if (majormodel.getMajortype()!= null && majormodel.getMajortype().getMajorTypeId()!= null && !"".equals(majormodel.getMajortype().getMajorTypeId())) {

				hql += " and major.majortype.majorTypeId= '" + majormodel.getMajortype().getMajorTypeId()+"'";
			}
			// 专业类别
			if (majormodel.getMajorcategory()!= null && majormodel.getMajorcategory().getMajorCategoryId()!= null && !"".equals(majormodel.getMajorcategory().getMajorCategoryId())) {

				hql += " and major.majorcategory.majorCategoryId= '" + majormodel.getMajorcategory().getMajorCategoryId()+"'";
			}
			// 招生状态
			if (majormodel.getEnrollmentState()!= null && majormodel.getEnrollmentState()!= null && !"".equals(majormodel.getEnrollmentState())) {

				hql += " and major.enrollmentState= '" + majormodel.getEnrollmentState()+"'";
			}
			// 学院
			if (majormodel.getDepartmentId() != null
					&& !"".endsWith(majormodel.getDepartmentId())) {

				hql += " and major.department.dno= '"
						+ majormodel.getDepartmentId()+"'";
			}
			System.out.println(hql);
			list = (List<Major>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, mapParam, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("多条件查询失败",e);
		}

		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindMajor(MajorModel majormodel) throws ServiceException {
		
		int count=0;
		String hql = "select count(*) from Major as major where major.mno like :tno";
		
		try {
			Map mapParam = new HashMap();
			// 专利号
			mapParam.put("tno", "%" + majormodel.getMajorId() + "%");
			//年份
			if (majormodel.getYear()!= null && !"".equals(majormodel.getYear())) {

				hql += " and major.year= '" + majormodel.getYear()+"'";
			}			
			// 专业代码
			if (majormodel.getMno()!= null && !"".equals(majormodel.getMno())) {

				hql += " and major.mno= '" + majormodel.getMno()+"'";
			}
			// 学科门类
			if (majormodel.getDisciplinetype()!= null && majormodel.getDisciplinetype().getDisciplineTypeId()!= null && !"".equals(majormodel.getDisciplinetype().getDisciplineTypeId())) {

				hql += " and major.disciplinetype.disciplineTypeId= '" + majormodel.getDisciplinetype().getDisciplineTypeId()+"'";
			}
			// 专业类
			if (majormodel.getMajortype()!= null && majormodel.getMajortype().getMajorTypeId()!= null && !"".equals(majormodel.getMajortype().getMajorTypeId())) {

				hql += " and major.majortype.majorTypeId= '" + majormodel.getMajortype().getMajorTypeId()+"'";
			}
			// 专业类别
			if (majormodel.getMajorcategory()!= null && majormodel.getMajorcategory().getMajorCategoryId()!= null && !"".equals(majormodel.getMajorcategory().getMajorCategoryId())) {

				hql += " and major.majorcategory.majorCategoryId= '" + majormodel.getMajorcategory().getMajorCategoryId()+"'";
			}
			// 招生状态
			if (majormodel.getEnrollmentState()!= null && majormodel.getEnrollmentState()!= null && !"".equals(majormodel.getEnrollmentState())) {

				hql += " and major.enrollmentState= '" + majormodel.getEnrollmentState()+"'";
			}
			// 学院
			if (majormodel.getDepartmentId() != null
					&& !"".endsWith(majormodel.getDepartmentId())) {

				hql += " and major.department.dno= '"
					+ majormodel.getDepartmentId()+"'";
			}
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询结果条数失败", e);
		}
		System.out.println("count=========" + count);
		return count;

	}
	public int count(String mno,String dno)
	throws ServiceException {
int count=0;	
String hql="";
if(!mno.equals("000000")){
	hql="select count(*) from  Major t where t.mno=?";
	String param[]={mno};
	count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
}else if(!dno.equals("00000")&&mno.equals("000000")){
	hql="select count(*) from Major t where t.department.dno=?";
	String param[]={dno};
	count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
	
}else{
	hql="select count(*) from Major";
	
	count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
	
}
return count;

}


}
