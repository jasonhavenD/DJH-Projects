package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private String dno;
	private String dname;
	private String fuzeren;
	private Set majors = new HashSet(0);
	private Set majors_1 = new HashSet(0);
	private Set courses = new HashSet(0);
	private Set courses_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(String dno) {
		this.dno = dno;
	}

	/** full constructor */
	public Department(String dno, String dname, String fuzeren, Set majors,
			Set majors_1, Set courses, Set courses_1) {
		this.dno = dno;
		this.dname = dname;
		this.fuzeren = fuzeren;
		this.majors = majors;
		this.majors_1 = majors_1;
		this.courses = courses;
		this.courses_1 = courses_1;
	}

	// Property accessors

	public String getDno() {
		return this.dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getFuzeren() {
		return this.fuzeren;
	}

	public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
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

	public Set getCourses() {
		return this.courses;
	}

	public void setCourses(Set courses) {
		this.courses = courses;
	}

	public Set getCourses_1() {
		return this.courses_1;
	}

	public void setCourses_1(Set courses_1) {
		this.courses_1 = courses_1;
	}

}