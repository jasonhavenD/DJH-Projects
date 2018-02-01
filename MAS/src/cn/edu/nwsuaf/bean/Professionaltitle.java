package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Professionaltitle entity. @author MyEclipse Persistence Tools
 */

public class Professionaltitle implements java.io.Serializable {

	// Fields

	private String professionalTitleNo;
	private String professionalTitleName;
	private Set teachers = new HashSet(0);
	private Set teachers_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Professionaltitle() {
	}

	/** minimal constructor */
	public Professionaltitle(String professionalTitleNo) {
		this.professionalTitleNo = professionalTitleNo;
	}

	/** full constructor */
	public Professionaltitle(String professionalTitleNo,
			String professionalTitleName, Set teachers, Set teachers_1) {
		this.professionalTitleNo = professionalTitleNo;
		this.professionalTitleName = professionalTitleName;
		this.teachers = teachers;
		this.teachers_1 = teachers_1;
	}

	// Property accessors

	public String getProfessionalTitleNo() {
		return this.professionalTitleNo;
	}

	public void setProfessionalTitleNo(String professionalTitleNo) {
		this.professionalTitleNo = professionalTitleNo;
	}

	public String getProfessionalTitleName() {
		return this.professionalTitleName;
	}

	public void setProfessionalTitleName(String professionalTitleName) {
		this.professionalTitleName = professionalTitleName;
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