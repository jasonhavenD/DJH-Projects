package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.edu.nwsuaf.Model.CurriculumresourceModel;
import cn.edu.nwsuaf.bean.Curriculumresource;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class CurriculumresourceService extends
		BaseServiceImpl<Curriculumresource> {
	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() {
		String hql = "SELECT DISTINCT cur.year FROM Curriculumresource AS cur ORDER BY cur.year ASC";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("年份=============" + list.size());
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Curriculumresource> findallCurriculumresourceList(int page, int rows, String mno,String dno) {
		String hql = "";
		List<Curriculumresource> list = null;
		if(!mno.equals("000000")){
			hql="from Curriculumresource as cur where cur.major.mno=?";
			hql+=" order by course.cname,year DESC";
			String param[]={mno};
			list = (List<Curriculumresource>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Curriculumresource as cur where cur.major.department.dno=?";
			hql+=" order by course.cname,year DESC";
			String param[]={dno};
			list = (List<Curriculumresource>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Curriculumresource";
			hql+=" order by course.cname,year DESC";
			list = (List<Curriculumresource>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()==="+list.size());			
		}
		return list;
	}
	//导出
	@SuppressWarnings("unchecked")
	public List<Curriculumresource> exportallCurriculumresourceList(
			CurriculumresourceModel curmodel) {

		String hql = "from Curriculumresource as cur where cur.course.cno like :tpno";
		Map mapParam = new HashMap();
		// 课程编号
		mapParam.put("tpno", "%" + curmodel.getId() + "%");
		// 课程名称
		//mapParam.put("tpn", "%" + curmodel.getName() + "%");
		// 年份
		if (curmodel.getYear() != null && !"".equals(curmodel.getYear())) {

			hql += " and cur.year='" + curmodel.getYear()+"'";
		}

		// 是否开出
		if (curmodel.getIsOpen() != null && !"".equals(curmodel.getIsOpen())) {
			System.out.println(curmodel.getIsOpen());
			hql += " and cur.isOpen='" + curmodel.getIsOpen()+"'";
		}
		// 是否优质课程
		if (curmodel.getIsExcellent() != null
				&& !"".equals(curmodel.getIsExcellent())) {
			hql += " and cur.isExcellent='" + curmodel.getIsExcellent()+"'";
		}
		// 专业
		if (curmodel.getMajorId() != null && !"".equals(curmodel.getMajorId())&& !"%".equals(curmodel.getMajorId())) {

			hql += " and cur.major.mno='" + curmodel.getMajorId()+"'";
		}
		// 学院
		if (curmodel.getDepartmentId() != null
				&& !"".endsWith(curmodel.getDepartmentId())) {

			hql += " and cur.major.department.dno='"
					+ curmodel.getDepartmentId()+"'";
		}
		hql+=" order by course.cname,year DESC";
		System.out.println("course:"+hql);
		List<Curriculumresource> list = (List<Curriculumresource>) QueryUtilDaoImpl.executeQuery(hql, null, mapParam);
		return list;

	}
	
	@SuppressWarnings("unchecked")
	// 多条件查询
	public List<Curriculumresource> findCurriculumresourceList(
			CurriculumresourceModel curmodel, int page, int rows) {

		String hql = "from Curriculumresource as cur where cur.course.cno like :tpno";
		Map mapParam = new HashMap();
		// 课程编号
		mapParam.put("tpno", "%" + curmodel.getId() + "%");
		// 课程名称
		//mapParam.put("tpn", "%" + curmodel.getName() + "%");
		// 年份
		if (curmodel.getYear() != null && !"".equals(curmodel.getYear())) {

			hql += " and cur.year='" + curmodel.getYear()+"'";
		}

		// 是否开出
		if (curmodel.getIsOpen() != null && !"".equals(curmodel.getIsOpen())) {
			System.out.println(curmodel.getIsOpen());
			hql += " and cur.isOpen='" + curmodel.getIsOpen()+"'";
		}
		// 是否优质课程
		if (curmodel.getIsExcellent() != null
				&& !"".equals(curmodel.getIsExcellent())) {
			hql += " and cur.isExcellent='" + curmodel.getIsExcellent()+"'";
		}
		// 专业
		if (curmodel.getMajorId() != null && !"".equals(curmodel.getMajorId())&& !"%".equals(curmodel.getMajorId())) {

			hql += " and cur.major.mno='" + curmodel.getMajorId()+"'";
		}
		// 学院
		if (curmodel.getDepartmentId() != null
				&& !"".endsWith(curmodel.getDepartmentId())) {

			hql += " and cur.major.department.dno='"
					+ curmodel.getDepartmentId()+"'";
		}
		hql+=" order by course.cname,year DESC";
		System.out.println(hql);
		List<Curriculumresource> list = (List<Curriculumresource>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindCurriculumresource(CurriculumresourceModel curmodel) {
		int count;

		String hql = "select count(*) from Curriculumresource as cur where cur.course.cno like :tpno";
		Map mapParam = new HashMap();
		//课程编号
		mapParam.put("tpno", "%" + curmodel.getId() + "%");
		// 课程名称
		//mapParam.put("tpn", "%" + curmodel.getName() + "%");
		// 年份
		if (curmodel.getYear() != null && !"".equals(curmodel.getYear())) {

			hql += " and cur.year='" + curmodel.getYear()+"'";
		}

		// 是否开出
		if (curmodel.getIsOpen() != null && !"".equals(curmodel.getIsOpen())) {
			System.out.println(curmodel.getIsOpen());
			hql += " and cur.isOpen='" + curmodel.getIsOpen()+"'";
		}
		// 是否优质课程
		if (curmodel.getIsExcellent() != null
				&& !"".equals(curmodel.getIsExcellent())) {
			hql += " and cur.isExcellent='" + curmodel.getIsExcellent()+"'";
		}
		// 专业
		if (curmodel.getMajorId() != null && !"".equals(curmodel.getMajorId())&& !"%".equals(curmodel.getMajorId())) {

			hql += " and cur.major.mno='" + curmodel.getMajorId()+"'";
		}
		// 学院
		if (curmodel.getDepartmentId() != null
				&& !"".endsWith(curmodel.getDepartmentId())) {

			hql += " and cur.major.department.dno='"
					+ curmodel.getDepartmentId()+"'";
		}
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=========" + count);
		return count;

	}
	// 查询结果条数
	public int count(String mno,String dno)
			throws ServiceException {
		int count=0;	
		String hql="";
		if(!mno.equals("000000")){
			hql="select count(*) from Curriculumresource as cur where cur.major.mno=?";
			String param[]={mno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="select count(*) from Curriculumresource as cur where cur.major.department.dno=?";
			String param[]={dno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			
		}else{
			hql="select count(*) from Curriculumresource";
			
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
			
		}
		return count;

	}
}
