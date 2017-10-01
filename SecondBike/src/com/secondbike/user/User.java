package com.secondbike.user;


public class User {
	private String nicheng;
	private String name;
	private String passwd;
	private String QQ;
	private String phone;
	private String address;
	private String moto;
	private int imagesid[];
	public User(String nicheng, String name, String passwd, String qQ,
			String phone, String address, String moto, int[] imagesid) {
		super();
		this.nicheng = nicheng;
		this.name = name;
		this.passwd = passwd;
		QQ = qQ;
		this.phone = phone;
		this.address = address;
		this.moto = moto;
		this.imagesid = imagesid;
	}
	public String getNicheng() {
		return nicheng;
	}
	public void setNicheng(String nicheng) {
		this.nicheng = nicheng;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMoto() {
		return moto;
	}
	public void setMoto(String moto) {
		this.moto = moto;
	}
	public int[] getImagesid() {
		return imagesid;
	}
	public void setImagesid(int[] imagesid) {
		this.imagesid = imagesid;
	}
	
}
