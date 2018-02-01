package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Learningedge entity. @author MyEclipse Persistence Tools
 */

public class Learningedge implements java.io.Serializable {

	// Fields

	private String learnEdgeNo;
	private String learnEdgeName;
	private Set teachers = new HashSet(0);
	private Set teachers_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Learningedge() {
	}

	/** minimal constructor */
	public Learningedge(String learnEdgeNo) {
		this.learnEdgeNo = learnEdgeNo;
	}

	/** full constructor */
	public Learningedge(String learnEdgeNo, String learnEdgeName, Set teachers,
			Set teachers_1) {
		this.learnEdgeNo = learnEdgeNo;
		this.learnEdgeName = learnEdgeName;
		this.teachers = teachers;
		this.teachers_1 = teachers_1;
	}

	// Property accessors

	public String getLearnEdgeNo() {
		return this.learnEdgeNo;
	}

	public void setLearnEdgeNo(String learnEdgeNo) {
		this.learnEdgeNo = learnEdgeNo;
	}

	public String getLearnEdgeName() {
		return this.learnEdgeName;
	}

	public void setLearnEdgeName(String learnEdgeName) {
		this.learnEdgeName = learnEdgeName;
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