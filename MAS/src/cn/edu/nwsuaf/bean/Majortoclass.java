package cn.edu.nwsuaf.bean;

/**
 * Majortoclass entity. @author MyEclipse Persistence Tools
 */

public class Majortoclass implements java.io.Serializable {

	// Fields

	private Integer mcid;
	private Major major;
	private Majorclass majorclass;

	// Constructors

	/** default constructor */
	public Majortoclass() {
	}

	/** full constructor */
	public Majortoclass(Major major, Majorclass majorclass) {
		this.major = major;
		this.majorclass = majorclass;
	}

	// Property accessors

	public Integer getMcid() {
		return this.mcid;
	}

	public void setMcid(Integer mcid) {
		this.mcid = mcid;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Majorclass getMajorclass() {
		return this.majorclass;
	}

	public void setMajorclass(Majorclass majorclass) {
		this.majorclass = majorclass;
	}

}