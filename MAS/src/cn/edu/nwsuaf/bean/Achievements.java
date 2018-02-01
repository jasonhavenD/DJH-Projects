package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Achievements entity. @author MyEclipse Persistence Tools
 */

public class Achievements implements java.io.Serializable {

	// Fields

	private String certificateNo;
	private String certificateName;
	private Integer departRank;
	private String certificateJibie;
	private String certificateType;
	private String certificateClass;
	private String certificateDate;
	private String beizhu;
	private Integer tag;
	private Set teacherachievementses = new HashSet(0);
	// Constructors

	/** default constructor */
	public Achievements() {
	}

	/** minimal constructor */
	public Achievements(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	/** full constructor */
	public Achievements(String certificateNo, String certificateName,
			Integer departRank, String certificateJibie,
			String certificateType, String certificateClass,
			String certificateDate, String beizhu, Integer tag,
			Set teacherachievementses) {
		this.certificateNo = certificateNo;
		this.certificateName = certificateName;
		this.departRank = departRank;
		this.certificateJibie = certificateJibie;
		this.certificateType = certificateType;
		this.certificateClass = certificateClass;
		this.certificateDate = certificateDate;
		this.beizhu = beizhu;
		this.tag = tag;
		this.teacherachievementses = teacherachievementses;
	}

	// Property accessors

	public String getCertificateNo() {
		return this.certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public String getCertificateName() {
		return this.certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public Integer getDepartRank() {
		return this.departRank;
	}

	public void setDepartRank(Integer departRank) {
		this.departRank = departRank;
	}

	public String getCertificateJibie() {
		return this.certificateJibie;
	}

	public void setCertificateJibie(String certificateJibie) {
		this.certificateJibie = certificateJibie;
	}

	public String getCertificateType() {
		return this.certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateClass() {
		return this.certificateClass;
	}

	public void setCertificateClass(String certificateClass) {
		this.certificateClass = certificateClass;
	}

	public String getCertificateDate() {
		return this.certificateDate;
	}

	public void setCertificateDate(String certificateDate) {
		this.certificateDate = certificateDate;
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

	public Set getTeacherachievementses() {
		return this.teacherachievementses;
	}

	public void setTeacherachievementses(Set teacherachievementses) {
		this.teacherachievementses = teacherachievementses;
	}

}