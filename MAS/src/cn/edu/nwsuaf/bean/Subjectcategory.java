package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Subjectcategory entity. @author MyEclipse Persistence Tools
 */

public class Subjectcategory implements java.io.Serializable {

	// Fields

	private String subjectCategoryNo;
	private String subjectCategoryName;
	private Set teachers = new HashSet(0);
	private Set teachers_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Subjectcategory() {
	}

	/** minimal constructor */
	public Subjectcategory(String subjectCategoryNo) {
		this.subjectCategoryNo = subjectCategoryNo;
	}

	/** full constructor */
	public Subjectcategory(String subjectCategoryNo,
			String subjectCategoryName, Set teachers, Set teachers_1) {
		this.subjectCategoryNo = subjectCategoryNo;
		this.subjectCategoryName = subjectCategoryName;
		this.teachers = teachers;
		this.teachers_1 = teachers_1;
	}

	// Property accessors

	public String getSubjectCategoryNo() {
		return this.subjectCategoryNo;
	}

	public void setSubjectCategoryNo(String subjectCategoryNo) {
		this.subjectCategoryNo = subjectCategoryNo;
	}

	public String getSubjectCategoryName() {
		return this.subjectCategoryName;
	}

	public void setSubjectCategoryName(String subjectCategoryName) {
		this.subjectCategoryName = subjectCategoryName;
	}

	public Set getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set teachers) {
		this.teachers = teachers;
	}

	public Set getTeachers_1() {
		return this.teachers_1;
	}

	public void setTeachers_1(Set teachers_1) {
		this.teachers_1 = teachers_1;
	}

}