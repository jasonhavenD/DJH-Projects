package com.secondbike.secuphone;

import com.secondbike.SecondBike.R;
import com.secondbike.SecondBike.SysApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecuPhoneActivity extends Activity {

	private Button cancel, changePhone;
	private ButtonListener buttonListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secu_phone);
		SysApplication.getInstance().addActivity(this);
		Intent intent = getIntent();
		init();// ≥ı ºªØ

	}

	public void init() {
		cancel = (Button) findViewById(R.id.cancel);
		changePhone = (Button) findViewById(R.id.changephone);
		buttonListener=new ButtonListener();
		cancel.setOnClickListener(buttonListener);
		changePhone.setOnClickListener(buttonListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.secu_phone, menu);
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
				SecuPhoneActivity.this.finish();
			} else if (id == R.id.changephone) {
				Intent intent = new Intent(SecuPhoneActivity.this,
						ChangePhoneActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
			}
		}

	}
}
