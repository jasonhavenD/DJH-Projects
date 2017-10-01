package com.secondbike.SecondBike;

import com.secondbike.blinktophone.BlinkActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MyAccountActivity extends Activity {
	private Button cancel, xiugai;
	private ButtonListener buttonListner;

	private TextView[] textviews;
	public final static String NICHENG = "nicheng";
	public final static String QQ = "QQ";
	public final static String ADDRESS = "address";
	public final static String MOTO = "moto";
	public final static String GENDER = "gender";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_account);
		SysApplication.getInstance().addActivity(this);
		Intent i = getIntent();
		init();// 初始化
		initinfo();
	}

	public void init() {
		cancel = (Button) findViewById(R.id.cancel);
		buttonListner = new ButtonListener();
		xiugai = (Button) findViewById(R.id.xiugai);
		xiugai.setOnClickListener(buttonListner);
		cancel.setOnClickListener(buttonListner);
		textviews = new TextView[7];
		textviews[0] = (TextView) findViewById(R.id.nicheng);
		textviews[1] = (TextView) findViewById(R.id.uname);
		textviews[2] = (TextView) findViewById(R.id.gender);
		textviews[3] = (TextView) findViewById(R.id.QQ);
		textviews[4] = (TextView) findViewById(R.id.phone);
		textviews[5] = (TextView) findViewById(R.id.address);
		textviews[6] = (TextView) findViewById(R.id.moto);
	}

	public void initinfo() {
		// 从SharedPreferences获取
		SharedPreferences sharedPreferences = getSharedPreferences(
				ZhuceActivity.PREFERENCE_NAME, ZhuceActivity.MODE);
		String[] labels = { NICHENG, ZhuceActivity.UNAME, GENDER, QQ,
				BlinkActivity.PHONE, ADDRESS, MOTO };
		String[] answers = new String[labels.length];
		for (int i = 0; i < labels.length; i++) {
			answers[i] = sharedPreferences.getString(labels[i], labels[i]);
		}
		for (int i = 0; i < answers.length; i++) {
			textviews[i].setText(answers[i]);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_account, menu);
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

	// 按钮监听器
	public class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			if (id == R.id.cancel) {
				MyAccountActivity.this.finish();
			} else if (id == R.id.xiugai) {
				// 进入修改页面
				Intent intent = new Intent(MyAccountActivity.this,
						XiugaiAccountActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
			}
		}
	}
}
