package cn.edu.nwsuaf.Action;


import java.util.List;
import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;
import com.opensymphony.xwork2.ActionSupport;

public class DepartmentAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DepartmentService departmentService;
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private int number;
	private BaseModel departmentmodel = new BaseModel();
	public String dno;	
	private List<Department> departmentList;// 学院
	private Department department;
	private int rol;
	
	//错误提示
	private String errstring;
	
	
	
	// 初始化修改页面
	public String initEdit() {

		try {
			if (dno==null) {
				department = null;
			} else {
			
				department = departmentService.findById(Department.class, dno);
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	
	// 修改
	public String modifiDepartment() {
		try {
			
			List<Department> s;
			s = departmentService
					.findByHQL(" from Department as d where d.dno='"
							+ department.getDno() + "'");
			System.out.println("s.size="+s.size());
			if (s.size() == 0) {
				departmentService.save(department);
			} else {
				departmentService.update(department);
			}
		} catch (ServiceException e) {
			
			return "error";
		}

		return "success";
	}


	// 删除
	public String deleteDepartment() {
		try {
			Department departments = departmentService.findById(Department.class,
					dno);
			departmentService.delete(departments);
		} catch (ServiceException e) {
			errstring="您所要删除的学院在其他表中仍有使用，故无法删除";
			return "errorstring";
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
		departmentmodel=null;
		try {
			page = 1;
			rows = 10;
			departmentList = departmentService.getAllDepartmentListByPage(page, rows,mno,dno);
			totalRows=departmentService.count(mno,dno);
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
	public String findDepartment() {
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
			if(departmentmodel==null){
				departmentmodel=new BaseModel();
				departmentmodel.setDepartmentId("");
				departmentmodel.setName("");
			}else if(departmentmodel.getName()!=null){
				departmentmodel.setName(java.net.URLDecoder.decode(departmentmodel.getName(),"UTF-8"));
			}
			if(!dno.equals("00000")&&mno.equals("000000")){
				departmentmodel.setDepartmentId(dno);
			}
			departmentList = departmentService.findDepartmentList(departmentmodel, page, rows);
			totalRows = departmentService.countFindDepartment(departmentmodel);
			System.out.println("totalRows"+totalRows);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println(totalPage);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
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

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public BaseModel getDepartmentmodel() {
		return departmentmodel;
	}

	public void setDepartmentmodel(BaseModel departmentmodel) {
		this.departmentmodel = departmentmodel;
	}

	public String getDno() {
		return dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getErrstring() {
		return errstring;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}
	
}
