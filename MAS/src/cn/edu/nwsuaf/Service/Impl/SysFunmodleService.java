package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.SysfunmodleModel;
import cn.edu.nwsuaf.bean.Sysfunmodle;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;

public class SysFunmodleService extends BaseServiceImpl<Sysfunmodle> {
	//查找所有数据
	@SuppressWarnings("unchecked")
	public List<Sysfunmodle> findallSysfunmodleList(int page, int rows) {

		String hql = "from Sysfunmodle where funParentCode>5";
		List<Sysfunmodle> list = (List<Sysfunmodle>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, page, rows);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	// 多条件查询
	public List<Sysfunmodle> findSysfunmodleList(SysfunmodleModel funcmodel,
			int page, int rows) {

		String hql = "from Sysfunmodle as func where func.funModleCode like :tpn";
		Map mapParam = new HashMap();
		// 功能编号
		mapParam.put("tpn", "%" + funcmodel.getId() + "%");

		// 二级目录
		if (funcmodel.getPfun() != null && !"".equals(funcmodel.getPfun())) {
			hql += " and func.funParentCode=" + funcmodel.getPfun();
		}
		// 状态
		if (funcmodel.getState() != null && !"".equals(funcmodel.getState())) {
			hql += " and func.state=" + funcmodel.getState();
		}
		
		System.out.println(hql);
		List<Sysfunmodle> list = (List<Sysfunmodle>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindSysfunmodle(SysfunmodleModel funcmodel) {
		int count;

		String hql = "select count(*) from Sysfunmodle as func where func.funModleCode like :tpn";
		Map mapParam = new HashMap();
		// 功能编号
		mapParam.put("tpn", "%" + funcmodel.getId() + "%");

		// 二级目录
		if (funcmodel.getPfun() != null && !"".equals(funcmodel.getPfun())) {
			hql += " and func.funParentCode=" + funcmodel.getPfun();
		}
		// 状态
		if (funcmodel.getState() != null && !"".equals(funcmodel.getState())) {
			hql += " and func.state=" + funcmodel.getState();
		}
		
		System.out.println(hql);
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=========" + count);
		return count;

	}
	
	public int isExist(String tpno) {
		
		int count=0;
		String hql = "select count(*) from Sysfunmodle as func where "
				+ "func.funModleCode = '"+ tpno+"'";
		
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, null);
		return count;
	}
}
