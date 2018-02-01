package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Teachingcosttype entity. @author MyEclipse Persistence Tools
 */

public class Teachingcosttype implements java.io.Serializable {

	// Fields

	private String teachCostTypeNo;
	private String useType;
	private Set teachingcosts = new HashSet(0);
	private Set teachingcosts_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teachingcosttype() {
	}

	/** minimal constructor */
	public Teachingcosttype(String teachCostTypeNo) {
		this.teachCostTypeNo = teachCostTypeNo;
	}

	/** full constructor */
	public Teachingcosttype(String teachCostTypeNo, String useType,
			Set teachingcosts, Set teachingcosts_1) {
		this.teachCostTypeNo = teachCostTypeNo;
		this.useType = useType;
		this.teachingcosts = teachingcosts;
		this.teachingcosts_1 = teachingcosts_1;
	}

	// Property accessors

	public String getTeachCostTypeNo() {
		return this.teachCostTypeNo;
	}

	public void setTeachCostTypeNo(String teachCostTypeNo) {
		this.teachCostTypeNo = teachCostTypeNo;
	}

	public String getUseType() {
		return this.useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}

	public Set getTeachingcosts() {
		return this.teachingcosts;
	}

	public void setTeachingcosts(Set teachingcosts) {
		this.teachingcosts = teachingcosts;
	}

	public Set getTeachingcosts_1() {
		return this.teachingcosts_1;
	}

	public void setTeachingcosts_1(Set teachingcosts_1) {
		this.teachingcosts_1 = teachingcosts_1;
	}

}