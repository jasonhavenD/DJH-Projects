package cn.edu.nwsuaf.Action;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.Service.Impl.AppraisalSystemService;
import cn.edu.nwsuaf.Service.Impl.AssessingneedtargetService;
import cn.edu.nwsuaf.Service.Impl.AssessingprojectService;
import cn.edu.nwsuaf.Service.Impl.ExpertscoreService;
import cn.edu.nwsuaf.Service.Impl.FileinfoattachmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.MasService;
import cn.edu.nwsuaf.bean.Appraisalsystem;
import cn.edu.nwsuaf.bean.Assessingneedtarget;
import cn.edu.nwsuaf.bean.Assessingproject;
import cn.edu.nwsuaf.bean.Expertscore;
import cn.edu.nwsuaf.bean.FileinfoAttachment;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Mas;
import cn.edu.nwsuaf.exception.ServiceException;

import com.opensymphony.xwork2.ActionSupport;

public class AssessingneedtargetAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Service
	private AssessingneedtargetService assneedService;
	private AppraisalSystemService appService;
	private AssessingprojectService aprojectService;
	private MajorService majorService;
	private MasService masService;
	private FileinfoattachmentService fiaService;//附件
	private ExpertscoreService expertscoreService;//专家打分
	
	// 传到前台下拉列表从数据库中读取显示
	private List<Assessingneedtarget> assneedList;// 项目评估所需指标列表
	private List<Appraisalsystem> appList;// 项目评估所需指标列表
	private List<Assessingproject> aprojectList;// 项目评估所需指标列表
	private List<Major> majorList;// 专业
	
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;		
	private Assessingneedtarget assneed;
	private Mas mas;
	private int  assessingNeedTargetNo;//编号
	private BaseModel basemodel=new BaseModel();
	private int rol;
	
	private Exception err;
	private JSONObject json = new JSONObject();
	
	
	public FileinfoattachmentService getFiaService() {
		return fiaService;
	}

	public void setFiaService(FileinfoattachmentService fiaService) {
		this.fiaService = fiaService;
	}

	public ExpertscoreService getExpertscoreService() {
		return expertscoreService;
	}

	public void setExpertscoreService(ExpertscoreService expertscoreService) {
		this.expertscoreService = expertscoreService;
	}

	public Exception getErr() {
		return err;
	}

	public void setErr(Exception err) {
		this.err = err;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	//初始化修改页面
	public String initEdit(){
		
		if ( assessingNeedTargetNo == 0) {
			assneed=null;
		} else {
				assneed = assneedService.findById(Assessingneedtarget.class,  assessingNeedTargetNo);
			
		}	
		return "success";
	}
	
	//修改or添加
	public String modifiassneed(){
		addAssessingNeedTarget(assneed);
		return "success";
	}
	/**
	 * 一键添加所有指标
	 * @return
	 */
	public String addAllAssessingNeedTarget(){
		List<Assessingneedtarget> assList = assneedService.findAssessingNeedTargetByDate();
		if(assList == null || assList.size()==0){
		Assessingproject aproject = aprojectService.findCurrentProject();
		List<Appraisalsystem> appList = (List<Appraisalsystem>)appService.findAll(Appraisalsystem.class);
		Iterator<Appraisalsystem> iapp = appList.iterator();
		while(iapp.hasNext()){
			Appraisalsystem app = iapp.next();
			Assessingneedtarget assessingNeedTarget = new Assessingneedtarget();
			assessingNeedTarget.setAssessingNeedTargetNo(0);
			assessingNeedTargetNo=0;
			assessingNeedTarget.setAssessingproject(aproject);
			assessingNeedTarget.setAppraisalsystem(app);
			float indicatorWeight = assneedService.findByIndicatorIdAndProName(app.getIndicatorId(), "第一期").getIndicatorWeight();
			assessingNeedTarget.setIndicatorWeight(indicatorWeight);
			assessingNeedTarget.setStatus(1);
			addAssessingNeedTarget(assessingNeedTarget);
		}
		}else{
			System.out.println("当前评估期已经添加了"+assList.size()+"个指标，请删除后进行一键添加所有指标！");
		}
		return SUCCESS;
	}
	/**
	 * 添加评估所需指标
	 * @param assneed
	 */
	private void addAssessingNeedTarget(Assessingneedtarget assneed){
		try {
			if(assessingNeedTargetNo==0){
				assneedService.save(assneed);
				//majorList=majorService.findByHQL("from Major as m where m.mname<>'其他' and m.enrollmentState='在招'");
				majorList=majorService.findSummaryMajor(Major.class);
				System.out.println("测试："+majorList.size());
				for(Major major : majorList){
					Mas mas=new Mas();
					mas.setMajor(major);
					mas.setAssessingneedtarget(assneed);
					mas.setAssessingScore((float)0.0);
					masService.save(mas);
					List<Appraisalsystem> appList;
					appList=appService.findByHQL("from Appraisalsystem as app where app.type='0'");//指标
					System.out.println("循环开始");
					for(Appraisalsystem app : appList){
						System.out.println("assneed"+assneed.getAppraisalsystem().getIndicatorId());
						System.out.println("app"+app.getIndicatorId());
						System.out.println(assneed.getAppraisalsystem().getIndicatorId().equals(app.getIndicatorId()));
						if(assneed.getAppraisalsystem().getIndicatorId().equals(app.getIndicatorId()))
							{
								System.out.println("进入fa");
								FileinfoAttachment fa=new FileinfoAttachment();
								int code=masService.findByHQL("from Mas where major.mno='"+major.getMno()+"' and assessingneedtarget.assessingNeedTargetNo='"+assneed.getAssessingNeedTargetNo()+"'").get(0).getMasCode();
								Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
								int year = c.get(Calendar.YEAR); 
								fa.setYear(""+year);
								fa.setAttachmentId(year+""+code);
								fa.setMas(masService.findByHQL("from Mas where major.mno='"+major.getMno()+"' and assessingneedtarget.assessingNeedTargetNo='"+assneed.getAssessingNeedTargetNo()+"'").get(0));
								fa.setUploadStatus(0);
								System.out.println("savefa");
								fiaService.save(fa);
								break;
							}						
					}
				}
			}else{
				assneedService.update(assneed);
			}
		} catch (Exception e) {
			System.out.println("添加评估指标出错！");;
		}
	}
	//删除
	public String deleteassneed(){
		try {
			Assessingneedtarget ass=new Assessingneedtarget();
			ass=assneedService.findById(Assessingneedtarget.class,  assessingNeedTargetNo);
			majorList=majorService.findByHQL("from Major as m where m.mname<>'其他' and m.enrollmentState='在招'");
			for(Major major : majorList){
					Mas mas=new Mas();
					mas=masService.findByHQL("from Mas where major.mno='"+major.getMno()+"' and assessingneedtarget.assessingNeedTargetNo='"+assessingNeedTargetNo+"'").get(0);
					FileinfoAttachment fa=new FileinfoAttachment();
					if(fiaService.findByHQL("from FileinfoAttachment where mas.masCode="+mas.getMasCode()).size()!=0)
					{
						fa=fiaService.findByHQL("from FileinfoAttachment where mas.masCode="+mas.getMasCode()).get(0);
						fiaService.delete(fa);
					}
					masService.delete(mas);
			}
			assneedService.delete(ass);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
			
		}
		
		return "success";
	}
	// 初始化信息，用于页面显示数据库中信息
	public String initSearch() {
		try {
			page=1;
			rows=10;
			basemodel=null;
			appList=appService.findAll(Appraisalsystem.class);
			aprojectList=aprojectService.findProjectDesc();
			assneedList = assneedService.findallAssNeedTargetList(page, rows);
			totalRows =  assneedService.findAll(Assessingneedtarget.class).size();
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println(totalPage);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";

	}
	public String findassneed() {
		try {
			basemodel.setName(java.net.URLDecoder.decode(basemodel.getName(),"UTF-8"));
			basemodel.setYear(java.net.URLDecoder.decode(basemodel.getYear(),"UTF-8"));
			assneedList =assneedService.findAssNeedTargetList(basemodel, page, rows);
			totalRows = assneedService.countFindAssNeedTarget(basemodel);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println(totalPage);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}

	/**
	 * 显示指标思维导图
	 * @return
	 */
	public String showTarget(){
		JSONArray jsonId = new JSONArray();
		JSONArray jsonPId = new JSONArray();
		JSONArray jsonName = new JSONArray();
		List<Assessingneedtarget> list = assneedService.findAssessingNeedTargetByDate();
		Iterator<Assessingneedtarget> ia = list.iterator();
		while(ia.hasNext()){
			Assessingneedtarget ass = ia.next();
			jsonId.add(ass.getAppraisalsystem().getIndicatorId());
			jsonPId.add(ass.getAppraisalsystem().getPid());
			String name = ass.getAppraisalsystem().getIndicatorName();
			if(name.length()>23){
				name = name.substring(0, 20)+"...";
			}
			name += " — "+ass.getIndicatorWeight();
			jsonName.add(name);
		}
		json.put("jsonId",jsonId);
		json.put("jsonPId",jsonPId);
		json.put("jsonName", jsonName);
		return SUCCESS;
	}

	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public MasService getMasService() {
		return masService;
	}

	public void setMasService(MasService masService) {
		this.masService = masService;
	}

	public List<Major> getMajorList() {
		return majorList;
	}

	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}

	public Mas getMas() {
		return mas;
	}

	public void setMas(Mas mas) {
		this.mas = mas;
	}

	public AssessingneedtargetService getAssneedService() {
		return assneedService;
	}

	public void setAssneedService(AssessingneedtargetService assneedService) {
		this.assneedService = assneedService;
	}

	public AppraisalSystemService getAppService() {
		return appService;
	}

	public void setAppService(AppraisalSystemService appService) {
		this.appService = appService;
	}

	public AssessingprojectService getAprojectService() {
		return aprojectService;
	}

	public void setAprojectService(AssessingprojectService aprojectService) {
		this.aprojectService = aprojectService;
	}

	public List<Assessingneedtarget> getAssneedList() {
		return assneedList;
	}

	public void setAssneedList(List<Assessingneedtarget> assneedList) {
		this.assneedList = assneedList;
	}

	public List<Appraisalsystem> getAppList() {
		return appList;
	}

	public void setAppList(List<Appraisalsystem> appList) {
		this.appList = appList;
	}

	public List<Assessingproject> getAprojectList() {
		return aprojectList;
	}

	public void setAprojectList(List<Assessingproject> aprojectList) {
		this.aprojectList = aprojectList;
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

	public Assessingneedtarget getAssneed() {
		return assneed;
	}

	public void setAssneed(Assessingneedtarget assneed) {
		this.assneed = assneed;
	}

	public int getAssessingNeedTargetNo() {
		return assessingNeedTargetNo;
	}

	public void setAssessingNeedTargetNo(int assessingNeedTargetNo) {
		this.assessingNeedTargetNo = assessingNeedTargetNo;
	}

	public BaseModel getBasemodel() {
		return basemodel;
	}

	public void setBasemodel(BaseModel basemodel) {
		this.basemodel = basemodel;
	}

	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}

}
