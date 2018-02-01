package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.TeacherModel;
import cn.edu.nwsuaf.bean.Teacher;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

public class TeacherService extends BaseServiceImpl<Teacher> {

	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() throws ServiceException {
		String hql = "SELECT DISTINCT t.year FROM Teacher AS t";
		List list = null;
		try {
			list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("TeacherService层查询年份列表失败", e);
		}
		return list;
	}

	// 返回教师是否存在
	@SuppressWarnings("unchecked")
	public int isExist(String tno) {
		int count = 0;
		String hql = "from Teacher as t where t.tno='" + tno + "'";
		List list = QueryUtilDaoImpl.executeQuery(hql, null);
		count = list.size();
		
		return count;
	}

	// 返回教师姓名
	@SuppressWarnings("unchecked")
	public String findByTno(String tno) {
		String s = "";
		String hql = "select t.tname from Teacher as t where t.tno='" + tno
				+ "'";
		List list = QueryUtilDaoImpl.executeQuery(hql, null);
		if (list.size() == 0) {
			s = "该教师不存在";
		} else {
			s = (String) list.get(0);
		}
		return s;
	}
	@SuppressWarnings("unchecked")
	public List<Teacher> findallTeacherList(int page, int rows, String mno,String dno) {
		String hql = "";
		List<Teacher> list = null;
		if(!mno.equals("000000")){
			hql="from Teacher t where t.major.mno=?";
			hql += " order by t.tno"; 
			String param[]={mno};
			list = (List<Teacher>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Teacher t where t.major.department.dno=?";
			hql += " order by t.tno"; 
			String param[]={dno};
			list = (List<Teacher>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Teacher t";
			hql += " order by t.tno"; 
			list = (List<Teacher>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii==="+list.size());			
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	// 多条件查询（教师编号、教师名称、专业、学院）
	public List<Teacher> findTeacherList(TeacherModel teachermodel, int page,
			int rows, String mno,String dno) throws ServiceException {
		System.out.println("===="+mno);
		if(!mno.equals("000000")){
			teachermodel.setMajorId(mno);
			
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			
			teachermodel.setDepartmentId(dno);
		}
		String hql = "from Teacher as t where " + "t.tname like :ty";
		Map mapParam = new HashMap();
		mapParam.put("ty", "%" + teachermodel.getTname() + "%");
		//mapParam.put("td", "%" + teachermodel.getDepartmentId() + "%");
		List<Teacher> list = null;
		try {

			// 编号
			if (teachermodel.getTno() != null
					&& !"".equals(teachermodel.getTno())) {

				hql += " and t.tno='" + teachermodel.getTno() + "'";
			}
			// 专业
			if (teachermodel.getMajorId() != null && !"".equals(teachermodel.getMajorId())&& !"%".equals(teachermodel.getMajorId())) {

				hql += " and t.major.mno='" + teachermodel.getMajorId()+"'";
			}
			// 学院
			if (teachermodel.getDepartmentId() != null
					&& !"".endsWith(teachermodel.getDepartmentId())) {

				hql += " and t.major.department.dno='"
						+ teachermodel.getDepartmentId() + "'";
			}
			// 职称
			if (teachermodel.getProfessionaltitle()!=null && teachermodel.getProfessionaltitle().getProfessionalTitleNo()!= null
					&& !"".equals(teachermodel.getProfessionaltitle().getProfessionalTitleNo())) {

				hql += " and t.professionaltitle.professionalTitleNo='" + teachermodel.getProfessionaltitle().getProfessionalTitleNo() + "'";
			}
			//学位
			if (teachermodel.getAcademicdegree()!=null && teachermodel.getAcademicdegree().getBestDegreeNo()!= null
					&& !"".equals(teachermodel.getAcademicdegree().getBestDegreeNo())) {

				hql += " and t.academicdegree.bestDegreeNo='" + teachermodel.getAcademicdegree().getBestDegreeNo() + "'";
			}
			hql += " order by t.tno"; 
			//测试
			System.out.println("教师查找"+hql);
			
			list = (List<Teacher>) QueryUtilDaoImpl.executeQueryByPage(hql,
					null, mapParam, page, rows);
			System.out.println("list==="+list.size());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("TeacherService层多条件查询失败", e);
		}
		return list;

	}
	// 查询结果条数

	public int count(String mno,String dno)
			throws ServiceException {
		int count=0;	
		String hql="";
		if(!mno.equals("000000")){
			hql="select count(*) from  Teacher t where t.major.mno=?";
			String param[]={mno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="select count(*) from Teacher t where t.major.department.dno=?";
			String param[]={dno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			
		}else{
			hql="select count(*) from Teacher";
			
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
			
		}
		return count;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindTeacher(TeacherModel teachermodel)
			throws ServiceException {
		//System.out.println("学院信息："+teachermodel.getDepartmentId()+"专业信息"+teachermodel.getMajorId());
		String hql = "select count(*) from Teacher as t where "
				+ "t.tname like :ty";
		int count = 0;

		// 教师编号
		try {

			Map mapParam = new HashMap();
			mapParam.put("ty", "%" + teachermodel.getTname() + "%");
			
			// 编号
			if (teachermodel.getTno() != null
					&& !"".equals(teachermodel.getTno())) {

				hql += " and t.tno='" + teachermodel.getTno() + "'";
			}
			// 专业
			if (teachermodel.getMajorId() != null && !"".equals(teachermodel.getMajorId())&& !"%".equals(teachermodel.getMajorId())) {

				hql += " and t.major.mno='" + teachermodel.getMajorId()+"'";
			}
			// 学院
			if (teachermodel.getDepartmentId() != null
					&& !"".endsWith(teachermodel.getDepartmentId())) {

				hql += " and t.major.department.dno='"
						+ teachermodel.getDepartmentId() + "'";
			}
			// 职称
			if (teachermodel.getProfessionaltitle()!=null && teachermodel.getProfessionaltitle().getProfessionalTitleNo()!= null
					&& !"".equals(teachermodel.getProfessionaltitle().getProfessionalTitleNo())) {

				hql += " and t.professionaltitle.professionalTitleNo='" + teachermodel.getProfessionaltitle().getProfessionalTitleNo() + "'";
			}
			//学位
			if (teachermodel.getAcademicdegree()!=null && teachermodel.getAcademicdegree().getBestDegreeNo()!= null
					&& !"".equals(teachermodel.getAcademicdegree().getBestDegreeNo())) {

				hql += " and t.academicdegree.bestDegreeNo='" + teachermodel.getAcademicdegree().getBestDegreeNo() + "'";
			}
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
			System.out.println("count=========" + count);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("TeacherService层查询结果条数失败", e);
		}
		return count;

	}

	/**
	 * 自动查询
	 * 
	 * @param userId
	 * @param role
	 * @param idname
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> autoSearch(String userId, String role, String idname)
			throws ServiceException {

		@SuppressWarnings("unused")
		Teacher teacher = this.findById(Teacher.class, userId);
		System.out.println("userId=====" + userId);
		List<Object[]> resultList = null;
		if ("student".equals(role)) {
			String hql = "SELECT s.stuNumber, s.stuName FROM Student AS s WHERE (s.stuNumber LIKE :idname OR s.stuName LIKE :idname) ";
			Map<String, String> mapParam = new HashMap<String, String>();
			mapParam.put("idname", "%" + idname + "%");
			System.out.println("idname=====" + idname);
			resultList = (List<Object[]>) QueryUtil.executeQuery(hql, null,
					mapParam);

		} else if ("teacher".equals(role)) {
			String hql = "SELECT t.tno, t.tname FROM Teacher AS t WHERE (t.tno LIKE :idname OR t.tname LIKE :idname) ";
			Map<String, String> mapParam = new HashMap<String, String>();
			mapParam.put("idname", "%" + idname + "%");
			System.out.println("idname=====" + idname);
			resultList = (List<Object[]>) QueryUtil.executeQuery(hql, null,
					mapParam);
		}
		return resultList;
	}

	/**
	 * 根据所在学院查找教师
	 * 
	 * @param dno
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Teacher> findByCollegeId(String dno) {
		String hql = "FROM Teacher AS t WHERE t.major.department.dno = ?";
		String[] param = { dno };
		return (List<Teacher>) QueryUtil.executeQuery(hql, param);
	}

	@SuppressWarnings("unchecked")
	public List<Teacher> findByCollegeIdByPage(String dno, int page, int rows) {
		String hql = "FROM Teacher AS t WHERE t.major.department.dno = ? ORDER BY t.tno";
		String[] param = { dno };
		return (List<Teacher>) QueryUtil.executeQueryByPage(hql, param, page,
				rows);
	}

	public int countFindByCollegeId(String dno) {
		String countHql = "SELECT COUNT(*) FROM Teacher AS t WHERE t.major.department.dno = ?";
		String[] param = { dno };
		return QueryUtil.getResultCountForHql(countHql, param);
	}

	/**
	 * 根据教师编号查找教师姓名
	 * 
	 * @param dno
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Teacher> findTnameListByTno(String tno) {
		String hql = "FROM Teacher AS teacher WHERE teacher.tno = ?";
		String[] param = { tno };
		return (List<Teacher>) QueryUtilDaoImpl.executeQuery(hql, param);
	}

	@SuppressWarnings("unchecked")
	public List<Teacher> exportallTeacherList(TeacherModel teachermodel, String mno,String dno) {
		// teachermodel.setMajorId(mno);
		//System.out.println("教师学院:"+teachermodel.getDepartmentId());
		if(!mno.equals("000000")){
			teachermodel.setMajorId(mno);			
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			teachermodel.setDepartmentId(dno);
		}
		String hql = "from Teacher as t where " + "t.tname like :ty";
		Map mapParam = new HashMap();
		mapParam.put("ty", "%" + teachermodel.getTname() + "%");

		// 编号
		if (teachermodel.getTno() != null && !"".equals(teachermodel.getTno())) {

			hql += " and t.tno='" + teachermodel.getTno() + "'";
		}
		// 职称
		if (teachermodel.getProfessionaltitle().getProfessionalTitleNo()!= null
				&& !"".equals(teachermodel.getProfessionaltitle().getProfessionalTitleNo())) {

			hql += " and t.professionaltitle.professionalTitleNo='" + teachermodel.getProfessionaltitle().getProfessionalTitleNo() + "'";
		}
		//学位
		if (teachermodel.getAcademicdegree().getBestDegreeNo()!= null
				&& !"".equals(teachermodel.getAcademicdegree().getBestDegreeNo())) {

			hql += " and academicdegree.bestDegreeNo='" + teachermodel.getAcademicdegree().getBestDegreeNo() + "'";
		}
		// 专业
		if (teachermodel.getMajorId() != null && !"".equals(teachermodel.getMajorId())&& !"%".equals(teachermodel.getMajorId())) {

			hql += " and t.major.mno='" + teachermodel.getMajorId()+"'";
		}
		// 学院
		if (teachermodel.getDepartmentId() != null
				&& !"".endsWith(teachermodel.getDepartmentId())) {

			hql += " and t.major.department.dno='"+ teachermodel.getDepartmentId() + "'";
		}
		System.out.println(hql);
		List<Teacher> list = (List<Teacher>) QueryUtilDaoImpl.executeQuery(hql,
				null, mapParam);

		return list;

	}

}
