package cn.edu.nwsuaf.Service.Impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.PublicshedaacademicpapersModel;
import cn.edu.nwsuaf.bean.Publicshedaacademicpapers;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class PublicshedaacademicpapersService extends
		BaseServiceImpl<Publicshedaacademicpapers> {
	@SuppressWarnings("unchecked")
	public List<String> findYearList() throws ServiceException {
		List list = null;
		try {
			String hql = "SELECT DISTINCT eqe.year FROM Publicshedaacademicpapers AS eqe";
			list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			Collections.sort(list);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询年份列表失败", e);

		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<String> findPeriodicalTypeList() throws ServiceException {
		List list = null;
		try {
			String hql = "SELECT DISTINCT eqe.periodicalType FROM Publicshedaacademicpapers AS eqe";
			list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询论文类型列表失败", e);

		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Publicshedaacademicpapers> findallPublicshedaacademicpapersList(
			int page, int rows, String mno, String dno) {

		String hql = "";
		List<Publicshedaacademicpapers> list = null;
		if (!mno.equals("000000")) {
			hql = "from Publicshedaacademicpapers t where t.teacher.major.mno=?";
			String param[] = { mno };
			list = (List<Publicshedaacademicpapers>) QueryUtilDaoImpl
					.executeQueryByPage(hql, param, page, rows);
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "from Publicshedaacademicpapers t where t.teacher.major.department.dno=?";
			String param[] = { dno };
			list = (List<Publicshedaacademicpapers>) QueryUtilDaoImpl
					.executeQueryByPage(hql, param, page, rows);
		} else {
			hql = "from Publicshedaacademicpapers";

			list = (List<Publicshedaacademicpapers>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii===" + list.size());

		}

		return list;

	}

	// 导出
	@SuppressWarnings("unchecked")
	public List<Publicshedaacademicpapers> exportallPapList(
			PublicshedaacademicpapersModel papmodel) throws ServiceException {

		List<Publicshedaacademicpapers> list = null;
		try {
			String hql = "from Publicshedaacademicpapers as pap where "
					+ "pap.paperName like :tpno and "
					+ "pap.periodicalType like :tpn";

			System.out.println("Service===Year=="
					+ papmodel.getPeriodicalType());
			Map<String, String> mapParam = new HashMap<String, String>();
			// 年份
			mapParam.put("tpno", "%" + papmodel.getPaperName() + "%");
			mapParam.put("tpn", "%" + papmodel.getPeriodicalType() + "%");

			if (papmodel.getYear() != null && !"".equals(papmodel.getYear())) {

				hql += " and pap.year= " + papmodel.getYear();
			}

			// 专业
			if (papmodel.getMajorId() != null
					&& !"".equals(papmodel.getMajorId())
					&& !"%".equals(papmodel.getMajorId())) {

				hql += " and pap.teacher.major.mno= '" + papmodel.getMajorId()
						+ "'";
			}
			// 学院
			if (papmodel.getDepartmentId() != null
					&& !"".endsWith(papmodel.getDepartmentId())) {

				hql += " and pap.teacher.major.department.dno='"
						+ papmodel.getDepartmentId() + "'";
			}
			// System.out.println("hql()===="+hql);
			list = (List<Publicshedaacademicpapers>) QueryUtilDaoImpl
					.executeQuery(hql, null, mapParam);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("多条件查询失败", e);
		}
		System.out.println("list.zize()====" + list.size());
		return list;

	}

	@SuppressWarnings("unchecked")
	// 多条件查询（专利号、专利名称、专业、学院）
	public List<Publicshedaacademicpapers> findPapList(
			PublicshedaacademicpapersModel papmodel, int page, int rows)
			throws ServiceException {

		List<Publicshedaacademicpapers> list = null;
		try {
			String hql = "from Publicshedaacademicpapers as pap where "
					+ "pap.paperName like :tpno and "
					+ "pap.periodicalType like :tpn";

			System.out.println("Service===Year==" + papmodel.getYear());
			Map mapParam = new HashMap();
			// 年份
			mapParam.put("tpno", "%" + papmodel.getPaperName() + "%");
			mapParam.put("tpn", "%" + papmodel.getPeriodicalType() + "%");

			if (papmodel.getYear() != null && !"".equals(papmodel.getYear())) {

				hql += " and pap.year= " + papmodel.getYear();
			}

			// 专业
			if (papmodel.getMajorId() != null
					&& !"".equals(papmodel.getMajorId())
					&& !"%".equals(papmodel.getMajorId())) {

				hql += " and pap.teacher.major.mno= '" + papmodel.getMajorId()
						+ "'";
			}
			// 学院
			if (papmodel.getDepartmentId() != null
					&& !"".endsWith(papmodel.getDepartmentId())) {

				hql += " and pap.teacher.major.department.dno='"
						+ papmodel.getDepartmentId() + "'";
			}
			list = (List<Publicshedaacademicpapers>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, mapParam, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("多条件查询失败", e);
		}

		return list;

	}

	// 多条件清空（专利号、专利名称、专业、学院）
	@SuppressWarnings("unchecked")
	public List<Publicshedaacademicpapers> clearPapList(
			PublicshedaacademicpapersModel papmodel) throws ServiceException {

		List<Publicshedaacademicpapers> list = null;
		try {
			String hql = "from Publicshedaacademicpapers as pap where "
					+ "pap.paperName like :tpno and "
					+ "pap.periodicalType like :tpn";

			System.out.println("Service===Year==" + papmodel.getYear());
			Map mapParam = new HashMap();
			// 年份
			mapParam.put("tpno", "%" + papmodel.getPaperName() + "%");
			mapParam.put("tpn", "%" + papmodel.getPeriodicalType() + "%");

			if (papmodel.getYear() != null && !"".equals(papmodel.getYear())) {

				hql += " and pap.year= " + papmodel.getYear();
			}

			// 专业
			if (papmodel.getMajorId() != null
					&& !"".equals(papmodel.getMajorId())
					&& !"%".equals(papmodel.getMajorId())) {

				hql += " and pap.teacher.major.mno= '" + papmodel.getMajorId()
						+ "'";
			}
			// 学院
			if (papmodel.getDepartmentId() != null
					&& !"".endsWith(papmodel.getDepartmentId())) {

				hql += " and pap.teacher.major.department.dno='"
						+ papmodel.getDepartmentId() + "'";
			}
			list = (List<Publicshedaacademicpapers>) QueryUtilDaoImpl
					.executeQuery(hql, null, mapParam);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("多条件删除失败！", e);
		}

		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindPap(PublicshedaacademicpapersModel papmodel)
			throws ServiceException {

		int count = 0;
		String hql = "select count(*) from Publicshedaacademicpapers as pap where "
				+ "pap.paperName like :tpno and "
				+ "pap.periodicalType like :tpn";
		try {
			Map mapParam = new HashMap();
			// 年份
			mapParam.put("tpno", "%" + papmodel.getPaperName() + "%");
			mapParam.put("tpn", "%" + papmodel.getPeriodicalType() + "%");

			if (papmodel.getYear() != null && !"".equals(papmodel.getYear())) {

				hql += " and pap.year= " + papmodel.getYear();
			}

			// 专业
			if (papmodel.getMajorId() != null
					&& !"".equals(papmodel.getMajorId())
					&& !"%".equals(papmodel.getMajorId())) {

				hql += " and pap.teacher.major.mno= '" + papmodel.getMajorId()
						+ "'";
			}
			// 学院
			if (papmodel.getDepartmentId() != null
					&& !"".endsWith(papmodel.getDepartmentId())) {

				hql += " and pap.teacher.major.department.dno= '"
						+ papmodel.getDepartmentId() + "'";
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

		int count = 0;
		String hql = "select count(*) from Publicshedaacademicpapers as stup where "
				+ "stup.year like :tpno";
		Map mapParam = new HashMap();
		// 专利号
		mapParam.put("tpno", "%" + tpno + "%");
		// 专利名称

		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		return count;
	}

	public int count(String mno, String dno) throws ServiceException {
		int count = 0;
		String hql = "";
		if (!mno.equals("000000")) {
			hql = "select count(*) from  Publicshedaacademicpapers t where t.teacher.major.mno=?";
			String param[] = { mno };
			count = QueryUtilDaoImpl.getResultCountForHql(hql, param);
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "select count(*) from Publicshedaacademicpapers t where t.teacher.major.department.dno=?";
			String param[] = { dno };
			count = QueryUtilDaoImpl.getResultCountForHql(hql, param);

		} else {
			hql = "select count(*) from Publicshedaacademicpapers";

			count = QueryUtilDaoImpl.getResultCountForHql(hql, null);

		}
		return count;

	}

}
