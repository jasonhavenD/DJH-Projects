package com.secondbike.SecondBike;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class AppearanceActivity extends Activity {

	private Button cancel;
	private ButtonListener buttonListner;
	private RadioButton[] rbtns;
	private RadioButtonListener radioButtonListener;
	private final int[] buttonsid = { R.id.first, R.id.second, R.id.third,
			R.id.fourth, R.id.fifth, R.id.sixth };
	private final int[] pifusid = { R.drawable.shenlan, R.drawable.hei,
			R.drawable.hui, R.drawable.qing, R.drawable.weilan, R.drawable.bg_4 };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appearance);
		SysApplication.getInstance().addActivity(this);
		Intent intent = getIntent();
		init();// 初始化
	}

	public void init() {
		cancel = (Button) findViewById(R.id.cancel);
		buttonListner = new ButtonListener();
		cancel.setOnClickListener(buttonListner);
		rbtns = new RadioButton[6];
		rbtns[0] = (RadioButton) findViewById(R.id.first);
		rbtns[1] = (RadioButton) findViewById(R.id.second);
		rbtns[2] = (RadioButton) findViewById(R.id.third);
		rbtns[3] = (RadioButton) findViewById(R.id.fourth);
		rbtns[4] = (RadioButton) findViewById(R.id.fifth);
		rbtns[5] = (RadioButton) findViewById(R.id.sixth);
		radioButtonListener = new RadioButtonListener();
		for (int i = 0; i < rbtns.length; i++) {
			rbtns[i].setOnClickListener(radioButtonListener);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.appearance, menu);
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
			if (id == R.id.cancel) {
				AppearanceActivity.this.finish();
			}
		}
	}

	class RadioButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			for (int i = 0; i < rbtns.length; i++) {
				if (id == buttonsid[i]) {
					// 测试，将当前页改了,ok
					LinearLayout vg = (LinearLayout) findViewById(R.id.title);
					vg.setBackgroundResource(pifusid[i]);
					
					//如果想修改别的页面，需要重写reSume（）
					// // 将主页和我的改了
					// Activity[] activities = { new ZhuyeActivity(),
					// new MineActivity() };// 确定页面
					// LinearLayout[] layouts = new
					// LinearLayout[activities.length];// 确定
					// for (int j = 0; j < layouts.length; j++) {
					// layouts[i] = (LinearLayout) activities[i]
					// .findViewById(R.id.title);
					// layouts[i].setBackgroundResource(pifusid[i]);
					// }
				}
			}
		}
	}
}
