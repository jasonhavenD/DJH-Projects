package com.secondbike.blinktophone;

import com.secondbike.SecondBike.DengluActivity;
import com.secondbike.SecondBike.R;
import com.secondbike.SecondBike.SysApplication;
import com.secondbike.SecondBike.ZhuceActivity;
import com.secondbike.secuphone.YanZhengActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BlinkActivity extends Activity {

	private Button cancel, next;
	private EditText phone;
	private ButtonListener buttonListener;
	public final static String PHONE="phone";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.blink);
		SysApplication.getInstance().addActivity(this);
		Intent intent = getIntent();
		init();// 初始化

	}

	public void init() {
		cancel = (Button) findViewById(R.id.cancel);
		next = (Button) findViewById(R.id.next);
		phone = (EditText) findViewById(R.id.phoneEdittext);
		buttonListener = new ButtonListener();
		cancel.setOnClickListener(buttonListener);
		next.setOnClickListener(buttonListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.blink, menu);
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
				// 跳回登录
				Intent intent = new Intent(BlinkActivity.this,
						DengluActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);

			} else if (id == R.id.next) {
				String rs = phone.getText().toString();
				if (rs.length() == 0) {
					Toast.makeText(BlinkActivity.this, "手机号不能为空！",
							Toast.LENGTH_SHORT).show();
					return;
				}
				//手机号验证
				String regularExpression="^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
				if(!rs.matches(regularExpression)){
					Toast.makeText(BlinkActivity.this,"手机号码不正确！", Toast.LENGTH_SHORT).show();
					return;
				}
				Intent intent = new Intent(BlinkActivity.this,
						BYanZhengActivity.class);
				intent.putExtra(PHONE, rs);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);

			}

		}
	}
}
