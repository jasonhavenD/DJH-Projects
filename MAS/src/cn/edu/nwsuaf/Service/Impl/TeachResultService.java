package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import cn.edu.nwsuaf.bean.Teachresult;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;

public class TeachResultService extends BaseServiceImpl<Teachresult> {
	@SuppressWarnings( { "unchecked" })
	// 多条件查询
	public List<Teachresult> findTeaReList(Teachresult teachresult,int page, int rows, int tresultBaseNo) {
		String hql = "from Teachresult as tResult where "
				+ "tResult.teachresultbaseinfo.tresultBaseNo like :tbn order by tResult.tresultRank ASC";
		Map mapParam = new HashMap();
		// 专利名称
		mapParam.put("tbn",tresultBaseNo);

		List<Teachresult> list = (List<Teachresult>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		System.out.println(list.toString());
		return list;
	}

	// 查询结果条数
	@SuppressWarnings( { "unchecked" })
	public int countTeaRe(Teachresult teachresult, int tresultBaseNo) {
		int count = 0;
		String hql = "select count(*) from Teachresult as tResult where "
				+ "tResult.teachresultbaseinfo.tresultBaseNo like :tbn";
		Map mapParam = new HashMap();
		// 专利名称
		mapParam.put("tbn",tresultBaseNo);

		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=======" + count);
		return count;

	}

	// 根据学院Id查专业，用于下拉列表====待完善
	public JSONArray findMajorByDno(String dno) {

		JSONArray jsonArray = QueryUtilDaoImpl.findMajorByDno(dno);
		return jsonArray;
	}

	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() {
		String hql = "SELECT DISTINCT tResults.year FROM Teachresult AS tResults";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("年份=============" + list.size());
		return list;
	}
	// 导出
	@SuppressWarnings("unchecked")
	public List<Teachresult> exportInberList(
			Teachresult teachresult, int tresultBaseNo) {
		String hql = "from Teachresult as sp where sp.teachresultbaseinfo.tresultBaseNo ="+tresultBaseNo;

		List<Teachresult> list = (List<Teachresult>) QueryUtilDaoImpl
				.executeQuery(hql, null, null);
		System.out.println("list=========" + list.toString());
		return list;
	}
}
