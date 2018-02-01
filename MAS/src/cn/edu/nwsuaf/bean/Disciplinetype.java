package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Disciplinetype entity. @author MyEclipse Persistence Tools
 */

public class Disciplinetype implements java.io.Serializable {

	// Fields

	private String disciplineTypeId;
	private String disciplineTypeName;
	private Set majors = new HashSet(0);
	private Set majors_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Disciplinetype() {
	}

	/** minimal constructor */
	public Disciplinetype(String disciplineTypeId) {
		this.disciplineTypeId = disciplineTypeId;
	}

	/** full constructor */
	public Disciplinetype(String disciplineTypeId, String disciplineTypeName,
			Set majors, Set majors_1) {
		this.disciplineTypeId = disciplineTypeId;
		this.disciplineTypeName = disciplineTypeName;
		this.majors = majors;
		this.majors_1 = majors_1;
	}

	// Property accessors

	public String getDisciplineTypeId() {
		return this.disciplineTypeId;
	}

	public void setDisciplineTypeId(String disciplineTypeId) {
		this.disciplineTypeId = disciplineTypeId;
	}

	public String getDisciplineTypeName() {
		return this.disciplineTypeName;
	}

	public void setDisciplineTypeName(String disciplineTypeName) {
		this.disciplineTypeName = disciplineTypeName;
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

}