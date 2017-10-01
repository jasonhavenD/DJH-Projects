package com.secondbike.SecondBike;

import com.secondbike.mine_libary.MyData;
import com.secondbike.mine_libary.Myadapter;
import com.secondbike.secuphone.SecuPhoneActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MineActivity extends Activity {
	private ListView listView;
	private Myadapter myadapter;
	private MyData[] datas;
	private ListViewListener listViewListener;
	private Button cancel, exit;
	private ButtonListener buttonListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mine);
		SysApplication.getInstance().addActivity(this);
		Intent i = getIntent();
		init();// 初始化
	}

	public void init() {
		String[] names = { "我的账号", "密保手机", "我要挂车", "我要求车", "我的收藏", "皮肤设置",
				"修改密码", "清除缓存", "关于我们", "退出账号", "清除数据" };
		int[] imageIDs = { R.drawable.account, R.drawable.contact,
				R.drawable.guache, R.drawable.qiuche, R.drawable.mydeal,
				R.drawable.setting, R.drawable.changepwd, R.drawable.guache,
				R.drawable.about, R.drawable.exit, R.drawable.guache };
		datas = new MyData[names.length];
		// 初始化
		for (int i = 0; i < datas.length; i++) {
			datas[i] = new MyData(imageIDs[i], names[i]);
		}
		listView = (ListView) findViewById(R.id.listview1);
		myadapter = new Myadapter(this, datas);
		listView.setAdapter(myadapter);
		cancel = (Button) findViewById(R.id.cancel);
		buttonListener = new ButtonListener();
		cancel.setOnClickListener(buttonListener);
		exit = (Button) findViewById(R.id.exit);
		exit.setOnClickListener(buttonListener);
		listViewListener = new ListViewListener();
		listView.setOnItemClickListener(listViewListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mine, menu);
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

	// ListViewListener
	class ListViewListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// "我的账号","安全手机" "我要挂车", "我要求车", "我的交易", "我的收藏","皮肤设置", "修改密码",
			// "关于我们","退出账号"
			Intent intent = null;
			switch (position) {
			case 0:// 我的账号
				intent = new Intent(MineActivity.this, MyAccountActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				break;
			case 1:
				// 安全手机
				intent = new Intent(MineActivity.this, SecuPhoneActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				break;
			case 2:// 我要挂车
				intent = new Intent(MineActivity.this, GuacheActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				break;
			case 3:// 我要求车
				intent = new Intent(MineActivity.this, QiucheActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				break;
			case 4:
				// 我的收藏
				intent = new Intent(MineActivity.this, MyFaovrActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				break;
			case 5:
				intent = new Intent(MineActivity.this, AppearanceActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				break;
			case 6:
				intent = new Intent(MineActivity.this, ChangePWDActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				break;
			case 7:
				// 清除缓存
				DiagListener2 diagListener2 = new DiagListener2();
				AlertDialog.Builder builder2 = new AlertDialog.Builder(
						MineActivity.this, AlertDialog.THEME_HOLO_LIGHT);
				builder2.setTitle("清除缓存");
				builder2.setMessage("清除缓存可能影响浏览速度，请三思啊！");
				builder2.setPositiveButton("确定", diagListener2);
				builder2.setNeutralButton("取消", diagListener2);
				AlertDialog dialog2 = builder2.create();
				dialog2.show();
				break;
			case 8://
				intent = new Intent(MineActivity.this, AboutActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				break;
			case 9:
				DiagListener1 diagListener = new DiagListener1();
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MineActivity.this, AlertDialog.THEME_HOLO_LIGHT);
				builder.setTitle("退出账号");
				builder.setMessage("亲，退出账号后要重新登录哦！");
				builder.setPositiveButton("确定", diagListener);
				builder.setNeutralButton("取消", diagListener);
				AlertDialog dialog = builder.create();
				dialog.show();
				break;
			case 10:
				DiagListener3 diagListener3 = new DiagListener3();
				AlertDialog.Builder builder3 = new AlertDialog.Builder(
						MineActivity.this, AlertDialog.THEME_HOLO_LIGHT);
				builder3.setTitle("清除数据");
				builder3.setMessage("清除账号等信息，请三思啊！");
				builder3.setPositiveButton("确定", diagListener3);
				builder3.setNeutralButton("取消", diagListener3);
				AlertDialog dialog3 = builder3.create();
				dialog3.show();
			}

		}
	}

	// 按钮监听器
	public class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			if (id == R.id.cancel) {
				MineActivity.this.finish();
			}
		}
	}

	class DiagListener1 implements
			android.content.DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
			case AlertDialog.BUTTON_POSITIVE:
				Intent intent = new Intent(MineActivity.this,
						DengluActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				break;
			case AlertDialog.BUTTON_NEUTRAL:
				break;
			}
		}

	}

	class DiagListener2 implements
			android.content.DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
			case AlertDialog.BUTTON_POSITIVE:
				Toast.makeText(MineActivity.this, "成功清除！", Toast.LENGTH_SHORT)
						.show();
				break;
			case AlertDialog.BUTTON_NEUTRAL:
				break;
			}
		}

	}

	class DiagListener3 implements
			android.content.DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
			case AlertDialog.BUTTON_POSITIVE:
				SharedPreferences sharedPreferences = getSharedPreferences(
						DengluActivity.PREFERENCE_NAME, DengluActivity.MODE);
				(sharedPreferences.edit()).clear().commit();
				Toast.makeText(MineActivity.this, "成功清除！", Toast.LENGTH_SHORT)
						.show();
				break;
			case AlertDialog.BUTTON_NEUTRAL:
				break;
			}
		}

	}

}
