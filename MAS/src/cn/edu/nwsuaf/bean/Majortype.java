package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Majortype entity. @author MyEclipse Persistence Tools
 */

public class Majortype implements java.io.Serializable {

	// Fields

	private String majorTypeId;
	private String majorTypeName;
	private Set majors = new HashSet(0);
	private Set majors_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Majortype() {
	}

	/** minimal constructor */
	public Majortype(String majorTypeId) {
		this.majorTypeId = majorTypeId;
	}

	/** full constructor */
	public Majortype(String majorTypeId, String majorTypeName, Set majors,
			Set majors_1) {
		this.majorTypeId = majorTypeId;
		this.majorTypeName = majorTypeName;
		this.majors = majors;
		this.majors_1 = majors_1;
	}

	// Property accessors

	public String getMajorTypeId() {
		return this.majorTypeId;
	}

	public void setMajorTypeId(String majorTypeId) {
		this.majorTypeId = majorTypeId;
	}

	public String getMajorTypeName() {
		return this.majorTypeName;
	}

	public void setMajorTypeName(String majorTypeName) {
		this.majorTypeName = majorTypeName;
	}

	public Set getMajors() {
		return this.majors;
	}

	public void setMajors(Set majors) {
		this.majors = majors;
	}

	public Set getMajors_1() {
		return this.majors_1;
	}

	public void setMajors_1(Set majors_1) {
		this.majors_1 = majors_1;
	}

}