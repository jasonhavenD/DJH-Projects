package com.secondbike.secuphone;

import com.secondbike.SecondBike.R;
import com.secondbike.SecondBike.SysApplication;
import com.secondbike.blinktophone.BlinkActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class YanZhengActivity extends Activity {

	private Button cancel, next;
	private EditText code;
	private ButtonListener buttonListener;
	private String phone;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yan_zheng);
		SysApplication.getInstance().addActivity(this);
		Intent intent = getIntent();
		phone=intent.getStringExtra(BlinkActivity.PHONE);
		init();// 初始化
		
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
		getMenuInflater().inflate(R.menu.yan_zheng, menu);
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
				YanZhengActivity.this.finish();
			} else if (id == R.id.next) {
				String rs = code.getText().toString();
				if (rs.length() == 0) {
					Toast.makeText(YanZhengActivity.this, "验证码不能为空！",
							Toast.LENGTH_SHORT).show();
					return;
				}
				Intent intent = new Intent(YanZhengActivity.this,
						ResultActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				intent.putExtra(BlinkActivity.PHONE, phone);
				startActivity(intent);

			}

		}
	}
}
