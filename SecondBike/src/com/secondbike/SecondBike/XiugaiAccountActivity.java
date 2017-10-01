package com.secondbike.SecondBike;

import com.secondbike.blinktophone.BlinkActivity;

import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class XiugaiAccountActivity extends Activity {

	private Button yes, cancel;
	private ButtonListener ButtonListner;
	private TextView[] textviews;
	private Spinner gender;
	public final static String NICHENG="nicheng";
	public final static String QQ="QQ";
	public final static String ADDRESS="address";
	public final static String MOTO="moto";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xiugai_account);
		SysApplication.getInstance().addActivity(this);
		Intent i = getIntent();
		init();// 初始化
	}

	public void init() {
		cancel = (Button) findViewById(R.id.cancel);
		yes = (Button) findViewById(R.id.yes);
		ButtonListner = new ButtonListener();
		cancel.setOnClickListener(ButtonListner);
		yes.setOnClickListener(ButtonListner);
		textviews = new TextView[6];
		textviews[0] = (TextView) findViewById(R.id.nicheng);
		textviews[1] = (TextView) findViewById(R.id.uname);
		textviews[2] = (TextView) findViewById(R.id.QQ);
		textviews[3] = (TextView) findViewById(R.id.phone);
		textviews[4] = (TextView) findViewById(R.id.address);
		textviews[5] = (TextView) findViewById(R.id.moto);
		gender = (Spinner) findViewById(R.id.gender);
		//
		// 从SharedPreferences获取
				SharedPreferences sharedPreferences = getSharedPreferences(
						ZhuceActivity.PREFERENCE_NAME, ZhuceActivity.MODE);
				String[] labels = { NICHENG, ZhuceActivity.UNAME, QQ,
						BlinkActivity.PHONE, ADDRESS, MOTO };
				String[] answers = new String[labels.length];
				for (int i = 0; i < labels.length; i++) {
					answers[i] = sharedPreferences.getString(labels[i], labels[i]);
				}
				for (int i = 0; i < answers.length; i++) {
					textviews[i].setText(answers[i]);
				}
				String sex=sharedPreferences.getString(MyAccountActivity.GENDER, "defValue");
				if(sex.equals("男")){
					gender.setSelection(0);
				}else{
					gender.setSelection(1);
				}
				
	}

	public void changeinfo() {
		// SharedPreferences保存
		SharedPreferences sharedPreferences = getSharedPreferences(
				DengluActivity.PREFERENCE_NAME, DengluActivity.MODE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		String[] labels = { NICHENG, ZhuceActivity.UNAME, QQ, BlinkActivity.PHONE, ADDRESS,
				MOTO };
		for (int i = 0; i < textviews.length; i++) {
			editor.putString(labels[i], textviews[i].getText().toString());
		}
		int gender_id = gender.getSelectedItemPosition();
		if (gender_id == 0) {
			editor.putString("gender", "男");
		} else {
			editor.putString("gender", "女");
		}
		editor.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.xiugai_account, menu);
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

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			XiugaiAccountActivity.this.finish();
		}
		return super.onKeyDown(keyCode, event);
	}

	class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			if (id == R.id.cancel) {
				XiugaiAccountActivity.this.finish();
			} else if (id == R.id.yes) {
				changeinfo();
				//
				DiagListener diagListener = new DiagListener();
				AlertDialog.Builder builder = new AlertDialog.Builder(
						XiugaiAccountActivity.this,
						AlertDialog.THEME_HOLO_LIGHT);
				builder.setTitle("修改结果");
				builder.setMessage("修改成功!");
				builder.setPositiveButton("确定", diagListener);
				AlertDialog dialog = builder.create();
				dialog.show();

			}
		}

	}

	class DiagListener implements
			android.content.DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			Intent intent = new Intent(XiugaiAccountActivity.this,
					MineActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}

	}
}
