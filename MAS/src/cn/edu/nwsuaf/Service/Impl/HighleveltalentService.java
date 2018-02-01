package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.HighleveltalentModel;
import cn.edu.nwsuaf.Service.Interface.IHighleveltalentService;
import cn.edu.nwsuaf.bean.Highleveltalent;
import cn.edu.nwsuaf.bean.Majorcourse;
import cn.edu.nwsuaf.bean.Teacher;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class HighleveltalentService extends BaseServiceImpl<Highleveltalent> implements IHighleveltalentService{
	
	//分页获取全部高层次人才信息
	@SuppressWarnings("unchecked")
	public List<Highleveltalent> getAllHighListByPage(String mno,String dno,int page, int rows) throws ServiceException{
		/*
		
		*/
		String hql = "";
		List<Highleveltalent> list = null;
		if(!mno.equals("000000")){
			hql="from Highleveltalent as h where h.teacher.major.mno=?";
			String param[]={mno};
			list = (List<Highleveltalent>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Highleveltalent as h where h.teacher.major.department.dno=?";
			String param[]={dno};
			list = (List<Highleveltalent>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Highleveltalent";
			
			list= (List<Highleveltalent>) QueryUtilDaoImpl.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii==="+list.size());
			
		}
		return list;
	}
	public List<Highleveltalent> getAllHighListByPage(int page, int rows) throws ServiceException{
		String hql = "from Highleveltalent";
		List list=null;
		try {
			list= (List<Highleveltalent>) QueryUtilDaoImpl.executeQueryByPage(hql, null, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("HighleveltalentService层分页获取全部高层次人才信息失败", e);
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Teacher> findAllInSort(){
		String hql = "select distinct teacher from Highleveltalent ";//order by teacher.tname asc
		List list = null;
		try {
			list = (List<Teacher>)QueryUtilDaoImpl.executeQuery(hql, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//获取获得年份信息
	@SuppressWarnings("unchecked")
	public List<String> findYear() throws ServiceException{
		String hql = "select distinct h.year from Highleveltalent as h";
		List list = null;
		try{
			list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			Collections.sort(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("HighleveltalentService层获取获得年份信息失败", e);
		}
		System.out.println("获得年份=============" + list.size());
		return list;
	}
	
	//获取人才类型信息
	
	public List<String> findTalentType() throws ServiceException{
		List<String> list = new ArrayList<String>() ;
		try {
			list.add("国家特聘专家");
			list.add("长江学者特聘教授");
			list.add("长江学者讲座教授");
			list.add("教育部创新团队");
			list.add("国家杰出青年基金获得者");
			list.add("国家“百千万人才工程”入选者");
			list.add("国家级有突出贡献专家");
			list.add("教育部“跨世界优秀人才计划”入选者");
			list.add("高校青年教师奖入选者");
			list.add("高等学校优秀青年教师资助计划入选者");
			list.add("高等学校教学名师奖获得者");
			list.add("万人计划教学名师（高等学校）");
			list.add("万人计划科技创新领军人才");
			list.add("农业科研杰出人才及其创新团队");
			list.add("教育部“新世纪优秀人才支持计划”入选者");
			list.add("陕西省“百人计划”");
			list.add("秦学者");
			list.add("西省重点科技创新团队");
			list.add("后稷学者特聘教授入选者");
			list.add("后稷学者讲座教授入选者");
			list.add("学校“创新团队支持计划”入选者");
			list.add("学校“学科带头人支持计划”入选者");
			list.add("学校“拔尖人才支持计划”入选者");
			list.add("学校“青年学术骨干支持计划”入选者");
			list.add("学校“推广专家支持计划”入选者");
			list.add("学校“教学名师支持计划”入选者");	
			list.add("“青年千人计划”入选者");
			Collections.sort(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("HighleveltalentService层获取人才类型信息失败", e);
		}
		System.out.println("人才类型============="+list.size());
		return list;
	}
	
	//获取研究领域信息
	@SuppressWarnings("unchecked")
	public List<String> findRearchField() throws ServiceException{
		String hql = "select distinct h.rearchField from Highleveltalent as h";
		List list = null;
		try {
			list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			Collections.sort(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("HighleveltalentService层获取研究领域信息失败", e);
		}
		System.out.println("研究领域============"+list.size());
		return list;
	}
	
	//更新高层次人才信息
	public void updateHigh(Highleveltalent high) throws ServiceException{
		try {
			this.update(high);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException("HighleveltalentService层更新高层次人才信息失败", e);
		}
	}
	
	//保存高层次人才信息
	public void saveHigh(Highleveltalent high) throws ServiceException{
		try {
			this.save(high);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException("HighleveltalentService层保存高层次人才信息失败", e);
		}
	}
	
	//删除高层次人才信息
	public void deleteHigh(Highleveltalent highleveltalent) throws ServiceException{
		
		try {
			this.delete(highleveltalent);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException("HighleveltalentService层删除高层次人才信息失败", e);
		}
		
	}
	
	// 导出
	@SuppressWarnings("unchecked")
	public List<Highleveltalent> exportallHighList(HighleveltalentModel hmodel) {

		String hql = "from Highleveltalent as h where "
			+ "h.teacher.tno like :ti and " + "h.teacher.tname like :tno";
		
		Map mapParam = new HashMap();
		//教师编号
		mapParam.put("ti", "%" + hmodel.getId()+ "%");
		//教师名称
		mapParam.put("tno", "%" + hmodel.getName() + "%");
		//获得年份
		if(hmodel.getYear()!=null&&!"".equals(hmodel.getYear())){
			
			hql+=" and h.year= "+hmodel.getYear();
		}
		// 学院
		if (hmodel.getDepartmentId() != null
				&& !"".endsWith(hmodel.getDepartmentId())) {

			hql += " and h.teacher.major.department.dno='" + hmodel.getDepartmentId()+"'";
		}
		// 专业
		if (hmodel.getMajorId() != null && !"".equals(hmodel.getMajorId())&& !"%".equals(hmodel.getMajorId())) {

			hql += " and h.teacher.major.mno='" + hmodel.getMajorId()+"'";
		}
		//人才类型
		if(hmodel.getTalentType() != null && !"".equals(hmodel.getTalentType())){
			hql += " and h.talentType='" + hmodel.getTalentType()+"'";
		}

		//研究领域
		if(hmodel.getRearchField() != null && !"".equals(hmodel.getRearchField())){
			hql += " and h.rearchField='" + hmodel.getRearchField()+"'";
		}
		List<Highleveltalent> list = (List<Highleveltalent>) QueryUtilDaoImpl.executeQuery(hql, null, mapParam);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	// 多条件查询（序号、教师编号、获得年份、学院、专业、人才类型、研究领域）
	public List<Highleveltalent> findHighList(HighleveltalentModel hmodel, int page, int rows)  throws ServiceException{
		List<Highleveltalent> list;
		try {
			String hql = "from Highleveltalent as h where "
				+ "h.teacher.tno like :ti and " + "h.teacher.tname like :tno";
			
			Map mapParam = new HashMap();
			//教师编号
			mapParam.put("ti", "%" + hmodel.getId()+ "%");
			//教师名称
			mapParam.put("tno", "%" + hmodel.getName() + "%");
			//获得年份
			if(hmodel.getYear()!=null&&!"".equals(hmodel.getYear())){
				
				hql+=" and h.year= "+hmodel.getYear();
			}
			// 学院
			if (hmodel.getDepartmentId() != null
					&& !"".endsWith(hmodel.getDepartmentId())) {

				hql += " and h.teacher.major.department.dno='" + hmodel.getDepartmentId()+"'";
			}
			// 专业
			if (hmodel.getMajorId() != null && !"".equals(hmodel.getMajorId())&& !"%".equals(hmodel.getMajorId())) {

				hql += " and h.teacher.major.mno='" + hmodel.getMajorId()+"'";
			}
			//人才类型
			if(hmodel.getTalentType() != null && !"".equals(hmodel.getTalentType())){
				hql += " and h.talentType='" + hmodel.getTalentType()+"'";
			}

			//研究领域
			if(hmodel.getRearchField() != null && !"".equals(hmodel.getRearchField())){
				hql += " and h.rearchField='" + hmodel.getRearchField()+"'";
			}
			System.out.println("highlevel:"+hql);
			list = (List<Highleveltalent>) QueryUtilDaoImpl.executeQueryByPage(hql, null, mapParam, page, rows);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException("多条件查询失败",e);
		}
		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindHigh(HighleveltalentModel hmodel)  throws ServiceException{

		int count;
		try {
			String hql = "select count(*) from Highleveltalent as h where "
				+ "h.teacher.tno like :ti and " + "h.teacher.tname like :tno ";

			Map mapParam = new HashMap();
			//教师编号
			mapParam.put("ti", "%" + hmodel.getId()+ "%");
			//教师名称
			mapParam.put("tno", "%" + hmodel.getName() + "%");
			//获得年份
			if(hmodel.getYear()!=null&&!"".equals(hmodel.getYear())){
				
				hql+=" and h.year= "+hmodel.getYear();
			} 
			// 学院
			if (hmodel.getDepartmentId() != null
					&& !"".endsWith(hmodel.getDepartmentId())) {

				hql += " and h.teacher.major.department.dno='" + hmodel.getDepartmentId()+"'";
			}
			// 专业
			if (hmodel.getMajorId() != null && !"".equals(hmodel.getMajorId())&& !"%".equals(hmodel.getMajorId())) {

				hql += " and h.teacher.major.mno='" + hmodel.getMajorId()+"'";
			}
			//人才类型
			if(hmodel.getTalentType() != null && !"".equals(hmodel.getTalentType())){
				hql += " and h.talentType='" + hmodel.getTalentType()+"'";
			}
			//研究领域
			if(hmodel.getRearchField() != null && !"".equals(hmodel.getRearchField())){
				hql += " and h.rearchField='" + hmodel.getRearchField()+"'";
			}
			
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException("查询结果条数失败",e);
		}
		
		return count;

	}
}
