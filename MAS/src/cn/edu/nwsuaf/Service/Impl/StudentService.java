package cn.edu.nwsuaf.Service.Impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.edu.nwsuaf.Model.StudentModel;
import cn.edu.nwsuaf.bean.Student;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class StudentService extends BaseServiceImpl<Student> {
	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() throws ServiceException {
		String hql = "SELECT DISTINCT s.year FROM Student AS s";
		List list = null;
		try {
			list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("StudentService层查询年份列表失败", e);
		}
		return list;
	}
	// 返回年级列表
	@SuppressWarnings("unchecked")
	public List<String> findGradeList() throws ServiceException {
		String hql = "SELECT DISTINCT s.grade FROM Student AS s";
		List list = null;
		try {
			list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("StudentService层查询年级列表失败", e);
		}
		return list;
	}



	// 返回学生是否存在
	@SuppressWarnings("unchecked")
	public int isExist(String sid) {
		int count = 0;
		String hql = "from Student as s where s.stuNumber='" + sid + "'";
		List list = QueryUtilDaoImpl.executeQuery(hql, null);
		count = list.size();
		return count;
	}

	// 根据学号查学生姓名
	@SuppressWarnings("unchecked")
	public String findByStuno(String stuNumber) {
		String s = "";
		if (stuNumber.length() == 0) {
			s = "请输入学号";
			s=(String)s;
		}

		else {
			String hql = "select s.stuName from Student as s where s.stuNumber= '"
					+ stuNumber+"'";
			List list = QueryUtilDaoImpl.executeQuery(hql, null);
			if (list.size() == 0) {
				s = "该学生不存在";
				s=(String)s;
			} else {
				s = (String) list.get(0);
			}
		}
		return s;
	}
	@SuppressWarnings("unchecked")
	public List<Student> findSnameListBySno(String sno) {
		String hql = "FROM Student AS s WHERE s.stuNumber = ?";
		String[] param = { sno };
		return (List<Student>) QueryUtilDaoImpl.executeQuery(hql, param);
	}

	@SuppressWarnings("unchecked")
	public List<Student> findallStudentList(int page, int rows,String mno,String dno) {
		
		
		String hql = "";
		List<Student> list = null;
		if(!mno.equals("000000")){
			hql="from Student t where t.major.mno=?";
			String param[]={mno};
			list = (List<Student>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Student t where t.major.department.dno=?";
			String param[]={dno};
			list = (List<Student>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Student";
			
			list = (List<Student>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii==="+list.size());
			
		}
		
		
		
		return list;

	}
	// 导出
	@SuppressWarnings("unchecked")
	public List<Student> exportallStudentList(StudentModel studentmodel)throws ServiceException {
		
	String hql = "from Student as s where " + "s.stuNumber like :stuI and "
			+ "s.stuName like :stuN";
	
	Map mapParam = new HashMap();
	// 编号
	mapParam.put("stuI", "%" + studentmodel.getId() + "%");
	try {
		studentmodel.setName(java.net.URLDecoder.decode(studentmodel.getName(),"UTF-8"));
		studentmodel.setIsInSchool(java.net.URLDecoder.decode(studentmodel.getIsInSchool(),"UTF-8"));
		studentmodel.setIsRoll(java.net.URLDecoder.decode(studentmodel.getIsRoll(),"UTF-8"));
	} catch (UnsupportedEncodingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
// 名称
mapParam.put("stuN", "%" + studentmodel.getName() + "%");

List<Student> list = null;
try {
	// 年份
	if (studentmodel.getYear() != null && !"".equals(studentmodel.getYear())) {

		hql += " and s.year= '" + studentmodel.getYear()+"'";
	}
	// 年级
	if (studentmodel.getGrade() != null && !"".equals(studentmodel.getGrade())) {

		hql += " and s.grade= '" + studentmodel.getGrade()+"'";
	}

	// 民族
	if (studentmodel.getNational().getNationNnumber() != null && !"".equals(studentmodel.getNational().getNationNnumber())) {

		hql += " and s.national.nationNnumber= '" + studentmodel.getNational().getNationNnumber()+"'";
	}
	
	// 专业
	if (studentmodel.getMajorId() != null && !"".equals(studentmodel.getMajorId()) && !"%".equals(studentmodel.getMajorId())) {

		hql += " and s.major.mno= '" + studentmodel.getMajorId()+"'";
	}
	// 学院
	if (studentmodel.getDepartmentId() != null
			&& !"".endsWith(studentmodel.getDepartmentId())) {

		hql += " and s.major.department.dno= '"
				+ studentmodel.getDepartmentId()+"'";
	}
	//是否有学籍
	if (studentmodel.getIsRoll() != null
			&& !"".endsWith(studentmodel.getIsRoll())) {

		hql += " and s.isRoll='"
				+ studentmodel.getIsRoll()+"'";
	}
	//是否在校
	if (studentmodel.getIsInSchool() != null
			&& !"".endsWith(studentmodel.getIsInSchool())) {

		hql += " and s.isInSchool='"
				+ studentmodel.getIsInSchool()+"'";
	}
	System.out.println("stuhql:"+hql);
	list = (List<Student>) QueryUtilDaoImpl.executeQuery(hql,
			null, mapParam);
} catch (Exception e) {
	e.printStackTrace();
	throw new ServiceException("StudentService层多条件查询失败", e);
}
return list;

}
	@SuppressWarnings("unchecked")
	// 多条件查询
	public List<Student> findStudentList(StudentModel studentmodel, int page, int rows)
			throws ServiceException {
		
		String hql = "from Student as s where " + "s.stuNumber like :stuI and "
				+ "s.stuName like :stuN";

		Map mapParam = new HashMap();
		// 编号
		mapParam.put("stuI", "%" + studentmodel.getId() + "%");
		// 名称
		mapParam.put("stuN", "%" + studentmodel.getName() + "%");

		List<Student> list = null;
		try {
			// 年份
			if (studentmodel.getYear() != null && !"".equals(studentmodel.getYear())) {

				hql += " and s.year= '" + studentmodel.getYear()+"'";
			}
			// 年级
			if (studentmodel.getGrade() != null && !"".equals(studentmodel.getGrade())) {

				hql += " and s.grade= '" + studentmodel.getGrade()+"'";
			}

			// 民族
			if (studentmodel.getNational()!=null && studentmodel.getNational().getNationNnumber() != null && !"".equals(studentmodel.getNational().getNationNnumber())) {

				hql += " and s.national.nationNnumber= '" + studentmodel.getNational().getNationNnumber()+"'";
			}
			
			// 专业
			if (studentmodel.getMajorId() != null && !"".equals(studentmodel.getMajorId()) && !"%".equals(studentmodel.getMajorId())) {

				hql += " and s.major.mno= '" + studentmodel.getMajorId()+"'";
			}
			// 学院
			if (studentmodel.getDepartmentId() != null
					&& !"".endsWith(studentmodel.getDepartmentId())) {

				hql += " and s.major.department.dno= '"
						+ studentmodel.getDepartmentId()+"'";
			}
			//是否有学籍
			if (studentmodel.getIsRoll() != null
					&& !"".endsWith(studentmodel.getIsRoll())) {

				hql += " and s.isRoll='"
						+ studentmodel.getIsRoll()+"'";
			}
			//是否在校
			if (studentmodel.getIsInSchool() != null
					&& !"".endsWith(studentmodel.getIsInSchool())) {

				hql += " and s.isInSchool= '"
						+ studentmodel.getIsInSchool()+"'";
			}
			list = (List<Student>) QueryUtilDaoImpl.executeQueryByPage(hql,
					null, mapParam, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("StudentService层多条件查询失败", e);
		}
		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindStudent(StudentModel studentmodel) throws ServiceException {
		int count = 0;
		String hql = "select count(*) from Student as s where "
				+ "s.stuNumber like :stuI and " + "s.stuName like :stuN";
		Map mapParam = new HashMap();
		// 编号
		mapParam.put("stuI", "%" + studentmodel.getId() + "%");
		// 名称
		mapParam.put("stuN", "%" + studentmodel.getName() + "%");
		try {
			
			// 年份
			if (studentmodel.getYear() != null && !"".equals(studentmodel.getYear())) {

				hql += " and s.year= '" + studentmodel.getYear()+"'";
			}
			// 年级
			if (studentmodel.getGrade() != null && !"".equals(studentmodel.getGrade())) {

				hql += " and s.grade= '" + studentmodel.getGrade()+"'";
			}

			// 民族
			if (studentmodel.getNational()!=null && studentmodel.getNational().getNationNnumber() != null && !"".equals(studentmodel.getNational().getNationNnumber())) {

				hql += " and s.national.nationNnumber= '" + studentmodel.getNational().getNationNnumber()+"'";
			}
			// 专业
			if (studentmodel.getMajorId() != null && !"".equals(studentmodel.getMajorId()) && !"%".equals(studentmodel.getMajorId())) {

				hql += " and s.major.mno= '" + studentmodel.getMajorId()+"'";
			}
			// 学院
			if (studentmodel.getDepartmentId() != null
					&& !"".equals(studentmodel.getDepartmentId())) {

				hql += " and s.major.department.dno= '"
						+ studentmodel.getDepartmentId()+"'";
			}
			//是否有学籍
			if (studentmodel.getIsRoll() != null
					&& !"".endsWith(studentmodel.getIsRoll())) {

				hql += " and s.isRoll='"
						+ studentmodel.getIsRoll()+"'";
			}
			//是否在校
			if (studentmodel.getIsInSchool() != null
					&& !"".endsWith(studentmodel.getIsInSchool())) {

				hql += " and s.isInSchool= '"
						+ studentmodel.getIsInSchool()+"'";
			}
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
			System.out.println("count=========" + count);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("StudentService层查询结果条数失败", e);
		}
		return count;

	}
	public int count(String mno,String dno)throws ServiceException {
		int count=0;	
		String hql="";
		if(!mno.equals("000000")){
			hql="select count(*) from  Student t where t.major.mno=?";
			String param[]={mno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="select count(*) from Student t where t.major.department.dno=?";
			String param[]={dno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			
		}else{
			hql="select count(*) from Student";
			
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
			
		}
		return count;
	}

}
