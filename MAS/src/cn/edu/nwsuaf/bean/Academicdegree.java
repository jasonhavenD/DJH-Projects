package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Academicdegree entity. @author MyEclipse Persistence Tools
 */

public class Academicdegree implements java.io.Serializable {

	// Fields

	private String bestDegreeNo;
	private String bestDegreeName;
	private Set teachers = new HashSet(0);
	private Set teachers_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Academicdegree() {
	}

	/** minimal constructor */
	public Academicdegree(String bestDegreeNo) {
		this.bestDegreeNo = bestDegreeNo;
	}

	/** full constructor */
	public Academicdegree(String bestDegreeNo, String bestDegreeName,
			Set teachers, Set teachers_1) {
		this.bestDegreeNo = bestDegreeNo;
		this.bestDegreeName = bestDegreeName;
		this.teachers = teachers;
		this.teachers_1 = teachers_1;
	}

	// Property accessors

	public String getBestDegreeNo() {
		return this.bestDegreeNo;
	}

	public void setBestDegreeNo(String bestDegreeNo) {
		this.bestDegreeNo = bestDegreeNo;
	}

	public String getBestDegreeName() {
		return this.bestDegreeName;
	}

	public void setBestDegreeName(String bestDegreeName) {
		this.bestDegreeName = bestDegreeName;
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