package cn.edu.nwsuaf.Action;

import java.util.Date;
import java.util.List;

import cn.edu.nwsuaf.Model.TrainingvenueModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.EquipmentService;
import cn.edu.nwsuaf.Service.Impl.TrainingvenueUsingService;

import cn.edu.nwsuaf.Service.Impl.TrainingvenueService;

import cn.edu.nwsuaf.bean.Equipment;
import cn.edu.nwsuaf.bean.Teacherachievements;
import cn.edu.nwsuaf.bean.Trainingvenue;
import cn.edu.nwsuaf.bean.Trainingvenueuse;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class TrainingvenueAction extends ActionSupport{

	/**
	 * 
	 */
	//实验实训场地
	private static final long serialVersionUID = 1L;

	// Service
	private TrainingvenueService trainingvenueService;
	private TrainingvenueUsingService trainingvenueuseService;
	private DepartmentService departmentService;
	private EquipmentService equipmentService;
	
	// 传到前台下拉列表从数据库中读取显示
	private List<Trainingvenue> trainingvenueList;// 
	private List<Trainingvenue> traList;// 页面总列表
    private List<Equipment> equipmentList;//实验室设备列表
	private List<String> yearList;// 年份
	private List<String> tcList;//实验室性质列表
    
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	
	//页面属性
	private String traNumer;	
	private String traName;	
	private Float area;
	private Integer aptCount;
	private Float eaquipAllVal;
	private Float equipVal;
	private Integer useCount;
	private Integer courseCount;
	private Integer pjCount;
	private Integer thHcount;
	private Integer thPcount;
	
	private Trainingvenue trainingvenue;
	private TrainingvenueModel tramodel = new TrainingvenueModel();
	private Equipment equipment;
	private int rol;
	private Exception err;
	private String errstring;
	
	// 初始化修改页面
	public String initEdit() {

		try {
			if (traNumer == null) {
				trainingvenue = null;
			} else {
				System.out.println("add:"+traNumer);
				trainingvenue=trainingvenueService.findById(Trainingvenue.class, traNumer);
				
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	// 修改实验室
	public String modifiTrainingvenue() {
		try {

			List<Trainingvenue> s;
			s = trainingvenueService
			.findByHQL("from Trainingvenue as tr where tr.traNumer='"
					+ trainingvenue.getTraNumer() + "'");
			if (s.size() == 0) {
				trainingvenueService.save(trainingvenue);
			} else {

				trainingvenueService.update(trainingvenue);
			}
		} catch (ServiceException e) {
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
	
	public String modifiEquipment(){
		try {

			List<Equipment> s;
			s = equipmentService
			.findBySQL("select * from Equipment where trainingvenue.traNumer='"
					+ equipment.getTrainingvenue().getTraNumer() + "'");
			if (s.size() == 0) {
				equipmentService.save(equipment);
			} else {

				equipmentService.update(equipment);
			}
		} catch (ServiceException e) {
			
			return "error";
		}

		return "success";
	}
	
	
	// 添加
	public String insertTrainingvenue() {
		try {
			trainingvenueService.save(trainingvenue);
		} catch (ServiceException e) {
			
			return "error";
		}
		return "success";
	}

	// 删除
	public String deleteTrainingvenue() {
		try {
			Trainingvenue fs = trainingvenueService.findById(Trainingvenue.class,
					traNumer);
			List<Trainingvenueuse> newList;
			newList=trainingvenueuseService.findByHQL("from Trainingvenueuse as ta where ta.trainingvenue.traNumer='"+traNumer+"'");
			int size=0;
			size=newList.size();
			System.out.println("Teacherachievementssize"+size);
			if(size!=0){
				for(Trainingvenueuse t:newList)
				{
					trainingvenueuseService.delete(t);
				}
			}
			trainingvenueService.delete(fs);
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
		tramodel=null;
		try {
			
			tcList=trainingvenueService.findTCharacterList();
			//System.out.println(tcList.toString());
		
			yearList = trainingvenueService.findYearList();
			trainingvenueList = trainingvenueService.findallTrainingvenueList(page, rows,mno,dno);
			totalRows = trainingvenueService.count(mno, dno);
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
	
	public String initEquipment() {
		try {
			yearList = trainingvenueService.findYearList();
			equipmentList = equipmentService.findByHQL("from Equipment where trainingvenue.traNumer='"
					+ traNumer+ "'");	
			System.out.println("from Equipment where trainingvenue.traNumer='"+ traNumer+ "'");
			System.out.println("equipmentList"+equipmentList.size());
		} catch (ServiceException e) {
			
			return "error";
		}
	return "success";
	}
	//多条件查询信息
	public String findTrainingvenue() {
		try {
			System.out.println("当前页数是=="+page);
			trainingvenueList = trainingvenueService.findTrainingvenueList(tramodel, page,
					rows);
			totalRows = trainingvenueService.countFindTrainingvenue(tramodel);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			//System.out.println(totalPage);
		} catch (ServiceException e) {
			
			return "error";
		}
		return "success";
	}
	//set&&get
	public TrainingvenueService getTrainingvenueService() {
		return trainingvenueService;
	}
	public void setTrainingvenueService(TrainingvenueService trainingvenueService) {
		this.trainingvenueService = trainingvenueService;
	}
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public List<Trainingvenue> getTrainingvenueList() {
		return trainingvenueList;
	}
	public void setTrainingvenueList(List<Trainingvenue> trainingvenueList) {
		this.trainingvenueList = trainingvenueList;
	}
	
	
	public EquipmentService getEquipmentService() {
		return equipmentService;
	}
	public void setEquipmentService(EquipmentService equipmentService) {
		this.equipmentService = equipmentService;
	}
	public List<Trainingvenue> getTraList() {
		return traList;
	}
	public void setTraList(List<Trainingvenue> traList) {
		this.traList = traList;
	}
	
	public List<String> getYearList() {
		return yearList;
	}
	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
	}
	public List<String> getTcList() {
		return tcList;
	}
	public void setTcList(List<String> tcList) {
		this.tcList = tcList;
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
	public String getTraNumer() {
		return traNumer;
	}
	public void setTraNumer(String traNumer) {
		this.traNumer = traNumer;
	}
	public String getTraName() {
		return traName;
	}
	public void setTraName(String traName) {
		this.traName = traName;
	}
	public Float getArea() {
		return area;
	}
	public void setArea(Float area) {
		this.area = area;
	}
	public Integer getAptCount() {
		return aptCount;
	}
	public void setAptCount(Integer aptCount) {
		this.aptCount = aptCount;
	}
	public Float getEaquipAllVal() {
		return eaquipAllVal;
	}
	public void setEaquipAllVal(Float eaquipAllVal) {
		this.eaquipAllVal = eaquipAllVal;
	}
	public Float getEquipVal() {
		return equipVal;
	}
	public void setEquipVal(Float equipVal) {
		this.equipVal = equipVal;
	}
	public Integer getUseCount() {
		return useCount;
	}
	public void setUseCount(Integer useCount) {
		this.useCount = useCount;
	}
	public Integer getCourseCount() {
		return courseCount;
	}
	public void setCourseCount(Integer courseCount) {
		this.courseCount = courseCount;
	}
	public Integer getPjCount() {
		return pjCount;
	}
	public void setPjCount(Integer pjCount) {
		this.pjCount = pjCount;
	}
	public Integer getThHcount() {
		return thHcount;
	}
	public void setThHcount(Integer thHcount) {
		this.thHcount = thHcount;
	}
	public Integer getThPcount() {
		return thPcount;
	}
	public void setThPcount(Integer thPcount) {
		this.thPcount = thPcount;
	}
	
	public Trainingvenue getTrainingvenue() {
		return trainingvenue;
	}
	public void setTrainingvenue(Trainingvenue trainingvenue) {
		this.trainingvenue = trainingvenue;
	}
	public TrainingvenueModel getTramodel() {
		return tramodel;
	}
	public void setTramodel(TrainingvenueModel tramodel) {
		this.tramodel = tramodel;
	}

	public void setEquipmentList(List<Equipment> equipmentList) {
		this.equipmentList = equipmentList;
	}

	public List<Equipment> getEquipmentList() {
		return equipmentList;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Equipment getEquipment() {
		return equipment;
	}
	public TrainingvenueUsingService getTrainingvenueuseService() {
		return trainingvenueuseService;
	}
	public void setTrainingvenueuseService(
			TrainingvenueUsingService trainingvenueuseService) {
		this.trainingvenueuseService = trainingvenueuseService;
	}
	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}
	public String getErrstring() {
		return errstring;
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
}
