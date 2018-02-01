package com.model.newvoui;

public class CartItem {
	private String picturepath;
	private String picturetitle;
	private double price;
	private int count;

	public CartItem() {

	}

	public CartItem(String picturepath, String picturetitle, double price,
			int count) {
		super();
		this.picturepath = picturepath;
		this.picturetitle = picturetitle;
		this.price = price;
		this.count = count;
	}

	public String getPicturepath() {
		return picturepath;
	}

	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}

	public String getPicturetitle() {
		return picturetitle;
	}

	public void setPicturetitle(String picturetitle) {
		this.picturetitle = picturetitle;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}