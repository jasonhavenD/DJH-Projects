package cn.edu.nwsuaf.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Teachproject entity. @author MyEclipse Persistence Tools
 */

public class Teachproject implements java.io.Serializable {

	// Fields

	private String tprojectNo;
	private String tprojectName;
	private String tprojecJibie;
	private String tprojecType;
	private String year;
	private String approvalNumber;
	private String beizhu;
	private Integer tag;
	private Timestamp tprojecTime;
	private Set teacherprojectusers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teachproject() {
	}

	/** minimal constructor */
	public Teachproject(String tprojectNo) {
		this.tprojectNo = tprojectNo;
	}

	/** full constructor */
	public Teachproject(String tprojectNo, String tprojectName,
			String tprojecJibie, String tprojecType, String year,
			String approvalNumber, String beizhu, Integer tag,
			Timestamp tprojecTime, Set teacherprojectusers) {
		this.tprojectNo = tprojectNo;
		this.tprojectName = tprojectName;
		this.tprojecJibie = tprojecJibie;
		this.tprojecType = tprojecType;
		this.year = year;
		this.approvalNumber = approvalNumber;
		this.beizhu = beizhu;
		this.tag = tag;
		this.tprojecTime = tprojecTime;
		this.teacherprojectusers = teacherprojectusers;
	}

	// Property accessors

	public String getTprojectNo() {
		return this.tprojectNo;
	}

	public void setTprojectNo(String tprojectNo) {
		this.tprojectNo = tprojectNo;
	}

	public String getTprojectName() {
		return this.tprojectName;
	}

	public void setTprojectName(String tprojectName) {
		this.tprojectName = tprojectName;
	}

	public String getTprojecJibie() {
		return this.tprojecJibie;
	}

	public void setTprojecJibie(String tprojecJibie) {
		this.tprojecJibie = tprojecJibie;
	}

	public String getTprojecType() {
		return this.tprojecType;
	}

	public void setTprojecType(String tprojecType) {
		this.tprojecType = tprojecType;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getApprovalNumber() {
		return this.approvalNumber;
	}

	public void setApprovalNumber(String approvalNumber) {
		this.approvalNumber = approvalNumber;
	}

	public String getBeizhu() {
		return this.beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

	public Timestamp getTprojecTime() {
		return this.tprojecTime;
	}

	public void setTprojecTime(Timestamp tprojecTime) {
		this.tprojecTime = tprojecTime;
	}

	public Set getTeacherprojectusers() {
		return this.teacherprojectusers;
	}

	public void setTeacherprojectusers(Set teacherprojectusers) {
		this.teacherprojectusers = teacherprojectusers;
	}

}