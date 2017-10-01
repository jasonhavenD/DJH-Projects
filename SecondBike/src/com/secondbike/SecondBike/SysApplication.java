package com.secondbike.SecondBike;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

public class SysApplication extends Application {

	private List<Activity> mList = new LinkedList<Activity>();
	private static SysApplication instance;

	private SysApplication() {
	}

	public synchronized static SysApplication getInstance() {
		if (null == instance) {
			instance = new SysApplication();
		}
		return instance;
	}

	public void addActivity(Activity activity) {
		((LinkedList<Activity>)mList).addFirst(activity);//从头进去
	}
	
	public void removeActivity(){
		((LinkedList<Activity>)mList).removeFirst();
	}

	public List<Activity> getActivitiesList() {
		return mList;
	}

	
	public void exit() {
		try {
			for (Activity activity : mList) {
				if (activity != null)
					activity.finish();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		System.gc();
	}

}