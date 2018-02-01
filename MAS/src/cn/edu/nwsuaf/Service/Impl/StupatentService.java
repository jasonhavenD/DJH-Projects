package cn.edu.nwsuaf.Service.Impl;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.edu.nwsuaf.Model.StupatentModel;
import cn.edu.nwsuaf.bean.Stupatent;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class StupatentService extends BaseServiceImpl<Stupatent> {
	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() throws ServiceException{
		List list=null;
		try {
			String hql = "SELECT DISTINCT stup.year FROM Stupatent AS stup";
			 list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			Collections.sort(list);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询年份列表失败",e);
			
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Stupatent> findallStupatentList(int page, int rows,String mno,String dno) {

		
		String hql = "";
		List<Stupatent> list = null;
		if(!mno.equals("000000")){
			hql="from Stupatent t where t.student.major.mno=?";
			String param[]={mno};
			list = (List<Stupatent>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Stupatent t where t.student.major.department.dno=?";
			String param[]={dno};
			list = (List<Stupatent>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Stupatent";
			
			list = (List<Stupatent>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii==="+list.size());
			
		}
		
		
		
		return list;

	}
	//导出
	@SuppressWarnings("unchecked")
	public List<Stupatent> exportallStupatentList(StupatentModel stupmodel
			) throws ServiceException{

		List<Stupatent> list=null;
		try {
			String hql = "from Stupatent as stup where "
					+ "stup.patentNumber like :tpno and "
					+ "stup.pateName like :tpn";
			System.out.println("Service===StupatentName==" + stupmodel.getName());
			Map<String, String> mapParam = new HashMap<String, String>();
			// 专利号
			mapParam.put("tpno", "%" + stupmodel.getPatentNumber() + "%");
			// 专利名称
			mapParam.put("tpn", "%" + stupmodel.getName() + "%");
			// 年份
			if (stupmodel.getYear() != null && !"".equals(stupmodel.getYear())) {

				hql += " and stup.year= " + stupmodel.getYear();
			}

			// 学号
			if (stupmodel.getStuNumber() != null
					&& !"".equals(stupmodel.getStuNumber())) {
				System.out.println(stupmodel.getStuNumber());
				hql += " and stup.student.stuNumber= " + stupmodel.getStuNumber();
			}
			// 申请人姓名
			stupmodel.setStuName(java.net.URLDecoder.decode(stupmodel.getStuName(),"UTF-8"));
			if (stupmodel.getStuName() != null
					&& !"".equals(stupmodel.getStuName())) {
				hql += " and stup.student.stuName= '" + stupmodel.getStuName()+"'";
			}
			// 专利类别
			if (stupmodel.getPateType() != null
					&& !"".equals(stupmodel.getPateType())) {

				hql += " and stup.pateType= " + stupmodel.getPateType();
			}
			// 专业
			if (stupmodel.getMajorId() != null
					&& !"".equals(stupmodel.getMajorId()) && !"%".equals(stupmodel.getMajorId())) {

				hql += " and stup.student.major.mno= '" + stupmodel.getMajorId()+"'";
			}
			// 学院
			if (stupmodel.getDepartmentId() != null
					&& !"".endsWith(stupmodel.getDepartmentId())) {

				hql += " and stup.student.major.department.dno= '"
						+ stupmodel.getDepartmentId()+"'";
			}
			System.out.println(hql);
			list = (List<Stupatent>) QueryUtilDaoImpl
					.executeQuery(hql, null, mapParam);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("多条件查询失败",e);
		}

		return list;

	}
	@SuppressWarnings("unchecked")
	// 多条件查询（专利号、专利名称、专业、学院）
	public List<Stupatent> findStupatentList(StupatentModel stupmodel,
			int page, int rows) throws ServiceException{

		List<Stupatent> list=null;
		try {
			String hql = "from Stupatent as stup where "
					+ "stup.patentNumber like :tpno and "
					+ "stup.pateName like :tpn";
			System.out.println("Service===StupatentName==" + stupmodel.getName());
			Map mapParam = new HashMap();
			// 专利号
			mapParam.put("tpno", "%" + stupmodel.getPatentNumber() + "%");
			try {
				stupmodel.setName(java.net.URLDecoder.decode(stupmodel.getName(),"UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// 专利名称
			mapParam.put("tpn", "%" + stupmodel.getName() + "%");
			// 年份
			if (stupmodel.getYear() != null && !"".equals(stupmodel.getYear())) {

				hql += " and stup.year= " + stupmodel.getYear();
			}

			// 学号
			if (stupmodel.getStuNumber() != null
					&& !"".equals(stupmodel.getStuNumber())) {
				hql += " and stup.student.stuNumber= " + stupmodel.getStuNumber();
			}
			// 申请人姓名
			//stupmodel.setStuName(java.net.URLDecoder.decode(stupmodel.getStuName(),"UTF-8"));		
			if (stupmodel.getStuName() != null
					&& !"".equals(stupmodel.getStuName())) {
				hql += " and stup.student.stuName= '" + stupmodel.getStuName()+"'";
			}
			// 专利类别
			if (stupmodel.getPateType() != null
					&& !"".equals(stupmodel.getPateType())) {

				hql += " and stup.pateType= '" + stupmodel.getPateType()+"'";
			}
			// 专业
			if (stupmodel.getMajorId() != null
					&& !"".equals(stupmodel.getMajorId()) && !"%".equals(stupmodel.getMajorId())) {

				hql += " and stup.student.major.mno= '" + stupmodel.getMajorId()+"'";
			}
			// 学院
			if (stupmodel.getDepartmentId() != null
					&& !"".endsWith(stupmodel.getDepartmentId())) {

				hql += " and stup.student.major.department.dno= '"
						+ stupmodel.getDepartmentId()+"'";
			}
			System.out.println(hql);
			list = (List<Stupatent>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, mapParam, page, rows);
		} catch (Exception e) {
			
			throw new ServiceException("多条件查询失败",e);
		}

		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindStupatent(StupatentModel stupmodel) throws ServiceException {
		
		int count=0;
		String hql = "select count(*) from Stupatent as stup where "
				+ "stup.patentNumber like :tpno and "
				+ "stup.pateName like :tpn";
		
		try {
			Map mapParam = new HashMap();
			// 专利号
			mapParam.put("tpno", "%" + stupmodel.getPatentNumber() + "%");
			// 专利名称
			stupmodel.setName(java.net.URLDecoder.decode(stupmodel.getName(),"UTF-8"));
			mapParam.put("tpn", "%" + stupmodel.getName() + "%");
			// 年份
			if (stupmodel.getYear() != null && !"".equals(stupmodel.getYear())) {

				hql += " and stup.year= " + stupmodel.getYear();
			}

			// 学号
			if (stupmodel.getStuNumber() != null
					&& !"".equals(stupmodel.getStuNumber())) {

				hql += " and stup.student.stuNumber= " + stupmodel.getStuNumber();
			}
			// 申请人姓名
			if (stupmodel.getStuName() != null
					&& !"".equals(stupmodel.getStuName())) {

				hql += " and stup.student.stuName= '" + stupmodel.getStuName()+"'";
			}
			// 专业
			if (stupmodel.getMajorId() != null
					&& !"".equals(stupmodel.getMajorId()) && !"%".equals(stupmodel.getMajorId())) {

				hql += " and stup.student.major.mno= '" + stupmodel.getMajorId()+"'";
			}
			// 学院
			if (stupmodel.getDepartmentId() != null
					&& !"".endsWith(stupmodel.getDepartmentId())) {

				hql += " and stup.student.major.department.dno= '"
					+ stupmodel.getDepartmentId()+"'";
			}
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		} catch (Exception e) {
			
			throw new ServiceException("查询结果条数失败", e);
		}
		System.out.println("count=========" + count);
		return count;

	}
	public int isExist(String tpno) {
		
		int count=0;
		String hql = "select count(*) from Stupatent as stup where "
				+ "stup.patentNumber = '"+ tpno+"'";
		
		
		
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, null);
		return count;
	}
	// 查询结果条数

	public int count(String mno,String dno)
			throws ServiceException {
		int count=0;	
		String hql="";
		if(!mno.equals("000000")){
			hql="select count(*) from  Stupatent t where t.student.major.mno=?";
			String param[]={mno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="select count(*) from Stupatent t where t.student.major.department.dno=?";
			String param[]={dno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			
		}else{
			hql="select count(*) from Stupatent";
			
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
			
		}
		return count;

	}

	
}
