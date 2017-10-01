package com.seconbike.carlibary;

import java.io.Serializable;

public class MyData implements Serializable{
	private String name;
	private int imageid;
	private double price;
	private boolean rentable;
	private double rentPrice;
	private String color;
	private String express;
	public MyData(String name, int imageid,double price,boolean rentable,double rentprice,String color,String express) {
		super();
		this.name = name;
		this.imageid = imageid;
		this.price=price;
		this.rentable=rentable;
		if(rentable){
		this.rentPrice=rentprice;}
		else rentprice=0;
		this.color=color;
		this.express=express;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setRentable(boolean rentable) {
		this.rentable = rentable;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getImageid() {
		return imageid;
	}
	public void setImageid(int imageid) {
		this.imageid = imageid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isRentable() {
		return rentable;
	}
	public double getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
	@Override
	public String toString() {
		return "name=" + name + ", imageid=" + imageid + ", price="
				+ price + ", rentable=" + rentable + ", rentPrice=" + rentPrice
				;
	}

	public String getExpress() {
		return express;
	}

	public void setExpress(String express) {
		this.express = express;
	}
	
	
}
