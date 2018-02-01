package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Degree entity. @author MyEclipse Persistence Tools
 */

public class Degree implements java.io.Serializable {

	// Fields

	private String degreeNo;
	private String degreeName;
	private Set teachers = new HashSet(0);
	private Set teachers_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Degree() {
	}

	/** minimal constructor */
	public Degree(String degreeNo) {
		this.degreeNo = degreeNo;
	}

	/** full constructor */
	public Degree(String degreeNo, String degreeName, Set teachers,
			Set teachers_1) {
		this.degreeNo = degreeNo;
		this.degreeName = degreeName;
		this.teachers = teachers;
		this.teachers_1 = teachers_1;
	}

	// Property accessors

	public String getDegreeNo() {
		return this.degreeNo;
	}

	public void setDegreeNo(String degreeNo) {
		this.degreeNo = degreeNo;
	}

	public String getDegreeName() {
		return this.degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
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