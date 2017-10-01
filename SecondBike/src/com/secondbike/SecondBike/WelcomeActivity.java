package com.secondbike.SecondBike;

import com.secondbike.user.MySQLiteOpenHelper;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class WelcomeActivity extends Activity {

	Button welcome_btn1;
	private static final String SHARE_APP_TAG = "share_app_tag";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		SysApplication.getInstance().addActivity(this);
		Start();
	}

	// 等待1.5s自动进入主页面
	public void Start() {
		new Thread() {
			public void run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 判断是否第一次启动
				SharedPreferences setting = getSharedPreferences(SHARE_APP_TAG,
						0);
				Boolean user_first = setting.getBoolean("FIRST", true);
				if (user_first) {// 第一次
					setting.edit().putBoolean("FIRST", false).commit();
					Log.e("welcome", "第一次");
					// 创建用户数据库
					Thread thread = new Thread(new Runnable() {
						@Override
						public void run() {
							MySQLiteOpenHelper mySQLiteOpenHelper = new MySQLiteOpenHelper(
									WelcomeActivity.this, "db");
							SQLiteDatabase db = mySQLiteOpenHelper
									.getWritableDatabase();// 创建
						}
					});
					thread.start();
					//启动引导动画
					
					
				} else {
					Log.e("welcome", "不是第一次");

					// 判断用户是否自动登录
					SharedPreferences sharedPreferences = getSharedPreferences(
							DengluActivity.PREFERENCE_NAME, DengluActivity.MODE);
					String uname = sharedPreferences.getString(
							DengluActivity.UNAME, "defValue");
					String pwd = sharedPreferences.getString(
							DengluActivity.PWD, "defValue");
					boolean save = sharedPreferences.getBoolean(
							DengluActivity.SAVE, false);
					boolean auto = sharedPreferences.getBoolean(
							DengluActivity.AUTO_LOGIN, false);

					Log.e("welcome:save=" + save, "auto=" + auto);

					if (save && auto) {
						Intent intent = new Intent(WelcomeActivity.this,
								ZhuyeActivity.class);
						intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
						startActivity(intent);
						finish();
					} else {
						Intent intent = new Intent();
						intent.setClass(WelcomeActivity.this,
								DengluActivity.class);
						intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
						startActivity(intent);
						finish();

					}
				}
			}
		}.start();

	}
}
