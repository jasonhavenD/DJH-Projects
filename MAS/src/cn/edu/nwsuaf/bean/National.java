package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * National entity. @author MyEclipse Persistence Tools
 */

public class National implements java.io.Serializable {

	// Fields

	private String nationNnumber;
	private String nationName;
	private Set students = new HashSet(0);
	private Set students_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public National() {
	}

	/** minimal constructor */
	public National(String nationNnumber) {
		this.nationNnumber = nationNnumber;
	}

	/** full constructor */
	public National(String nationNnumber, String nationName, Set students,
			Set students_1) {
		this.nationNnumber = nationNnumber;
		this.nationName = nationName;
		this.students = students;
		this.students_1 = students_1;
	}

	// Property accessors

	public String getNationNnumber() {
		return this.nationNnumber;
	}

	public void setNationNnumber(String nationNnumber) {
		this.nationNnumber = nationNnumber;
	}

	public String getNationName() {
		return this.nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

	public Set getStudents_1() {
		return this.students_1;
	}

	public void setStudents_1(Set students_1) {
		this.students_1 = students_1;
	}

}