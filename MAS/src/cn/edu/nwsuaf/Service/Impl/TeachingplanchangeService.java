package cn.edu.nwsuaf.Service.Impl;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.edu.nwsuaf.Model.TeachingplanchangeModel;
import cn.edu.nwsuaf.bean.Teachingplanchange;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;



public class TeachingplanchangeService extends BaseServiceImpl<Teachingplanchange>{
	//返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList(){
		String hql = "SELECT DISTINCT tplan.year FROM Teachingplanchange AS tplan ORDER BY tplan.year ASC";
		List list= (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("年份============="+list.size());
		return list;
	}
	//返回年级列表
	@SuppressWarnings("unchecked")
	public List<String> findGradeList(){
		String hql = "SELECT DISTINCT tplan.grade FROM Teachingplanchange AS tplan ORDER BY tplan.grade ASC";
		List list= (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("年级============="+list.size());
		return list;
	}
	//初始化获取list
	@SuppressWarnings("unchecked")
	public List<Teachingplanchange> findallTplanchangeList(int page, int rows,String mno,String dno) {
		String hql = "";
		List<Teachingplanchange> list = null;
		if(!mno.equals("000000")){
			hql="from Teachingplanchange as tplan where tplan.major.mno=?";
			String param[]={mno};
			list = (List<Teachingplanchange>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Teachingplanchange as tplan where tplan.major.department.dno=?";
			String param[]={dno};
			list = (List<Teachingplanchange>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Teachingplanchange";
			
			list = (List<Teachingplanchange>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii==="+list.size());
			
		}

		return list;
	}
	//导出list
	@SuppressWarnings("unchecked")
	public List<Teachingplanchange> exportList(TeachingplanchangeModel tplanmodel) throws UnsupportedEncodingException{
		String hql = "from Teachingplanchange as tplan where " + "tplan.course.cno like :cno ";
		System.out.println("导出Service===TplanName=="+tplanmodel.getName());
		Map mapParam = new HashMap();
		// 课程编号
		mapParam.put("cno", "%" + tplanmodel.getId()+ "%");
		//年份
		if(tplanmodel.getYear()!=null&&!"".equals(tplanmodel.getYear())){
			
			hql+=" and tplan.year= "+tplanmodel.getYear();
		}		
		//年级
		if (tplanmodel.getGrade() != null && !"".equals(tplanmodel.getGrade())) {
			hql += " and tplan.grade='" + tplanmodel.getGrade()+"'";
		}
		//变动类型
		if (tplanmodel.getChangeType() != null && !"".equals(tplanmodel.getChangeType())) {
			tplanmodel.setChangeType(java.net.URLDecoder.decode(tplanmodel.getChangeType(),"UTF-8"));
			hql += " and tplan.changeType='" + tplanmodel.getChangeType()+"'";
		}
		//变更方式
		if (tplanmodel.getChangeMode() != null && !"".equals(tplanmodel.getChangeMode())) {
			tplanmodel.setChangeMode(java.net.URLDecoder.decode(tplanmodel.getChangeMode(),"UTF-8"));
			hql += " and tplan.changeMode='" + tplanmodel.getChangeMode()+"'";
		}
		//调整性质
		if (tplanmodel.getAdjustNature() != null && !"".equals(tplanmodel.getAdjustNature())) {

			hql += " and tplan.adjustNature=" + tplanmodel.getAdjustNature();
		}
		// 专业
		if (tplanmodel.getMajorId() != null && !"".equals(tplanmodel.getMajorId())&& !"%".equals(tplanmodel.getMajorId())) {

			hql += " and tplan.major.mno='" + tplanmodel.getMajorId()+"'";
		}
		// 学院
		if (tplanmodel.getDepartmentId() != null
				&& !"".endsWith(tplanmodel.getDepartmentId())) {

			hql += " and tplan.major.department.dno='" + tplanmodel.getDepartmentId()+"'";
		}
		List<Teachingplanchange> list = (List<Teachingplanchange>) QueryUtilDaoImpl.executeQuery(hql, null, mapParam);
		return list;
	}
	@SuppressWarnings("unchecked")
	// 多条件查询
	public List<Teachingplanchange> findTplanchangeList(TeachingplanchangeModel tplanmodel, int page, int rows) throws UnsupportedEncodingException {
		
		String hql = "from Teachingplanchange as tplan where " + "tplan.course.cno like :cno ";
		//System.out.println("Service===TplanName=="+tplanmodel.getName());
		Map mapParam = new HashMap();
		// 课程编号
		mapParam.put("cno", "%" + tplanmodel.getId()+ "%");
		//年份
		if(tplanmodel.getYear()!=null&&!"".equals(tplanmodel.getYear())){
			
			hql+=" and tplan.year= "+tplanmodel.getYear();
		}		
		//年级
		if (tplanmodel.getGrade() != null && !"".equals(tplanmodel.getGrade())) {
			hql += " and tplan.grade='" + tplanmodel.getGrade()+"'";
		}
		//变动类型
		if (tplanmodel.getChangeType() != null && !"".equals(tplanmodel.getChangeType())) {
			tplanmodel.setChangeType(java.net.URLDecoder.decode(tplanmodel.getChangeType(),"UTF-8"));
			hql += " and tplan.changeType='" + tplanmodel.getChangeType()+"'";
		}
		//变更方式
		if (tplanmodel.getChangeMode() != null && !"".equals(tplanmodel.getChangeMode())) {
			tplanmodel.setChangeMode(java.net.URLDecoder.decode(tplanmodel.getChangeMode(),"UTF-8"));
			hql += " and tplan.changeMode='" + tplanmodel.getChangeMode()+"'";
		}
		//调整性质
		if (tplanmodel.getAdjustNature() != null && !"".equals(tplanmodel.getAdjustNature())) {

			hql += " and tplan.adjustNature=" + tplanmodel.getAdjustNature();
		}
		// 专业
		if (tplanmodel.getMajorId() != null && !"".equals(tplanmodel.getMajorId())&& !"%".equals(tplanmodel.getMajorId())) {

			hql += " and tplan.major.mno='" + tplanmodel.getMajorId()+"'";
		}
		// 学院
		if (tplanmodel.getDepartmentId() != null
				&& !"".endsWith(tplanmodel.getDepartmentId())) {

			hql += " and tplan.major.department.dno='" + tplanmodel.getDepartmentId()+"'";
		}
		List<Teachingplanchange> list = (List<Teachingplanchange>) QueryUtilDaoImpl.executeQueryByPage(hql, null, mapParam, page, rows);
		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindTplan(TeachingplanchangeModel tplanmodel) {

		String hql = "select count(*) from Teachingplanchange as tplan where "
			+ "tplan.course.cno like :cno ";
		int count;
			//System.out.println("Service===TplanName=="+tplanmodel.getName());
			Map mapParam = new HashMap();
			// 课程编号
			mapParam.put("cno", "%" + tplanmodel.getId()+ "%");
		//年份
		if(tplanmodel.getYear()!=null&&!"".equals(tplanmodel.getYear())){
			
			hql+=" and tplan.year= "+tplanmodel.getYear();
		}		
		//年级
		if (tplanmodel.getGrade() != null && !"".equals(tplanmodel.getGrade())) {
			hql += " and tplan.grade='" + tplanmodel.getGrade()+"'";
		}
		//变动类型
		if (tplanmodel.getChangeType() != null && !"".equals(tplanmodel.getChangeType())) {
			hql += " and tplan.changeType='" + tplanmodel.getChangeType()+"'";
		}
		//变更方式
		if (tplanmodel.getChangeMode() != null && !"".equals(tplanmodel.getChangeMode())) {

			hql += " and tplan.changeMode='" + tplanmodel.getChangeMode()+"'";
		}
		//调整性质
		if (tplanmodel.getAdjustNature() != null && !"".equals(tplanmodel.getAdjustNature())) {

			hql += " and tplan.adjustNature=" + tplanmodel.getAdjustNature();
		}
		// 专业
		if (tplanmodel.getMajorId() != null && !"".equals(tplanmodel.getMajorId())&& !"%".equals(tplanmodel.getMajorId())) {

			hql += " and tplan.major.mno='" + tplanmodel.getMajorId()+"'";
		}
		// 学院
		if (tplanmodel.getDepartmentId() != null
				&& !"".endsWith(tplanmodel.getDepartmentId())) {

			hql += " and tplan.major.department.dno='" + tplanmodel.getDepartmentId()+"'";
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
			hql="select count(*) from  Teachingplanchange as tplan where tplan.major.mno=?";
			String param[]={mno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="select count(*) from Teachingplanchange as tplan where tplan.major.department.dno=?";
			String param[]={dno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			
		}else{
			hql="select count(*) from Teachingplanchange";
			
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
			
		}
		return count;

	}

}
