package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.bean.Teachbook;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;

public class TeachBookService extends BaseServiceImpl<Teachbook> {
	@SuppressWarnings( { "unchecked" })
	// 多条件查询
	public List<Teachbook> findTBookList(Teachbook teachBook,int page, int rows, int tbno) {
		String hql = "from Teachbook as tBook where "
				+ "tBook.teachingbooks.tbno like :tbn order by tBook.authorRank ASC";
		Map mapParam = new HashMap();
		// 专利名称
		mapParam.put("tbn",tbno);

		List<Teachbook> list = (List<Teachbook>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		System.out.println(list.toString());
		return list;
	}

	// 查询结果条数
	@SuppressWarnings( { "unchecked" })
	public int countFindTBook(Teachbook teachBook, int tbno) {
		int count = 0;
		String hql = "select count(*) from Teachbook as tBook where "
				+ "tBook.teachingbooks.tbno like :tbn";
		Map mapParam = new HashMap();
		// 专利名称
		mapParam.put("tbn",tbno);

		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=======" + count);
		return count;

	}

	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() {
		String hql = "SELECT DISTINCT tBooks.year FROM Teachbook AS tBooks";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("年份=============" + list.size());
		return list;
	}
	// 导出
	@SuppressWarnings("unchecked")
	public List<Teachbook> exportTeaBList(
			Teachbook teachbook, int tbno) {
		String hql = "from Teachbook as sp where sp.teachingbooks.tbno ="+tbno;

		List<Teachbook> list = (List<Teachbook>) QueryUtilDaoImpl
				.executeQuery(hql, null, null);
		System.out.println("list=========" + list.toString());
		return list;
	}
}
