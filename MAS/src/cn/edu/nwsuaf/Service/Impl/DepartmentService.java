package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class DepartmentService extends BaseServiceImpl<Department> {

	// 分页获取全部学院信息
	@SuppressWarnings("unchecked")
	public List<Department> getAllDepartmentListByPage(int page, int rows,
			String mno, String dno) {

		String hql = "";
		List<Department> list = null;
		if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "from Department d where d.dno=? ";
			String param[] = { dno };
			list = (List<Department>) QueryUtilDaoImpl.executeQueryByPage(hql,
					param, page, rows);
		} else {
			hql = "from Department ";

			list = (List<Department>) QueryUtilDaoImpl.executeQueryByPage(hql,
					null, page, rows);
			System.out.println("list.size()iii===" + list.size());

		}
		return list;

	}

	// 导出
	@SuppressWarnings("unchecked")
	public List<Department> exportallDepartmentList(BaseModel departmentmodel)
			throws ServiceException {

		List<Department> list = null;
		try {
			String hql = "from Department as d where d.dno like :tno"
					+ " and d.dname like :tname";
			Map mapParam = new HashMap();
			System.out.println(departmentmodel.getDepartmentId()+"   "+departmentmodel.getName());
			// 学院代码
			mapParam.put("tno", "%" + departmentmodel.getDepartmentId() + "%");
			// 学院名称
			mapParam.put("tname", "%" + departmentmodel.getName() + "%");
			System.out.println(hql);
			list = (List<Department>) QueryUtilDaoImpl.executeQuery(hql, null,
					mapParam);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("导出失败", e);
		}

		return list;

	}

	@SuppressWarnings("unchecked")
	// 多条件查询（专利号、专利名称、专业、学院）
	public List<Department> findDepartmentList(BaseModel departmentmodel,
			int page, int rows) throws ServiceException {

		List<Department> list = null;
		try {
			String hql = "from Department as d where d.dno like :tno"
					+ " and d.dname like :tname";
			Map mapParam = new HashMap();
			// 学院代码
			mapParam.put("tno", "%" + departmentmodel.getDepartmentId() + "%");
			// 学院名称
			mapParam.put("tname", "%" + departmentmodel.getName() + "%");
			System.out.println(hql);
			list = (List<Department>) QueryUtilDaoImpl.executeQueryByPage(hql,
					null, mapParam, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("多条件查询失败", e);
		}

		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindDepartment(BaseModel departmentmodel)
			throws ServiceException {

		int count = 0;
		String hql = "select count(*) from Department as d where d.dno like :tno"
				+ " and d.dname like :tname";
		try {
			Map mapParam = new HashMap();
			// 学院代码
			mapParam.put("tno", "%" + departmentmodel.getDepartmentId() + "%");
			// 学院名称
			mapParam.put("tname", "%" + departmentmodel.getName() + "%");
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询结果条数失败", e);
		}
		System.out.println("count=========" + count);
		return count;

	}

	public int count(String mno, String dno) throws ServiceException {
		int count = 0;
		String hql = "";
		if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "select count(*) from Department t where t.department.dno=?";
			String param[] = { dno };
			count = QueryUtilDaoImpl.getResultCountForHql(hql, param);

		} else {
			hql = "select count(*) from Department";
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null);
		}
		return count;

	}

	public int isExist(String dno) {

		int count = 0;
		String hql = "select count(*) from Department as d where "
				+ "d.dno = '" + dno + "'";

		count = QueryUtilDaoImpl.getResultCountForHql(hql, null);
		return count;
	}
}
