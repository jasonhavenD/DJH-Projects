package cn.edu.nwsuaf.Model;

import java.sql.Date;

public class StupatentModel  extends BaseModel{
	private String stuNumber;
	private String stuName;
	private Date authorityDate;
	private String pateType;
	private String patentNumber;
	private String note;
	
	public String getStuNumber() {
		return stuNumber;
	}
	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
	}
	
	public Date getAuthorityDate() {
		return authorityDate;
	}
	public void setAuthorityDate(Date authorityDate) {
		this.authorityDate = authorityDate;
	}
	public String getPateType() {
		return pateType;
	}
	public void setPateType(String pateType) {
		this.pateType = pateType;
	}
	
	public String getPatentNumber() {
		return patentNumber;
	}
	public void setPatentNumber(String patentNumber) {
		this.patentNumber = patentNumber;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuName() {
		return stuName;
	}
	
}
