package cn.edu.nwsuaf.Service.Impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import cn.edu.nwsuaf.Model.InnovationModel;
import cn.edu.nwsuaf.bean.Innovationproject;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class InnovationprojectService extends
		BaseServiceImpl<Innovationproject> {
	//分页查找所有的……
	@SuppressWarnings("unchecked")
	public List<Innovationproject> findallCompetitionList(int page, int rows, String mno,String dno) {
		String hql = "";
		List<Innovationproject> list = null;
		if(!mno.equals("000000")){
			hql="from Innovationproject IP where IP.innoNumber in(select IPM.innovationproject.innoNumber from Innovationmember IPM where IPM.student.major.mno="+"'"+mno+"')";
			String param[]={mno};
			list = (List<Innovationproject>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Innovationproject IP where IP.innoNumber in(select IPM.innovationproject.innoNumber from Innovationmember IPM where IPM.student.major.department.dno='"+dno+"'"+")";
			String param[]={dno};
//			System.out.println("test！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！test");
//			System.out.println(param[0]);
			
			list = (List<Innovationproject>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
		}else{
			hql="from Innovationproject";
			
			list = (List<Innovationproject>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);

			
		}
		System.out.println("list.size()==="+list.size());
		return list;
	}
	//计算查询结果条数
	public int count(String mno, String dno) throws ServiceException {
		int count = 0;
		String hql = "";
		if (!mno.equals("000000")) {
			hql = "select count(*) from  Innovationproject IP where IP.innoNumber in(select IPM.innovationproject.innoNumber from Innovationmember IPM where IPM.student.major.mno="+"'"+mno+"')";
			String param[] = { mno };
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null);
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "select count(*) from Innovationproject IP where IP.innoNumber in(select IPM.innovationproject.innoNumber from Innovationmember IPM where IPM.student.major.department.dno='"+dno+"'"+")";
			String param[] = { dno };
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null);

		} else {
			hql = "select count(*) from Innovationproject";
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null);

		}
		return count;

	}
	@SuppressWarnings( { "unchecked" })
	// 多条件查询
	public List<Innovationproject> findIProjectsList(
			InnovationModel innovationModel, int page, int rows,String mno,String dno) throws UnsupportedEncodingException {
		String hql = "from Innovationproject as ip where "
				+ "ip.innoName like :inN";

		Map mapParam = new HashMap();
		System.out.println("项目名称"+innovationModel.getName());
		// 项目名称
		innovationModel.setName(java.net.URLDecoder.decode(innovationModel.getName(),"UTF-8"));
		mapParam.put("inN", "%" + innovationModel.getName() + "%");
		// 项目类型
		if (innovationModel.getType() != null
				&& !"".equals(innovationModel.getType())) {
			innovationModel.setType(java.net.URLDecoder.decode(innovationModel.getType(),"UTF-8"));
			hql += " and ip.type='"+ innovationModel.getType()+"'";
		}
		// 项目级别
		if (innovationModel.getLevel() != null
				&& !"".equals(innovationModel.getLevel())) {
			innovationModel.setLevel(java.net.URLDecoder.decode(innovationModel.getLevel(),"UTF-8"));
			hql += " and ip.level='"+innovationModel.getLevel()+"'";
		}
		
		if (!mno.equals("000000")) {
			hql += " and ip.innoNumber in(select IPM.innovationproject.innoNumber from Innovationmember IPM where IPM.student.major.mno="+"'"+mno+"')";
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql += " and ip.innoNumber in(select IPM.innovationproject.innoNumber from Innovationmember IPM where IPM.student.major.department.dno='"+dno+"'"+")";
		} else {
			hql += "";

		}
		
		
		List<Innovationproject> list = (List<Innovationproject>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		System.out.println("语句"+hql);
		return list;
	}

	// 查询结果条数
	@SuppressWarnings( { "unchecked" })
	public int countFindIProject(InnovationModel innovationModel ,String mno ,String dno) throws UnsupportedEncodingException {
		int count = 0;
		String hql = "select count(*) from Innovationproject as ip where "
				+ "ip.innoName like :inN";
		innovationModel.setName(java.net.URLDecoder.decode(innovationModel.getName(),"UTF-8"));
		Map mapParam = new HashMap();
		// 项目名称
		mapParam.put("inN", "%" + innovationModel.getName() + "%");
		// 项目类型
		if (innovationModel.getType() != null
				&& !"".equals(innovationModel.getType())) {
			innovationModel.setType(java.net.URLDecoder.decode(innovationModel.getType(),"UTF-8"));
			hql += " and ip.type='"+ innovationModel.getType()+"'";
		}
		// 项目级别
		if (innovationModel.getLevel() != null
				&& !"".equals(innovationModel.getLevel())) {
			innovationModel.setLevel(java.net.URLDecoder.decode(innovationModel.getLevel(),"UTF-8"));
			hql += " and ip.level='"+innovationModel.getLevel()+"'";
		}
		
		if (!mno.equals("000000")) {
			hql += " and ip.innoNumber in(select IPM.innovationproject.innoNumber from Innovationmember IPM where IPM.student.major.mno="+"'"+mno+"')";
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql += " and ip.innoNumber in(select IPM.innovationproject.innoNumber from Innovationmember IPM where IPM.student.major.department.dno='"+dno+"'"+")";
		} else {
			hql += "";

		}
		
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=======" + count);
		return count;

	}

	@SuppressWarnings("unchecked")
	public int isExist(String innoNumber) {

		int count = 0;
		String hql = "select count(*) from Innovationproject as a where "
				+ "a.innoNumber = :ci ";
		 Map mapParam = new HashMap();
		 // 获奖证书编号
		 mapParam.put("ci", innoNumber );

		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		return count;
	}
	
	@SuppressWarnings( { "unchecked" })
	// 导出
	public List<Innovationproject> exportIProjectsList(
			InnovationModel innovationModel) {
		String hql = "from Innovationproject as IP where "
				+ "IP.innoName like :inN";

		Map mapParam = new HashMap();
		// 项目名称
		mapParam.put("inN", "%" + innovationModel.getName() + "%");
		// 年份
		if (innovationModel.getYear() != null
				&& !"".equals(innovationModel.getYear())) {

			hql += " and IP.year like :inY";
			mapParam.put("inY", "%" + innovationModel.getYear()+ "%");
		}
		// 项目类型
		if (innovationModel.getType() != null
				&& !"".equals(innovationModel.getType())) {

			hql += " and IP.type like :inT";
			mapParam.put("inT", "%" + innovationModel.getType() + "%");
		}
		// 项目级别
		if (innovationModel.getLevel() != null
				&& !"".equals(innovationModel.getLevel())) {

			hql += " and IP.level like :inL";
			mapParam.put("inL", "%" + innovationModel.getLevel() + "%");
		}
		// 项目经费
		if (innovationModel.getCost() != null
				&& !"".equals(innovationModel.getCost())) {

			hql += " and IP.cost like :inC";
			mapParam.put("inC", "%" +  innovationModel.getCost() + "%");
		}
		// 立项时间
		if (innovationModel.getSetDate() != null
				&& !"".equals(innovationModel.getSetDate())) {
			hql += " and IP.setDate like :inSD";
			mapParam.put("inSD", "%" +  innovationModel.getSetDate() + "%");
		}
		// 结项时间
		if (innovationModel.getEndDate() != null
				&& !"".equals(innovationModel.getEndDate())) {
			hql += " and IP.endDate like :inED";
			mapParam.put("inED", "%" + innovationModel.getEndDate() + "%");
		}
		// 学院
		if (innovationModel.getDepartmentId() != null
				&& !"".equals(innovationModel.getDepartmentId())) {
			hql += " and IP.innoNumber in(select IPM.innovationproject.innoNumber from Innovationmember IPM where IPM.student.major.department.dno like :dn)";
			mapParam.put("dn", "%" + innovationModel.getDepartmentId() + "%");
		}
		// 专业
		if (innovationModel.getMajorId() != null
				&& !"".equals(innovationModel.getMajorId())) {
			hql += " and IP.innoNumber in(select IPM.innovationproject.innoNumber from Innovationmember IPM where IPM.student.major.mno like :mn)";
			mapParam.put("mn", "%" + innovationModel.getMajorId() + "%");
		}
		List<Innovationproject> list = (List<Innovationproject>) QueryUtilDaoImpl
				.executeQuery(hql, null, mapParam);
		System.out.println("list size============" + list.size());
		return list;
	}


	// 根据学院Id查专业，用于下拉列表====待完善
	public JSONArray findMajorByDno(String dno) {

		JSONArray jsonArray = QueryUtilDaoImpl.findMajorByDno(dno);
		return jsonArray;
	}

	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() {
		String hql = "SELECT DISTINCT IP.year FROM Innovationproject AS IP";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("年份=============" + list.size());
		return list;
	}

	// 返回级别
	@SuppressWarnings("unchecked")
	public List<String> findLevelList() {
		String hql = "SELECT DISTINCT IP.level FROM Innovationproject AS IP";
		List<String> list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		for(String l:list){
			
		}
		System.out.println("级别=============" + list.size());
		return list;
	}

	// 返回类别
	@SuppressWarnings("unchecked")
	public List<String> findTypeList() {
		String hql = "SELECT DISTINCT IP.type FROM Innovationproject AS IP";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("类别=============" + list.size());
		return list;
	}

	// 返回立项时间
	@SuppressWarnings("unchecked")
	public List<String> findSetDateList() {
		String hql = "SELECT DISTINCT IP.setDate FROM Innovationproject AS IP";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("立项时间=============" + list.size());
		return list;
	}

	// 返回结项时间
	@SuppressWarnings("unchecked")
	public List<String> findEndDateList() {
		String hql = "SELECT DISTINCT IP.endDate FROM Innovationproject AS IP";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("结项时间=============" + list.size());
		return list;
	}
}
