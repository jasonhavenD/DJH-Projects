package com.model.newvoui;

public class FirstProductPicture {
	// Fields

	///////
	private Integer producttypeId;// 产品类别id
	
	public Integer getProducttypeId() {
		return producttypeId;
	}
	public void setProducttypeId(Integer producttypeId) {
		this.producttypeId = producttypeId;
	}
	///////

	// private Integer pictureid;
	// private String picturename;
	private String typename;// 产品类型
	private String propaganda;// 宣传广告词
	private String picturepath;

	// private String lowpicturepath;
	// private Integer picturesequence;

	
	public FirstProductPicture(){}
	
	
	public FirstProductPicture(String picturepath) {
		super();
		this.picturepath = picturepath;
	}

	public FirstProductPicture(Integer producttypeId, String typename, String propaganda,
			String picturepath) {
		super();
		this.producttypeId = producttypeId;
		this.typename = typename;
		this.propaganda = propaganda;
		this.picturepath = picturepath;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getPropaganda() {
		return propaganda;
	}

	public void setPropaganda(String propaganda) {
		this.propaganda = propaganda;
	}

	public String getPicturepath() {
		return picturepath;
	}

	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}

}
