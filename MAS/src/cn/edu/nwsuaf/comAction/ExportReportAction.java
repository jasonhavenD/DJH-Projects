package cn.edu.nwsuaf.comAction;

import cn.edu.nwsuaf.Model.ExportModel;
import cn.edu.nwsuaf.Service.Impl.AssessingprojectService;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.ExpertadviceService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.MasService;
import cn.edu.nwsuaf.Service.Impl.ScoreService;
import cn.edu.nwsuaf.bean.Assessingproject;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Expertadvice;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Majorclass;
import cn.edu.nwsuaf.bean.Majortoclass;
import cn.edu.nwsuaf.bean.Mas;
import cn.edu.nwsuaf.bean.Score;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.util.QueryUtil;
import com.opensymphony.xwork2.ActionSupport;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import javax.servlet.http.HttpServletResponse;

public class ExportReportAction extends ActionSupport {

	private MasService masService;
	private ScoreService scoreService;
	private DepartmentService departmentService;
	private MajorService majorService;
	private ExpertadviceService expertAdviceService;
	private AssessingprojectService aprojectService;
	private Configuration configuration = null;
	private String mno;
	private List<ExportModel> findList;
	private List<Department> departmentList;// 学院
	private List<Major> majorList;// 专业
	private HttpServletResponse response = null;// 创建一个HttpServletResponse对象

	/****************************报告信息查询-start************************************/
	public String initFindReportInfo(){	
		departmentList = departmentService.findAll(Department.class);
		majorList = majorService.findSummaryMajor(Major.class);
		if(isOpen()==true){
			try{
				String mymno=QueryUtil.getUserMno().getMajor().getInMno();
				String mydno=QueryUtil.getUserMno().getDepartment().getDno();
				if(!mymno.equals("000000")){
					mno = mymno;
				}else if(!mydno.equals("00000")&&mymno.equals("000000")){
					List<Major> ml = majorService.findMajorListByDepat(mydno);
					Iterator<Major> iml = ml.iterator();
					int tag = 0;
					while(iml.hasNext()){
						Major major = iml.next();
						if(major.getMno().equals(mno)){
							tag = 1;
						}
					}
					if(tag == 0){
						mno = ml.get(0).getMno();
					}
				}else{
					if("".equals(mno)|| mno==null){
						mno = "020101";
					}
				}
			}catch(Exception e){
				return ERROR;
			}
			
			//返回结果信息
			List<ExportModel> resultList = new ArrayList<ExportModel>();
			//存储一级指标信息
			List<ExportModel> emList = new ArrayList<ExportModel>();
			List<Mas> masList = (List<Mas>) masService.findByTargetAndMno("一级指标", mno);
			for(int i=0;i<masList.size();i++){
				Mas mas = masList.get(i);
				emList.add(getListData(mas,mno,i));
			}
			
			Iterator<ExportModel> iem = emList.iterator();
			while(iem.hasNext()){
				ExportModel em1 = iem.next();
				//合并一级指标信息
				resultList.add(em1);
				Iterator<ExportModel> iem2 = em1.getList().iterator();
				while(iem2.hasNext()){
					ExportModel em2 = iem2.next();
					//合并二级指标信息
					resultList.add(em2);
					Iterator<ExportModel> iem3 = em2.getList().iterator();
					while(iem3.hasNext()){
						ExportModel em3 = iem3.next();
						//合并三级指标信息
						resultList.add(em3);
					}
				}
			}
			setFindList(resultList);
		}else{
			setFindList(null);
		}
		return SUCCESS;
	}
	/**
	 * 根据一级指标查找该指标的子指标信息
	 * @param mas
	 * @param i 根据i查找排名
	 * @return
	 */
	private ExportModel getListData(Mas mas,String mno,int i){
		List<ExportModel> em1List = new ArrayList<ExportModel>();
		ExportModel em1 = new ExportModel();
		//查找该一级指标的所有二级指标信息
		String pID1 = mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorId();
		List<Mas> secondList = (List<Mas>)masService.findByPID(pID1,mno);
		Iterator<Mas> ims = secondList.iterator();
		//查找所有二级指标的三级指标信息
		while(ims.hasNext()){
			ExportModel em2 = new ExportModel();
			List<ExportModel> em2List = new ArrayList<ExportModel>();
			
			Mas mas2 = ims.next();
			String pID2 = mas2.getAssessingneedtarget().getAppraisalsystem().getIndicatorId();
			List<Mas> thirdList = (List<Mas>) masService.findByPID(pID2, mno);
			Iterator<Mas> imt = thirdList.iterator();
			while(imt.hasNext()){
				Mas mas3 = imt.next();
				ExportModel em3 = new ExportModel();
				setValue(em3,mas3,null);
				em2List.add(em3);
			}
			setValue(em2,mas2,em2List);
			em1List.add(em2);
		}
		//为一级指标设置排名值
		Assessingproject ap = aprojectService.findCurrentProject();
		em1.setRanking(getRank(i,mno,ap.getMasprojectName()));
		em1.setClassifyRanking(getClassRank(i,mno,ap.getMasprojectName()));
		setValue(em1,mas,em1List);
		
		return em1;
	}
	/**
	 * 获取八大项指标排名
	 * @param i
	 * @param mno
	 * @return
	 */
	private String getRank(int  i,String mno,String pName){
		Score score = scoreService.findBYMno(mno,pName);
		String ranking ="";
		switch(i){
		case 0:
			ranking = score.getFirstTargetRanking()+"";
			break;
		case 1:
			ranking = score.getSecondTargetRanking()+"";
			break;
		case 2:
			ranking = score.getThirdTargetRanking()+"";
			break;
		case 3:
			ranking = score.getFouthTargetRanking()+"";
			break;
		case 4:
			ranking = score.getFifthTargetRanking()+"";
			break;
		case 5:
			ranking = score.getSixthTargetRanking()+"";
			break;
		case 6:
			ranking = score.getSecondTargetRanking()+"";
			break;
		case 7:
			ranking = score.getEightTargetRanking()+"";
			break;	
		}
		return ranking;
	}
	/**
	 * 获取八大项指标按专业类别（工，农，理，经管人文）分类排名
	 * @param i
	 * @param mno
	 * @return
	 */
	private String getClassRank(int  i,String mno,String pName){
		Score score = scoreService.findBYMno(mno,pName);
		String ranking ="";
		switch(i){
		case 0:
			ranking = score.getFirstTargetRankingByClass()+"";
			break;
		case 1:
			ranking = score.getSecondTargetRankingByClass()+"";
			break;
		case 2:
			ranking = score.getThirdTargetRankingByClass()+"";
			break;
		case 3:
			ranking = score.getFouthTargetRankingByClass()+"";
			break;
		case 4:
			ranking = score.getFifthTargetRankingByClass()+"";
			break;
		case 5:
			ranking = score.getSixthTargetRankingByClass()+"";
			break;
		case 6:
			ranking = score.getSeventhTargetRankingByClass()+"";
			break;
		case 7:
			ranking = score.getEightTargetRankingByClass()+"";
			break;	
		}
		return ranking;
	}
	/**
	 * 将查找信息放入ExportModel中
	 * @param em 导出模型
	 * @param mas 
	 * @param list ExportModel中定义了一个自身的列表
	 */
	private void setValue(ExportModel em,Mas mas,List<ExportModel> list){
		em.setMname(mas.getMajor().getMname());
		em.setIndicatorName(mas.getAssessingneedtarget().getAppraisalsystem().getIndicatorName());
		float weight = mas.getAssessingneedtarget().getIndicatorWeight()*100;
		em.setIndicatorWeight((int)weight+"%");
		if("1".equals(mas.getAssessingneedtarget().getAppraisalsystem().getType())){
			em.setIndicatorType("定量");
		}else{
			em.setIndicatorType("定性");
		}
		int assId = mas.getAssessingneedtarget().getAssessingNeedTargetNo();
		em.setMax(masService.findMaxByAssessingNeedTargetNo(assId)+"");
		em.setMin(masService.findMinByAssessingNeedTargetNo(assId)+"");
		em.setAvg(masService.calByAssessingNeedTargetNo(assId)+"");
		float myscore = mas.getAssessingScore();
		myscore =((float)Math.round(myscore*100))/100;
		em.setScore(myscore+"");
		//em.setRanking(ranking);
		//em.setClassifyRanking(classifyRanking);
		em.setList(list);
	}
	/****************************报告信息查询-end************************************/
	
	
	
	
	/****************************报告信息导出-start**********************************/
	public ExportReportAction() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
	}
	
	public String createWorld() {
		if(isOpen() == true){
			//用户信息验证
			try{
				String mymno=QueryUtil.getUserMno().getMajor().getInMno();
				String mydno=QueryUtil.getUserMno().getDepartment().getDno();
				if(!mymno.equals("000000")){
					mno = mymno;
				}else if(!mydno.equals("00000")&&mymno.equals("000000")){
					List<Major> ml = majorService.findMajorListByDepat(mydno);
					Iterator<Major> iml = ml.iterator();
					int tag = 0;
					while(iml.hasNext()){
						Major major = iml.next();
						if(major.getMno().equals(mno)){
							tag = 1;
						}
					}
					if(tag == 0){
						mno = ml.get(0).getMno();
					}
				}else{
					if("".equals(mno)|| mno==null){
						mno = "020101";
					}
				}
			}catch(Exception e){
				return ERROR;
			}
			// 要填入模本的数据文件
			Map dataMap = new HashMap();
			getData(dataMap);
			// 设置模本装置方法和路径,FreeMarker支持多种模板装载方法。可以从servlet，classpath，数据库装载
			// 这里我们的模板是放在template包下面
			configuration.setClassForTemplateLoading(this.getClass(), "/template");
			Template t = null;
			try {
				// report.ftl为要装载的模板
				t = configuration.getTemplate("report.ftl");
				t.setEncoding("utf-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 创建一个HttpServletResponse对象
			HttpServletResponse response = null;
			// 创建一个输出流对象
			OutputStream out = null;
			Writer out1 = null;
			try {
				// 初始化HttpServletResponse对象
				response = ServletActionContext.getResponse();
				out = response.getOutputStream();
				// filename是下载的doc的名，建议最好用英文
				Major major = majorService.findMajorById(mno);
				String mname = major.getMname()+"专业数据分析报告";
				String fileName = URLEncoder.encode(mname, "utf-8");
				response.setHeader("Content-disposition","attachment; filename="+fileName+".doc");
				// 设置类型
				response.setContentType("application/msword;charset=UTF-8");
				// 设置头
				response.setHeader("Cache-Control", "no-cache");
				// 设置日期头
				response.setDateHeader("Expires", 0);
				out1 = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
				try {
					t.process(dataMap, out1);
					out1.close();
					out.close();
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		return null;
	}

	/**
	 * 注意dataMap里存放的数据Key值要与模板中的参数相对应
	 * 
	 * @param dataMap
	 */
	private void getData(Map dataMap) {
		/*************变量定义********************/
		String mname = "";
		String majorClass = "";
		String majorCount = "";
		//总分
		String totalScore_max = "";
		String totalScore_min = "";
		String totalScore_score = "";
		String totalScore_avg = "";
		String totalScore_ranking = "";
		String totalScore_rankingByClass = "";
		
		/*************************获取当前评估期项目*******************************/
		Assessingproject ap = aprojectService.findCurrentProject();
		
		/*************************专业基本信息赋值*********************************/
		//获取专业名称
		Major major = majorService.findMajorById(mno);
		mname = major.getMname();
		//获取专业类别
		String mtcHQL = "from Majortoclass as mtc where mtc.major.mno='"+mno+"'";
		Majortoclass mtc = (Majortoclass)QueryUtilDaoImpl.uniqueResult(mtcHQL, null);	
		majorClass = mtc.getMajorclass().getClassname();
		//专业所在类别包含的专业个数
		String mcbcHQL = " select count(*) from Majortoclass as mtc where mtc.majorclass.classcode='"+mtc.getMajorclass().getClasscode()+"'";
		long majorCountByClass = (Long)QueryUtilDaoImpl.uniqueResult(mcbcHQL, null);
		//将专业名称、专业代码、专业分类统一长度
		int length = Math.max(mname.length(), Math.max(majorClass.length(), mno.length()));
		this.formatString(mname, length);
		this.formatString(mno, length);
		this.formatString(majorClass, length);
		dataMap.put("mname", mname);
		dataMap.put("mno", mno);
		dataMap.put("majorClass", majorClass);
		dataMap.put("majorCountByClass", majorCountByClass+"");
		
		/**************************总分信息赋值*********************************/
		Score tempScore = scoreService.findBYMno(mno,ap.getMasprojectName());
		totalScore_score = tempScore.getTotalScore()+"";
		totalScore_ranking = tempScore.getTotalScoreRanking()+"";
		totalScore_rankingByClass = tempScore.getTotalTargetRankingByClass()+"";
		totalScore_max = scoreService.getMax("totalScore", null,tempScore.getMasprojectName())+"";
		totalScore_min = scoreService.getMin("totalScore", null,tempScore.getMasprojectName())+"";
		totalScore_avg = scoreService.calculateAverage("totalScore", null,tempScore.getMasprojectName())+"";
		dataMap.put("totalScore_max",totalScore_max);
		dataMap.put("totalScore_min",totalScore_min);
		dataMap.put("totalScore_avg",totalScore_avg);
		dataMap.put("totalScore_score",totalScore_score);
		dataMap.put("totalScore_ranking",totalScore_ranking);
		dataMap.put("totalScore_rankingByClass",totalScore_rankingByClass);
		
		/***************八大项指标列表(二级指标和三级指标信息包含在八大项指标中）*************/
		List<ExportModel> list ;
		//获取当前评估期一级指标
		List<Mas> masList = (List<Mas>) masService.findByTargetAndMno("一级指标", mno);
		for(int i=0;i<masList.size();i++){
			Mas mas = masList.get(i);
			ExportModel em = getListData(mas,mno,i);
			list = new ArrayList<ExportModel>();
			list.add(em);
			String keyName = "list_" + (i+1) ;
			dataMap.put(keyName, list);
			//为八大项指标最高得分，最低得分，本专业得分，全部专业排名，专业分类排名赋值
			switch(i){
			case 0:
				dataMap.put("firstTarget_max", em.getMax());
				dataMap.put("firstTarget_min", em.getMin());
				dataMap.put("firstTarget_score", em.getScore());
				dataMap.put("firstTarget_avg",em.getAvg());
				dataMap.put("firstTarget_ranking",em.getRanking());
				dataMap.put("firstTarget_RankingByClass",em.getClassifyRanking());
			case 1:
				dataMap.put("secondTarget_max",em.getMax());
				dataMap.put("secondTarget_min",em.getMin());
				dataMap.put("secondTarget_score",em.getScore());
				dataMap.put("secondTarget_avg",em.getAvg());
				dataMap.put("secondTarget_ranking",em.getRanking());
				dataMap.put("secondTarget_RankingByClass",em.getClassifyRanking());
			case 2:
				dataMap.put("thirdTarget_max",em.getMax());
				dataMap.put("thirdTarget_min",em.getMin());
				dataMap.put("thirdTarget_score",em.getScore());
				dataMap.put("thirdTarget_avg",em.getAvg());
				dataMap.put("thirdTarget_ranking",em.getRanking());
				dataMap.put("thirdTarget_RankingByClass",em.getClassifyRanking());
			case 3:
				dataMap.put("fouthTarget_max",em.getMax());
				dataMap.put("fouthTarget_min",em.getMin());
				dataMap.put("fouthTarget_score",em.getScore());
				dataMap.put("fouthTarget_avg",em.getAvg());
				dataMap.put("fouthTarget_ranking",em.getRanking());
				dataMap.put("fouthTarget_RankingByClass",em.getClassifyRanking());
			case 4:
				dataMap.put("fifthTarget_max",em.getMax());
				dataMap.put("fifthTarget_min",em.getMin());
				dataMap.put("fifthTarget_score",em.getScore());
				dataMap.put("fifthTarget_avg",em.getAvg());
				dataMap.put("fifthTarget_ranking",em.getRanking());
				dataMap.put("fifthTarget_RankingByClass",em.getClassifyRanking());
			case 5:	
				dataMap.put("sixthTarget_max",em.getMax());
				dataMap.put("sixthTarget_min",em.getMin());
				dataMap.put("sixthTarget_score",em.getScore());
				dataMap.put("sixthTarget_avg",em.getAvg());
				dataMap.put("sixthTarget_ranking",em.getRanking());
				dataMap.put("sixthTarget_RankingByClass",em.getClassifyRanking());
			case 6:
				dataMap.put("seventhTarget_max",em.getMax());
				dataMap.put("seventhTarget_min",em.getMin());
				dataMap.put("seventhTarget_score",em.getScore());
				dataMap.put("seventhTarget_avg",em.getAvg());
				dataMap.put("seventhTarget_ranking",em.getRanking());
				dataMap.put("seventhTarget_RankingByClass",em.getClassifyRanking());
			case 7:
				dataMap.put("eighthTarget_max",em.getMax());
				dataMap.put("eighthTarget_min",em.getMin());
				dataMap.put("eighthTarget_score",em.getScore());
				dataMap.put("eighthTarget_avg",em.getAvg());
				dataMap.put("eighthTarget_ranking",em.getRanking());
				dataMap.put("eighthTarget_RankingByClass",em.getClassifyRanking());
			}
		}
		
		/**********************专家意见和建议**************************************/
		List<Expertadvice> eaList = (List<Expertadvice>) expertAdviceService.searchByModel(mno, null);
		List<String> questionList = new ArrayList<String>();
		List<String> adviceList = new ArrayList<String>();
		for(int i=0;i<eaList.size();i++){
			String question = eaList.get(i).getQuestion();
			String advice = eaList.get(i).getAdvice();
			if(!"".equals(question) && !"无".equals(question) && question != null){
				questionList.add(question);
			}
			if(!"".equals(advice) && !"无".equals(advice) && advice != null){
				adviceList.add(advice);
			}

		}
		dataMap.put("questionList", questionList);
		dataMap.put("adviceList", adviceList);
		
		/************************总分及一级指标得分列表***********************/
		//获取已开启的评估项目
		String scoreHQL = "from Score as s where masprojectName = '"+ap.getMasprojectName()+"' order by s.totalScoreRanking";
		List<Score> scoreList = scoreService.findByHQL(scoreHQL);
		dataMap.put("scoreList", scoreList);
	}
	/**
	 * 将字符串转为固定长度且居中
	 * @param str
	 * @param length
	 */
	private void formatString(String str ,int length){
		if(length<10){
			length = 10;
		}
		int s = length-str.length();
		int h = s/2;
		for(int i=0;i<h;i++){
			str = " " + str;
		}
		for(int i=0;i<(s-h);i++){
			str += " ";
		}
		
	}
	/****************************报告信息导出-end**********************************/
	
	
	/** */
public String createDoc(){
		
		if(isOpen() == true){
			String sheetName = null;
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String[] tableHeader = null;
			tableHeader = new String[]{"指标名称","指标名称","指标权重","指标性质","最高分","最低分","平均分","本专业得分","总和排名","分类排名"};
			sheetName = "专业信息表";
			
			//目标list
			List<ExportModel> exportList = this.findList;
			int cellNumber = tableHeader.length;// 表的列数
			HSSFWorkbook workbook = new HSSFWorkbook(); // 创建一个excel
			HSSFCell cell = null; // Excel的列
			HSSFRow row = null; // Excel的行
			HSSFCellStyle style = workbook.createCellStyle(); // 设置表头的类型
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

			HSSFCellStyle style1 = workbook.createCellStyle(); // 设置表头的类型
			style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);

			HSSFFont font = workbook.createFont(); // 设置字体
			HSSFSheet sheet = workbook.createSheet(sheetName); // 创建一个sheet
			HSSFHeader header = sheet.getHeader();// 设置sheet的头

				row = sheet.createRow(0);
				row.setHeight((short) 400);
				for (int k = 0; k < cellNumber; k++) {
					cell = row.createCell(k);// 创建第0行第k列
					cell.setCellValue(tableHeader[k]);// 设置第0行第k列的值
					sheet.setColumnWidth(k, 8000);// 设置列的宽度
					font.setColor(HSSFFont.COLOR_NORMAL); // 设置单元格字体的颜色.
					font.setFontHeight((short) 350); // 设置单元字体高度
					style.setFont(font);// 设置字体风格
					cell.setCellStyle(style);
				}
						/*
						 * // 给excel填充数据这里需要编写
						 */
						for (int i = 0; i < exportList.size(); i++) {
							
							ExportModel model = (ExportModel) exportList.get(i);
							Object[] values = { 
									model.getMname(),
									model.getIndicatorName(),
									model.getIndicatorWeight(),
									model.getIndicatorType(),
									model.getMax(),
									model.getMin(),
									model.getAvg(),
									model.getScore(),
									model.getRanking(),
									model.getClassifyRanking()};
							row = sheet.createRow((short) (i + 1));// 创建第i+1行
							row.setHeight((short) 400);// 设置行高

							for (int m = 0; m < values.length; m++) {
								cell = row.createCell(m);// 创建第i+1行第0列
								if (values[m] instanceof Integer) {
									cell.setCellValue(Integer.parseInt(values[m]
											.toString()));
								} else {
									if(values[m] == null){
										values[m] =  "";
									}
									cell.setCellValue(values[m].toString());
								}// 设置第i+1行第0列的值
								cell.setCellStyle(style1);// 设置风格
							}
						}

				OutputStream out = null;// 创建一个输出流对象
				try {
					response = ServletActionContext.getResponse();// 初始化HttpServletResponse对象
					out = response.getOutputStream();//
					response.setHeader("Content-disposition", "attachment; filename="
							+ "export" + ".xls");// filename是下载的xls的名，建议最好用英文
					response.setContentType("application/msexcel;charset=UTF-8");// 设置类型
					response.setHeader("Pragma", "No-cache");// 设置头
					response.setHeader("Cache-Control", "no-cache");// 设置头
					response.setDateHeader("Expires", 0);// 设置日期头
					workbook.write(out);
					out.flush();
					workbook.write(out);
				} catch (IOException e) {
					// e.printStackTrace();
				} finally {
					try {
						if (out != null) {
							out.close();
						}
					} catch (IOException e) {
						// e.printStackTrace();
					}
				}
		}
		return null;
	}
	/**
	 * 判断当前评估期开启后是否将计算结果更新到score表
	 * @return
	 */
	private boolean isOpen(){
		Assessingproject aproject = aprojectService.findCurrentProject();
		System.out.println(aproject.getMasprojectName());
		majorList = majorService.findSummaryMajor(Major.class);
		Score score = scoreService.findBYMno(majorList.get(0).getMno(), aproject.getMasprojectName());
		if(score == null){
			return false;
		}else{
			return true;
		}
	}
	public void setMasService(MasService masService) {
		this.masService = masService;
	}

	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}
	public List<ExportModel> getFindList() {
		return findList;
	}
	public void setFindList(List<ExportModel> findList) {
		this.findList = findList;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
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
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public void setExpertAdviceService(ExpertadviceService expertAdviceService) {
		this.expertAdviceService = expertAdviceService;
	}
	public void setAprojectService(AssessingprojectService aprojectService) {
		this.aprojectService = aprojectService;
	}
	
}
