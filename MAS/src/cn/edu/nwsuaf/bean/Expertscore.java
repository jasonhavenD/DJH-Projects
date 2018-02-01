package cn.edu.nwsuaf.bean;

/**
 * Expertscore entity. @author MyEclipse Persistence Tools
 */

public class Expertscore implements java.io.Serializable {

	// Fields

	private Integer epertscoreId;
	private FileinfoAttachment fileinfoAttachment;
	private Expert expert;
	private Float asseisingValue;
	private String beizhu;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Expertscore() {
	}

	/** minimal constructor */
	public Expertscore(FileinfoAttachment fileinfoAttachment, Expert expert) {
		this.fileinfoAttachment = fileinfoAttachment;
		this.expert = expert;
	}

	/** full constructor */
	public Expertscore(FileinfoAttachment fileinfoAttachment, Expert expert,
			Float asseisingValue, String beizhu, Integer tag) {
		this.fileinfoAttachment = fileinfoAttachment;
		this.expert = expert;
		this.asseisingValue = asseisingValue;
		this.beizhu = beizhu;
		this.tag = tag;
	}

	// Property accessors

	public Integer getEpertscoreId() {
		return this.epertscoreId;
	}

	public void setEpertscoreId(Integer epertscoreId) {
		this.epertscoreId = epertscoreId;
	}

	public FileinfoAttachment getFileinfoAttachment() {
		return this.fileinfoAttachment;
	}

	public void setFileinfoAttachment(FileinfoAttachment fileinfoAttachment) {
		this.fileinfoAttachment = fileinfoAttachment;
	}

	public Expert getExpert() {
		return this.expert;
	}

	public void setExpert(Expert expert) {
		this.expert = expert;
	}

	public Float getAsseisingValue() {
		return this.asseisingValue;
	}

	public void setAsseisingValue(Float asseisingValue) {
		this.asseisingValue = asseisingValue;
	}

	public String getBeizhu() {
		return this.beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

}