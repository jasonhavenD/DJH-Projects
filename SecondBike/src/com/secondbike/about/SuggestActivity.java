package com.secondbike.about;

import com.secondbike.SecondBike.CarLibaryActivity;
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
import android.widget.EditText;
import android.widget.Toast;

public class SuggestActivity extends Activity {

	private Button cancel, submit;
	private ButtonListener buttonListner;
	private EditText content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.suggest);
		SysApplication.getInstance().addActivity(this);
		Intent intent = getIntent();
		init();
	}

	public void init() {
		submit = (Button) findViewById(R.id.submit);
		cancel = (Button) findViewById(R.id.cancel);
		buttonListner = new ButtonListener();
		submit.setOnClickListener(buttonListner);
		cancel.setOnClickListener(buttonListner);
		content = (EditText) findViewById(R.id.content);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.suggest, menu);
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
				SuggestActivity.this.finish();
			} else if (id == R.id.submit) {
				String rs = content.getText().toString();
				if (rs.length() == 0) {
					Toast.makeText(SuggestActivity.this, "输入不能为空！",
							Toast.LENGTH_SHORT).show();
					return;
				}
				Toast.makeText(SuggestActivity.this, "提交成功！",
						Toast.LENGTH_SHORT).show();
			}
			SuggestActivity.this.finish();
		}
	}
}
