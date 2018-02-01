package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Appraisalsystem entity. @author MyEclipse Persistence Tools
 */

public class Appraisalsystem implements java.io.Serializable {

	// Fields

	private String indicatorId;
	private String indicatorName;
	private String pid;
	private String indNameExp;
	private String type;
	private Set assessingneedtargets = new HashSet(0);
	private Set assessingneedtargets_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Appraisalsystem() {
	}

	/** minimal constructor */
	public Appraisalsystem(String indicatorId, String indicatorName, String pid) {
		this.indicatorId = indicatorId;
		this.indicatorName = indicatorName;
		this.pid = pid;
	}

	/** full constructor */
	public Appraisalsystem(String indicatorId, String indicatorName,
			String pid, String indNameExp, String type,
			Set assessingneedtargets, Set assessingneedtargets_1) {
		this.indicatorId = indicatorId;
		this.indicatorName = indicatorName;
		this.pid = pid;
		this.indNameExp = indNameExp;
		this.type = type;
		this.assessingneedtargets = assessingneedtargets;
		this.assessingneedtargets_1 = assessingneedtargets_1;
	}

	// Property accessors

	public String getIndicatorId() {
		return this.indicatorId;
	}

	public void setIndicatorId(String indicatorId) {
		this.indicatorId = indicatorId;
	}

	public String getIndicatorName() {
		return this.indicatorName;
	}

	public void setIndicatorName(String indicatorName) {
		this.indicatorName = indicatorName;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getIndNameExp() {
		return this.indNameExp;
	}

	public void setIndNameExp(String indNameExp) {
		this.indNameExp = indNameExp;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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