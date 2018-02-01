package cn.edu.nwsuaf.Service.Impl;

import java.util.Collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.PreRevolutModel;
import cn.edu.nwsuaf.Service.Interface.IPresidedRevolutionService;
import cn.edu.nwsuaf.bean.Presidedoverrevolutionresearchproject;
import cn.edu.nwsuaf.bean.Presidedoverscientificresearchproject;
import cn.edu.nwsuaf.bean.Teacher;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class PresidedRevolutionService extends
		BaseServiceImpl<Presidedoverrevolutionresearchproject> implements
		IPresidedRevolutionService {
	// 分页获取全部主持教改项目信息(添加新功能，区别专业负责人权限)
	@SuppressWarnings("unchecked")
	public List<Presidedoverrevolutionresearchproject> getAllPreRevolutListByPage(
			int page, int rows, String mno, String dno) throws ServiceException {

		String hql = "";

		List<Presidedoverrevolutionresearchproject> list = null;

		// 专业负责人
		if (!mno.equals("000000")) {
			hql = "from Presidedoverrevolutionresearchproject p where p.teacher.major.mno="
					+ "'" + mno + "'";
			hql += " order by p.rprojectNo";
			list = (List<Presidedoverrevolutionresearchproject>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, page, rows);
			// 学院负责人
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "from Presidedoverrevolutionresearchproject p where p.teacher.major.department.dno="
				+ "'"+dno+"'";
			hql += " order by p.rprojectNo";
			list = (List<Presidedoverrevolutionresearchproject>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, page, rows);
			// 系统管理员
		} else {
			hql = "from Presidedoverrevolutionresearchproject p";
			hql += " order by p.rprojectNo";
			list = (List<Presidedoverrevolutionresearchproject>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii===" + list.size());
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Teacher> findAllInSort() {
		String hql = "select distinct teacher from Presidedoverrevolutionresearchproject ";// order
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

	// 获取全部主持教改项目信息
	@SuppressWarnings("unchecked")
	public List<Presidedoverrevolutionresearchproject> getAllPreRevolut(String mno,String dno)
			throws ServiceException {
		String hql = "";
		
		List<Presidedoverrevolutionresearchproject> list = null;
		
		// 专业负责人
		if (!mno.equals("000000")) {
			hql = "from Presidedoverrevolutionresearchproject p where p.teacher.major.mno="
					+ "'" + mno + "'";
			hql += " order by p.rprojectNo";
			// 学院负责人
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "from Presidedoverrevolutionresearchproject p where p.teacher.major.department.dno="
					+ "'"+dno+"'";
			hql += " order by p.rprojectNo";
			// 系统管理员
		} else {
			hql = "from Presidedoverrevolutionresearchproject p";
			hql += " order by p.rprojectNo";
		}

		try {
			list = (List<Presidedoverrevolutionresearchproject>) QueryUtilDaoImpl
					.executeQuery(hql, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 获取立项年份信息
	@SuppressWarnings("unchecked")
	public List<String> findYear() throws ServiceException {
		String hql = "select distinct p.year from Presidedoverrevolutionresearchproject as p";
		List list = null;
		try {
			list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			// Collections.sort(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"Presidedoverrevolutionresearchproject层获取立项年份信息失败", e);
		}
		return list;
	}

	// 获取项目类型信息
	@SuppressWarnings("unchecked")
	public List<String> findRProType() throws ServiceException {
		String hql = "SELECT DISTINCT p.rprojecType FROM Presidedoverrevolutionresearchproject AS p";
		List list = null;
		try {
			list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			Collections.sort(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"Presidedoverrevolutionresearchproject层获取项目类型信息失败", e);
		}
		System.out.println("项目类型=============" + list.size());
		return list;
	}

	// 获取项目级别信息
	@SuppressWarnings("unchecked")
	public List<String> findRProjecJibie() throws ServiceException {
		String hql = "select distinct p.rprojecJibie from Presidedoverrevolutionresearchproject as p";
		List list = null;
		try {
			list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			Collections.sort(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"Presidedoverrevolutionresearchproject层获取项目级别信息失败", e);
		}
		System.out.println("项目级别============" + list.size());
		return list;
	}

	// 依据主键获取主持教改项目信息
	public Presidedoverrevolutionresearchproject findPreRevolutById(
			String rprojectNo) throws ServiceException {
		try {
			return this.findById(Presidedoverrevolutionresearchproject.class,
					rprojectNo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"Presidedoverrevolutionresearchproject层依据主键获取主持教改项目信息失败", e);
		}
	}

	// 更新主持教改项目信息
	public void updatePreRevolut(Presidedoverrevolutionresearchproject prer)
			throws ServiceException {
		try {
			this.update(prer);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(
					"Presidedoverrevolutionresearchproject层更新主持教改项目信息失败", e);
		}
	}

	// 保存主持教改项目信息
	public void savePreRevolut(Presidedoverrevolutionresearchproject prer)
			throws ServiceException {
		try {
			this.save(prer);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(
					"Presidedoverrevolutionresearchproject层保存主持教改项目信息失败", e);
		}
	}

	// 删除主持教改项目信息
	public void deletePreRevolut(String rprojectNo) throws ServiceException {
		Presidedoverrevolutionresearchproject prer;
		try {
			prer = this.findById(Presidedoverrevolutionresearchproject.class,
					rprojectNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(
					"Presidedoverrevolutionresearchproject层删除主持教改项目信息失败", e);
		}
		this.delete(prer);
	}

	// 根据主持教改项目属性分页查询获取主持教改项目信息
	@SuppressWarnings("unchecked")
	public List<Presidedoverrevolutionresearchproject> findByType(String type,
			String value, int page, int rows) throws ServiceException {
		List<Presidedoverrevolutionresearchproject> prerList;
		try {
			prerList = (List<Presidedoverrevolutionresearchproject>) QueryUtilDaoImpl
					.findByType("Presidedoverrevolutionresearchproject", type,
							value, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"Presidedoverrevolutionresearchproject层根据项目属性分页查询获取主持教改项目信息失败",
					e);

		}
		return prerList;
	}

	// 导出
	@SuppressWarnings("unchecked")
	public List<Presidedoverrevolutionresearchproject> exportallPrerList(
			PreRevolutModel pmodel) {

		String hql = "from Presidedoverrevolutionresearchproject as p where "
				+ "p.rprojectNo like :pno and " + "p.rprojectName like :pi";

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

			hql += " and p.rprojecType='" + pmodel.getProjecType() + "'";
		}
		// 项目级别
		if (pmodel.getProjecJibie() != null
				&& !"".equals(pmodel.getProjecJibie())) {

			hql += " and p.rprojecJibie='" + pmodel.getProjecJibie() + "'";
		}
		List<Presidedoverrevolutionresearchproject> list = (List<Presidedoverrevolutionresearchproject>) QueryUtilDaoImpl
				.executeQuery(hql, null, mapParam);
		return list;
	}

	@SuppressWarnings("unchecked")
	// 多条件查询（项目编号、项目名称、教师编号、教师姓名、立项年份、学院、专业、项目类型、项目级别）
	public List<Presidedoverrevolutionresearchproject> findPreRevolutList(
			PreRevolutModel pmodel, int page, int rows,String mno , String dno) throws ServiceException {
		List<Presidedoverrevolutionresearchproject> list;
		try {
			String hql = "from Presidedoverrevolutionresearchproject as p where "
					+ "p.rprojectNo like :pno and " + "p.rprojectName like :pi";

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

				hql += " and p.rprojecType='" + pmodel.getProjecType() + "'";
			}
			// 项目级别
			if (pmodel.getProjecJibie() != null
					&& !"".equals(pmodel.getProjecJibie())) {

				hql += " and p.rprojecJibie='" + pmodel.getProjecJibie() + "'";
			}
			

			// 专业负责人
			if (!mno.equals("000000")) {
				hql += " and p.teacher.major.mno="
						+ "'" + mno + "'";
				hql += " order by p.rprojectNo";
				// 学院负责人
			} else if (!dno.equals("00000") && mno.equals("000000")) {
				hql += " and p.teacher.major.department.dno="
					+ "'"+dno+"'";
				hql += " order by p.rprojectNo";
				// 系统管理员
			} else {
				hql += " order by p.rprojectNo";
			}

			
			System.out.println(hql);

			list = (List<Presidedoverrevolutionresearchproject>) QueryUtilDaoImpl
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
	public int countFindPrer(PreRevolutModel pmodel ,String mno, String dno) throws ServiceException {

		int count;
		try {
			String hql = "select count(*) from Presidedoverrevolutionresearchproject as p where "
					+ "p.rprojectNo like :pno and " + "p.rprojectName like :pi";

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

				hql += " and p.rprojecType='" + pmodel.getProjecType() + "'";
			}

			// 项目级别
			if (pmodel.getProjecJibie() != null
					&& !"".equals(pmodel.getProjecJibie())) {

				hql += " and p.rprojecJibie='" + pmodel.getProjecJibie() + "'";
			}
			
			// 专业负责人
			if (!mno.equals("000000")) {
				hql += " and p.teacher.major.mno="
						+ "'" + mno + "'";
				hql += " order by p.rprojectNo";
				// 学院负责人
			} else if (!dno.equals("00000") && mno.equals("000000")) {
				hql += " and p.teacher.major.department.dno="
					+ "'"+dno+"'";
				hql += " order by p.rprojectNo";
				// 系统管理员
			} else {
				hql += " order by p.rprojectNo";
			}

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
		String hql = "select count(*) from Presidedoverrevolutionresearchproject as p where "
				+ "p.rprojectNo = '" + pno + "'";

		count = QueryUtilDaoImpl.getResultCountForHql(hql, null);
		return count;
	}
}
