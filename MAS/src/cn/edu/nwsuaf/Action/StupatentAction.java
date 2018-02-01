package cn.edu.nwsuaf.Action;

import java.io.IOException;
import java.util.List;
import cn.edu.nwsuaf.Model.StupatentModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.StupatentService;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Stupatent;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONObject;


public class StupatentAction extends ActionSupport {

	//学生获得专利
	private static final long serialVersionUID = 1L;

	// Service
	private StupatentService stupatentService;

	private DepartmentService departmentService;
	private MajorService majorService;

	// 传到前台下拉列表从数据库中读取显示
	// 专利
	private List<Stupatent> stupList;// 

	private List<Department> departmentList;// 学院

	private List<Major> majorList;// 专业
	private List<String> yearList;// 年份

	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private String stuNumber;// 学号
	private String stuName;
	private String majorId;
	private String departmentId;
	private Stupatent stupatent;
	private StupatentModel stupmodel = new StupatentModel();
	private int pnumber;
	private boolean flag;
	private HttpServletRequest request;
	private String patentNumber;
	private String result;
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
			if (pnumber == 0) {
				stupatent = null;
			} else {

				stupatent = stupatentService.findById(Stupatent.class, pnumber);
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}

	// 修改
	public String modifiStupatent() {
		try {
			
			List<Stupatent> s;
			s = stupatentService
					.findByHQL("from Stupatent as stu where stu.pnumber='"
							+ stupatent.getPnumber() + "'");
			if (s.size() == 0) {
				stupatentService.save(stupatent);
			} else {

				stupatentService.update(stupatent);
			}
		} catch (ServiceException e) {
			//e.printStackTrace();
			return "error";
		}

		return "success";
	}

	// 添加
	public String insertStupatent() {
		try {
			stupatentService.save(stupatent);
		} catch (ServiceException e) {
			
			return "error";
		}
		return "success";
	}

	// 删除
	public String deleteStupatent() {
		try {
			Stupatent stupatents = stupatentService.findById(Stupatent.class,
					pnumber);
			stupatentService.delete(stupatents);
		} catch (ServiceException e) {
			
			return "error";
		}

		return "success";
	}
	public String checkPatentNumber() throws IOException{
		try {
			System.out.println("进入action");
			
			System.out.println(patentNumber);
			List<Stupatent> s;
			s = stupatentService
					.findBySQL("select * from Stupatent where patentNumber='"
							+ patentNumber + "'");
			
			JSONObject json = JSONObject.fromObject(s.size());
			System.out.println("111112342111");
			System.out.println(json);
			result=json.toString();
			System.out.println(json);
		} catch (Exception e) {
			
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
		stupmodel=null;
		try {
			
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = stupatentService.findYearList();
			stupList = stupatentService.findallStupatentList(page, rows,mno,dno);
			
			totalRows=stupatentService.count(mno,dno);
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
	public String findStupatent() {
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
			System.out.println("当前页数是=="+rows);
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = stupatentService.findYearList();
			if(!mno.equals("000000")){
				stupmodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				stupmodel.setDepartmentId(dno);
			}
			if(stupmodel==null){
				stupmodel=new StupatentModel();
				stupmodel.setYear(null);
				stupmodel.setDepartmentId(null);
				stupmodel.setMajorId(null);
				stupmodel.setName("");
				stupmodel.setPatentNumber("");
				stupmodel.setPateType(null);
				stupmodel.setStuName(null);
				stupmodel.setStuNumber(null);
			}else if(stupmodel.getName()!=null&&stupmodel.getStuName()!=null){
				stupmodel.setName(java.net.URLDecoder.decode(stupmodel.getName(),"UTF-8"));
				stupmodel.setStuName(java.net.URLDecoder.decode(stupmodel.getStuName(),"UTF-8"));		
			}

			stupList = stupatentService.findStupatentList(stupmodel, page,
					rows);
			totalRows = stupatentService.countFindStupatent(stupmodel);
			//System.out.println("totalRows"+totalRows);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			//System.out.println(totalPage);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}

	
	//get-----set方法
	public int getPnumber() {
		return pnumber;
	}

	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}

	public String getStuNumber() {
		return stuNumber;
	}

	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
	}

	

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
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

	public StupatentService getStupatentService() {
		return stupatentService;
	}

	public void setStupatentService(StupatentService stupatentService) {
		this.stupatentService = stupatentService;
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

	
	public List<Stupatent> getStupList() {
		return stupList;
	}

	public void setStupList(List<Stupatent> stupList) {
		this.stupList = stupList;
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

	public Stupatent getStupatent() {
		return stupatent;
	}

	public void setStupatent(Stupatent stupatent) {
		this.stupatent = stupatent;
	}

	public StupatentModel getStupmodel() {
		return stupmodel;
	}

	public void setStupmodel(StupatentModel stupmodel) {
		this.stupmodel = stupmodel;
	}

	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getPatentNumber() {
		return patentNumber;
	}

	public void setPatentNumber(String patentNumber) {
		this.patentNumber = patentNumber;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	public String getErrstring() {
		return errstring;
	}

}
