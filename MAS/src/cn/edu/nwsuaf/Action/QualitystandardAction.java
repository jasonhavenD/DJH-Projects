package cn.edu.nwsuaf.Action;

import java.util.List;

import cn.edu.nwsuaf.Model.QualitystandardModel;
import cn.edu.nwsuaf.Service.Impl.QualitystandardService;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.bean.Qualitystandard;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class QualitystandardAction extends ActionSupport{
	
	    //课程质量标准
		private static final long serialVersionUID = 1L;

		// Service
		private QualitystandardService quastanService;//质量标准建设
		private DepartmentService departmentService;// 学院
		private MajorService majorService;// 专业
		
		// 传到前台下拉列表从数据库中读取显示
		private List<Qualitystandard> quastanList;// 质量标准建设	
		private List<Department> departmentList;// 学院	
		private List<Major> majorList;// 专业	
		
		// 前台获取属性
		private int page = 1;
		private int rows = 10;
		private int totalRows;
		private int totalPage;
		private String majorId;
		private String departmentId;		
		private Qualitystandard quastan;
		private QualitystandardModel quastanmodel=new QualitystandardModel();		
		private int quaNumber;
		private int rol;
		//错误提示
		private String errstring;

		public int getRol() {
			return rol;
		}

		public void setRol(int rol) {
			this.rol = rol;
		}
		//初始化修改or添加页面
		public String initEdit() throws ServiceException{
			
			if (quaNumber == 0) {
				quastan=null;
			} else {
				quastan = quastanService.findById(Qualitystandard.class, quaNumber);
			}	
			return "success";
		}
		
		//修改or添加
		public String modifiQualitystandard(){
			try {
				List<Qualitystandard> s;
				s=quastanService.findByHQL("from Qualitystandard as qu where qu.quaNumber="+quastan.getQuaNumber());
				if(s.size()==0){
					quastan.setMajor(majorService.findMajorById(quastan.getMajor().getMno()));
					quastanService.save(quastan);
				}else{
					quastan.setMajor(majorService.findMajorById(quastan.getMajor().getMno()));
					quastanService.update(quastan);
				}
			} catch (Exception e) {
				
				return "error";
			}
			
			return "success";
		}
		
		//删除
		public String deleteQualitystandard(){
			try {
				Qualitystandard delquastan=quastanService.findById(Qualitystandard.class, quaNumber);
				quastanService.delete(delquastan);
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
	        	setErrstring("登录超时！请安全退出再重新登录！");
	        	return "errorstring";
	        }
			quastanmodel=null;
			try {
				page = 1;
				rows = 10;
				departmentList = departmentService.findAll(Department.class);
				majorList = majorService.findAll(Major.class);	
				quastanList = quastanService.findallQualitystandardList(page,rows,mno,dno);	
				totalRows =  quastanService.count(mno, dno);
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
		//查找
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
				majorList = majorService.findAll(Major.class);
				if(!mno.equals("000000")){
					quastanmodel.setMajorId(mno);
					
				}else if(!dno.equals("00000")&&mno.equals("000000")){
					
					quastanmodel.setDepartmentId(dno);
				}if(quastanmodel==null){
					quastanmodel=new QualitystandardModel();
					quastanmodel.setBigallCount(null);
					quastanmodel.setBigcompleteCount(null);
					quastanmodel.setDepartmentId(null);
					quastanmodel.setLittleallCount(null);
					quastanmodel.setLittlecompleteCount(null);
					quastanmodel.setMajorId(null);
					quastanmodel.setYear("");
					
				}
				quastanList = quastanService.findQualitystandardList(quastanmodel, page, rows);
				totalRows = quastanService.countFindQualitystandard(quastanmodel);
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

		public QualitystandardService getQuastanService() {
			return quastanService;
		}

		public void setQuastanService(QualitystandardService quastanService) {
			this.quastanService = quastanService;
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

		public List<Qualitystandard> getQuastanList() {
			return quastanList;
		}

		public void setQuastanList(List<Qualitystandard> quastanList) {
			this.quastanList = quastanList;
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

		public Qualitystandard getQuastan() {
			return quastan;
		}

		public void setQuastan(Qualitystandard quastan) {
			this.quastan = quastan;
		}

		public QualitystandardModel getQuastanmodel() {
			return quastanmodel;
		}

		public void setQuastanmodel(QualitystandardModel quastanmodel) {
			this.quastanmodel = quastanmodel;
		}

		public int getQuaNumber() {
			return quaNumber;
		}

		public void setQuaNumber(int quaNumber) {
			this.quaNumber = quaNumber;
		}
}
