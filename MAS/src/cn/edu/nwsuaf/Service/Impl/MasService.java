package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.bean.Mas;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class MasService extends BaseServiceImpl<Mas> {

	// 初始化获取list
	@SuppressWarnings("unchecked")
	public List<Mas> findallMasList(int page, int rows,String mno,String dno) {
		String hql = "";
		String sortHQL = " mas.assessingneedtarget.assessingproject.masprojectName desc ,";
		List<Mas> list = null;
		if(!mno.equals("000000")){
			hql="from Mas as mas where mas.major.mno=? order by"+sortHQL+" mas.assessingneedtarget.appraisalsystem.indicatorName";
			String param[]={mno};
			list = (List<Mas>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Mas as mas where mas.major.department.dno=? order by"+sortHQL+" mas.assessingneedtarget.appraisalsystem.indicatorName";
			String param[]={dno};
			list = (List<Mas>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Mas as mas order by"+sortHQL+" mas.assessingneedtarget.appraisalsystem.indicatorName";
			
			list = (List<Mas>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()iii==="+list.size());
			
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	// 多条件查询
	public List<Mas> findMasList(BaseModel basemodel,
			int page, int rows) {
		String hql = "from Mas as mas where "
			+ "mas.assessingneedtarget.appraisalsystem.indicatorId like :indname "// 到指标基本表里找到指标编号
			+ "and mas.assessingneedtarget.assessingproject.masprojectName like :mpname";// 到评估项目表里找到评估项目名称
//		String hql = "from Mas as mas where "
//				+ "mas.assessingneedtarget.appraisalsystem.indicatorId like :indname "
//				+ "and mas.assessingneedtarget.assessingproject.masprojectName like :mpname";
		Map mapParam = new HashMap();
		// 指标名称
		mapParam.put("indname", "%" + basemodel.getId() + "%");
		// 开启项目名称
		mapParam.put("mpname", "%" + basemodel.getName() + "%");
		// 专业
		if (basemodel.getMajorId() != null
				&& !"".equals(basemodel.getMajorId())&& !"%".equals(basemodel.getMajorId())) {

			hql += " and mas.major.mno='" + basemodel.getMajorId()
					+ "'";
		}
		// 学院
		if (basemodel.getDepartmentId() != null
				&& !"".endsWith(basemodel.getDepartmentId())) {

			hql += " and mas.major.department.dno='"
					+ basemodel.getDepartmentId() + "'";
		}
		hql=hql+" order by mas.assessingneedtarget.assessingproject.masprojectName desc ,mas.assessingneedtarget.appraisalsystem.indicatorName";
		List<Mas> list = (List<Mas>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindMas(BaseModel basemodel) {
		int count;
		String hql = "select count(*)  from Mas as mas where "
				+ "mas.assessingneedtarget.appraisalsystem.indicatorId like :indname "
				+ "and mas.assessingneedtarget.assessingproject.masprojectName like :mpname";
		Map mapParam = new HashMap();
		// 指标名称
		mapParam.put("indname", "%" + basemodel.getId() + "%");
		// 开启项目名称
		mapParam.put("mpname", "%" + basemodel.getName() + "%");
		// 专业
		if (basemodel.getMajorId() != null
				&& !"".equals(basemodel.getMajorId())&& !"%".equals(basemodel.getMajorId())) {

			hql += " and mas.major.mno='" + basemodel.getMajorId()
					+ "'";
		}
		// 学院
		if (basemodel.getDepartmentId() != null
				&& !"".endsWith(basemodel.getDepartmentId())) {

			hql += " and mas.major.department.dno='"
					+ basemodel.getDepartmentId() + "'";
		}
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=========" + count);
		return count;

	}
	// 查询结果条
	public int count(String mno,String dno)
			throws ServiceException {
		int count=0;	
		String hql="";
		if(!mno.equals("000000")){
			hql="select count(*) from Mas as mas where  mas.major.mno=?";
			String param[]={mno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="select count(*)from Mas as mas where mas.major.department.dno=?";
			String param[]={dno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			
		}else{
			hql="select count(*) from Mas";
			
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
			
		}
		return count;

	}
	
	/**
	 * 根据指标级别和专业代码查找记录
	 * @param target 指标级别
	 * @param mno 专业代码
	 * @return
	 */
	public List<Mas> findByTargetAndMno(String target,String mno){
		String hql = "from Mas as mas where mas.assessingneedtarget.appraisalsystem.indNameExp = '"+target+"'"
		+" and mas.assessingneedtarget.assessingproject.tag = '1'"
		+" and mas.major.mno = '" +mno + "' order by mas.assessingneedtarget.appraisalsystem.indicatorName";
		List<Mas> list =  (List<Mas>)QueryUtilDaoImpl.executeQuery(hql, null);
		return list;		
	}
	/**
	 * 根据指标编号和专业号查找
	 * @param indcatorId
	 * @param mno
	 * @return
	 */
	public Mas findByTargetNoAndMno(String indcatorId,String mno){
		String hql = "from Mas as mas where mas.assessingneedtarget.appraisalsystem.indicatorId = '"+
		indcatorId +"' and mas.major.mno = '" +mno + "' and mas.assessingneedtarget.assessingproject.tag = '1'";
		Mas mas=  (Mas)QueryUtilDaoImpl.uniqueResult(hql, null);
		return mas;		
	}
	/**
	 * 根据评估所需指标编号计算平均值
	 * @param assessingNeedTargetNo 评估所需指标编号
	 * @return
	 */
	public float calByAssessingNeedTargetNo(int assessingNeedTargetNo){
		String hql = "select avg(mas.assessingScore) from Mas as mas where mas.assessingneedtarget.assessingNeedTargetNo ="+assessingNeedTargetNo
		+ " and mas.assessingneedtarget.assessingproject.tag = '1'";
		Object average = QueryUtilDaoImpl.uniqueResult(hql, null);
        float avg = Float.valueOf(average.toString());
        avg=((float)Math.round(avg*100))/100;
		return avg;
	}
	/**
	 * 根据评估所需指标编号查找
	 * @param assessingNeedTargetNo（这里是指标编号）
	 * @return
	 */
	public List<Mas> findByAssessingNeedTargetNo(int indicatorId){
		String hql = "from Mas as mas where mas.assessingneedtarget.appraisalsystem.indicatorId ='"+indicatorId+"'and mas.assessingneedtarget.status=1 and mas.assessingneedtarget.assessingproject.tag='1'";
		List<Mas> list = (List<Mas>)QueryUtilDaoImpl.executeQuery(hql, null);
		return list;
	}
	/**
	 * 根据评估所需指标状态进行查找
	 * @param status
	 * @return
	 */
	public List<Mas> findByTargetStatus(int status){
		String hql = "from Mas as mas where mas.assessingneedtarget.status='"+status+"' and mas.assessingneedtarget.assessingproject.tag='1'";
		List<Mas> list =  (List<Mas>)QueryUtilDaoImpl.executeQuery(hql, null);
		return list;
	}
	/**
	 * 根据指标级别查找(结果为所有专业的当前级别指标得分）
	 * @param targetLevel
	 * @return
	 */
	public List<Mas> findByTargetLevel(String targetLevel){
		String hql = "from Mas as mas where mas.assessingneedtarget.appraisalsystem.indNameExp = '"+targetLevel+"' and mas.assessingneedtarget.assessingproject.tag='1' order by mas.assessingneedtarget.appraisalsystem.indicatorName";
		List<Mas> list = (List<Mas>)QueryUtilDaoImpl.executeQuery(hql, null);
		return list;
	}
	/**
	 * 根据指标编号和专业类别查找
	 * @param indicatorID指标编号
	 * @param classcode 专业分类（按农、工、理、经人分类）
	 * @return
	 */
	public List<Map> getMasScoreMap(int indicatorId,String classcode){
		String hql = "select new map(t.major.mno as mno , t.assessingScore as assessingScore) from Mas as t where t.assessingneedtarget.appraisalsystem.indicatorId='"+indicatorId+"' and t.major.mno in" +
				"(select mc.major.mno from Majortoclass as mc where mc.majorclass.classcode='"+classcode+"')";
		List <Map> mapList =    (List<Map>) QueryUtilDaoImpl.executeQuery(hql,  null);
		for(Map map:mapList){		
			Float value=(Float) map.get("assessingScore");
			if(value==null){
				map.put("assessingScore", 0.00);
			}else{
				map.put("assessingScore",Double.parseDouble(String.valueOf(value)));
			}
			
		}
		return mapList;
	}
	/**
	 * 根据PID查找
	 * @param PID 父编号
	 * @return
	 */
	public List<Mas> findByPID(String pID,String mno){
		String hql = "from Mas as mas where mas.assessingneedtarget.appraisalsystem.pid ='"+pID+"' and mas.major.mno='"+mno+"'"
		+ " and mas.assessingneedtarget.assessingproject.tag = '1' "
		+"order by mas.assessingneedtarget.appraisalsystem.indicatorName";
		List<Mas> list = (List<Mas>)QueryUtilDaoImpl.executeQuery(hql, null);
		return list;
	}
	/**
	 * 根据评估所需指标查找最大值
	 * @param assessingNeedTargetNo
	 * @return
	 */
	public float findMaxByAssessingNeedTargetNo(int assessingNeedTargetNo){
		String hql = "select max(mas.assessingScore) from Mas as mas where mas.assessingneedtarget.assessingNeedTargetNo ="+assessingNeedTargetNo;
		Object max_ = QueryUtilDaoImpl.uniqueResult(hql, null);
        float max = Float.valueOf(max_.toString());
        max=((float)Math.round(max*100))/100;
		return max;
	}
	/**
	 * 根据评估所需指标查找最小值
	 * @param assessingNeedTargetNo
	 * @return
	 */
	public float findMinByAssessingNeedTargetNo(int assessingNeedTargetNo){
		String hql = "select min(mas.assessingScore) from Mas as mas where mas.assessingneedtarget.assessingNeedTargetNo ="+assessingNeedTargetNo;
		Object min_ = QueryUtilDaoImpl.uniqueResult(hql, null);
        float min = Float.valueOf(min_.toString());
         min=((float)Math.round(min*100))/100;
		return min;
	}
	/**
	 * 导出所有数据
	 * 
	 * @param baseModel
	 * @param mno
	 * @param dno
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Mas> exportAllMas(BaseModel baseModel, String mno, String dno) {
		// 多条件查询
		String hql = "from Mas as mas where "
				+ "mas.assessingneedtarget.appraisalsystem.indicatorId like :indname "// 到指标基本表里找到指标编号
				+ "and mas.assessingneedtarget.assessingproject.masprojectName like :mpname";// 到评估项目表里找到评估项目名称
		Map mapParam = new HashMap();
		// 指标名称
		mapParam.put("indname", "%" + baseModel.getId() + "%");
		// 开启项目名称
		mapParam.put("mpname", "%" + baseModel.getName() + "%");
		// 专业
		if (baseModel.getMajorId() != null
				&& !"".equals(baseModel.getMajorId())
				&& !"%".equals(baseModel.getMajorId())) {
			hql += " and mas.major.mno='" + baseModel.getMajorId() + "'";
		}
		// 学院
		if (baseModel.getDepartmentId() != null
				&& !"".endsWith(baseModel.getDepartmentId())) {

			hql += " and mas.major.department.dno='"
					+ baseModel.getDepartmentId() + "'";
		}
		hql = hql + " order by mas.assessingScore desc";

		List<Mas> list = (List<Mas>) QueryUtilDaoImpl.executeQuery(hql, null,
				mapParam);
		
		System.out.println(hql);
		System.out.println(list.size());
		return list;

	}

}
