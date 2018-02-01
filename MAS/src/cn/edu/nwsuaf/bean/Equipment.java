package cn.edu.nwsuaf.bean;

/**
 * Equipment entity. @author MyEclipse Persistence Tools
 */

public class Equipment implements java.io.Serializable {

	// Fields

	private Integer equipNumber;
	private Trainingvenue trainingvenue;
	private String equipName;
	private Float ervValue;
	private Integer count;
	private Double allValue;
	private String year;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Equipment() {
	}

	/** full constructor */
	public Equipment(Trainingvenue trainingvenue, String equipName,
			Float ervValue, Integer count, Double allValue, String year,
			Integer tag) {
		this.trainingvenue = trainingvenue;
		this.equipName = equipName;
		this.ervValue = ervValue;
		this.count = count;
		this.allValue = allValue;
		this.year = year;
		this.tag = tag;
	}

	// Property accessors

	public Integer getEquipNumber() {
		return this.equipNumber;
	}

	public void setEquipNumber(Integer equipNumber) {
		this.equipNumber = equipNumber;
	}

	public Trainingvenue getTrainingvenue() {
		return this.trainingvenue;
	}

	public void setTrainingvenue(Trainingvenue trainingvenue) {
		this.trainingvenue = trainingvenue;
	}

	public String getEquipName() {
		return this.equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}

	public Float getErvValue() {
		return this.ervValue;
	}

	public void setErvValue(Float ervValue) {
		this.ervValue = ervValue;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getAllValue() {
		return this.allValue;
	}

	public void setAllValue(Double allValue) {
		this.allValue = allValue;
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

}