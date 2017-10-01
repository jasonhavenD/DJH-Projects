package com.secondbike.SecondBike;

import java.util.ArrayList;

import com.seconbike.carlibary.MyData;
import com.seconbike.carlibary.Myadapter;
import com.secondbike.SecondBike.ChangePWDActivity.DiagListener;
import com.secondbike.SecondBike.MyFaovrActivity.ButtonListener;
import com.secondbike.SecondBike.MyFaovrActivity.ListViewListener;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;

public class BroHistoryActivity extends Activity {

	private ListView listView;
	private Myadapter myadapter;
	private MyData[] datas;
	private ButtonListener btnListener;
	private ListViewListener lvListener;

	private Button cancel, clear;
	private ButtonListener buttonListner;
	private ArrayList<MyData> dataslist;
	private TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.brohistory);
		SysApplication.getInstance().addActivity(this);
		Intent intent = getIntent();
		init();
	}

	public void init() {
		cancel = (Button) findViewById(R.id.cancel);
		buttonListner = new ButtonListener();
		cancel.setOnClickListener(buttonListner);
		clear = (Button) findViewById(R.id.clear);
		clear.setOnClickListener(buttonListner);
		text = (TextView) findViewById(R.id.text);
		//
		datas = new MyData[5];
		datas[0] = new MyData("捷安特", R.drawable.a, 100, true, 10,"红色","express");
		datas[1] = new MyData("美利达", R.drawable.b, 100, false, 0,"红色","express");
		datas[2] = new MyData("凤凰", R.drawable.c, 100, true, 12,"红色","express");
		datas[3] = new MyData("永久", R.drawable.d, 100, true, 12,"红色","express");
		datas[4] = new MyData("飞鸽", R.drawable.e, 100, true, 12,"红色","express");
		//
		dataslist = new ArrayList<MyData>();
		for (int i = 0; i < datas.length; i++) {
			dataslist.add(datas[i]);
		}
		listView = (ListView) findViewById(R.id.listview);
		myadapter = new Myadapter(this, dataslist);
		listView.setAdapter(myadapter);
		btnListener = new ButtonListener();
		cancel.setOnClickListener(btnListener);
		//
		lvListener = new ListViewListener();
		listView.setOnItemClickListener(lvListener);
		//
		listView.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {

			@Override
			public void onCreateContextMenu(ContextMenu menu, View v,
					ContextMenuInfo menuInfo) {
				menu.add(0, 1, 1, "清除记录");
			}
		});
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo acmenuinfo = (AdapterContextMenuInfo) item
				.getMenuInfo();
		int id = (int) myadapter.getItemId(acmenuinfo.position);
		// 取到id号(这个id为数据库中的对应id)
		// 重新设置adapter
		dataslist.remove(id);
		if (dataslist.size() > 0) {
			myadapter = new Myadapter(this, dataslist);
			listView.setAdapter(myadapter);
		} else {
			listView.setAdapter(null);
			listView.setEmptyView(text);
		}
		return true;
	}

	// 按钮监听器
	public class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			if (id == R.id.cancel) {
				BroHistoryActivity.this.finish();
			} else if (id == R.id.clear) {
				// 将当前页面布局内容清空
				// 判断是否已经空了
				if (listView.getItemAtPosition(0) == null) {
					DiagListener diagListener1 = new DiagListener();
					AlertDialog.Builder builder = new AlertDialog.Builder(
							BroHistoryActivity.this,
							AlertDialog.THEME_HOLO_LIGHT);
					builder.setTitle("清除历史");
					builder.setMessage("暂无历史记录！");
					builder.setNegativeButton("确定", diagListener1);
					AlertDialog dialog = builder.create();
					dialog.show();
					return;
				}
				DiagListener diagListener = new DiagListener();
				AlertDialog.Builder builder = new AlertDialog.Builder(
						BroHistoryActivity.this, AlertDialog.THEME_HOLO_LIGHT);
				builder.setTitle("清除历史");
				builder.setMessage("确定清除历史记录吗？");
				builder.setPositiveButton("确定", diagListener);
				builder.setNegativeButton("取消", diagListener);
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		}
	}

	class DiagListener implements
			android.content.DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			if (which == AlertDialog.BUTTON_POSITIVE) {
				listView.setAdapter(null);
				listView.setEmptyView(text);
			} else if (which == AlertDialog.BUTTON_NEGATIVE) {

			}
		}
	}

	class ListViewListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// 点击之后跳转，数据动态送
			Intent intent = new Intent(BroHistoryActivity.this,
					CarDetailActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
			startActivity(intent);
		}

	}
}
