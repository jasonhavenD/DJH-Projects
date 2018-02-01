package com.model.newvoui;

public class ShopItem {
	// Fields
	private String picturetitle;// 产品名称标题
	private String introduction;// 产品介绍
	private String picturepath;
	// private String picturepath2;//hover显示，还未实现
	private double discount;// 特价
	private String closingday;// 距离结束日

	public ShopItem() {

	}

	public ShopItem(String picturetitle, String introduction,
			String picturepath, double discount, String closingday) {
		super();
		this.picturetitle = picturetitle;
		this.introduction = introduction;
		this.picturepath = picturepath;
		this.discount = discount;
		this.closingday = closingday;
	}

	public String getPicturetitle() {
		return picturetitle;
	}

	public void setPicturetitle(String picturetitle) {
		this.picturetitle = picturetitle;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getPicturepath() {
		return picturepath;
	}

	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getClosingday() {
		return closingday;
	}

	public void setClosingday(String closingday) {
		this.closingday = closingday;
	}

}
