package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Majorcategory entity. @author MyEclipse Persistence Tools
 */

public class Majorcategory implements java.io.Serializable {

	// Fields

	private String majorCategoryId;
	private String majorCategoryName;
	private Set majors = new HashSet(0);
	private Set majors_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Majorcategory() {
	}

	/** minimal constructor */
	public Majorcategory(String majorCategoryId) {
		this.majorCategoryId = majorCategoryId;
	}

	/** full constructor */
	public Majorcategory(String majorCategoryId, String majorCategoryName,
			Set majors, Set majors_1) {
		this.majorCategoryId = majorCategoryId;
		this.majorCategoryName = majorCategoryName;
		this.majors = majors;
		this.majors_1 = majors_1;
	}

	// Property accessors

	public String getMajorCategoryId() {
		return this.majorCategoryId;
	}

	public void setMajorCategoryId(String majorCategoryId) {
		this.majorCategoryId = majorCategoryId;
	}

	public String getMajorCategoryName() {
		return this.majorCategoryName;
	}

	public void setMajorCategoryName(String majorCategoryName) {
		this.majorCategoryName = majorCategoryName;
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