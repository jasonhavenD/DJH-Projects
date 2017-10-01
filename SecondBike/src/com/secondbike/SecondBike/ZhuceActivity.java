package com.secondbike.SecondBike;

import com.secondbike.blinktophone.BlinkActivity;
import com.secondbike.user.MySQLiteOpenHelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ZhuceActivity extends Activity {

	private EditText accountEdittext, pwdEditText, confirmEdittext;
	private Button zhuce, cancel;
	private ButtonListener buttonListener;
	public static int MODE = Context.MODE_WORLD_READABLE
			+ Context.MODE_WORLD_WRITEABLE;
	public static final String PREFERENCE_NAME = "setting";
	public final static String UNAME = "uname";
	public final static String PWD = "pwd";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhuce);
		SysApplication.getInstance().addActivity(this);
		Intent intent = getIntent();
		init();// 初始化
	}

	public void init() {
		accountEdittext = (EditText) findViewById(R.id.accountEdittext);
		pwdEditText = (EditText) findViewById(R.id.pwdEdittext);
		confirmEdittext = (EditText) findViewById(R.id.confirmEdittext);
		zhuce = (Button) findViewById(R.id.zhuce);
		cancel = (Button) findViewById(R.id.cancel);
		buttonListener = new ButtonListener();
		zhuce.setOnClickListener(buttonListener);
		cancel.setOnClickListener(buttonListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.zhuce, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			if (id == R.id.zhuce) {
				// 显示注册成功
				String account = accountEdittext.getText().toString();
				String old = pwdEditText.getText().toString();
				String newpwd = confirmEdittext.getText().toString();
				if (account.length() == 0 || old.length() == 0
						|| newpwd.length() == 0) {
					DiagListener3 diagListener = new DiagListener3();
					AlertDialog.Builder builder = new AlertDialog.Builder(
							ZhuceActivity.this, AlertDialog.THEME_HOLO_LIGHT);
					builder.setTitle("注册");
					builder.setMessage("输入不能为空！");
					builder.setPositiveButton("确定", diagListener);
					AlertDialog dialog = builder.create();
					dialog.show();
					return;
				}
				if (account.length() < 6 || account.length() > 14) {
					DiagListener3 diagListener = new DiagListener3();
					AlertDialog.Builder builder = new AlertDialog.Builder(
							ZhuceActivity.this, AlertDialog.THEME_HOLO_LIGHT);
					builder.setTitle("注册");
					builder.setMessage("账号位数为7~14位！");
					builder.setPositiveButton("确定", diagListener);
					AlertDialog dialog = builder.create();
					dialog.show();
					return;
				}

				if (old.length() < 6 || old.length() > 14) {
					DiagListener3 diagListener = new DiagListener3();
					AlertDialog.Builder builder = new AlertDialog.Builder(
							ZhuceActivity.this, AlertDialog.THEME_HOLO_LIGHT);
					builder.setTitle("注册");
					builder.setMessage("密码位数为6~14位！");
					builder.setPositiveButton("确定", diagListener);
					AlertDialog dialog = builder.create();
					dialog.show();
					return;
				}
				if (!newpwd.equals(old)) {
					DiagListener3 diagListener = new DiagListener3();
					AlertDialog.Builder builder = new AlertDialog.Builder(
							ZhuceActivity.this, AlertDialog.THEME_HOLO_LIGHT);
					builder.setTitle("注册");
					builder.setMessage("两次密码输入不一致！");
					builder.setPositiveButton("确定", diagListener);
					AlertDialog dialog = builder.create();
					dialog.show();
					return;
				}
				// 先判断账号是否已经被注册
				MySQLiteOpenHelper mySQLiteOpenHelper = new MySQLiteOpenHelper(
						ZhuceActivity.this, "db");
				SQLiteDatabase database = mySQLiteOpenHelper
						.getReadableDatabase();
				Cursor cursor = database
						.rawQuery("select name from user", null);
				while (cursor.moveToNext()) {
					Log.e("进入判断", "是否已被注册:" + account);
					String name = cursor.getString(cursor
							.getColumnIndex("name"));
					Log.e("name=", name);
					if (account.equals(name)) {
						Log.e("注册", "此账号已被注册");
						DiagListener3 diagListener = new DiagListener3();
						AlertDialog.Builder builder = new AlertDialog.Builder(
								ZhuceActivity.this,
								AlertDialog.THEME_HOLO_LIGHT);
						builder.setTitle("注册");
						builder.setMessage("用户：" + name + "已经被注册！");
						builder.setNegativeButton("确定", diagListener);
						AlertDialog dialog = builder.create();
						dialog.show();
						return;
					}
				}
				cursor.close();//关闭
				// 注册成功,保存
				// 保存账号信息到数据库user
				database = mySQLiteOpenHelper.getWritableDatabase();
				ContentValues values = new ContentValues();
				values.put("name", account);
				values.put("passwd", newpwd);
				database.insert("user", null, values);
				Log.e("数据库", "保存成功");
				// 保存到shared
				SharedPreferences sharedPreferences = getSharedPreferences(
						PREFERENCE_NAME, MODE);
				SharedPreferences.Editor editor = sharedPreferences.edit();
				editor.putString(UNAME, accountEdittext.getText().toString());
				editor.putString(PWD, pwdEditText.getText().toString());
				editor.commit();
				DiagListener diagListener = new DiagListener();
				AlertDialog.Builder builder = new AlertDialog.Builder(
						ZhuceActivity.this, AlertDialog.THEME_HOLO_LIGHT);
				builder.setTitle("恭喜" + account + "!");
				builder.setMessage("注册成功！");
				builder.setPositiveButton("确定", diagListener);
				AlertDialog dialog = builder.create();
				dialog.show();
			} else if (id == R.id.cancel) {
				// 返回登录界面
				ZhuceActivity.this.finish();// 结束当前
			}
		}

	}

	class DiagListener implements
			android.content.DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
			case AlertDialog.BUTTON_POSITIVE:
				// 是否绑定手机
				DiagListener2 diagListener = new DiagListener2();
				AlertDialog.Builder builder = new AlertDialog.Builder(
						ZhuceActivity.this, AlertDialog.THEME_HOLO_LIGHT);
				builder.setTitle("密保手机");
				builder.setMessage("为了您的账号安全，请绑定手机！");
				builder.setPositiveButton("立即绑定", diagListener);
				builder.setNegativeButton("稍后绑定", diagListener);
				AlertDialog dialog2 = builder.create();
				dialog2.show();
				break;
			default:
				break;
			}
		}

	}

	class DiagListener2 implements
			android.content.DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
			case AlertDialog.BUTTON_POSITIVE:
				// 绑定手机
				Intent intent = new Intent(ZhuceActivity.this,
						BlinkActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				break;
			case AlertDialog.BUTTON_NEGATIVE:
				// 返回登录页面
				ZhuceActivity.this.finish();
			default:
				break;
			}
		}

	}

	class DiagListener3 implements
			android.content.DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
		}

	}

}
