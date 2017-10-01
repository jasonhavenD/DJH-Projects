package com.secondbike.fogetpwd;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.secondbike.SecondBike.DengluActivity;
import com.secondbike.SecondBike.R;
import com.secondbike.SecondBike.SysApplication;

public class NextActivity extends Activity {

	private ImageView imagecode;
	private TextView changecode;
	private EditText code;
	private Button submit, cancel;
	private ButtonListener buttonListener;
	private TextViewListener textViewListener;
	final String[] codes = { "7428", "5483", "6952", "4106", "8609", "4291" };
	final int[] codeimages = { R.drawable.code1, R.drawable.code2,
			R.drawable.code3, R.drawable.code4, R.drawable.code5,
			R.drawable.code6 };
	String answer = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forget_next);
		SysApplication.getInstance().addActivity(this);
		init();// 初始化

	}

	public void init() {
		imagecode = (ImageView) findViewById(R.id.imagecode);
		changecode = (TextView) findViewById(R.id.change);
		code = (EditText) findViewById(R.id.codeEdittext);
		submit = (Button) findViewById(R.id.submit);
		cancel = (Button) findViewById(R.id.cancel);
		buttonListener = new ButtonListener();
		textViewListener = new TextViewListener();
		submit.setOnClickListener(buttonListener);
		cancel.setOnClickListener(buttonListener);
		changecode.setOnClickListener(textViewListener);
		// 获取answer
		answer = codes[0];
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.next, menu);
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
			if (id == R.id.submit) {
				String input = code.getText().toString();
				if (input.length() == 0) {
					AlertDialog.Builder builder = new AlertDialog.Builder(
							NextActivity.this, AlertDialog.THEME_HOLO_LIGHT);
					builder.setTitle("验证结果");
					builder.setMessage("请输入验证码！");
					builder.setPositiveButton("确定", new DialogListener());
					AlertDialog dialog = builder.create();
					dialog.show();
					return;
				}
				if (!input.equals(answer)) {
					AlertDialog.Builder builder = new AlertDialog.Builder(
							NextActivity.this, AlertDialog.THEME_HOLO_LIGHT);
					builder.setTitle("验证结果");
					builder.setMessage("验证码不正确！");
					builder.setPositiveButton("确定", new DialogListener());
					AlertDialog dialog = builder.create();
					dialog.show();
					return;
				}
				// 进入修改密码
				Intent intent = getIntent();// 启动
				String uname=intent.getStringExtra(DengluActivity.UNAME);
				Intent intent2 = new Intent(NextActivity.this,
						ChPWDActivity.class);
				intent2.putExtra(DengluActivity.UNAME, uname);
				intent2.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent2);
				//
				// AlertDialog.Builder builder = new AlertDialog.Builder(
				// NextActivity.this, AlertDialog.THEME_HOLO_LIGHT);
				// builder.setTitle("提交结果");
				// builder.setMessage("提交成功！返回登录界面");
				// builder.setNegativeButton("确定", new DialogListener());
				// AlertDialog dialog = builder.create();
				// dialog.show();
			} else if (id == R.id.cancel) {
				// 跳回登录
				Intent intent = new Intent(NextActivity.this,
						DengluActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}

		}
	}

	class TextViewListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// 修改图片
			int x = 0;
			Random random = new Random();
			x = random.nextInt(codes.length);
			Drawable drawable = getResources().getDrawable(codeimages[x]);
			drawable.setBounds(0, 0, drawable.getMinimumWidth(),
					drawable.getMinimumHeight());
			imagecode.setBackgroundDrawable(drawable);
			answer = codes[x];
		}

	}

	class DialogListener implements
			android.content.DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
			// case AlertDialog.BUTTON_NEGATIVE:
			// // 跳回登录
			// Intent intent = new Intent(NextActivity.this,
			// DengluActivity.class);
			// intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			// startActivity(intent);
			// break;
			}

		}

	}

}
