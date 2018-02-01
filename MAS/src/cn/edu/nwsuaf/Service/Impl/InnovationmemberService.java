package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.bean.Innovationmember;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;

public class InnovationmemberService extends BaseServiceImpl<Innovationmember> {
	// 多条件查询
	@SuppressWarnings("unchecked")
	public List<Innovationmember> findIMList(Innovationmember innovationmember,
			int page, int rows, String innoNumber) {
		String hql = "from Innovationmember as IM where "
				+ "IM.innovationproject.innoNumber like :iN order by IM.rank asc";
		Map mapParam = new HashMap();
		// 专利名称
		mapParam.put("iN", innoNumber );

		List<Innovationmember> list = (List<Innovationmember>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		System.out.println(list.toString());
		return list;
	}

	// 查询结果条数
	@SuppressWarnings( { "unchecked" })
	public int countFindIM(Innovationmember teachBook, String innoNumber) {
		int count = 0;
		String hql = "select count(*) from Innovationmember as IM where "
				+ "IM.innovationproject.innoNumber like :iN";
		Map mapParam = new HashMap();
		// 专利名称
		mapParam.put("iN", "%" + innoNumber + "%");

		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=======" + count);
		return count;

	}


	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() {
		String hql = "SELECT DISTINCT IM.year FROM Innovationmember AS IM";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("年份=============" + list.size());
		return list;
	}
	// 导出
	@SuppressWarnings("unchecked")
	public List<Innovationmember> exportInberList(
			Innovationmember innovationmember, String innoNumber) {
		String hql = "from Innovationmember as sp where sp.innovationproject.innoNumber like :an";

		Map mapParam = new HashMap();
		// 编号
		mapParam.put("an", "%" + innoNumber + "%");
		List<Innovationmember> list = (List<Innovationmember>) QueryUtilDaoImpl
				.executeQuery(hql, null, mapParam);
		System.out.println("list=========" + list.toString());
		return list;
	}

}
