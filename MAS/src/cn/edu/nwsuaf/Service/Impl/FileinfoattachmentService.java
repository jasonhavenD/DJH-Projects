package cn.edu.nwsuaf.Service.Impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.CurriculumresourceModel;
import cn.edu.nwsuaf.Model.FileinfoAttachmentModel;

import cn.edu.nwsuaf.bean.Curriculumresource;
import cn.edu.nwsuaf.bean.FileinfoAttachment;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class FileinfoattachmentService extends BaseServiceImpl<FileinfoAttachment> {
	@SuppressWarnings("unchecked")
	public List<String> findYearList() throws ServiceException{
		List list=null;
		try {
			String hql = "SELECT DISTINCT fia.year FROM FileinfoAttachment AS fia where fia.mas.assessingneedtarget.assessingproject.tag='1'";
			 list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			Collections.sort(list);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询年份列表失败",e);
			
		}
		return list;
	}
	public FileinfoAttachment findByIdyear(String masCode,String year) throws ServiceException{
		FileinfoAttachment f=null;	
		try{
			String hql = "select * from FileinfoAttachment as fia where fia.mas.assessingneedtarget.assessingproject.tag='1' and fia.masCode= '"
					+ masCode+"'"+"and fia.year= '"+year+"'";
			f =(FileinfoAttachment) QueryUtilDaoImpl.executeQuery(hql, null);
			
	} catch (Exception e) {
		e.printStackTrace();
		throw new ServiceException("查询附件列表失败",e);
		
	}
		return f;
	}
	@SuppressWarnings("unchecked")
	public List<FileinfoAttachment> findallFileinfoAttachmentList(int page, int rows,String mno,String dno) {
			
		String hql = "";
		List<FileinfoAttachment> list = null;
		if(!mno.equals("000000")){
			hql="from FileinfoAttachment t where t.mas.major.mno=? and t.mas.assessingneedtarget.assessingproject.tag='1'";
			String param[]={mno};
			list = (List<FileinfoAttachment>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from FileinfoAttachment t where t.mas.major.department.dno=? and t.mas.assessingneedtarget.assessingproject.tag='1'";
			String param[]={dno};
			list = (List<FileinfoAttachment>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from FileinfoAttachment where mas.assessingneedtarget.assessingproject.tag='1'";
			
			list = (List<FileinfoAttachment>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii==="+list.size());
			
		}
		
		
		
		return list;

	}
	@SuppressWarnings("unchecked")
	// 多条件查询（专利号、专利名称、专业、学院）
	public List<FileinfoAttachment> findFiaList(FileinfoAttachmentModel fiamodel,
			int page, int rows) throws ServiceException{

		List<FileinfoAttachment> list=null;
		try {
			String hql = "from FileinfoAttachment as fia where fia.mas.assessingneedtarget.assessingproject.tag='1' and " +
					"fia.year like :tpno";
					
					
			System.out.println("Service===Year==" + fiamodel.getYear());
			Map mapParam = new HashMap();
			// 年份
			mapParam.put("tpno", "%" + fiamodel.getYear()+ "%");
			
			// 专业
			if (fiamodel.getMajorId() != null
					&& !"".equals(fiamodel.getMajorId())&& !"%".equals(fiamodel.getMajorId())) {

				hql += " and fia.mas.major.mno= '" + fiamodel.getMajorId()+"'";
			}
			// 学院
			if (fiamodel.getDepartmentId() != null
					&& !"".endsWith(fiamodel.getDepartmentId())) {

				hql += " and fia.mas.major.department.dno='"
						+ fiamodel.getDepartmentId()+"'";
			}
			// 是否上传
			if (fiamodel.getUploadStatus() != null
					&& !"".equals(fiamodel.getUploadStatus())) {

				hql += " and fia.uploadStatus='"
						+ fiamodel.getUploadStatus()+"'";
			}
			list = (List<FileinfoAttachment>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, mapParam, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("多条件查询失败",e);
		}

		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindFia(FileinfoAttachmentModel fiamodel) throws ServiceException {
		
		int count=0;
		String hql = "select count(*) from FileinfoAttachment as fia where fia.mas.assessingneedtarget.assessingproject.tag='1' and " +
					"fia.year like :tpno";
		try {
			Map mapParam = new HashMap();
			// 年份
			mapParam.put("tpno", "%" + fiamodel.getYear()+ "%");

			// 专业
			if (fiamodel.getMajorId() != null
					&& !"".equals(fiamodel.getMajorId())&& !"%".equals(fiamodel.getMajorId())) {

				hql += " and fia.mas.major.mno= '" + fiamodel.getMajorId()+"'";
			}
			// 学院
			if (fiamodel.getDepartmentId() != null
					&& !"".endsWith(fiamodel.getDepartmentId())) {

				hql += " and fia.mas.major.department.dno= '"
						+ fiamodel.getDepartmentId()+"'";
			}
			// 是否上传
			if (fiamodel.getUploadStatus() != null
					&& !"".equals(fiamodel.getUploadStatus())) {

				hql += " and fia.uploadStatus='"
						+ fiamodel.getUploadStatus()+"'";
			}
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询结果条数失败", e);
		}
		System.out.println("count=========" + count);
		return count;

	}
	public List<FileinfoAttachment>  findCurrentFileinfoAttachment(){
		String hql = "from FileinfoAttachment as fia where fia.mas.assessingneedtarget.assessingproject.tag='1'";
		List<FileinfoAttachment> list = (List<FileinfoAttachment>)QueryUtilDaoImpl.executeQuery(hql, null);
		return list;
	}
	//导出
	@SuppressWarnings("unchecked")
	public List<FileinfoAttachment> exportallFiaList(
			FileinfoAttachmentModel fiamodel) {

		List<FileinfoAttachment> list=null;
		try {
			String hql = "from FileinfoAttachment as fia where fia.mas.assessingneedtarget.assessingproject.tag='1' and " +
					"fia.year like :tpno";
					
					
			System.out.println("Service===Year==" + fiamodel.getYear());
			Map mapParam = new HashMap();
			// 年份
			mapParam.put("tpno", "%" + fiamodel.getYear()+ "%");
			
			// 专业
			if (fiamodel.getMajorId() != null
					&& !"".equals(fiamodel.getMajorId())&& !"%".equals(fiamodel.getMajorId())) {

				hql += " and fia.mas.major.mno= '" + fiamodel.getMajorId()+"'";
			}
			// 学院
			if (fiamodel.getDepartmentId() != null
					&& !"".endsWith(fiamodel.getDepartmentId())) {

				hql += " and fia.mas.major.department.dno='"
						+ fiamodel.getDepartmentId()+"'";
			}
			// 是否上传
			if (fiamodel.getUploadStatus() != null
					&& !"".equals(fiamodel.getUploadStatus())) {

				hql += " and fia.uploadStatus='"
						+ fiamodel.getUploadStatus()+"'";
			}
			list = (List<FileinfoAttachment>) QueryUtilDaoImpl
					.executeQuery(hql, null, mapParam);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public int count(String mno,String dno)
	throws ServiceException {
int count=0;	
String hql="";
if(!mno.equals("000000")){
	hql="select count(*) from  FileinfoAttachment t where t.mas.major.mno=? and t.mas.assessingneedtarget.assessingproject.tag='1'";
	String param[]={mno};
	count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
}else if(!dno.equals("00000")&&mno.equals("000000")){
	hql="select count(*) from FileinfoAttachment t where t.mas.major.department.dno=? and t.mas.assessingneedtarget.assessingproject.tag='1'";
	String param[]={dno};
	count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
	
}else{
	hql="select count(*) from FileinfoAttachment where mas.assessingneedtarget.assessingproject.tag='1'";
	
	count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
	
}
return count;

}

	
}
