package com.secondbike.user;

import android.R.integer;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//Mysqlitehelper作为访问数据库的助手类，提供两个功能
//1.得到sqlitehelper对象
//2.提供方法.

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

	private static final int VERSION = 1;// 默认版本,自定义

	// 构造函数必须的
	public MySQLiteOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// (上下文（actiity对象），表名字，null，当前数据库版本>0)
	}

	// 自定义
	public MySQLiteOpenHelper(Context context, String name) {
		this(context, name, null, VERSION);
	}

	// 自定义
	public MySQLiteOpenHelper(Context context, String name, int version) {
		this(context, name, null, version);
	}

	// 第一次创建数据库时调用,第一次得到MySQLiteOpenHelper对象时调用
	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.e("helper", "create()");
		db.execSQL("create table user(id integer primary key autoincrement ,nicheng varchar(30),name varchar(30),passwd varchar(30),QQ varchar(20),phone varchar(30),address varchar(30),moto varchar(30))");
		Log.e("helper", "创建user ok");
	}

	// 打开数据库
	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);

	}

	// 更新数据库
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.e("helper", "update()");
		// update table_name set xxx=xxx where xxx
	}

}
