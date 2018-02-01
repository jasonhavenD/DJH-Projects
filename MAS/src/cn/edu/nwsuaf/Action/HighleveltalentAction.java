package cn.edu.nwsuaf.Action;

import java.io.UnsupportedEncodingException;
import java.util.List;
import cn.edu.nwsuaf.Model.HighleveltalentModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.HighleveltalentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.TeacherService;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Highleveltalent;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Teacher;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class HighleveltalentAction extends ActionSupport{
	
	//高层次人才
	private static final long serialVersionUID = 1L;
	
	//Service
	private HighleveltalentService highService;
	private TeacherService teacherService;
	private MajorService majorService;
	private DepartmentService departmentService;
	
	//List
	private List<Highleveltalent> highList;
	private List<Teacher> teacherList;
	private List<String> yearList;
	private List<Major> majorList;
	private List<Department> departmentList;
	private List<String> talentTypeList;
	private List<String> rearchFieldList;
	
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private int Hno;
	private String Tno;
	private Highleveltalent high;
	private HighleveltalentModel hmodel = new HighleveltalentModel();
	private int rol;
	private String errstring;
	// 初始化修改页面
	public String initEdit() {

		try {
			if (Hno == 0) {
				high = null;
			} else {
				System.out.println();
				high = highService.findById(Highleveltalent.class, Hno);
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	
	//修改
	public String modifiHigh(){

		try {
			if(Hno==0){
				highService.save(high);
			} else {
				highService.update(high);
			}
		} catch (Exception e) {
			
			return "error";
		}
		
		return "success";
	}
	
	//添加
	public String insertHigh(){
		try {
			highService.save(high);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	
	// 删除
	public String deleteHigh() {
		try {
			high = highService.findById(Highleveltalent.class, Hno);
			highService.delete(high);
		} catch (ServiceException e) {
			
			return "error";
		}

		return "success";
	}
	
	// 初始化信息，用于页面显示数据库中信息
	public String initSearch() {
		String mno="";
		String dno="";
		try{			
			if(rol!=1){	
				mno=QueryUtil.getUserMno().getMajor().getInMno();
	    		dno=QueryUtil.getUserMno().getDepartment().getDno();
	    		System.out.println("mno"+mno);
	    		if("000000".equals(mno)){
	    			mno="";
	    		}
	    		
			}
			hmodel.setMajorId(mno);
			hmodel.setDepartmentId(dno);
			
        }catch(Exception e){
        	setErrstring("登录超时！请安全退出再重新登录！");
        	return "errorstring";
        }
		try {
			page=1;
			rows=10;
			hmodel.setId("");
			hmodel.setName("");
			hmodel.setRearchField("");
			hmodel.setTalentType("");
			hmodel.setYear("");
			yearList = highService.findYear();
		
			System.out.println("truerol1");
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
				
			
			talentTypeList = highService.findTalentType();
			rearchFieldList = highService.findRearchField();
			//totalRows = highService.findAll(Highleveltalent.class).size();
			System.out.println("dno:"+dno+"mno"+mno);
			highList = highService.findHighList(hmodel, page,rows);
			totalRows = highService.countFindHigh(hmodel);
			if (totalRows % rows == 0){
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0?1:(totalRows/rows+1);
			}
			System.out.println("totalpage==="+totalPage+"totalrows====="+totalRows);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";

	}

	//多条件查询信息
	public String findHigh() throws UnsupportedEncodingException {
		String mno="";
		String dno="";
		try{
			//if(rol!=1){	
				mno=QueryUtil.getUserMno().getMajor().getInMno();
	    		dno=QueryUtil.getUserMno().getDepartment().getDno();
	    	//	if("000000".equals(mno)){
	    	//		mno="";
	    	//	}
	    	//	hmodel.setMajorId(mno);
			//	hmodel.setDepartmentId(dno);
			//}
			
        }catch(Exception e){
        	setErrstring("登录超时！请安全退出再重新登录！");
        	return "errorstring";
        }
		try {
			System.out.println("dno:"+dno+"mno"+mno);
			yearList = highService.findYear();
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			talentTypeList = highService.findTalentType();
			rearchFieldList = highService.findRearchField();
			
			if(!mno.equals("000000")){
				hmodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				hmodel.setDepartmentId(dno);
			}
			//System.out.println("dno:"+dno+"mno"+mno);
			if(hmodel==null){
				hmodel=new HighleveltalentModel();
				hmodel.setId("");
				hmodel.setName("");
				hmodel.setRearchField("");
				hmodel.setTalentType("");
				hmodel.setYear("");
			}
			else if(hmodel!=null && hmodel.getName()!=null&&hmodel.getTalentType()!=null&&hmodel.getRearchField()!=null){
				hmodel.setName(java.net.URLDecoder.decode(hmodel.getName(),
				"UTF-8"));
				hmodel.setTalentType(java.net.URLDecoder.decode(hmodel
				.getTalentType(), "UTF-8"));
				hmodel.setRearchField(java.net.URLDecoder.decode(hmodel
				.getRearchField(), "UTF-8"));
			}
			highList = highService.findHighList(hmodel, page,rows);
			totalRows = highService.countFindHigh(hmodel);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (ServiceException e) {
			
			return "error";
		}
		return "success";
	}

	
	
	/*****************  	GETTERS & SETTERS   *****************/
	public HighleveltalentService getHighService() {
		return highService;
	}

	public void setHighService(HighleveltalentService highService) {
		this.highService = highService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public List<Highleveltalent> getHighList() {
		return highList;
	}

	public void setHighList(List<Highleveltalent> highList) {
		this.highList = highList;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public List<String> getYearList() {
		return yearList;
	}

	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
	}

	public List<Major> getMajorList() {
		return majorList;
	}

	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public List<String> getTalentTypeList() {
		return talentTypeList;
	}

	public void setTalentTypeList(List<String> talentTypeList) {
		this.talentTypeList = talentTypeList;
	}

	public List<String> getRearchFieldList() {
		return rearchFieldList;
	}

	public void setRearchFieldList(List<String> rearchFieldList) {
		this.rearchFieldList = rearchFieldList;
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
	
	public String getTno() {
		return Tno;
	}

	public void setHno(int hno) {
		Hno = hno;
	}

	public Highleveltalent getHigh() {
		return high;
	}

	public void setHigh(Highleveltalent high) {
		this.high = high;
	}

	public HighleveltalentModel getHmodel() {
		return hmodel;
	}

	public void setHmodel(HighleveltalentModel hmodel) {
		this.hmodel = hmodel;
	}
	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	public String list() {

		return "list";
	}
	public String getErrstring() {
		return errstring;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}
}
