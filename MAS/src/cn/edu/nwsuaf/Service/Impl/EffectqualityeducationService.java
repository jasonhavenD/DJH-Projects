package cn.edu.nwsuaf.Service.Impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.edu.nwsuaf.Model.EffectqualityeducationModel;
import cn.edu.nwsuaf.bean.Effectofqualityeducation;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class EffectqualityeducationService extends BaseServiceImpl<Effectofqualityeducation> {
	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() throws ServiceException{
		List list=null;
		try {
			String hql = "SELECT DISTINCT eqe.year FROM Effectofqualityeducation AS eqe";
			 list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			Collections.sort(list);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询年份列表失败",e);
			
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Effectofqualityeducation> findallEffectofqualityeducationList(int page, int rows,String mno,String dno) {

		
		String hql = "";
		List<Effectofqualityeducation> list = null;
		if(!mno.equals("000000")){
			hql="from Effectofqualityeducation t where t.major.mno=?";
			String param[]={mno};
			list = (List<Effectofqualityeducation>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Effectofqualityeducation t where t.major.department.dno=?";
			String param[]={dno};
			list = (List<Effectofqualityeducation>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Effectofqualityeducation";
			
			list = (List<Effectofqualityeducation>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii==="+list.size());
			
		}
		
		
		
		return list;

	}
	//导出
	@SuppressWarnings("unchecked")
	public List<Effectofqualityeducation> exportallEqeList(EffectqualityeducationModel eqemodel) throws ServiceException{

		List<Effectofqualityeducation> list=null;
		try {
			String hql = "from Effectofqualityeducation as eqe where eqe.year like :tpno";
					
					
			System.out.println("Service===Year==" + eqemodel.getYear());
			Map<String, String> mapParam = new HashMap<String, String>();
			// 年份
			mapParam.put("tpno", "%" + eqemodel.getYear()+ "%");
			
			
			/*if (eqemodel.getCupCount() != null
					&& eqemodel.getCupCount() >= 0
					&& !"".equals(eqemodel.getCupCount())) {
				hql += " and eqe.cupCount=" + eqemodel.getCupCount();
			}
			if (eqemodel.getMajorCount() != null
					&& eqemodel.getMajorCount() >= 0
					&& !"".equals(eqemodel.getCupCount())) {
				hql += " and eqe.major.majorStudentNum=" + eqemodel.getMajorCount();
			}
			*/

			
			
			// 专业
			if (eqemodel.getMajorId() != null
					&& !"".equals(eqemodel.getMajorId())&& !"%".equals(eqemodel.getMajorId())) {

				hql += " and eqe.major.mno= '" + eqemodel.getMajorId()+"'";
			}
			// 学院
			if (eqemodel.getDepartmentId() != null
					&& !"".endsWith(eqemodel.getDepartmentId())) {

				hql += " and eqe.major.department.dno='"
						+ eqemodel.getDepartmentId()+"'";
			}
			
			list = (List<Effectofqualityeducation>) QueryUtilDaoImpl
					.executeQuery(hql, null, mapParam);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("多条件查询失败",e);
		}

		return list;

	}
	@SuppressWarnings("unchecked")
	// 多条件查询（专利号、专利名称、专业、学院）
	public List<Effectofqualityeducation> findEqeList(EffectqualityeducationModel eqemodel,
			int page, int rows) throws ServiceException{

		List<Effectofqualityeducation> list=null;
		try {
			String hql = "from Effectofqualityeducation as eqe where eqe.year like :tpno";
					
					
			System.out.println("Service===Year==" + eqemodel.getYear());
			Map mapParam = new HashMap();
			// 年份
			mapParam.put("tpno", "%" + eqemodel.getYear()+ "%");
			
			
			/*if (eqemodel.getCupCount() != null
					&& eqemodel.getCupCount() >= 0
					&& !"".equals(eqemodel.getCupCount())) {
				hql += " and eqe.cupCount=" + eqemodel.getCupCount();
			}
			if (eqemodel.getMajorCount() != null
					&& eqemodel.getMajorCount() >= 0
					&& !"".equals(eqemodel.getCupCount())) {
				hql += " and eqe.major.majorStudentNum=" + eqemodel.getMajorCount();
			}
			*/

			
			
			// 专业
			if (eqemodel.getMajorId() != null
					&& !"".equals(eqemodel.getMajorId())&& !"%".equals(eqemodel.getMajorId())) {

				hql += " and eqe.major.mno= '" + eqemodel.getMajorId()+"'";
			}
			// 学院
			if (eqemodel.getDepartmentId() != null
					&& !"".endsWith(eqemodel.getDepartmentId())) {

				hql += " and eqe.major.department.dno='"
						+ eqemodel.getDepartmentId()+"'";
			}
			
			list = (List<Effectofqualityeducation>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, mapParam, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("多条件查询失败",e);
		}

		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindEqe(EffectqualityeducationModel eqemodel) throws ServiceException {
		
		int count=0;
		String hql = "select count(*) from Effectofqualityeducation as eqe where eqe.year like :tpno";
				
		try {
			Map mapParam = new HashMap();
			// 年份
			mapParam.put("tpno", "%" + eqemodel.getYear() + "%");
			
			if (eqemodel.getYear() != null && !"".equals(eqemodel.getYear())) {

				hql += " and eqe.year= " + eqemodel.getYear();
			}
			//挑战杯人数
			/*if (eqemodel.getCupCount() != null
					&& eqemodel.getCupCount() >= 0
					&& !"".equals(eqemodel.getCupCount())) {
				hql += " and eqe.cupCount=" + eqemodel.getCupCount();
			}
			if (eqemodel.getMajorCount() != null
					&& eqemodel.getMajorCount() >= 0
					&& !"".equals(eqemodel.getCupCount())) {
				hql += " and eqe.major.majorStudentNum=" + eqemodel.getMajorCount();
			}*/
			
			
			// 专业
			if (eqemodel.getMajorId() != null
					&& !"".equals(eqemodel.getMajorId())&& !"%".equals(eqemodel.getMajorId())) {

				hql += " and eqe.major.mno= '" + eqemodel.getMajorId()+"'";
			}
			// 学院
			if (eqemodel.getDepartmentId() != null
					&& !"".endsWith(eqemodel.getDepartmentId())) {

				hql += " and eqe.major.department.dno= '"
						+ eqemodel.getDepartmentId()+"'";
			}
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询结果条数失败", e);
		}
		System.out.println("count=========" + count);
		return count;

	}
	@SuppressWarnings("unchecked")
	public int isExist(String tpno) {
		
		int count=0;
		String hql = "select count(*) from Effectofqualityeducation as stup where "
				+ "stup.year like :tpno";
		Map mapParam = new HashMap();
		// 专利号
		mapParam.put("tpno", "%" + tpno + "%");
		// 专利名称
		
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		return count;
	}
	public int count(String mno,String dno)
	throws ServiceException {
int count=0;	
String hql="";
if(!mno.equals("000000")){
	hql="select count(*) from  Effectofqualityeducation t where t.major.mno=?";
	String param[]={mno};
	count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
}else if(!dno.equals("00000")&&mno.equals("000000")){
	hql="select count(*) from Effectofqualityeducation t where t.major.department.dno=?";
	String param[]={dno};
	count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
	
}else{
	hql="select count(*) from Effectofqualityeducation";
	
	count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
	
}
return count;

}

	
}
