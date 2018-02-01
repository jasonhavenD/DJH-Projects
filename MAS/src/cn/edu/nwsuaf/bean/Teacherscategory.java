package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Teacherscategory entity. @author MyEclipse Persistence Tools
 */

public class Teacherscategory implements java.io.Serializable {

	// Fields

	private String teachersCategoryNo;
	private String teachersCategoryName;
	private Set teachers = new HashSet(0);
	private Set teachers_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teacherscategory() {
	}

	/** minimal constructor */
	public Teacherscategory(String teachersCategoryNo) {
		this.teachersCategoryNo = teachersCategoryNo;
	}

	/** full constructor */
	public Teacherscategory(String teachersCategoryNo,
			String teachersCategoryName, Set teachers, Set teachers_1) {
		this.teachersCategoryNo = teachersCategoryNo;
		this.teachersCategoryName = teachersCategoryName;
		this.teachers = teachers;
		this.teachers_1 = teachers_1;
	}

	// Property accessors

	public String getTeachersCategoryNo() {
		return this.teachersCategoryNo;
	}

	public void setTeachersCategoryNo(String teachersCategoryNo) {
		this.teachersCategoryNo = teachersCategoryNo;
	}

	public String getTeachersCategoryName() {
		return this.teachersCategoryName;
	}

	public void setTeachersCategoryName(String teachersCategoryName) {
		this.teachersCategoryName = teachersCategoryName;
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