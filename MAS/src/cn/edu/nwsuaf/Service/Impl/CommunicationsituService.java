package cn.edu.nwsuaf.Service.Impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.CommunicationsituModel;
import cn.edu.nwsuaf.bean.Communicationsitu;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class CommunicationsituService extends BaseServiceImpl<Communicationsitu>{

	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() throws ServiceException{
		List list=null;
		try {
			String hql = "SELECT DISTINCT stup.year FROM Communicationsitu AS stup";
			 list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			Collections.sort(list);
			
		} catch (Exception e) {
		
			throw new ServiceException("查询年份列表失败",e);
			
		}
		return list;
	}
	
	//导出
	@SuppressWarnings("unchecked")
	public List<Communicationsitu> exportallAddmissionsList(CommunicationsituModel commodel) {

		String hql = "from Communicationsitu as stup where stup.year like :tpn";
		System.out.println("Service===Communiyear==" + commodel.getYear());
		Map mapParam = new HashMap();
		// 年份
		mapParam.put("tpn", "%" + commodel.getYear() + "%");

		// 编号
		if (commodel.getComNumber() != null && !"".equals(commodel.getComNumber())) {

			hql += "and stup.comNumber= " + commodel.getComNumber();
		}
		// 专业
		if (commodel.getMajorId() != null && !"".equals(commodel.getMajorId())&& !"%".equals(commodel.getMajorId())) {

			hql += " and stup.major.mno='" + commodel.getMajorId() + "'";
		}
		// 学院
		if (commodel.getDepartmentId() != null
				&& !"".endsWith(commodel.getDepartmentId())) {

			hql += " and stup.major.department.dno='"
					+ commodel.getDepartmentId() + "'";
		}
		System.out.println(hql);
		List<Communicationsitu> list = (List<Communicationsitu>) QueryUtilDaoImpl.executeQuery(hql, null, mapParam);
		return list;

	}
	
	
	@SuppressWarnings("unchecked")
	public List<Communicationsitu> findallCommunicationsituList(int page, int rows, String mno, String dno) {

		String hql = "";
		List<Communicationsitu> list = null;
		if(!mno.equals("000000")){
			hql="from Communicationsitu t where t.major.mno=?";
			String param[]={mno};
			list = (List<Communicationsitu>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Communicationsitu t where t.major.department.dno=?";
			String param[]={dno};
			list = (List<Communicationsitu>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Communicationsitu";
			
			list = (List<Communicationsitu>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii==="+list.size());
			
		}
		return list;
	}
	
@SuppressWarnings("unchecked")
	
	public List<Communicationsitu> findCommunicationsituList(
			CommunicationsituModel commodel, int page, int rows) throws ServiceException {
		List<Communicationsitu> list=null;
		try {
			
			String hql = "from Communicationsitu as stup where "
			+ "stup.year like :tpno ";
			Map mapParam = new HashMap();
			
			mapParam.put("tpno", "%" + commodel.getYear()+"%");
			
		
			// 编号
			if (commodel.getComNumber() != null && !"".equals(commodel.getComNumber())) {

				hql += "and stup.comNumber= " + commodel.getComNumber();
			}

			
			// 类型
			/*if (fulmodel.getFulType() != null
					&& !"".equals(fulmodel.getFulType())) {

				hql += " and stup.fulType= " + fulmodel.getFulType();
			}*/
			// 专业
			if (commodel.getMajorId() != null && !"".equals(commodel.getMajorId())&& !"%".equals(commodel.getMajorId())) {

				hql += " and stup.major.mno='" + commodel.getMajorId() + "'";
			}
			// 学院
			if (commodel.getDepartmentId() != null
					&& !"".endsWith(commodel.getDepartmentId())) {

				hql += " and stup.major.department.dno='"
						+ commodel.getDepartmentId() + "'";
			}
			System.out.println(hql);
			list = (List<Communicationsitu>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, mapParam, page, rows);
		} catch (Exception e) {
			
			throw new ServiceException("多条件查询失败",e);
		}

		return list;
	}
	
	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindCommunicationsitu(
			CommunicationsituModel commodel) throws ServiceException
			{
		int count=0;
		String hql = "select count(*) from Communicationsitu as stup where "
			+ "stup.year like :tpno ";
	
	try {
		Map mapParam = new HashMap();
		// 编号
		mapParam.put("tpno", "%" + commodel.getYear()+ "%");
		
		
		
		// 编号
		if (commodel.getComNumber() != null && !"".equals(commodel.getComNumber())) {

			hql += "and stup.comNumber= " + commodel.getComNumber();
		}

		System.out.println("Service===comNumber==" + commodel.getComNumber());
		
		
		// 专业
		if (commodel.getMajorId() != null && !"".equals(commodel.getMajorId())&& !"%".equals(commodel.getMajorId())) {

			hql += " and stup.major.mno='" + commodel.getMajorId() + "'";
		}
		// 学院
		if (commodel.getDepartmentId() != null
				&& !"".endsWith(commodel.getDepartmentId())) {

			hql += " and stup.major.department.dno='"
					+ commodel.getDepartmentId() + "'";
		}
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
	} catch (Exception e) {
		
		throw new ServiceException("查询结果条数失败", e);
	}
	System.out.println("count=========" + count);
	return count;
	}
	public int isExist(int tpno) {
		
		int count=0;
		String hql = "select count(*) from Communicationsitu as stup where "
				+ "stup.comNumber ="+tpno;
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null);
		System.out.println(count);
		return count;
		
		
	}

	public int count(String mno,String dno)
	throws ServiceException {
int count=0;	
String hql="";
if(!mno.equals("000000")){
	hql="select count(*) from  Communicationsitu t where t.major.mno=?";
	String param[]={mno};
	count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
}else if(!dno.equals("00000")&&mno.equals("000000")){
	hql="select count(*) from Communicationsitu t where t.major.department.dno=?";
	String param[]={dno};
	count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
	
}else{
	hql="select count(*) from Communicationsitu";
	
	count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
	
}
return count;

}

	

}
