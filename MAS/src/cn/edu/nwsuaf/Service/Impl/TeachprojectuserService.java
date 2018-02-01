package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import cn.edu.nwsuaf.bean.Teachprojectuser;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;

public class TeachprojectuserService extends BaseServiceImpl<Teachprojectuser> {
	@SuppressWarnings( { "unchecked" })
	// 多条件查询
	public List<Teachprojectuser> findTPUList(Teachprojectuser teachprojectuser,int page, int rows, String tprojectNo) {
		String hql = "from Teachprojectuser as tpu where "
				+ "tpu.teachproject.tprojectNo like :tpn order by tpu.rank ASC";
		Map mapParam = new HashMap();
		// 专利名称
		mapParam.put("tpn",tprojectNo);

		List<Teachprojectuser> list = (List<Teachprojectuser>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		System.out.println(list.toString());
		return list;
	}

	// 查询结果条数
	@SuppressWarnings( { "unchecked" })
	public int countFindTBook(Teachprojectuser teachprojectuser, String tprojectNo) {
		int count = 0;
		String hql = "select count(*) from Teachprojectuser as tpu where "
				+ "tpu.teachproject.tprojectNo like :tpn";
		Map mapParam = new HashMap();
		// 专利名称
		mapParam.put("tpn",tprojectNo);

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
		String hql = "SELECT DISTINCT tp.year FROM Teachprojectuser AS tp";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("年份=============" + list.size());
		return list;
	}
	// 导出
	@SuppressWarnings("unchecked")
	public List<Teachprojectuser> exportInberList(
			Teachprojectuser teachprojectuser, String tprojectNo) {
		String hql = "from Teachprojectuser as sp where sp.teachproject.tprojectNo ='"+tprojectNo+"'";
		List<Teachprojectuser> list = (List<Teachprojectuser>) QueryUtilDaoImpl.executeQuery(hql, null, null);
		System.out.println("list=========" + list.size());
		return list;
	}
}
