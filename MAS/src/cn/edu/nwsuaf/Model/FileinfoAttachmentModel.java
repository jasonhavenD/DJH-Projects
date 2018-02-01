package cn.edu.nwsuaf.Model;

import java.sql.Timestamp;

public class FileinfoAttachmentModel extends BaseModel{
	private String attachmentId;
	private String masCode;
	private String orginalName;
	private String actualName;
	private String actualPath;
	private String year;
	private Timestamp uploadDate;
	private String uploadPerson;
	private String indexFileType;
	private Float asseisingValue;
	private Integer uploadStatus;
	public String getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}
	public String getMasCode() {
		return masCode;
	}
	public void setMasCode(String masCode) {
		this.masCode = masCode;
	}
	public String getOrginalName() {
		return orginalName;
	}
	public void setOrginalName(String orginalName) {
		this.orginalName = orginalName;
	}
	public String getActualName() {
		return actualName;
	}
	public void setActualName(String actualName) {
		this.actualName = actualName;
	}
	public String getActualPath() {
		return actualPath;
	}
	public void setActualPath(String actualPath) {
		this.actualPath = actualPath;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Timestamp getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Timestamp uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getUploadPerson() {
		return uploadPerson;
	}
	public void setUploadPerson(String uploadPerson) {
		this.uploadPerson = uploadPerson;
	}
	public String getIndexFileType() {
		return indexFileType;
	}
	public void setIndexFileType(String indexFileType) {
		this.indexFileType = indexFileType;
	}
	public Float getAsseisingValue() {
		return asseisingValue;
	}
	public void setAsseisingValue(Float asseisingValue) {
		this.asseisingValue = asseisingValue;
	}
	public Integer getUploadStatus() {
		return uploadStatus;
	}
	public void setUploadStatus(Integer uploadStatus) {
		this.uploadStatus = uploadStatus;
	}
	
	
	
}
