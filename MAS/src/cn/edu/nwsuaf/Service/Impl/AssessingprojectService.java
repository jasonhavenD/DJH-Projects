package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.bean.Assessingproject;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;

public class AssessingprojectService extends BaseServiceImpl<Assessingproject>{
	// 初始化获取list
	@SuppressWarnings("unchecked")
	public List<Assessingproject> findallAprojectList(int page, int rows) {

		String hql = "from Assessingproject";
		List<Assessingproject> list = (List<Assessingproject>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, page, rows);
		return list;
	}
	// 多条件查询（学号号、论文名称、专业、学院）
	@SuppressWarnings("unchecked")
	public List<Assessingproject> findAprojectList(BaseModel basemodel,
			int page, int rows) {

		String hql = "from Assessingproject as ap where "
				+ "ap.masprojectName like :apname";
		Map mapParam = new HashMap();
		// 开启评估项目名称
		mapParam.put("apname", "%" + basemodel.getName() + "%");
		
		List<Assessingproject> list = (List<Assessingproject>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindAproject(BaseModel basemodel) {
		int count;
		String hql = "select count(*) from Assessingproject as ap where "
				+ "ap.masprojectName like :apname";
		Map mapParam = new HashMap();
		// 开启评估项目名称
		mapParam.put("apname", "%" + basemodel.getName() + "%");
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=========" + count);
		return count;

	}
	/**
	 * 获取所有评估项目期信息(按名称倒序拍）
	 * @return
	 */
	public List<Assessingproject> findProjectDesc(){
		String hql = "from Assessingproject as a order by a.masprojectName desc";
		List<Assessingproject> list = (List<Assessingproject>) QueryUtilDaoImpl.executeQuery(hql, null);
		return list;
	}
	/**
	 * 获取已开启的评估项目，如果有多期，则取第一个
	 * @return
	 */
	public Assessingproject findCurrentProject(){
		String hql = "from Assessingproject as a where a.tag = '1'";
		List<Assessingproject> list = (List<Assessingproject>) QueryUtilDaoImpl.executeQuery(hql, null);
		Assessingproject ap = null;
		if(list != null && list.size()>0){
			ap = list.get(0);
		}
		return ap;
	}
}
