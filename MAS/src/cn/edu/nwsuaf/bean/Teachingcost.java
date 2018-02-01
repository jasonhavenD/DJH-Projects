package cn.edu.nwsuaf.bean;

/**
 * Teachingcost entity. @author MyEclipse Persistence Tools
 */

public class Teachingcost implements java.io.Serializable {

	// Fields

	private Integer costNumber;
	private Major major;
	private Teachingcosttype teachingcosttype;
	private Integer stuNumber;
	private Double cost;
	private String useness;
	private Integer tag;
	private String year;

	// Constructors

	/** default constructor */
	public Teachingcost() {
	}

	/** full constructor */
	public Teachingcost(Major major, Teachingcosttype teachingcosttype,
			Integer stuNumber, Double cost, String useness, Integer tag,
			String year) {
		this.major = major;
		this.teachingcosttype = teachingcosttype;
		this.stuNumber = stuNumber;
		this.cost = cost;
		this.useness = useness;
		this.tag = tag;
		this.year = year;
	}

	// Property accessors

	public Integer getCostNumber() {
		return this.costNumber;
	}

	public void setCostNumber(Integer costNumber) {
		this.costNumber = costNumber;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Teachingcosttype getTeachingcosttype() {
		return this.teachingcosttype;
	}

	public void setTeachingcosttype(Teachingcosttype teachingcosttype) {
		this.teachingcosttype = teachingcosttype;
	}

	public Integer getStuNumber() {
		return this.stuNumber;
	}

	public void setStuNumber(Integer stuNumber) {
		this.stuNumber = stuNumber;
	}

	public Double getCost() {
		return this.cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getUseness() {
		return this.useness;
	}

	public void setUseness(String useness) {
		this.useness = useness;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}