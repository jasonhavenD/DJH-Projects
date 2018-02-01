package cn.edu.nwsuaf.Model;

public class AchieveModel {
	private String Id;//id
	private String Name;//名称
	private String majorId;//专业id
	private String departmentId;//学院id
	private Integer departRank;
	private String certificateJibie;
	private String certificateType;
	private String certificateClass;
	private String certificateDate;
	private String beizhu;
	private Integer tag;
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
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public Integer getDepartRank() {
		return departRank;
	}
	public void setDepartRank(Integer departRank) {
		this.departRank = departRank;
	}
	public String getCertificateJibie() {
		return certificateJibie;
	}
	public void setCertificateJibie(String certificateJibie) {
		this.certificateJibie = certificateJibie;
	}
	public String getCertificateType() {
		return certificateType;
	}
	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}
	public String getCertificateClass() {
		return certificateClass;
	}
	public void setCertificateClass(String certificateClass) {
		this.certificateClass = certificateClass;
	}
	public String getCertificateDate() {
		return certificateDate;
	}
	public void setCertificateDate(String certificateDate) {
		this.certificateDate = certificateDate;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public Integer getTag() {
		return tag;
	}
	public void setTag(Integer tag) {
		this.tag = tag;
	}
	
}
