package com.newentity;

public class Product2 {
	private NewProduct newproduct;
	private NewProductproperty newproductproperty;
	private NewProducttype newproducttype;
	private String[] pictures;
	private String activity;
	public String[] getPictures() {
		return pictures;
	}

	public void setPictures(String[] pictures) {
		this.pictures = pictures;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Product2(){
		
	}
	
	public Product2(NewProduct newproduct,NewProductproperty newproductproperty,
			NewProducttype newproducttype,String[] pictures,String activity){
		this.newproduct = newproduct;
		this.newproductproperty = newproductproperty;
		this.newproducttype = newproducttype;
		this.pictures = pictures;
		this.activity = activity;
	}
	
	public NewProduct getNewproduct() {
		return newproduct;
	}
	public void setNewproduct(NewProduct newproduct) {
		this.newproduct = newproduct;
	}
	public NewProductproperty getNewproductproperty() {
		return newproductproperty;
	}
	public void setNewproductproperty(NewProductproperty newproductproperty) {
		this.newproductproperty = newproductproperty;
	}
	public NewProducttype getNewproducttype() {
		return newproducttype;
	}
	public void setNewproducttype(NewProducttype newproducttype) {
		this.newproducttype = newproducttype;
	}

	@Override
	public String toString() {
		return "Product2 [newproduct=" + newproduct + ", newproductproperty="
				+ newproductproperty + ", newproducttype=" + newproducttype
				+ "]";
	}
	
}
