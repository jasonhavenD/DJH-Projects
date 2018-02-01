package cn.edu.nwsuaf.Service.Impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import cn.edu.nwsuaf.Model.TeachprojectModel;
import cn.edu.nwsuaf.Model.TrainingvenueModel;
import cn.edu.nwsuaf.bean.Achievements;
import cn.edu.nwsuaf.bean.Teachproject;
import cn.edu.nwsuaf.bean.Trainingvenue;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class TrainingvenueService extends BaseServiceImpl<Trainingvenue>{
	//分页获取全部实验室信息
	@SuppressWarnings("unchecked")
	public List<Trainingvenue> findallTrainingvenueList(int page, int rows,String mno ,String dno) {
		String hql = "";
		List<Trainingvenue> list = null;
		if(!mno.equals("000000")){
			hql="from Trainingvenue a where a.traNumer in(select ta.trainingvenue.traNumer from Trainingvenueuse ta where ta.major.mno=?)";
			String param[]={mno};
			list = (List<Trainingvenue>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Trainingvenue a where a.traNumer in(select ta.trainingvenue.traNumer from Trainingvenueuse ta where ta.major.department.dno=?)";
			String param[]={dno};
			list = (List<Trainingvenue>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Trainingvenue";
			
			list = (List<Trainingvenue>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()==="+list.size());
			
		}
		return list;
	}
	//返回类型列表
	@SuppressWarnings("unchecked")
	public List<String> findTCharacterList() throws ServiceException{
		List list=null;
		try {
			String hql = "SELECT DISTINCT stup.traCharacter FROM Trainingvenue AS stup";
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
			String hql = "SELECT DISTINCT stup.year FROM Trainingvenue AS stup";
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
	public List<Trainingvenue> findTrainingvenueList(TrainingvenueModel tramodel,
			int page, int rows) throws ServiceException{

		List<Trainingvenue> list=null;
		
			String hql = "from Trainingvenue as stup where "
			+ "stup.traName like :tpno ";
			Map mapParam = new HashMap();
			
			mapParam.put("tpno", "%" + tramodel.getTraName()+"%");
			
//		if (tramodel.getStuNumber1()!= null && !"".equals(tramodel.getStuNumber1())) {
//
//			hql += "and stup.stuNumber1= " + tramodel.getStuNumber1();
//		}
//		if (tramodel.getStuNumber2()!= null && !"".equals(tramodel.getStuNumber2())) {
//
//			hql += "and  stup.stuNumber2= " + tramodel.getStuNumber2();
//		}
			// 年份
			if (tramodel.getYear() != null && !"".equals(tramodel.getYear())) {

				hql += "and stup.year=" + tramodel.getYear();
			}
			// 实验室编号
			if (tramodel.getTraNumer() != null && !"".equals(tramodel.getTraNumer())) {

				hql += "and stup.traNumer='" + tramodel.getTraNumer()+"'";
			}
			// 实验室性质
			if (tramodel.getTraCharacter()!= null && !"".equals(tramodel.getTraCharacter())) {

				hql += "and stup.traCharacter='" + tramodel.getTraCharacter()+"'";
			}
			// 面积
			if (tramodel.getArea() != null && !"".equals(tramodel.getArea())) {

				hql += "and stup.area=" + tramodel.getArea();
			}	
			
			System.out.println("as"+hql+page+rows);
			list = (List<Trainingvenue>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, mapParam, page, rows);
		

		return list;

	}
	
	
	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindTrainingvenue(TrainingvenueModel tramodel) throws ServiceException {
		int count=0;
		String hql = "select count(*) from Trainingvenue as stup where "
			+ "stup.traName like :tpno ";
	   try {
		   Map mapParam = new HashMap();
			
			mapParam.put("tpno", "%" + tramodel.getTraName()+"%");
			
			// 年份
			if (tramodel.getYear() != null && !"".equals(tramodel.getYear())) {

				hql += "and stup.year=" + tramodel.getYear();
			}
			// 实验室编号
			if (tramodel.getTraNumer() != null && !"".equals(tramodel.getTraNumer())) {

				hql += "and stup.traNumer='" + tramodel.getTraNumer()+"'";
			}
			// 实验室性质
			if (tramodel.getTraCharacter()!= null && !"".equals(tramodel.getTraCharacter())) {

				hql += "and stup.traCharacter='" + tramodel.getTraCharacter()+"'";
			}
			// 面积
			if (tramodel.getArea() != null && !"".equals(tramodel.getArea())) {

				hql += "and stup.area=" + tramodel.getArea();
			}	
			System.out.println("实验名称"+tramodel.getTraName());
			System.out.println("as"+hql);
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询结果条数失败", e);
		}
		System.out.println("count=========" + count);
		return count;

	}
	public int count(String mno, String dno) throws ServiceException {
		int count = 0;
		String hql = "";
		if (!mno.equals("000000")) {
			hql="from Trainingvenue a where a.traNumer in(select ta.trainingvenue.traNumer from Trainingvenueuse ta where ta.major.mno=?)";
			String param[] = { mno };
			count = QueryUtilDaoImpl.getResultCountForHql(hql, param);
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql="from Trainingvenue a where a.traNumer in(select ta.trainingvenue.traNumer from Trainingvenueuse ta where ta.major.department.dno=?)";
			String param[] = { dno };
			count = QueryUtilDaoImpl.getResultCountForHql(hql, param);

		} else {
			hql = "select count(*) from Trainingvenue";
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null);

		}
		return count;
	}
	// 导出
	@SuppressWarnings("unchecked")
	public List<Trainingvenue> exportTraList(TrainingvenueModel tramodel
			) {

		String hql = " from Trainingvenue as stup where "
			+ "stup.traCharacter like :tpno ";
	   //System.out.println("Service===StupatentName==" + tramodel.getTraName());
	
	   
			Map mapParam = new HashMap();
			
			mapParam.put("tpno", "%" + tramodel.getTraCharacter()+ "%");
			

			
			// 年份
			if (tramodel.getYear() != null && !"".equals(tramodel.getYear())) {

				hql += "and stup.year=" + tramodel.getYear();
			}
			// 实验室编号
			if (tramodel.getTraNumer() != null && !"".equals(tramodel.getTraNumer())) {

				hql += "and stup.traNumer='" + tramodel.getTraNumer()+"'";
			}
			// 实验室名称
			if (tramodel.getTraName()!= null && !"".equals(tramodel.getTraName())) {

				hql += "and stup.traName= '" + tramodel.getTraName()+"'";
			}
			// 面积
			if (tramodel.getArea() != null && !"".equals(tramodel.getArea())) {

				hql += "and stup.area=" + tramodel.getArea();
			}	
			
			
			List <Trainingvenue>list = (List<Trainingvenue>) QueryUtilDaoImpl.executeQuery(hql, null, mapParam);
			/*System.out.println("as"+hql);
			System.out.println("as"+list.size());*/
		
		return list;
	}
	
}
