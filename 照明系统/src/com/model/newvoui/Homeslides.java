package com.model.newvoui;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Homeslides entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "homeslides", schema = "dbo", catalog = "LightSystem")
public class Homeslides implements java.io.Serializable {

	// Fields

	private Integer pictureid;
	private String picturename;
	private String picturepath;
	private String lowpicturepath;
	private Integer picturesequence;

	// Constructors

	/** default constructor */
	public Homeslides() {
	}

	/** minimal constructor */
	public Homeslides(Integer pictureid, String picturename,
			String picturepath, Integer picturesequence) {
		this.pictureid = pictureid;
		this.picturename = picturename;
		this.picturepath = picturepath;
		this.picturesequence = picturesequence;
	}

	/** full constructor */
	public Homeslides(Integer pictureid, String picturename,
			String picturepath, String lowpicturepath, Integer picturesequence) {
		this.pictureid = pictureid;
		this.picturename = picturename;
		this.picturepath = picturepath;
		this.lowpicturepath = lowpicturepath;
		this.picturesequence = picturesequence;
	}

	// Property accessors
	@Id
	@Column(name = "pictureid", unique = true, nullable = false)
	public Integer getPictureid() {
		return this.pictureid;
	}

	public void setPictureid(Integer pictureid) {
		this.pictureid = pictureid;
	}

	@Column(name = "picturename", nullable = false, length = 50)
	public String getPicturename() {
		return this.picturename;
	}

	public void setPicturename(String picturename) {
		this.picturename = picturename;
	}

	@Column(name = "picturepath", nullable = false, length = 50)
	public String getPicturepath() {
		return this.picturepath;
	}

	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}

	@Column(name = "lowpicturepath", length = 50)
	public String getLowpicturepath() {
		return this.lowpicturepath;
	}

	public void setLowpicturepath(String lowpicturepath) {
		this.lowpicturepath = lowpicturepath;
	}

	@Column(name = "picturesequence", nullable = false)
	public Integer getPicturesequence() {
		return this.picturesequence;
	}

	public void setPicturesequence(Integer picturesequence) {
		this.picturesequence = picturesequence;
	}

}