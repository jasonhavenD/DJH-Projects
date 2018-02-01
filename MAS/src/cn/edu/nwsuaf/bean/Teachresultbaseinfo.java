package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Teachresultbaseinfo entity. @author MyEclipse Persistence Tools
 */

public class Teachresultbaseinfo implements java.io.Serializable {

	// Fields

	private Integer tresultBaseNo;
	private String tresultName;
	private String tresultJibie;
	private String tresultClass;
	private String year;
	private String approvalNumber;
	private String rewardDepart;
	private String beizhu;
	private Integer tag;
	private Set teachresults = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teachresultbaseinfo() {
	}

	/** minimal constructor */
	public Teachresultbaseinfo(Integer tresultBaseNo) {
		this.tresultBaseNo = tresultBaseNo;
	}

	/** full constructor */
	public Teachresultbaseinfo(Integer tresultBaseNo, String tresultName,
			String tresultJibie, String tresultClass, String year,
			String approvalNumber, String rewardDepart, String beizhu,
			Integer tag, Set teachresults) {
		this.tresultBaseNo = tresultBaseNo;
		this.tresultName = tresultName;
		this.tresultJibie = tresultJibie;
		this.tresultClass = tresultClass;
		this.year = year;
		this.approvalNumber = approvalNumber;
		this.rewardDepart = rewardDepart;
		this.beizhu = beizhu;
		this.tag = tag;
		this.teachresults = teachresults;
	}

	// Property accessors

	public Integer getTresultBaseNo() {
		return this.tresultBaseNo;
	}

	public void setTresultBaseNo(Integer tresultBaseNo) {
		this.tresultBaseNo = tresultBaseNo;
	}

	public String getTresultName() {
		return this.tresultName;
	}

	public void setTresultName(String tresultName) {
		this.tresultName = tresultName;
	}

	public String getTresultJibie() {
		return this.tresultJibie;
	}

	public void setTresultJibie(String tresultJibie) {
		this.tresultJibie = tresultJibie;
	}

	public String getTresultClass() {
		return this.tresultClass;
	}

	public void setTresultClass(String tresultClass) {
		this.tresultClass = tresultClass;
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

	public String getRewardDepart() {
		return this.rewardDepart;
	}

	public void setRewardDepart(String rewardDepart) {
		this.rewardDepart = rewardDepart;
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

	public Set getTeachresults() {
		return this.teachresults;
	}

	public void setTeachresults(Set teachresults) {
		this.teachresults = teachresults;
	}

}