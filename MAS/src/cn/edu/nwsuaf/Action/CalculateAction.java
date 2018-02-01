package cn.edu.nwsuaf.Action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.Service.Impl.*;
import cn.edu.nwsuaf.bean.Effectofqualityeducation;
import cn.edu.nwsuaf.bean.Expertscore;
import cn.edu.nwsuaf.bean.FileinfoAttachment;
import cn.edu.nwsuaf.bean.Fulfillinginstance;

import cn.edu.nwsuaf.bean.Assessingproject;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Majorclass;
import cn.edu.nwsuaf.bean.Majortoclass;
import cn.edu.nwsuaf.bean.Mas;
import cn.edu.nwsuaf.bean.Practicecoursesummary;
import cn.edu.nwsuaf.bean.Score;
import cn.edu.nwsuaf.bean.Studentculturesummary;
import cn.edu.nwsuaf.bean.Teacherinfosummary;
import cn.edu.nwsuaf.bean.Teacherresearchsummary;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.Function;
import cn.edu.nwsuaf.util.QueryUtil;
import cn.edu.nwsuaf.view.PracticecourseView;
import cn.edu.nwsuaf.view.ScoreView;
import cn.edu.nwsuaf.view.StudentculturesummaryView;
import cn.edu.nwsuaf.view.TeacherinfolastView;
import cn.edu.nwsuaf.view.TeacherresearchsummaryView;

import com.opensymphony.xwork2.ActionSupport;

public class CalculateAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private BaseModel basemodel = new BaseModel();
	// 获取专业评估指标信息
	private MasService masService;// 专业评估指标表
	// 专业评估指标信息
	private List<Mas> masList;
	// 获取F值信息
	private FuntionargsService funtionargsService;

	// 获取统计数据
	private CalculateService calculateService;
	// 统计数据信息
	private List<Teacherinfosummary> teacherinfosummaryList;
	private List<Teacherresearchsummary> teacherresearchsummaryList;
	private List<Studentculturesummary> studentculturesummaryList;
	private List<Practicecoursesummary> practicecoursesummaryList;

	private List<PracticecourseView> practicecourseViewList;
	private List<TeacherinfolastView> teacherinfolastViewsList;
	private List<TeacherresearchsummaryView> teacherresearchsummaryViewsList;
	private List<StudentculturesummaryView> studentculturesummaryViewsList;
	
	

	// 获取定性数据专家打分
	private ExpertscoreService expertscoreService;
	private List<Expertscore> expertscoreList;
    private FileinfoattachmentService fileinfoattachmentService;
    private List<FileinfoAttachment> fileinfoAttachmentList;
    
    private EffectqualityeducationService effectqualityeducationService;
    private FulfillinginstanceService fulfillinginstanceService;
    private AssessingprojectService aprojectService;
    private DepartmentService departmentService;
	private MajorService majorService;
	
	private ScoreService scoreService;
	
    private List<ScoreView> ScoreViewList;//视图存储分数
    private List<Score> scoreList;//实体存储分数
    private List<Department> departmentList;// 学院
	private List<Major> majorList;// 专业
	private List<Assessingproject> aprojectList;
	
	private int rol;

	// 从前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private String errstring;
	private JSONArray jsonArray1;
	private JSONArray jsonArray2;
	private JSONArray jsonArray3;
	private JSONArray jsonArray4;
	private JSONArray jsonArray5;
	private JSONArray jsonArray6;
	private JSONArray jsonArray7;
	private JSONArray jsonArray8;
	private JSONArray jsonArray9;
	private String num;
	private String name;
	private String order;
	private String masprojectName;
	private JSONObject json=new JSONObject();
	private int A = 30;//定量数据量化最低值

	//评估结果查询  初始化信息，用于页面显示数据库中信息
	public String initSearch() {
		String mno="";
		String dno="";
		order="9";
		try{
			mno=QueryUtil.getUserMno().getMajor().getInMno();
    		dno=QueryUtil.getUserMno().getDepartment().getDno();
    		//最终结果存入数据库
    		//scoreService.updatAllScore();
			page=1;
			rows=10;
			basemodel=null;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findSummaryMajor(Major.class);
			aprojectList = aprojectService.findProjectDesc(); 
			//ScoreViewList=calculateService.findallScoreViewList(page, rows, mno, dno);
			scoreList=scoreService.findallScoreViewList(page, rows, mno, dno);
			//totalRows =  calculateService.count(mno, dno);
			totalRows=scoreService.count(mno, dno);
			//outPrint();
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	public String findScore() {
		System.out.println("findscore");
		String mno="";
		String dno="";

		try{
			mno=QueryUtil.getUserMno().getMajor().getInMno();
    		dno=QueryUtil.getUserMno().getDepartment().getDno();
        
			basemodel.setName(java.net.URLDecoder.decode(basemodel.getName(),"UTF-8"));
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			if(!mno.equals("000000")){
				basemodel.setMajorId(mno);
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				basemodel.setDepartmentId(dno);
			}
			//ScoreViewList =calculateService.findScoreViewList(basemodel, page, rows);
			//totalRows =calculateService.countFindMas(basemodel);
			System.out.println("order=="+order);
			scoreList=scoreService.findScoreViewList(basemodel, page, rows,order);
			totalRows=scoreService.countFindMas(basemodel);
			
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			//System.out.println(totalPage);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	//评估结果图形显示--初始化
	public String findScoreCountList(){
		
		try {
			aprojectList = aprojectService.findProjectDesc(); 
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	// 评估结果多条件查询--图形显示
	public String findScoreCount() {
		try {
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			//masprojectName = (java.net.URLDecoder.decode(masprojectName,"UTF-8"));
			if (masprojectName == null || "".equals(masprojectName)) {
					Assessingproject ap = aprojectService.findCurrentProject();
					masprojectName = ap.getMasprojectName();
			}
			System.out.println("name:"+masprojectName);
			scoreList = scoreService.findScoreCountList(majorList,
					masprojectName);
			// 1.不同專業的專業設置
			jsonArray1 = new JSONArray();
			for (int i = 0; i < scoreList.size(); i++) {
				JSONObject j1 = new JSONObject();
				j1.put("major", scoreList.get(i).getMname().toString());
				j1.put("score", scoreList.get(i).getFirstTarget());
				jsonArray1.add(j1);
			}

			// 2.不同專業的培養模式
			jsonArray2 = new JSONArray();
			for (int i = 0; i < scoreList.size(); i++) {
				JSONObject j1 = new JSONObject();
				j1.put("major", scoreList.get(i).getMname().toString());
				j1.put("score", scoreList.get(i).getSecondTarget());
				jsonArray2.add(j1);
			}
			// 3.不同專業的師資隊伍
			jsonArray3 = new JSONArray();
			for (int i = 0; i < scoreList.size() ; i++) {
				JSONObject j1 = new JSONObject();
				j1.put("major", scoreList.get(i).getMname().toString());
				j1.put("score", scoreList.get(i).getThirdTarget());
				jsonArray3.add(j1);
			}
			// 4.不同專業的教學資源
			jsonArray4 = new JSONArray();
			for (int i = 0; i < scoreList.size(); i++) {
				JSONObject j1 = new JSONObject();
				j1.put("major", scoreList.get(i).getMname().toString());
				j1.put("score", scoreList.get(i).getFouthTarget());
				jsonArray4.add(j1);
			}
			// 5.不同專業的培養過程
			jsonArray5 = new JSONArray();
			for (int i = 0; i < scoreList.size(); i++) {
				JSONObject j1 = new JSONObject();
				j1.put("major", scoreList.get(i).getMname().toString());
				j1.put("score", scoreList.get(i).getFifthTarget());
				jsonArray5.add(j1);
			}
			// 6.不同專業的教學質量保證
			jsonArray6 = new JSONArray();
			for (int i = 0; i < scoreList.size(); i++) {
				JSONObject j1 = new JSONObject();
				j1.put("major", scoreList.get(i).getMname().toString());
				j1.put("score", scoreList.get(i).getSixthTarget());
				jsonArray6.add(j1);
			}
			// 7.不同專業的學生發展
			jsonArray7 = new JSONArray();
			for (int i = 0; i < scoreList.size(); i++) {
				JSONObject j1 = new JSONObject();
				j1.put("major", scoreList.get(i).getMname().toString());
				j1.put("score", scoreList.get(i).getSeventhTarget());
				jsonArray7.add(j1);
			}
			// 8.不同專業的專業特色
			jsonArray8 = new JSONArray();
			for (int i = 0; i < scoreList.size(); i++) {
				JSONObject j1 = new JSONObject();
				j1.put("major", scoreList.get(i).getMname().toString());
				j1.put("score", scoreList.get(i).getEightTarget());
				jsonArray8.add(j1);
			}
			// 9.不同專業的得分總和
			jsonArray9 = new JSONArray();
			for (int i = 0; i < scoreList.size(); i++) {

				JSONObject j1 = new JSONObject();
				j1.put("major", scoreList.get(i).getMname().toString());
				j1.put("score", scoreList.get(i).getTotalScore());
				jsonArray9.add(j1);
			}
			System.out.println(scoreList.size());
			System.out.println(num);
			float average;
			float max;
			float min;
			int num1 = Integer.parseInt(num);
			switch (num1) {
			case 1:
				System.out.println(num1);
				average = scoreService.calculateAverage("firstTarget",null ,masprojectName);
				max = scoreService.getMax("firstTarget",null ,masprojectName);
				min = scoreService.getMin("firstTarget",null ,masprojectName);
				json.put("average", average);
				json.put("max", max);
				json.put("min", min);
				json.put("array1", jsonArray1);
				name = "专业设置";
				break;
			case 2:
				System.out.println(num1);
				average = scoreService.calculateAverage("secondTarget",null ,masprojectName);
				max = scoreService.getMax("secondTarget",null ,masprojectName);
				min = scoreService.getMin("secondTarget",null ,masprojectName);
				json.put("average", average);
				json.put("max", max);
				json.put("min", min);
				json.put("array1", jsonArray2);
				name = "培养模式";
				break;
			case 3:
				average = scoreService.calculateAverage("thirdTarget",null ,masprojectName);
				max = scoreService.getMax("thirdTarget",null ,masprojectName);
				min = scoreService.getMin("thirdTarget",null ,masprojectName);
				json.put("average", average);
				json.put("max", max);
				json.put("min", min);
				json.put("array1", jsonArray3);
				name = "师资队伍";
				break;
			case 4:
				average = scoreService.calculateAverage("fouthTarget",null ,masprojectName);
				max = scoreService.getMax("fouthTarget",null ,masprojectName);
				min = scoreService.getMin("fouthTarget",null ,masprojectName);
				json.put("average", average);
				json.put("max", max);
				json.put("min", min);
				json.put("array1", jsonArray4);
				name = "教学资源";
				break;
			case 5:
				average = scoreService.calculateAverage("fifthTarget",null ,masprojectName);
				max = scoreService.getMax("fifthTarget",null ,masprojectName);
				min = scoreService.getMin("fifthTarget",null ,masprojectName);
				json.put("average", average);
				json.put("max", max);
				json.put("min", min);
				json.put("array1", jsonArray5);
				name = "培养过程";
				break;
			case 6:
				average = scoreService.calculateAverage("sixthTarget",null ,masprojectName);
				max = scoreService.getMax("sixthTarget",null ,masprojectName);
				min = scoreService.getMin("sixthTarget",null ,masprojectName);
				json.put("average", average);
				json.put("max", max);
				json.put("min", min);
				json.put("array1", jsonArray6);
				name = "教学质量保证";
				break;
			case 7:
				average = scoreService.calculateAverage("seventhTarget",null ,masprojectName);
				max = scoreService.getMax("seventhTarget",null ,masprojectName);
				min = scoreService.getMin("seventhTarget",null ,masprojectName);
				json.put("average", average);
				json.put("max", max);
				json.put("min", min);
				json.put("array1", jsonArray7);
				name = "学生发展";
				break;
			case 8:
				average = scoreService.calculateAverage("eightTarget",null ,masprojectName);
				max = scoreService.getMax("eightTarget",null ,masprojectName);
				min = scoreService.getMin("eightTarget",null ,masprojectName);
				json.put("average", average);
				json.put("max", max);
				json.put("min", min);
				json.put("array1", jsonArray8);
				name = "专业特色";
				break;
			case 9:
				average = scoreService.calculateAverage("totalScore",null ,masprojectName);
				max = scoreService.getMax("totalScore",null ,masprojectName);
				min = scoreService.getMin("totalScore",null ,masprojectName);
				json.put("average", average);
				json.put("max", max);
				json.put("min", min);
				json.put("array1", jsonArray9);
				name = "总分";
				break;
			}

		} catch (Exception e) {
			setErrstring("登录超时！请安全退出再重新登录！");
			return "errorstring";
		}
		return "success";

	}
	public String calculateAllTarget() {
		String mno = QueryUtil.getUserMno().getMajor().getInMno();
		String dno = QueryUtil.getUserMno().getDepartment().getDno();
		// 一：首先获取专业评估指标信息
		masList = masService.findByTargetStatus(1);

		// 二：获取定量数据（获取评估数据统计的统计结果）
		// 获取处理后教师信息

		teacherinfolastViewsList = calculateService.preTeachInfoData();
		// 获取教学科研信息
		teacherresearchsummaryViewsList = calculateService.preTeachResearData();
		// 获取学生培养信息
		studentculturesummaryViewsList = calculateService.preStudnetCulData();
		// 获取实践课程信息
		practicecourseViewList = calculateService.prePracticeCouseData();
		
		// 三：获取定性数据
		try {
		//处理数据平均值
			// 四：获取F值对定量数据进行处理（获取对应F值的权重）
			double F601 = funtionargsService.findFuntionargsByName("F601").get(
					0).getFunValue();
			double F602 = funtionargsService.findFuntionargsByName("F602").get(
					0).getFunValue();
			double F611 = funtionargsService.findFuntionargsByName("F611").get(
					0).getFunValue();
			double F612 = funtionargsService.findFuntionargsByName("F612").get(
					0).getFunValue();
			double F613 = funtionargsService.findFuntionargsByName("F613").get(
					0).getFunValue();
			double F614 = funtionargsService.findFuntionargsByName("F614").get(
					0).getFunValue();
			double F621 = funtionargsService.findFuntionargsByName("F621").get(
					0).getFunValue();
			double F622 = funtionargsService.findFuntionargsByName("F622").get(
					0).getFunValue();
			//附件得分存入Mas
			calculateQualityTarget(masList);

			// F7指标项的处理，公式是
			calculateF7(masList, practicecourseViewList);

			calculateF10(masList);
			calculateF11(masList);
			calculateF15(masList);
			calculateF16(masList);
			
			calculateF17(masList);
			calculateF19(masList);
			calculateF20(masList);
			
			
			calculateF12(masList, teacherinfolastViewsList);
			calculateF13(masList, teacherinfolastViewsList);
			calculateF14(masList, teacherinfolastViewsList);
			calculateF121314Sum(masList, teacherinfolastViewsList);
			calculateF121314(masList);

			calculateF21(masList, teacherresearchsummaryViewsList);
			calculateF2223(masList, teacherresearchsummaryViewsList);
			calculateF242526(masList, teacherresearchsummaryViewsList);
			calculateF27(masList, teacherresearchsummaryViewsList);
			calculateF2829(masList, teacherresearchsummaryViewsList);
			calculateF303132(masList, teacherresearchsummaryViewsList);
			calculateF353637(masList, teacherresearchsummaryViewsList);
			calculateF383940(masList, teacherresearchsummaryViewsList);
			//calculateF41(masList, teacherresearchsummaryViewsList);
			
			calculateF43(masList);
			calculateF44(masList);
			calculateF46(masList);
			calculateF59(masList);
			calculateF60(masList, F601, F602);
			calculateF61(masList, F611, F612, F613, F614);
			calculateF62(masList, F621, F622);
			calculateF63(masList);
			
			calculateF69(masList);
			calculateF70(masList);
			calculateF71(masList);

			calculateF7172(masList);
			calculateF74(masList);
			calculateF75_1(masList);
			calculateF75_2(masList);
			calculateF75_3(masList);
			calculateF76(masList);
			calculateF77(masList);
			calculatePartSumOrStandrd(masList);//各个分项和加入总项（三级指标）
			calculateTeplate(masList, "60");
			calculateTeplate(masList, "61");
			calculateTeplate(masList, "1920");
			calculateTeplate(masList, "2223");
			calculateTeplate(masList, "242526");
			calculateTeplate(masList, "2829");
			calculateTeplate(masList, "303132");
			calculateTeplate(masList, "353637");
			calculateTeplate(masList, "383940");
			calculateTeplate(masList, "4950");
			calculateTeplate(masList, "7677");
			
			//calculateTargetType(masList);
			calculateTeplate(masList, "27");
			calculateF18();
			calculateF33();
			calculateF41();
			calculateF42();
			calculateF47();
			calculateF48();
			calculateF4950();
			calculateF51();
			calculateF52();
			calculateF58();
			calculateSecondLevelTarget();
			calculateFirstLevelTarget();
			scoreService.updatAllScore();
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";

		}
		return "success";
	}
	//定性数据得分
	public void calculateQualityTarget(List<Mas> masList){
		try {
			//获取附件表
			List<FileinfoAttachment> fiaList=fileinfoattachmentService.findCurrentFileinfoAttachment();
			System.out.println("filesize:"+fiaList.size());
			//获取打分表
			Iterator<Mas> masIterator = masList.iterator();
			
			System.out.println("更新定性数据信息-把附件得分加入Mas——————————————————————！");
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem().getType().equals("0")) {
					//进入定性指标
					Iterator<FileinfoAttachment>fileIterator=fiaList.iterator();
					while(fileIterator.hasNext()){
						FileinfoAttachment fileinfoAttachment=fileIterator.next();
						if(mas.getMasCode().equals(fileinfoAttachment.getMas().getMasCode())){
							if(fileinfoAttachment.getAsseisingValue()==null){
								mas.setAssessingScore((float)0.00);
							}else{
								mas.setAssessingScore(fileinfoAttachment.getAsseisingValue());
							}
							System.out.println("score:"+mas.getAssessingScore());
							masService.update(mas);
						}
					}
				}
			}
			System.out.println("更新定性数据完成！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 2.1.3培养方案的执行与调整情况
	 * 计划调整次数，如果没有统计到，置零
	 */
	public void calculateF7(List<Mas> masList,
			List<PracticecourseView> practicecourseViewList) {
		try {
			double F7 = funtionargsService.findFuntionargsByName("F7").get(0)
					.getFunValue();
			// F7指标项的处理，公式是
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("7")) {
					if(mas.getAssessingScore()==null){
						mas.setAssessingScore((float)0.0);
						masService.update(mas);
						//System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
					}else{
						// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
						Iterator<PracticecourseView> praIterator = practicecourseViewList
								.iterator();
						while (praIterator.hasNext()) {
							PracticecourseView practicecourseView = praIterator
									.next();
							// System.out.println(mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId());
							if (practicecourseView.getMno().equals(
									mas.getMajor().getMno())) {
								float F7Value;
								if (practicecourseView.getPlanChangeNumber() == null) {
									F7Value = (float) Function
											.CalculatePlanChangeNum(0, F7);
								} else {
									F7Value = (float) Function
											.CalculatePlanChangeNum(
													practicecourseView
															.getPlanChangeNumber(),
													F7);
								}
								// System.out.println("得分："+F7Value);
								mas.setAssessingScore(F7Value);
								masService.update(mas);
								//System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
							}
						}
					}
				}
			}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F7计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void calculateF10(List<Mas> masList) {
		// F10指标项师生比的处理,统计后百分量化
		// 首先获取量化前的指标数据
		List<Map> mapList = calculateService.getAllTeachStudentRateMap();
		
		List<Map> smapList = Function.Standard(mapList,
				"studentsTeachersRatio", A, 100, 0);
		/*System.out.println("量化后数据：——————————");
		for (Map map : smapList) {
			String majorNoString = (String) map.get("mno");
			Float value = (Float) map.get("studentsTeachersRatio");
			System.out.println(map.get("mno") + "————》" + value);

		}*/

		
		// System.out.println("mas.size" + masList.size());
		// System.out.println("practicecourseViewList.size" +
		// practicecourseViewList.size());
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("10")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("studentsTeachersRatio");
						BigDecimal   b   =   new   BigDecimal(value1);  
						Double   value   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.valueOf(String.valueOf(value)));
							masService.update(mas);
							//System.out.println(mas.getMajor().getMname()+ "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("更新F10计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// F11指标项博士教师人数比值的处理,统计后百分量化
	@SuppressWarnings("unchecked")
	public void calculateF11(List<Mas> masList) {

		// 首先获取量化前的指标数据
		List<Map> mapList = calculateService.getAllDoctorNumberMap();
		List<Map> smapList = Function.Standard(mapList, "doctorTeacherRate",
				A, 100, 0);
		System.out.println("量化后数据：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("11")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("doctorTeacherRate");
						BigDecimal b = new BigDecimal(value1);
						Double value = b.setScale(2, BigDecimal.ROUND_HALF_UP)
								.doubleValue();
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.valueOf(String
									.valueOf(value)));
							masService.update(mas);
							 //System.out.println(mas.getMajor().getMno()+
							 //"--->" + mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("更新F11计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void calculateF12(List<Mas> masList,
			List<TeacherinfolastView> teacherinfolastViewList) {
		//3.1.3国家级人才人数
		try {
			double F12 = funtionargsService.findFuntionargsByName("F12").get(0)
					.getFunValue();
			// F12指标项的处理，公式是
			Iterator<Mas> masIterator = masList.iterator();
			// System.out.println("mas.size" + masList.size());
			// System.out.println("practicecourseViewList.size" +
			// practicecourseViewList.size());
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("12")) {
					// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
					Iterator<TeacherinfolastView> praIterator = teacherinfolastViewList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherinfolastView teacherinfolastView = praIterator
								.next();
						// System.out.println(mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId());
						if (teacherinfolastView.getMno().equals(
								mas.getMajor().getMno())) {
							float F12Value;
							if (teacherinfolastView.getTalentnuber1() == null) {
								F12Value = (float) Function
										.CalculateTalentsPart(0, F12);
							} else {
								F12Value = (float) Function
										.CalculateTalentsPart(
												teacherinfolastView
														.getTalentnuber1(), F12);
							}
							// System.out.println("得分："+F7Value);
							mas.setAssessingScore(F12Value);
							masService.update(mas);
							// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
						}
					}
				}
			}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F12国家级人才计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block

		}
	}

	public void calculateF13(List<Mas> masList,
			List<TeacherinfolastView> teacherinfolastViewList) {
		//3.1.3省级人才人数
		try {
			double F13 = funtionargsService.findFuntionargsByName("F13").get(0)
					.getFunValue();
			// F13指标项的处理，公式是
			Iterator<Mas> masIterator = masList.iterator();
			// System.out.println("mas.size" + masList.size());
			// System.out.println("practicecourseViewList.size" +
			// practicecourseViewList.size());
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("13")) {
					// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
					Iterator<TeacherinfolastView> praIterator = teacherinfolastViewList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherinfolastView teacherinfolastView = praIterator
								.next();
						// System.out.println(mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId());
						if (teacherinfolastView.getMno().equals(
								mas.getMajor().getMno())) {
							float F13Value;
							if (teacherinfolastView.getTalentnuber2() == null) {
								F13Value = (float) Function
										.CalculateTalentsPart(0, F13);
							} else {
								F13Value = (float) Function
										.CalculateTalentsPart(
												teacherinfolastView
														.getTalentnuber2(), F13);
							}
							// System.out.println("得分："+F7Value);
							mas.setAssessingScore(F13Value);
							masService.update(mas);
							// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
						}
					}
				}
			}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F13省级人才计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block

		}
	}

	public void calculateF14(List<Mas> masList,
			List<TeacherinfolastView> teacherinfolastViewList) {
		//3.1.3校级人才人数
		try {
			double F14 = funtionargsService.findFuntionargsByName("F14").get(0)
					.getFunValue();
			// F7指标项的处理，公式是
			Iterator<Mas> masIterator = masList.iterator();
			// System.out.println("mas.size" + masList.size());
			// System.out.println("practicecourseViewList.size" +
			// practicecourseViewList.size());
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("14")) {
					// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
					Iterator<TeacherinfolastView> praIterator = teacherinfolastViewList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherinfolastView teacherinfolastView = praIterator
								.next();
						// System.out.println(mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId());
						if (teacherinfolastView.getMno().equals(
								mas.getMajor().getMno())) {
							float F14Value;
							if (teacherinfolastView.getTalentnuber3() == null) {
								F14Value = (float) Function
										.CalculateTalentsPart(0, F14);
							} else {
								F14Value = (float) Function
										.CalculateTalentsPart(
												teacherinfolastView
														.getTalentnuber3(), F14);
							}
							// System.out.println("得分："+F7Value);
							mas.setAssessingScore(F14Value);
							masService.update(mas);
							// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
						}
					}
				}
			}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F14校级人才计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block

		}
	}
	public void calculateF121314Sum(List<Mas> masList,
			List<TeacherinfolastView> teacherinfolastViewList) {
		//3.1.3高层次教师情况量化得分
		try {
			double F12 = funtionargsService.findFuntionargsByName("F12").get(0)
			.getFunValue();
			double F13 = funtionargsService.findFuntionargsByName("F13").get(0)
			.getFunValue();
			double F14 = funtionargsService.findFuntionargsByName("F14").get(0)
			.getFunValue();
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("121314")) {
					// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
					Iterator<TeacherinfolastView> praIterator = teacherinfolastViewList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherinfolastView teacherinfolastView = praIterator
								.next();
						// System.out.println(mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId());
						if (teacherinfolastView.getMno().equals(
								mas.getMajor().getMno())) {
							if(teacherinfolastView.getTalentnuber1()==null){
								teacherinfolastView.setTalentnuber1(0);
							}
							if(teacherinfolastView.getTalentnuber2()==null){
								teacherinfolastView.setTalentnuber1(0);
							}
							if(teacherinfolastView.getTalentnuber3()==null){
								teacherinfolastView.setTalentnuber1(0);
							}
							float F12Value= (float) Function.CalculateTalents(teacherinfolastView.getTalentnuber1(), teacherinfolastView.getTalentnuber2(), teacherinfolastView.getTalentnuber3(),
									F12, F13, F14);
							mas.setAssessingScore(F12Value);
							masService.update(mas);
						}
						}
					}
				}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F121314人才计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block

		}
	}
	//量化3.1.3指标信息
	@SuppressWarnings("unchecked")
	public void calculateF121314(List<Mas> masList) {
		
		List<Map> mapList = calculateService.getAllassessingScoreMap("121314");
		System.out.println(mapList.size());
		List<Map> sumapList = Function.Standard(mapList,"assessingScore", A, 100, 0);
		//System.out.println("量化后数据：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if(mas.getAssessingneedtarget().getAppraisalsystem()
							.getIndicatorId().equals("121314")){
					for (Map map : sumapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("assessingScore");
						BigDecimal f=new BigDecimal(value1);
						Double   value   =   f.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.parseFloat(String.valueOf(value)));
							masService.update(mas);
							//System.out.println("7172:_____"+mas.getMajor().getMno()+ "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("量化F121314信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//教授授课比
	@SuppressWarnings("unchecked")
	public void calculateF15(List<Mas> masList) {
		// F15指标项教授授课比的处理,统计后百分量化
		// 首先获取量化前的指标数据
		List<Map> mapList = calculateService.getAllProfessorTeachCourseMap();
		List<Map> smapList = Function.Standard(mapList,
				"professorTeachTimeRatio", A, 100, 0);
		//System.out.println("量化后数据：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("15")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value = (Double) map.get("professorTeachTimeRatio");
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.parseFloat(String.valueOf(value)));
							masService.update(mas);
							//System.out.println(mas.getMajor().getMname()+ "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("更新F15计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//高职授课比例
	@SuppressWarnings("unchecked")
	public void calculateF16(List<Mas> masList) {
		// F16指标项高职授课比的处理,统计后百分量化
		// 首先获取量化前的指标数据
		List<Map> mapList = calculateService.getAllInprofessorTeachCourseMap();
		List<Map> smapList = Function.Standard(mapList,
				"inprofessorTteachTimeRatio", A, 100, 0);
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("16")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value = (Double) map.get("inprofessorTteachTimeRatio");
						if (mas.getMajor().getMno().equals(majorNoString)) {
									mas.setAssessingScore(Float.parseFloat(String.valueOf(value)));
									masService.update(mas);
									//System.out.println(mas.getMajor().getMno()+ "--->" + mas.getAssessingScore());
							}
						}
					}
				}
			System.out.println("更新F16计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//行业经历教师比例
	@SuppressWarnings("unchecked")
	public void calculateF17(List<Mas> masList) {
		// F17指标项行业教师比的处理,统计后百分量化
		// 首先获取量化前的指标数据
		List<Map> mapList = calculateService.getAllindustryExperienceNumberMap();
		List<Map> smapList = Function.Standard(mapList,
				"industryExperienceNumberRatio", A, 100, 0);
		//System.out.println("量化后数据：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("17")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("industryExperienceNumberRatio");
						BigDecimal f=new BigDecimal(value1);
						Double   value   =   f.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.parseFloat(String.valueOf(value)));
							masService.update(mas);
							//System.out.println(mas.getMajor().getMno()+ "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("更新F17计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//中青年教师比例
	@SuppressWarnings("unchecked")
	public void calculateF19(List<Mas> masList) {
		
		// 首先获取量化前的指标数据
		List<Map> mapList = calculateService.getAllyoungTeacherNumberMap();
		List<Map> smapList = Function.Standard(mapList,
				"youngTeacherNumberRatio", A, 100, 0);
		//System.out.println("量化后数据：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("19")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("youngTeacherNumberRatio");
						BigDecimal f=new BigDecimal(value1);
						Double   value   =   f.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.parseFloat(String.valueOf(value)));
							masService.update(mas);
							//System.out.println(mas.getMajor().getMno()+ "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("更新F19计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//中青年教师参加培训比例
	@SuppressWarnings("unchecked")
	public void calculateF20(List<Mas> masList) {
		
		// 首先获取量化前的指标数据
		List<Map> mapList = calculateService.getAlltrainTeacherNumberMap();
		List<Map> smapList = Function.Standard(mapList,
				"trainTeacherNumberRatio", A, 100, 0);
		//System.out.println("量化后数据：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("20")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("trainTeacherNumberRatio");
						BigDecimal f=new BigDecimal(value1);
						Double   value   =   f.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.parseFloat(String.valueOf(value)));
							masService.update(mas);
							//System.out.println(mas.getMajor().getMno()+ "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("更新F20计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//由于统计专业最新数据是21条，结果得分只有21,统计表内无信息
	public void calculateF21(List<Mas> masList,
			List<TeacherresearchsummaryView> teacherresearchsummaryViewsList) {
		try {
			double F211 = funtionargsService.findFuntionargsByName("F211").get(
					0).getFunValue();
			double F212 = funtionargsService.findFuntionargsByName("F212").get(
					0).getFunValue();
			double F213 = funtionargsService.findFuntionargsByName("F213").get(
					0).getFunValue();
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("21")) {
					// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
					if (mas.getAssessingScore()==null){
						mas.setAssessingScore((float)0.0);
						masService.update(mas);
						 
					}else{
						Iterator<TeacherresearchsummaryView> praIterator = teacherresearchsummaryViewsList
						.iterator();
				while (praIterator.hasNext()) {
					TeacherresearchsummaryView teacherresearchsummaryView = praIterator
							.next();
					// System.out.println(mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId());
					if (teacherresearchsummaryView.getMno().equals(
							mas.getMajor().getMno())) {
						float F21Value;
						F21Value = (float) Function.CalculateTalents(
								teacherresearchsummaryView
										.getResearchPaperNumber1(),
								teacherresearchsummaryView
										.getResearchPaperNumber2(),
								teacherresearchsummaryView
										.getResearchPaperNumber3(), F211,
								F212, F213);
						// System.out.println("得分："+F7Value);
						mas.setAssessingScore(F21Value);
						masService.update(mas);
						// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
					}
				}
					}
					
				}
			}
			//量化所有科研论文得分
			List<Map> mapList = calculateService.getAllassessingScoreMap("21");
			List<Map> smapList = Function.Standard(mapList,
					"assessingScore", A, 100, 0);
			//System.out.println("量化后数据：——————————");
				// 最终结果列表
				Iterator<Mas> masIterator1 = masList.iterator();
				while (masIterator1.hasNext()) {
					Mas mas = masIterator1.next();
					if (mas.getAssessingneedtarget().getAppraisalsystem()
							.getIndicatorId().equals("21")) {
						for (Map map : smapList) {
							String majorNoString = (String) map.get("mno");
							Double value1 = (Double) map.get("assessingScore");
							BigDecimal f=new BigDecimal(value1);
							Double   value   =   f.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
							if (mas.getMajor().getMno().equals(majorNoString)) {
								mas.setAssessingScore(Float.parseFloat(String.valueOf(value)));
								masService.update(mas);
								//System.out.println(mas.getMajor().getMno()+ "--->" + mas.getAssessingScore());
							}
						}
					}
				}
			System.out.println("更新F21教师发表学术论文计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block

		}
	}
	//同22
	@SuppressWarnings("unchecked")
	public void calculateF2223(List<Mas> masList,
			List<TeacherresearchsummaryView> teacherresearchsummaryViewsList) {
		//3.2.2 近三年教师获得省级以上科研奖励量化得分
		try {
			// 国家级科研奖励参数信息
			double F221 = funtionargsService.findFuntionargsByName("F221").get(
					0).getFunValue();
			double F222 = funtionargsService.findFuntionargsByName("F222").get(
					0).getFunValue();
			double F223 = funtionargsService.findFuntionargsByName("F223").get(
					0).getFunValue();
			// 省级科研奖励参数信息
			double F231 = funtionargsService.findFuntionargsByName("F231").get(
					0).getFunValue();
			double F232 = funtionargsService.findFuntionargsByName("F232").get(
					0).getFunValue();
			double F233 = funtionargsService.findFuntionargsByName("F233").get(
					0).getFunValue();
			// 校级科研奖励参数信息
			double F241 = funtionargsService.findFuntionargsByName("F241").get(
					0).getFunValue();
			double F242 = funtionargsService.findFuntionargsByName("F242").get(
					0).getFunValue();
			double F243 = funtionargsService.findFuntionargsByName("F243").get(
					0).getFunValue();
			// 国家级获取排名加分参数
			double R221 = funtionargsService.findFuntionargsByName("R221").get(
					0).getFunValue();
			double R222 = funtionargsService.findFuntionargsByName("R222").get(
					0).getFunValue();
			double R223 = funtionargsService.findFuntionargsByName("R223").get(
					0).getFunValue();
			// 省级级获取排名加分参数
			double R231 = funtionargsService.findFuntionargsByName("R231").get(
					0).getFunValue();
			double R232 = funtionargsService.findFuntionargsByName("R232").get(
					0).getFunValue();
			double R233 = funtionargsService.findFuntionargsByName("R233").get(
					0).getFunValue();
			
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("22")) {
					Iterator<TeacherresearchsummaryView> praIterator = teacherresearchsummaryViewsList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherresearchsummaryView teacherresearchsummaryView = praIterator
								.next();
						// System.out.println(mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId());
						if (teacherresearchsummaryView.getMno().equals(
								mas.getMajor().getMno())) {
							float F22Value;
							F22Value = (float) Function.CalculateProjectContest(teacherresearchsummaryView.getResearchAwardNumber111(), teacherresearchsummaryView.getResearchAwardNumber211(), teacherresearchsummaryView.getResearchAwardNumber311(), 
									teacherresearchsummaryView.getResearchAwardNumber121(), teacherresearchsummaryView.getResearchAwardNumber221(), teacherresearchsummaryView.getResearchAwardNumber321(), 
									teacherresearchsummaryView.getResearchAwardNumber131(), teacherresearchsummaryView.getResearchAwardNumber231(), teacherresearchsummaryView.getResearchAwardNumber331(), 
									F221, F222, F223, R221, R222, R223);
							// System.out.println("得分："+F7Value);
							mas.setAssessingScore(F22Value);
							masService.update(mas);
							// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
						}
					}
				}
			}
			// masService.batchUpdateResult(Mas.class, masList);
			
			
				System.out.println("更新F22国家级科研奖励计算信息完成！！");
			// 更新F23
			Iterator<Mas> masIterator1 = masList.iterator();
			// System.out.println("mas.size" + masList.size());
			// System.out.println("practicecourseViewList.size" +
			// practicecourseViewList.size());
			while (masIterator1.hasNext()) {
				Mas mas = masIterator1.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("23")) {
					// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
					Iterator<TeacherresearchsummaryView> praIterator = teacherresearchsummaryViewsList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherresearchsummaryView teacherresearchsummaryView = praIterator
								.next();
						if (teacherresearchsummaryView.getMno().equals(
								mas.getMajor().getMno())) {
							float F23Value = (float) Function.CalculateProjectContest(teacherresearchsummaryView.getResearchAwardNumber112(), teacherresearchsummaryView.getResearchAwardNumber212(), teacherresearchsummaryView.getResearchAwardNumber312(), 
									teacherresearchsummaryView.getResearchAwardNumber122(), teacherresearchsummaryView.getResearchAwardNumber222(), teacherresearchsummaryView.getResearchAwardNumber322(), 
									teacherresearchsummaryView.getResearchAwardNumber132(), teacherresearchsummaryView.getResearchAwardNumber232(), teacherresearchsummaryView.getResearchAwardNumber332(), 
									F231, F232, F233, R231, R232, R233);
							// System.out.println("得分："+F7Value);
							mas.setAssessingScore(F23Value);
							masService.update(mas);
							// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("更新F23省级科研奖励计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block

		}
	}
	//同22
	public void calculateF242526(List<Mas> masList,
			List<TeacherresearchsummaryView> teacherresearchsummaryViewsList) {
		//3.2.3 近三年教师主持的科研信息量化得分
		try {

			double F24 = funtionargsService.findFuntionargsByName("F24").get(0)
					.getFunValue();
			double F25 = funtionargsService.findFuntionargsByName("F25").get(0)
					.getFunValue();
			double F26 = funtionargsService.findFuntionargsByName("F26").get(0)
					.getFunValue();

			Iterator<Mas> masIterator = masList.iterator();
			// System.out.println("mas.size" + masList.size());
			// System.out.println("practicecourseViewList.size" +
			// practicecourseViewList.size());
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("24")) {
					// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
					Iterator<TeacherresearchsummaryView> praIterator = teacherresearchsummaryViewsList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherresearchsummaryView teacherresearchsummaryView = praIterator
								.next();
						// System.out.println(mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId());
						if (teacherresearchsummaryView.getMno().equals(
								mas.getMajor().getMno())) {
							float F24Value;
							F24Value = (float) Function.CalculateTalentsPart(
									teacherresearchsummaryView
											.getResearchProjectNumber1(), F24);
							// System.out.println("得分："+F7Value);
							mas.setAssessingScore(F24Value);
							masService.update(mas);
							// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
						}
					}
				}
			}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F24主持国家级科研计算信息完成！！");

			// 更新F25
			Iterator<Mas> masIterator1 = masList.iterator();
			// System.out.println("mas.size" + masList.size());
			// System.out.println("practicecourseViewList.size" +
			// practicecourseViewList.size());
			while (masIterator1.hasNext()) {
				Mas mas = masIterator1.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("25")) {
					// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
					Iterator<TeacherresearchsummaryView> praIterator = teacherresearchsummaryViewsList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherresearchsummaryView teacherresearchsummaryView = praIterator
								.next();
						// System.out.println(mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId());
						if (teacherresearchsummaryView.getMno().equals(
								mas.getMajor().getMno())) {
							float F25Value;
							F25Value = (float) Function.CalculateTalentsPart(
									teacherresearchsummaryView
											.getResearchProjectNumber2(), F25);
							// System.out.println("得分："+F7Value);
							mas.setAssessingScore(F25Value);
							masService.update(mas);
							// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
						}
					}
				}
			}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F25主持省级科研计算信息完成！！");
			// 更新F26
			Iterator<Mas> masIterator2 = masList.iterator();
			// System.out.println("mas.size" + masList.size());
			// System.out.println("practicecourseViewList.size" +
			// practicecourseViewList.size());
			while (masIterator2.hasNext()) {
				Mas mas = masIterator2.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("26")) {
					// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
					Iterator<TeacherresearchsummaryView> praIterator = teacherresearchsummaryViewsList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherresearchsummaryView teacherresearchsummaryView = praIterator
								.next();
						// System.out.println(mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId());
						if (teacherresearchsummaryView.getMno().equals(
								mas.getMajor().getMno())) {
							float F26Value;
							F26Value = (float) Function.CalculateTalentsPart(
									teacherresearchsummaryView
											.getResearchProjectNumber3(), F26);
							// System.out.println("得分："+F7Value);
							mas.setAssessingScore(F26Value);
							masService.update(mas);
							// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
						}
					}
				}
			}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F26主持校级科研计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block

		}
	}
	//同22
	@SuppressWarnings("unchecked")
	public void calculateF27(List<Mas> masList,
			List<TeacherresearchsummaryView> teacherresearchsummaryViewsList) {
		//3.3.1 近三年教师发表教改论文数量(A类期刊、B类期刊、CNKI可查到的公开发表论文)
		try {

			double F27A = funtionargsService.findFuntionargsByName("F27A").get(
					0).getFunValue();
			double F27B = funtionargsService.findFuntionargsByName("F27B").get(
					0).getFunValue();
			double F27C = funtionargsService.findFuntionargsByName("F27C").get(
					0).getFunValue();

			Iterator<Mas> masIterator = masList.iterator();
			// System.out.println("mas.size" + masList.size());
			// System.out.println("practicecourseViewList.size" +
			// practicecourseViewList.size());
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("27")) {
					// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
					Iterator<TeacherresearchsummaryView> praIterator = teacherresearchsummaryViewsList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherresearchsummaryView teacherresearchsummaryView = praIterator
								.next();
						// System.out.println(mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId());
						if (teacherresearchsummaryView.getMno().equals(
								mas.getMajor().getMno())) {
							float F27Value;
							F27Value = (float) Function.CalculateTalents(
									teacherresearchsummaryView
											.getEducationPaperNumber1(),
									teacherresearchsummaryView
											.getEducationPaperNumber2(),
									teacherresearchsummaryView
											.getEducationPaperNumber3(), F27A,
									F27B, F27C);
							//System.out.println("得分："+F27Value);
							mas.setAssessingScore(F27Value);
							masService.update(mas);
							//System.out.println(mas.getMajor().getMno()+"--->"+mas.getAssessingScore());
						}
					}
				}
			}
			//量化
			List<Map> mapList = calculateService.getAllassessingScoreMap("27");
			List<Map> smapList = Function.Standard(mapList,
					"assessingScore", A, 100, 0);
			//System.out.println(mapList.size()+"  "+smapList.size()+"量化后数据：——————————");
				// 最终结果列表
				Iterator<Mas> masIterator1 = masList.iterator();
				while (masIterator1.hasNext()) {
					Mas mas = masIterator1.next();
					if (mas.getAssessingneedtarget().getAppraisalsystem()
							.getIndicatorId().equals("27")) {
						for (Map map : smapList) {
							String majorNoString = (String) map.get("mno");
							Double value1 = (Double) map.get("assessingScore");
							BigDecimal f=new BigDecimal(value1);
							Double   value   =   f.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
							if (mas.getMajor().getMno().equals(majorNoString)) {
								mas.setAssessingScore(Float.parseFloat(String.valueOf(value)));
								masService.update(mas);
								//System.out.println(mas.getMajor().getMno()+ "--->" + mas.getAssessingScore());
							}
						}
					}
				}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F27教改论文计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block

		}
	}
	//同22
	public void calculateF2829(List<Mas> masList,
			List<TeacherresearchsummaryView> teacherresearchsummaryViewsList) {
		//3.3.2 近三年教师参编教材量化得分
		try {
			
			// 副主编统计信息在指标信息中没有
			double F291 = funtionargsService.findFuntionargsByName("F291").get(
					0).getFunValue();
			// 副主编double F292 =
			// funtionargsService.findFuntionargsByName("F292").get(0).getFunValue();
			double F293 = funtionargsService.findFuntionargsByName("F293").get(
					0).getFunValue();

			Iterator<Mas> masIterator = masList.iterator();
			// System.out.println("mas.size" + masList.size());
			// System.out.println("practicecourseViewList.size" +
			// practicecourseViewList.size());
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("28")) {
					// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
					Iterator<TeacherresearchsummaryView> praIterator = teacherresearchsummaryViewsList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherresearchsummaryView teacherresearchsummaryView = praIterator
								.next();
						// System.out.println(mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId());
						if (teacherresearchsummaryView.getMno().equals(
								mas.getMajor().getMno())) {
							float F28Value;
							F28Value = (float) Function.CalculateTalentsPart(
									teacherresearchsummaryView
											.getTextbookNumber1(), F291);
							// System.out.println("得分："+F7Value);
							mas.setAssessingScore(F28Value);
							masService.update(mas);
							// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
						}
					}
				}
			}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F28主编教材计算信息完成！！");
			Iterator<Mas> masIterator1 = masList.iterator();
			// System.out.println("mas.size" + masList.size());
			// System.out.println("practicecourseViewList.size" +
			// practicecourseViewList.size());
			while (masIterator1.hasNext()) {
				Mas mas = masIterator1.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("29")) {
					// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
					Iterator<TeacherresearchsummaryView> praIterator = teacherresearchsummaryViewsList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherresearchsummaryView teacherresearchsummaryView = praIterator
								.next();
						// System.out.println(mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId());
						if (teacherresearchsummaryView.getMno().equals(
								mas.getMajor().getMno())) {
							float F29Value;
							F29Value = (float) Function.CalculateTalentsPart(
									teacherresearchsummaryView
											.getTextbookNumber3(), F293);
							// System.out.println("得分："+F7Value);
							mas.setAssessingScore(F29Value);
							masService.update(mas);
							// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
						}
					}
				}
			}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F29参编教改论文计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block

		}
	}

	public void calculateF303132(List<Mas> masList,
			List<TeacherresearchsummaryView> teacherresearchsummaryViewsList) {
		
		//3.3.3 近三年教师主持教改项目量化得分
		try {

			double F30 = funtionargsService.findFuntionargsByName("F30").get(0)
					.getFunValue();
			double F31 = funtionargsService.findFuntionargsByName("F31").get(0)
					.getFunValue();
			double F32 = funtionargsService.findFuntionargsByName("F32").get(0)
					.getFunValue();

			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("30")) {
					Iterator<TeacherresearchsummaryView> praIterator = teacherresearchsummaryViewsList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherresearchsummaryView teacherresearchsummaryView = praIterator
								.next();
						if (teacherresearchsummaryView.getMno().equals(
								mas.getMajor().getMno())) {
							float F30Value;
							F30Value = (float) Function.CalculateTalentsPart(
									teacherresearchsummaryView
											.getEducationProjectNumber1(), F30);
							mas.setAssessingScore(F30Value);
							masService.update(mas);
							// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
						}
					}
				}
			}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F30主持国家级教改计算信息完成！！");
			Iterator<Mas> masIterator1 = masList.iterator();
			while (masIterator1.hasNext()) {
				Mas mas = masIterator1.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("31")) {
					Iterator<TeacherresearchsummaryView> praIterator = teacherresearchsummaryViewsList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherresearchsummaryView teacherresearchsummaryView = praIterator
								.next();
						if (teacherresearchsummaryView.getMno().equals(
								mas.getMajor().getMno())) {
							float F31Value;
							F31Value = (float) Function.CalculateTalentsPart(
									teacherresearchsummaryView
											.getEducationProjectNumber2(), F31);
							mas.setAssessingScore(F31Value);
							masService.update(mas);
							// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
						}
					}
				}
			}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F31主持省级教改计算信息完成！！");
			Iterator<Mas> masIterator2 = masList.iterator();
			while (masIterator2.hasNext()) {
				Mas mas = masIterator2.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("32")) {
					Iterator<TeacherresearchsummaryView> praIterator = teacherresearchsummaryViewsList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherresearchsummaryView teacherresearchsummaryView = praIterator
								.next();
						if (teacherresearchsummaryView.getMno().equals(
								mas.getMajor().getMno())) {
							float F32Value;
							F32Value = (float) Function.CalculateTalentsPart(
									teacherresearchsummaryView
											.getEducationProjectNumber3(), F32);
							mas.setAssessingScore(F32Value);
							masService.update(mas);
							// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
						}
					}
				}
			}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F32主持校级教改计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block

		}
	}

	public void calculateF353637(List<Mas> masList,
			List<TeacherresearchsummaryView> teacherresearchsummaryViewsList) {
		//3.4.1 历年本科教学工程项目量化得分
		try {

			double F35 = funtionargsService.findFuntionargsByName("F35").get(0)
					.getFunValue();
			double F36 = funtionargsService.findFuntionargsByName("F36").get(0)
					.getFunValue();
			double F37 = funtionargsService.findFuntionargsByName("F37").get(0)
					.getFunValue();

			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("35")) {
					Iterator<TeacherresearchsummaryView> praIterator = teacherresearchsummaryViewsList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherresearchsummaryView teacherresearchsummaryView = praIterator
								.next();
						if (teacherresearchsummaryView.getMno().equals(
								mas.getMajor().getMno())) {
							float F35Value;
							F35Value = (float) Function.CalculateTalentsPart(
									teacherresearchsummaryView
											.getQualitylEngineeringNumber1(),
									F35);
							mas.setAssessingScore(F35Value);
							masService.update(mas);
							// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
						}
					}
				}
			}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F35国家级教学质量工程计算信息完成！！");
			Iterator<Mas> masIterator1 = masList.iterator();
			while (masIterator1.hasNext()) {
				Mas mas = masIterator1.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("36")) {
					Iterator<TeacherresearchsummaryView> praIterator = teacherresearchsummaryViewsList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherresearchsummaryView teacherresearchsummaryView = praIterator
								.next();
						if (teacherresearchsummaryView.getMno().equals(
								mas.getMajor().getMno())) {
							float F36Value;
							F36Value = (float) Function.CalculateTalentsPart(
									teacherresearchsummaryView
											.getQualitylEngineeringNumber2(),
									F36);
							mas.setAssessingScore(F36Value);
							masService.update(mas);
							// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
						}
					}
				}
			}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F36省级教学工程计算信息完成！！");
			Iterator<Mas> masIterator2 = masList.iterator();
			while (masIterator2.hasNext()) {
				Mas mas = masIterator2.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("37")) {
					Iterator<TeacherresearchsummaryView> praIterator = teacherresearchsummaryViewsList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherresearchsummaryView teacherresearchsummaryView = praIterator
								.next();
						if (teacherresearchsummaryView.getMno().equals(
								mas.getMajor().getMno())) {
							float F37Value;
							F37Value = (float) Function.CalculateTalentsPart(
									teacherresearchsummaryView
											.getQualitylEngineeringNumber3(),
									F37);
							mas.setAssessingScore(F37Value);
							masService.update(mas);
							// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
						}
					}
				}
			}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F37校级教学工程计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block

		}
	}

	public void calculateF383940(List<Mas> masList,
			List<TeacherresearchsummaryView> teacherresearchsummaryViewsList) {
		//3.5.1 历年教学成果量化得分
		try {// 由于数据库中没有统计教学成果奖的排名信息，所以排名没有计算
			// 教学成果奖国家级
			double F381 = funtionargsService.findFuntionargsByName("F381").get(
					0).getFunValue();
			double F382 = funtionargsService.findFuntionargsByName("F382").get(
					0).getFunValue();
			double F383 = funtionargsService.findFuntionargsByName("F383").get(
					0).getFunValue();

			@SuppressWarnings("unused")
			double R381 = funtionargsService.findFuntionargsByName("R381").get(
					0).getFunValue();
			double R382 = funtionargsService.findFuntionargsByName("R382").get(
					0).getFunValue();
			double R383 = funtionargsService.findFuntionargsByName("R383").get(
					0).getFunValue();

			// 教学成果奖省级
			double F391 = funtionargsService.findFuntionargsByName("F391").get(
					0).getFunValue();
			double F392 = funtionargsService.findFuntionargsByName("F392").get(
					0).getFunValue();
			double F393 = funtionargsService.findFuntionargsByName("F393").get(
					0).getFunValue();

			double R391 = funtionargsService.findFuntionargsByName("R391").get(
					0).getFunValue();
			double R392 = funtionargsService.findFuntionargsByName("R392").get(
					0).getFunValue();
			double R393 = funtionargsService.findFuntionargsByName("R393").get(
					0).getFunValue();

			// 教学成果奖校级
			double F401 = funtionargsService.findFuntionargsByName("F401").get(
					0).getFunValue();
			double F402 = funtionargsService.findFuntionargsByName("F402").get(
					0).getFunValue();
			double F403 = funtionargsService.findFuntionargsByName("F403").get(
					0).getFunValue();

			double R401 = funtionargsService.findFuntionargsByName("R401").get(
					0).getFunValue();
			double R402 = funtionargsService.findFuntionargsByName("R402").get(
					0).getFunValue();
			double R403 = funtionargsService.findFuntionargsByName("R403").get(
					0).getFunValue();

			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("38")) {
					Iterator<TeacherresearchsummaryView> praIterator = teacherresearchsummaryViewsList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherresearchsummaryView teacherresearchsummaryView = praIterator
								.next();
						if (teacherresearchsummaryView.getMno().equals(
								mas.getMajor().getMno())) {
							float F38Value;
							F38Value = (float) Function.CalculateTalents(
									teacherresearchsummaryView
											.getTeachingAchievementNumber11(),
									teacherresearchsummaryView
											.getTeachingAchievementNumber21(),
									teacherresearchsummaryView
											.getTeachingAchievementNumber31(),
									F381, F382, F383);
							mas.setAssessingScore(F38Value);
							masService.update(mas);
							//System.out.println(mas.getMajor().getMname()+ "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F38国家级教学成果计算信息完成！！");
			Iterator<Mas> masIterator1 = masList.iterator();
			while (masIterator1.hasNext()) {
				Mas mas = masIterator1.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("39")) {
					Iterator<TeacherresearchsummaryView> praIterator = teacherresearchsummaryViewsList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherresearchsummaryView teacherresearchsummaryView = praIterator
								.next();
						if (teacherresearchsummaryView.getMno().equals(
								mas.getMajor().getMno())) {
							float F39Value;
							F39Value = (float) Function.CalculateTalents(
									teacherresearchsummaryView
											.getTeachingAchievementNumber12(),
									teacherresearchsummaryView
											.getTeachingAchievementNumber22(),
									teacherresearchsummaryView
											.getTeachingAchievementNumber32(),
									F391, F392, F393);
							mas.setAssessingScore(F39Value);
							masService.update(mas);
							//System.out.println(mas.getMajor().getMname()+ "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F39省级教学成果奖计算信息完成！！");
			Iterator<Mas> masIterator2 = masList.iterator();
			while (masIterator2.hasNext()) {
				Mas mas = masIterator2.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("40")) {
					Iterator<TeacherresearchsummaryView> praIterator = teacherresearchsummaryViewsList
							.iterator();
					while (praIterator.hasNext()) {
						TeacherresearchsummaryView teacherresearchsummaryView = praIterator
								.next();
						if (teacherresearchsummaryView.getMno().equals(
								mas.getMajor().getMno())) {
							float F40Value;
							F40Value = (float) Function.CalculateTalents(
									teacherresearchsummaryView
											.getTeachingAchievementNumber13(),
									teacherresearchsummaryView
											.getTeachingAchievementNumber23(),
									teacherresearchsummaryView
											.getTeachingAchievementNumber33(),
									F401, F402, F403);
							mas.setAssessingScore(F40Value);
							masService.update(mas);
							//System.out.println(mas.getMajor().getMname()+ "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			// masService.batchUpdateResult(Mas.class, masList);
			System.out.println("更新F40校级教学成果奖计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block

		}
	}
	//没有完善信息
//	public void calculateF41(List<Mas> masList,
//			List<TeacherresearchsummaryView> teacherresearchsummaryViewsList) {
//		//4.1.1 教学经费投入与使用情况
//		try {
//
//			double F27A = funtionargsService.findFuntionargsByName("F27A").get(
//					0).getFunValue();
//			double F27B = funtionargsService.findFuntionargsByName("F27B").get(
//					0).getFunValue();
//			double F27C = funtionargsService.findFuntionargsByName("F27C").get(
//					0).getFunValue();
//
//			Iterator<Mas> masIterator = masList.iterator();
//			// System.out.println("mas.size" + masList.size());
//			while (masIterator.hasNext()) {
//				Mas mas = masIterator.next();
//				if (mas.getAssessingneedtarget().getAppraisalsystem()
//						.getIndicatorId().equals("27")) {
//					// System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
//					Iterator<TeacherresearchsummaryView> praIterator = teacherresearchsummaryViewsList
//							.iterator();
//					
//					while (praIterator.hasNext()) {
//						TeacherresearchsummaryView teacherresearchsummaryView = praIterator
//								.next();
//						// System.out.println(mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId());
//						if (teacherresearchsummaryView.getMno().equals(
//								mas.getMajor().getMno())) {
//							float F27Value;
//							F27Value = (float) Function.CalculateTalents(
//									teacherresearchsummaryView
//											.getEducationPaperNumber1(),
//									teacherresearchsummaryView
//											.getEducationPaperNumber2(),
//									teacherresearchsummaryView
//											.getEducationPaperNumber3(), F27A,
//									F27B, F27C);
//							// System.out.println("得分："+F7Value);
//							mas.setAssessingScore(F27Value);
//							masService.update(mas);
//							//System.out.println(mas.getMajor().getMname()+"--->"+mas.getAssessingScore());
//						}
//					}
//				}
//			}
//			System.out.println("更新F41教改论文计算信息完成！！");
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//
//		}
//	}
	
	//课程开出率比例
	@SuppressWarnings("unchecked")
	public void calculateF43(List<Mas> masList) {
		
		// 首先获取量化前的指标数据
		List<Map> mapList = calculateService.getAllopenCourseTotaoNumMap();
		List<Map> smapList = Function.Standard(mapList,
				"openCourseTotaoNumRatio", A, 100, 0);
		//System.out.println("量化后数据：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("43")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("openCourseTotaoNumRatio");
						BigDecimal f=new BigDecimal(value1);
						Double   value   =   f.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.parseFloat(String.valueOf(value)));
							masService.update(mas);
							//System.out.println(mas.getMajor().getMno()+ "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("更新F43计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//优质课程率比例
	@SuppressWarnings("unchecked")
	public void calculateF44(List<Mas> masList) {
		
		// 首先获取量化前的指标数据
		List<Map> mapList = calculateService.getAllgoodCourseTotaoNumMap();
		List<Map> smapList = Function.Standard(mapList,
				"goodCourseTotaoNum", A, 100, 0);
		//System.out.println("量化后数据：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("44")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("goodCourseTotaoNum");
						BigDecimal f=new BigDecimal(value1);
						Double   value   =   f.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.parseFloat(String.valueOf(value)));
							masService.update(mas);
							//System.out.println(mas.getMajor().getMno()+ "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("更新F44计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//实习基地资源数量量化
	@SuppressWarnings("unchecked")
	public void calculateF46(List<Mas> masList) {
		
		// 首先获取量化前的指标数据
		List<Map> mapList = calculateService.getAllpracticeBaseTotalNumMap();
		List<Map> smapList = Function.Standard(mapList,
				"practiceBaseTotalNumRatio", A, 100, 0);
		//System.out.println("量化后数据：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("46")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("practiceBaseTotalNumRatio");
						BigDecimal f=new BigDecimal(value1);
						Double   value   =   f.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.parseFloat(String.valueOf(value)));
							masService.update(mas);
							//System.out.println(mas.getMajor().getMno()+ "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("更新F46计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// 学生科创人数比例
	@SuppressWarnings("unchecked")
	public void calculateF59(List<Mas> masList) {

		List<Map> mapList = calculateService.getAllstudentInnovationNumMap();
		List<Map> smapList = Function.Standard(mapList,
				"studentInnovationNumRatio", A, 100, 0);
		// System.out.println("量化后数据：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("59")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map
								.get("studentInnovationNumRatio");
						BigDecimal f = new BigDecimal(value1);
						Double value = f.setScale(2, BigDecimal.ROUND_HALF_UP)
								.doubleValue();
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.parseFloat(String
									.valueOf(value)));
							masService.update(mas);
							// System.out.println(mas.getMajor().getMno()+
							// "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("更新F59计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 实习实践毕业设计落实及效果情况
	@SuppressWarnings("unchecked")
	public void calculateF60(List<Mas> masList, double F1, double F2) {

		List<Fulfillinginstance> ffList = fulfillinginstanceService
				.findAll(Fulfillinginstance.class);
		// System.out.println("量化后数据：——————————");
		try {
			List<Map> mapList = new ArrayList<Map>();
			for (Fulfillinginstance ff : ffList) {
				Double value1 = (Double) Function.CaculateTeachOpenRate(ff
						.getOpenRate(), ff.getFinishRate(), F1, F2);
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("mno", ff.getMajor().getMno());
				m.put("ffNum", value1);
				mapList.add(m);
			}
			//List<Map> smapList = Function.Standard(mapList, "ffNum", 60, 100, 0);
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("60")) {
					for (Map map : mapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("ffNum");
						BigDecimal f = new BigDecimal(value1);
						Double value = f.setScale(2, BigDecimal.ROUND_HALF_UP)
								.doubleValue();
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.parseFloat(String
									.valueOf(value)));
							System.out.println(mas.getMajor().getMno()+ "--->" + mas.getAssessingScore());
							masService.update(mas);
							//System.out.println(mas.getMajor().getMno()+ "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("更新F60计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 人文与科学素质教育及育人情况
	@SuppressWarnings("unchecked")
	public void calculateF61(List<Mas> masList, double F1, double F2,
			double F3, double F4) {

		List<Effectofqualityeducation> eqeList = effectqualityeducationService
				.findAll(Effectofqualityeducation.class);
		// System.out.println("量化后数据：——————————");
		try {
			List<Map> mapList = new ArrayList<Map>();
			for (Effectofqualityeducation eqe : eqeList) {			
				Double value1 = (Double) Function.CaculateEffectofqualityeducation(Function.CalculateDoctorRate(eqe.getCupCount(),eqe.getMajorCount()), eqe.getHostReportCount(),eqe.getPartiCount(),eqe.getOtherProject(), F1, F2, F3,F4);
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("mno", eqe.getMajor().getMno());
				m.put("eqeNum", value1);
				mapList.add(m);
			}
			//List<Map> smapList = Function.Standard(mapList, "eqeNum", 60, 100, 0);
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("61")) {
					for (Map map : mapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("eqeNum");
						BigDecimal f = new BigDecimal(value1);
						Double value = f.setScale(2, BigDecimal.ROUND_HALF_UP)
								.doubleValue();
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.parseFloat(String
									.valueOf(value)));
							masService.update(mas);
							//System.out.println(mas.getMajor().getMno()+"--->" + mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("更新F61计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	// 学生国内外交流情况
	@SuppressWarnings("unchecked")
	public void calculateF62(List<Mas> masList, double F1, double F2) {

		// System.out.println("量化后数据：——————————");
		try {
			List<Map> mapList = calculateService.getAllstudentCommunicationsituNumMap(F1,F2);
			List<Map> smapList = Function
					.Standard(mapList, "exchangeRatio", A, 100, 0);
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("62")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");						
						Double value1 = (Double) map.get("exchangeRatio");
						BigDecimal f = new BigDecimal(value1);
						Double value = f.setScale(2, BigDecimal.ROUND_HALF_UP)
								.doubleValue();
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.parseFloat(String
									.valueOf(value)));
							masService.update(mas);
							// System.out.println(mas.getMajor().getMno()+
							// "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("更新F62计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// 课程质量标准完成比例
	@SuppressWarnings("unchecked")
	public void calculateF63(List<Mas> masList) {

		List<Map> mapList = calculateService.getAllqualitystandardNumMap();
		List<Map> smapList = Function.Standard(mapList,
				"qualitystandardNumRatio", A, 100, 0);
		// System.out.println("量化后数据：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("63")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map
								.get("qualitystandardNumRatio");
						BigDecimal f = new BigDecimal(value1);
						Double value = f.setScale(2, BigDecimal.ROUND_HALF_UP)
								.doubleValue();
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.parseFloat(String
									.valueOf(value)));
							masService.update(mas);
							// System.out.println(mas.getMajor().getMno()+
							// "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("更新F63计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//专业热门度比例
	@SuppressWarnings("unchecked")
	public void calculateF69(List<Mas> masList) {
		
		// 首先获取量化前的指标数据
		List<Map> mapList = calculateService.getAllpopularityRateMap();
		List<Map> smapList = Function.Standard(mapList,
				"popularityRate", A, 100, 0);
		//System.out.println("量化后数据：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("69")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("popularityRate");
						BigDecimal f=new BigDecimal(value1);
						Double   value   =   f.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.parseFloat(String.valueOf(value)));
							masService.update(mas);
							//System.out.println(mas.getMajor().getMno()+ "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("更新F69计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//第一志愿率比例
	@SuppressWarnings("unchecked")
	public void calculateF70(List<Mas> masList) {
		
		List<Map> mapList = calculateService.getAllfirstVolunteerRateMap();
		List<Map> smapList = Function.Standard(mapList,
				"firstVolunteerRate", A, 100, 0);
		//System.out.println("量化后数据：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("70")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("firstVolunteerRate");
						BigDecimal f=new BigDecimal(value1);
						Double   value   =   f.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.parseFloat(String.valueOf(value)));
							masService.update(mas);
							//System.out.println(mas.getMajor().getMno()+ "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("更新F70计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//初次就业率比例
	@SuppressWarnings("unchecked")
	public void calculateF71(List<Mas> masList) {
		List<Map> imapList = calculateService.getAllinitialemploymentrateMap();
		List<Map> emapList = calculateService.getAllemploymentrateMap();

		
		//System.out.println("量化后数据：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("71")) {
					for (Map map : imapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("initialemploymentrate")*100;
						BigDecimal f=new BigDecimal(value1);
						Double   value   =   f.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.parseFloat(String.valueOf(value)));
							masService.update(mas);
							//System.out.println("71:_____"+mas.getMajor().getMno()+ "--->" + mas.getAssessingScore());
						}
					}
				}else if (mas.getAssessingneedtarget().getAppraisalsystem()
							.getIndicatorId().equals("72")) {
					for (Map map : emapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("employmentrate")*100;
						BigDecimal f=new BigDecimal(value1);
						Double   value   =   f.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.parseFloat(String.valueOf(value)));
							masService.update(mas);
							//System.out.println("72:_____"+mas.getMajor().getMno()+ "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("更新F71、F72计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//三年就业率比例
	@SuppressWarnings("unchecked")
	public void calculateF7172(List<Mas> masList) {
		List<Map> mapList = calculateService.getAllemploymentrateSumMap();
		List<Map> sumapList = Function.Standard(mapList,
				"employmentrateSum", A, 100, 0);
		//System.out.println("量化后数据：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if(mas.getAssessingneedtarget().getAppraisalsystem()
							.getIndicatorId().equals("7172")){
					for (Map map : sumapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("employmentrateSum");
						BigDecimal f=new BigDecimal(value1);
						Double   value   =   f.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.parseFloat(String.valueOf(value)));
							masService.update(mas);
							//System.out.println("7172:_____"+mas.getMajor().getMno()+ "--->" + mas.getAssessingScore());
						}
					}
				}
			}
			System.out.println("更新F7172计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// F74指标项项目主持学生人数与本专业在籍学生比值的处理,统计后百分量化
	@SuppressWarnings("unchecked")
	public void calculateF74(List<Mas> masList) {

		// 首先获取量化前的指标数据
		List<Map> mapList = calculateService.getAllstudentpersisProjectRate();
		List<Map> smapList = Function.Standard(mapList, "studentPersisProjectRate",
				A, 100, 0);
		//System.out.println("量化后数据F74：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("74")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("studentPersisProjectRate");
						BigDecimal b = new BigDecimal(value1);
						Double value = b.setScale(2, BigDecimal.ROUND_HALF_UP)
								.doubleValue();
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.valueOf(String
									.valueOf(value)));
							masService.update(mas);
							/* System.out.println(mas.getMajor().getMno()+
							 "--->" + mas.getAssessingScore());*/
						}
					}
				}
			}
			System.out.println("更新F74计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// F75-1指标项学生获得国家级竞赛奖励（学生为第一获奖人）的处理,统计后百分量化
	@SuppressWarnings("unchecked")
	public void calculateF75_1(List<Mas> masList) {

		// 首先获取量化前的指标数据
		List<Map> mapList = calculateService.getAllRaceNumber1();
		List<Map> smapList = Function.Standard(mapList, "raceNumber1",
				A, 100, 0);
		//System.out.println("量化后数据F75-1：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("75")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("raceNumber1");
						BigDecimal b = new BigDecimal(value1);
						Double value = b.setScale(2, BigDecimal.ROUND_HALF_UP)
								.doubleValue();
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.valueOf(String
									.valueOf(value)));
							masService.update(mas);
							/* System.out.println(mas.getMajor().getMno()+
							 "--->" + mas.getAssessingScore());*/
						}
					}
				}
			}
			System.out.println("更新F75-1计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// F75-2指标项学生获得省级竞赛奖励（学生为第一获奖人）的处理,统计后百分量化
	@SuppressWarnings("unchecked")
	public void calculateF75_2(List<Mas> masList) {

		// 首先获取量化前的指标数据
		List<Map> mapList = calculateService.getAllRaceNumber2();
		List<Map> smapList = Function.Standard(mapList, "raceNumber2",
				A, 100, 0);
		//System.out.println("量化后数据F75-2：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("75")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("raceNumber2");
						BigDecimal b = new BigDecimal(value1);
						Double value = b.setScale(2, BigDecimal.ROUND_HALF_UP)
								.doubleValue();
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.valueOf(String
									.valueOf(value)));
							masService.update(mas);
							/* System.out.println(mas.getMajor().getMno()+
							 "--->" + mas.getAssessingScore());*/
						}
					}
				}
			}
			System.out.println("更新F75-2计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// F75-3指标项学生获得校级竞赛奖励（学生为第一获奖人）的处理,统计后百分量化
	@SuppressWarnings("unchecked")
	public void calculateF75_3(List<Mas> masList) {

		// 首先获取量化前的指标数据
		List<Map> mapList = calculateService.getAllRaceNumber3();
		List<Map> smapList = Function.Standard(mapList, "raceNumber3",
				A, 100, 0);
		//System.out.println("量化后数据F75-3：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("75")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("raceNumber3");
						BigDecimal b = new BigDecimal(value1);
						Double value = b.setScale(2, BigDecimal.ROUND_HALF_UP)
								.doubleValue();
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.valueOf(String
									.valueOf(value)));
							masService.update(mas);
							 /*System.out.println(mas.getMajor().getMno()+
							 "--->" + mas.getAssessingScore());*/
						}
					}
				}
			}
			System.out.println("更新F75-3计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// F76指标项学生获得专利数（学生为第一获奖人）的处理,统计后百分量化
	@SuppressWarnings("unchecked")
	public void calculateF76(List<Mas> masList) {

		// 首先获取量化前的指标数据
		List<Map> mapList = calculateService.getAllPatentNumber();
		List<Map> smapList = Function.Standard(mapList, "patentNumber",
				A, 100, 0);
		//System.out.println("量化后数据F76：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("76")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("patentNumber");
						BigDecimal b = new BigDecimal(value1);
						Double value = b.setScale(2, BigDecimal.ROUND_HALF_UP)
								.doubleValue();
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.valueOf(String
									.valueOf(value)));
							masService.update(mas);
							/* System.out.println(mas.getMajor().getMno()+
							 "--->" + mas.getAssessingScore());*/
						}
					}
				}
			}
			System.out.println("更新F76计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// F77指标项学生发表论文数的处理,统计后百分量化
	@SuppressWarnings("unchecked")
	public void calculateF77(List<Mas> masList) {

		// 首先获取量化前的指标数据
		List<Map> mapList = calculateService.getAllResearchPaperNumber();
		List<Map> smapList = Function.Standard(mapList, "researchPaperNumber",
				A, 100, 0);
		//System.out.println("量化后数据F77：——————————");
		try {
			// 最终结果列表
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if (mas.getAssessingneedtarget().getAppraisalsystem()
						.getIndicatorId().equals("77")) {
					for (Map map : smapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("researchPaperNumber");
						BigDecimal b = new BigDecimal(value1);
						Double value = b.setScale(2, BigDecimal.ROUND_HALF_UP)
								.doubleValue();
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.valueOf(String
									.valueOf(value)));
							masService.update(mas);
							 /*System.out.println(mas.getMajor().getMno()+
							 "--->" + mas.getAssessingScore());*/
						}
					}
				}
			}
			System.out.println("更新F77计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//将四级指标得分汇总到三级指标
	public void calculatePartSumOrStandrd(List<Mas> masList) {
		
		try {
			Iterator <Mas>iterator=masList.iterator();
		while (iterator.hasNext()) {
				Mas mas = iterator.next();
				float score=0;
			if(mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId().equals("1516")
					||mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId().equals("1920")
					||mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId().equals("2223")
					||mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId().equals("242526")
					||mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId().equals("2829")
					||mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId().equals("303132")
					||mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId().equals("353637")
					||mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId().equals("383940")
					||mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId().equals("4950")
					||mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId().equals("7677")){
				Iterator<Mas> masLIterator=masList.iterator();
				while(masLIterator.hasNext()){
					Mas imas=masLIterator.next();
					if (mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId().equals(imas.getAssessingneedtarget().getAppraisalsystem().getPid())
							&&mas.getMajor().getMno().equals(imas.getMajor().getMno())) {
						//System.out.println(imas.getMajor().getMname()+"---->"+imas.getAssessingneedtarget().getAppraisalsystem().getIndicatorName()+ "--->" + imas.getAssessingScore());
						if(imas.getAssessingScore()==null){
							imas.setAssessingScore((float)0.0);
						}
						score+=imas.getAssessingScore()*imas.getAssessingneedtarget().getIndicatorWeight();	
						//System.out.println(imas.getAssessingneedtarget().getAppraisalsystem().getIndicatorName()+ "--->" + imas.getAssessingScore());
					}
				}
				BigDecimal f = new BigDecimal(score);
				float value = f.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
				mas.setAssessingScore(value);
				mas.setAssessingScore(score);
				System.out.println(mas.getMajor().getMname()+"---->"+mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorName()+ "--->" + mas.getAssessingScore());
				masService.update(mas);
				}
			}
			//System.out.println("更新F1516指标数据信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//量化22、23 3.2.2
	@SuppressWarnings("unchecked")
	public void calculateTeplate(List<Mas> masList,String TargetNum) {
		List<Map> mapList = calculateService.getAllassessingScoreMap(TargetNum);
		List<Map> sumapList = Function.Standard(mapList,
				"assessingScore", A, 100, 0);
		try {
			// 最终结果列表
			//System.out.println("更新"+TargetNum+"计算信息开始！！");
			Iterator<Mas> masIterator = masList.iterator();
			while (masIterator.hasNext()) {
				Mas mas = masIterator.next();
				if(mas.getAssessingneedtarget().getAppraisalsystem()
							.getIndicatorId().equals(TargetNum)){
					for (Map map : sumapList) {
						String majorNoString = (String) map.get("mno");
						Double value1 = (Double) map.get("assessingScore");
						BigDecimal f=new BigDecimal(value1);
						Double   value   =   f.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
						if (mas.getMajor().getMno().equals(majorNoString)) {
							mas.setAssessingScore(Float.parseFloat(String.valueOf(value)));
							//System.out.println(mas.getMajor().getMno()+ "--->" + mas.getAssessingScore());
							masService.update(mas);
						}
					}
				}
			}
			System.out.println("更新"+TargetNum+"计算信息完成！！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//计算二级指标以及以及指标  耗费时间
	public void calculateTargetType(List<Mas>masList){
	try {
			Iterator <Mas>iterator=masList.iterator();
			System.out.println("更新各级指标数据信息——————————————————————！");
		while (iterator.hasNext()) {
				Mas mas = iterator.next();
				float score=0;
				//定性数据：一开始mas表中只有需要量化的三级指标，哪来的一级二级指标？
				
			if((mas.getAssessingneedtarget().getAppraisalsystem().getIndNameExp().equals("一级指标")&&mas.getTag()==1)||
					(mas.getAssessingneedtarget().getAppraisalsystem().getIndNameExp().equals("二级指标")
					&&mas.getTag()==1)){
					Iterator<Mas> masLIterator=masList.iterator();
					while(masLIterator.hasNext()){
						Mas imas=masLIterator.next();
						if (mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId().equals(imas.getAssessingneedtarget().getAppraisalsystem().getPid())
								&&mas.getMajor().getMno().equals(imas.getMajor().getMno())) {
								if(imas.getAssessingScore()==null){
									imas.setAssessingScore((float)0.0);
								}
								
							score+=imas.getAssessingScore()*imas.getAssessingneedtarget().getIndicatorWeight();
								System.out.println(imas.getAssessingneedtarget().getAppraisalsystem().getIndicatorName()+ "--->" + imas.getAssessingScore());
						}
						
					}
				BigDecimal f = new BigDecimal(score);
				float value = f.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
				mas.setAssessingScore(value);
				System.out.println(score+" "+mas.getMasCode()+mas.getMajor().getMname()+mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorName()+ "--->" + mas.getAssessingScore());
				masService.update(mas);
				}
			}
			System.out.println("更新各级指标数据信息完成！！");
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//计算二级指标以及以及指标
	public void outPrint(){
		    List<Mas>masList=masService.findAll(Mas.class);
			Iterator <Mas>iterator=masList.iterator();
		while (iterator.hasNext()) {
				Mas mas = iterator.next();
				float score=0;
				//System.out.println("进入定性指标");
			if(mas.getAssessingneedtarget().getAppraisalsystem().getIndNameExp().equals("一级指标")||
					mas.getAssessingneedtarget().getAppraisalsystem().getIndNameExp().equals("二级指标")
					||mas.getAssessingneedtarget().getAppraisalsystem().getIndNameExp().equals("三级指标")){
				if(mas.getMajor().getMname().equals("软件工程")){
					System.out.println(mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorName()+ "--->" + mas.getAssessingScore());
					Iterator<Mas> masLIterator=masList.iterator();
					while(masLIterator.hasNext()){
						Mas imas=masLIterator.next();
						if (mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId().equals(imas.getAssessingneedtarget().getAppraisalsystem().getPid())
								&&mas.getMajor().getMno().equals(imas.getMajor().getMno())) {
								System.out.println("------"+imas.getAssessingneedtarget().getAppraisalsystem().getIndicatorName()+"("+imas.getAssessingneedtarget().getIndicatorWeight()+")"+ "--->" + imas.getAssessingScore());
						}
					}
				}
				}
			}
			System.out.println("输出各级指标数据信息完成！！");
	}
	/*************************** 2016-11-23添加系统缺失的统计方法——start **************************/
		/**
		 * 将三级指标得分汇总到二级指标
		 */
	    private void calculateSecondLevelTarget(){
	    	List<Mas> masList2 = masService.findByTargetLevel("二级指标");
	    	List<Mas> masList3 = masService.findByTargetLevel("三级指标");
	    	Iterator<Mas> im2 = masList2.iterator();   	
	    	while(im2.hasNext()){
	    		float score = 0;
	    		Mas mas2 = im2.next();
	    		Iterator<Mas> im3 = masList3.iterator();
	    		while(im3.hasNext()){
	    			Mas mas3 = im3.next();
	    			if(mas3.getAssessingneedtarget().getAppraisalsystem().getPid().equals
	    					(mas2.getAssessingneedtarget().getAppraisalsystem().getIndicatorId())
	    					&& mas3.getMajor().getInMno().equals(mas2.getMajor().getMno())
	    			){
	    				if (mas3.getAssessingScore() == null) {
							mas3.setAssessingScore((float) 0.0);
						}
	    				score += mas3.getAssessingScore()*mas3.getAssessingneedtarget().getIndicatorWeight();
						BigDecimal f = new BigDecimal(score);
						score = f.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
	    			}
	    		}
	    		mas2.setAssessingScore(score);
	    		try {
					masService.update(mas2);
				} catch (ServiceException e) {
					e.printStackTrace();
					System.out.println("三级指标更新到二级指标失败！");
				}
	    	}
	    	System.out.println("二级指标统计完成！");
	    }
	    /**
	     * 将二级指标得分汇总到一级指标
	     */
		private void calculateFirstLevelTarget(){
			List<Mas> masList1 = masService.findByTargetLevel("一级指标");
			List<Mas> masList2 = masService.findByTargetLevel("二级指标");
	    	Iterator<Mas> im1 = masList1.iterator();   	
	    	while(im1.hasNext()){
	    		float score = 0;
	    		Mas mas1 = im1.next();
	    		Iterator<Mas> im2 = masList2.iterator();
	    		while(im2.hasNext()){
	    			Mas mas2 = im2.next();
	    			if(mas2.getAssessingneedtarget().getAppraisalsystem().getPid().equals
	    					(mas1.getAssessingneedtarget().getAppraisalsystem().getIndicatorId())
	    					&& mas2.getMajor().getInMno().equals(mas1.getMajor().getMno())
	    			){
	    				if (mas2.getAssessingScore() == null) {
							mas2.setAssessingScore((float) 0.0);
						}
	    				score += mas2.getAssessingScore()*mas2.getAssessingneedtarget().getIndicatorWeight();
						BigDecimal f = new BigDecimal(score);
						score = f.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
	    			}
	    		}
	    		mas1.setAssessingScore(score);
	    		try {
					masService.update(mas1);
				} catch (ServiceException e) {
					e.printStackTrace();
					System.out.println("二级指标更新到一级指标失败！");
				}
	    	}
	    	System.out.println("一级指标统计完成！");
		}

		/**
		 * 3.1.6 提升教师教学能力和专业水平的举措及成效
		 */
		private void calculateF18() {
			List<Mas> masList = masService.findByAssessingNeedTargetNo(18);
			Iterator<Mas> im = masList.iterator();
			Mas mas;
			while(im.hasNext()){
				mas = im.next();
				//将2、4、20、65、67项累计计算
				float s = 0;
				s += masService.findByTargetNoAndMno("2", mas.getMajor().getMno()).
				getAssessingScore();
				s += masService.findByTargetNoAndMno("4", mas.getMajor().getMno()).
				getAssessingScore();
				s += masService.findByTargetNoAndMno("20", mas.getMajor().getMno()).
				getAssessingScore();
				s += masService.findByTargetNoAndMno("65", mas.getMajor().getMno()).
				getAssessingScore();
				s += masService.findByTargetNoAndMno("67", mas.getMajor().getMno()).
				getAssessingScore();
				//先存入数据库，全部计算完成后,按照农、工、理、经人分类进行量化
				
				mas.setAssessingScore(s);
				try {
					masService.update(mas);
				} catch (ServiceException e) {
					e.printStackTrace();
					System.out.println("更新第18项指标出现错误！");
				}
			}
			//按照农、工、理、经人分类进行量化
			Categoryquantization(18);
			System.out.println("更新第18项指标完成");
		}
		/**
		 * 3.3.4 专任教师的专业水平、教学能力及教学效果
		 * @param masList
		 */
		private void calculateF33() {
			List<Mas> masList = masService.findByAssessingNeedTargetNo(33);
			Iterator<Mas> im = masList.iterator();
			Mas mas;
			while(im.hasNext()){
				
				mas = im.next();
				//由教师科研：S1=21-26项累计
				float s1 = 0;
				s1 += masService.findByTargetNoAndMno("21", mas.getMajor().getMno()).
				getAssessingScore();
				s1 += masService.findByTargetNoAndMno("2223", mas.getMajor().getMno()).
				getAssessingScore();
				s1 += masService.findByTargetNoAndMno("242526", mas.getMajor().getMno()).
				getAssessingScore();
				s1 = s1/3;
				//教学：S2=27-32、35-40累计
				float s2 = 0;
				s2 += masService.findByTargetNoAndMno("27", mas.getMajor().getMno()).
				getAssessingScore();
				s2 += masService.findByTargetNoAndMno("2829", mas.getMajor().getMno()).
				getAssessingScore();
				s2 += masService.findByTargetNoAndMno("303132", mas.getMajor().getMno()).
				getAssessingScore();
				s2 += masService.findByTargetNoAndMno("353637", mas.getMajor().getMno()).
				getAssessingScore();
				s2 += masService.findByTargetNoAndMno("383940", mas.getMajor().getMno()).
				getAssessingScore();
				s2 = s2/5;
				//S=s1*0.3+s2*0.7
				float score = (float) (s1*0.3 + s2*0.7);
				BigDecimal f = new BigDecimal(score);
				score = f.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
				System.out.println("33项指标得分："+score);
				mas.setAssessingScore(score);
				try {
					masService.update(mas);
				} catch (ServiceException e) {
					System.out.println("更新第33项指标出现错误！");
				}
			}
			System.out.println("更新第33项指标完成");
		}		
		/**
		 * 4.1.1 教学经费投入与使用情况
		 */
		private void calculateF41() {
			List<Mas> masList = masService.findByAssessingNeedTargetNo(41);
			List<Map> mapList = calculateService.getAllstudentTrainNumMap();
			Iterator<Mas> im = masList.iterator();
			
			while(im.hasNext()){
				Mas mas = im.next();
				//总教学经费/总学生人数
				int count =0 ;
				Iterator<Map> ip = mapList.iterator();
				while(ip.hasNext()){				
					Map map = ip.next();
					float s = 0;
					if(mas.getMajor().getMno().equals(map.get("mno"))){
						Double c = (Double)map.get("totalTeachCostRatio");
					    System.out.println(c);
					    BigDecimal f = new BigDecimal(c);
						s = f.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
						mas.setAssessingScore(s);
						try {
							masService.update(mas);
						} catch (ServiceException e) {
							e.printStackTrace();
							System.out.println("更新第41项指标出现错误！");
						}
						break;
					}
				
				}
			}
			//按照农、工、理、经人分类进行量化
			Categoryquantization(41);
			System.out.println("更新第41项指标完成");
		
		}
		/**
		 * 4.1.2 教学经费分配比例及使用情况
		 * @param masList
		 */
		private void calculateF42() {
			
			List<Mas> masList = masService.findByAssessingNeedTargetNo(42);
			List<Map> mapList = calculateService.getAllstudentTrainNumMap();
			Iterator<Mas> im = masList.iterator();
			
			while(im.hasNext()){
				Mas mas = im.next();
				//总教学经费/总学生人数
				int count =0 ;
				Iterator<Map> ip = mapList.iterator();
				while(ip.hasNext()){				
					Map map = ip.next();
					float s = 0;
					if(mas.getMajor().getMno().equals(map.get("mno"))){
						Double c = (Double)map.get("totalTeachCostRatio");
					    System.out.println(c);
					    BigDecimal f = new BigDecimal(c);
						s = f.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
						mas.setAssessingScore(s);
						try {
							masService.update(mas);
						} catch (ServiceException e) {
							e.printStackTrace();
							System.out.println("更新第42项指标出现错误！");
						}
						break;
					}
				
				}
			}
			//按照农、工、理、经人分类进行量化
			Categoryquantization(42);
			System.out.println("更新第42项指标完成");
		}
		
		/**
		 * 4.4.1 现有教学实验室数量、面积，教学实验仪器设备（含软件）生均值等 
		 */
		private void calculateF47() {
			List<Mas> masList = masService.findByAssessingNeedTargetNo(47);
			List<Map> mapList = calculateService.getAllstudentTuiNumMap();
			Iterator<Mas> im = masList.iterator();
			
			while(im.hasNext()){
				Mas mas = im.next();
				//总学生人数
				int count =0 ;
				Iterator<Map> ip = mapList.iterator();
				while(ip.hasNext()){				
					Map map = ip.next();
					float s = 0;
					if(mas.getMajor().getMno().equals(map.get("mno"))){
						double c = (Double)map.get("equipmentMeanRatio");
					    System.out.println(c);
					    BigDecimal f = new BigDecimal(c);
						s = f.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
						mas.setAssessingScore(s);
						try {
							masService.update(mas);
						} catch (ServiceException e) {
							e.printStackTrace();
							System.out.println("更新第47项指标出现错误！");
						}
						break;
					}
				
				}
			}
			//按照农、工、理、经人分类进行量化
			Categoryquantization(47);
			System.out.println("更新第47项指标完成");
		
		}

		/**
		 * 4.4.2 近三年新增的教学实验仪器设备（含软件）生均值
		 * 
		 */
		private void calculateF48() {
			List<Mas> masList = masService.findByAssessingNeedTargetNo(48);
			List<Map> mapList = calculateService.getTraininguseinginformation();
//			System.out.println(mapList!=null);
//			System.out.println(mapList.size()!=0);
			
			if(mapList!=null){
				if(mapList.size()!=0){
					List<Map> fmapList = Function.Standard(mapList, "rate", A, 100, 0);
					Iterator<Mas> im = masList.iterator();
					while (im.hasNext()) {
						Mas mas = im.next();
						for (Map map : fmapList) {
							String mno = (String) map.get("mno");
							if (mas.getMajor().getMno().equals(mno)) {
								Double f = (Double) map.get("rate");
								BigDecimal b = new BigDecimal(f);
								double score = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
								System.out.println("第48项指标得分："+score);
								mas.setAssessingScore((float)score);
								break;
							}
						}
						try {
							masService.update(mas);
						} catch (ServiceException e) {
							System.out.println("更新第48项指标出现错误！");
							e.printStackTrace();
						}
					}
					
				}
			}
			System.out.println("更新第48项指标完成！");
		}

		/** 
		 * (1)4.4.3 近三年校外实习实践基地数量
		 * (2)4.4.3 近三年校外实习实践基地实习学生人次数
		 */
		private void calculateF4950(){
			//近三年校外实习实践基地数量
			List<Map> mapList1 = calculateService.getTrainingUseingInfo(1);
			if(mapList1!=null){
				if(mapList1.size()!=0){
					List<Map> mapResult1 =  Function.Standard(mapList1, "outBaseNumber", A, 100, 0);
					// 近三年校外实习实践基地满足率（根据Excel统计量化表计算）
					List<Map> mapList2 = calculateService.getTrainingUseingInfo(2);
					List<Map> mapResult2 =  Function.Standard(mapList2, "outBaseRate", A, 100, 0);
					
					List<Mas> masList = masService.findByAssessingNeedTargetNo(4950);
					Iterator<Mas> im = masList.iterator();
					while(im.hasNext()){
						Mas mas  = im.next();
						for(int i=0;i<mapResult1.size();i++){
							Map map1 = mapResult1.get(i);
							Map map2 = mapResult2.get(i);
							if(mas.getMajor().getMno().equals((String)map1.get("mno"))){
								Double s1 = (Double)map1.get("outBaseNumber")*0.5;
								Double s2 = (Double)map2.get("outBaseRate")*0.5;
								float score = (float)(s1+s2);
								mas.setAssessingScore(score);
								break;
							}
						}
						try {
							masService.update(mas);
						} catch (ServiceException e) {
							System.out.println("更新第4950项指标出现错误！");
							e.printStackTrace();
							
						}
					}
				}
			}
			System.out.println("更新第4950项指标完成！");
		}
		/**
		 * 4.5.1 现有专业纸质图书资料册数
		 * @param masList
		 */
		private void calculateF51() {
			List<Mas> masList = masService.findByAssessingNeedTargetNo(51);
			Iterator<Mas> im = masList.iterator();
			//此项指标未统计数据，因此按照100分计算
			float score = 100f;
			while(im.hasNext()){
				Mas mas = im.next();
				mas.setAssessingScore(score);
				try {
					masService.update(mas);
				} catch (ServiceException e) {
					e.printStackTrace();
					System.out.println("更新第51项指标出现错误！");
				}
			}
			System.out.println("更新第51项指标完成！");
		}

		/**
		 * 4.5.2 现有专业电子图书资料的个数
		 * @param masList
		 */
		private void calculateF52() {
			List<Mas> masList = masService.findByAssessingNeedTargetNo(52);
			Iterator<Mas> im = masList.iterator();
			//此项指标未统计数据，因此按照100分计算
			float score = 100f;
			while(im.hasNext()){
				Mas mas = im.next();
				mas.setAssessingScore(score);
				try {
					masService.update(mas);
				} catch (ServiceException e) {
					e.printStackTrace();
					System.out.println("更新第52项指标出现错误！");
				}
			}
			System.out.println("更新第52项指标完成！");
		}

		/**
		 * 5.2.3 实验教学内容与实验室开放情况
		 * @param masList
		 */
		private void calculateF58() {
			List<Mas> masList = masService.findByAssessingNeedTargetNo(58);
			List<Map> mapList = calculateService.getTrainingvenueuse();
			List<Map> fmapList = Function.Standard(mapList, "thHCount", A, 100, 0);
			Iterator<Mas> im = masList.iterator();
			while (im.hasNext()) {
				Mas mas = im.next();
				for (Map map : fmapList) {
					String mno = (String) map.get("mno");
					if (mas.getMajor().getMno().equals(mno)) {
						double f = (Double) map.get("thHCount");
						BigDecimal b = new BigDecimal(f);
						double score = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
						mas.setAssessingScore((float)score);
						System.out.println("第58项指标得分"+ score);
						break;
					}
				}
				try {
					masService.update(mas);
				} catch (ServiceException e) {
					System.out.println("更新第58项指标出现错误！");
					e.printStackTrace();
				}
			}
			System.out.println("更新第58项指标完成！");
		}
		/**
		 * 按照农、工、理、经人分类进行量化
		 * @param indicatorId 需要量化的指标
		 * （只有18，41，42，47需要进行分类量化）
		 */
		private void Categoryquantization(int indicatorId){
			List<Mas> masList = masService.findByAssessingNeedTargetNo(indicatorId);
			List<Majorclass> mcList = calculateService.getAllMajorclass();
			Iterator<Majorclass> imc = mcList.iterator();
			int i=0,j=0,x=0;
			while(imc.hasNext()){
				i++;
				Majorclass mc = imc.next();
				List<Map> mapList = masService.getMasScoreMap(indicatorId, mc.getClasscode());
				List<Map> fmapList = Function.Standard(mapList,"assessingScore", A, 100, 0);
				Iterator<Mas> im = masList.iterator();
				while (im.hasNext()) {
					Mas mas = im.next();
					for (Map map : fmapList) {
						String mno = (String) map.get("mno");
						if (mas.getMajor().getMno().equals(mno)) {
							double f = (Double) map.get("assessingScore");							
							BigDecimal b = new BigDecimal(f);
							double score = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
							System.out.println("s"+mno+"   "+score);
							mas.setAssessingScore((float)score);
							break;
						}
					}
					try {
						masService.update(mas);
					} catch (ServiceException e) {
						System.out.println("分类量化出现错误！");
						e.printStackTrace();
					}
				}
				
			}
		}
		/*************************** 2016-11-23添加系统缺失的统计方法——end **************************/
	
	
	
	public List<Teacherinfosummary> getTeacherinfosummaryList() {
		return teacherinfosummaryList;
	}

	public void setTeacherinfosummaryList(
			List<Teacherinfosummary> teacherinfosummaryList) {
		this.teacherinfosummaryList = teacherinfosummaryList;
	}

	public List<Teacherresearchsummary> getTeacherresearchsummaryList() {
		return teacherresearchsummaryList;
	}

	public void setTeacherresearchsummaryList(
			List<Teacherresearchsummary> teacherresearchsummaryList) {
		this.teacherresearchsummaryList = teacherresearchsummaryList;
	}

	public List<Studentculturesummary> getStudentculturesummaryList() {
		return studentculturesummaryList;
	}

	public void setStudentculturesummaryList(
			List<Studentculturesummary> studentculturesummaryList) {
		this.studentculturesummaryList = studentculturesummaryList;
	}

	public List<Practicecoursesummary> getPracticecoursesummaryList() {
		return practicecoursesummaryList;
	}

	public void setPracticecoursesummaryList(
			List<Practicecoursesummary> practicecoursesummaryList) {
		this.practicecoursesummaryList = practicecoursesummaryList;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setCalculateService(CalculateService calculateService) {
		this.calculateService = calculateService;
	}

	public CalculateService getCalculateService() {
		return calculateService;
	}

	public void setMasService(MasService masService) {
		this.masService = masService;
	}

	public MasService getMasService() {
		return masService;
	}

	public void setMasList(List<Mas> masList) {
		this.masList = masList;
	}

	public List<Mas> getMasList() {
		return masList;
	}

	public void setExpertscoreService(ExpertscoreService expertscoreService) {
		this.expertscoreService = expertscoreService;
	}

	public ExpertscoreService getExpertscoreService() {
		return expertscoreService;
	}

	public void setExpertscoreList(List<Expertscore> expertscoreList) {
		this.expertscoreList = expertscoreList;
	}

	public List<Expertscore> getExpertscoreList() {
		return expertscoreList;
	}

	public void setFuntionargsService(FuntionargsService funtionargsService) {
		this.funtionargsService = funtionargsService;
	}

	public FuntionargsService getFuntionargsService() {
		return funtionargsService;
	}

	public void setTeacherinfolastViewsList(
			List<TeacherinfolastView> teacherinfolastViewsList) {
		this.teacherinfolastViewsList = teacherinfolastViewsList;
	}

	public List<TeacherinfolastView> getTeacherinfolastViewsList() {
		return teacherinfolastViewsList;
	}

	public void setTeacherresearchsummaryViewsList(
			List<TeacherresearchsummaryView> teacherresearchsummaryViewsList) {
		this.teacherresearchsummaryViewsList = teacherresearchsummaryViewsList;
	}

	public List<TeacherresearchsummaryView> getTeacherresearchsummaryViewsList() {
		return teacherresearchsummaryViewsList;
	}

	public void setStudentculturesummaryViewsList(
			List<StudentculturesummaryView> studentculturesummaryViewsList) {
		this.studentculturesummaryViewsList = studentculturesummaryViewsList;
	}

	public List<StudentculturesummaryView> getStudentculturesummaryViewsList() {
		return studentculturesummaryViewsList;
	}

	public List<PracticecourseView> getPracticecourseViewList() {
		return practicecourseViewList;
	}

	public void setPracticecourseViewList(
			List<PracticecourseView> practicecourseViewList) {
		this.practicecourseViewList = practicecourseViewList;
	}
	public FileinfoattachmentService getFileinfoattachmentService() {
		return fileinfoattachmentService;
	}

	public void setFileinfoattachmentService(
			FileinfoattachmentService fileinfoattachmentService) {
		this.fileinfoattachmentService = fileinfoattachmentService;
	}

	public List<FileinfoAttachment> getFileinfoAttachmentList() {
		return fileinfoAttachmentList;
	}

	public void setFileinfoAttachmentList(
			List<FileinfoAttachment> fileinfoAttachmentList) {
		this.fileinfoAttachmentList = fileinfoAttachmentList;
	}

	public void setEffectqualityeducationService(
			EffectqualityeducationService effectqualityeducationService) {
		this.effectqualityeducationService = effectqualityeducationService;
	}

	public EffectqualityeducationService getEffectqualityeducationService() {
		return effectqualityeducationService;
	}

	public void setFulfillinginstanceService(FulfillinginstanceService fulfillinginstanceService) {
		this.fulfillinginstanceService = fulfillinginstanceService;
	}

	public FulfillinginstanceService getFulfillinginstanceService() {
		return fulfillinginstanceService;
	}

	public void setScoreViewList(List<ScoreView> scoreViewList) {
		ScoreViewList = scoreViewList;
	}

	public List<ScoreView> getScoreViewList() {
		return ScoreViewList;
	}

	public BaseModel getBasemodel() {
		return basemodel;
	}

	public void setBasemodel(BaseModel basemodel) {
		this.basemodel = basemodel;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public List<Major> getMajorList() {
		return majorList;
	}

	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}
	public void setScoreList(List<Score> scoreList) {
		this.scoreList = scoreList;
	}
	public List<Score> getScoreList() {
		return scoreList;
	}
	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	public ScoreService getScoreService() {
		return scoreService;
	}
	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}
	public String getErrstring() {
		return errstring;
	}
	public JSONArray getJsonArray1() {
		return jsonArray1;
	}
	public void setJsonArray1(JSONArray jsonArray1) {
		this.jsonArray1 = jsonArray1;
	}
	public JSONArray getJsonArray2() {
		return jsonArray2;
	}
	public void setJsonArray2(JSONArray jsonArray2) {
		this.jsonArray2 = jsonArray2;
	}
	public JSONArray getJsonArray3() {
		return jsonArray3;
	}
	public void setJsonArray3(JSONArray jsonArray3) {
		this.jsonArray3 = jsonArray3;
	}
	public JSONArray getJsonArray4() {
		return jsonArray4;
	}
	public void setJsonArray4(JSONArray jsonArray4) {
		this.jsonArray4 = jsonArray4;
	}
	public JSONArray getJsonArray5() {
		return jsonArray5;
	}
	public void setJsonArray5(JSONArray jsonArray5) {
		this.jsonArray5 = jsonArray5;
	}
	public JSONArray getJsonArray6() {
		return jsonArray6;
	}
	public void setJsonArray6(JSONArray jsonArray6) {
		this.jsonArray6 = jsonArray6;
	}
	public JSONArray getJsonArray7() {
		return jsonArray7;
	}
	public void setJsonArray7(JSONArray jsonArray7) {
		this.jsonArray7 = jsonArray7;
	}
	public JSONArray getJsonArray8() {
		return jsonArray8;
	}
	public void setJsonArray8(JSONArray jsonArray8) {
		this.jsonArray8 = jsonArray8;
	}
	public JSONArray getJsonArray9() {
		return jsonArray9;
	}
	public void setJsonArray9(JSONArray jsonArray9) {
		this.jsonArray9 = jsonArray9;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getMasprojectName() {
		return masprojectName;
	}
	public void setMasprojectName(String masprojectName) {
		this.masprojectName = masprojectName;
	}
	public JSONObject getJson() {
		return json;
	}
	public void setJson(JSONObject json) {
		this.json = json;
	}

	public void setAprojectService(AssessingprojectService aprojectService) {
		this.aprojectService = aprojectService;
	}

	public List<Assessingproject> getAprojectList() {
		return aprojectList;
	}

	public void setAprojectList(List<Assessingproject> aprojectList) {
		this.aprojectList = aprojectList;
	}
	
	
}
