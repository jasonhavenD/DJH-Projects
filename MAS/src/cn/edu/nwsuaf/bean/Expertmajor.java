package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Expertmajor entity. @author MyEclipse Persistence Tools
 */

public class Expertmajor implements java.io.Serializable {

	// Fields

	private Integer expertMajorCode;
	private Major major;
	private Expert expert;
	private Assessingproject assessingproject;
	private Set expertadvices = new HashSet(0);

	// Constructors

	/** default constructor */
	public Expertmajor() {
	}

	/** minimal constructor */
	public Expertmajor(Assessingproject assessingproject) {
		this.assessingproject = assessingproject;
	}

	/** full constructor */
	public Expertmajor(Major major, Expert expert,
			Assessingproject assessingproject, Set expertadvices) {
		this.major = major;
		this.expert = expert;
		this.assessingproject = assessingproject;
		this.expertadvices = expertadvices;
	}

	// Property accessors

	public Integer getExpertMajorCode() {
		return this.expertMajorCode;
	}

	public void setExpertMajorCode(Integer expertMajorCode) {
		this.expertMajorCode = expertMajorCode;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Expert getExpert() {
		return this.expert;
	}

	public void setExpert(Expert expert) {
		this.expert = expert;
	}

	public Assessingproject getAssessingproject() {
		return this.assessingproject;
	}

	public void setAssessingproject(Assessingproject assessingproject) {
		this.assessingproject = assessingproject;
	}

	public Set getExpertadvices() {
		return this.expertadvices;
	}

	public void setExpertadvices(Set expertadvices) {
		this.expertadvices = expertadvices;
	}

}