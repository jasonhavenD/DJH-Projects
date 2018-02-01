package cn.edu.nwsuaf.bean;

/**
 * Funtionargs entity. @author MyEclipse Persistence Tools
 */

public class Funtionargs implements java.io.Serializable {

	// Fields

	private Integer id;
	private String funName;
	private Double funValue;
	private String funExplation;

	// Constructors

	/** default constructor */
	public Funtionargs() {
	}

	/** full constructor */
	public Funtionargs(String funName, Double funValue, String funExplation) {
		this.funName = funName;
		this.funValue = funValue;
		this.funExplation = funExplation;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFunName() {
		return this.funName;
	}

	public void setFunName(String funName) {
		this.funName = funName;
	}

	public Double getFunValue() {
		return this.funValue;
	}

	public void setFunValue(Double funValue) {
		this.funValue = funValue;
	}

	public String getFunExplation() {
		return this.funExplation;
	}

	public void setFunExplation(String funExplation) {
		this.funExplation = funExplation;
	}

}