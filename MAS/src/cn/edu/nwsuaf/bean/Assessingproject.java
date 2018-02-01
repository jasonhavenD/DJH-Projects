package cn.edu.nwsuaf.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Assessingproject entity. @author MyEclipse Persistence Tools
 */

public class Assessingproject implements java.io.Serializable {

	// Fields

	private Integer masprojectNo;
	private String masprojectName;
	private Date masprojectOpenDate;
	private Date masprojectEndDate;
	private String assessingExplation;
	private Integer tag;
	private Set assessingneedtargets = new HashSet(0);
	private Set assessingneedtargets_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Assessingproject() {
	}

	/** minimal constructor */
	public Assessingproject(String masprojectName, Date masprojectOpenDate,
			Date masprojectEndDate) {
		this.masprojectName = masprojectName;
		this.masprojectOpenDate = masprojectOpenDate;
		this.masprojectEndDate = masprojectEndDate;
	}

	/** full constructor */
	public Assessingproject(String masprojectName, Date masprojectOpenDate,
			Date masprojectEndDate, String assessingExplation, Integer tag,
			Set assessingneedtargets, Set assessingneedtargets_1) {
		this.masprojectName = masprojectName;
		this.masprojectOpenDate = masprojectOpenDate;
		this.masprojectEndDate = masprojectEndDate;
		this.assessingExplation = assessingExplation;
		this.tag = tag;
		this.assessingneedtargets = assessingneedtargets;
		this.assessingneedtargets_1 = assessingneedtargets_1;
	}

	// Property accessors

	public Integer getMasprojectNo() {
		return this.masprojectNo;
	}

	public void setMasprojectNo(Integer masprojectNo) {
		this.masprojectNo = masprojectNo;
	}

	public String getMasprojectName() {
		return this.masprojectName;
	}

	public void setMasprojectName(String masprojectName) {
		this.masprojectName = masprojectName;
	}

	public Date getMasprojectOpenDate() {
		return this.masprojectOpenDate;
	}

	public void setMasprojectOpenDate(Date masprojectOpenDate) {
		this.masprojectOpenDate = masprojectOpenDate;
	}

	public Date getMasprojectEndDate() {
		return this.masprojectEndDate;
	}

	public void setMasprojectEndDate(Date masprojectEndDate) {
		this.masprojectEndDate = masprojectEndDate;
	}

	public String getAssessingExplation() {
		return this.assessingExplation;
	}

	public void setAssessingExplation(String assessingExplation) {
		this.assessingExplation = assessingExplation;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

	public Set getAssessingneedtargets() {
		return this.assessingneedtargets;
	}

	public void setAssessingneedtargets(Set assessingneedtargets) {
		this.assessingneedtargets = assessingneedtargets;
	}

	public Set getAssessingneedtargets_1() {
		return this.assessingneedtargets_1;
	}

	public void setAssessingneedtargets_1(Set assessingneedtargets_1) {
		this.assessingneedtargets_1 = assessingneedtargets_1;
	}

}