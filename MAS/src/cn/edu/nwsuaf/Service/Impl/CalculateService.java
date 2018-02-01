package cn.edu.nwsuaf.Service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.bean.Majorclass;
import cn.edu.nwsuaf.bean.Mas;
import cn.edu.nwsuaf.bean.Score;
import cn.edu.nwsuaf.bean.Studentculturesummary;
import cn.edu.nwsuaf.bean.Teacherinfosummary;
import cn.edu.nwsuaf.bean.Teacherresearchsummary;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.Function;
import cn.edu.nwsuaf.util.QueryUtil;
import cn.edu.nwsuaf.view.PracticecourseView;
import cn.edu.nwsuaf.view.ScoreView;
import cn.edu.nwsuaf.view.StudentculturesummaryView;
import cn.edu.nwsuaf.view.TeacherinfolastView;
import cn.edu.nwsuaf.view.TeacherresearchsummaryView;

public class CalculateService extends BaseServiceImpl<PracticecourseView> {
	
	//2016-1-12 为了评估计算需要对统计的信息做预处理
	//专业教师信息的处理,获得最新的教师统计信息
	@SuppressWarnings("unchecked")
	public List<TeacherinfolastView> preTeachInfoData(){
		String  hql="FROM TeacherinfolastView";
		List<TeacherinfolastView> list = null;
		list = (List<TeacherinfolastView>) QueryUtilDaoImpl.executeQuery(hql,
				null);
		/*System.out.println("teainfolist-->"+list.size());
		System.out.println(list.toString());*/
		return list;
	}
	//教师科研信息的处理，统计系统中记录的信息，一般是求和
	@SuppressWarnings("unchecked")
	public List<TeacherresearchsummaryView> preTeachResearData(){
		String hql="FROM TeacherresearchsummaryView";
		List<TeacherresearchsummaryView> list = null;
		list = (List<TeacherresearchsummaryView>) QueryUtilDaoImpl.executeQuery(hql,
				null);
		/*System.out.println("teacrealist-->"+list.size());
		System.out.println(list.toString());*/
		return list;
	}
	//学生培养情况预处理，学生人数，志愿率，就业率，进行平均化处理，其他信息进行求和
	@SuppressWarnings("unchecked")
	public List<StudentculturesummaryView> preStudnetCulData(){
		String hql="FROM StudentculturesummaryView";
		List<StudentculturesummaryView> list = null;
		list = (List<StudentculturesummaryView>) QueryUtilDaoImpl.executeQuery(hql,
				null);
		/*System.out.println("stulist-->"+list.size());
		System.out.println(list.toString());*/
		return list;
	}
	//实践课程信息统计预处理，进行平均化处理
	
	public List<PracticecourseView> prePracticeCouseData(){
		
		List<PracticecourseView> list = this.findAll(PracticecourseView.class);
		
		/*System.out.println("praclist-->"+list.size());
		System.out.println(list.toString());
		*/
		return list;
	}
	                                                                                                                          
	//获取专业教师信息<专业号，师生比>信息
	@SuppressWarnings("unchecked")
	public List<Map> getAllTeachStudentRateMap(){
		String hql = "select new map(t.mno as mno , t.studentsTeachersRatio as studentsTeachersRatio) from TeacherinfolastView  t";
		List <Map> mapList =    (List<Map>) QueryUtilDaoImpl.executeQuery(hql,  null);
		for(Map map:mapList){		
			//String majorNoString=(String) map.get("mno");
			Float value=(Float) map.get("studentsTeachersRatio");
			map.put("studentsTeachersRatio", Double.parseDouble(String.valueOf(value)));
			//System.out.println(majorNoString+"————》"+value);		
	}
		return mapList;
	}
	
	//获取专业教师教授授课比例信息<专业号，教授授课比>信息t.professorTeachTime/t.teachTotalTime
	@SuppressWarnings("unchecked")
	public List<Map> getAllProfessorTeachCourseMap(){
		String hql = "select new map(t.mno as mno ,t.professorTeachTime*1.00/t.teachTotalTime as professorTeachTimeRatio) from PracticecourseView  t";
		List <Map> mapList =    (List<Map>) QueryUtilDaoImpl.executeQuery(hql,  null);
		for(Map map:mapList){		
		//String majorNoString=(String) map.get("mno");
		Double value=(Double) map.get("professorTeachTimeRatio");
		if(value==null){
			map.put("professorTeachTimeRatio", 0.00);
		}
		/*Double value1=(Double) map.get("professorTeachTimeRatio");
		System.out.println(majorNoString+"————》"+value1);	*/	
		}
		return mapList;
	}
	//获取专业教师副教授授课比例信息<专业号，教授授课比>信息
	@SuppressWarnings("unchecked")
	public List<Map> getAllInprofessorTeachCourseMap(){
		String hql = "select new map(t.mno as mno , t.inprofessorTteachTime*1.00/t.teachTotalTime as inprofessorTteachTimeRatio) from PracticecourseView  t";
		List <Map> mapList =    (List<Map>) QueryUtilDaoImpl.executeQuery(hql,  null);
		for(Map map:mapList){		
			//String majorNoString=(String) map.get("mno");
			Double value=(Double) map.get("inprofessorTteachTimeRatio");
			if(value==null){
				map.put("inprofessorTteachTimeRatio", 0.00);
			}
			//Double value1=(Double) map.get("inprofessorTteachTimeRatio");
			//System.out.println(majorNoString+"————》"+value1);		
			}
		return mapList;
	}
	//获取博士信息<专业号，博士教师人数比>
	@SuppressWarnings("unchecked")
	public List<Map> getAllDoctorNumberMap(){
		
		String hql="select new map(t.mno as mno,t.doctorNumber*1.00/t.facultyNumber as doctorTeacherRate) from TeacherinfolastView t";
		List <Map> mapList= (List<Map>) QueryUtilDaoImpl.executeQuery(hql, null);
		for(Map map:mapList){
			Double value=(Double) map.get("doctorTeacherRate");
			if(value==null){
				map.put("doctorTeacherRate", 0.00);
			}
		}
		return mapList;
	}
	//获取专业教师行业经历比例信息<专业号，比>信息
	@SuppressWarnings("unchecked")
	public List<Map> getAllindustryExperienceNumberMap(){
		String hql = "select new map(t.mno as mno , t.industryExperienceNumber*1.00/t.professionaTteacherNumbers as industryExperienceNumberRatio) from TeacherinfolastView  t";
		List <Map> mapList =    (List<Map>) QueryUtilDaoImpl.executeQuery(hql,  null);
		for(Map map:mapList){		
			//String majorNoString=(String) map.get("mno");
			Double value=(Double) map.get("industryExperienceNumberRatio");
			if(value==null){
				map.put("industryExperienceNumberRatio", 0.00);
			}
			//Double value1=(Double) map.get("industryExperienceNumberRatio");
			//System.out.println(majorNoString+"————》"+value1);		
			}
		return mapList;
	}
	//获取专业教师中青年教师比例信息<专业号，比>信息
	@SuppressWarnings("unchecked")
	public List<Map> getAllyoungTeacherNumberMap(){
		String hql = "select new map(t.mno as mno , t.youngTeacherNumber*1.00/t.professionaTteacherNumbers as youngTeacherNumberRatio) from TeacherinfolastView  t";
		List <Map> mapList =    (List<Map>) QueryUtilDaoImpl.executeQuery(hql,  null);
		for(Map map:mapList){		
			//String majorNoString=(String) map.get("mno");
			Double value=(Double) map.get("youngTeacherNumberRatio");
			if(value==null){
				map.put("youngTeacherNumberRatio", 0.00);
			}
			//Double value1=(Double) map.get("youngTeacherNumberRatio");
			//System.out.println(majorNoString+"————》"+value1);		
			}
		return mapList;
	}
	//获取专业教师中青年教师培训比例信息<专业号，比>信息
	@SuppressWarnings("unchecked")
	public List<Map> getAlltrainTeacherNumberMap(){
		String hql = "select new map(t.mno as mno , t.trainTeacherNumber*1.00/t.professionaTteacherNumbers as trainTeacherNumberRatio) from TeacherinfolastView  t";
		List <Map> mapList =    (List<Map>) QueryUtilDaoImpl.executeQuery(hql,  null);
		for(Map map:mapList){		
			//String majorNoString=(String) map.get("mno");
			Double value=(Double) map.get("trainTeacherNumberRatio");
			if(value==null){
				map.put("trainTeacherNumberRatio", 0.00);
			}
			//Double value1=(Double) map.get("trainTeacherNumberRatio");
			//System.out.println(majorNoString+"————》"+value1);		
			}
		return mapList;
	}
	
	//获取专业课程开出率比例信息<专业号，比>信息
	@SuppressWarnings("unchecked")
	public List<Map> getAllopenCourseTotaoNumMap(){
		String hql = "select new map(t.mno as mno , t.openCourseTotaoNum*1.00/t.courseTotaoNum as openCourseTotaoNumRatio) from PracticecourseView  t";
		List <Map> mapList =    (List<Map>) QueryUtilDaoImpl.executeQuery(hql,  null);
		for(Map map:mapList){		
			//String majorNoString=(String) map.get("mno");
			Double value=(Double) map.get("openCourseTotaoNumRatio");
			if(value==null){
				map.put("openCourseTotaoNumRatio", 0.00);
			}
			//Double value1=(Double) map.get("openCourseTotaoNumRatio");
			//System.out.println(majorNoString+"————》"+value1);		
		}
		return mapList;
	}
	//获取优质专业课程率比例信息<专业号，比>信息
	@SuppressWarnings("unchecked")
	public List<Map> getAllgoodCourseTotaoNumMap(){
		String hql = "select new map(t.mno as mno , t.goodCourseTotaoNum*1.00/t.courseTotaoNum as goodCourseTotaoNumRatio) from PracticecourseView  t";
		List <Map> mapList =    (List<Map>) QueryUtilDaoImpl.executeQuery(hql,  null);
		for(Map map:mapList){		
			//String majorNoString=(String) map.get("mno");
			Double value=(Double) map.get("goodCourseTotaoNum");
			if(value==null){
				map.put("goodCourseTotaoNum", 0.00);
			}
			//Double value1=(Double) map.get("openCourseTotaoNumRatio");
			//System.out.println(majorNoString+"————》"+value1);		
		}
		return mapList;
	}
	//获取实习基地信息<专业号，资源数>信息
	@SuppressWarnings("unchecked")
	public List<Map> getAllpracticeBaseTotalNumMap(){
		String hql = "select new map(t.mno as mno , t.practiceBaseTotalNum*1.00 as practiceBaseTotalNumRatio) from PracticecourseView  t";
		List <Map> mapList =    (List<Map>) QueryUtilDaoImpl.executeQuery(hql,  null);
		for(Map map:mapList){		
			Double value=(Double) map.get("practiceBaseTotalNumRatio");
			if(value==null){
				map.put("practiceBaseTotalNumRatio", 0.00);
			}
		}
		return mapList;
	}
	
	//获取专业报考热门度比例信息<专业号，比>信息
	@SuppressWarnings("unchecked")
	public List<Map> getAllpopularityRateMap(){
		String hql = "select new map(t.mno as mno , t.popularityRate as popularityRate) from StudentculturesummaryView  t";
		
		List <Map> mapList =    (List<Map>) QueryUtilDaoImpl.executeQuery(hql,  null);
		for(Map map:mapList){		
			//String majorNoString=(String) map.get("mno");
			Double value=(Double) map.get("popularityRate");
			if(value==null){
				map.put("popularityRate", 0.00);
			}
			//Double value1=(Double) map.get("openCourseTotaoNumRatio");
			//System.out.println(majorNoString+"————》"+value1);		
		}
		return mapList;
	}
	//获取专业报考第一志愿率比例信息<专业号，比>信息
	@SuppressWarnings("unchecked")
	public List<Map> getAllfirstVolunteerRateMap(){
		String hql = "select new map(t.mno as mno , t.firstVolunteerRate as firstVolunteerRate) from StudentculturesummaryView  t";
		List <Map> mapList =    (List<Map>) QueryUtilDaoImpl.executeQuery(hql,  null);
		for(Map map:mapList){		
			//String majorNoString=(String) map.get("mno");
			Double value=(Double) map.get("firstVolunteerRate");
			if(value==null){
				map.put("firstVolunteerRate", 0.00);
			}
			//Double value1=(Double) map.get("openCourseTotaoNumRatio");
			//System.out.println(majorNoString+"————》"+value1);		
		}
		return mapList;
	}
	
	//获取专业初次就业率例信息<专业号，比>信息
	@SuppressWarnings("unchecked")
	public List<Map> getAllemploymentrateSumMap(){
		String hql = "select new map(t.mno as mno , t.initialemploymentrate*100.0+t.employmentrate*100.0 as employmentrateSum) from StudentculturesummaryView  t";
		List <Map> mapList =    (List<Map>) QueryUtilDaoImpl.executeQuery(hql,  null);
		for(Map map:mapList){		
			//String majorNoString=(String) map.get("mno");
			Double value=(Double) map.get("employmentrateSum");
			if(value==null){
				map.put("employmentrateSum", 0.00);
			}
			//Double value1=(Double) map.get("openCourseTotaoNumRatio");
			//System.out.println(majorNoString+"————》"+value1);		
		}
		return mapList;
	}
	//获取专业初次就业率例信息<专业号，比>信息
	@SuppressWarnings("unchecked")
	public List<Map> getAllinitialemploymentrateMap(){
		String hql = "select new map(t.mno as mno , t.initialemploymentrate as initialemploymentrate) from StudentculturesummaryView  t";
		List <Map> mapList =    (List<Map>) QueryUtilDaoImpl.executeQuery(hql,  null);
		for(Map map:mapList){		
			//String majorNoString=(String) map.get("mno");
			Double value=(Double) map.get("initialemploymentrate");
			if(value==null){
				map.put("initialemploymentrate", 0.00);
			}
			//Double value1=(Double) map.get("openCourseTotaoNumRatio");
			//System.out.println(majorNoString+"————》"+value1);		
		}
		return mapList;
	}
	//获取专业三年就业率例信息<专业号，比>信息
	@SuppressWarnings("unchecked")
	public List<Map> getAllemploymentrateMap(){
		String hql = "select new map(t.mno as mno , t.employmentrate as employmentrate) from StudentculturesummaryView  t";
		List <Map> mapList =    (List<Map>) QueryUtilDaoImpl.executeQuery(hql,  null);
		for(Map map:mapList){		
			//String majorNoString=(String) map.get("mno");
			Double value=(Double) map.get("employmentrate");
			if(value==null){
				map.put("employmentrate", 0.00);
			}
			//Double value1=(Double) map.get("openCourseTotaoNumRatio");
			//System.out.println(majorNoString+"————》"+value1);		
		}
		return mapList;
	}
	//获取专业教师科研论文加分例信息<专业号，比>信息
	@SuppressWarnings("unchecked")
	public List<Map> getAllassessingScoreMap(String indicatorID){
		String hql = "select new map(t.major.mno as mno , t.assessingScore as assessingScore) from Mas t where t.assessingneedtarget.appraisalsystem.indicatorId='"+indicatorID+"'";
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
	// 获取专业质量标准及课程质量标准的完成情况<专业号，比率=完成数/总数>信息
	@SuppressWarnings("unchecked")
	public List<Map> getAllqualitystandardNumMap() {
		String hql = "select new map(t.major.mno as mno , t.completeCount*1.00/t.allCount as qualitystandardNumRatio) from Qualitystandard  t";
		List<Map> mapList = (List<Map>) QueryUtilDaoImpl
				.executeQuery(hql, null);
		for (Map map : mapList) {
			// String majorNoString=(String) map.get("mno");
			Double value = (Double) map.get("qualitystandardNumRatio");
			if (value == null) {
				map.put("qualitystandardNumRatio", 0.00);
			}
			// Double value1=(Double) map.get("openCourseTotaoNumRatio");
			// System.out.println(majorNoString+"————》"+value1);
		}
		return mapList;
	}

	// 获取学生参与创新创业训练项目情况<专业号，比率=参与人数数/总学生人数>信息
	@SuppressWarnings("unchecked")
	public List<Map> getAllstudentInnovationNumMap() {
		String hql = "select new map(t.mno as mno , (t.studentInnovationNumber11+t.studentInnovationNumber12+t.studentInnovationNumber13)*1.00/t.studentNumber as studentInnovationNumRatio) from StudentculturesummaryView  t";
		List<Map> mapList = (List<Map>) QueryUtilDaoImpl
				.executeQuery(hql, null);
		for (Map map : mapList) {
			String majorNoString = (String) map.get("mno");
			Double value = (Double) map.get("studentInnovationNumRatio");
			if (value == null) {
				map.put("studentInnovationNumRatio", 0.00);
			}
			Double value1 = (Double) map.get("studentInnovationNumRatio");
			//System.out.println(majorNoString + "————》" + value1);
		}
		return mapList;
	}
	//F74获取项目主持学生人次数与本专业在即学生总数比值<专业号，比率=学生科创主持项目数/专业在籍学生人数>
	public List<Map> getAllstudentpersisProjectRate(){
		String hql="select new map(p.mno as mno,p.studentPersistProjectNum*1.00/t.stuNumber as studentPersisProjectRate) from PracticecourseView as p,TeacherinfolastView as t where p.mno=t.mno";
		List<Map> mapList=(List<Map>)QueryUtilDaoImpl.executeQuery(hql, null);
		for(Map map:mapList){
			String majorNoString=(String)map.get("mno");
			Double value=(Double)map.get("studentPersisProjectRate");
			if(value==null){
				map.put("studentPersisProjectRate", 0.00);
			}
//			Double value1 = (Double) map.get("studentPersisProjectRate");
//			System.out.println(majorNoString + "————》" + value1);
		}
		return mapList;
	}
	//F75-1学生获得国家级竞赛奖励，学生为第一获奖人
	public List<Map> getAllRaceNumber1(){
		String hql="select new map(t.mno as mno,t.raceNumber1*1.00 as raceNumber1) from StudentculturesummaryView t";
		List<Map> mapList=(List<Map>)QueryUtilDaoImpl.executeQuery(hql, null);
		for(Map map:mapList){
			String majorNoString=(String)map.get("mno");
			Double value=(Double)map.get("raceNumber1");
			if(value==null){
				map.put("raceNumber1", 0.00);
			}
			/*Double value1=(Double)map.get("raceNumber1");
			System.out.println(majorNoString + "————》" + value1);*/
		}
		return mapList;
	}
	//F75-2学生获得省级竞赛奖励，学生为第一获奖人
	public List<Map> getAllRaceNumber2(){
		String hql="select new map(t.mno as mno,t.raceNumber2*1.00 as raceNumber2) from StudentculturesummaryView t";
		List<Map> mapList=(List<Map>)QueryUtilDaoImpl.executeQuery(hql, null);
		for(Map map:mapList){
			String majorNoString=(String)map.get("mno");
			Double value=(Double)map.get("raceNumber2");
			if(value==null){
				map.put("raceNumber2", 0.00);
			}
			/*Double value1=(Double)map.get("raceNumber2");
			System.out.println(majorNoString + "————》" + value1);*/
		}
		return mapList;
	}
	//F75-3学生获得校级竞赛奖励，学生为第一获奖人
	public List<Map> getAllRaceNumber3(){
		String hql="select new map(t.mno as mno,t.raceNumber3*1.00 as raceNumber3) from StudentculturesummaryView t";
		List<Map> mapList=(List<Map>)QueryUtilDaoImpl.executeQuery(hql, null);
		for(Map map:mapList){
			String majorNoString=(String)map.get("mno");
			Double value=(Double)map.get("raceNumber3");
			if(value==null){
				map.put("raceNumber3", 0.00);
			}
			/*Double value1=(Double)map.get("raceNumber3");
			System.out.println(majorNoString + "————》" + value1);*/
		}
		return mapList;
	}
	//F76学生获专业数量，学生为第一获奖人
	public List<Map> getAllPatentNumber(){
		String hql="select new map(t.mno as mno,t.patentNumber*1.00 as patentNumber) from StudentculturesummaryView t";
		List<Map> mapList=(List<Map>)QueryUtilDaoImpl.executeQuery(hql, null);
		for(Map map:mapList){
			String majorNoString=(String)map.get("mno");
			Double value=(Double)map.get("patentNumber");
			if(value==null){
				map.put("patentNumber", 0.00);
			}
			/*Double value1=(Double)map.get("patentNumber");
			System.out.println(majorNoString + "————》" + value1);*/
		}
		return mapList;
	}
	//F77学生发表学术论文数
	public List<Map> getAllResearchPaperNumber(){
		String hql="select new map(t.mno as mno,t.researchPaperNumber*1.00 as researchPaperNumber) from StudentculturesummaryView t";
		List<Map> mapList=(List<Map>)QueryUtilDaoImpl.executeQuery(hql, null);
		for(Map map:mapList){
			String majorNoString=(String)map.get("mno");
			Double value=(Double)map.get("researchPaperNumber");
			if(value==null){
				map.put("researchPaperNumber", 0.00);
			}
			/*Double value1=(Double)map.get("researchPaperNumber");
			System.out.println(majorNoString + "————》" + value1);*/
		}
		return mapList;
	}
	// 获取学生国内外交流情况<专业号，比率=参与人数数/总学生人数>信息
	@SuppressWarnings("unchecked")
	public List<Map> getAllstudentCommunicationsituNumMap(double F1, double F2) {
		String hql = "select new map(t.mno as mno , t.exchangepeople as exchangepeople,t.studentNumber as studentNumber,t.exchangeprojects as exchangeprojects) from StudentculturesummaryView  t";
		List<Map> mapList = (List<Map>) QueryUtilDaoImpl
				.executeQuery(hql, null);
		for (Map map : mapList) {	
			if((Integer)map.get("studentNumber")!=0){
				map.put("exchangeRatio", Function.CalculateCommunication((Integer)map.get("exchangeprojects"),(Integer)map.get("exchangepeople"),(Integer)map.get("studentNumber"),F1,F2));
			}else{
				map.put("exchangeRatio",0.00);
			}
			Double value = (Double) map.get("exchangeRatio");
			if (value == null) {
				map.put("exchangeRatio", 0.00);
			}
			//String majorNoString = (String) map.get("mno");	
			//Double value1 = (Double) map.get("exchangepeopleRatio");
			//System.out.println(majorNoString + "————》" + value1);
		}
		return mapList;
	}
	/************结果存在于实体类中*************/
	//首先获取所有一级指标的得分值
	@SuppressWarnings("unchecked")
	public List<Score>findAllScore(){
		List<Score>scoreList=new ArrayList<Score>();
		String hql="from Mas a where a.assessingneedtarget.appraisalsystem.indNameExp='一级指标'";
		List<Mas>list = (List<Mas>) QueryUtilDaoImpl.executeQuery(hql, null);
		Iterator<Mas>masiIterator=list.iterator();
		while(masiIterator.hasNext()){
			Score score=new Score();
			Mas mas=masiIterator.next();
			score.setMasCode(mas.getMasCode());
			score.setMasprojectName(mas.getAssessingneedtarget().getAssessingproject().getMasprojectName());
			score.setMno(mas.getMajor().getMno());
			score.setMname(mas.getMajor().getMname());
			score.setDno(mas.getMajor().getDepartment().getDno());
			score.setDname(mas.getMajor().getDepartment().getDname());
			if(mas.getAssessingneedtarget().getAppraisalsystem().getIndNameExp().equals("1.专业设置")){
				score.setFirstTarget(mas.getAssessingScore());
			}
			if(mas.getAssessingneedtarget().getAppraisalsystem().getIndNameExp().equals("2.培养模式")){
				score.setSecondTarget(mas.getAssessingScore());
			}
			if(mas.getAssessingneedtarget().getAppraisalsystem().getIndNameExp().equals("3.师资队伍")){
				score.setThirdTarget(mas.getAssessingScore());
			}
			if(mas.getAssessingneedtarget().getAppraisalsystem().getIndNameExp().equals("4.教学资源")){
				score.setFouthTarget(mas.getAssessingScore());
			}
			if(mas.getAssessingneedtarget().getAppraisalsystem().getIndNameExp().equals("5.培养过程")){
				score.setFifthTarget(mas.getAssessingScore());
			}
			if(mas.getAssessingneedtarget().getAppraisalsystem().getIndNameExp().equals("6.教学质量保障")){
				score.setSixthTarget(mas.getAssessingScore());
			}
			if(mas.getAssessingneedtarget().getAppraisalsystem().getIndNameExp().equals("7.学生发展")){
				score.setSeventhTarget(mas.getAssessingScore());
			}
			if(mas.getAssessingneedtarget().getAppraisalsystem().getIndNameExp().equals("8.专业特色")){
				score.setEightTarget(mas.getAssessingScore());
			}
			scoreList.add(score);
		}
		
		return scoreList;
	}
	
	/**************************************/
	//这是最终结果存在于视图的测试
	//最终结果的测试
	@SuppressWarnings("unchecked")
	public List<ScoreView> findallScoreViewList(int page, int rows,String mno,String dno) {
		String hql = "";
		List<ScoreView> list = null;
		if(!mno.equals("000000")){
			hql="from ScoreView as score where score.mno=?";
			String param[]={mno};
			list = (List<ScoreView>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from ScoreView as s where s.dno=?";
			String param[]={dno};
			list = (List<ScoreView>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from ScoreView";
			
			list = (List<ScoreView>) QueryUtilDaoImpl.executeQueryByPage(hql, null, page, rows);
			
		}
		return list;
	}
	// 多条件查询
	@SuppressWarnings("unchecked") //未完
	public List<ScoreView> findScoreViewList(BaseModel basemodel,
			int page, int rows) {

		String hql = "from ScoreView as score where "
		//	+ "score.indicatorName like :indname "
			+ "score.masprojectName like :mpname ";		
		Map mapParam = new HashMap();
		// 指标名称
		//mapParam.put("indname", "%" + basemodel.getId() + "%");
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
		System.out.println("结果查询："+hql);
		List<ScoreView> list = (List<ScoreView>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")//未完
	public int countFindMas(BaseModel basemodel) {
		int count;
		String hql = "select count(*)  from ScoreView as score where "
			//	+ "score.indicatorName like :indname "
				+ "score.masprojectName like :mpname";
		Map mapParam = new HashMap();
		// 指标名称
		//mapParam.put("indname", "%" + basemodel.getId() + "%");
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
			hql="select count(*) from ScoreView as s where  s.mno=?";
			String param[]={mno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="select count(*)from ScoreView as s where s.dno=?";
			String param[]={dno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			
		}else{
			hql="select count(*) from ScoreView";
			
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
			
		}
		return count;

	}
	/*************************** 2016-11-25——start****************************/
	/**
	 * 4.4.2 近三年新增的教学实验仪器设备（含软件）生均值
	 * @return
	 */
	public List<Map> getTraininguseinginformation(){
		String hql = "select new map(t.major.mno as mno , avg(t.laboratorySatisfactionRate)*100 as rate) from Traininguseinginformation as t where t.year>=(select year(masprojectOpenDate)-2 from Assessingproject where tag='1') group by t.major.mno";
		List<Map> mapList=(List<Map>)QueryUtilDaoImpl.executeQuery(hql, null);
		for(Map map:mapList){
			String majorNoString=(String)map.get("mno");
			Double value=(Double)map.get("ratet");
			if(value==null){
				map.put("rate", 0.00);
			}
		}
		return mapList;
	}
	/**
	 * 5.2.3 统计实验教学内容与实验室开放情况
	 */
	public List<Map> getTrainingvenueuse(){
		String hql = "select new map(t.major.mno as mno , sum(t.thHcount) as thHCount) from Trainingvenueuse as t group by t.major.mno";
		List<Map> mapList=(List<Map>)QueryUtilDaoImpl.executeQuery(hql, null);
		for(Map map:mapList){
			String majorNoString=(String)map.get("mno");
			Number value=(Number)map.get("thHCount");
			double v = value.doubleValue();
			if(value==null){
				map.put("thHCount", 0.00);
			}else{
				map.put("thHCount", v);
			}
		}
		return mapList;
	}
/*************************** 2016-11-25——end****************************/
	// 获取实践经费情况<专业号，比率=教学总经费/学生人数>信息
	@SuppressWarnings("unchecked")
	public List<Map> getAllstudentTrainNumMap() {
		String hql = "select new map (p.mno as mno,p.totalTeachCost/s.studentNumber as totalTeachCostRatio) from PracticecourseView as p,StudentculturesummaryView as s where p.mno= s.mno";
		//String hql = "select new map(t.mno as mno , (t.studentNumber as studentNumber) from StudentculturesummaryView  t";
		List<Map> mapList = (List<Map>) QueryUtilDaoImpl.executeQuery(hql, null);
			for (Map map : mapList) {
				String majorNoString = (String) map.get("mno");				
				Double value = (Double) map.get("totalTeachCostRatio");
				if (value == null) {
				map.put("totalTeachCostRatio", 0.00);
			}
			Double value1 = (Double) map.get("totalTeachCostRatio");
			//System.out.println(majorNoString + "————》" + value1);
		}
		return mapList;
	}
	
	// 获取教学实验设备生均值情况信息
	@SuppressWarnings("unchecked")
	public List<Map> getAllstudentTuiNumMap() {
		String hql = "select new map (t.major.mno as mno,t.experimentalEquipmentMean*1.00 as equipmentMeanRatio) from Traininguseinginformation as t,StudentculturesummaryView as s where s.mno= t.major.mno";
		//String hql = "select new map(t.mno as mno , (t.studentNumber as studentNumber) from StudentculturesummaryView  t";
		List<Map> mapList = (List<Map>) QueryUtilDaoImpl.executeQuery(hql, null);
			for (Map map : mapList) {
				String majorNoString = (String) map.get("mno");				
				double value =  (Double)map.get("equipmentMeanRatio");
				if (value == 0) {
				map.put("equipmentMeanRatio", 0.00);
			}
			double value1 = (Double) map.get("equipmentMeanRatio");
			//System.out.println(majorNoString + "————》" + value1);
		}
		return mapList;
	}

	/**
	 * (1)4.4.3 近三年校外实习实践基地数量
	 * (2)4.4.3 近三年校外实习实践基地实习学生人次数
	 * @param s 查詢（1）或（2）所对应的记录
	 * @return
	 */
	public List<Map> getTrainingUseingInfo(int s) {
		String hql = "";
		List<Map> mapList;
		if (s == 1) {
			hql = "select new map(t.major.mno as mno , sum(t.outBaseNumber) as outBaseNumber) from Traininguseinginformation as t where t.year>=(select year(masprojectOpenDate)-2 from Assessingproject where tag='1') group by t.major.mno order by t.major.mno";
			mapList = (List<Map>) QueryUtilDaoImpl.executeQuery(hql, null);
			for (Map map : mapList) {
				String majorNoString = (String) map.get("mno");
				Number value = (Number) map.get("outBaseNumber");
				if (value == null || value.doubleValue() == 0) {
					map.put("outBaseNumber", 0.00);
				} else {
					map.put("outBaseNumber", value.doubleValue());
				}
			}
		} else {
			hql = "select new map(t.major.mno as mno , avg(t.outBaseRate)*100 as outBaseRate) from Traininguseinginformation as t where t.year>=(select year(masprojectOpenDate)-2 from Assessingproject where tag='1') group by t.major.mno order by t.major.mno";
			mapList = (List<Map>) QueryUtilDaoImpl.executeQuery(hql, null);
			for (Map map : mapList) {
				String majorNoString = (String) map.get("mno");
				Number value = (Number) map.get("outBaseRate");
				if (value == null || value.doubleValue() == 0) {
					map.put("outBaseRate", 0.00);
				} else {
					map.put("outBaseRate", value.doubleValue());
				}
			}
		}
		return mapList;
	}
	public List<Majorclass> getAllMajorclass(){
		String hql = "from Majorclass";
		List<Majorclass> list = (List<Majorclass>)QueryUtilDaoImpl.executeQuery(hql, null);
		return list;
	}
	/*************************** 2016-11-26——end****************************/
}
