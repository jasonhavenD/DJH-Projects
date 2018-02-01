package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.bean.Assessingneedtarget;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;

public class AssessingneedtargetService extends BaseServiceImpl<Assessingneedtarget>{
	
	/**
	 * 初始化获取list
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Assessingneedtarget> findallAssNeedTargetList(int page, int rows) {
		String sortHQL = "order by a.assessingproject.masprojectName desc , a.appraisalsystem.indicatorName asc";
		String hql = "from Assessingneedtarget as a "+sortHQL;
		List<Assessingneedtarget> list = (List<Assessingneedtarget>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, page, rows);
		return list;
	}
	/**
	 * 根据指标级别查询
	 * @param tag
	 * @return
	 */
	public List<Assessingneedtarget> findallAssNeedTargetList(int tag) {
		List<Assessingneedtarget> list=null;
		if(tag==0){
			System.out.println("获取所有指标");
			String hql = "from Assessingneedtarget ass where (ass.appraisalsystem.indNameExp='一级指标' or ass.appraisalsystem.indNameExp='二级指标' or ass.appraisalsystem.indNameExp='三级指标') and ass.assessingproject.tag='1' order by ass.appraisalsystem.indicatorName";
			list = (List<Assessingneedtarget>) QueryUtilDaoImpl.executeQuery(hql, null);
			System.out.println("获取所有指标"+list.size());
		}
		else if(tag==1){
			String hql = "from Assessingneedtarget ass where ass.appraisalsystem.indNameExp='一级指标' and ass.assessingproject.tag='1' order by ass.appraisalsystem.indicatorName";
			list = (List<Assessingneedtarget>) QueryUtilDaoImpl.executeQuery(hql, null);
		}else if(tag==2){
			String hql = "from Assessingneedtarget ass where ass.appraisalsystem.indNameExp='二级指标' and ass.assessingproject.tag='1' order by ass.appraisalsystem.indicatorName";
			list = (List<Assessingneedtarget>) QueryUtilDaoImpl.executeQuery(hql, null);
		}
		else if(tag==3){
			String hql = "from Assessingneedtarget ass where ass.appraisalsystem.indNameExp='三级指标' and ass.assessingproject.tag='1' order by ass.appraisalsystem.indicatorName";
			list = (List<Assessingneedtarget>) QueryUtilDaoImpl.executeQuery(hql, null);
		}
		
		return list;
	}
	/**
	 * 多条件查询
	 * @param basemodel
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Assessingneedtarget> findAssNeedTargetList(BaseModel basemodel,
			int page, int rows) {
		String sortHQL = " order by ass.assessingproject.masprojectName desc , ass.appraisalsystem.indicatorName asc";
		String hql = "from Assessingneedtarget as ass where 1 = 1";
		//指标编号
		if(basemodel.getId() != null && !"".equals(basemodel.getId())){
			hql += " and ass.appraisalsystem.indicatorId like '%"+basemodel.getId()+"%'";
		}
		//指标名称
		if(basemodel.getName() != null && !"".equals(basemodel.getName())){
			hql += " and ass.appraisalsystem.indicatorName like '%"+basemodel.getName()+"%'";
		}
		// 开启评估项目名称
		if(basemodel.getYear() != null && !"".equals(basemodel.getYear())){
			hql += " and ass.assessingproject.masprojectName='"+basemodel.getYear()+"'";
		}
		hql += sortHQL;
		System.out.println(hql);
		List<Assessingneedtarget> list = (List<Assessingneedtarget>) QueryUtilDaoImpl.executeQueryByPage(hql, null, page, rows);
		return list;
	}

	/**
	 * 查询结果条数
	 * 
	 */
	public int countFindAssNeedTarget(BaseModel basemodel) {
		int count;
		String hql = "select count(*) from Assessingneedtarget as ass where 1 = 1";
		//指标编号
		if(basemodel.getId() != null && !"".equals(basemodel.getId())){
			hql += " and ass.appraisalsystem.indicatorId like '%"+basemodel.getId()+"%'";
		}
		//指标名称
		if(basemodel.getName() != null && !"".equals(basemodel.getName())){
			hql += " and ass.appraisalsystem.indicatorName like '%"+basemodel.getName()+"%'";
		}
		// 开启评估项目名称
		if(basemodel.getYear() != null && !"".equals(basemodel.getYear())){
			hql += " and ass.assessingproject.masprojectName='"+basemodel.getYear()+"'";
		}
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null);
		return count;

	}
	/**
	 * 根据当前开始的评估期查询
	 * @return
	 */
	public List<Assessingneedtarget> findAssessingNeedTargetByDate(){
		String hql = "from Assessingneedtarget as ass where ass.assessingproject.tag=1 order by ass.appraisalsystem.indicatorName";
		List<Assessingneedtarget> list = (List<Assessingneedtarget>) QueryUtilDaoImpl.executeQuery(hql, null);
		return list;
	}
	public Assessingneedtarget findByIndicatorIdAndProName(String indicatorId, String masProjectName){
		String hql = "from Assessingneedtarget as ass where ass.appraisalsystem.indicatorId='"+indicatorId+"' and ass.assessingproject.masprojectName='"+masProjectName+"'";
		Assessingneedtarget assNeedTarget = (Assessingneedtarget)QueryUtilDaoImpl.uniqueResult(hql, null);
		return assNeedTarget;
	}
	
}
