package cn.edu.nwsuaf.Service.Impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.MajorcourseModel;
import cn.edu.nwsuaf.bean.Majorcourse;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class MajorcourseService extends BaseServiceImpl<Majorcourse>{
	//返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList(){
		String hql = "SELECT DISTINCT mcourse.year FROM Majorcourse AS mcourse ORDER BY mcourse.year ASC";
		List list= (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("年份============="+list.size());
		return list;
	}
	//返回职称列表
	@SuppressWarnings("unchecked")
	public List<String> findPtitleList(){
		String hql = "SELECT DISTINCT ptitle.professionalTitleName FROM Professionaltitle AS ptitle ORDER BY ptitle.professionalTitleName";
		List list= (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("职称============="+list.size());
		return list;
	}
	//返回学期列表
	@SuppressWarnings("unchecked")
	public List<String> findOpenSemesterList(){
		String hql = "SELECT DISTINCT mcourse.openSemester FROM Majorcourse AS mcourse ORDER BY mcourse.openSemester ";
		List list= (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("学期============="+list.size());
		return list;
	}
	//初始化获取list
	@SuppressWarnings("unchecked")
	public List<Majorcourse> findallMcourseList(int page, int rows,String mno,String dno) {

		String hql = "";
		List<Majorcourse> list = null;
		if(!mno.equals("000000")){
			hql="from Majorcourse as mcourse where mcourse.major.mno=?";
			String param[]={mno};
			list = (List<Majorcourse>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Majorcourse as mcourse where mcourse.major.department.dno=?";
			String param[]={dno};
			list = (List<Majorcourse>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Majorcourse";
			
			list = (List<Majorcourse>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii==="+list.size());
			
		}
		return list;
	}
	//导出list
	@SuppressWarnings("unchecked")
	public List<Majorcourse> exportList(MajorcourseModel mcoursemodel) throws UnsupportedEncodingException {
		String hql = "from Majorcourse as mcourse where " + "mcourse.teacher.tno like :tno "+"and mcourse.teacher.tname like :tname ";
		Map mapParam = new HashMap();
		// 教师编号
		mapParam.put("tno", "%" + mcoursemodel.getTno()+ "%");
		//教师姓名
		mcoursemodel.setTname(java.net.URLDecoder.decode(mcoursemodel.getTname(),"UTF-8"));
		mapParam.put("tname", "%" + mcoursemodel.getTname()+ "%");
		//年份
		if(mcoursemodel.getId()!=null&&!"".equals(mcoursemodel.getId())){
			
			hql+=" and mcourse.course.cno= "+mcoursemodel.getId();
		}
		//年份
		if(mcoursemodel.getYear()!=null&&!"".equals(mcoursemodel.getYear())){
			
			hql+=" and mcourse.year= "+mcoursemodel.getYear();
		}
		//学期
		if (mcoursemodel.getOpenSemester() != null && !"".equals(mcoursemodel.getOpenSemester())) {
			mcoursemodel.setOpenSemester(java.net.URLDecoder.decode(mcoursemodel.getOpenSemester(),"UTF-8"));
			hql += " and mcourse.openSemester='" + mcoursemodel.getOpenSemester()+"'";
		}
		//职称
		if (mcoursemodel.getProfessionalTitleName() != null && !"".equals(mcoursemodel.getProfessionalTitleName())) {
			mcoursemodel.setProfessionalTitleName(java.net.URLDecoder.decode(mcoursemodel.getProfessionalTitleName(),"UTF-8"));
			hql += " and mcourse.professionaltitle.professionalTitleName='" + mcoursemodel.getProfessionalTitleName()+"'";
		}
		//课程类型
		if (mcoursemodel.getCtype() != null && !"".equals(mcoursemodel.getCtype())) {
			mcoursemodel.setCtype(java.net.URLDecoder.decode(mcoursemodel.getCtype(),"UTF-8"));
			hql += " and mcourse.ctype='" + mcoursemodel.getCtype()+"'";
		}
		// 专业
		if (mcoursemodel.getMajorId() != null && !"".equals(mcoursemodel.getMajorId()) && !"%".equals(mcoursemodel.getMajorId())) {

			hql += " and mcourse.major.mno='" + mcoursemodel.getMajorId()+"'";
		}
		// 学院
		if (mcoursemodel.getDepartmentId() != null
				&& !"".endsWith(mcoursemodel.getDepartmentId())) {

			hql += " and mcourse.major.department.dno='" + mcoursemodel.getDepartmentId()+"'";
		}
		List<Majorcourse> list = (List<Majorcourse>) QueryUtilDaoImpl.executeQuery(hql, null, mapParam);
		System.out.println("exportlist+"+list.size());	
		return list;
	}
	@SuppressWarnings("unchecked")
	// 多条件查询
	public List<Majorcourse> findMcourseList(MajorcourseModel mcoursemodel, int page, int rows) throws UnsupportedEncodingException {
		
		String hql = "from Majorcourse as mcourse where " + "mcourse.teacher.tno like :tno "+"and mcourse.teacher.tname like :tname ";
		Map mapParam = new HashMap();
		// 教师编号
		mapParam.put("tno", "%" + mcoursemodel.getTno()+ "%");
		//教师姓名
		mcoursemodel.setTname(java.net.URLDecoder.decode(mcoursemodel.getTname(),"UTF-8"));
		//mcoursemodel.setTname(mcoursemodel.getTname());
		mapParam.put("tname", "%" + mcoursemodel.getTname()+ "%");
		//年份
		if(mcoursemodel.getId()!=null&&!"".equals(mcoursemodel.getId())){
			
			hql+=" and mcourse.course.cno= "+mcoursemodel.getId();
		}
		//年份
		if(mcoursemodel.getYear()!=null&&!"".equals(mcoursemodel.getYear())){
			
			hql+=" and mcourse.year= "+mcoursemodel.getYear();
		}
		//学期
		if (mcoursemodel.getOpenSemester() != null && !"".equals(mcoursemodel.getOpenSemester())) {
			mcoursemodel.setOpenSemester(java.net.URLDecoder.decode(mcoursemodel.getOpenSemester(),"UTF-8"));
			hql += " and mcourse.openSemester='" + mcoursemodel.getOpenSemester()+"'";
		}
		//职称
		if (mcoursemodel.getProfessionalTitleName() != null && !"".equals(mcoursemodel.getProfessionalTitleName())) {
			mcoursemodel.setProfessionalTitleName(java.net.URLDecoder.decode(mcoursemodel.getProfessionalTitleName(),"UTF-8"));
			hql += " and mcourse.professionalTitleName='" + mcoursemodel.getProfessionalTitleName()+"'";
		}
		//课程类型
		if (mcoursemodel.getCtype() != null && !"".equals(mcoursemodel.getCtype())) {
			mcoursemodel.setCtype(java.net.URLDecoder.decode(mcoursemodel.getCtype(),"UTF-8"));
			hql += " and mcourse.ctype='" + mcoursemodel.getCtype()+"'";
		}
		// 专业
		if (mcoursemodel.getMajorId() != null && !"".equals(mcoursemodel.getMajorId())&& !"%".equals(mcoursemodel.getMajorId())) {

			hql += " and mcourse.major.mno='" + mcoursemodel.getMajorId()+"'";
		}
		// 学院
		if (mcoursemodel.getDepartmentId() != null
				&& !"".endsWith(mcoursemodel.getDepartmentId())) {

			hql += " and mcourse.major.department.dno='" + mcoursemodel.getDepartmentId()+"'";
		}
		List<Majorcourse> list = (List<Majorcourse>) QueryUtilDaoImpl.executeQueryByPage(hql, null, mapParam, page, rows);
		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindMajorcourse(MajorcourseModel mcoursemodel) {
        int count;
		String hql = "select count(*) from Majorcourse as mcourse where "
			+ "mcourse.teacher.tno like :tno "+"and mcourse.teacher.tname like :tname ";
		Map mapParam = new HashMap();
		// 教师编号
		mapParam.put("tno", "%" + mcoursemodel.getTno()+ "%");
		//教师姓名
		mapParam.put("tname", "%" + mcoursemodel.getTname()+ "%");
		//年份
		if(mcoursemodel.getId()!=null&&!"".equals(mcoursemodel.getId())){
			
			hql+=" and mcourse.course.cno= "+mcoursemodel.getId();
		}
		//年份
		if(mcoursemodel.getYear()!=null&&!"".equals(mcoursemodel.getYear())){
			
			hql+=" and mcourse.year= "+mcoursemodel.getYear();
		}		
		//学期
		if (mcoursemodel.getOpenSemester() != null && !"".equals(mcoursemodel.getOpenSemester())) {
			hql += " and mcourse.openSemester='" + mcoursemodel.getOpenSemester()+"'";
		}
		//职称
		if (mcoursemodel.getProfessionalTitleName() != null && !"".equals(mcoursemodel.getProfessionalTitleName())) {
			hql += " and mcourse.professionalTitleName='" + mcoursemodel.getProfessionalTitleName()+"'";
		}
		//课程类型
		if (mcoursemodel.getCtype() != null && !"".equals(mcoursemodel.getCtype())) {

			hql += " and mcourse.ctype='" + mcoursemodel.getCtype()+"'";
		}
		// 专业
		if (mcoursemodel.getMajorId() != null && !"".equals(mcoursemodel.getMajorId()) && !"%".equals(mcoursemodel.getMajorId())) {

			hql += " and mcourse.major.mno='" + mcoursemodel.getMajorId()+"'";
		}
		// 学院
		if (mcoursemodel.getDepartmentId() != null
				&& !"".endsWith(mcoursemodel.getDepartmentId())) {

			hql += " and mcourse.major.department.dno='" + mcoursemodel.getDepartmentId()+"'";
		}
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count========="+count);
		return count;
	}
	// 查询结果条
	public int count(String mno,String dno)
			throws ServiceException {
		int count=0;	
		String hql="";
		if(!mno.equals("000000")){
			hql="select count(*) from Majorcourse as mcourse where mcourse.major.mno=?";
			String param[]={mno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="select count(*) from Majorcourse as mcourse where mcourse.major.department.dno=?";
			String param[]={dno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			
		}else{
			hql="select count(*) from Majorcourse";
			
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);		
		}
		return count;
	}
}
