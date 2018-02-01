package cn.edu.nwsuaf.Action;

import java.util.ArrayList;
import java.util.List;

import cn.edu.nwsuaf.Model.TraininguseinginformationModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.StudentService;
import cn.edu.nwsuaf.Service.Impl.TraininguseinginformationService;
import cn.edu.nwsuaf.Service.Impl.TrainingvenueService;
import cn.edu.nwsuaf.Service.Impl.TrainingvenueUsingService;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Student;
import cn.edu.nwsuaf.bean.Traininguseinginformation;
import cn.edu.nwsuaf.bean.Trainingvenueuse;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

public class TraininguseinginformationAction extends ActionSupport{

	/**
	 * 
	 */
	//实践教学资源情况
	private static final long serialVersionUID = 1L;

	// Service
	private TraininguseinginformationService traininguseinginformationService;
	private DepartmentService departmentService;
	private MajorService majorService;
	private TrainingvenueUsingService trainingvenueuseService;
	private TrainingvenueService trainingvenueService;
	private StudentService studentService;
	
	// 传到前台下拉列表从数据库中读取显示
	
	private List<Traininguseinginformation> tuiList;//
	
	private List<Department> departmentList;// 学院
	private List<Major> majorList;// 专业
	private List<String> yearList;// 年份
	
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	
	private Integer praId;
	private Integer resourceConstructionNumber;
	private Integer experimentalEquipmentMean;
	private Float laboratorySatisfactionRate;
	private Integer experimentNumber;
	private Integer schooBaseNumber;
	private Integer outBaseNumber;
	private Float schooBaseRate;
	private Float outBaseRate;
	
	private String majorId;
	private String departmentId;
	private int rol;
	private String errstring;

	private Traininguseinginformation traininguseinginformation;
	private TraininguseinginformationModel tuimodel = new TraininguseinginformationModel();
	
	//qingkong所有数据
	public String addAll() {
		try {
			//qingkong
			String sqlCall="delete from traininguseinginformation;";
			//String sqlCall="call _init_traininguseinginformation()";
			traininguseinginformationService.execute(sqlCall);
			//traininguseinginformationService.execute("upadate traininguseinginformation t set t.ExperimentalEquipmentMean=0 where t.ExperimentalEquipmentMean is null");
			//traininguseinginformationService.execute("upadate traininguseinginformation t set t.ExperimentNumber=0 where t.ExperimentalEquipmentMean is null");
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	//计算
	public String calculate() {
		try {
			List<Traininguseinginformation> newtuiList=new ArrayList<Traininguseinginformation>();
			newtuiList=traininguseinginformationService.findAll(Traininguseinginformation.class);
			List<Trainingvenueuse> newtuList=new ArrayList<Trainingvenueuse>();
			List<Trainingvenueuse> sectuList=new ArrayList<Trainingvenueuse>();
			List<Student> studentList=new ArrayList<Student>(); 
			int sumthHcount=0;
			int stucount=0;
			float eem=0;
			for(Traininguseinginformation t:newtuiList){
				newtuList=trainingvenueuseService.findByHQL("from Trainingvenueuse as t where t.major.mno='"+t.getMajor().getMno()+"' and t.year='"+t.getYear()+"'");
				for(Trainingvenueuse tu:newtuList){
					sumthHcount+=tu.getThHcount();
				}
				t.setExperimentNumber(sumthHcount);
				for(Trainingvenueuse tu:newtuList){
					sectuList=trainingvenueuseService.findByHQL("from Trainingvenueuse as t where t.trainingvenue.traNumer='"+tu.getTrainingvenue().getTraNumer()+"' and t.year='"+tu.getYear()+"'");
					for(Trainingvenueuse stu:sectuList){
						studentList=studentService.findByHQL("from Student as s where s.major.mno='"+stu.getMajor().getMno()+"' and s.isRoll='有学籍' and s.isInSchool='在校'");
						stucount=+studentList.size();
					}
					if(stucount!=0){
						eem+=tu.getTrainingvenue().getEaquipAllVal()/stucount;
					}
				}
				t.setExperimentalEquipmentMean((int) eem);
				traininguseinginformationService.update(t);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	// 初始化修改页面
	public String initEdit() {

		try {
			if (praId == 0) {
				traininguseinginformation = null;
			} else {

				traininguseinginformation=traininguseinginformationService.findById(Traininguseinginformation.class, praId);		
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	
	// 修改
	public String modifiTraininguseinginformation() {
		try {

			List<Traininguseinginformation> s;
			s = traininguseinginformationService
			.findByHQL("from Traininguseinginformation as tra where tra.praId='"
					+ traininguseinginformation.getPraId() + "'");
			if (s.size() == 0) {
				traininguseinginformationService.save(traininguseinginformation);
			} else {

				traininguseinginformationService.update(traininguseinginformation);
			}
		} catch (ServiceException e) {
			
			return "error";
		}
		return "success";
	}
	
	// 添加
	public String insertTraininguseinginformation() {
		try {
			traininguseinginformationService.save(traininguseinginformation);
		} catch (ServiceException e) {
			
			return "error";
		}
		return "success";
	}

	// 删除
	public String deleteTraininguseinginformation() {
		try {
			Traininguseinginformation fs = traininguseinginformationService.findById(Traininguseinginformation.class,
					praId);
			traininguseinginformationService.delete(fs);
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
        	setErrstring("登录超时！请安全退出再重新登录！");
        	return "errorstring";
        }
		tuimodel=null;
		try {
			page = 1;
			rows = 10;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = traininguseinginformationService.findYearList();
			tuiList = traininguseinginformationService.findAllTraList(page,rows,mno,dno);
			System.out.println(tuiList.toString());
			totalRows = traininguseinginformationService.count(mno, dno);
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
	public String findTraininguseinginformation() {
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
			System.out.println("当前页数是=="+page);
			if(!mno.equals("000000")){
				tuimodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				tuimodel.setDepartmentId(dno);
			}
			if(tuimodel==null){
				tuimodel=new TraininguseinginformationModel();
				tuimodel.setYear("");
				tuimodel.setMajorId(null);
				tuimodel.setDepartmentId(null);
			}
			tuiList = traininguseinginformationService.findTraininguseinginformationList(tuimodel, page,
					rows);	
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = traininguseinginformationService.findYearList();
			
			totalRows = traininguseinginformationService.countFindTraininguseinginformation(tuimodel);
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
	//getter && setter
	public TraininguseinginformationService getTraininguseinginformationService() {
		return traininguseinginformationService;
	}
	public void setTraininguseinginformationService(
			TraininguseinginformationService traininguseinginformationService) {
		this.traininguseinginformationService = traininguseinginformationService;
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
	
	public List<Traininguseinginformation> getTuiList() {
		return tuiList;
	}
	public void setTuiList(List<Traininguseinginformation> tuiList) {
		this.tuiList = tuiList;
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
	public Integer getPraId() {
		return praId;
	}
	public void setPraId(Integer praId) {
		this.praId = praId;
	}
	public Integer getResourceConstructionNumber() {
		return resourceConstructionNumber;
	}
	public void setResourceConstructionNumber(Integer resourceConstructionNumber) {
		this.resourceConstructionNumber = resourceConstructionNumber;
	}
	public Integer getExperimentalEquipmentMean() {
		return experimentalEquipmentMean;
	}
	public void setExperimentalEquipmentMean(Integer experimentalEquipmentMean) {
		this.experimentalEquipmentMean = experimentalEquipmentMean;
	}
	public Float getLaboratorySatisfactionRate() {
		return laboratorySatisfactionRate;
	}
	public void setLaboratorySatisfactionRate(Float laboratorySatisfactionRate) {
		this.laboratorySatisfactionRate = laboratorySatisfactionRate;
	}
	public Integer getExperimentNumber() {
		return experimentNumber;
	}
	public void setExperimentNumber(Integer experimentNumber) {
		this.experimentNumber = experimentNumber;
	}
	public Integer getSchooBaseNumber() {
		return schooBaseNumber;
	}
	public void setSchooBaseNumber(Integer schooBaseNumber) {
		this.schooBaseNumber = schooBaseNumber;
	}
	public Integer getOutBaseNumber() {
		return outBaseNumber;
	}
	public void setOutBaseNumber(Integer outBaseNumber) {
		this.outBaseNumber = outBaseNumber;
	}
	public Float getSchooBaseRate() {
		return schooBaseRate;
	}
	public void setSchooBaseRate(Float schooBaseRate) {
		this.schooBaseRate = schooBaseRate;
	}
	public Float getOutBaseRate() {
		return outBaseRate;
	}
	public void setOutBaseRate(Float outBaseRate) {
		this.outBaseRate = outBaseRate;
	}
	public Traininguseinginformation getTraininguseinginformation() {
		return traininguseinginformation;
	}
	public void setTraininguseinginformation(
			Traininguseinginformation traininguseinginformation) {
		this.traininguseinginformation = traininguseinginformation;
	}
	public TraininguseinginformationModel getTuimodel() {
		return tuimodel;
	}
	public void setTuimodel(TraininguseinginformationModel tuimodel) {
		this.tuimodel = tuimodel;
	}
	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
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
	public void setTrainingvenueuseService(TrainingvenueUsingService trainingvenueuseService) {
		this.trainingvenueuseService = trainingvenueuseService;
	}
	public TrainingvenueUsingService getTrainingvenueuseService() {
		return trainingvenueuseService;
	}
	public void setTrainingvenueService(TrainingvenueService trainingvenueService) {
		this.trainingvenueService = trainingvenueService;
	}
	public TrainingvenueService getTrainingvenueService() {
		return trainingvenueService;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}
	public String getErrstring() {
		return errstring;
	}
	
	
}
