package cn.edu.nwsuaf.Action;

import java.util.List;

import cn.edu.nwsuaf.Service.Impl.FuntionargsService;
import cn.edu.nwsuaf.bean.Funtionargs;
import cn.edu.nwsuaf.exception.ServiceException;

import com.opensymphony.xwork2.ActionSupport;

public class FuntionargsAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FuntionargsService funtionargsService;
	private List<Funtionargs> funvalueList;
	
	
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private int id;
	public String fName;//F名称
	
	private Funtionargs funtionargs;
	
	private int rol;
	

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	
	public String list() {

		return "list";
	}
	
	// 初始化修改页面
	public String initEdit() {

		try {
			if (id == 0) {
				funtionargs = null;
			} else {

				funtionargs = funtionargsService.findById(Funtionargs.class, id);
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	
	//修改
	public String modifiFuntionargs(){

		try {
			List<Funtionargs> s;
			s = funtionargsService
					.findBySQL("select * from funtionargs where id="
							+ funtionargs.getId());
			if (s.size() == 0) {
				funtionargsService.save(funtionargs);
			} else {
				funtionargsService.update(funtionargs);
			}
		} catch (Exception e) {
			
			return "error";
		}
		
		return "success";
	}
	
	//添加
	public String insertFuntionargs(){
		try {
			funtionargsService.save(funtionargs);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	
	// 删除
	public String deleteFuntionargs() {
		try {
			funtionargs = funtionargsService.findById(Funtionargs.class, id);
			funtionargsService.delete(funtionargs);
		} catch (ServiceException e) {
			
			return "error";
		}

		return "success";
	}
	
	// 初始化信息，用于页面显示数据库中信息
	public String initSearch() {
		try {
			funvalueList = funtionargsService.getAllFuntionargsListByPage(page, rows);
			
			totalRows = funtionargsService.findAll(Funtionargs.class).size();
			if (totalRows % rows == 0){
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0?1:(totalRows/rows+1);
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "success";

	}
	
	// 依据主键查询F值信息
	public String getFvalueById() {
		try {
			funtionargs = funtionargsService.findById(Funtionargs.class, id);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";

	}
	
	// 依据名称查询F值信息
	public String getFvalueByName() {
		try {
			if(fName==null||fName.equals("")){
				funvalueList = funtionargsService.getAllFuntionargsListByPage(page, rows);
				
				totalRows = funtionargsService.findAll(Funtionargs.class).size();
				if (totalRows % rows == 0){
					totalPage = totalRows / rows;
				} else {
					totalPage = totalRows == 0?1:(totalRows/rows+1);
				}
			}else{

				funvalueList = funtionargsService.findFuntionargsByNamePage(fName,page,rows);
			}
			
		} catch (Exception e) {
			
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
	public Funtionargs getFuntionargs() {
		return funtionargs;
	}
	public void setFuntionargs(Funtionargs funtionargs) {
		this.funtionargs = funtionargs;
	}
	public void setFunvalueList(List<Funtionargs> funvalueList) {
		this.funvalueList = funvalueList;
	}
	public FuntionargsService getFuntionargsService() {
		return funtionargsService;
	}
	public void setFuntionargsService(FuntionargsService funtionargsService) {
		this.funtionargsService = funtionargsService;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public List<Funtionargs> getFunvalueList() {
		return funvalueList;
	}

}
