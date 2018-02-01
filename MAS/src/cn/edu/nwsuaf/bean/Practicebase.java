package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Practicebase entity. @author MyEclipse Persistence Tools
 */

public class Practicebase implements java.io.Serializable {

	// Fields

	private String pracNumer;
	private String baseName;
	private String address;
	private Integer everyAccept;
	private Integer yearsAccept;
	private String year;
	private Integer tag;
	private Set basevenueuses = new HashSet(0);
	private Set basevenueuses_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Practicebase() {
	}

	/** minimal constructor */
	public Practicebase(String pracNumer) {
		this.pracNumer = pracNumer;
	}

	/** full constructor */
	public Practicebase(String pracNumer, String baseName, String address,
			Integer everyAccept, Integer yearsAccept, String year, Integer tag,
			Set basevenueuses, Set basevenueuses_1) {
		this.pracNumer = pracNumer;
		this.baseName = baseName;
		this.address = address;
		this.everyAccept = everyAccept;
		this.yearsAccept = yearsAccept;
		this.year = year;
		this.tag = tag;
		this.basevenueuses = basevenueuses;
		this.basevenueuses_1 = basevenueuses_1;
	}

	// Property accessors

	public String getPracNumer() {
		return this.pracNumer;
	}

	public void setPracNumer(String pracNumer) {
		this.pracNumer = pracNumer;
	}

	public String getBaseName() {
		return this.baseName;
	}

	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getEveryAccept() {
		return this.everyAccept;
	}

	public void setEveryAccept(Integer everyAccept) {
		this.everyAccept = everyAccept;
	}

	public Integer getYearsAccept() {
		return this.yearsAccept;
	}

	public void setYearsAccept(Integer yearsAccept) {
		this.yearsAccept = yearsAccept;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

	public Set getBasevenueuses() {
		return this.basevenueuses;
	}

	public void setBasevenueuses(Set basevenueuses) {
		this.basevenueuses = basevenueuses;
	}

	public Set getBasevenueuses_1() {
		return this.basevenueuses_1;
	}

	public void setBasevenueuses_1(Set basevenueuses_1) {
		this.basevenueuses_1 = basevenueuses_1;
	}

}