package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.AddmissionsModel;
import cn.edu.nwsuaf.bean.Addmissions;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class AddmissionsService extends BaseServiceImpl<Addmissions> {
	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() {
		String hql = "SELECT DISTINCT adm.addmYear FROM Addmissions AS adm ORDER BY adm.addmYear ASC";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("年份=============" + list.size());
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Addmissions> findallAddmissionsList(int page, int rows, String mno,String dno) {
		String hql = "";
		List<Addmissions> list = null;
		if(!mno.equals("000000")){
			hql="from Addmissions as adm where adm.major.mno=?";
			String param[]={mno};
			list = (List<Addmissions>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Addmissions as adm where adm.major.department.dno=?";
			String param[]={dno};
			list = (List<Addmissions>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Addmissions";
			
			list = (List<Addmissions>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()==="+list.size());
			
		}
		return list;
	}
	//导出
	@SuppressWarnings("unchecked")
	public List<Addmissions> exportallAddmissionsList(AddmissionsModel admmodel) {

		String hql = "from Addmissions as adm where adm.addmYear like :tpn";
		System.out.println("Service===Addmissionsyear==" + admmodel.getYear());
		Map mapParam = new HashMap();
		// 年份
		mapParam.put("tpn", "%" + admmodel.getYear() + "%");

		// 计划人数大于
		if (admmodel.getLittleexpectCount() !=null
				&& admmodel.getLittleexpectCount() >= 0
				&& !"".equals(admmodel.getLittleexpectCount())) {
			hql += " and adm.expectCount>=" + admmodel.getLittleexpectCount();
		}
		// 计划人数小于
		if (admmodel.getBigexpectCount() != null
				&& admmodel.getBigexpectCount() >= admmodel
						.getLittleexpectCount()
				&& !"".equals(admmodel.getBigexpectCount())) {
			hql += " and adm.expectCount<=" + admmodel.getBigexpectCount();
		}
		// 招生人数大于
		if (admmodel.getLittleaddmCount() != null
				&& admmodel.getLittleaddmCount() >= 0
				&& !"".equals(admmodel.getLittleaddmCount())) {
			hql += " and adm.addmCount>=" + admmodel.getLittleaddmCount();
		}
		// 招生人数小于
		if (admmodel.getBigaddmCount() != null
				&& admmodel.getBigaddmCount() >= admmodel.getLittleaddmCount()
				&& !"".equals(admmodel.getBigaddmCount())) {
			hql += " and adm.addmCount<=" + admmodel.getBigaddmCount();
		}
		// 入学平均分大于

		if (admmodel.getLittleentranceEverage() != null
				&& admmodel.getLittleentranceEverage() >= 0
				&& !"".equals(admmodel.getLittleentranceEverage())) {
			hql += " and adm.entranceEverage>="
					+ admmodel.getLittleentranceEverage();
		}
		// 入学平均分小于
		if (admmodel.getBigentranceEverage() != null
				&& admmodel.getBigentranceEverage() >= admmodel
						.getLittleentranceEverage()
				&& !"".equals(admmodel.getBigentranceEverage())) {
			hql += " and adm.entranceEverage<="
					+ admmodel.getBigentranceEverage();
		}
		// 专业
		if (admmodel.getMajorId() != null && !"".equals(admmodel.getMajorId())&& !"%".equals(admmodel.getMajorId())) {

			hql += " and adm.major.mno='" + admmodel.getMajorId() + "'";
		}
		// 学院
		if (admmodel.getDepartmentId() != null
				&& !"".endsWith(admmodel.getDepartmentId())) {

			hql += " and adm.major.department.dno='"
					+ admmodel.getDepartmentId() + "'";
		}
		System.out.println(hql);
		List<Addmissions> list = (List<Addmissions>) QueryUtilDaoImpl.executeQuery(hql, null, mapParam);
		return list;

	}
	
	@SuppressWarnings("unchecked")
	// 多条件查询
	public List<Addmissions> findAddmissionsList(AddmissionsModel admmodel,
			int page, int rows) {

		String hql = "from Addmissions as adm where adm.addmYear like :tpn";
		System.out.println("Service===Addmissionsyear==" + admmodel.getYear());
		Map mapParam = new HashMap();
		// 年份
		mapParam.put("tpn", "%" + admmodel.getYear() + "%");

		// 计划人数大于
		if (admmodel.getLittleexpectCount() !=null
				&& admmodel.getLittleexpectCount() >= 0
				&& !"".equals(admmodel.getLittleexpectCount())) {
			hql += " and adm.expectCount>=" + admmodel.getLittleexpectCount();
		}
		// 计划人数小于
		if (admmodel.getBigexpectCount() != null
				&& admmodel.getBigexpectCount() >= admmodel
						.getLittleexpectCount()
				&& !"".equals(admmodel.getBigexpectCount())) {
			hql += " and adm.expectCount<=" + admmodel.getBigexpectCount();
		}
		// 招生人数大于
		if (admmodel.getLittleaddmCount() != null
				&& admmodel.getLittleaddmCount() >= 0
				&& !"".equals(admmodel.getLittleaddmCount())) {
			hql += " and adm.addmCount>=" + admmodel.getLittleaddmCount();
		}
		// 招生人数小于
		if (admmodel.getBigaddmCount() != null
				&& admmodel.getBigaddmCount() >= admmodel.getLittleaddmCount()
				&& !"".equals(admmodel.getBigaddmCount())) {
			hql += " and adm.addmCount<=" + admmodel.getBigaddmCount();
		}
		// 入学平均分大于

		if (admmodel.getLittleentranceEverage() != null
				&& admmodel.getLittleentranceEverage() >= 0
				&& !"".equals(admmodel.getLittleentranceEverage())) {
			hql += " and adm.entranceEverage>="
					+ admmodel.getLittleentranceEverage();
		}
		// 入学平均分小于
		if (admmodel.getBigentranceEverage() != null
				&& admmodel.getBigentranceEverage() >= admmodel
						.getLittleentranceEverage()
				&& !"".equals(admmodel.getBigentranceEverage())) {
			hql += " and adm.entranceEverage<="
					+ admmodel.getBigentranceEverage();
		}
		// 专业
		if (admmodel.getMajorId() != null && !"".equals(admmodel.getMajorId())&& !"%".equals(admmodel.getMajorId())) {

			hql += " and adm.major.mno='" + admmodel.getMajorId() + "'";
		}
		// 学院
		if (admmodel.getDepartmentId() != null
				&& !"".endsWith(admmodel.getDepartmentId())) {

			hql += " and adm.major.department.dno='"
					+ admmodel.getDepartmentId() + "'";
		}
		System.out.println(hql);
		List<Addmissions> list = (List<Addmissions>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindAddmissions(AddmissionsModel admmodel) {
		int count;

		String hql = "select count(*) from Addmissions as adm where adm.addmYear like :tpn";
		System.out.println("Service===Addmissionsyear==" + admmodel.getYear());
		Map mapParam = new HashMap();
		// 年份
		mapParam.put("tpn", "%" + admmodel.getYear() + "%");

		// 计划人数大于
		if (admmodel.getLittleexpectCount() != null
				&& admmodel.getLittleexpectCount() >= 0
				&& !"".equals(admmodel.getLittleexpectCount())) {
			hql += " and adm.expectCount>=" + admmodel.getLittleexpectCount();
		}
		// 计划人数小于
		if (admmodel.getBigexpectCount() != null
				&& admmodel.getBigexpectCount() >= admmodel
						.getLittleexpectCount()
				&& !"".equals(admmodel.getBigexpectCount())) {
			hql += " and adm.expectCount<=" + admmodel.getBigexpectCount();
		}
		// 招生人数大于
		if (admmodel.getLittleaddmCount() != null
				&& admmodel.getLittleaddmCount() >= 0
				&& !"".equals(admmodel.getLittleaddmCount())) {
			hql += " and adm.addmCount>=" + admmodel.getLittleaddmCount();
		}
		// 招生人数小于
		if (admmodel.getBigaddmCount() != null
				&& admmodel.getBigaddmCount() >= admmodel.getLittleaddmCount()
				&& !"".equals(admmodel.getBigaddmCount())) {
			hql += " and adm.addmCount<=" + admmodel.getBigaddmCount();
		}
		// 入学平均分大于

		if (admmodel.getLittleentranceEverage() != null
				&& admmodel.getLittleentranceEverage() >= 0
				&& !"".equals(admmodel.getLittleentranceEverage())) {
			hql += " and adm.entranceEverage>="
					+ admmodel.getLittleentranceEverage();
		}
		// 入学平均分小于
		if (admmodel.getBigentranceEverage() != null
				&& admmodel.getBigentranceEverage() >= admmodel
						.getLittleentranceEverage()
				&& !"".equals(admmodel.getBigentranceEverage())) {
			hql += " and adm.entranceEverage<="
					+ admmodel.getBigentranceEverage();
		}
		// 专业
		if (admmodel.getMajorId() != null && !"".equals(admmodel.getMajorId())&& !"%".equals(admmodel.getMajorId())) {

			hql += " and adm.major.mno='" + admmodel.getMajorId() + "'";
		}
		// 学院
		if (admmodel.getDepartmentId() != null
				&& !"".endsWith(admmodel.getDepartmentId())) {

			hql += " and adm.major.department.dno='"
					+ admmodel.getDepartmentId() + "'";
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
			hql="select count(*) from Addmissions as adm where adm.major.mno=?";
			String param[]={mno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="select count(*) from Addmissions as adm where adm.major.department.dno=?";
			String param[]={dno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			
		}else{
			hql="select count(*) from Addmissions";
			
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
			
		}
		return count;

	}
}
