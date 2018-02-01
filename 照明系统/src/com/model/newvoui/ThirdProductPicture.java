package com.model.newvoui;

public class ThirdProductPicture {
	// Fields
	
	///////
	private Integer productId;// 产品id
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	///////
	
	private String picturetitle;// 产品名称标题
	private String picturepath;

	private String introduction;
	private double price;

	public ThirdProductPicture() {
	}

	public ThirdProductPicture(Integer productId, String picturetitle, String picturepath,
			String introduction, double price) {
		super();
		this.productId = productId;
		this.picturetitle = picturetitle;
		this.picturepath = picturepath;
		this.introduction = introduction;
		this.price = price;
	}

	public String getPicturetitle() {
		return picturetitle;
	}

	public void setPicturetitle(String picturetitle) {
		this.picturetitle = picturetitle;
	}

	public String getPicturepath() {
		return picturepath;
	}

	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
}