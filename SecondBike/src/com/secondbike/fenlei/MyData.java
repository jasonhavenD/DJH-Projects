package com.secondbike.fenlei;

public class MyData {
	int imageId;

	String name;

	public MyData(int imageId, String name) {
		super();
		this.imageId = imageId;
		// this.name = name;
	}

	public MyData(int imageId) {
		this.imageId = imageId;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}