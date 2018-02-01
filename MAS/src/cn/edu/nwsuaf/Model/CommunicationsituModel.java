package cn.edu.nwsuaf.Model;

import cn.edu.nwsuaf.bean.Major;

public class CommunicationsituModel extends BaseModel{
	 
	
	private Integer comNumber;
     private Major major;
     private String year;
     private Integer projCounts;
     private Integer stuCount;
     private String note;
     
     
	public Integer getComNumber() {
		return comNumber;
	}
	public void setComNumber(Integer comNumber) {
		this.comNumber = comNumber;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Integer getProjCounts() {
		return projCounts;
	}
	public void setProjCounts(Integer projCounts) {
		this.projCounts = projCounts;
	}
	public Integer getStuCount() {
		return stuCount;
	}
	public void setStuCount(Integer stuCount) {
		this.stuCount = stuCount;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
     
     
     
}
