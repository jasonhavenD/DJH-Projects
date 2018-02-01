package cn.edu.nwsuaf.Action;

import java.util.List;
import cn.edu.nwsuaf.Model.TeachertrainingModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.TeachertrainingService;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Teachertraining;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;


public class TeachertrainingAction extends ActionSupport {
	
    //教师进修培训
	private static final long serialVersionUID = 1L;

	// Service
	private TeachertrainingService teachertrainingService;

	private DepartmentService departmentService;
	private MajorService majorService;

	// 传到前台下拉列表从数据库中读取显示
	private List<Teachertraining> teatList;// 专利

	private List<Department> departmentList;// 学院

	private List<Major> majorList;// 专业
	private List<String> yearList;// 年份
	private List<String> traintypeList;
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	
	private String majorId;
	private String departmentId;
	private Teachertraining teachertraining;
	private TeachertrainingModel teatmodel = new TeachertrainingModel();
	private int teacherTrainingNo;
	private int rol;
	private String errstring;

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	// 初始化修改页面
	public String initEdit() {

		try {
			if (teacherTrainingNo == 0) {
				teachertraining = null;
			} else {

				teachertraining = teachertrainingService.findById(Teachertraining.class, teacherTrainingNo);
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}

	// 修改
	public String modifiTeat() {
		try {

			List<Teachertraining> s;
			s = teachertrainingService
					.findByHQL("from Teachertraining as t where t.teacherTrainingNo="
							+ teachertraining.getTeacherTrainingNo() );
			if (s.size() == 0) {
				teachertrainingService.save(teachertraining);
			} else {

				teachertrainingService.update(teachertraining);
			}
		} catch (ServiceException e) {
			
			return "error";
		}

		return "success";
	}

	// 添加
	public String insertTeat() {
		try {
			teachertrainingService.save(teachertraining);
		} catch (ServiceException e) {
			
			return "error";
		}
		return "success";
	}

	// 删除
	public String deleteTeat() {
		try {
			Teachertraining teachertrainings = teachertrainingService.findById(Teachertraining.class,
					teacherTrainingNo);
			teachertrainingService.delete(teachertrainings);
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
			mno=QueryUtil.getUserMno().getMajor().getInMno();
    		dno=QueryUtil.getUserMno().getDepartment().getDno();
        }catch(Exception e){
        	errstring="登录超时！请安全退出再重新登录！";
        	return "errorstring";
        }
		teatmodel=null;
		try {
			page = 1;
			rows = 10;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = teachertrainingService.findYearList();
			setTraintypeList(teachertrainingService.findTrainTypeList());
			teatList = teachertrainingService.findallTeachertrainingList(page, rows,mno,dno);
			totalRows=teachertrainingService.count(mno,dno);
			System.out.println("init"+totalRows);
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
	//多条件查询信息
	public String findTeat() {
		String mno="";
		String dno="";
		try{
			mno=QueryUtil.getUserMno().getMajor().getInMno();
    		dno=QueryUtil.getUserMno().getDepartment().getDno();
        }catch(Exception e){
        	errstring="登录超时！请安全退出再重新登录！";
        	return "errorstring";
        }
		try {
			System.out.println("当前页数是=="+page);
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = teachertrainingService.findYearList();
			setTraintypeList(teachertrainingService.findTrainTypeList());
			if(!mno.equals("000000")){
				teatmodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				teatmodel.setDepartmentId(dno);
			}
			if(teatmodel==null){
				teatmodel=new TeachertrainingModel();
            	teatmodel.setGetCertificate("");
            	teatmodel.setGivenCertificateDepart("");
            	teatmodel.setId("");
            	teatmodel.setIsIndustryTrain("");
            	teatmodel.setTrainType("");
            	teatmodel.setYear("");
            	teatmodel.setTrainContend("");
            }
			teatList = teachertrainingService.findTeatList(teatmodel, page,
					rows);
			totalRows = teachertrainingService.countFindTeat(teatmodel);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println(totalPage);
		} catch (ServiceException e) {
			
			return "error";
		}
		return "success";
	}

	
	//get-----set方法
	

	public String getMajorId() {
		return majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
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

	public List<String> getYearList() {
		return yearList;
	}

	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
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

	public TeachertrainingService getTeachertrainingService() {
		return teachertrainingService;
	}

	public void setTeachertrainingService(
			TeachertrainingService teachertrainingService) {
		this.teachertrainingService = teachertrainingService;
	}

	public List<Teachertraining> getTeatList() {
		return teatList;
	}

	public void setTeatList(List<Teachertraining> teatList) {
		this.teatList = teatList;
	}

	public Teachertraining getTeachertraining() {
		return teachertraining;
	}

	public void setTeachertraining(Teachertraining teachertraining) {
		this.teachertraining = teachertraining;
	}

	public TeachertrainingModel getTeatmodel() {
		return teatmodel;
	}

	public void setTeatmodel(TeachertrainingModel teatmodel) {
		this.teatmodel = teatmodel;
	}

	public int getTeacherTrainingNo() {
		return teacherTrainingNo;
	}

	public void setTeacherTrainingNo(int teacherTrainingNo) {
		this.teacherTrainingNo = teacherTrainingNo;
	}

	public void setTraintypeList(List<String> traintypeList) {
		this.traintypeList = traintypeList;
	}

	public List<String> getTraintypeList() {
		return traintypeList;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	public String getErrstring() {
		return errstring;
	}

	

	

	

	

}
