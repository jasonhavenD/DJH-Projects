package com.secondbike.secuphone;

import com.secondbike.SecondBike.DengluActivity;
import com.secondbike.SecondBike.MineActivity;
import com.secondbike.SecondBike.R;
import com.secondbike.SecondBike.SysApplication;
import com.secondbike.SecondBike.R.id;
import com.secondbike.SecondBike.R.layout;
import com.secondbike.SecondBike.R.menu;
import com.secondbike.blinktophone.BlinkActivity;
import com.secondbike.secuphone.YanZhengActivity.ButtonListener;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends Activity {

	private TextView result;
	private Button next;
	private ButtonListener buttonListener;
	private String phone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		SysApplication.getInstance().addActivity(this);
		Intent intent = getIntent();
		phone = intent.getStringExtra(BlinkActivity.PHONE);
		init();// 初始化
	}

	public void init() {
		next = (Button) findViewById(R.id.next);
		buttonListener = new ButtonListener();
		next.setOnClickListener(buttonListener);

		// 作出判断是否验证成功
		result = (TextView) findViewById(R.id.result);
		result.setText("绑定成功！");
		// 更新手机号
		SharedPreferences sharedPreferences = getSharedPreferences(
				DengluActivity.PREFERENCE_NAME, DengluActivity.MODE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString(BlinkActivity.PHONE, phone);
		editor.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
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
			ResultActivity.this.finish();
		}
		return super.onKeyDown(keyCode, event);
	}

	class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			if (id == R.id.next) {
				Intent intent = new Intent(ResultActivity.this,
						MineActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);

			}

		}
	}
}
