package cn.edu.nwsuaf.bean;

/**
 * Traininguseinginformation entity. @author MyEclipse Persistence Tools
 */

public class Traininguseinginformation implements java.io.Serializable {

	// Fields

	private Integer praId;
	private Major major;
	private String year;
	private Integer resourceConstructionNumber;
	private Integer experimentalEquipmentMean;
	private Float laboratorySatisfactionRate;
	private Integer experimentNumber;
	private Integer schooBaseNumber;
	private Integer outBaseNumber;
	private Float schooBaseRate;
	private Float outBaseRate;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Traininguseinginformation() {
	}

	/** minimal constructor */
	public Traininguseinginformation(Integer praId) {
		this.praId = praId;
	}

	/** full constructor */
	public Traininguseinginformation(Integer praId, Major major, String year,
			Integer resourceConstructionNumber,
			Integer experimentalEquipmentMean,
			Float laboratorySatisfactionRate, Integer experimentNumber,
			Integer schooBaseNumber, Integer outBaseNumber,
			Float schooBaseRate, Float outBaseRate, Integer tag) {
		this.praId = praId;
		this.major = major;
		this.year = year;
		this.resourceConstructionNumber = resourceConstructionNumber;
		this.experimentalEquipmentMean = experimentalEquipmentMean;
		this.laboratorySatisfactionRate = laboratorySatisfactionRate;
		this.experimentNumber = experimentNumber;
		this.schooBaseNumber = schooBaseNumber;
		this.outBaseNumber = outBaseNumber;
		this.schooBaseRate = schooBaseRate;
		this.outBaseRate = outBaseRate;
		this.tag = tag;
	}

	// Property accessors

	public Integer getPraId() {
		return this.praId;
	}

	public void setPraId(Integer praId) {
		this.praId = praId;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getResourceConstructionNumber() {
		return this.resourceConstructionNumber;
	}

	public void setResourceConstructionNumber(Integer resourceConstructionNumber) {
		this.resourceConstructionNumber = resourceConstructionNumber;
	}

	public Integer getExperimentalEquipmentMean() {
		return this.experimentalEquipmentMean;
	}

	public void setExperimentalEquipmentMean(Integer experimentalEquipmentMean) {
		this.experimentalEquipmentMean = experimentalEquipmentMean;
	}

	public Float getLaboratorySatisfactionRate() {
		return this.laboratorySatisfactionRate;
	}

	public void setLaboratorySatisfactionRate(Float laboratorySatisfactionRate) {
		this.laboratorySatisfactionRate = laboratorySatisfactionRate;
	}

	public Integer getExperimentNumber() {
		return this.experimentNumber;
	}

	public void setExperimentNumber(Integer experimentNumber) {
		this.experimentNumber = experimentNumber;
	}

	public Integer getSchooBaseNumber() {
		return this.schooBaseNumber;
	}

	public void setSchooBaseNumber(Integer schooBaseNumber) {
		this.schooBaseNumber = schooBaseNumber;
	}

	public Integer getOutBaseNumber() {
		return this.outBaseNumber;
	}

	public void setOutBaseNumber(Integer outBaseNumber) {
		this.outBaseNumber = outBaseNumber;
	}

	public Float getSchooBaseRate() {
		return this.schooBaseRate;
	}

	public void setSchooBaseRate(Float schooBaseRate) {
		this.schooBaseRate = schooBaseRate;
	}

	public Float getOutBaseRate() {
		return this.outBaseRate;
	}

	public void setOutBaseRate(Float outBaseRate) {
		this.outBaseRate = outBaseRate;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

}