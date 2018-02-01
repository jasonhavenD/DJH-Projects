package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Trainingvenue entity. @author MyEclipse Persistence Tools
 */

public class Trainingvenue implements java.io.Serializable {

	// Fields

	private String traNumer;
	private String traName;
	private String traCharacter;
	private Float area;
	private Integer aptCount;
	private Float eaquipAllVal;
	private Float equipVal;
	private Integer useCount;
	private Integer courseCount;
	private Integer pjCount;
	private Integer thHcount;
	private Integer thPcount;
	private String year;
	private Integer tag;
	private Set trainingvenueuses = new HashSet(0);
	private Set trainingvenueuses_1 = new HashSet(0);
	private Set equipments = new HashSet(0);
	private Set equipments_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Trainingvenue() {
	}

	/** minimal constructor */
	public Trainingvenue(String traNumer) {
		this.traNumer = traNumer;
	}

	/** full constructor */
	public Trainingvenue(String traNumer, String traName, String traCharacter,
			Float area, Integer aptCount, Float eaquipAllVal, Float equipVal,
			Integer useCount, Integer courseCount, Integer pjCount,
			Integer thHcount, Integer thPcount, String year, Integer tag,
			Set trainingvenueuses, Set trainingvenueuses_1, Set equipments,
			Set equipments_1) {
		this.traNumer = traNumer;
		this.traName = traName;
		this.traCharacter = traCharacter;
		this.area = area;
		this.aptCount = aptCount;
		this.eaquipAllVal = eaquipAllVal;
		this.equipVal = equipVal;
		this.useCount = useCount;
		this.courseCount = courseCount;
		this.pjCount = pjCount;
		this.thHcount = thHcount;
		this.thPcount = thPcount;
		this.year = year;
		this.tag = tag;
		this.trainingvenueuses = trainingvenueuses;
		this.trainingvenueuses_1 = trainingvenueuses_1;
		this.equipments = equipments;
		this.equipments_1 = equipments_1;
	}

	// Property accessors

	public String getTraNumer() {
		return this.traNumer;
	}

	public void setTraNumer(String traNumer) {
		this.traNumer = traNumer;
	}

	public String getTraName() {
		return this.traName;
	}

	public void setTraName(String traName) {
		this.traName = traName;
	}

	public String getTraCharacter() {
		return this.traCharacter;
	}

	public void setTraCharacter(String traCharacter) {
		this.traCharacter = traCharacter;
	}

	public Float getArea() {
		return this.area;
	}

	public void setArea(Float area) {
		this.area = area;
	}

	public Integer getAptCount() {
		return this.aptCount;
	}

	public void setAptCount(Integer aptCount) {
		this.aptCount = aptCount;
	}

	public Float getEaquipAllVal() {
		return this.eaquipAllVal;
	}

	public void setEaquipAllVal(Float eaquipAllVal) {
		this.eaquipAllVal = eaquipAllVal;
	}

	public Float getEquipVal() {
		return this.equipVal;
	}

	public void setEquipVal(Float equipVal) {
		this.equipVal = equipVal;
	}

	public Integer getUseCount() {
		return this.useCount;
	}

	public void setUseCount(Integer useCount) {
		this.useCount = useCount;
	}

	public Integer getCourseCount() {
		return this.courseCount;
	}

	public void setCourseCount(Integer courseCount) {
		this.courseCount = courseCount;
	}

	public Integer getPjCount() {
		return this.pjCount;
	}

	public void setPjCount(Integer pjCount) {
		this.pjCount = pjCount;
	}

	public Integer getThHcount() {
		return this.thHcount;
	}

	public void setThHcount(Integer thHcount) {
		this.thHcount = thHcount;
	}

	public Integer getThPcount() {
		return this.thPcount;
	}

	public void setThPcount(Integer thPcount) {
		this.thPcount = thPcount;
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

	public Set getTrainingvenueuses() {
		return this.trainingvenueuses;
	}

	public void setTrainingvenueuses(Set trainingvenueuses) {
		this.trainingvenueuses = trainingvenueuses;
	}

	public Set getTrainingvenueuses_1() {
		return this.trainingvenueuses_1;
	}

	public void setTrainingvenueuses_1(Set trainingvenueuses_1) {
		this.trainingvenueuses_1 = trainingvenueuses_1;
	}

	public Set getEquipments() {
		return this.equipments;
	}

	public void setEquipments(Set equipments) {
		this.equipments = equipments;
	}

	public Set getEquipments_1() {
		return this.equipments_1;
	}

	public void setEquipments_1(Set equipments_1) {
		this.equipments_1 = equipments_1;
	}

}