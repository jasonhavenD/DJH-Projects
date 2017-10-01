package com.secondbike.SecondBike;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.secondbike.about.ScoreUsActivity;
import com.secondbike.about.SuggestActivity;

public class AboutActivity extends Activity {

	private Button cancel;
	private ButtonListener buttonListener;
	private TextView tv1, tv2, tv3, tv4;
	private textViewListener tvListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		SysApplication.getInstance().addActivity(this);
		Intent intent = getIntent();
		init();
	}

	public void init() {
		tv1 = (TextView) findViewById(R.id.check);
		tv2 = (TextView) findViewById(R.id.suggest);
		tv3 = (TextView) findViewById(R.id.contact);
		tv4 = (TextView) findViewById(R.id.score);
		cancel = (Button) findViewById(R.id.cancel);
		buttonListener = new ButtonListener();
		cancel.setOnClickListener(buttonListener);
		tvListener = new textViewListener();
		tv1.setOnClickListener(tvListener);
		tv2.setOnClickListener(tvListener);
		tv3.setOnClickListener(tvListener);
		tv4.setOnClickListener(tvListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
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
	class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			if (id == R.id.cancel) {// 返回上一层
				AboutActivity.this.finish();
			}
		}
	}

	class textViewListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			Intent intent = null;
			switch (id) {
			case R.id.check:
				DiagListener diagListener = new DiagListener();
				AlertDialog.Builder builder = new AlertDialog.Builder(
						AboutActivity.this, AlertDialog.THEME_HOLO_LIGHT);
				builder.setTitle("检查更新");
				builder.setMessage("当前已是最新版本1.0");
				builder.setPositiveButton("确定", diagListener);
				AlertDialog dialog = builder.create();
				dialog.show();

				break;
			case R.id.suggest:
				intent = new Intent(AboutActivity.this, SuggestActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				break;
			case R.id.contact:
				DiagListener2 diagListener2 = new DiagListener2();
				AlertDialog.Builder builder2 = new AlertDialog.Builder(
						AboutActivity.this, AlertDialog.THEME_HOLO_LIGHT);
				builder2.setTitle("联系客服");
				builder2.setMessage("确定发送短信吗？");
				builder2.setPositiveButton("确定", diagListener2);
				builder2.setNegativeButton("取消", diagListener2);
				AlertDialog dialog2 = builder2.create();
				dialog2.show();

				break;
			case R.id.score:
				intent = new Intent(AboutActivity.this, ScoreUsActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				break;
			}
		}

	}

	class DiagListener implements
			android.content.DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
		}

	}

	class DiagListener2 implements
			android.content.DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
			case AlertDialog.BUTTON_POSITIVE:
				Toast.makeText(AboutActivity.this, "短信已发送！", Toast.LENGTH_SHORT)
						.show();
				break;
			}
		}

	}

}
