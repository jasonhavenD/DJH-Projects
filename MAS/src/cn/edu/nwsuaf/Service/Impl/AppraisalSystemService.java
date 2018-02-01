package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.Service.Impl.BaseServiceImpl;
import cn.edu.nwsuaf.bean.Appraisalsystem;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;

public class AppraisalSystemService extends BaseServiceImpl<Appraisalsystem> {
	// 初始化获取list
	@SuppressWarnings("unchecked")
	public List<Appraisalsystem> findallTargetList(int page, int rows) {

		String hql = "from Appraisalsystem";
		List<Appraisalsystem> list = (List<Appraisalsystem>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, page, rows);
		return list;
	}
	// 返回指标编号是否存在
	@SuppressWarnings("unchecked")
	public int isExist(String indicatorId) {
		int count = 0;
		String hql = "from Appraisalsystem as app where app.indicatorId='"
				+ indicatorId + "'";
		List list = QueryUtilDaoImpl.executeQuery(hql, null);
		count = list.size();
		return count;
	}

	// 返回指标名称
	@SuppressWarnings("unchecked")
	public String findByTno(String indicatorId) {
		String s = "";
		String hql = "select app.indicatorName from Appraisalsystem as app where app.indicatorId='"
				+ indicatorId + "'";
		List list = QueryUtilDaoImpl.executeQuery(hql, null);
		if (list.size() == 0) {
			s = "请输入";
		} else {
			s = (String) list.get(0);
		}
		return s;
	}

	// 多条件查询
	@SuppressWarnings("unchecked")
	public List<Appraisalsystem> findTargetList(BaseModel basemodel, int page,
			int rows) {

		String hql = "from Appraisalsystem as app where "
				+ "app.type like :type "
				+ "and app.indicatorName like :tarname";
		Map mapParam = new HashMap();
		// 指标类型
		mapParam.put("type", "%" + basemodel.getId() + "%");
		// 指标名称
		mapParam.put("tarname", "%" + basemodel.getName() + "%");

		List<Appraisalsystem> list = (List<Appraisalsystem>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindTarget(BaseModel basemodel) {
		int count;
		String hql = "select count(*) from Appraisalsystem as app where "
				+ "app.type like :type "
				+ "and app.indicatorName like :tarname";
		Map mapParam = new HashMap();
		// 指标类型
		mapParam.put("type", "%" + basemodel.getId() + "%");
		// 指标名称
		mapParam.put("tarname", "%" + basemodel.getName() + "%");
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=========" + count);
		return count;

	}
}
