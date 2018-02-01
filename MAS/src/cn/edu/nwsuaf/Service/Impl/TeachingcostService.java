package cn.edu.nwsuaf.Service.Impl;


import java.util.List;

import cn.edu.nwsuaf.Model.TeachingcostModel;

import cn.edu.nwsuaf.bean.Teachingcost;
import cn.edu.nwsuaf.bean.Teachingcosttype;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

import java.util.HashMap;
import java.util.Map;

public class TeachingcostService extends BaseServiceImpl<Teachingcost>{

	
	
	// 返回类型列表
	@SuppressWarnings("unchecked")
	public List<Teachingcosttype> findTypeList() throws ServiceException{
		List list=null;
		try {
			String hql = "FROM Teachingcosttype";
			 list = (List<Teachingcosttype>) QueryUtilDaoImpl.executeQuery(hql, null);
			
			
		} catch (Exception e) {
			
			throw new ServiceException("查询类型列表失败",e);
			
		}
		return list;
	}
	
	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() throws ServiceException{
		List list=null;
		try {
			String hql = "SELECT DISTINCT stup.year FROM Teachingcost AS stup";
			 list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			
			
		} catch (Exception e) {
			
			throw new ServiceException("查询年份列表失败",e);
			
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Teachingcost> findTeachingcostList(TeachingcostModel teamodel,
			int page, int rows) throws ServiceException{
		List<Teachingcost> list=null;
		
         try {
			
			String hql = "from Teachingcost as stup where "
			+ "stup.teachingcosttype.teachCostTypeNo like :tpno ";
			Map mapParam = new HashMap();
			
			mapParam.put("tpno",  "%"+teamodel.getTeachingcosttype().getTeachCostTypeNo()+"%");
		
			// 编号
			if (teamodel.getCostNumber() != null && !"".equals(teamodel.getCostNumber())) {

				hql += "and stup.costNumber= " + teamodel.getCostNumber();
			}
			// 年份
			if (teamodel.getYear() != null && !"".equals(teamodel.getYear())) {

				hql += " and stup.year= " + teamodel.getYear();
			}

			// 专业
			if (teamodel.getMajorId() != null && !"".equals(teamodel.getMajorId()) && !"%".equals(teamodel.getMajorId())) {

				hql += " and stup.major.mno='" + teamodel.getMajorId() + "'";
			}
			// 学院
			if (teamodel.getDepartmentId() != null
					&& !"".endsWith(teamodel.getDepartmentId())) {

				hql += " and stup.major.department.dno='"
						+ teamodel.getDepartmentId() + "'";
			}
			
			
			System.out.print(hql);
			list = (List<Teachingcost>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, mapParam, page, rows);
         }
         
         catch(Exception e){
        	
 			throw new ServiceException("多条件查询失败",e);
         }
         return list;
	}
	
	@SuppressWarnings("unchecked")
	public int countFindTeachingcost(TeachingcostModel teamodel) throws ServiceException {

		int count=0;
		String hql = "select count(*) from Teachingcost as stup where "
			+ "stup.teachingcosttype.teachCostTypeNo like :tpno ";			
			
	System.out.println("Service=====" + teamodel.getTeachingcosttype().getTeachCostTypeNo());
	try {
		
		
		Map mapParam = new HashMap();
		
		mapParam.put("tpno","%"+ teamodel.getTeachingcosttype().getTeachCostTypeNo()+"%");
		// 编号
		if (teamodel.getCostNumber() != null && !"".equals(teamodel.getCostNumber())) {

			hql += "and stup.costNumber= " + teamodel.getCostNumber();
		}
		// 年份
		if (teamodel.getYear() != null && !"".equals(teamodel.getYear())) {

			hql += " and stup.year= " + teamodel.getYear();
		}

         
		// 专业
		if (teamodel.getMajorId() != null && !"".equals(teamodel.getMajorId()) && !"%".equals(teamodel.getMajorId())) {

			hql += " and stup.major.mno='" + teamodel.getMajorId() + "'";
		}
		// 学院
		if (teamodel.getDepartmentId() != null
				&& !"".endsWith(teamodel.getDepartmentId())) {

			hql += " and stup.major.department.dno='"
					+ teamodel.getDepartmentId() + "'";
		}
		
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
     }
     
     catch(Exception e){
    	 
			throw new ServiceException("多条件查询失败",e);
     }
	
     System.out.println("count=========" + count);
		return count;
	}
	@SuppressWarnings("unchecked")
	public List<Teachingcost> findallCostList(int page, int rows, String mno, String dno) {
		
		
		String hql = "";
		List<Teachingcost> list = null;
		if(!mno.equals("000000")){
			hql="from Teachingcost t where t.major.mno=?";
			String param[]={mno};
			list = (List<Teachingcost>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Teachingcost t where t.major.department.dno=?";
			String param[]={dno};
			list = (List<Teachingcost>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Teachingcost";
			
			list = (List<Teachingcost>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii==="+list.size());
			
		}
		
		
		
		return list;

		
		
	}
	
	
	//导出
	@SuppressWarnings("unchecked")
	public List<Teachingcost> exportallTeachList(TeachingcostModel teamodel) {
		String hql = "from Teachingcost as stup where "
			+ "stup.teachingcosttype.teachCostTypeNo like :tpno ";
			Map mapParam = new HashMap();
			
			mapParam.put("tpno", "%" + teamodel.getTeachingcosttype().getTeachCostTypeNo()+"%");
			
			
		

			// 专业
			if (teamodel.getMajorId() != null && !"".equals(teamodel.getMajorId()) && !"%".equals(teamodel.getMajorId())) {

				hql += " and stup.major.mno='" + teamodel.getMajorId() + "'";
			}
			// 学院
			if (teamodel.getDepartmentId() != null
					&& !"".endsWith(teamodel.getDepartmentId())) {

				hql += " and stup.major.department.dno='"
						+ teamodel.getDepartmentId() + "'";
			}
			
			
			
			List<Teachingcost> list = (List<Teachingcost>) QueryUtilDaoImpl.executeQuery(hql, null, mapParam);
        
         return list;
	}
	public int count(String mno, String dno) 
		throws ServiceException {
			int count=0;	
			String hql="";
			if(!mno.equals("000000")){
				hql="select count(*) from  Teachingcost t where t.major.mno=?";
				String param[]={mno};
				count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				hql="select count(*) from Teachingcost t where t.major.department.dno=?";
				String param[]={dno};
				count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
				
			}else{
				hql="select count(*) from Teachingcost";
				
				count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
				
			}
			return count;


	}
	
	
	
	

}

