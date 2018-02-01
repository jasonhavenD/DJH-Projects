package cn.edu.nwsuaf.Service.Impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.bean.Traininguseinginformation;
import cn.edu.nwsuaf.Model.TraininguseinginformationModel;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class TraininguseinginformationService extends BaseServiceImpl<Traininguseinginformation>{
	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() throws ServiceException{
		List list=null;
		try {
			String hql = "SELECT DISTINCT stup.year FROM Traininguseinginformation AS stup";
			 list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			Collections.sort(list);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询年份列表失败",e);
			
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	
	public List<Traininguseinginformation> findTraininguseinginformationList(
			TraininguseinginformationModel tuimodel, int page, int rows) throws ServiceException {
		List<Traininguseinginformation> list=null;
		try {
			
			String hql = "from Traininguseinginformation as stup where "
			+ "stup.year like :tpno ";
			Map mapParam = new HashMap();
			
			mapParam.put("tpno", "%" + tuimodel.getYear()+"%");
			
		
			// 编号
			if (tuimodel.getPraId() != null && !"".equals(tuimodel.getPraId())) {

				hql += "and stup.praId= " + tuimodel.getPraId();
			}

			
			// 专业
			if (tuimodel.getMajorId() != null && !"".equals(tuimodel.getMajorId()) && !"%".equals(tuimodel.getMajorId())) {

				hql += " and stup.major.mno='" + tuimodel.getMajorId() + "'";
			}
			// 学院
			if (tuimodel.getDepartmentId() != null
					&& !"".endsWith(tuimodel.getDepartmentId())) {

				hql += " and stup.major.department.dno= "
						+ tuimodel.getDepartmentId();
			}
			
			list = (List<Traininguseinginformation>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, mapParam, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("多条件查询失败",e);
		}

		return list;
	}
	
	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindTraininguseinginformation(
			TraininguseinginformationModel tuimodel) throws ServiceException
			{
		int count=0;
		String hql = "select count(*) from Traininguseinginformation as stup where "
			+ "stup.year like :tpno ";
	System.out.println("Service===PraId==" + tuimodel.getPraId());
	try {
		Map mapParam = new HashMap();
		// 编号
		mapParam.put("tpno", "%" + tuimodel.getYear()+ "%");
		
		
		
		// 编号
		if (tuimodel.getPraId() != null && !"".equals(tuimodel.getPraId())) {

			hql += "and stup.praId= " + tuimodel.getPraId();
		}

		
		
		// 专业
		if (tuimodel.getMajorId() != null && !"".equals(tuimodel.getMajorId()) && !"%".equals(tuimodel.getMajorId())) {

			hql += " and stup.major.mno='" + tuimodel.getMajorId() + "'";
		}
		// 学院
		if (tuimodel.getDepartmentId() != null
				&& !"".endsWith(tuimodel.getDepartmentId())) {

			hql += " and stup.major.department.dno= "
					+ tuimodel.getDepartmentId();
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
	public List<Traininguseinginformation> findAllTraList(int page, int rows, String mno, String dno) {
		
		
		String hql = "";
		List<Traininguseinginformation> list = null;
		if(!mno.equals("000000")){
			hql="from Traininguseinginformation t where t.major.mno=?";
			String param[]={mno};
			list = (List<Traininguseinginformation>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Traininguseinginformation t where t.major.department.dno=?";
			String param[]={dno};
			list = (List<Traininguseinginformation>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Traininguseinginformation";
			
			list = (List<Traininguseinginformation>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii==="+list.size());
			
		}

		return list;
		
	}

	@SuppressWarnings("unchecked")
	public List<Traininguseinginformation> exportallTraList(
			TraininguseinginformationModel tuimodel) {
		
			
			String hql = "from Traininguseinginformation as stup where "
			+ "stup.year like :tpno ";
			Map mapParam = new HashMap();
			
			mapParam.put("tpno", "%" + tuimodel.getYear()+"%");
			
		
			// 编号
			if (tuimodel.getPraId() != null && !"".equals(tuimodel.getPraId())) {

				hql += "and stup.praId= " + tuimodel.getPraId();
			}

			
			// 专业
			if (tuimodel.getMajorId() != null && !"".equals(tuimodel.getMajorId()) && !"%".equals(tuimodel.getMajorId())) {

				hql += " and stup.major.mno='" + tuimodel.getMajorId() + "'";
			}
			// 学院
			if (tuimodel.getDepartmentId() != null
					&& !"".endsWith(tuimodel.getDepartmentId())) {

				hql += " and stup.major.department.dno= "
						+ tuimodel.getDepartmentId();
			}
			
			List<Traininguseinginformation> list = (List<Traininguseinginformation>) QueryUtilDaoImpl
					.executeQuery(hql, null, mapParam);
		

		return list;
	}

public int count(String mno,String dno)
			throws ServiceException {
		int count=0;	
		String hql="";
		if(!mno.equals("000000")){
			hql="select count(*) from  Traininguseinginformation t where t.major.mno=?";
			String param[]={mno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="select count(*) from Traininguseinginformation t where t.major.department.dno=?";
			String param[]={dno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			
		}else{
			hql="select count(*) from Traininguseinginformation";
			
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
			
		}
		return count;

	}


} 
