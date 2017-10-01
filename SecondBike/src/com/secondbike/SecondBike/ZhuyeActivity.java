package com.secondbike.SecondBike;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ZhuyeActivity extends Activity {

	private Button btn1, btn2, btn3, btn4;
	private ButtonListener btnListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhuye);
		SysApplication.getInstance().addActivity(this);
		init();// 初始化
	}

	public void init() {
		btn1 = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);
		btn3 = (Button) findViewById(R.id.button3);
		btn4 = (Button) findViewById(R.id.button4);
		btnListener = new ButtonListener();
		btn1.setOnClickListener(btnListener);
		btn2.setOnClickListener(btnListener);
		btn3.setOnClickListener(btnListener);
		btn4.setOnClickListener(btnListener);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			// 退出
			DiagListener1 diagListener = new DiagListener1();
			AlertDialog.Builder builder = new AlertDialog.Builder(
					ZhuyeActivity.this, AlertDialog.THEME_HOLO_LIGHT);
			builder.setTitle("退出程序");
			builder.setMessage("是否退出？");
			builder.setPositiveButton("确定", diagListener);
			builder.setNeutralButton("取消", diagListener);
			AlertDialog dialog = builder.create();
			dialog.show();

		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.zhuye, menu);
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

	class DiagListener1 implements
			android.content.DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
			case AlertDialog.BUTTON_POSITIVE:
				SysApplication.getInstance().exit();
				break;
			case AlertDialog.BUTTON_NEGATIVE:

				break;
			}
		}

	}

	// 按钮监听器
	public class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			if (id == R.id.button1) {
				// 当前页
			} else if (id == R.id.button2) {
				// 车库
				Intent intent = new Intent(ZhuyeActivity.this,
						CarLibaryActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
			} else if (id == R.id.button3) {
				// 分类
				Intent intent = new Intent(ZhuyeActivity.this,
						FenleiActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);

			} else if (id == R.id.button4) {
				// 我的
				Intent intent = new Intent(ZhuyeActivity.this,
						MineActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
			}
		}
	}
}
