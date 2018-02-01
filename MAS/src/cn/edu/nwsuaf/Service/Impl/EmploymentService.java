package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.edu.nwsuaf.Model.EmploymentModel;
import cn.edu.nwsuaf.bean.Employment;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class EmploymentService extends BaseServiceImpl<Employment> {
	
	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() {
		String hql = "SELECT DISTINCT emp.year FROM Employment AS emp ORDER BY emp.year ASC";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("年份=============" + list.size());
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Employment> findallEmploymentList(int page, int rows, String mno,String dno) {
		String hql = "";
		List<Employment> list = null;
		if(!mno.equals("000000")){
			hql="from Employment as emp where emp.major.mno=?";
			String param[]={mno};
			list = (List<Employment>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Employment as emp where emp.major.department.dno=?";
			String param[]={dno};
			list = (List<Employment>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Employment";
			
			list = (List<Employment>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()==="+list.size());
			
		}
		return list;
	}
	//导出
	@SuppressWarnings("unchecked")
	public List<Employment> exportallEmploymentList(EmploymentModel empmodel) {

		String hql = "from Employment as emp where emp.year like :tpn";
		System.out.println("Service===Employmentyear=="
				+ empmodel.getYear());
		Map mapParam = new HashMap();
		// 年份
		mapParam.put("tpn", "%" + empmodel.getYear() + "%");

		// 毕业人数大于
		if (empmodel.getLittlegraduCount()!= null && empmodel.getLittlegraduCount() >= 0 && !"".equals(empmodel.getLittlegraduCount())) {
			hql += " and emp.graduCount>="+empmodel.getLittlegraduCount();
		}
		// 毕业人数小于
		if(empmodel.getBiggraduCount()!= null && empmodel.getBiggraduCount()>=empmodel.getLittlegraduCount() && !"".equals(empmodel.getBiggraduCount())){
			hql += " and emp.graduCount<="+empmodel.getBiggraduCount();
		}
		// 初次就业人数大于
		if (empmodel.getLittlefempCount()!= null && empmodel.getLittlefempCount() >= 0 && !"".equals(empmodel.getLittlefempCount())) {
			hql += " and emp.fempCount>="+empmodel.getLittlefempCount();
		}
		// 初次就业人数小于
		if(empmodel.getBigfempCount()!= null && empmodel.getBigfempCount()>=empmodel.getLittlefempCount() && !"".equals(empmodel.getBigfempCount())){
			hql += " and emp.fempCount<="+empmodel.getBigfempCount();
		}
		// 就业人数大于
		
		if (empmodel.getLittleempCount()!= null && empmodel.getLittleempCount() >= 0 && !"".equals(empmodel.getLittleempCount()) ) {
			hql += " and emp.empCount>="+empmodel.getLittleempCount();
		}
		// 就业人数小于
		if(empmodel.getBigempCount()!= null && empmodel.getBigempCount()>=empmodel.getLittleempCount() && !"".equals(empmodel.getBigempCount())){
			hql += " and emp.empCount<="+empmodel.getBigempCount();
		}
		// 专业
		if (empmodel.getMajorId() != null && !"".equals(empmodel.getMajorId())&& !"%".equals(empmodel.getMajorId())) {

			hql += " and emp.major.mno='" + empmodel.getMajorId()+"'";
		}
		// 学院
		if (empmodel.getDepartmentId() != null
				&& !"".endsWith(empmodel.getDepartmentId())) {

			hql += " and emp.major.department.dno='"
					+ empmodel.getDepartmentId()+"'";
		}
		System.out.println(hql);
		List<Employment> list = (List<Employment>) QueryUtilDaoImpl
				.executeQuery(hql, null, mapParam);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	// 多条件查询
	public List<Employment> findEmploymentList(
			EmploymentModel empmodel, int page, int rows) {

		String hql = "from Employment as emp where emp.year like :tpn";
		System.out.println("Service===Employmentyear=="
				+ empmodel.getYear());
		Map mapParam = new HashMap();
		// 年份
		mapParam.put("tpn", "%" + empmodel.getYear() + "%");

		// 毕业人数大于
		if (empmodel.getLittlegraduCount()!= null && empmodel.getLittlegraduCount() >= 0 && !"".equals(empmodel.getLittlegraduCount())) {
			hql += " and emp.graduCount>="+empmodel.getLittlegraduCount();
		}
		// 毕业人数小于
		if(empmodel.getBiggraduCount()!= null && empmodel.getBiggraduCount()>=empmodel.getLittlegraduCount() && !"".equals(empmodel.getBiggraduCount())){
			hql += " and emp.graduCount<="+empmodel.getBiggraduCount();
		}
		// 初次就业人数大于
		if (empmodel.getLittlefempCount()!= null && empmodel.getLittlefempCount() >= 0 && !"".equals(empmodel.getLittlefempCount())) {
			hql += " and emp.fempCount>="+empmodel.getLittlefempCount();
		}
		// 初次就业人数小于
		if(empmodel.getBigfempCount()!= null && empmodel.getBigfempCount()>=empmodel.getLittlefempCount() && !"".equals(empmodel.getBigfempCount())){
			hql += " and emp.fempCount<="+empmodel.getBigfempCount();
		}
		// 就业人数大于
		
		if (empmodel.getLittleempCount()!= null && empmodel.getLittleempCount() >= 0 && !"".equals(empmodel.getLittleempCount()) ) {
			hql += " and emp.empCount>="+empmodel.getLittleempCount();
		}
		// 就业人数小于
		if(empmodel.getBigempCount()!= null && empmodel.getBigempCount()>=empmodel.getLittleempCount() && !"".equals(empmodel.getBigempCount())){
			hql += " and emp.empCount<="+empmodel.getBigempCount();
		}
		// 专业
		if (empmodel.getMajorId() != null && !"".equals(empmodel.getMajorId())&& !"%".equals(empmodel.getMajorId())) {

			hql += " and emp.major.mno='" + empmodel.getMajorId()+"'";
		}
		// 学院
		if (empmodel.getDepartmentId() != null
				&& !"".endsWith(empmodel.getDepartmentId())) {

			hql += " and emp.major.department.dno='"
					+ empmodel.getDepartmentId()+"'";
		}
		System.out.println(hql);
		List<Employment> list = (List<Employment>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);

		/*
		 * for (Employment t : list) {
		 * 
		 * System.out.println(t.getTno() + t.getTname() +
		 * t.getMajor().getMname()); }
		 */
		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindEmployment(EmploymentModel empmodel) {
		int count;

		String hql = "select count(*) from Employment as emp where emp.year like :tpn";
		System.out.println("Service===Employmentyear=="
				+ empmodel.getYear());
		Map mapParam = new HashMap();
		// 年份
		mapParam.put("tpn", "%" + empmodel.getYear() + "%");

		// 毕业人数大于
		if (empmodel.getLittlegraduCount()!= null && empmodel.getLittlegraduCount() >= 0 && !"".equals(empmodel.getLittlegraduCount())) {
			hql += " and emp.graduCount>="+empmodel.getLittlegraduCount();
		}
		// 毕业人数小于
		if(empmodel.getBiggraduCount()!= null && empmodel.getBiggraduCount()>=empmodel.getLittlegraduCount() && !"".equals(empmodel.getBiggraduCount())){
			hql += " and emp.graduCount<="+empmodel.getBiggraduCount();
		} 
		// 初次就业人数大于
		if (empmodel.getLittlefempCount()!= null && empmodel.getLittlefempCount() >= 0 && !"".equals(empmodel.getLittlefempCount())) {
			hql += " and emp.fempCount>="+empmodel.getLittlefempCount();
		}
		// 初次就业人数小于
		if(empmodel.getBigfempCount()!= null && empmodel.getBigfempCount()>=empmodel.getLittlefempCount() && !"".equals(empmodel.getBigfempCount())){
			hql += " and emp.fempCount<="+empmodel.getBigfempCount();
		}
		// 就业人数大于
		
		if (empmodel.getLittleempCount()!= null && empmodel.getLittleempCount() >= 0 && !"".equals(empmodel.getLittleempCount()) ) {
			hql += " and emp.empCount>="+empmodel.getLittleempCount();
		}
		// 就业人数小于
		if(empmodel.getBigempCount()!= null && empmodel.getBigempCount()>=empmodel.getLittleempCount() && !"".equals(empmodel.getBigempCount())){
			hql += " and emp.empCount<="+empmodel.getBigempCount();
		}
		// 专业
		if (empmodel.getMajorId() != null && !"".equals(empmodel.getMajorId())&& !"%".equals(empmodel.getMajorId())) {

			hql += " and emp.major.mno='" + empmodel.getMajorId()+"'";
		}
		// 学院
		if (empmodel.getDepartmentId() != null
				&& !"".endsWith(empmodel.getDepartmentId())) {

			hql += " and emp.major.department.dno='"
					+ empmodel.getDepartmentId()+"'";
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
			hql="select count(*) from Employment as emp where emp.major.mno=?";
			String param[]={mno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="select count(*) from Employment as emp where emp.major.department.dno=?";
			String param[]={dno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			
		}else{
			hql="select count(*) from Employment";
			
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
			
		}
		return count;

	}
}
