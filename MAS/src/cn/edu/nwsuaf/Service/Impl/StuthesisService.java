package cn.edu.nwsuaf.Service.Impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.edu.nwsuaf.Model.StuthesisModel;
import cn.edu.nwsuaf.bean.Stuthesis;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class StuthesisService extends BaseServiceImpl<Stuthesis> {
	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() {
		String hql = "SELECT DISTINCT stut.year FROM Stuthesis AS stut ORDER BY stut.year ASC";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("年份=============" + list.size());
		return list;
	}

	// 返回发表期刊列表
	@SuppressWarnings("unchecked")
	public List<String> findJournalList() {
		String hql = "SELECT DISTINCT stut.journal FROM Stuthesis AS stut ORDER BY stut.journal ";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("发表期刊=============" + list.size());
		return list;
	}

	// 初始化获取list
	@SuppressWarnings("unchecked")
	public List<Stuthesis> findallStuthesisList(int page, int rows,String mno,String dno) {

		String hql = "";
		List<Stuthesis> list = null;
		if(!mno.equals("000000")){
			System.out.println(mno);
			hql="from Stuthesis as stut where stut.student.major.mno=?";
			String param[]={mno};
			list = (List<Stuthesis>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Stuthesis as stut where stut.student.major.department.dno=?";
			String param[]={dno};
			list = (List<Stuthesis>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Stuthesis";
			
			list = (List<Stuthesis>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii==="+list.size());
			
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Stuthesis> exportList(StuthesisModel stutmodel) throws UnsupportedEncodingException {
		String hql = "from Stuthesis as stut where "
				+ "stut.comName like :com "
				+ "and stut.student.stuName like :sname";
		Map mapParam = new HashMap();
		// 论文名称
		stutmodel.setComName(java.net.URLDecoder.decode(stutmodel.getComName(),"UTF-8"));
		mapParam.put("com", "%" + stutmodel.getComName() + "%");
		// 姓名
		stutmodel.setName(java.net.URLDecoder.decode(stutmodel.getName(),"UTF-8"));
		mapParam.put("sname", "%" + stutmodel.getName() + "%");
		// 年份
		if (stutmodel.getYear() != null && !"".equals(stutmodel.getYear())) {

			hql += " and stut.year= " + stutmodel.getYear();
		}
		// 学号
		if (stutmodel.getId() != null && !"".equals(stutmodel.getId())) {
			System.out.println(stutmodel.getId());
			hql += " and stut.student.stuNumber='" + stutmodel.getId() + "'";
		}
		// 发表期刊
		if (stutmodel.getJournal() != null
				&& !"".equals(stutmodel.getJournal())) {
			stutmodel.setJournal(java.net.URLDecoder.decode(stutmodel.getJournal(),"UTF-8"));
			hql += " and stut.journal='" + stutmodel.getJournal() + "'";
		}
		// 论文类型
		if (stutmodel.getJournalType() != null
				&& !"".equals(stutmodel.getJournalType())) {
			stutmodel.setJournalType(java.net.URLDecoder.decode(stutmodel.getJournalType(),"UTF-8"));
			hql += " and stut.journalType='" + stutmodel.getJournalType() + "'";
		}
		// 专业
		if (stutmodel.getMajorId() != null
				&& !"".equals(stutmodel.getMajorId())&& !"%".equals(stutmodel.getMajorId())) {

			hql += " and stut.student.major.mno='" + stutmodel.getMajorId()
					+ "'";
		}
		// 学院
		if (stutmodel.getDepartmentId() != null
				&& !"".endsWith(stutmodel.getDepartmentId())) {

			hql += " and stut.student.major.department.dno='"
					+ stutmodel.getDepartmentId() + "'";
		}
		List<Stuthesis> list = (List<Stuthesis>) QueryUtilDaoImpl.executeQuery(
				hql, null, mapParam);
		System.out.println("export"+list.size()+list.toString());
		return list;
	}

	@SuppressWarnings("unchecked")
	// 多条件查询（学号号、论文名称、专业、学院）
	public List<Stuthesis> findStuthesisList(StuthesisModel stutmodel,
			int page, int rows) throws UnsupportedEncodingException {

		String hql = "from Stuthesis as stut where "
				+ "stut.comName like :com "
				+ "and stut.student.stuName like :sname";
		Map mapParam = new HashMap();
		// 论文名称
		stutmodel.setComName(java.net.URLDecoder.decode(stutmodel.getComName(),"UTF-8"));
		mapParam.put("com", "%" + stutmodel.getComName() + "%");
		// 姓名
		stutmodel.setName(java.net.URLDecoder.decode(stutmodel.getName(),"UTF-8"));
		mapParam.put("sname", "%" + stutmodel.getName() + "%");
		// 年份
		if (stutmodel.getYear() != null && !"".equals(stutmodel.getYear())) {

			hql += " and stut.year= " + stutmodel.getYear();
		}
		// 学号
		if (stutmodel.getId() != null && !"".equals(stutmodel.getId())) {
			System.out.println(stutmodel.getId());
			hql += " and stut.student.stuNumber='" + stutmodel.getId() + "'";
		}
		// 发表期刊
		if (stutmodel.getJournal() != null
				&& !"".equals(stutmodel.getJournal())) {
			stutmodel.setJournal(java.net.URLDecoder.decode(stutmodel.getJournal(),"UTF-8"));
			hql += " and stut.journal='" + stutmodel.getJournal() + "'";
		}
		// 论文类型
		if (stutmodel.getJournalType() != null
				&& !"".equals(stutmodel.getJournalType())) {
			stutmodel.setJournalType(java.net.URLDecoder.decode(stutmodel.getJournalType(),"UTF-8"));
			hql += " and stut.journalType='" + stutmodel.getJournalType() + "'";
		}
		// 专业
		if (stutmodel.getMajorId() != null
				&& !"".equals(stutmodel.getMajorId())&& !"%".equals(stutmodel.getMajorId())) {

			hql += " and stut.student.major.mno='" + stutmodel.getMajorId()
					+ "'";
		}
		// 学院
		if (stutmodel.getDepartmentId() != null
				&& !"".endsWith(stutmodel.getDepartmentId())) {

			hql += " and stut.student.major.department.dno='"
					+ stutmodel.getDepartmentId() + "'";
		}
		List<Stuthesis> list = (List<Stuthesis>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindStuthesis(StuthesisModel stutmodel) throws UnsupportedEncodingException {
		int count;
		String hql = "select count(*) from Stuthesis as stut where "
				+ "stut.comName like :com "
				+ "and stut.student.stuName like :sname";
		Map mapParam = new HashMap();
		// 论文名称
		stutmodel.setComName(java.net.URLDecoder.decode(stutmodel.getComName(),"UTF-8"));
		mapParam.put("com", "%" + stutmodel.getComName() + "%");
		// 姓名
		stutmodel.setName(java.net.URLDecoder.decode(stutmodel.getName(),"UTF-8"));
		mapParam.put("sname", "%" + stutmodel.getName() + "%");
		// 年份
		if (stutmodel.getYear() != null && !"".equals(stutmodel.getYear())) {

			hql += " and stut.year= " + stutmodel.getYear();
		}
		// 学号
		if (stutmodel.getId() != null && !"".equals(stutmodel.getId())) {
			System.out.println(stutmodel.getId());
			hql += " and stut.student.stuNumber='" + stutmodel.getId() + "'";
		}
		// 发表期刊
		if (stutmodel.getJournal() != null
				&& !"".equals(stutmodel.getJournal())) {
			stutmodel.setJournal(java.net.URLDecoder.decode(stutmodel.getJournal(),"UTF-8"));
			hql += " and stut.journal='" + stutmodel.getJournal() + "'";
		}
		// 论文类型
		if (stutmodel.getJournalType() != null
				&& !"".equals(stutmodel.getJournalType())) {
			stutmodel.setJournalType(java.net.URLDecoder.decode(stutmodel.getJournalType(),"UTF-8"));
			hql += " and stut.journalType='" + stutmodel.getJournalType() + "'";
		}
		// 专业
		if (stutmodel.getMajorId() != null
				&& !"".equals(stutmodel.getMajorId())&& !"%".equals(stutmodel.getMajorId())) {

			hql += " and stut.student.major.mno='" + stutmodel.getMajorId()
					+ "'";
		}
		// 学院
		if (stutmodel.getDepartmentId() != null
				&& !"".endsWith(stutmodel.getDepartmentId())) {

			hql += " and stut.student.major.department.dno='"
					+ stutmodel.getDepartmentId() + "'";
		}
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=========" + count);
		return count;
	}
	// 查询结果条
	public int count(String mno,String dno)
			throws ServiceException {
		int count=0;	
		String hql="";
		if(!mno.equals("000000")){
			hql="select count(*) from Stuthesis as stut where stut.student.major.mno=?";
			String param[]={mno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="select count(*) from Stuthesis as stut where stut.student.major.department.dno=?";
			String param[]={dno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			
		}else{
			hql="select count(*) from Stuthesis";
			
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
			
		}
		return count;

	}
}
