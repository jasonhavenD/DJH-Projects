package com.example.agricultural;

import android.app.Application;

public class AgriApplication extends Application {

	private static AgriApplication instance;
	public static int USER_TYPE_NORMAL = 1;
	public static int USER_TYPE_DOCTOR = 2;

	private int userType;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();

		instance = this;
		userType = USER_TYPE_NORMAL;

	}

	public static AgriApplication getInstance() {

		return instance;
	}
	
	public void setUserType(int type){
		userType = type;
	}
	
	public int getUserType(){
		return userType;
	}
}
