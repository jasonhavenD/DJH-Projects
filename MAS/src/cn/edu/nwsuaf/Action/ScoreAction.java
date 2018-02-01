package cn.edu.nwsuaf.Action;

import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.Service.Impl.AssessingprojectService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.MasService;
import cn.edu.nwsuaf.Service.Impl.ScoreService;
import cn.edu.nwsuaf.bean.Assessingproject;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Majorclass;
import cn.edu.nwsuaf.bean.Score;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ScoreAction extends ActionSupport{
	private List<Majorclass> majorClassList;//专业类别
	private List<Major> majorList;// 专业
	private List<Assessingproject> projectList; //评估项目期
	private List<Score> scoreList;
	private BaseModel basemodel = new BaseModel();
	
	private ScoreService scoreService;
	private MajorService majorService;
	private MasService masService;
	private AssessingprojectService aprojectService;
	
	// 从前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private String category;
	private String major;
	private String pName;
	private String masprojectName;
	private String order;
	private String mc;//专业类别
	private JSONObject majorJson = new JSONObject();
	private JSONObject scoreJson = new JSONObject();
	/**
	 * 初始化查询，显示各专业得分
	 * @return
	 */
	public String initSearch() {
		String mno="";
		String dno="";
		try{
			mno=QueryUtil.getUserMno().getMajor().getInMno();
    		dno=QueryUtil.getUserMno().getDepartment().getDno();
			page=1;
			rows=10;
			basemodel=null;
			majorClassList = scoreService.findAllMajorClass();
			projectList = scoreService.findProject();
			majorList = majorService.findSummaryMajor(Major.class);
			scoreList=scoreService.findScoreListInit(page, rows);
			totalRows=scoreService.findCountScoreInit();
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
	/**
	 * 根据BaseModel多条件查询
	 * @return
	 */
	public String classifyFindScore() {
		System.out.println("findscore");
		String mno="";
		String dno="";
		try{
			mno=QueryUtil.getUserMno().getMajor().getInMno();
    		dno=QueryUtil.getUserMno().getDepartment().getDno();
    		majorClassList = scoreService.findAllMajorClass();
			projectList = scoreService.findProject();
			majorList = majorService.findSummaryMajor(Major.class);
			basemodel.setName(java.net.URLDecoder.decode(basemodel.getName(),"UTF-8"));
			majorList = majorService.findAll(Major.class);
			scoreList=scoreService.findScoreListByModel(basemodel, page, rows);
			totalRows=scoreService.findCountByModel(basemodel);
			
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
	/**
	 * 专业分类级联查询
	 * @return
	 */
	public String majorClassifyCascade(){
		List<Major> list = scoreService.findMajorByMC(mc);
		JSONArray jaName = new JSONArray();
		JSONArray jaMno = new JSONArray();
		Iterator<Major> im = list.iterator();
		while(im.hasNext()){
			Major m= im.next();
			jaName.add(m.getMname());
			jaMno.add(m.getMno());
		}
		majorJson.put("jaName", jaName);
		majorJson.put("jaMno", jaMno);
		return SUCCESS;
	}
	/**
	 * 分类查询柱状图初始化
	 * @return
	 */
	public String initGraphPage(){
		majorClassList = scoreService.findAllMajorClass();
		projectList = scoreService.findProject();
		return SUCCESS;
	}
	/**
	 * 分类查询柱状图数据
	 * @return
	 */
	public String findGraphData(){
		JSONArray jMname = new JSONArray();
		JSONArray jScore = new JSONArray();
		System.out.println(pName);
		if (pName == null || "".equals(pName)) {
			Assessingproject ap = aprojectService.findCurrentProject();
			pName = ap.getMasprojectName();
		}
		List<Score> list = scoreService.findGraphData(mc, pName);
		Iterator<Score> is = list.iterator();
		int num = Integer.parseInt(order);
		System.out.println("num:"+num);
		float average;
		float max;
		float min;
		switch(num){
		case 1:
			while(is.hasNext()){
				Score s = is.next();
				jMname.add(s.getMname());
				jScore.add(s.getFirstTarget());
			}
			scoreJson.put("jMname", jMname);
			scoreJson.put("jScore", jScore);
			average = scoreService.calculateAverage("firstTarget",mc, pName);
			max = scoreService.getMax("firstTarget",mc, pName);
			min = scoreService.getMin("firstTarget",mc, pName);
			scoreJson.put("average", average);
			scoreJson.put("max", max);
			scoreJson.put("min", min);
			break;
		case 2:
			while(is.hasNext()){
				Score s = is.next();
				jMname.add(s.getMname());
				jScore.add(s.getSecondTarget());
			}
			scoreJson.put("jMname", jMname);
			scoreJson.put("jScore", jScore);
			average = scoreService.calculateAverage("secondTarget",mc, pName);
			max = scoreService.getMax("secondTarget",mc, pName);
			min = scoreService.getMin("secondTarget",mc, pName);
			scoreJson.put("average", average);
			scoreJson.put("max", max);
			scoreJson.put("min", min);
			break;
		case 3:
			while(is.hasNext()){
				Score s = is.next();
				jMname.add(s.getMname());
				jScore.add(s.getThirdTarget());
			}
			scoreJson.put("jMname", jMname);
			scoreJson.put("jScore", jScore);
			average = scoreService.calculateAverage("thirdTarget",mc, pName);
			max = scoreService.getMax("thirdTarget",mc, pName);
			min = scoreService.getMin("thirdTarget",mc, pName);
			scoreJson.put("average", average);
			scoreJson.put("max", max);
			scoreJson.put("min", min);
			break;
		case 4:
			while(is.hasNext()){
				Score s = is.next();
				jMname.add(s.getMname());
				jScore.add(s.getFouthTarget());
			}
			scoreJson.put("jMname", jMname);
			scoreJson.put("jScore", jScore);
			average = scoreService.calculateAverage("fouthTarget",mc, pName);
			max = scoreService.getMax("fouthTarget",mc, pName);
			min = scoreService.getMin("fouthTarget",mc, pName);
			scoreJson.put("average", average);
			scoreJson.put("max", max);
			scoreJson.put("min", min);
			break;
		case 5:
			while(is.hasNext()){
				Score s = is.next();
				jMname.add(s.getMname());
				jScore.add(s.getFifthTarget());
			}
			scoreJson.put("jMname", jMname);
			scoreJson.put("jScore", jScore);
			average = scoreService.calculateAverage("fifthTarget",mc, pName);
			max = scoreService.getMax("fifthTarget",mc, pName);
			min = scoreService.getMin("fifthTarget",mc, pName);
			scoreJson.put("average", average);
			scoreJson.put("max", max);
			scoreJson.put("min", min);
			break;
		case 6:
			while(is.hasNext()){
				Score s = is.next();
				jMname.add(s.getMname());
				jScore.add(s.getSixthTarget());
			}
			scoreJson.put("jMname", jMname);
			scoreJson.put("jScore", jScore);
			average = scoreService.calculateAverage("sixthTarget",mc, pName);
			max = scoreService.getMax("sixthTarget",mc, pName);
			min = scoreService.getMin("sixthTarget",mc, pName);
			scoreJson.put("average", average);
			scoreJson.put("max", max);
			scoreJson.put("min", min);
			break;
		case 7:
			while(is.hasNext()){
				Score s = is.next();
				jMname.add(s.getMname());
				jScore.add(s.getSeventhTarget());
			}
			scoreJson.put("jMname", jMname);
			scoreJson.put("jScore", jScore);
			average = scoreService.calculateAverage("seventhTarget",mc, pName);
			max = scoreService.getMax("seventhTarget",mc, pName);
			min = scoreService.getMin("seventhTarget",mc, pName);
			scoreJson.put("average", average);
			scoreJson.put("max", max);
			scoreJson.put("min", min);
			break;
		case 8:
			while(is.hasNext()){
				Score s = is.next();
				jMname.add(s.getMname());
				jScore.add(s.getEightTarget());
			}
			scoreJson.put("jMname", jMname);
			scoreJson.put("jScore", jScore);
			average = scoreService.calculateAverage("eightTarget",mc, pName);
			max = scoreService.getMax("eightTarget",mc, pName);
			min = scoreService.getMin("eightTarget",mc, pName);
			scoreJson.put("average", average);
			scoreJson.put("max", max);
			scoreJson.put("min", min);
			break;
		case 9:
			while(is.hasNext()){
				Score s = is.next();
				jMname.add(s.getMname());
				jScore.add(s.getTotalScore());
			}
			scoreJson.put("jMname", jMname);
			scoreJson.put("jScore", jScore);
			average = scoreService.calculateAverage("totalScore",mc, pName);
			max = scoreService.getMax("totalScore",mc, pName);
			min = scoreService.getMin("totalScore",mc, pName);
			scoreJson.put("average", average);
			scoreJson.put("max", max);
			scoreJson.put("min", min);
			break;
		}
		return SUCCESS;
	}
	public List<Majorclass> getMajorClassList() {
		return majorClassList;
	}
	public void setMajorClassList(List<Majorclass> majorClassList) {
		this.majorClassList = majorClassList;
	}
	public List<Major> getMajorList() {
		return majorList;
	}
	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}
	
	public List<Assessingproject> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<Assessingproject> projectList) {
		this.projectList = projectList;
	}
	public List<Score> getScoreList() {
		return scoreList;
	}
	public void setScoreList(List<Score> scoreList) {
		this.scoreList = scoreList;
	}
	public BaseModel getBasemodel() {
		return basemodel;
	}
	public void setBasemodel(BaseModel basemodel) {
		this.basemodel = basemodel;
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
	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}
	public void setMasService(MasService masService) {
		this.masService = masService;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getPName() {
		return pName;
	}
	public void setPName(String pName) {
		this.pName = pName;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public JSONObject getMajorJson() {
		return majorJson;
	}
	public void setMajorJson(JSONObject majorJson) {
		this.majorJson = majorJson;
	}
	public JSONObject getScoreJson() {
		return scoreJson;
	}
	public void setScoreJson(JSONObject scoreJson) {
		this.scoreJson = scoreJson;
	}
	public void setAprojectService(AssessingprojectService aprojectService) {
		this.aprojectService = aprojectService;
	}
	public String getMasprojectName() {
		return masprojectName;
	}
	public void setMasprojectName(String masprojectName) {
		this.masprojectName = masprojectName;
	}
	
}
