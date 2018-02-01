package cn.edu.nwsuaf.Service.Impl;

import java.util.Collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.PreScientModel;
import cn.edu.nwsuaf.Service.Interface.IPresidedScientificService;
import cn.edu.nwsuaf.bean.Presidedoverscientificresearchproject;
import cn.edu.nwsuaf.bean.Teacher;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class PresidedScientificService extends
		BaseServiceImpl<Presidedoverscientificresearchproject> implements
		IPresidedScientificService {
	// 分页获取全部主持科研项目信息
	@SuppressWarnings("unchecked")
	public List<Presidedoverscientificresearchproject> getAllPreScientListByPage(
			int page, int rows) throws ServiceException {
		String hql = "from Presidedoverscientificresearchproject";
		List list = null;
		try {
			list = (List<Presidedoverscientificresearchproject>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"Presidedoverscientificresearchproject层分页获取全部主持科研项目信息失败", e);
		}
		return list;
	}

	// 获取全部主持科研项目信息，分页，区别专家(新添加方法)
	@SuppressWarnings("unchecked")
	public List<Presidedoverscientificresearchproject> getAllPreScient(
			int page, int rows, String mno, String dno) {
		String hql = "";
		List<Presidedoverscientificresearchproject> list = null;
		// 专业负责人
		if (!mno.equals("000000")) {
			hql = "from Presidedoverscientificresearchproject p where p.teacher.major.mno="
					+ "'" + mno + "'";
			hql += " order by p.projectNo";
			list = (List<Presidedoverscientificresearchproject>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, page, rows);
			// 学院负责人
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "from Presidedoverscientificresearchproject p where p.teacher.major.department.dno="
					+ "'"+dno+"'";
			hql += " order by p.projectNo";
			list = (List<Presidedoverscientificresearchproject>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, page, rows);
			// 系统管理员
		} else {
			hql = "from Presidedoverscientificresearchproject p";
			hql += " order by p.projectNo";
			list = (List<Presidedoverscientificresearchproject>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii===" + list.size());
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Teacher> findAllInSort() {
		String hql = "select distinct teacher from Presidedoverscientificresearchproject ";// order
																							// by
																							// teacher.tname
																							// asc
		List list = null;
		try {
			list = (List<Teacher>) QueryUtilDaoImpl.executeQuery(hql, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 获取全部主持科研项目信息
	@SuppressWarnings("unchecked")
	public List<Presidedoverscientificresearchproject> getAllPreScient()
			throws ServiceException {
		String hql = "from Presidedoverscientificresearchproject";
		List list = null;
		try {
			list = (List<Presidedoverscientificresearchproject>) QueryUtilDaoImpl
					.executeQuery(hql, null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"Presidedoverscientificresearchproject层获取全部主持科研项目信息失败", e);
		}
		return list;
	}

	// 获取立项年份信息
	@SuppressWarnings("unchecked")
	public List<String> findYear() throws ServiceException {
		String hql = "select distinct p.year from Presidedoverscientificresearchproject as p";
		List list = null;
		try {
			list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			Collections.sort(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"Presidedoverscientificresearchproject层获取立项年份信息失败", e);
		}
		return list;
	}

	// 获取项目类型信息
	@SuppressWarnings("unchecked")
	public List<String> findProType() throws ServiceException {
		String hql = "SELECT DISTINCT p.projecType FROM Presidedoverscientificresearchproject AS p";
		List list = null;
		try {
			list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			Collections.sort(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"PresidedoverscientificresearchprojectService层获取项目类型信息失败",
					e);
		}
		return list;
	}

	// 获取项目级别信息
	@SuppressWarnings("unchecked")
	public List<String> findProjecJibie() throws ServiceException {
		String hql = "select distinct p.projecJibie from Presidedoverscientificresearchproject as p";
		List list = null;
		try {
			list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			Collections.sort(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"PresidedoverscientificresearchprojectService层获取项目级别信息失败",
					e);
		}
		return list;
	}

	// 依据主键获取主持科研项目信息
	public Presidedoverscientificresearchproject findPreScientById(
			String projectNo) throws ServiceException {
		try {
			return this.findById(Presidedoverscientificresearchproject.class,
					projectNo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"Presidedoverscientificresearchproject层依据主键获取主持科研项目信息失败", e);
		}
	}

	// 更新主持科研项目信息
	public void updatePreScient(Presidedoverscientificresearchproject pres)
			throws ServiceException {
		try {
			this.update(pres);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(
					"PresidedoverscientificresearchprojectService层更新主持科研项目信息失败",
					e);
		}
	}

	// 保存主持科研项目信息
	public void savePreScient(Presidedoverscientificresearchproject pres)
			throws ServiceException {
		try {
			this.save(pres);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(
					"PresidedoverscientificresearchprojectService层保存主持科研项目信息失败",
					e);
		}
	}

	// 删除主持科研项目信息
	public void deletePreScient(String projectNo) throws ServiceException {
		Presidedoverscientificresearchproject pres;
		try {
			pres = this.findById(Presidedoverscientificresearchproject.class,
					projectNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(
					"PresidedoverscientificresearchprojectService层删除主持科研项目信息失败",
					e);
		}
		this.delete(pres);
	}

	// 根据主持科研项目属性分页查询获取主持科研项目信息
	@SuppressWarnings("unchecked")
	public List<Presidedoverscientificresearchproject> findByType(String type,
			String value, int page, int rows) throws ServiceException {
		List<Presidedoverscientificresearchproject> presList;
		try {
			presList = (List<Presidedoverscientificresearchproject>) QueryUtilDaoImpl
					.findByType("Presidedoverscientificresearchproject", type,
							value, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"PresidedoverscientificresearchprojectService层根据项目属性分页查询获取主持科研项目信息失败",
					e);

		}
		return presList;
	}

	// 导出
	@SuppressWarnings("unchecked")
	public List<Presidedoverscientificresearchproject> exportallPresList(
			PreScientModel pmodel) {

		String hql = "from Presidedoverscientificresearchproject as p where "
				+ "p.projectNo like :pno and " + "p.projectName like :pi";

		Map mapParam = new HashMap();
		// 项目编号
		mapParam.put("pno", "%" + pmodel.getId() + "%");
		// 项目名称
		mapParam.put("pi", "%" + pmodel.getName() + "%");
		// 教师编号
		if (pmodel.getTno() != null && !"".equals(pmodel.getTno())) {

			hql += " and p.teacher.tno='" + pmodel.getTno() + "'";
		}
		// 教师姓名
		if (pmodel.getTname() != null && !"".equals(pmodel.getTname())) {

			hql += " and p.teacher.tname='" + pmodel.getTname() + "'";
		}
		// 立项年份
		if (pmodel.getYear() != null && !"".equals(pmodel.getYear())) {

			hql += " and p.year='" + pmodel.getYear() + "'";
		}
		// 学院
		if (pmodel.getDepartmentId() != null
				&& !"".endsWith(pmodel.getDepartmentId())) {

			hql += " and p.teacher.major.department.dno='"
					+ pmodel.getDepartmentId() + "'";
		}
		// 专业
		if (pmodel.getMajorId() != null && !"".equals(pmodel.getMajorId())
				&& !"%".equals(pmodel.getMajorId())) {

			hql += " and p.teacher.major.mno='" + pmodel.getMajorId() + "'";
		}
		// 项目类型
		if (pmodel.getProjecType() != null
				&& !"".equals(pmodel.getProjecType())) {

			hql += " and p.projecType='" + pmodel.getProjecType() + "'";
		}
		// 项目级别
		if (pmodel.getProjecJibie() != null
				&& !"".equals(pmodel.getProjecJibie())) {

			hql += " and p.projecJibie='" + pmodel.getProjecJibie() + "'";
		}
		List<Presidedoverscientificresearchproject> list = (List<Presidedoverscientificresearchproject>) QueryUtilDaoImpl
				.executeQuery(hql, null, mapParam);
		return list;
	}

	@SuppressWarnings("unchecked")
	// 多条件查询（项目编号、项目名称、教师编号、教师姓名、立项年份、学院、专业、项目类型、项目级别） 此处添加了专业负责人权限
	public List<Presidedoverscientificresearchproject> findPreScientList(
			PreScientModel pmodel, int page, int rows, String mno, String dno)
			throws ServiceException {
		List<Presidedoverscientificresearchproject> list;

		try {
			String hql = "from Presidedoverscientificresearchproject as p where "
					+ "p.projectNo like :pno and " + "p.projectName like :pi ";

			Map mapParam = new HashMap();
			// 项目编号
			mapParam.put("pno", "%" + pmodel.getId() + "%");
			// 项目名称
			mapParam.put("pi", "%" + pmodel.getName() + "%");
			// 教师编号
			if (pmodel.getTno() != null && !"".equals(pmodel.getTno())) {

				hql += " and p.teacher.tno='" + pmodel.getTno() + "'";
			}
			// 教师姓名
			if (pmodel.getTname() != null && !"".equals(pmodel.getTname())) {

				hql += " and p.teacher.tname='" + pmodel.getTname() + "'";
			}
			// 立项年份
			if (pmodel.getYear() != null && !"".equals(pmodel.getYear())) {

				hql += " and p.year='" + pmodel.getYear() + "'";
			}
			// 学院
			if (pmodel.getDepartmentId() != null
					&& !"".endsWith(pmodel.getDepartmentId())) {

				hql += " and p.teacher.major.department.dno='"
						+ pmodel.getDepartmentId() + "'";
			}
			// 专业
			if (pmodel.getMajorId() != null && !"".equals(pmodel.getMajorId())
					&& !"%".equals(pmodel.getMajorId())) {

				hql += " and p.teacher.major.mno='" + pmodel.getMajorId() + "'";
			}
			// 项目类型
			if (pmodel.getProjecType() != null
					&& !"".equals(pmodel.getProjecType())) {

				hql += " and p.projecType='" + pmodel.getProjecType() + "'";
			}
			// 项目级别
			if (pmodel.getProjecJibie() != null
					&& !"".equals(pmodel.getProjecJibie())) {

				hql += " and p.projecJibie='" + pmodel.getProjecJibie() + "'";
			}

			// 专业负责人
			if (!mno.equals("000000")) {
				hql += " and p.teacher.major.mno=" + "'" + mno + "'";
				hql += " order by p.projectNo";
				// String param[]={mno};
				// 学院负责人
			} else if (!dno.equals("00000") && mno.equals("000000")) {
				hql += " and p.teacher.major.department.dno=" + "'"+dno+"'";
				hql += " order by p.projectNo";
				// 系统管理员
			} else {
				hql += " order by p.projectNo";
			}

			list = (List<Presidedoverscientificresearchproject>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, mapParam, page, rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException("多条件查询失败", e);
		}
		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindPres(PreScientModel pmodel ,String mno ,String dno) throws ServiceException {

		int count;
		try {
			String hql = "select count(*) from Presidedoverscientificresearchproject as p where "
					+ "p.projectNo like :pno and " + "p.projectName like :pi ";

			Map mapParam = new HashMap();
			// 项目编号
			mapParam.put("pno", "%" + pmodel.getId() + "%");
			// 项目名称
			mapParam.put("pi", "%" + pmodel.getName() + "%");
			// 教师编号
			if (pmodel.getTno() != null && !"".equals(pmodel.getTno())) {

				hql += " and p.teacher.tno='" + pmodel.getTno() + "'";
			}
			// 教师姓名
			if (pmodel.getTname() != null && !"".equals(pmodel.getTname())) {

				hql += " and p.teacher.tname='" + pmodel.getTname() + "'";
			}
			// 立项年份
			if (pmodel.getYear() != null && !"".equals(pmodel.getYear())) {

				hql += " and p.year='" + pmodel.getYear() + "'";
			}
			// 学院
			if (pmodel.getDepartmentId() != null
					&& !"".endsWith(pmodel.getDepartmentId())) {

				hql += " and p.teacher.major.department.dno='"
						+ pmodel.getDepartmentId() + "'";
			}
			// 专业
			if (pmodel.getMajorId() != null && !"".equals(pmodel.getMajorId())
					&& !"%".equals(pmodel.getMajorId())) {

				hql += " and p.teacher.major.mno='" + pmodel.getMajorId() + "'";
			}
			// 项目类型
			if (pmodel.getProjecType() != null
					&& !"".equals(pmodel.getProjecType())) {

				hql += " and p.projecType='" + pmodel.getProjecType() + "'";
			}

			// 项目级别
			if (pmodel.getProjecJibie() != null
					&& !"".equals(pmodel.getProjecJibie())) {

				hql += " and p.projecJibie='" + pmodel.getProjecJibie() + "'";
			}

			// 专业负责人
			if (!mno.equals("000000")) {
				hql += " and p.teacher.major.mno=" + "'" + mno + "'";
				hql += " order by p.projectNo";
				// String param[]={mno};
				// 学院负责人
			} else if (!dno.equals("00000") && mno.equals("000000")) {
				hql += " and p.teacher.major.department.dno=" + " '"+dno+"' ";
				hql += " order by p.projectNo";
				// 系统管理员
			} else {
				hql += " order by p.projectNo";
			}
			System.out.println("test!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!test");
			System.out.println(hql);
			
			
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException("查询结果条数失败", e);
		}
		return count;
	}

	public int isExist(String pno) {

		int count = 0;
		String hql = "select count(*) from Presidedoverscientificresearchproject as p where "
				+ "p.projectNo = '" + pno + "'";
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null);
		return count;
	}
}
