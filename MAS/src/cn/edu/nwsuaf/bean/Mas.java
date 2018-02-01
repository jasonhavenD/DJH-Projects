package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Mas entity. @author MyEclipse Persistence Tools
 */

public class Mas implements java.io.Serializable {

	// Fields

	private Integer masCode;
	private Major major;
	private Assessingneedtarget assessingneedtarget;
	private Float assessingScore;
	private Integer tag;
	private Set fileinfoAttachments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Mas() {
	}

	/** full constructor */
	public Mas(Major major, Assessingneedtarget assessingneedtarget,
			Float assessingScore, Integer tag, Set fileinfoAttachments) {
		this.major = major;
		this.assessingneedtarget = assessingneedtarget;
		this.assessingScore = assessingScore;
		this.tag = tag;
		this.fileinfoAttachments = fileinfoAttachments;
	}

	// Property accessors

	public Integer getMasCode() {
		return this.masCode;
	}

	public void setMasCode(Integer masCode) {
		this.masCode = masCode;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Assessingneedtarget getAssessingneedtarget() {
		return this.assessingneedtarget;
	}

	public void setAssessingneedtarget(Assessingneedtarget assessingneedtarget) {
		this.assessingneedtarget = assessingneedtarget;
	}

	public Float getAssessingScore() {
		return this.assessingScore;
	}

	public void setAssessingScore(Float assessingScore) {
		this.assessingScore = assessingScore;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

	public Set getFileinfoAttachments() {
		return this.fileinfoAttachments;
	}

	public void setFileinfoAttachments(Set fileinfoAttachments) {
		this.fileinfoAttachments = fileinfoAttachments;
	}

}