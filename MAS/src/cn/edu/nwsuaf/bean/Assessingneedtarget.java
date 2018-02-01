package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Assessingneedtarget entity. @author MyEclipse Persistence Tools
 */

public class Assessingneedtarget implements java.io.Serializable {

	// Fields

	private Integer assessingNeedTargetNo;
	private Appraisalsystem appraisalsystem;
	private Assessingproject assessingproject;
	private Float indicatorWeight;
	private Integer status;
	private Integer tag;
	private Set mases = new HashSet(0);

	// Constructors

	/** default constructor */
	public Assessingneedtarget() {
	}

	/** minimal constructor */
	public Assessingneedtarget(Float indicatorWeight) {
		this.indicatorWeight = indicatorWeight;
	}

	/** full constructor */
	public Assessingneedtarget(Appraisalsystem appraisalsystem,
			Assessingproject assessingproject, Float indicatorWeight,
			Integer status, Integer tag, Set mases) {
		this.appraisalsystem = appraisalsystem;
		this.assessingproject = assessingproject;
		this.indicatorWeight = indicatorWeight;
		this.status = status;
		this.tag = tag;
		this.mases = mases;
	}

	// Property accessors

	public Integer getAssessingNeedTargetNo() {
		return this.assessingNeedTargetNo;
	}

	public void setAssessingNeedTargetNo(Integer assessingNeedTargetNo) {
		this.assessingNeedTargetNo = assessingNeedTargetNo;
	}

	public Appraisalsystem getAppraisalsystem() {
		return this.appraisalsystem;
	}

	public void setAppraisalsystem(Appraisalsystem appraisalsystem) {
		this.appraisalsystem = appraisalsystem;
	}

	public Assessingproject getAssessingproject() {
		return this.assessingproject;
	}

	public void setAssessingproject(Assessingproject assessingproject) {
		this.assessingproject = assessingproject;
	}

	public Float getIndicatorWeight() {
		return this.indicatorWeight;
	}

	public void setIndicatorWeight(Float indicatorWeight) {
		this.indicatorWeight = indicatorWeight;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

	public Set getMases() {
		return this.mases;
	}

	public void setMases(Set mases) {
		this.mases = mases;
	}

}