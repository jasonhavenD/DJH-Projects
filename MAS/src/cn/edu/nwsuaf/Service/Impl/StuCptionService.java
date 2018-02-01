package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import cn.edu.nwsuaf.bean.Studentcoepetition;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;



public class StuCptionService extends BaseServiceImpl<Studentcoepetition> {
	@SuppressWarnings("unchecked")
	// 查询
	public List<Studentcoepetition> findStuptionList(Studentcoepetition studentcoepetition,
			int page, int rows ,int comNumber) {
		String hql = "from Studentcoepetition as sp where sp.competition.comNumber = :an order by  sp.rank ASC";

		Map mapParam = new HashMap();
		// 编号
		mapParam.put("an",  comNumber);
		List<Studentcoepetition> list = (List<Studentcoepetition>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		System.out.println(list.toString());
		return list;

	}
	// 查询总条数
	@SuppressWarnings("unchecked")
	public int findStuption(Studentcoepetition studentcoepetition,int comNumber
			)
			{
		int count = 0;
		String hql = "select count(*) from Studentcoepetition as sp where sp.competition.comNumber = :an";

		Map mapParam = new HashMap();
		// 编号
		mapParam.put("an", comNumber);
		
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=========" + count);
		return count;

	}
	//导出
	@SuppressWarnings("unchecked")
	public List<Studentcoepetition> exportStuptionList(Studentcoepetition studentcoepetition,int comNumber) {
		String hql = "from Studentcoepetition as sp where sp.competition.comNumber = :an order by sp.rank";

		Map mapParam = new HashMap();
		// 编号
		mapParam.put("an", comNumber);
		List<Studentcoepetition> list = (List<Studentcoepetition>) QueryUtilDaoImpl
				.executeQuery(hql, null, mapParam);
		System.out.println("list========="+list.toString());
		return list;


	}


}
