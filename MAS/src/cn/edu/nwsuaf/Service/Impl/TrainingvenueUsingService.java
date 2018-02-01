package cn.edu.nwsuaf.Service.Impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.bean.Trainingvenueuse;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class TrainingvenueUsingService extends BaseServiceImpl<Trainingvenueuse>{
	//分页获取全部实验室信息
	@SuppressWarnings("unchecked")
	public List<Trainingvenueuse> findallTrainingvenueuseList(int page, int rows,String mno ,String dno) {
		String hql = "";
		List<Trainingvenueuse> list = null;
		if(!mno.equals("000000")){
			hql="from Trainingvenueuse a where a.major.mno=?";
			String param[]={mno};
			list = (List<Trainingvenueuse>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Trainingvenueuse a where a.major.department.dno=?";
			String param[]={dno};
			list = (List<Trainingvenueuse>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Trainingvenueuse";
			
			list = (List<Trainingvenueuse>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()列表长度==="+list.size());
			
		}
		return list;
	}

	
	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() throws ServiceException{
		List list=null;
		try {
			String hql = "SELECT DISTINCT stup.year FROM Trainingvenueuse AS stup";
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
	public List<Trainingvenueuse> findTrainingvenueuseList(BaseModel tramodel,
			int page, int rows) throws ServiceException{

		List<Trainingvenueuse> list=null;
		
			String hql = "from Trainingvenueuse as stup where "
			+ "stup.trainingvenue.traName like :tpno "+"and stup.trainingvenue.traNumer like :tpn ";
			Map mapParam = new HashMap();
			
			mapParam.put("tpno", "%" + tramodel.getName()+"%");
			mapParam.put("tpn", "%" + tramodel.getId()+"%");

			// 年份
			if (tramodel.getYear() != null && !"".equals(tramodel.getYear())) {

				hql += "and stup.year=" + tramodel.getYear();
			}
			// 学院
			if (tramodel.getDepartmentId() != null
					&& !"".equals(tramodel.getDepartmentId())) {
				hql += " and stup.major.department.dno='"+tramodel.getDepartmentId()+"'";
				
			}
			// 专业
			if (tramodel.getMajorId() != null && !"".equals(tramodel.getMajorId())&& !"%".equals(tramodel.getMajorId())) {
				hql += " and stup.major.mno='"+tramodel.getMajorId()+"'";
			}
			
			System.out.println("as"+hql+page+rows);
			list = (List<Trainingvenueuse>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, mapParam, page, rows);
		return list;

	}
	
	
	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindTrainingvenueuse(BaseModel tramodel) throws ServiceException {
		int count=0;
		String hql = "select count(*) from Trainingvenueuse as stup where "
			+ "stup.trainingvenue.traName like :tpno "+"and stup.trainingvenue.traNumer like :tpn ";
		Map mapParam = new HashMap();
		try{
		mapParam.put("tpno", "%" + tramodel.getName()+"%");
		mapParam.put("tpn", "%" + tramodel.getId()+"%");

		// 年份
		if (tramodel.getYear() != null && !"".equals(tramodel.getYear())) {

			hql += "and stup.year= " + tramodel.getYear();
		}
		// 学院
		if (tramodel.getDepartmentId() != null
				&& !"".equals(tramodel.getDepartmentId())) {
			hql += " and stup.major.department.dno='"+tramodel.getDepartmentId()+"'";
			
		}
		// 专业
		if (tramodel.getMajorId() != null && !"".equals(tramodel.getMajorId())&& !"%".equals(tramodel.getMajorId())) {
			hql += " and stup.major.mno='"+tramodel.getMajorId()+"'";
		}
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
			hql="select count(*) from Trainingvenueuse a where a.major.mno=?";
			String param[] = { mno };
			count = QueryUtilDaoImpl.getResultCountForHql(hql, param);
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql="select count(*) from Trainingvenueuse a where a.major.department.dno=?";
			String param[] = { dno };
			count = QueryUtilDaoImpl.getResultCountForHql(hql, param);

		} else {
			hql = "select count(*) from Trainingvenueuse";
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null);

		}
		return count;
	}
	// 导出
	@SuppressWarnings("unchecked")
	public List<Trainingvenueuse> exportTrauseList(BaseModel tramodel) {
		List<Trainingvenueuse> list=null;
		String hql = "from Trainingvenueuse as stup where "
			+ "stup.trainingvenue.traName like :tpno "+"and stup.trainingvenue.traNumer like :tpn ";
			Map mapParam = new HashMap();
			
			mapParam.put("tpno", "%" + tramodel.getName()+"%");
			mapParam.put("tpn", "%" + tramodel.getId()+"%");

			// 年份
			if (tramodel.getYear() != null && !"".equals(tramodel.getYear())) {

				hql += "and stup.year=" + tramodel.getYear();
			}
			// 学院
			if (tramodel.getDepartmentId() != null
					&& !"".equals(tramodel.getDepartmentId())) {
				hql += " and stup.major.department.dno='"+tramodel.getDepartmentId()+"'";
				
			}
			// 专业
			if (tramodel.getMajorId() != null && !"".equals(tramodel.getMajorId())&& !"%".equals(tramodel.getMajorId())) {
				hql += " and stup.major.mno='"+tramodel.getMajorId()+"'";
			}
			
			list = (List<Trainingvenueuse>) QueryUtilDaoImpl
					.executeQuery(hql, null, mapParam);
		return list;
	}
}
