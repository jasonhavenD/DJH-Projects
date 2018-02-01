package cn.edu.nwsuaf.Service.Impl;

import cn.edu.nwsuaf.bean.Fulfillinginstance;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.edu.nwsuaf.Model.FulfillinginstanceModel;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class FulfillinginstanceService extends BaseServiceImpl<Fulfillinginstance>{
	//返回类型列表
	@SuppressWarnings("unchecked")
	public List<String> findFTypeList() throws ServiceException{
		List list=null;
		try {
			String hql = "SELECT DISTINCT stup.fulType FROM Fulfillinginstance AS stup";
			 list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询类型列表失败",e);
			
		}
		return list;
	}
	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() throws ServiceException{
		List list=null;
		try {
			String hql = "SELECT DISTINCT stup.year FROM Fulfillinginstance AS stup";
			 list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			Collections.sort(list);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询年份列表失败",e);
			
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	// 多条件查询（类型、数目、专业、学院）
	public List<Fulfillinginstance> findFulfillinginstancetList(FulfillinginstanceModel fulmodel,
			int page, int rows) throws ServiceException{
		String hql = "";
		List<Fulfillinginstance> list=null;
		try {
			
		    hql = "from Fulfillinginstance as stup where "
			+ "stup.year like :tpno ";
			Map mapParam = new HashMap();
			
			mapParam.put("tpno", "%" + fulmodel.getYear()+"%");
			
			if (fulmodel.getFulType() != null
					&& !"".equals(fulmodel.getFulType())) {

				hql += " and stup.fulType= '" + fulmodel.getFulType()+"'";
			}
			// 专业
			if (fulmodel.getMajorId() != null
					&& !"".equals(fulmodel.getMajorId())&& !"%".equals(fulmodel.getMajorId())) {

				hql += " and stup.major.mno='" + fulmodel.getMajorId() + "'";
			}
			// 学院
			if (fulmodel.getDepartmentId() != null
					&& !"".endsWith(fulmodel.getDepartmentId())) {

				hql += " and stup.major.department.dno='"
					+ fulmodel.getDepartmentId() + "'";
			}
			System.out.println("as"+hql);
			list = (List<Fulfillinginstance>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, mapParam, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("多条件查询失败",e);
		}

		return list;

	}
	

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindFulfillinginstance(FulfillinginstanceModel fulmodel) throws ServiceException {
		
		int count=0;
		String hql = "select count(*) from Fulfillinginstance as stup where "
			+ "stup.year like :tpno ";
		System.out.println("Service=====" + fulmodel.getYear());

		
		try {
			Map mapParam = new HashMap();
			// 专利号
			mapParam.put("tpno", "%" +fulmodel.getYear()+ "%");
			//类型
			if (fulmodel.getFulType() != null
					&& !"".equals(fulmodel.getFulType())) {

				hql += " and stup.fulType= '" + fulmodel.getFulType()+"'";
			}
			// 专业
			if (fulmodel.getMajorId() != null
					&& !"".equals(fulmodel.getMajorId())&& !"%".equals(fulmodel.getMajorId())) {

				hql += " and stup.major.mno='" + fulmodel.getMajorId() + "'";
			}
			// 学院
			if (fulmodel.getDepartmentId() != null
					&& !"".endsWith(fulmodel.getDepartmentId())) {

				hql += " and stup.major.department.dno='"
					+ fulmodel.getDepartmentId() + "'";
			}
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询结果条数失败", e);
		}
		System.out.println("count=========" + hql);
		System.out.println("count=========" + count);
		return count;

	}
	@SuppressWarnings("unchecked")
	public List<Fulfillinginstance> findallfulList(int page, int rows, String mno, String dno) {
		
		String hql = "";
		List<Fulfillinginstance> list = null;
		if(!mno.equals("000000")){
			hql="from Fulfillinginstance t where t.major.mno=?";
			String param[]={mno};
			list = (List<Fulfillinginstance>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Fulfillinginstance t where t.major.department.dno=?";
			String param[]={dno};
			list = (List<Fulfillinginstance>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Fulfillinginstance";
			
			list = (List<Fulfillinginstance>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii==="+list.size());
			
		}
		return list;

	}
	@SuppressWarnings("unchecked")
	public List<Fulfillinginstance> exportallFulList(
			FulfillinginstanceModel fulmodel) {
		String hql = "from Fulfillinginstance as stup where stup.year like :tpn";
		System.out.println("Service===year==" + fulmodel.getYear());
		Map mapParam = new HashMap();
		// 年份
		mapParam.put("tpn", "%" + fulmodel.getYear() + "%");

		//类型
		if (fulmodel.getFulType() != null
				&& !"".equals(fulmodel.getFulType())) {

			hql += " and stup.fulType= '" + fulmodel.getFulType()+"'";
		}
		// 专业
		if (fulmodel.getMajorId() != null
				&& !"".equals(fulmodel.getMajorId())&& !"%".equals(fulmodel.getMajorId())) {

			hql += " and stup.major.mno='" + fulmodel.getMajorId() + "'";
		}
		// 学院
		if (fulmodel.getDepartmentId() != null
				&& !"".endsWith(fulmodel.getDepartmentId())) {

			hql += " and stup.major.department.dno='"
				+ fulmodel.getDepartmentId() + "'";
		}
		System.out.println(hql);
		List<Fulfillinginstance> list = (List<Fulfillinginstance>) QueryUtilDaoImpl.executeQuery(hql, null, mapParam);
		return list;
	}
	
	// 查询结果条数
	public int count(String mno,String dno)
			throws ServiceException {
		int count=0;	
		String hql="";
		if(!mno.equals("000000")){
			hql="select count(*) from  Fulfillinginstance t where t.major.mno=?";
			String param[]={mno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="select count(*) from Fulfillinginstance t where t.major.department.dno=?";
			String param[]={dno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			
		}else{
			hql="select count(*) from Fulfillinginstance";
			
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
			
		}
		return count;

	}
}
