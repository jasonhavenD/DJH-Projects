package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import cn.edu.nwsuaf.Model.TeachReBaseModel;
import cn.edu.nwsuaf.bean.Teachresultbaseinfo;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class TeachResultBaseService extends
		BaseServiceImpl<Teachresultbaseinfo> {

	@SuppressWarnings("unchecked")
	public List<Teachresultbaseinfo> findallTeachresultbaseinfoList(int page,
			int rows, String mno, String dno) {
		String hql = "from Teachresultbaseinfo tr ";
		List<Teachresultbaseinfo> list = null;
		if (!mno.equals("000000")) {
			hql += "where tr.tresultBaseNo in(select trb.teachresultbaseinfo.tresultBaseNo from Teachresult trb where trb.teacher.major.mno=?)";
			String param[] = { mno };
			list = (List<Teachresultbaseinfo>) QueryUtilDaoImpl
					.executeQueryByPage(hql, param, page, rows);
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql += "where tr.tresultBaseNo in(select trb.teachresultbaseinfo.tresultBaseNo from Teachresult trb where trb.teacher.major.department.dno=?)";
			String param[] = { dno };
			list = (List<Teachresultbaseinfo>) QueryUtilDaoImpl
					.executeQueryByPage(hql, param, page, rows);
		} else {
			list = (List<Teachresultbaseinfo>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()===" + list.size());

		}
		return list;
	}

	public int count(String mno, String dno) throws ServiceException {
		int count = 0;
		String hql = "";
		if (!mno.equals("000000")) {
			hql = "select count(*) from  Teachresultbaseinfo tr where tr.tresultBaseNo in(select trb.teachresultbaseinfo.tresultBaseNo from Teachresult trb where trb.teacher.major.mno=?)";
			String param[] = { mno };
			count = QueryUtilDaoImpl.getResultCountForHql(hql, param);
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "select count(*) from Teachresultbaseinfo tr where tr.tresultBaseNo in(select trb.teachresultbaseinfo.tresultBaseNo from Teachresult trb where trb.teacher.major.department.dno=?)";
			String param[] = { dno };
			count = QueryUtilDaoImpl.getResultCountForHql(hql, param);

		} else {
			hql = "select count(*) from Teachresultbaseinfo";
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null);

		}
		return count;

	}

	@SuppressWarnings("unchecked")
	// 多条件查询（获奖证书编号、成果名称、专业、学院）
	public List<Teachresultbaseinfo> findTeRebaseinfoList(
			TeachReBaseModel tmodel, int page, int rows) {
		String hql = "from Teachresultbaseinfo as tr where "
				+ "tr.tresultName like :an";
		Map mapParam = new HashMap();
		// 教学成果名称
		mapParam.put("an", "%" + tmodel.getTresultName() + "%");
		// 年份
		if (tmodel.getYear() != null && !"".equals(tmodel.getYear())) {
			hql += " and tr.year= " + tmodel.getYear();
		}
		// 获奖级别
		if (tmodel.getTresultJibie() != null
				&& !"".equals(tmodel.getTresultJibie())) {
			hql += " and tr.tresultJibie like :jibie ";
			mapParam.put("jibie", "%" + tmodel.getTresultJibie() + "%");
		}
		// 获奖等级
		if (tmodel.getTresultClass() != null
				&& !"".equals(tmodel.getTresultClass())) {
			hql += " and tr.tresultClass like :ticlass ";
			mapParam.put("ticlass", "%" + tmodel.getTresultClass() + "%");
		}
		// 学院
		if (tmodel.getDepartmentId() != null
				&& !"".equals(tmodel.getDepartmentId())) {
			hql += " and tr.tresultBaseNo in(select trb.teachresultbaseinfo.tresultBaseNo from Teachresult trb where trb.teacher.major.department.dno like :dn)";
			mapParam.put("dn", "%" + tmodel.getDepartmentId() + "%");
		}
		// 专业
		if (tmodel.getMajorId() != null && !"".equals(tmodel.getMajorId()) && !"%".equals(tmodel.getMajorId())) {
			hql += " and tr.tresultBaseNo in(select trb.teachresultbaseinfo.tresultBaseNo from Teachresult trb where trb.teacher.major.mno like :mn)";
			mapParam.put("mn", "%" + tmodel.getMajorId() + "%");
		}

		List<Teachresultbaseinfo> list = (List<Teachresultbaseinfo>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		return list;
	}

	@SuppressWarnings("unchecked")
	// 多条件查询（获奖证书编号、成果名称、专业、学院）
	public int countTeRebaseinfoList(TeachReBaseModel tmodel) {
		String hql = "select count(*) from Teachresultbaseinfo as tr where "
				+ "tr.tresultName like :an";
		int count = 0;
		Map mapParam = new HashMap();
		// 教学成果名称
		mapParam.put("an", "%" + tmodel.getTresultName() + "%");
		// 年份
		if (tmodel.getYear() != null && !"".equals(tmodel.getYear())) {
			hql += " and tr.year= " + tmodel.getYear();
		}
		// 获奖级别
		if (tmodel.getTresultJibie() != null
				&& !"".equals(tmodel.getTresultJibie())) {

			hql += " and tr.tresultJibie like :jibie ";
			mapParam.put("jibie", "%" + tmodel.getTresultJibie() + "%");
		}

		// 获奖等级
		if (tmodel.getTresultClass() != null
				&& !"".equals(tmodel.getTresultClass())) {
			hql += " and tr.tresultClass like :ticlass ";
			mapParam.put("ticlass", "%" + tmodel.getTresultClass() + "%");
		}
		// 学院
		if (tmodel.getDepartmentId() != null
				&& !"".equals(tmodel.getDepartmentId())) {
			hql += " and tr.tresultBaseNo in(select trb.teachresultbaseinfo.tresultBaseNo from Teachresult trb where trb.teacher.major.department.dno like :dn)";
			mapParam.put("dn", "%" + tmodel.getDepartmentId() + "%");
		}
		// 专业
		if (tmodel.getMajorId() != null && !"".equals(tmodel.getMajorId()) && !"%".equals(tmodel.getMajorId())) {
			hql += " and tr.tresultBaseNo in(select trb.teachresultbaseinfo.tresultBaseNo from Teachresult trb where trb.teacher.major.mno like :mn)";
			mapParam.put("mn", "%" + tmodel.getMajorId() + "%");
		}

		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		return count;
	}

	@SuppressWarnings("unchecked")
	public int isExist(int tresultBaseNo) {

		int count = 0;
		String hql = "select count(*) from Teachresultbaseinfo as a where "
				+ "a.tresultBaseNo like :ci ";
		Map mapParam = new HashMap();
		// 获奖证书编号
		mapParam.put("ci", "%" + tresultBaseNo + "%");

		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		return count;
	}

	@SuppressWarnings("unchecked")
	// 导出
	public List<Teachresultbaseinfo> exportTeRebaseinfoList(
			TeachReBaseModel tmodel) {
		String hql = "from Teachresultbaseinfo as tr where "
				+ "tr.tresultName like :an and " + "tr.rewardDepart like :rd";
		Map mapParam = new HashMap();
		// 教学成果名称
		mapParam.put("an", "%" + tmodel.getTresultName() + "%");
		// 授予单位
		mapParam.put("rd", "%" + tmodel.getRewardDepart() + "%");
		// 编号
		if (tmodel.getTresultBaseNo() != null
				&& !"".equals(tmodel.getTresultBaseNo())) {
			hql += " and tr.tresultBaseNo= " + tmodel.getTresultBaseNo();
		}
		// 年份
		if (tmodel.getYear() != null && !"".equals(tmodel.getYear())) {
			hql += " and tr.year= " + tmodel.getYear();
		}
		// 获奖级别
		if (tmodel.getTresultJibie() != null
				&& !"".equals(tmodel.getTresultJibie())) {
			hql += " and tr.tresultJibie like :jibie ";
			mapParam.put("jibie", "%" + tmodel.getTresultJibie() + "%");
		}

		// 获奖等级
		if (tmodel.getTresultClass() != null
				&& !"".equals(tmodel.getTresultClass())) {
			hql += " and tr.tresultClass like :ticlass ";
			mapParam.put("ticlass", "%" + tmodel.getTresultClass() + "%");
		}
		// 学院
		if (tmodel.getDepartmentId() != null
				&& !"".equals(tmodel.getDepartmentId())) {
			hql += " and tr.tresultBaseNo in(select trb.teachresultbaseinfo.tresultBaseNo from Teachresult trb where trb.teacher.major.department.dno like :dn)";
			mapParam.put("dn", "%" + tmodel.getDepartmentId() + "%");
		}
		// 专业
		if (tmodel.getMajorId() != null && !"".equals(tmodel.getMajorId()) && !"%".equals(tmodel.getMajorId())) {
			hql += " and tr.tresultBaseNo in(select trb.teachresultbaseinfo.tresultBaseNo from Teachresult trb where trb.teacher.major.mno like :mn)";
			mapParam.put("mn", "%" + tmodel.getMajorId() + "%");
		}

		List<Teachresultbaseinfo> list = (List<Teachresultbaseinfo>) QueryUtilDaoImpl
				.executeQuery(hql, null, mapParam);
		System.out.println("list.size()=============" + list.size());

		return list;
	}

	// 根据学院Id查专业，用于下拉列表====待完善
	public JSONArray findMajorByDno(String dno) {

		JSONArray jsonArray = QueryUtilDaoImpl.findMajorByDno(dno);
		return jsonArray;
	}

	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findyearList() {
		String hql = "SELECT DISTINCT tr.year FROM Teachresultbaseinfo AS tr";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("年份=============" + list.size());
		return list;
	}

	// 返回获奖级别
	@SuppressWarnings("unchecked")
	public List<String> findtresultJibieList() {
		String hql = "SELECT DISTINCT tr.tresultJibie FROM Teachresultbaseinfo AS tr";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("级别=============" + list.size());
		return list;
	}

	// 返回获奖等级
	@SuppressWarnings("unchecked")
	public List<String> findtresultClassList() {
		String hql = "SELECT DISTINCT tr.tresultClass FROM Teachresultbaseinfo AS tr";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("等级=============" + list.size());
		return list;
	}
}
