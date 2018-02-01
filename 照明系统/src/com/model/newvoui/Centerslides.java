package com.model.newvoui;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Centerslides implements java.io.Serializable {
	// Fields

	private Integer pictureid;
	private String picturename;
	private String picturepath;
	private String lowpicturepath;
	private Integer picturesequence;

	public Centerslides() {
	}

	public Centerslides(Integer pictureid, String picturename,
			String picturepath, String lowpicturepath, Integer picturesequence) {
		super();
		this.pictureid = pictureid;
		this.picturename = picturename;
		this.picturepath = picturepath;
		this.lowpicturepath = lowpicturepath;
		this.picturesequence = picturesequence;
	}

	public Integer getPictureid() {
		return pictureid;
	}

	public void setPictureid(Integer pictureid) {
		this.pictureid = pictureid;
	}

	public String getPicturename() {
		return picturename;
	}

	public void setPicturename(String picturename) {
		this.picturename = picturename;
	}

	public String getPicturepath() {
		return picturepath;
	}

	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}

	public String getLowpicturepath() {
		return lowpicturepath;
	}

	public void setLowpicturepath(String lowpicturepath) {
		this.lowpicturepath = lowpicturepath;
	}

	public Integer getPicturesequence() {
		return picturesequence;
	}

	public void setPicturesequence(Integer picturesequence) {
		this.picturesequence = picturesequence;
	}

}
