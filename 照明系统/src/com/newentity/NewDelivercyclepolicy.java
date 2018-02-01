package com.newentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Delivercyclepolicy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "delivercyclepolicy", schema = "dbo", catalog = "newlightsystem")

public class NewDelivercyclepolicy implements java.io.Serializable {

	// Fields

	private Integer delivercyclepolicyid;
	private Integer delivercycle;
	private Double delivercyclebenefits;

	// Constructors

	/** default constructor */
	public NewDelivercyclepolicy() {
	}

	/** full constructor */
	public NewDelivercyclepolicy(Integer delivercyclepolicyid, Integer delivercycle, Double delivercyclebenefits) {
		this.delivercyclepolicyid = delivercyclepolicyid;
		this.delivercycle = delivercycle;
		this.delivercyclebenefits = delivercyclebenefits;
	}

	// Property accessors
	@Id

	@Column(name = "delivercyclepolicyid", unique = true, nullable = false)

	public Integer getDelivercyclepolicyid() {
		return this.delivercyclepolicyid;
	}

	public void setDelivercyclepolicyid(Integer delivercyclepolicyid) {
		this.delivercyclepolicyid = delivercyclepolicyid;
	}

	@Column(name = "delivercycle", nullable = false)

	public Integer getDelivercycle() {
		return this.delivercycle;
	}

	public void setDelivercycle(Integer delivercycle) {
		this.delivercycle = delivercycle;
	}

	@Column(name = "delivercyclebenefits", nullable = false, precision = 53, scale = 0)

	public Double getDelivercyclebenefits() {
		return this.delivercyclebenefits;
	}

	public void setDelivercyclebenefits(Double delivercyclebenefits) {
		this.delivercyclebenefits = delivercyclebenefits;
	}

}