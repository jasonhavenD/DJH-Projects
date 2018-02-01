package cn.edu.nwsuaf.Service.Impl;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.TeachertrainingModel;
import cn.edu.nwsuaf.bean.Teachertraining;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class TeachertrainingService extends BaseServiceImpl<Teachertraining> {
	@SuppressWarnings("unchecked")
	public List<String> findYearList() throws ServiceException{
		List list=null;
		try {
			String hql = "SELECT DISTINCT teat.year FROM Teachertraining AS teat";
			 list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			Collections.sort(list);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询年份列表失败",e);
			
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<String> findTrainTypeList() throws ServiceException{
		List list=null;
		try {
			String hql = "SELECT DISTINCT teat.trainType FROM Teachertraining AS teat";
			 list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询年份列表失败",e);
			
		}
		return list;
	}
	
	//导出
	@SuppressWarnings("unchecked")
	public List<Teachertraining> exportallTeatList(TeachertrainingModel teatmodel) throws ServiceException{

		List<Teachertraining> list=null;
		try {
			String hql = "from Teachertraining as teat where " +
					"teat.trainContend like :tpno and " +
					"teat.trainType like :tpn";
					
					
			System.out.println("Service===Year==" + teatmodel.getYear());
			Map<String, String> mapParam = new HashMap<String, String>();
			
			try {
				teatmodel.setTrainContend(java.net.URLDecoder.decode(teatmodel.getTrainContend(),"UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			mapParam.put("tpno", "%" + teatmodel.getTrainContend()+ "%");
			mapParam.put("tpn", "%" + teatmodel.getTrainType()+ "%");
			
			
			if (teatmodel.getYear() != null && !"".equals(teatmodel.getYear())) {

				hql += " and teat.year= '" + teatmodel.getYear()+"'";
			}
			
			
			// 专业
			if (teatmodel.getMajorId() != null
					&& !"".equals(teatmodel.getMajorId())&& !"%".equals(teatmodel.getMajorId())) {

				hql += " and teat.teacher.major.mno= '" + teatmodel.getMajorId()+"'";
			}
			// 学院
			if (teatmodel.getDepartmentId() != null
					&& !"".endsWith(teatmodel.getDepartmentId())) {

				hql += " and teat.teacher.major.department.dno='"
						+ teatmodel.getDepartmentId()+"'";
			}
			list = (List<Teachertraining>) QueryUtilDaoImpl
					.executeQuery(hql, null, mapParam);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("多条件查询失败",e);
		}

		return list;

	}
	@SuppressWarnings("unchecked")
	public List<Teachertraining> findallTeachertrainingList(int page, int rows,String mno,String dno) {

		
		String hql = "";
		List<Teachertraining> list = null;
		if(!mno.equals("000000")){
			hql="from Teachertraining t where t.teacher.major.mno=?";
			String param[]={mno};
			list = (List<Teachertraining>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Teachertraining t where t.teacher.major.department.dno=?";
			String param[]={dno};
			list = (List<Teachertraining>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Teachertraining";
			
			list = (List<Teachertraining>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii==="+list.size());
			
		}
		
		
		
		return list;

	}
	@SuppressWarnings("unchecked")
	// 多条件查询（专利号、专利名称、专业、学院）
	public List<Teachertraining> findTeatList(TeachertrainingModel teatmodel,
			int page, int rows) throws ServiceException{

		List<Teachertraining> list=null;
		try {
			String hql = "from Teachertraining as teat where " +
					"teat.trainContend like :tpno and " +
					"teat.trainType like :tpn";
					
					
			System.out.println("Service===Year==" + teatmodel.getYear());
			Map mapParam = new HashMap();
			try {
				teatmodel.setTrainContend(java.net.URLDecoder.decode(teatmodel.getTrainContend(),"UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			mapParam.put("tpno", "%" + teatmodel.getTrainContend()+ "%");
			mapParam.put("tpn", "%" + teatmodel.getTrainType()+ "%");
			
			
			if (teatmodel.getYear() != null && !"".equals(teatmodel.getYear())) {

				hql += " and teat.year= '" + teatmodel.getYear()+"'";
			}
			
			
			// 专业
			if (teatmodel.getMajorId() != null
					&& !"".equals(teatmodel.getMajorId())&& !"%".equals(teatmodel.getMajorId())) {

				hql += " and teat.teacher.major.mno= '" + teatmodel.getMajorId()+"'";
			}
			// 学院
			if (teatmodel.getDepartmentId() != null
					&& !"".endsWith(teatmodel.getDepartmentId())) {

				hql += " and teat.teacher.major.department.dno='"
						+ teatmodel.getDepartmentId()+"'";
			}
			list = (List<Teachertraining>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, mapParam, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("多条件查询失败",e);
		}

		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindTeat(TeachertrainingModel teatmodel) throws ServiceException {
		
		int count=0;
		String hql = "select count(*) from Teachertraining as teat where " +
					"teat.trainContend like :tpno and " +
					"teat.trainType like :tpn";
		try {
			Map mapParam = new HashMap();
			try {
				teatmodel.setTrainContend(java.net.URLDecoder.decode(teatmodel.getTrainContend(),"UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			mapParam.put("tpno", "%" + teatmodel.getTrainContend()+ "%");
			mapParam.put("tpn", "%" + teatmodel.getTrainType()+ "%");
			
			
			if (teatmodel.getYear() != null && !"".equals(teatmodel.getYear())) {

				hql += " and teat.year= '" + teatmodel.getYear()+"'";
			}
			
			
			
			// 专业
			if (teatmodel.getMajorId() != null
					&& !"".equals(teatmodel.getMajorId())&& !"%".equals(teatmodel.getMajorId())) {

				hql += " and teat.teacher.major.mno= '" + teatmodel.getMajorId()+"'";
			}
			// 学院
			if (teatmodel.getDepartmentId() != null
					&& !"".endsWith(teatmodel.getDepartmentId())) {

				hql += " and teat.teacher.major.department.dno= '"
						+ teatmodel.getDepartmentId()+"'";
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
		String hql = "select count(*) from Teachertraining as stup where "
				+ "stup.year like :tpno";
		Map mapParam = new HashMap();
		// 专利号
		mapParam.put("tpno", "%" + tpno + "%");
		// 专利名称
		
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		return count;
	}
	// 查询结果条数

	public int count(String mno,String dno)
			throws ServiceException {
		int count=0;	
		String hql="";
		if(!mno.equals("000000")){
			hql="select count(*) from  Teachertraining t where t.teacher.major.mno=?";
			String param[]={mno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="select count(*) from Teachertraining t where t.teacher.major.department.dno=?";
			String param[]={dno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			
		}else{
			hql="select count(*) from Teachertraining";
			
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
			
		}
		return count;

	}

}
