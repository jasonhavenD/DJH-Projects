package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import cn.edu.nwsuaf.Model.TeachprojectModel;
import cn.edu.nwsuaf.bean.Teachproject;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class TeachprojectService extends BaseServiceImpl<Teachproject> {
	@SuppressWarnings("unchecked")
	public List<Teachproject> findallTeachprojectList(int page, int rows, String mno,String dno) {
		String hql = "";
		List<Teachproject> list = null;
		if(!mno.equals("000000")){
			hql="from Teachproject tp where tp.tprojectNo in(select tpu.teachproject.tprojectNo from Teachprojectuser tpu where tpu.teacher.major.mno=?)";
			String param[]={mno};
			list = (List<Teachproject>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Teachproject tp where tp.tprojectNo in(select tpu.teachproject.tprojectNo from Teachprojectuser tpu where tpu.teacher.major.department.dno=?)";
			String param[]={dno};
			list = (List<Teachproject>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Teachproject";
			
			list = (List<Teachproject>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()==="+list.size());
			
		}
		return list;
	}
	public int count(String mno, String dno) throws ServiceException {
		int count = 0;
		String hql = "";
		if (!mno.equals("000000")) {
			hql = "select count(*) from  Teachproject tp where tp.tprojectNo in(select tpu.teachproject.tprojectNo from Teachprojectuser tpu where tpu.teacher.major.mno=?)";
			String param[] = { mno };
			count = QueryUtilDaoImpl.getResultCountForHql(hql, param);
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "select count(*) from Teachproject tp where tp.tprojectNo in(select tpu.teachproject.tprojectNo from Teachprojectuser tpu where tpu.teacher.major.department.dno=?)";
			String param[] = { dno };
			count = QueryUtilDaoImpl.getResultCountForHql(hql, param);

		} else {
			hql = "select count(*) from Teachproject";
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null);

		}
		return count;

	}
	@SuppressWarnings( { "unchecked" })
	// 多条件查询（教材编号、教材名称、出版时间、出版社、级别、优秀教材级别、优秀教材奖项级别、专业、学院）
	public List<Teachproject> findTPList(TeachprojectModel teachprojectModel,
			int page, int rows) {

		String hql = "from Teachproject as tp where "
				+ "tp.tprojectName like :tpn";
		Map mapParam = new HashMap();

		// 质量工程名
		mapParam.put("tpn", "%" + teachprojectModel.getName() + "%");
		
		// 质量工程年份
		if (teachprojectModel.getYear() != null
				&& !"".equals(teachprojectModel.getYear())) {
			hql += " and tp.year like :tbY";
			mapParam.put("tbY", "%" + teachprojectModel.getYear() + "%");
		}
		// 质量工程级别
		if (teachprojectModel.getTprojecJibie() != null
				&& !"".equals(teachprojectModel.getTprojecJibie())) {
			hql += " and tp.tprojecJibie like :tbJ";
			mapParam
					.put("tbJ", "%" + teachprojectModel.getTprojecJibie() + "%");
		}
		// 质量工程类型
		if (teachprojectModel.getTprojecType() != null
				&& !"".equals(teachprojectModel.getTprojecType())) {
			hql += " and tp.tprojecType like :tbC";
			mapParam.put("tbC", "%" + teachprojectModel.getTprojecType() + "%");
		}
		// 学院
		if (teachprojectModel.getDepartmentId() != null
				&& !"".equals(teachprojectModel.getDepartmentId())) {
			hql += " and tp.tprojectNo in(select tpu.teachproject.tprojectNo from Teachprojectuser tpu where tpu.teacher.major.department.dno like :dn)";
			mapParam.put("dn", "%" + teachprojectModel.getDepartmentId() + "%");
		}
		// 专业
		if (teachprojectModel.getMajorId() != null
				&& !"".equals(teachprojectModel.getMajorId())&& !"%".equals(teachprojectModel.getMajorId())) {
			hql += " and tp.tprojectNo in(select tpu.teachproject.tprojectNo from Teachprojectuser tpu where tpu.teacher.major.mno like :mn)";
			mapParam.put("mn", "%" + teachprojectModel.getMajorId() + "%");
		}

		List<Teachproject> list = (List<Teachproject>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		System.out.println(hql);
		return list;
	}

	// 查询结果条数
	@SuppressWarnings( { "unchecked" })
	public int countFindTBooks(TeachprojectModel teachprojectModel) {
		int count = 0;
		String hql = "select count(*) from Teachproject as tp where "
				+ "tp.tprojectName like :tpn";
		Map mapParam = new HashMap();
		// 质量工程名
		mapParam.put("tpn", "%" + teachprojectModel.getName() + "%");
		
		// 质量工程年份
		if (teachprojectModel.getYear() != null
				&& !"".equals(teachprojectModel.getYear())) {
			hql += " and tp.year like :tbY";
			mapParam.put("tbY", "%" + teachprojectModel.getYear() + "%");
		}
		// 质量工程级别
		if (teachprojectModel.getTprojecJibie() != null
				&& !"".equals(teachprojectModel.getTprojecJibie())) {
			hql += " and tp.tprojecJibie like :tbJ";
			mapParam
					.put("tbJ", "%" + teachprojectModel.getTprojecJibie() + "%");
		}
		// 质量工程类型
		if (teachprojectModel.getTprojecType() != null
				&& !"".equals(teachprojectModel.getTprojecType())) {
			hql += " and tp.tprojecType like :tbC";
			mapParam.put("tbC", "%" + teachprojectModel.getTprojecType() + "%");
		}
		// 学院
		if (teachprojectModel.getDepartmentId() != null
				&& !"".equals(teachprojectModel.getDepartmentId())) {
			hql += " and tp.tprojectNo in(select tpu.teachproject.tprojectNo from Teachprojectuser tpu where tpu.teacher.major.department.dno like :dn)";
			mapParam.put("dn", "%" + teachprojectModel.getDepartmentId() + "%");
		}
		// 专业
		if (teachprojectModel.getMajorId() != null
				&& !"".equals(teachprojectModel.getMajorId())&& !"%".equals(teachprojectModel.getMajorId())) {
			hql += " and tp.tprojectNo in(select tpu.teachproject.tprojectNo from Teachprojectuser tpu where tpu.teacher.major.mno like :mn)";
			mapParam.put("mn", "%" + teachprojectModel.getMajorId() + "%");
		}

		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=======" + count);
		return count;

	}

	
	@SuppressWarnings("unchecked")
	public int isExist(String tprojectNo) {

		int count = 0;
		String hql = "select count(*) from Teachproject as a where "
				+ "a.tprojectNo like :ci ";
		 Map mapParam = new HashMap();
		 // 获奖证书编号
		 mapParam.put("ci", tprojectNo );

		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		return count;
	}
	@SuppressWarnings( { "unchecked" })
	// 导出
	public List<Teachproject> exportTPList(TeachprojectModel teachprojectModel
			) {

		String hql = "from Teachproject as tp where "
				+ "tp.tprojectName like :tpn";
		Map mapParam = new HashMap();

		// 质量工程名
		mapParam.put("tpn", "%" + teachprojectModel.getName() + "%");
		
		// 质量工程年份
		if (teachprojectModel.getYear() != null
				&& !"".equals(teachprojectModel.getYear())) {
			hql += " and tp.year like :tbY";
			mapParam.put("tbY", "%" + teachprojectModel.getYear() + "%");
		}
		// 质量工程级别
		if (teachprojectModel.getTprojecJibie() != null
				&& !"".equals(teachprojectModel.getTprojecJibie())) {
			hql += " and tp.tprojecJibie like :tbJ";
			mapParam
					.put("tbJ", "%" + teachprojectModel.getTprojecJibie() + "%");
		}
		// 质量工程类型
		System.out.println("as"+teachprojectModel.getTprojecType());
		if (teachprojectModel.getTprojecType() != null
				&& !"".equals(teachprojectModel.getTprojecType())) {
			hql += " and tp.tprojecType like :tbC";
			mapParam.put("tbC", "%" + teachprojectModel.getTprojecType() + "%");
		}
		// 学院
		if (teachprojectModel.getDepartmentId() != null
				&& !"".equals(teachprojectModel.getDepartmentId())) {
			hql += " and tp.tprojectNo in(select tpu.teachproject.tprojectNo from Teachprojectuser tpu where tpu.teacher.major.department.dno like :dn)";
			mapParam.put("dn", "%" + teachprojectModel.getDepartmentId() + "%");
		}
		// 专业
		if (teachprojectModel.getMajorId() != null
				&& !"".equals(teachprojectModel.getMajorId())&& !"%".equals(teachprojectModel.getMajorId())) {
			hql += " and tp.tprojectNo in(select tpu.teachproject.tprojectNo from Teachprojectuser tpu where tpu.teacher.major.mno like :mn)";
			mapParam.put("mn", "%" + teachprojectModel.getMajorId() + "%");
		}
		System.out.println("as"+hql);
		List<Teachproject> list = (List<Teachproject>) QueryUtilDaoImpl
				.executeQuery(hql, null, mapParam);
		System.out.println(list.size());
		return list;
	}

	// 根据学院Id查专业，用于下拉列表====待完善
	public JSONArray findMajorByDno(String dno) {

		JSONArray jsonArray = QueryUtilDaoImpl.findMajorByDno(dno);
		return jsonArray;
	}

	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() {
		String hql = "SELECT DISTINCT tp.year FROM Teachproject AS tp";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("年份=============" + list.size());
		return list;
	}

	// 返回获奖级别
	@SuppressWarnings("unchecked")
	public List<String> findTprojecJibieList() {
		String hql = "SELECT DISTINCT tp.tprojecJibie FROM Teachproject AS tp";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("级别=============" + list.size());
		return list;
	}

	// 返回获奖类别
	@SuppressWarnings("unchecked")
	public List<String> findTprojecTypeList() {
		String hql = "SELECT DISTINCT tp.tprojecType FROM Teachproject AS tp";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("类别=============" + list.size());
		return list;
	}
}
