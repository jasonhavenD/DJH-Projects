package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.CourseModel;
import cn.edu.nwsuaf.Service.Interface.ICourseService;
import cn.edu.nwsuaf.bean.Course;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class CourseService extends BaseServiceImpl<Course> implements
		ICourseService {

	// 分页获取全部课程基本信息
	@SuppressWarnings("unchecked")
	public List<Course> getAllCourseListByPage(int page, int rows)
			throws ServiceException {
		String hql = "from Course";
		List list = null;
		try {
			list = (List<Course>) QueryUtilDaoImpl.executeQueryByPage(hql,
					null, page, rows);
		} catch (Exception e) {
			
			throw new ServiceException("CourseService层分页获取全部课程基本信息失败", e);
		}
		
		return list;
	}

	// 导出
	@SuppressWarnings("unchecked")
	public List<Course> exportallCourseList(CourseModel cmodel) {

		String hql = "from Course as c where " + "c.cno like :ci and "
				+ "c.cname like :cn";

		Map mapParam = new HashMap();
		// 课程编号
		mapParam.put("ci", "%" + cmodel.getId() + "%");
		// 课程名称
		mapParam.put("cn", "%" + cmodel.getName() + "%");
		// 学院
		if (cmodel.getDepartmentId() != null
				&& !"".endsWith(cmodel.getDepartmentId())) {

			hql += " and c.department.dno= '" + cmodel.getDepartmentId() + "'";

		}
		// 课程类别
		if (cmodel.getCtype() != null && !"".equals(cmodel.getCtype())) {
			hql += " and c.ctype='" + cmodel.getCtype() + "'";
		}

		// 是否双语授课
		if (cmodel.getIsDoubleLanguageTeach() != null
				&& !"".equals(cmodel.getIsDoubleLanguageTeach

				())) {
			hql += " and c.isDoubleLanguageTeach='"
					+ cmodel.getIsDoubleLanguageTeach() + "'";
		}

		// 考核方式
		if (cmodel.getTestMode() != null && !"".equals(cmodel.getTestMode())) {
			hql += " and c.testMode='" + cmodel.getTestMode() + "'";
		}
		List<Course> list = (List<Course>) QueryUtilDaoImpl
				.executeQuery(hql, null, mapParam);
		return list;
	}

	// 获取全部课程基本信息
	@SuppressWarnings("unchecked")
	public List<Course> getAllCourse() throws ServiceException {
		String hql = "from Course";
		List list = null;
		try {
			list = (List<Course>) QueryUtilDaoImpl.executeQuery(hql, null);
		} catch (Exception e) {
			
			throw new ServiceException("CourseService层获取全部课程基本信息失败", e);
		}
		return list;
	}

	// 获取课程类别信息
	@SuppressWarnings("unchecked")
	public List<String> findCtype() throws ServiceException {
		String hql = "SELECT DISTINCT c.ctype FROM Course AS c";
		List list = null;
		try {
			list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		} catch (Exception e) {
			
			throw new ServiceException("CourseService层获取课程类别信息失败", e);
		}
		return list;
	}

	// 获取是否双语授课信息
	@SuppressWarnings("unchecked")
	public List<String> findIsDouble() throws ServiceException {
		String hql = "select distinct c.isDoubleLanguageTeach from Course as c";
		List list = null;
		try {
			list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		} catch (Exception e) {
		
			throw new ServiceException("CourseService层获取是否双语授课信息失败", e);
		}
		return list;
	}

	// 获取考核方式信息
	@SuppressWarnings("unchecked")
	public List<String> findTestMode() throws ServiceException {
		String hql = "select distinct c.testMode from Course as c";
		List list = null;
		try {
			list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		} catch (Exception e) {
			
			throw new ServiceException("CourseService层获取考核方式信息失败", e);
		}
		return list;
	}

	// 更新课程信息
	public void updateCourse(Course course) throws ServiceException {
		try {
			this.update(course);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			
			throw new ServiceException("CourseService层更新课程信息失败", e);
		}
	}

	// 保存课程信息
	public void saveCourse(Course course) throws ServiceException {
		try {
			this.save(course);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			
			throw new ServiceException("CourseService层保存课程信息失败", e);
		}
	}

	// 删除课程信息
	public void deleteCourse(Course course) throws ServiceException {
		try {
			this.delete(course);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			
			throw new ServiceException("CourseService层删除课程信息失败", e);
		}
		
	}

	@SuppressWarnings("unchecked")
	// 多条件查询（课程编号、课程名称、学院）
	public List<Course> findCourseList(CourseModel cmodel, int page, int rows)
			throws ServiceException {
		List<Course> list;
		try {
			String hql = "from Course as c where " + "c.cno like :ci and "
					+ "c.cname like :cn";

			Map mapParam = new HashMap();
			// 课程编号
			mapParam.put("ci", "%" + cmodel.getId() + "%");
			// 课程名称
			mapParam.put("cn", "%" + cmodel.getName() + "%");
			// 学院
			if (cmodel.getDepartmentId() != null
					&& !"".endsWith(cmodel.getDepartmentId())) {

				hql += " and c.department.dno= '" + cmodel.getDepartmentId()
						+ "'";

			}
			// 课程类别
			if (cmodel.getCtype() != null && !"".equals(cmodel.getCtype())) {
				hql += " and c.ctype='" + cmodel.getCtype() + "'";

			}

			// 是否双语授课
			if (cmodel.getIsDoubleLanguageTeach() != null
					&& !"".equals(cmodel.getIsDoubleLanguageTeach())) {
				hql += " and c.isDoubleLanguageTeach='"
						+ cmodel.getIsDoubleLanguageTeach() + "'";
			}

			// 考核方式
			if (cmodel.getTestMode() != null
					&& !"".equals(cmodel.getTestMode())) {
				hql += " and c.testMode='" + cmodel.getTestMode() + "'";
			}
			list = (List<Course>) QueryUtilDaoImpl.executeQueryByPage(hql,
					null, mapParam, page, rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		
			throw new ServiceException("多条件查询失败", e);
		}
		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindCourse(CourseModel cmodel) throws ServiceException {

		int count;
		try {
			String hql = "select count(*) from Course as c where "
					+ "c.cno like :ci and " + "c.cname like :cn";
			Map mapParam = new HashMap();
			// 课程编号
			mapParam.put("ci", "%" + cmodel.getId() + "%");
			// 课程名称
			mapParam.put("cn", "%" + cmodel.getName() + "%");
			// 学院
			if (cmodel.getDepartmentId() != null
					&& !"".equals(cmodel.getDepartmentId())) {

				hql += " and c.department.dno= '" + cmodel.getDepartmentId()
						+ "'";
			}
			// 课程类别
			if (cmodel.getCtype() != null && !"".equals(cmodel.getCtype())) {
				hql += " and c.ctype='" + cmodel.getCtype() + "'";
			}
			// 是否双语授课
			if (cmodel.getIsDoubleLanguageTeach() != null
					&& !"".equals(cmodel.getIsDoubleLanguageTeach())) {
				hql += " and c.isDoubleLanguageTeach='"
						+ cmodel.getIsDoubleLanguageTeach() + "'";
			}

			// 考核方式
			if (cmodel.getTestMode() != null
					&& !"".equals(cmodel.getTestMode())) {
				hql += " and c.testMode='" + cmodel.getTestMode() + "'";
			}

			count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException("查询结果条数失败", e);
		}
		return count;

	}

	public int isExist(String cno) {

		int count = 0;
		String hql = "select count(*) from Course as c where " + "c.cno = '"
				+ cno + "'";

		count = QueryUtilDaoImpl.getResultCountForHql(hql, null);
		return count;
	}
}
