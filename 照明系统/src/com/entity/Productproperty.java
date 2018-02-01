package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Productbulb entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "productproperty", schema = "dbo", catalog = "NewLightSystem")
public class Productproperty implements java.io.Serializable {

	// Fields

	@GeneratedValue
	private Integer productid;
	private String power;
	private String lampholder;
	private String colortemp;
	private String voltage;
	private String luminousflux;
	private String lightefficiency;
	private String colorrendering;
	private String beamangle;
	private String isemc;

	// Constructors

	/** default constructor */
	public Productproperty() {
	}

	/** full constructor */
	public Productproperty(String power, String luminousflux,
			String lightefficiency, String colorrendering, String beamangle,
			String isemc) {
		this.power = power;
		this.luminousflux = luminousflux;
		this.lightefficiency = lightefficiency;
		this.colorrendering = colorrendering;
		this.beamangle = beamangle;
		this.isemc = isemc;
	}

	// Property accessors
	@Id
	@Column(name = "productid", unique = true, nullable = false)
	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	@Column(name = "power", length = 50)
	public String getPower() {
		return this.power;
	}

	public void setPower(String power) {
		this.power = power;
	}
	@Column(name = "lampholder", length = 50)
	public String getLampholder() {
		return lampholder;
	}

	public void setLampholder(String lampholder) {
		this.lampholder = lampholder;
	}
	@Column(name = "colortemp", length = 50)
	public String getColortemp() {
		return colortemp;
	}

	public void setColortemp(String colortemp) {
		this.colortemp = colortemp;
	}
	@Column(name = "voltage", length = 50)
	public String getVoltage() {
		return voltage;
	}

	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}

	@Column(name = "luminousflux", length = 50)
	public String getLuminousflux() {
		return this.luminousflux;
	}

	public void setLuminousflux(String luminousflux) {
		this.luminousflux = luminousflux;
	}

	@Column(name = "lightefficiency", length = 50)
	public String getLightefficiency() {
		return this.lightefficiency;
	}

	public void setLightefficiency(String lightefficiency) {
		this.lightefficiency = lightefficiency;
	}

	@Column(name = "colorrendering", length = 50)
	public String getColorrendering() {
		return this.colorrendering;
	}

	public void setColorrendering(String colorrendering) {
		this.colorrendering = colorrendering;
	}

	@Column(name = "beamangle", length = 50)
	public String getBeamangle() {
		return this.beamangle;
	}

	public void setBeamangle(String beamangle) {
		this.beamangle = beamangle;
	}

	@Column(name = "isemc", length = 50)
	public String getIsemc() {
		return this.isemc;
	}

	public void setIsemc(String isemc) {
		this.isemc = isemc;
	}

	@Override
	public String toString() {
		return "Productproperty [beamangle=" + beamangle + ", colorrendering="
				+ colorrendering + ", colortemp=" + colortemp + ", isemc="
				+ isemc + ", lampholder=" + lampholder + ", lightefficiency="
				+ lightefficiency + ", luminousflux=" + luminousflux
				+ ", power=" + power
				+ ", voltage=" + voltage + "]";
	}

}