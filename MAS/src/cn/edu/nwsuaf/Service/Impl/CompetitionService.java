package cn.edu.nwsuaf.Service.Impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.CompetitionModel;
import cn.edu.nwsuaf.bean.Competition;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class CompetitionService extends BaseServiceImpl<Competition> {

	@SuppressWarnings("unchecked")
	public List<Competition> findallCompetitionList(int page, int rows, String mno,String dno) {
		String hql = "";
		List<Competition> list = null;
		if(!mno.equals("000000")){
			hql="from Competition cTion where cTion.comNumber in(select scTion.competition.comNumber from Studentcoepetition scTion where scTion.student.major.mno=?)";
			String param[]={mno};
			list = (List<Competition>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Competition cTion where cTion.comNumber in(select scTion.competition.comNumber from Studentcoepetition scTion where scTion.student.major.department.dno=?)";
			String param[]={dno};
			list = (List<Competition>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Competition";
			
			list = (List<Competition>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()==="+list.size());	
		}
		return list;
	}
	public int count(String mno, String dno) throws ServiceException {
		int count = 0;
		String hql = "";
		if (!mno.equals("000000")) {
			hql = "select count(*) from  Competition cTion where cTion.comNumber in(select scTion.competition.comNumber from Studentcoepetition scTion where scTion.student.major.mno=?)";
			String param[] = { mno };
			count = QueryUtilDaoImpl.getResultCountForHql(hql, param);
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "select count(*) from Competition cTion where cTion.comNumber in(select scTion.competition.comNumber from Studentcoepetition scTion where scTion.student.major.department.dno=?)";
			String param[] = { dno };
			count = QueryUtilDaoImpl.getResultCountForHql(hql, param);

		} else {
			hql = "select count(*) from Competition";
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null);

		}
		return count;

	}
	@SuppressWarnings( { "unchecked" })
	// 多条件查询（教材编号、教材名称、出版时间、出版社、级别、优秀教材级别、优秀教材奖项级别、专业、学院）
	public List<Competition> findCompesList(CompetitionModel cmodel,
			int page, int rows) throws UnsupportedEncodingException {
	
		String hql = "from Competition as cTion where "
			+ "cTion.comName like :cn";
		Map mapParam = new HashMap();
		
		// 竞赛名称名称
		cmodel.setComName(java.net.URLDecoder.decode(cmodel.getComName(),"UTF-8"));
		mapParam.put("cn", "%" + cmodel.getComName() + "%");
		
		// 年份
		if (cmodel.getYear() != null && !"".equals(cmodel.getYear())) {

			hql += " and cTion.year= " + cmodel.getYear();
		}
		
		// 类别
		if (cmodel.getComType() != null
				&& !"".equals(cmodel.getComType())) {

			hql += " and cTion.comType like :type " ;
			mapParam.put("type", "%" + cmodel.getComType() + "%");
			
		}
		
		// 获奖等级
		if (cmodel.getComRank() != null
				&& !"".equals(cmodel.getComRank())) {

			hql += " and cTion.comRank like :rank " ;
			mapParam.put("rank", "%" + cmodel.getComRank() + "%");
			
		}

		// 学院
		if (cmodel.getDepartmentId() != null
				&& !"".equals(cmodel.getDepartmentId())) {
			hql += " and cTion.comNumber in(select scTion.competition.comNumber from Studentcoepetition scTion where scTion.student.major.department.dno like :dn)";
			mapParam.put("dn", "%" + cmodel.getDepartmentId() + "%");
		}
		//专业
		if (cmodel.getMajorId() != null
				&& !"".equals(cmodel.getMajorId())&& !"%".equals(cmodel.getMajorId())) {
			hql += " and cTion.comNumber in(select scTion.competition.comNumber from Studentcoepetition scTion where scTion.student.major.mno like :mn)";
			mapParam.put("mn", "%" + cmodel.getMajorId() + "%");
		}


		List<Competition> list = (List<Competition>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		//System.out.println(list.toString());
		return list;
	}
	
	// 查询结果条数
	@SuppressWarnings( { "unchecked" })
	public int countFindTtion(CompetitionModel cmodel) throws UnsupportedEncodingException {
		int count=0;
		String hql = "select count(*) from Competition as cTion where "
			+ "cTion.comName like :cn";
		
		Map mapParam = new HashMap();
		// 竞赛名称
		cmodel.setComName(java.net.URLDecoder.decode(cmodel.getComName(),"UTF-8"));
		mapParam.put("cn", "%" + cmodel.getComName() + "%");
		
		// 年份
		if (cmodel.getYear() != null && !"".equals(cmodel.getYear())) {

			hql += " and cTion.year= " + cmodel.getYear();
		}
		
		// 类别
		if (cmodel.getComType() != null
				&& !"".equals(cmodel.getComType())) {

			hql += " and cTion.comType like :type " ;
			mapParam.put("type", "%" + cmodel.getComType() + "%");	
		}
		// 获奖等级
		if (cmodel.getComRank() != null
				&& !"".equals(cmodel.getComRank())) {
			hql += " and cTion.comRank like :rank " ;
			mapParam.put("rank", "%" + cmodel.getComRank() + "%");
			
		}

		// 学院
		if (cmodel.getDepartmentId() != null
				&& !"".equals(cmodel.getDepartmentId())) {
			hql += " and cTion.comNumber in(select scTion.competition.comNumber from Studentcoepetition scTion where scTion.student.major.department.dno like :dn)";
			mapParam.put("dn", "%" + cmodel.getDepartmentId() + "%");
		}
		//专业
		if (cmodel.getMajorId() != null
				&& !"".equals(cmodel.getMajorId())&& !"%".equals(cmodel.getMajorId())) {
			hql += " and cTion.comNumber in(select scTion.competition.comNumber from Studentcoepetition scTion where scTion.student.major.mno like :mn)";
			mapParam.put("mn", "%" + cmodel.getMajorId() + "%");
		}


		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=======" + count);
		return count;

	}
	@SuppressWarnings("unchecked")
	public int isExist(String comNumber) {

		int count = 0;
		String hql = "select count(*) from Competition as a where "
				+ "a.comNumber like :ci ";
		 Map mapParam = new HashMap();
		 // 获奖证书编号
		 mapParam.put("ci",  comNumber);

		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		return count;
	}
	//导出
	@SuppressWarnings("unchecked")
	public List<Competition> exportCompesList(CompetitionModel cmodel) throws UnsupportedEncodingException
	{
		String hql = "from Competition as cTion where "
			+ "cTion.comName like :cn";
		Map mapParam = new HashMap();
		
		// 竞赛名称
		cmodel.setComName(java.net.URLDecoder.decode(cmodel.getComName(),"UTF-8"));
		mapParam.put("cn", "%" + cmodel.getComName() + "%");
		
		// 年份
		if (cmodel.getYear() != null && !"".equals(cmodel.getYear())) {

			hql += " and cTion.year= " + cmodel.getYear();
		}
		
		// 类别
		if (cmodel.getComType() != null
				&& !"".equals(cmodel.getComType())) {

			hql += " and cTion.comType like :type " ;
			mapParam.put("type", "%" + cmodel.getComType() + "%");
			
		}
		
		// 获奖等级
		if (cmodel.getComRank() != null
				&& !"".equals(cmodel.getComRank())) {

			hql += " and cTion.comRank like :rank " ;
			mapParam.put("rank", "%" + cmodel.getComRank() + "%");
			
		}

		// 学院
		if (cmodel.getDepartmentId() != null
				&& !"".equals(cmodel.getDepartmentId())) {
			hql += " and cTion.comNumber in(select scTion.competition.comNumber from Studentcoepetition scTion where scTion.student.major.department.dno like :dn)";
			mapParam.put("dn", "%" + cmodel.getDepartmentId() + "%");
		}
		//专业
		if (cmodel.getMajorId() != null
				&& !"".equals(cmodel.getMajorId())&& !"%".equals(cmodel.getMajorId())) {
			hql += " and cTion.comNumber in(select scTion.competition.comNumber from Studentcoepetition scTion where scTion.student.major.mno like :mn)";
			mapParam.put("mn", "%" + cmodel.getMajorId() + "%");
		}


		List<Competition> list = (List<Competition>) QueryUtilDaoImpl
				.executeQuery(hql, null, mapParam);
		System.out.println(list.size());
		//System.out.println(list.toString());
		return list;
	}

	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() {
		String hql = "SELECT DISTINCT cTion.year FROM Competition AS cTion";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("年份=============" + list.size());
		return list;
	}

	// 返回获奖类别
	@SuppressWarnings("unchecked")
	public List<String> findTypeList() {
		String hql = "SELECT DISTINCT cTion.comType FROM Competition AS cTion";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("类别=============" + list.size());
		return list;
	}

	// 返回获奖等级
	@SuppressWarnings("unchecked")
	public List<String> findRankList() {
		String hql = "SELECT DISTINCT cTion.comRank FROM Competition AS cTion";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("获奖等级=============" + list.size());
		return list;
	}
}
