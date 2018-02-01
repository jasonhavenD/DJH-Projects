package cn.edu.nwsuaf.Action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.Model.ExpertModel;
import cn.edu.nwsuaf.Model.MajorModel;
import cn.edu.nwsuaf.Service.Impl.AppraisalSystemService;
import cn.edu.nwsuaf.Service.Impl.AssessingneedtargetService;
import cn.edu.nwsuaf.Service.Impl.AssessingprojectService;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.ExpertService;
import cn.edu.nwsuaf.Service.Impl.ExpertmajorService;
import cn.edu.nwsuaf.Service.Impl.ExpertscoreService;
import cn.edu.nwsuaf.Service.Impl.FileinfoattachmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.MasService;
import cn.edu.nwsuaf.bean.Appraisalsystem;
import cn.edu.nwsuaf.bean.Assessingneedtarget;
import cn.edu.nwsuaf.bean.Assessingproject;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Expert;
import cn.edu.nwsuaf.bean.Expertmajor;
import cn.edu.nwsuaf.bean.Expertscore;
import cn.edu.nwsuaf.bean.FileinfoAttachment;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Mas;
import cn.edu.nwsuaf.bean.Sysuserinfo;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class ExpertmajorAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8735034622954711087L;
	
	// Service
	private ExpertService expertService;//用户
	private DepartmentService departmentService;//学院
	private MajorService majorService;//专业
	private ExpertmajorService expertmajorService;//专家专业
	private AppraisalSystemService appService;//指标
	private AssessingneedtargetService assneedService;//评估所需指标
	private MasService masService;//指标统计
	private FileinfoattachmentService fiaService;//附件
	private ExpertscoreService expertscoreService;//专家打分
	private AssessingprojectService assessingprojectService;
	
	
	// 传到前台下拉列表从数据库中读取显示
	private List<Major> majorList;// 专业列表
	private List<Major> majorListfind;// 查询处专业列表
	private List<BaseModel> expertmajorList ;//专业专家列表
	private ArrayList<Expertmajor> expertmajorLists;  
	private List<Department> departmentList;// 学院	
	private List<Appraisalsystem> appList;//指标
	private List<Expert> expertList;// 专家
	private String expertName;
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private int tpage = 1;
	private int trows = 10;

	private Major major;
	private Expertmajor expertmajor;
	private Expert userinfo;
	private String mno;
	private String expertCode;
	private int expertMajorCode;
	private Assessingproject ap;
	
	//错误提示
	private Exception err;
	private String errormsg;
	private String successmsg;
	
	//错误提示
	private String errstring;
	
	private MajorModel majormodel=new MajorModel();
	private BaseModel basemodel=new BaseModel();
	
	//ajax专家组，专业组
	private HashMap<String,Object> map;
	private HashMap<String,Object> mapexpert;
	private String expertid;
	private String addValue;
	private List<String> mnameList;
	private List<String> expertnameList;
	private String groupmname;
	private String expertname;
	private List<BaseModel> expertgroupList ;//专家组
	private List<Major> majorListgroup;// 专业组
	
	//取消所有分配
	public String deleteAllExpertmajor(){
		expertmajorService.deleteAll();
		return "success";
	}
	//分配方式
	public String addType() {
		page = 1;
		rows = 10;
		expertName="";
		mno="";
		Sysuserinfo sysuserinfo = QueryUtil.getUserMno();
		departmentList  = departmentService.findAll(Department.class);
		majorListfind = expertscoreService.findMajorList(sysuserinfo, false);
		String hqlString="from Expertmajor as em where em.assessingproject.tag = '1' order by em.major.mname asc";
		expertmajorLists = (ArrayList<Expertmajor>) QueryUtilDaoImpl.executeQueryByPage(hqlString, null, null, page, rows);

       ArrayList<Expertmajor> expertmajorLists2 = (ArrayList<Expertmajor>)expertmajorService.findByHQL(hqlString);
		     
		     System.out.println(expertmajorLists2.size());
			 totalRows = expertmajorLists2.size();
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
	     System.out.println("size:"+expertmajorLists.size());
		return "success";
	}
	
	
	// 选择组，初始化信息，用于页面显示数据库中信息
	public String groupInitSearch() {
		String mno="";
		String dno="";
		try{
			mno=QueryUtil.getUserMno().getMajor().getInMno();
    		dno=QueryUtil.getUserMno().getDepartment().getDno();
        }catch(Exception e){
        	setErrstring("登录超时！请安全退出再重新登录！");
        	return "errorstring";
        }
		majormodel=null;
		majorListgroup=new ArrayList<Major>();
		mnameList=new ArrayList<String>();
		groupmname="";
		page=1;
		rows=10;
		try {
			departmentList = departmentService.findAll(Department.class);
			majorListfind = majorService.findAll(Major.class);
			majorList = majorService.getAllMajorListByPage(page,rows,mno,dno);	
			List<Major> flagmajorList =new ArrayList<Major>();// 中间替换
			for(Major m1:majorList){
				Major m=new Major();
				m=m1;
				m.setTag(0);
				flagmajorList.add(m);
			}
			majorList=flagmajorList;
			System.out.println("majorList"+majorList.size());
			totalRows =  majorService.findAll(Major.class).size();
			System.out.println("init"+totalRows);	
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
	//查找专业
	public String groupfind() {
		String mno="";
		String dno="";
		try{
			mno=QueryUtil.getUserMno().getMajor().getInMno();
    		dno=QueryUtil.getUserMno().getDepartment().getDno();
        }catch(Exception e){
        	setErrstring("登录超时！请安全退出再重新登录！");
        	return "errorstring";
        }
		try {
			departmentList = departmentService.findAll(Department.class);
			majorListfind = majorService.findAll(Major.class);
			if(!mno.equals("000000")){
				majormodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				majormodel.setDepartmentId(dno);
			}
			if(majormodel==null){
				majormodel=new MajorModel();
				majormodel.setMajorId("");
				majormodel.setYear(null);
				majormodel.setMno(null);
				majormodel.setDisciplinetype(null);
				majormodel.setMajortype(null);
				majormodel.setMajorcategory(null);
				majormodel.setEnrollmentState(null);
				majormodel.setDepartmentId(null);
			}
			majorList = majorService.findMajorList(majormodel, page, rows);
			System.out.println("majorList.size()"+majorList.size());
			List<Major> flagmajorList =new ArrayList<Major>();// 中间替换
			for(Major m1:majorList){
				Major m=new Major();
				m=m1;
				if(majorListgroup.size()==0){
					m.setTag(0);
				}else{
					for(Major m2:majorListgroup){
						if(m1.getMno().equals(m2.getMno())){						
							m.setTag(1);
							break;
						}else{
							m.setTag(0);
						}
					}
				}
				flagmajorList.add(m);
			}
			System.out.println("flagmajorList.size()"+flagmajorList.size());
			majorList.clear();
			majorList=flagmajorList;
			totalRows = majorService.countFindMajor(majormodel);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println("page"+totalPage);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	//添加专业到组
	public String groupAddMajor() {
		map=new HashMap<String, Object>();
		try {
			Major m=majorService.findById(Major.class, mno);
			System.out.println("addValue"+addValue);
			if(addValue.equals("添加到专业组")){
				System.out.println("添加到专业组");
				majorListgroup.add(m);
				mnameList.add(m.getMname()+";   ");
				addValue="从专业组移除";
			}else{
				System.out.println("从专业组移除");
				majorListgroup.remove(m);
				mnameList.remove(m.getMname()+";   ");
				addValue="添加到专业组";	
			}
			System.out.println("majorListgroup.size()  "+majorListgroup.size());
			
			groupmname="";
			for(String s:mnameList){
				groupmname+=s;
			}
			map.put("mname", groupmname);
			map.put("addValue", addValue);
			map.put("id", mno);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	//初始化按组添加专家页面
    @SuppressWarnings("unchecked")
	public String groupAddExpert(){
    	basemodel=null;
    	expertname="";
    	expertnameList=new ArrayList<String>();
    	expertmajorList=new ArrayList<BaseModel>(); 
    	expertgroupList=new ArrayList<BaseModel>(); 
    	page=1;
		rows=10;
    	try{
    		List<Expert> user=(List<Expert>) QueryUtilDaoImpl
			.executeQueryByPage("from Expert", null, page, rows);
    		for(Expert u :user){
    			BaseModel base=new BaseModel();
    			base.setId(u.getExpertId());
				base.setName(u.getExpertName());
    			base.setYear("0");//用baseModel中year表示专家是否存在
    			expertmajorList.add(base);
    		}
    		totalRows =  expertService.findByHQL("from Expert").size();
			System.out.println("init"+totalRows);	
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
    	}catch (Exception e) {
			
			return "error";
		}
		return "success";  	
}
    //按组查找专家
	public String groupFindExpert() {
		try {
			List<BaseModel> newExpertList=new ArrayList<BaseModel>();
			if(basemodel==null){
				basemodel=new BaseModel();
				basemodel.setId("");
				basemodel.setName("");
				basemodel.setYear(null);
			}else if(basemodel.getName()!=null){
				basemodel.setYear(null);
				basemodel.setName(java.net.URLDecoder.decode(basemodel.getName(),"UTF-8"));
			}
			expertList = expertmajorService.findExpertList(basemodel, mno, page, rows);
			for(Expert u :expertList){
    			BaseModel base=new BaseModel();
    			base.setId(u.getExpertId());
				base.setName(u.getExpertName());
				for(BaseModel e :expertmajorList){	    				
    				if(e.getId().equals(u.getExpertId())&&e.getYear().equals("1")){
    					base.setYear("1");//用baseModel中year表示专家是否存在
    					break;
    				}
    				else{
    					base.setYear("0");
    				}    				
    			}   			 			
				newExpertList.add(base);
    		}
			expertmajorList.clear();
			expertmajorList=newExpertList;
			totalRows = expertmajorService.countFindExpert(basemodel, mno);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println("page"+totalPage);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	//添加专家到组
	public String addExpertToGroup() {
		mapexpert=new HashMap<String, Object>();
		try {
			BaseModel base=new BaseModel();
			for(BaseModel e :expertmajorList){	    				
				if(e.getId().equals(expertid)){
	    			base.setId(e.getId());
					base.setName(e.getName());
					base.setYear(e.getYear());
					break;
				}  				
			}   
			System.out.println("addValue"+addValue);
			if(base.getYear().equals("0")&& addValue.equals("添加到专家组")){
				System.out.println("添加到专家组");
				base.setYear("1");
				expertgroupList.add(base);
				expertnameList.add(base.getName()+";   ");
				addValue="从专家组移除";
			}else{
				System.out.println("从专家组移除");
				base.setYear("0");
				expertgroupList.remove(base);
				expertnameList.remove(base.getName()+";   ");
				addValue="添加到专家组";	
			}
			System.out.println("expertgroupList.size()"+expertgroupList.size());
			expertname="";
			for(String s:expertnameList){
				expertname+=s;
			}
			mapexpert.put("expertname", expertname);
			mapexpert.put("addValue", addValue);
			mapexpert.put("id", expertid);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	//按组分配专家专业
	public String groupMajorToExpert(){
		errormsg="";
		successmsg="";
		try {	
			List<Expertmajor> nemList=expertmajorService.findByTag();
			List<Expertmajor> resultList=new ArrayList<Expertmajor>();
			System.out.println("nemList.size()"+nemList.size());
			System.out.println("expertgroupList.size()"+expertgroupList.size());
			System.out.println("majorListgroup.size()"+majorListgroup.size());
			int flag=0;
			for(Major m:majorListgroup){
				for(BaseModel b:expertgroupList){
					flag=0;
					if(nemList.size()!=0){
						for(Expertmajor nem:nemList){
							System.out.println("nem.getMajor().getMno()"+nem.getMajor().getMno());
							System.out.println("m.getMno()"+m.getMno());
							System.out.println("nem.getExpert().getExpertId()"+nem.getExpert().getExpertId());
							System.out.println("b.getId()"+b.getId());
							if(nem.getMajor().getMno().equals(m.getMno()) && nem.getExpert().getExpertId().equals(b.getId())){
								errormsg+="专家"+b.getName()+"已经分配给"+m.getMname()+"专业；<br/>";
								flag=1;
								break;
							}
						}
					}
					if(flag==0){
						successmsg+="专家"+b.getName()+"成功分配给"+m.getMname()+"专业；<br/>";
						Expertmajor newem=new Expertmajor();
						Expert uinfo=new Expert();
						uinfo=expertService.findById(Expert.class, b.getId());
						Assessingproject ap = assessingprojectService.findCurrentProject();
						newem.setMajor(m);
						newem.setExpert(uinfo);
						newem.setAssessingproject(ap);
						System.out.println(ap);
						expertmajorService.save(newem);
						resultList.add(newem);
					}
				}
			}
			if(errormsg.equals("")){
				errormsg="无；";
			}
			if(successmsg.equals("")){
				successmsg="无；";
			}
			//更新打分表  改用数据库触发器操作
//			appList=appService.findByHQL("from Appraisalsystem as app where app.type='0'");//指标
//			List<Assessingneedtarget> assneedList =new ArrayList<Assessingneedtarget>();//评估所需指标
//			List<Mas> masList =new ArrayList<Mas>();//指标统计
//			List<Mas> masListspecial =new ArrayList<Mas>();//指标统计
//			List<FileinfoAttachment> fiaList =new ArrayList<FileinfoAttachment>();//附件
//			List<Assessingneedtarget> assneedListall=assneedService.findAll(Assessingneedtarget.class);
//			System.out.println("assneedListall "+assneedListall.size()+" "+appList.size());
//			
//			for(Assessingneedtarget an :assneedListall){
//				Assessingneedtarget base=new Assessingneedtarget();
//    			
//    			for(Appraisalsystem ap :appList){
//    				if(ap.getIndicatorId().equals(an.getAppraisalsystem().getIndicatorId())){
//    	    			base.setAssessingNeedTargetNo(an.getAssessingNeedTargetNo());
//    					
//    					assneedList.add(base);
//    					//评估所需指标
//    					
//    					break;
//    				}   				
//    			}
//    			System.out.println("end,assneedList");
//    		}
//			System.out.println("get,assneedList");
//			List<Mas> masListall=masService.findAll(Mas.class);//指标统计
//			System.out.println("get,masListall"+masListall.size());
//			int n=0;
//			for(Mas ma :masListall){
//				Mas base=new Mas();
//				n=n+1;
//    			for(Assessingneedtarget ant :assneedList){
//    				
//    				if(ant.getAssessingNeedTargetNo().equals(ma.getAssessingneedtarget().getAssessingNeedTargetNo())){	
//    					base.setMasCode(ma.getMasCode());
//    					base.setMajor(ma.getMajor());
//    					System.out.println("进入add"+n+"  "+base.getMasCode()+"  "+base.getMajor().getMno());
//    					masListspecial.add(base);//指标统计
//    					System.out.println("结束add"+n);
//    				}   				
//    			}
//    		}
//			System.out.println("get,masListspecial");
//			for(Mas m : masListspecial){
//				Mas base=new Mas();
//    			base=m;
//				if(m.getMajor().getMno().equals(mno)){
//					masList.add(base);//指标统计
//				}
//			}
//			System.out.println("get,masList"+masList.size());
//			List<FileinfoAttachment> fiaListall=fiaService.findAll(FileinfoAttachment.class);//附件
//			System.out.println("get,fiaListall");
//			for(FileinfoAttachment fa :fiaListall){
//				FileinfoAttachment base=new FileinfoAttachment();
//    			base=fa;
//    			for(Mas ma :masList){
//    				
//    				if(ma.getMasCode().equals(fa.getMas().getMasCode())){
//    					fiaList.add(base);//附件
//    					break;
//    				}   				
//    			}
//    		}
//			System.out.println("get,fiaList"+fiaList.size());
//			for(FileinfoAttachment fa :fiaList){
//				for(Expertmajor emajor:resultList){
//					Expertscore base=new Expertscore();
//	    			base.setFileinfoAttachment(fa);
//	    			base.setExpert(emajor.getExpert());
//	    			expertscoreService.save(base);
//				}
//    		}
//			System.out.println("end");
		} catch (Exception e) {
			e.printStackTrace();
			//return "error";
	}
//		
		return "success";
	}
	// 初始化单一分配专业信息列表
	public String initSearch() {
		String mno="";
		String dno="";
		try{
			mno=QueryUtil.getUserMno().getMajor().getInMno();
    		dno=QueryUtil.getUserMno().getDepartment().getDno();
        }catch(Exception e){
        	setErrstring("登录超时！请安全退出再重新登录！");
        	return "errorstring";
        }
		majormodel=null;
		page=1;
		rows=10;
		try {
			departmentList = departmentService.findAll(Department.class);
			majorListfind = majorService.findAll(Major.class);
			majorList = majorService.getAllMajorListByPage(page,rows,mno,dno);	
			System.out.println("majorList"+majorList.size());
			totalRows =  majorService.findAll(Major.class).size();
			System.out.println("init"+totalRows);	
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (Exception e) {			
			return "error";
		}
		return "success";
	}
	//查找单一分配专业信息列表
	public String find() {
		String mno="";
		String dno="";
		try{
			mno=QueryUtil.getUserMno().getMajor().getInMno();
    		dno=QueryUtil.getUserMno().getDepartment().getDno();
        }catch(Exception e){
        	setErrstring("登录超时！请安全退出再重新登录！");
        	return "errorstring";
        }
		try {
			departmentList = departmentService.findAll(Department.class);
			majorListfind = majorService.findAll(Major.class);
			if(!mno.equals("000000")){
				majormodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				majormodel.setDepartmentId(dno);
			}
			if(majormodel==null){
				majormodel=new MajorModel();
				majormodel.setMajorId("");
				majormodel.setYear(null);
				majormodel.setMno(null);
				majormodel.setDisciplinetype(null);
				majormodel.setMajortype(null);
				majormodel.setMajorcategory(null);
				majormodel.setEnrollmentState(null);
				majormodel.setDepartmentId(null);
			}
			majorList = majorService.findMajorList(majormodel, page, rows);
			totalRows = majorService.countFindMajor(majormodel);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println("page"+totalPage);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	public String getErrstring() {
		return errstring;
	}
	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}
	
	//查找专家 任务分配初始界面 汇总
	
	@SuppressWarnings("unchecked")
	public String findExperts() {
		try {
			ArrayList<Expertmajor> expertmajorLists2; 
		     String hqlString="from Expertmajor as em where em.assessingproject.tag = '1' and em.major.mno='"+mno+"'"+" and em.expert.expertName like '%"+expertName+"%' order by em.major.mname asc";
		     if("".equals(mno)){
		    	 hqlString="from Expertmajor as em where em.assessingproject.tag = '1' and em.expert.expertName like '%"+expertName+"%' order by em.major.mname asc";
		    	 
		     }
		     if("".equals(expertName)){
		    	 hqlString="from Expertmajor as em where em.assessingproject.tag = '1' and em.major.mno= '"+mno+"' order by em.major.mname asc";
		     }
		     if(("".equals(mno)&&"".equals(expertName))||(mno==null&&expertName==null)){
		    	 hqlString="from Expertmajor as em where em.assessingproject.tag = '1' order by em.major.mname asc";
		     }
		     System.out.println(mno);
		     System.out.println(expertName);
		     System.out.println(hqlString);
		    
			expertmajorLists = (ArrayList<Expertmajor>) QueryUtilDaoImpl.executeQueryByPage(hqlString, null, null, page, rows);
		     expertmajorLists2=(ArrayList<Expertmajor>)expertmajorService.findByHQL(hqlString);
		     
		     System.out.println(expertmajorLists2.size());
			 totalRows = expertmajorLists2.size();
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println("page"+totalPage);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	//查找专家
	public String findExpert() {
		try {
			expertmajorList=new ArrayList<BaseModel>();
			if(basemodel==null){
				basemodel=new BaseModel();
				basemodel.setId("");
				basemodel.setName("");
				basemodel.setYear(null);
			}else if(basemodel.getName()!=null){
				basemodel.setName(java.net.URLDecoder.decode(basemodel.getName(),"UTF-8"));
			}
			
			expertList = expertmajorService.findExpertList(basemodel, mno, page, rows);
			List<Expert> em1=expertService.findByHQL("from Expert as expert where expert.expertId in(SELECT expert.expertId FROM Expertmajor em WHERE em.assessingproject.tag = '1' AND em.major.mno='020301K')");
			System.out.println("em1.size"+em1.size());
			for(Expert u :expertList){
    			BaseModel base=new BaseModel();
    			base.setId(u.getExpertId());
				base.setName(u.getExpertName());
				if("".equals(basemodel.getYear())){
					String hqlString="from Expertmajor as em where em.assessingproject.tag='1' and em.major.mno='"+mno+"'";
		    		List<Expertmajor> em=expertmajorService.findByHQL(hqlString);
		    		System.out.println("emsize"+em.size());
					for(Expertmajor e :em){	    				
	    				if(e.getExpert().getExpertId().equals(u.getExpertId())){
	    					base.setMajorId(e.getExpertMajorCode()+"");//用baseModel中majorId表示专家专业关系主键
	    					base.setYear("0");//用baseModel中year表示专家是否存在
	    					break;
	    				}
	    				else{
	    					base.setYear("1");
	    				}    				
	    			}
				}else{
					base.setYear(basemodel.getYear());   
				}    			 			
    			expertmajorList.add(base);
    		}
			totalRows = expertmajorService.countFindExpert(basemodel, mno);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println("page"+totalPage);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	

	
	
	
	//初始化添加专家页面
    @SuppressWarnings("unchecked")
	public String addExpert(){
    	basemodel=null;
    	page=1;
		rows=10;
    	try{
    		expertmajorList=new ArrayList<BaseModel>();    		
    		String hqlString="from Expertmajor as em where em.assessingproject.tag='1' and em.major.mno='"+mno+"'";
    		List<Expertmajor> em=expertmajorService.findByHQL(hqlString);
    		List<Expert> user=(List<Expert>) QueryUtilDaoImpl
			.executeQueryByPage("from Expert", null, page, rows);
    		for(Expert u :user){
    			BaseModel base=new BaseModel();
    			base.setId(u.getExpertId());
				base.setName(u.getExpertName());
				System.out.println(base.getId());
    			for(Expertmajor e :em){
    				
    				if(e.getExpert().getExpertId().equals(u.getExpertId())){
    					base.setMajorId(e.getExpertMajorCode()+"");//用baseModel中majorId表示专家专业关系主键
    					base.setYear("0");//用baseModel中year表示专家是否存在
    					break;
    				}
    				else{
    					base.setYear("1");
    				}    				
    			}
    			expertmajorList.add(base);
    		}
    		totalRows =  expertService.findByHQL("from Expert").size();
			System.out.println("init"+totalRows);	
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
    	}catch (Exception e) {
			
			return "error";
		}
		return "success";  	
}
  //添加专家
	public String modifiExpertmajor(){
		try {
			System.out.println("modifi"+expertCode);
			System.out.println("modifi"+mno);
			userinfo=new Expert();
			userinfo=expertService.findById(Expert.class, expertCode);
			//userinfo.setUserCode(""+expertCode);
			expertmajor=new Expertmajor();
			expertmajor.setExpert(userinfo);
			major=new Major();
			major=majorService.findById(Major.class, mno);
			Assessingproject ap = assessingprojectService.findCurrentProject();
		
			//major.setMno(""+mno);
			expertmajor.setMajor(major);
			expertmajor.setAssessingproject(ap);
			expertmajorService.save(expertmajor);
			//更新打分表 改用数据库触发器操作
//			appList=appService.findByHQL("from Appraisalsystem as app where app.type='0'");//指标
//			List<Assessingneedtarget> assneedList =new ArrayList<Assessingneedtarget>();//评估所需指标
//			List<Mas> masList =new ArrayList<Mas>();//指标统计
//			List<Mas> masListspecial =new ArrayList<Mas>();//指标统计
//			List<FileinfoAttachment> fiaList =new ArrayList<FileinfoAttachment>();//附件
//			List<Assessingneedtarget> assneedListall=assneedService.findAll(Assessingneedtarget.class);
//			System.out.println("assneedListall "+assneedListall.size()+" "+appList.size());
//			
//			for(Assessingneedtarget an :assneedListall){
//				Assessingneedtarget base=new Assessingneedtarget();
//    			
//    			for(Appraisalsystem ap :appList){
//    				if(ap.getIndicatorId().equals(an.getAppraisalsystem().getIndicatorId())){
//    	    			base.setAssessingNeedTargetNo(an.getAssessingNeedTargetNo());
//    					
//    					assneedList.add(base);
//    					//评估所需指标
//    					
//    					break;
//    				}   				
//    			}
//    			System.out.println("end,assneedList");
//    		}
//			System.out.println("get,assneedList");
//			List<Mas> masListall=masService.findAll(Mas.class);//指标统计
//			System.out.println("get,masListall"+masListall.size());
//			int n=0;
//			for(Mas ma :masListall){
//				Mas base=new Mas();
//				n=n+1;
//    			for(Assessingneedtarget ant :assneedList){
//    				
//    				if(ant.getAssessingNeedTargetNo().equals(ma.getAssessingneedtarget().getAssessingNeedTargetNo())){	
//    					base.setMasCode(ma.getMasCode());
//    					base.setMajor(ma.getMajor());
//    					System.out.println("进入add"+n+"  "+base.getMasCode()+"  "+base.getMajor().getMno());
//    					masListspecial.add(base);//指标统计
//    					System.out.println("结束add"+n);
//    				}   				
//    			}
//    		}
//			System.out.println("get,masListspecial");
//			for(Mas m : masListspecial){
//				Mas base=new Mas();
//    			base=m;
//				if(m.getMajor().getMno().equals(mno)){
//					masList.add(base);//指标统计
//				}
//			}
//			System.out.println("get,masList"+masList.size());
//			List<FileinfoAttachment> fiaListall=fiaService.findAll(FileinfoAttachment.class);//附件
//			System.out.println("get,fiaListall");
//			for(FileinfoAttachment fa :fiaListall){
//				FileinfoAttachment base=new FileinfoAttachment();
//    			base=fa;
//    			for(Mas ma :masList){
//    				
//    				if(ma.getMasCode().equals(fa.getMas().getMasCode())){
//    					fiaList.add(base);//附件
//    					break;
//    				}   				
//    			}
//    		}
//			System.out.println("get,fiaList"+fiaList.size());
//			for(FileinfoAttachment fa :fiaList){
//				Expertscore base=new Expertscore();
//    			base.setFileinfoAttachment(fa);
//    			base.setExpert(userinfo);
//    			expertscoreService.save(base);
//    		}
//			System.out.println("end");
		} catch (Exception e) {
			
			return "error";
		}
		
		return "success";
	}
	
	//删除专家
	public String deleteExpertmajor(){
		try {
			System.out.println("expertMajorCode"+expertMajorCode);
			Expertmajor em=expertmajorService.findById(Expertmajor.class, expertMajorCode);
			expertmajorService.delete(em);
			//更新打分表 改用数据库触发器操作
//			appList=appService.findByHQL("from Appraisalsystem as app where app.type='0'");//指标
//			List<Assessingneedtarget> assneedList =new ArrayList<Assessingneedtarget>();//评估所需指标
//			List<Mas> masList =new ArrayList<Mas>();//指标统计
//			List<Mas> masListspecial =new ArrayList<Mas>();//指标统计
//			List<FileinfoAttachment> fiaList =new ArrayList<FileinfoAttachment>();//附件
//			List<Expertscore> expertscoreList =new ArrayList<Expertscore>();//专家打分
//			List<Assessingneedtarget> assneedListall=assneedService.findAll(Assessingneedtarget.class);
//			System.out.println("assneedListall "+assneedListall.size()+" "+appList.size());
//			
//			for(Assessingneedtarget an :assneedListall){
//				Assessingneedtarget base=new Assessingneedtarget();
//    			
//    			for(Appraisalsystem ap :appList){
//    				if(ap.getIndicatorId().equals(an.getAppraisalsystem().getIndicatorId())){
//    	    			base.setAssessingNeedTargetNo(an.getAssessingNeedTargetNo());
//    					
//    					assneedList.add(base);
//    					//评估所需指标
//    					
//    					break;
//    				}   				
//    			}
//    			System.out.println("end,assneedList");
//    		}
//			System.out.println("get,assneedList");
//			List<Mas> masListall=masService.findAll(Mas.class);//指标统计
//			System.out.println("get,masListall"+masListall.size());
//			int n=0;
//			for(Mas ma :masListall){
//				Mas base=new Mas();
//				n=n+1;
//    			for(Assessingneedtarget ant :assneedList){
//    				
//    				if(ant.getAssessingNeedTargetNo().equals(ma.getAssessingneedtarget().getAssessingNeedTargetNo())){	
//    					base.setMasCode(ma.getMasCode());
//    					base.setMajor(ma.getMajor());
//    					System.out.println("进入add"+n+"  "+base.getMasCode()+"  "+base.getMajor().getMno());
//    					masListspecial.add(base);//指标统计
//    					System.out.println("结束add"+n);
//    				}   				
//    			}
//    		}
//			System.out.println("get,masListspecial");
//			for(Mas m : masListspecial){
//				Mas base=new Mas();
//    			base=m;
//				if(m.getMajor().getMno().equals(mno)){
//					masList.add(base);//指标统计
//				}
//			}
//			System.out.println("get,masList"+masList.size());
//			List<FileinfoAttachment> fiaListall=fiaService.findAll(FileinfoAttachment.class);//附件
//			System.out.println("get,fiaListall");
//			for(FileinfoAttachment fa :fiaListall){
//				FileinfoAttachment base=new FileinfoAttachment();
//    			base=fa;
//    			for(Mas ma :masList){
//    				
//    				if(ma.getMasCode().equals(fa.getMas().getMasCode())){
//    					fiaList.add(base);//附件
//    					break;
//    				}   				
//    			}
//    		}
//			System.out.println("get,fiaList"+fiaList.size());
//			for(FileinfoAttachment fa :fiaList){
//				System.out.println("进入find"+em.getExpert().getExpertId()+" "+fa.getAttachmentId());
//				expertscoreList=expertscoreService.findByHQL("from Expertscore as es where es.expert.expertId='"+em.getExpert().getExpertId()+"' and es.fileinfoAttachment.attachmentId='"+fa.getAttachmentId()+"'");
//				System.out.println("expertscoreList "+expertscoreList.size());
//				for(Expertscore es:expertscoreList){
//    				System.out.println("进入delete");
//    				expertscoreService.delete(es);
//    			}
//    		}
		} catch (Exception e) {
			err=e;
			StackTraceElement[] st = err.getStackTrace();
			for (StackTraceElement stackTraceElement : st) {
				String exclass = stackTraceElement.getClassName();
				String method = stackTraceElement.getMethodName();
				System.out.println(new Date() + ":" + "[类:" + exclass + "]调用"
				+ method + "时在第" + stackTraceElement.getLineNumber()
				+ "行代码处发生异常!异常类型:" + err.getClass().getName());
			}
			return "error";
		}	
		return "success";
	}


	
	public Expert getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(Expert userinfo) {
		this.userinfo = userinfo;
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

	public ExpertService getExpertService() {
		return expertService;
	}
	public void setExpertService(ExpertService expertService) {
		this.expertService = expertService;
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
	public ExpertmajorService getExpertmajorService() {
		return expertmajorService;
	}
	public void setExpertmajorService(ExpertmajorService expertmajorService) {
		this.expertmajorService = expertmajorService;
	}
	public List<Major> getMajorList() {
		return majorList;
	}
	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}
	public List<Major> getMajorListfind() {
		return majorListfind;
	}
	public void setMajorListfind(List<Major> majorListfind) {
		this.majorListfind = majorListfind;
	}
	public List<BaseModel> getExpertmajorList() {
		return expertmajorList;
	}
	public void setExpertmajorList(List<BaseModel> expertmajorList) {
		this.expertmajorList = expertmajorList;
	}
	public List<Department> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public Expertmajor getExpertmajor() {
		return expertmajor;
	}
	public void setExpertmajor(Expertmajor expertmajor) {
		this.expertmajor = expertmajor;
	}
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public String getExpertCode() {
		return expertCode;
	}
	public void setExpertCode(String expertCode) {
		this.expertCode = expertCode;
	}
	public int getExpertMajorCode() {
		return expertMajorCode;
	}
	public void setExpertMajorCode(int expertMajorCode) {
		this.expertMajorCode = expertMajorCode;
	}
	public MajorModel getMajormodel() {
		return majormodel;
	}
	public void setMajormodel(MajorModel majormodel) {
		this.majormodel = majormodel;
	}
	public AppraisalSystemService getAppService() {
		return appService;
	}
	public void setAppService(AppraisalSystemService appService) {
		this.appService = appService;
	}
	public AssessingneedtargetService getAssneedService() {
		return assneedService;
	}
	public void setAssneedService(AssessingneedtargetService assneedService) {
		this.assneedService = assneedService;
	}
	public MasService getMasService() {
		return masService;
	}
	public void setMasService(MasService masService) {
		this.masService = masService;
	}
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
	public List<Appraisalsystem> getAppList() {
		return appList;
	}
	public void setAppList(List<Appraisalsystem> appList) {
		this.appList = appList;
	}

	public List<Expert> getExpertList() {
		return expertList;
	}
	public void setExpertList(List<Expert> expertList) {
		this.expertList = expertList;
	}
	public void setBasemodel(BaseModel basemodel) {
		this.basemodel = basemodel;
	}
	public BaseModel getBasemodel() {
		return basemodel;
	}
	public Exception getErr() {
		return err;
	}
	public void setErr(Exception err) {
		this.err = err;
	}
	public void setTrows(int trows) {
		this.trows = trows;
	}
	public int getTrows() {
		return trows;
	}
	public void setTpage(int tpage) {
		this.tpage = tpage;
	}
	public int getTpage() {
		return tpage;
	}
	public List<Major> getMajorListgroup() {
		return majorListgroup;
	}
	public void setMajorListgroup(List<Major> majorListgroup) {
		this.majorListgroup = majorListgroup;
	}
	public HashMap<String, Object> getMap() {
		return map;
	}
	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}
	public void setAddValue(String addValue) {
		this.addValue = addValue;
	}
	public String getAddValue() {
		return addValue;
	}
	public List<String> getMnameList() {
		return mnameList;
	}
	public void setMnameList(List<String> mnameList) {
		this.mnameList = mnameList;
	}
	public void setMapexpert(HashMap<String,Object> mapexpert) {
		this.mapexpert = mapexpert;
	}
	public HashMap<String,Object> getMapexpert() {
		return mapexpert;
	}
	public void setExpertid(String expertid) {
		this.expertid = expertid;
	}
	public String getExpertid() {
		return expertid;
	}
	public void setExpertnameList(List<String> expertnameList) {
		this.expertnameList = expertnameList;
	}
	public List<String> getExpertnameList() {
		return expertnameList;
	}
	public void setExpertgroupList(List<BaseModel> expertgroupList) {
		this.expertgroupList = expertgroupList;
	}
	public List<BaseModel> getExpertgroupList() {
		return expertgroupList;
	}
	public String getExpertname() {
		return expertname;
	}
	public void setExpertname(String expertname) {
		this.expertname = expertname;
	}
	public String getGroupmname() {
		return groupmname;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	public void setGroupmname(String groupmname) {
		this.groupmname = groupmname;
	}
	public String getSuccessmsg() {
		return successmsg;
	}
	public void setSuccessmsg(String successmsg) {
		this.successmsg = successmsg;
	}


	public ArrayList<Expertmajor> getExpertmajorLists() {
		return expertmajorLists;
	}


	public void setExpertmajorLists(ArrayList<Expertmajor> expertmajorLists) {
		this.expertmajorLists = expertmajorLists;
	}


	public String getExpertName() {
		return expertName;
	}


	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}

	public AssessingprojectService getAssessingprojectService() {
		return assessingprojectService;
	}
	public void setAssessingprojectService(
			AssessingprojectService assessingprojectService) {
		this.assessingprojectService = assessingprojectService;
	}
	public Assessingproject getAp() {
		return ap;
	}
	public void setAp(Assessingproject ap) {
		this.ap = ap;
	}
	
}
