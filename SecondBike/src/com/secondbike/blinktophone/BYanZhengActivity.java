package com.secondbike.blinktophone;

import java.util.Random;

import com.secondbike.SecondBike.IdentifyActivity;
import com.secondbike.SecondBike.R;
import com.secondbike.SecondBike.SysApplication;
import com.secondbike.SecondBike.ZhuceActivity;
import com.secondbike.user.MySQLiteOpenHelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BYanZhengActivity extends Activity {

	private Button cancel, next;
	private EditText code;
	private ButtonListener buttonListener;
	private int randCode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.byan_zheng);
		SysApplication.getInstance().addActivity(this);
		init();// 初始化
		getCode();
	}

	public void getCode() {
		randCode = new Random().nextInt(99999);
		DiagListener diagListener = new DiagListener();
		AlertDialog.Builder builder = new AlertDialog.Builder(
				BYanZhengActivity.this, AlertDialog.THEME_HOLO_LIGHT);
		builder.setTitle("获取验证码");
		builder.setMessage("" + randCode);
		builder.setPositiveButton("复制", diagListener);
		AlertDialog dialog = builder.create();
		dialog.show();
	}

	public void init() {
		cancel = (Button) findViewById(R.id.cancel);
		next = (Button) findViewById(R.id.next);
		code = (EditText) findViewById(R.id.code);
		buttonListener = new ButtonListener();
		cancel.setOnClickListener(buttonListener);
		next.setOnClickListener(buttonListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.byan_zheng, menu);
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
			if (id == R.id.cancel) {
				BYanZhengActivity.this.finish();
			} else if (id == R.id.next) {
				String rs = code.getText().toString();
				if (rs.length() == 0) {
					Toast.makeText(BYanZhengActivity.this, "验证码不能为空！",
							Toast.LENGTH_SHORT).show();
					return;
				}
				// 判断验证码是否正确
				if (!rs.equals("" + randCode)) {
					DiagListener diagListener = new DiagListener();
					AlertDialog.Builder builder = new AlertDialog.Builder(
							BYanZhengActivity.this,
							AlertDialog.THEME_HOLO_LIGHT);
					builder.setTitle("验证结果");
					builder.setMessage("验证码不正确！");
					builder.setNegativeButton("确定", diagListener);
					AlertDialog dialog = builder.create();
					dialog.show();
					return;
				}
				//获得手机号
				Intent intent = getIntent();
				String phone=intent.getStringExtra(BlinkActivity.PHONE);
				//获得当前用户信息
				SharedPreferences sharedPreferences=getSharedPreferences(ZhuceActivity.PREFERENCE_NAME, ZhuceActivity.MODE);
				String name=sharedPreferences.getString(ZhuceActivity.UNAME, "defValue");
				//绑定成功,存储手机号
				MySQLiteOpenHelper mySQLiteOpenHelper = new MySQLiteOpenHelper(
						BYanZhengActivity.this, "db");
				SQLiteDatabase database = mySQLiteOpenHelper
						.getReadableDatabase();
				ContentValues values=new ContentValues();
				values.put("phone", phone);
				database.update("user", values, "name=?",new String[]{name});
				//shared保存一份
				SharedPreferences.Editor editor = sharedPreferences.edit();
				editor.putString(BlinkActivity.PHONE, phone);
				editor.commit();
				//
				Intent intent2 = new Intent(BYanZhengActivity.this,
						BResultActivity.class);
				intent2.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent2);

			}

		}
	}

	class DiagListener implements
			android.content.DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
			case AlertDialog.BUTTON_POSITIVE:
				// 点击复制，自动粘贴
				code.setText("" + randCode);
				break;
			}
		}

	}
}
