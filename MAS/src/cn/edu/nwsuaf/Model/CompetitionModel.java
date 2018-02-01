package cn.edu.nwsuaf.Model;

public class CompetitionModel {
	private String comNumber;
	private String comName;
	private String comType;
	private String comRank;
	private String year;
	private String note;
	private Integer tag;
	private String majorId;//专业id
	private String departmentId;//学院id
	
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
	public String getComNumber() {
		return comNumber;
	}
	public void setComNumber(String comNumber) {
		this.comNumber = comNumber;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getComType() {
		return comType;
	}
	public void setComType(String comType) {
		this.comType = comType;
	}
	public String getComRank() {
		return comRank;
	}
	public void setComRank(String comRank) {
		this.comRank = comRank;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getTag() {
		return tag;
	}
	public void setTag(Integer tag) {
		this.tag = tag;
	}
	

}
