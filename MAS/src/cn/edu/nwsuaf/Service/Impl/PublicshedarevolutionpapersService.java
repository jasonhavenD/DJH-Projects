package cn.edu.nwsuaf.Service.Impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.PublicshedarevolutionpapersModel;
import cn.edu.nwsuaf.bean.Publicshedarevolutionpapers;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class PublicshedarevolutionpapersService extends BaseServiceImpl<Publicshedarevolutionpapers> {
	@SuppressWarnings("unchecked")
	public List<String> findYearList() throws ServiceException{
		List list=null;
		try {
			String hql = "SELECT DISTINCT pep.year FROM Publicshedarevolutionpapers AS pep";
			 list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			Collections.sort(list);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询年份列表失败",e);
			
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<String> findPeriodicalTypeList() throws ServiceException{
		List list=null;
		try {
			String hql = "SELECT DISTINCT pep.periodicalType FROM Publicshedarevolutionpapers AS pep";
			 list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			Collections.sort(list);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询年份列表失败",e);
			
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Publicshedarevolutionpapers> findallPublicshedarevolutionpapersList(int page, int rows,String mno,String dno) {

		
		String hql = "";
		List<Publicshedarevolutionpapers> list = null;
		if(!mno.equals("000000")){
			hql="from Publicshedarevolutionpapers t where t.teacher.major.mno=?";
			String param[]={mno};
			list = (List<Publicshedarevolutionpapers>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Publicshedarevolutionpapers t where t.teacher.major.department.dno=?";
			String param[]={dno};
			list = (List<Publicshedarevolutionpapers>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Publicshedarevolutionpapers";
			
			list = (List<Publicshedarevolutionpapers>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii==="+list.size());			
		}
				
		return list;

	}
	//导出
	@SuppressWarnings("unchecked")
	public List<Publicshedarevolutionpapers> exportallPepList(PublicshedarevolutionpapersModel pepmodel) throws ServiceException{

		List<Publicshedarevolutionpapers> list=null;
		try {
			String hql = "from Publicshedarevolutionpapers as pep where "
		+ "pep.revoPaperName like :tpno and "
		+ "pep.periodicalType like :tpn";
			
			Map<String, String> mapParam = new HashMap<String, String>();
			// 年份
			mapParam.put("tpno", "%" + pepmodel.getRevoPaperName() + "%");
			mapParam.put("tpn", "%" + pepmodel.getPeriodicalType() + "%");
			
			if (pepmodel.getYear() != null && !"".equals(pepmodel.getYear())) {

				hql += " and pep.year= " +pepmodel.getYear();
			}
			
			
			// 专业
			if (pepmodel.getMajorId() != null
					&& !"".equals(pepmodel.getMajorId())&& !"%".equals(pepmodel.getMajorId())) {

				hql += " and pep.teacher.major.mno= '" + pepmodel.getMajorId()+"'";
			}
			// 学院
			if (pepmodel.getDepartmentId() != null
					&& !"".endsWith(pepmodel.getDepartmentId())) {

				hql += " and pep.teacher.major.department.dno='"
						+ pepmodel.getDepartmentId()+"'";
			}
			//System.out.println(hql);
			list = (List<Publicshedarevolutionpapers>) QueryUtilDaoImpl
					.executeQuery(hql, null, mapParam);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("多条件查询失败",e);
		}

		return list;

	}
	@SuppressWarnings("unchecked")
	// 多条件查询（专利号、专利名称、专业、学院）
	public List<Publicshedarevolutionpapers> findPepList(PublicshedarevolutionpapersModel pepmodel,
			int page, int rows) throws ServiceException{

		List<Publicshedarevolutionpapers> list=null;
		try {
			String hql = "from Publicshedarevolutionpapers as pep where "
		+ "pep.revoPaperName like :tpno and "
		+ "pep.periodicalType like :tpn";
			
			Map mapParam = new HashMap();
			// 年份
			mapParam.put("tpno", "%" + pepmodel.getRevoPaperName() + "%");
			mapParam.put("tpn", "%" + pepmodel.getPeriodicalType() + "%");
			
			if (pepmodel.getYear() != null && !"".equals(pepmodel.getYear())) {

				hql += " and pep.year= " +pepmodel.getYear();
			}
			
			
			// 专业
			if (pepmodel.getMajorId() != null
					&& !"".equals(pepmodel.getMajorId())&& !"%".equals(pepmodel.getMajorId())) {

				hql += " and pep.teacher.major.mno= '" + pepmodel.getMajorId()+"'";
			}
			// 学院
			if (pepmodel.getDepartmentId() != null
					&& !"".endsWith(pepmodel.getDepartmentId())) {

				hql += " and pep.teacher.major.department.dno='"
						+ pepmodel.getDepartmentId()+"'";
			}
			System.out.println(hql);
			list = (List<Publicshedarevolutionpapers>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, mapParam, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("多条件查询失败",e);
		}

		return list;

	}
	@SuppressWarnings("unchecked")
	// 多条件清空（专利号、专利名称、专业、学院）
	public List<Publicshedarevolutionpapers> clearPepList(PublicshedarevolutionpapersModel pepmodel) throws ServiceException{

		List<Publicshedarevolutionpapers> list=null;
		try {
			String hql = "from Publicshedarevolutionpapers as pep where "
		+ "pep.revoPaperName like :tpno and "
		+ "pep.periodicalType like :tpn";
			
			Map mapParam = new HashMap();
			// 年份
			mapParam.put("tpno", "%" + pepmodel.getRevoPaperName() + "%");
			mapParam.put("tpn", "%" + pepmodel.getPeriodicalType() + "%");
			
			if (pepmodel.getYear() != null && !"".equals(pepmodel.getYear())) {

				hql += " and pep.year= " +pepmodel.getYear();
			}			
			
			// 专业
			if (pepmodel.getMajorId() != null
					&& !"".equals(pepmodel.getMajorId())&& !"%".equals(pepmodel.getMajorId())) {

				hql += " and pep.teacher.major.mno= '" + pepmodel.getMajorId()+"'";
			}
			// 学院
			if (pepmodel.getDepartmentId() != null
					&& !"".endsWith(pepmodel.getDepartmentId())) {

				hql += " and pep.teacher.major.department.dno='"
						+ pepmodel.getDepartmentId()+"'";
			}
			list = (List<Publicshedarevolutionpapers>) QueryUtilDaoImpl
					.executeQuery(hql, null, mapParam);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("多条件删除失败",e);
		}

		return list;

	}
	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindPep(PublicshedarevolutionpapersModel pepmodel) throws ServiceException {
		
		int count=0;
		String hql = "select count(*) from Publicshedarevolutionpapers as pep where " 
		+"pep.revoPaperName like :tpno and "
		+ "pep.periodicalType like :tpn";	
			
	
				
		try {
			Map mapParam = new HashMap();
			// 年份
			mapParam.put("tpno", "%" + pepmodel.getRevoPaperName() + "%");
			mapParam.put("tpn", "%" + pepmodel.getPeriodicalType() + "%");
			
			if (pepmodel.getYear() != null && !"".equals(pepmodel.getYear())) {

				hql += " and pep.year= " +pepmodel.getYear();
			}
												
			// 专业
			if (pepmodel.getMajorId() != null
					&& !"".equals(pepmodel.getMajorId())&& !"%".equals(pepmodel.getMajorId())) {

				hql += " and pep.teacher.major.mno= '" + pepmodel.getMajorId()+"'";
			}
			// 学院
			if (pepmodel.getDepartmentId() != null
					&& !"".endsWith(pepmodel.getDepartmentId())) {

				hql += " and pep.teacher.major.department.dno= '"
						+ pepmodel.getDepartmentId()+"'";
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
		String hql = "select count(*) from Publicshedarevolutionpapers as stup where "
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
			hql="select count(*) from  Publicshedarevolutionpapers t where t.teacher.major.mno=?";
			String param[]={mno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="select count(*) from Publicshedarevolutionpapers t where t.teacher.major.department.dno=?";
			String param[]={dno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			
		}else{
			hql="select count(*) from Publicshedarevolutionpapers";
			
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
			
		}
		return count;

	}

}
