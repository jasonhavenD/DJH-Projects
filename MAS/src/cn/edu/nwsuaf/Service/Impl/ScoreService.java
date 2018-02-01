package cn.edu.nwsuaf.Service.Impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.bean.Assessingneedtarget;
import cn.edu.nwsuaf.bean.Assessingproject;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Majorclass;
import cn.edu.nwsuaf.bean.Mas;
import cn.edu.nwsuaf.bean.Score;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.view.ScoreView;



public class ScoreService extends BaseServiceImpl<Score> {
	
	private MasService masService;
	private AssessingneedtargetService assneedtargetService;
	/**
	 * 将所有指标得分汇总得出总分
	 */
	public void updatAllScore(){
		System.out.println("开始最终得分：");
		List<Score>scoreList=new ArrayList<Score>();
		
		String hqlF="from Mas a where a.assessingneedtarget.appraisalsystem.indNameExp='一级指标' and a.assessingneedtarget.appraisalsystem.indicatorName='1.专业设置' and a.assessingneedtarget.assessingproject.tag='1'";
		List<Mas> firstlist = (List<Mas>) QueryUtilDaoImpl.executeQuery(hqlF, null);
		
		//首先存入scoreList基本信息,获取专业学院信息，指标名称信息
		Iterator<Mas> masFIterator=firstlist.iterator();
		while(masFIterator.hasNext()){
			Mas mas=masFIterator.next();
			Score score=new Score();
			score.setMasCode(mas.getMasCode());
			score.setMasprojectName(mas.getAssessingneedtarget().getAssessingproject().getMasprojectName());
			score.setMno(mas.getMajor().getMno());
			score.setMname(mas.getMajor().getMname());
			score.setDno(mas.getMajor().getDepartment().getDno());
			score.setDname(mas.getMajor().getDepartment().getDname());
			scoreList.add(score);			
		}
		Iterator<Score> scoreIterator=scoreList.iterator();
		while(scoreIterator.hasNext()){
			Score score = scoreIterator.next();
			score.setFirstTarget(masService.findByTargetNoAndMno("001", score.getMno()).getAssessingScore());
			score.setSecondTarget(masService.findByTargetNoAndMno("003", score.getMno()).getAssessingScore());
			score.setThirdTarget(masService.findByTargetNoAndMno("006", score.getMno()).getAssessingScore());
			score.setFouthTarget(masService.findByTargetNoAndMno("012", score.getMno()).getAssessingScore());
			score.setFifthTarget(masService.findByTargetNoAndMno("018", score.getMno()).getAssessingScore());
			score.setSixthTarget(masService.findByTargetNoAndMno("022", score.getMno()).getAssessingScore());
			score.setSeventhTarget(masService.findByTargetNoAndMno("027", score.getMno()).getAssessingScore());
			score.setEightTarget(masService.findByTargetNoAndMno("031", score.getMno()).getAssessingScore());
		}
		List<Assessingneedtarget> assList = assneedtargetService.findallAssNeedTargetList(1);
		System.out.println(assList.size());
		if(assList!=null&&assList.size()!=0){			
		float w1 = assList.get(0).getIndicatorWeight();
		float w2 = assList.get(1).getIndicatorWeight();
		float w3 = assList.get(2).getIndicatorWeight();
		float w4 = assList.get(3).getIndicatorWeight();
		float w5 = assList.get(4).getIndicatorWeight();
		float w6 = assList.get(5).getIndicatorWeight();
		float w7 = assList.get(6).getIndicatorWeight();
		float w8 = assList.get(7).getIndicatorWeight();
		System.out.println(w1+" "+w2+" "+w3+" "+w4+" "+w5+" "+w6+" "+w7+" "+w8+" ");
		
		
		scoreIterator = scoreList.iterator();
		while(scoreIterator.hasNext()){
			Score score=scoreIterator.next();			
			Float totalScore=Float.valueOf(String.valueOf((score.getFirstTarget()*w1+score.getSecondTarget()*w2+score.getThirdTarget()*w3+score.getFouthTarget()*w4
			+score.getFifthTarget()*w5+score.getSixthTarget()*w6+score.getSeventhTarget()*w7+score.getEightTarget()*w8)));
			BigDecimal f=new BigDecimal(totalScore);
			float   value   =   f.setScale(2,   BigDecimal.ROUND_HALF_UP).floatValue();
			score.setTotalScore(value);
		}
		}
		//最终结果已经存入Score数据库
		this.batchUpdateResult(Score.class, scoreList);
		
		//调用存储过程更新排名
		String sqlCall1="call  calculate_ranking()";
		this.execute(sqlCall1);
		String sqlCall2="call  calculate_Ranking_ByClass()";
		this.execute(sqlCall2);
	}
	@SuppressWarnings("unchecked")
	public List<Score> findallScoreViewList(int page, int rows,String mno,String dno) {
		System.out.println("findallScoreViewList");
		String hql = "";
		List<Score> list = null;
		if(!mno.equals("000000")){
			hql="from Score as score where score.mno=? order by score.masprojectName DESC ,score.totalScore DESC";
			String param[]={mno};
			list = (List<Score>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Score as score where score.dno=? order by score.masprojectName DESC ,score.totalScore DESC";
			String param[]={dno};
			list = (List<Score>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Score order by masprojectName DESC ,totalScore DESC";
			
			list = (List<Score>) QueryUtilDaoImpl.executeQueryByPage(hql, null, page, rows);
			
		}
		return list;
	}
	// 多条件查询
	@SuppressWarnings("unchecked") //未完
	public List<Score> findScoreViewList(BaseModel basemodel,
			int page, int rows,String order) {

		String hql = "from Score as score where "
			+ "score.masprojectName like :mpname ";		
		Map mapParam = new HashMap();
		mapParam.put("mpname", "%" + basemodel.getName() + "%");
		// 专业
		System.out.println("name=="+basemodel.getName());
		System.out.println("majorid=="+basemodel.getMajorId());
		if (basemodel.getMajorId() != null
				&& !"".equals(basemodel.getMajorId())&& !"%".equals(basemodel.getMajorId())) {

			hql += " and score.mno='" + basemodel.getMajorId()
					+ "'";
		}
		// 学院
		System.out.println("departid=="+basemodel.getDepartmentId());
		if (basemodel.getDepartmentId() != null
				&& !"".endsWith(basemodel.getDepartmentId())) {

			hql += " and score.dno='"
					+ basemodel.getDepartmentId() + "'";
		}
		
		 hql += " order by score.masprojectName DESC ,";
		if(order==null||order.equals("")||order.equals("0")){
			hql +=" score.totalScore DESC";
		}
		else{
			int order1=Integer.parseInt(order);
		switch(order1){
		case 1:
			hql +=" score.firstTarget DESC";
			break;
		case 2:
			System.out.println(order);
			hql +=" score.secondTarget DESC";
			break;
		case 3:
			System.out.println(order);
			hql +=" score.thirdTarget DESC";
			break;
		case 4:
			System.out.println(order);
			hql +=" score.fouthTarget DESC";
			break;
		case 5:
			System.out.println(order);
			hql +=" score.fifthTarget DESC";
			break;
		case 6:
			System.out.println(order);
			hql +=" score.sixthTarget DESC";
			break;
		case 7:
			hql +=" score.seventhTarget DESC";
			break;
		case 8:
			hql +=" score.eightTarget DESC";
			break;
		case 9:
			hql +=" score.totalScore DESC";
			break;
		}
		}
		System.out.println("结果查询："+hql);
		List<Score> list = (List<Score>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		return list;

	}
	// 多条件查询--图形显示
	@SuppressWarnings("unchecked")
	public List<Score> findScoreCountList(List<Major> majorList,String masprojectName) {
		String hql = "from Score as s where 1 = 1";
		//开启评估项目名称
		if(masprojectName != null && !"".equals(masprojectName)){
			hql += "and s.masprojectName='"+masprojectName+"'";
		}
		List<Score> list = (List<Score>) QueryUtilDaoImpl.executeQuery(hql, null);
		return list;
	}
	// 查询结果条数
	@SuppressWarnings("unchecked")//未完
	public int countFindMas(BaseModel basemodel) {
		int count;
		String hql = "select count(*)  from Score as score where "
				+ "score.masprojectName like :mpname";
		Map mapParam = new HashMap();
		// 开启项目名称
		mapParam.put("mpname", "%" + basemodel.getName() + "%");
		// 专业
		if (basemodel.getMajorId() != null
				&& !"".equals(basemodel.getMajorId())&& !"%".equals(basemodel.getMajorId())) {

			hql += " and score.mno='" + basemodel.getMajorId()
					+ "'";
		}
		// 学院
		if (basemodel.getDepartmentId() != null
				&& !"".endsWith(basemodel.getDepartmentId())) {

			hql += " and score.dno='"
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
			hql="select count(*) from Score as s where  s.mno=?";
			String param[]={mno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="select count(*)from Score as s where s.dno=?";
			String param[]={dno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			
		}else{
			hql="select count(*) from Score";
			
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
			
		}
		return count;

	}
	// 导出
	@SuppressWarnings("unchecked")
	public List<Score> exportScoreList(BaseModel basemodel)
			throws UnsupportedEncodingException {

		String hql = "from Score as score where "
		// + "score.indicatorName like :indname "
				+ "score.masprojectName like :mpname ";
		Map mapParam = new HashMap();
		// 指标名称
		// mapParam.put("indname", "%" + basemodel.getId() + "%");
		// 开启项目名称
		mapParam.put("mpname", "%" + basemodel.getName() + "%");
		// 专业
		if (basemodel.getMajorId() != null
				&& !"".equals(basemodel.getMajorId())
				&& !"%".equals(basemodel.getMajorId())) {

			hql += " and score.mno='" + basemodel.getMajorId() + "'";
		}
		// 学院
		if (basemodel.getDepartmentId() != null
				&& !"".endsWith(basemodel.getDepartmentId())) {

			hql += " and score.dno='" + basemodel.getDepartmentId() + "'";
		}
		System.out.println(hql);
		List<Score> list = (List<Score>) QueryUtilDaoImpl.executeQuery(hql,
				null, mapParam);
		System.out.println(list.toString());
		return list;
	}

	/***********************************2016-11-30--start******************************/
		/**
		 * 计算当前列的平均值
		 * @param num
		 * @return
		 */
		public float calculateAverage(String name,String mc,String pName){
			String hql = "select avg(s."+name+") from Score as s where s.masprojectName='"+pName+"'";
			if(mc != null && !"".equals(mc)){
				hql +=" and s.mno in(select mts.major.mno from Majortoclass as mts where mts.majorclass.classcode='"
				+ mc+"')";
			}
			Object obj = QueryUtilDaoImpl.uniqueResult(hql, null);
			float avg = Float.valueOf(obj.toString());
			return avg;
		}
		/**
		 * 获取name列的最大值
		 * @param name 列名
		 * @return
		 */
		public float getMax(String name,String mc,String pName){
			String hql = "select max(s."+name+") from Score as s where s.masprojectName='"+pName+"'";
			if(mc != null && !"".equals(mc)){
				hql +="  and s.mno in(select mts.major.mno from Majortoclass as mts where mts.majorclass.classcode='"
					+ mc+"')";
			}
			Object obj = QueryUtilDaoImpl.uniqueResult(hql, null);
			float max = Float.valueOf(obj.toString());
			return max;
		}
		/**
		 * 获取name列的最小值
		 * @param name 列名
		 * @return
		 */
		public float getMin(String name,String mc,String pName){
			String hql = "select min(s."+name+") from Score as s where s.masprojectName='"+pName+"'";
			if(mc != null && !"".equals(mc)){
				hql +=" and s.mno in(select mts.major.mno from Majortoclass as mts where mts.majorclass.classcode='"
					+ mc+"')";
			}
			Object obj = QueryUtilDaoImpl.uniqueResult(hql, null);
			float min = Float.valueOf(obj.toString());
			return min;
		}
		/**
		 * 获取所有专业类别
		 * @return
		 */
		public List<Majorclass> findAllMajorClass(){
			String hql = "from Majorclass";
			List<Majorclass> list = (List<Majorclass>) QueryUtilDaoImpl.executeQuery(hql, null);
			return list;
		}
		/**
		 * 获取所有评估项目期信息
		 * @return
		 */
		public List<Assessingproject> findProject(){
			String hql = "from Assessingproject as a order by a.masprojectName desc";
			List<Assessingproject> list = (List<Assessingproject>) QueryUtilDaoImpl.executeQuery(hql, null);
			return list;
		}
		/**
		 * 初始化查询
		 * @param page
		 * @param rows
		 * @return
		 */
		public List<Score> findScoreListInit(int page,int rows){
			String hql = "from Score as s order by s.masprojectName DESC,s.totalScore DESC";
			List<Score> list = (List<Score>)QueryUtilDaoImpl.executeQueryByPage(hql, null, page, rows);
			return list;
		}
		/**
		 * 初始化查询总条数
		 * @return
		 */
		public int findCountScoreInit(){
			String hql = "select count(*) from Score ";
			int count = QueryUtilDaoImpl.getResultCountForHql(hql, null, null);
			return count;
		}
		/**
		 * 根据model进行多条件查询
		 * @return
		 */
		public List<Score> findScoreListByModel(BaseModel basemodel,int page, int row){
			String hql = "from Score as s where 1=1";
			//专业类别
			if(basemodel.getDepartmentId() != null &&!"".equals(basemodel.getDepartmentId())){
				hql += "and s.mno in(select mts.major.mno from Majortoclass as mts where mts.majorclass.classcode='"
				+ basemodel.getDepartmentId()+"')";
			}
			//所在专业
			if(basemodel.getMajorId()!=null && !"".equals(basemodel.getMajorId())){
				hql += " and s.mno = '" +basemodel.getMajorId()+ "'";
			};
			//开启评估项目名称
			if(basemodel.getName() != null && !"".equals(basemodel.getName())){
				hql += "and s.masprojectName='"+basemodel.getName()+"'";
			}
			hql += " order by s.masprojectName DESC ,";
			// 排序
			if (basemodel.getId() == null || basemodel.getId().equals("")) {
				hql += " s.totalScore DESC";
			} else {
				int order = Integer.parseInt(basemodel.getId());
				switch (order) {
				case 1:
					hql += " s.firstTarget DESC";
					break;
				case 2:
					hql += " s.secondTarget DESC";
					break;
				case 3:
					hql += " s.thirdTarget DESC";
					break;
				case 4:
					hql += " s.fouthTarget DESC";
					break;
				case 5:
					hql += " s.fifthTarget DESC";
					break;
				case 6:
					hql += " s.sixthTarget DESC";
					break;
				case 7:
					hql += " s.seventhTarget DESC";
					break;
				case 8:
					hql += " s.eightTarget DESC";
					break;
				case 9:
					hql += " s.totalScore DESC";
					break;
				}
			}
			List<Score> list = (List<Score>) QueryUtilDaoImpl.executeQueryByPage(hql, null, page, row);
			return list;
		}
		/**
		 * 多条件查询记录数
		 * @param basemodel
		 * @return
		 */
		public int findCountByModel(BaseModel basemodel){
			String hql = "select count(*) from Score as s where 1=1";
			//专业类别
			if(basemodel.getDepartmentId() != null &&!"".equals(basemodel.getDepartmentId())){
				hql += "and s.mno in(select mts.major.mno from Majortoclass as mts where mts.majorclass.classcode='"
				+ basemodel.getDepartmentId()+"')";
			}
			//所在专业
			if(basemodel.getMajorId()!=null && !"".equals(basemodel.getMajorId())){
				hql += " and s.mno = '" +basemodel.getMajorId()+ "'";
			};
			//开启评估项目名称
			if(basemodel.getName() != null && !"".equals(basemodel.getName())){
				hql += "and s.masprojectName='"+basemodel.getName()+"'";
			}
			int count = QueryUtilDaoImpl.getResultCountForHql(hql, null, null);
			return count;
			
		}
		/**
		 * 根据专业类别查找专业
		 * @param mc 专业类别
		 * @return
		 */
		public List<Major> findMajorByMC(String mc){
			String hql = "from Major as m where m.mno in (select mts.major.mno from Majortoclass as mts where mts.majorclass.classcode='"
				+ mc +"')";
			List<Major> list = (List<Major>)QueryUtilDaoImpl.executeQuery(hql, null);
			return list;
		}
		/**
		 * 根据条件查询得分记录
		 * @param majorclass 专业类别
		 * @param projectName 开启评估项目名称
		 * @return
		 */
		public List<Score> findGraphData(String majorclass,String projectName){
			String hql = "from Score as s where 1 = 1";
			//开启评估项目名称
			if(projectName != null && !"".equals(projectName)){
				hql += "and s.masprojectName='"+projectName+"'";
			}
			if(majorclass != null && !"".equals(majorclass)){
				hql += "and s.mno in(select mts.major.mno from Majortoclass as mts where mts.majorclass.classcode='"
					+ majorclass +"')";
			}
			List<Score> list = (List<Score>) QueryUtilDaoImpl.executeQuery(hql, null);
			return list;
		}
		/**
		 * 获取当前评估期mno专业的得分记录
		 * @param mno
		 * @return
		 */
		public Score findBYMno(String mno,String pName){
			String hql = "from Score as s where s.mno='"+mno+"' and s.masprojectName='"+pName+"'";
			//System.out.println(hql);
			Score score =  (Score)QueryUtilDaoImpl.uniqueResult(hql, null);
			return score;
		}
		/***********************************2016-11-30--end******************************/
		public void setMasService(MasService masService) {
			this.masService = masService;
		}
		public void setAssneedtargetService(
				AssessingneedtargetService assneedtargetService) {
			this.assneedtargetService = assneedtargetService;
		}
		
		
}