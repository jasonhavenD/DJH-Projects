package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.QualitystandardModel;
import cn.edu.nwsuaf.bean.Qualitystandard;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class QualitystandardService extends BaseServiceImpl<Qualitystandard> {
	// 分页返回所有数据
	@SuppressWarnings("unchecked")
	public List<Qualitystandard> findallQualitystandardList(int page, int rows, String mno,String dno){
		
		String hql = "";
		List<Qualitystandard> list = null;
		if(!mno.equals("000000")){
			hql="from Qualitystandard as quastan where quastan.major.mno=?";
			String param[]={mno};
			list = (List<Qualitystandard>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Qualitystandard as quastan where quastan.major.department.dno=?";
			String param[]={dno};
			list = (List<Qualitystandard>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Qualitystandard";
			
			list = (List<Qualitystandard>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()==="+list.size());
			
		}
		return list;
	}
	//导出
	@SuppressWarnings("unchecked")
	public List<Qualitystandard> exportallQualitystandardList(QualitystandardModel quastanmodel) {

		String hql = "from Qualitystandard as quastan where quastan.major.mno like :tpn";
		System.out.println("Service===Qualitystandardmajor==" + quastanmodel.getMajorId());
		Map mapParam = new HashMap();
		// 年份
		mapParam.put("tpn", "%" + quastanmodel.getMajorId() + "%");

		// 总数大于
		if (quastanmodel.getLittleallCount() != null
				&& quastanmodel.getLittleallCount() >= 0
				&& !"".equals(quastanmodel.getLittleallCount())) {
			hql += " and quastan.allCount>=" + quastanmodel.getLittleallCount();
		}
		// 总数小于
		if (quastanmodel.getBigallCount() != null
				&& quastanmodel.getBigallCount() >= quastanmodel
						.getLittleallCount()
				&& !"".equals(quastanmodel.getBigallCount())) {
			hql += " and quastan.allCount<=" + quastanmodel.getBigallCount();
		}
		// 完成数大于
		if (quastanmodel.getLittlecompleteCount() != null
				&& quastanmodel.getLittlecompleteCount() >= 0
				&& !"".equals(quastanmodel.getLittlecompleteCount())) {
			hql += " and quastan.completeCount>=" + quastanmodel.getLittlecompleteCount();
		}
		// 完成数小于
		if (quastanmodel.getBigcompleteCount() != null
				&& quastanmodel.getBigcompleteCount() >= quastanmodel.getLittlecompleteCount()
				&& !"".equals(quastanmodel.getBigcompleteCount())) {
			hql += " and quastan.completeCount<=" + quastanmodel.getBigcompleteCount();
		}
		// 学院
		if (quastanmodel.getDepartmentId() != null
				&& !"".endsWith(quastanmodel.getDepartmentId())) {

			hql += " and quastan.major.department.dno='"
					+ quastanmodel.getDepartmentId() + "'";
		}
		System.out.println(hql);
		List<Qualitystandard> list = (List<Qualitystandard>) QueryUtilDaoImpl.executeQuery(hql, null, mapParam);
		return list;

	}

	@SuppressWarnings("unchecked")
	// 多条件查询
	public List<Qualitystandard> findQualitystandardList(QualitystandardModel quastanmodel,
			int page, int rows) {

		String hql = "from Qualitystandard as quastan where quastan.major.mno like :tpn";
		System.out.println("Service===Qualitystandardmajor==" + quastanmodel.getMajorId());
		Map mapParam = new HashMap();
		// 年份
		mapParam.put("tpn", "%" + quastanmodel.getMajorId() + "%");

		// 总数大于
		if (quastanmodel.getLittleallCount() != null
				&& quastanmodel.getLittleallCount() >= 0
				&& !"".equals(quastanmodel.getLittleallCount())) {
			hql += " and quastan.allCount>=" + quastanmodel.getLittleallCount();
		}
		// 总数小于
		if (quastanmodel.getBigallCount() != null
				&& quastanmodel.getBigallCount() >= quastanmodel
						.getLittleallCount()
				&& !"".equals(quastanmodel.getBigallCount())) {
			hql += " and quastan.allCount<=" + quastanmodel.getBigallCount();
		}
		// 完成数大于
		if (quastanmodel.getLittlecompleteCount() != null
				&& quastanmodel.getLittlecompleteCount() >= 0
				&& !"".equals(quastanmodel.getLittlecompleteCount())) {
			hql += " and quastan.completeCount>=" + quastanmodel.getLittlecompleteCount();
		}
		// 完成数小于
		if (quastanmodel.getBigcompleteCount() != null
				&& quastanmodel.getBigcompleteCount() >= quastanmodel.getLittlecompleteCount()
				&& !"".equals(quastanmodel.getBigcompleteCount())) {
			hql += " and quastan.completeCount<=" + quastanmodel.getBigcompleteCount();
		}
		// 学院
		if (quastanmodel.getDepartmentId() != null
				&& !"".endsWith(quastanmodel.getDepartmentId())) {

			hql += " and quastan.major.department.dno='"
					+ quastanmodel.getDepartmentId() + "'";
		}
		System.out.println(hql);
		List<Qualitystandard> list = (List<Qualitystandard>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindQualitystandard(QualitystandardModel quastanmodel) {
		int count;

		String hql = "select count(*) from Qualitystandard as quastan where quastan.major.mno like :tpn";
		System.out.println("Service===Qualitystandardmajor==" + quastanmodel.getMajorId());
		Map mapParam = new HashMap();
		// 年份
		mapParam.put("tpn", "%" + quastanmodel.getMajorId() + "%");

		// 总数大于
		if (quastanmodel.getLittleallCount() != null
				&& quastanmodel.getLittleallCount() >= 0
				&& !"".equals(quastanmodel.getLittleallCount())) {
			hql += " and quastan.allCount>=" + quastanmodel.getLittleallCount();
		}
		// 总数小于
		if (quastanmodel.getBigallCount() != null
				&& quastanmodel.getBigallCount() >= quastanmodel
						.getLittleallCount()
				&& !"".equals(quastanmodel.getBigallCount())) {
			hql += " and quastan.allCount<=" + quastanmodel.getBigallCount();
		}
		// 完成数大于
		if (quastanmodel.getLittlecompleteCount() != null
				&& quastanmodel.getLittlecompleteCount() >= 0
				&& !"".equals(quastanmodel.getLittlecompleteCount())) {
			hql += " and quastan.completeCount>=" + quastanmodel.getLittlecompleteCount();
		}
		// 完成数小于
		if (quastanmodel.getBigcompleteCount() != null
				&& quastanmodel.getBigcompleteCount() >= quastanmodel.getLittlecompleteCount()
				&& !"".equals(quastanmodel.getBigcompleteCount())) {
			hql += " and quastan.completeCount<=" + quastanmodel.getBigcompleteCount();
		}
		// 学院
		if (quastanmodel.getDepartmentId() != null
				&& !"".endsWith(quastanmodel.getDepartmentId())) {

			hql += " and quastan.major.department.dno='"
					+ quastanmodel.getDepartmentId() + "'";
		}
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=========" + count);
		return count;

	}
	// 查询结果条数
	public int count(String mno,String dno)
			throws ServiceException {
		int count=0;	
		String hql="";
		if(!mno.equals("000000")){
			hql="select count(*) from Qualitystandard as quastan where quastan.major.mno=?";
			String param[]={mno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="select count(*) from Qualitystandard as quastan where quastan.major.department.dno=?";
			String param[]={dno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			
		}else{
			hql="select count(*) from Qualitystandard";
			
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
			
		}
		return count;

	}

}
