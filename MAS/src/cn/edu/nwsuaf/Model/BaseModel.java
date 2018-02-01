package cn.edu.nwsuaf.Model;

import cn.edu.nwsuaf.bean.Major;

public class BaseModel {

	private String Id;//id
	private String Name;//名称
	private String majorId;//专业id
	private String departmentId;//学院id
	private String year;//年份
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	@Override  
	 public boolean equals(Object obj) {  
	          
	        boolean flag = obj instanceof BaseModel;  
	        if(flag == false){  
	            return false;  
	        }  
	        BaseModel base = (BaseModel)obj;  
	        if(this.getId().equals(base.getId())){  
	            return true;  
	        }else {
	            return false;  
	        }  
	}
	
}
