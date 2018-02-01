package cn.edu.nwsuaf.Service.Impl;

import cn.edu.nwsuaf.bean.Achievements;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.edu.nwsuaf.Model.AchieveModel;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class AchievementService extends BaseServiceImpl<Achievements> {

	@SuppressWarnings("unchecked")
	public List<Achievements> findallAchievementsList(int page, int rows, String mno,String dno) {
		String hql = "";
		List<Achievements> list = null;
		if(!mno.equals("000000")){
			hql="from Achievements a where a.certificateNo in(select ta.achievements.certificateNo from Teacherachievements ta where ta.teacher.major.mno=?)";
			String param[]={mno};
			list = (List<Achievements>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Achievements a where a.certificateNo in(select ta.achievements.certificateNo from Teacherachievements ta where ta.teacher.major.department.dno=?)";
			String param[]={dno};
			list = (List<Achievements>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Achievements";		
			list = (List<Achievements>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()==="+list.size());
			
		}
		return list;
	}

	public int count(String mno, String dno) throws ServiceException {
		int count = 0;
		String hql = "";
		if (!mno.equals("000000")) {
			hql = "select count(*) from  Achievements a where a.certificateNo in(select ta.achievements.certificateNo from Teacherachievements ta where ta.teacher.major.mno=?)";
			String param[] = { mno };
			count = QueryUtilDaoImpl.getResultCountForHql(hql, param);
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "select count(*) from Achievements a where a.certificateNo in(select ta.achievements.certificateNo from Teacherachievements ta where ta.teacher.major.department.dno=?)";
			String param[] = { dno };
			count = QueryUtilDaoImpl.getResultCountForHql(hql, param);

		} else {
			hql = "select count(*) from Achievements";
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null);

		}
		return count;
	}
	@SuppressWarnings("unchecked")
	// 多条件查询（获奖证书编号、成果名称、专业、学院）
	public List<Achievements> findAchievementsList(AchieveModel amodel,
			int page, int rows) throws UnsupportedEncodingException {
		String hql = "from Achievements as a where "
				+ "a.certificateNo like :ci and "
				+ "a.certificateName like :an";

		Map mapParam = new HashMap();
		// 获奖证书编号
		mapParam.put("ci", "%" + amodel.getId() + "%");
		// 成果名称
		mapParam.put("an", "%" + amodel.getName() + "%");
		// 年份
		if (amodel.getCertificateDate() != null
				&& !"".equals(amodel.getCertificateDate())) {
			hql += " and a.certificateDate='" + amodel.getCertificateDate()+"'";

		}
		// 获奖级别
		if (amodel.getCertificateJibie() != null
				&& !"".equals(amodel.getCertificateJibie())) {
			amodel.setCertificateJibie(java.net.URLDecoder.decode(amodel.getCertificateJibie(),"UTF-8"));
			hql += " and a.certificateJibie='"+ amodel.getCertificateJibie() + "'";

		}
		// 获奖类别
		if (amodel.getCertificateType() != null
				&& !"".equals(amodel.getCertificateType())) {
			amodel.setCertificateType(java.net.URLDecoder.decode(amodel.getCertificateType(),"UTF-8"));
			hql += " and a.certificateType='" + amodel.getCertificateType() + "'";
		}
		// 获奖等级
		if (amodel.getCertificateClass() != null
				&& !"".equals(amodel.getCertificateClass())) {
			amodel.setCertificateClass(java.net.URLDecoder.decode(amodel.getCertificateClass(),"UTF-8"));
			hql += " and a.certificateClass='"+ amodel.getCertificateClass() + "'";
		}
		// 学院
		if (amodel.getDepartmentId() != null
				&& !"".equals(amodel.getDepartmentId())) {
			hql += " and a.certificateNo in(select ta.achievements.certificateNo from Teacherachievements ta where ta.teacher.major.department.dno like :dn)";
			mapParam.put("dn", "%" + amodel.getDepartmentId() + "%");
		}
		// 专业
		if (amodel.getMajorId() != null && !"".equals(amodel.getMajorId())&& !"%".equals(amodel.getMajorId())) {
			hql += " and a.certificateNo in(select ta.achievements.certificateNo from Teacherachievements ta where ta.teacher.major.mno like :mn)";
			mapParam.put("mn", "%" + amodel.getMajorId() + "%");
		}
		List<Achievements> list = (List<Achievements>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindAchievements(AchieveModel amodel) throws UnsupportedEncodingException {
		int count = 0;
		String hql = "select count(*) from Achievements as a where "
				+ "a.certificateNo like :ci and "
				+ "a.certificateName like :an";
		Map mapParam = new HashMap();
		// 获奖证书编号
		mapParam.put("ci", "%" + amodel.getId() + "%");
		// 成果名称
		mapParam.put("an", "%" + amodel.getName() + "%");
		// 年份
		if (amodel.getCertificateDate() != null
				&& !"".equals(amodel.getCertificateDate())) {
			hql += " and a.certificateDate='" + amodel.getCertificateDate()+"'";
		}
		// 获奖级别
		if (amodel.getCertificateJibie() != null
				&& !"".equals(amodel.getCertificateJibie())) {
			amodel.setCertificateJibie(java.net.URLDecoder.decode(amodel.getCertificateJibie(),"UTF-8"));
			hql += " and a.certificateJibie='"+ amodel.getCertificateJibie() + "'";

		}
		// 获奖类别
		if (amodel.getCertificateType() != null
				&& !"".equals(amodel.getCertificateType())) {
			amodel.setCertificateType(java.net.URLDecoder.decode(amodel.getCertificateType(),"UTF-8"));
			hql += " and a.certificateType='" + amodel.getCertificateType() + "'";
		}
		// 获奖等级
		if (amodel.getCertificateClass() != null
				&& !"".equals(amodel.getCertificateClass())) {
			amodel.setCertificateClass(java.net.URLDecoder.decode(amodel.getCertificateClass(),"UTF-8"));
			hql += " and a.certificateClass='"+ amodel.getCertificateClass() + "'";
		}// 学院
		if (amodel.getDepartmentId() != null
				&& !"".equals(amodel.getDepartmentId())) {
			hql += " and a.certificateNo in(select ta.achievements.certificateNo from Teacherachievements ta where ta.teacher.major.department.dno like :dn)";
			mapParam.put("dn", "%" + amodel.getDepartmentId() + "%");
		}
		// 专业
		if (amodel.getMajorId() != null && !"".equals(amodel.getMajorId())&& !"%".equals(amodel.getMajorId())) {
			hql += " and a.certificateNo in(select ta.achievements.certificateNo from Teacherachievements ta where ta.teacher.major.mno like :mn)";
			mapParam.put("mn", "%" + amodel.getMajorId() + "%");
		}
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=========" + count);
		return count;

	}

	@SuppressWarnings("unchecked")
	public int isExist(String certificateNo) {

		int count = 0;
		String hql = "select count(*) from Achievements as a where "
				+ "a.certificateNo = :ci ";
		Map mapParam = new HashMap();
		// 获奖证书编号
		mapParam.put("ci",  certificateNo );

		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		return count;
	}

	// 导出
	@SuppressWarnings("unchecked")
	public List<Achievements> exportAchievementsList(AchieveModel amodel) throws UnsupportedEncodingException {

		String hql = "from Achievements as a where "
			+ "a.certificateNo like :ci and "
			+ "a.certificateName like :an";

	Map mapParam = new HashMap();
	// 获奖证书编号
	mapParam.put("ci", "%" + amodel.getId() + "%");
	// 成果名称
	amodel.setName(java.net.URLDecoder.decode(amodel.getName(),"UTF-8"));
	mapParam.put("an", "%" + amodel.getName() + "%");
	// 年份
	if (amodel.getCertificateDate() != null
			&& !"".equals(amodel.getCertificateDate())) {
		hql += " and a.certificateDate= '" + amodel.getCertificateDate()+"'";
		System.out.println(amodel.getCertificateDate());
	}
	// 获奖级别
	if (amodel.getCertificateJibie() != null
			&& !"".equals(amodel.getCertificateJibie())) {
		amodel.setCertificateJibie(java.net.URLDecoder.decode(amodel.getCertificateJibie(),"UTF-8"));
		hql += " and a.certificateJibie like :jibie ";
		mapParam.put("jibie", "%" + amodel.getCertificateJibie() + "%");

	}
	// 获奖类别
	if (amodel.getCertificateType() != null
			&& !"".equals(amodel.getCertificateType())) {
		amodel.setCertificateType(java.net.URLDecoder.decode(amodel.getCertificateType(),"UTF-8"));
		hql += " and a.certificateType like :type ";
		mapParam.put("type", "%" + amodel.getCertificateType() + "%");
	}
	// 获奖等级
	if (amodel.getCertificateClass() != null
			&& !"".equals(amodel.getCertificateClass())) {
		amodel.setCertificateClass(java.net.URLDecoder.decode(amodel.getCertificateClass(),"UTF-8"));
		System.out.println(amodel.getCertificateClass());
		hql += " and a.certificateClass like :ticlass ";
		mapParam.put("ticlass", "%" + amodel.getCertificateClass() + "%");
		
	}
	
	
	// 学院
	if (amodel.getDepartmentId() != null
			&& !"".equals(amodel.getDepartmentId())) {
		hql += " and a.certificateNo in(select ta.achievements.certificateNo from Teacherachievements ta where ta.teacher.major.department.dno like :dn)";
		mapParam.put("dn", "%" + amodel.getDepartmentId() + "%");
	}
	// 专业
	if (amodel.getMajorId() != null && !"".equals(amodel.getMajorId())&& !"%".equals(amodel.getMajorId())) {
		hql += " and a.certificateNo in(select ta.achievements.certificateNo from Teacherachievements ta where ta.teacher.major.mno like :mn)";
		mapParam.put("mn", "%" + amodel.getMajorId() + "%");
	}
	System.out.println(hql);
	List<Achievements> list = (List<Achievements>) QueryUtilDaoImpl
	.executeQuery(hql, null, mapParam);
	System.out.println(list.toString());
	return list;
	}

	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findCertificateDateList() {
		String hql = "SELECT DISTINCT a.certificateDate FROM Achievements AS a";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("年份=============" + list.size());
		return list;
	}

	// 返回获奖级别
	@SuppressWarnings("unchecked")
	public List<String> findCertificateJibieList() {
		String hql = "SELECT DISTINCT a.certificateJibie FROM Achievements AS a";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("级别=============" + list.size());
		return list;
	}

	// 返回获奖类别
	@SuppressWarnings("unchecked")
	public List<String> findCertificateTypeList() {
		String hql = "SELECT DISTINCT a.certificateType FROM Achievements AS a";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("类别=============" + list.size());
		return list;
	}

	// 返回获奖等级
	@SuppressWarnings("unchecked")
	public List<String> findCertificateClassList() {
		String hql = "SELECT DISTINCT a.certificateClass FROM Achievements AS a";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("等级=============" + list.size());
		return list;
	}

}
