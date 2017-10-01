package com.secondbike.SecondBike;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class QiucheActivity extends Activity {
	private Button cancel, submit;
	private ButtonListener buttonListner;
	private EditText content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.qiuche);
		SysApplication.getInstance().addActivity(this);
		Intent i = getIntent();
		init();// 初始化
	}

	public void init() {
		cancel = (Button) findViewById(R.id.cancel);
		buttonListner = new ButtonListener();
		submit = (Button) findViewById(R.id.submit);
		submit.setOnClickListener(buttonListner);
		cancel.setOnClickListener(buttonListner);
		content = (EditText) findViewById(R.id.content);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.qiuche, menu);
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
				QiucheActivity.this.finish();
			} else if (id == R.id.submit) {
				String rs = content.getText().toString();
				if (rs.length() == 0) {
					Toast.makeText(QiucheActivity.this, "请输入求车信息！",
							Toast.LENGTH_SHORT).show();
					return;
				}
				DiagListener diagListener = new DiagListener();
				AlertDialog.Builder builder = new AlertDialog.Builder(
						QiucheActivity.this,
						AlertDialog.THEME_HOLO_LIGHT);
				builder.setTitle("提交结果");
				builder.setMessage("提交成功!");
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
			if(which==AlertDialog.BUTTON_POSITIVE){
				QiucheActivity.this.finish();
			}
		}

	}
}
