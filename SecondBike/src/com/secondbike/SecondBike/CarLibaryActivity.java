package com.secondbike.SecondBike;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.seconbike.carlibary.MyData;
import com.seconbike.carlibary.Myadapter;

public class CarLibaryActivity extends Activity {
	private ListView listView;
	private Myadapter myadapter;
	private MyData[] datas;

	private Button tv3;
	private Button cancel;
	private ButtonListener btnListener;
	private Spinner tv1, tv2;
	private final String[] styles = { "品　牌", "永久", "阿米尼", "凤凰", "捷安特", "K2",
			"美利达", "千里达", "五羊", "追风鸟" };
	private final String[] prices = { "价　格", "0-100", "100-200", "200-300",
			"300-400", "400-500", "500-600", "600+" };
	private SpinnerListener1 spListener1;
	private SpinnerListener2 spListener2;
	private ListViewListener lvListener;
	private ArrayList<MyData> dataslist;

	// public static ArrayList<MyData> favordatas;
	// public static ArrayList<Integer> ids;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.car_libary);
		SysApplication.getInstance().addActivity(this);
		init();
		initSpinner();
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		if (bundle != null) {
			int style = bundle.getInt(FenleiActivity.STYLE);
			Log.e("carlibary", "style=" + style);
			tv1.setSelection(style);
		}
	}

	public void initSpinner() {
		tv1 = (Spinner) findViewById(R.id.tv1);
		tv2 = (Spinner) findViewById(R.id.tv2);
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		for (int i = 0; i < styles.length; i++) {
			list1.add(styles[i]);
		}
		for (int i = 0; i < prices.length; i++) {
			list2.add(prices[i]);
		}
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list1);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		tv1.setAdapter(adapter1);
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list2);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		tv2.setAdapter(adapter2);
		spListener1 = new SpinnerListener1();
		spListener2 = new SpinnerListener2();
		tv1.setOnItemSelectedListener(spListener1);
		tv2.setOnItemSelectedListener(spListener2);
	}

	public void init() {
		tv3 = (Button) findViewById(R.id.tv3);
		cancel = (Button) findViewById(R.id.cancel);
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
		tv3.setOnClickListener(btnListener);
		//
		lvListener = new ListViewListener();
		listView.setOnItemClickListener(lvListener);

		listView.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {

			@Override
			public void onCreateContextMenu(ContextMenu menu, View v,
					ContextMenuInfo menuInfo) {
				menu.add(0, 1, 0, "添加收藏");
			}

		});
		//
		//
		// ids = new ArrayList<Integer>();
		// favordatas = new ArrayList<MyData>();
		//

	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		if (item.getItemId() == 1) {
			AdapterContextMenuInfo acmenuinfo = (AdapterContextMenuInfo) item
					.getMenuInfo();
			int id = (int) myadapter.getItemId(acmenuinfo.position);// 取到id号(这个id为数据库中的对应id)
			MyData favorData = new MyData(datas[id].getName(),
					datas[id].getImageid(), datas[id].getPrice(),
					datas[id].isRentable(), datas[id].getRentPrice(),datas[id].getColor(),datas[id].getExpress());
			// //
			// ids.add(id);
			// favordatas.add(favorData);
			return true;
		}
		return false;
	}

	class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			if (id == R.id.cancel) {
				CarLibaryActivity.this.finish();
			} else if (id == R.id.tv3) {
				Intent intent = new Intent(CarLibaryActivity.this,
						BroHistoryActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
			}
		}
	}

	class SpinnerListener1 implements OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {

		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {

		}

	}

	class SpinnerListener2 implements OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {

		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {

		}

	}

	class ListViewListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// 点击之后跳转，数据动态送
			Log.e("车库", "posiiton="+position);
			MyData favorData = new MyData(datas[position].getName(),
					datas[position].getImageid(), datas[position].getPrice(),
					datas[position].isRentable(),
					datas[position].getRentPrice(),datas[position].getColor(),datas[position].getExpress());
			Bundle bundle = new Bundle();
			bundle.putSerializable(CarDetailActivity.carDetail, favorData);
			Intent intent = new Intent(CarLibaryActivity.this,
					CarDetailActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
			intent.putExtras(bundle);
			startActivity(intent);
		}

	}

}
