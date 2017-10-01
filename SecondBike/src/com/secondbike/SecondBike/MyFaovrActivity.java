package com.secondbike.SecondBike;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.seconbike.carlibary.MyData;
import com.seconbike.carlibary.Myadapter;

public class MyFaovrActivity extends Activity {
	private TextView text;
	private ListView listView;
	private Myadapter myadapter;
	private Button cancel, clear;
	private ButtonListener btnListener;
	private ListViewListener lvListener;
	private MyData[] datas;
	private ArrayList<MyData> dataslist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_faovr);
		init();
	}

	public void init() {
		clear = (Button) findViewById(R.id.clear);
		cancel = (Button) findViewById(R.id.cancel);
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
		clear.setOnClickListener(btnListener);
		cancel.setOnClickListener(btnListener);
		lvListener = new ListViewListener();
		listView.setOnItemClickListener(lvListener);
		listView.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {

			@Override
			public void onCreateContextMenu(ContextMenu menu, View v,
					ContextMenuInfo menuInfo) {
				menu.add(0, 1, 1, "取消收藏");
			}
		});
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo acmenuinfo = (AdapterContextMenuInfo) item
				.getMenuInfo();
		int id = (int) myadapter.getItemId(acmenuinfo.position);// 取到id号(这个id为数据库中的对应id)
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

	class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			if (id == R.id.cancel) {
				MyFaovrActivity.this.finish();
			} else if (id == R.id.clear) {
				if (listView.getItemAtPosition(0) == null) {
					DiagListener diagListener1 = new DiagListener();
					AlertDialog.Builder builder = new AlertDialog.Builder(
							MyFaovrActivity.this, AlertDialog.THEME_HOLO_LIGHT);
					builder.setTitle("清除收藏");
					builder.setMessage("暂无收藏记录!");
					builder.setNegativeButton("确定", diagListener1);
					AlertDialog dialog = builder.create();
					dialog.show();
					return;
				}
				DiagListener diagListener = new DiagListener();
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MyFaovrActivity.this, AlertDialog.THEME_HOLO_LIGHT);
				builder.setTitle("清除收藏");
				builder.setMessage("确定清除收藏吗？");
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
			Log.e("收藏", "posiiton="+position);
			MyData favorData = new MyData(datas[position].getName(),
					datas[position].getImageid(), datas[position].getPrice(),
					datas[position].isRentable(),
					datas[position].getRentPrice(), datas[position].getColor(),datas[position].getExpress());// 点击之后跳转，数据动态送
			Bundle bundle = new Bundle();
			bundle.putSerializable(CarDetailActivity.carDetail, favorData);
			Intent intent = new Intent(MyFaovrActivity.this,
					CarDetailActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
			intent.putExtras(bundle);
			startActivity(intent);
		}

	}
}
