package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Majorclass entity. @author MyEclipse Persistence Tools
 */

public class Majorclass implements java.io.Serializable {

	// Fields

	private String classcode;
	private String classname;
	private Set majortoclasses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Majorclass() {
	}

	/** minimal constructor */
	public Majorclass(String classcode, String classname) {
		this.classcode = classcode;
		this.classname = classname;
	}

	/** full constructor */
	public Majorclass(String classcode, String classname, Set majortoclasses) {
		this.classcode = classcode;
		this.classname = classname;
		this.majortoclasses = majortoclasses;
	}

	// Property accessors

	public String getClasscode() {
		return this.classcode;
	}

	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}

	public String getClassname() {
		return this.classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Set getMajortoclasses() {
		return this.majortoclasses;
	}

	public void setMajortoclasses(Set majortoclasses) {
		this.majortoclasses = majortoclasses;
	}

}