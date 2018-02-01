package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Jobtype entity. @author MyEclipse Persistence Tools
 */

public class Jobtype implements java.io.Serializable {

	// Fields

	private String jobTypeNo;
	private String jobTypeName;
	private Set teachers = new HashSet(0);
	private Set teachers_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Jobtype() {
	}

	/** minimal constructor */
	public Jobtype(String jobTypeNo) {
		this.jobTypeNo = jobTypeNo;
	}

	/** full constructor */
	public Jobtype(String jobTypeNo, String jobTypeName, Set teachers,
			Set teachers_1) {
		this.jobTypeNo = jobTypeNo;
		this.jobTypeName = jobTypeName;
		this.teachers = teachers;
		this.teachers_1 = teachers_1;
	}

	// Property accessors

	public String getJobTypeNo() {
		return this.jobTypeNo;
	}

	public void setJobTypeNo(String jobTypeNo) {
		this.jobTypeNo = jobTypeNo;
	}

	public String getJobTypeName() {
		return this.jobTypeName;
	}

	public void setJobTypeName(String jobTypeName) {
		this.jobTypeName = jobTypeName;
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