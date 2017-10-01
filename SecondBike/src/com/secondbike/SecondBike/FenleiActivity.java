package com.secondbike.SecondBike;

import com.secondbike.fenlei.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class FenleiActivity extends Activity {

	private Button cancel;
	private ButtonListener buttonListner;
	private ListView listView;
	private Myadapter myadapter;
	private MyData[] datas;
	private ListViewListener listViewListener;
	private int imagesId[] = { R.drawable.label_yongjiu, R.drawable.label_amini,
			R.drawable.label_fenghaung, R.drawable.label_jieante,
			R.drawable.label_k2, R.drawable.label_meilida,
			R.drawable.label_qianlida, R.drawable.label_wuyang,
			R.drawable.label_zhuifengniao };
	public final static String STYLE="fenlei";
	//这里和品牌顺序保存统一
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fenlei);
		SysApplication.getInstance().addActivity(this);
		Intent intent = getIntent();// 启动
		init();// 初始化和事件监听
	}

	public void init() {
		cancel = (Button) findViewById(R.id.cancel);
		buttonListner = new ButtonListener();
		cancel.setOnClickListener(buttonListner);
		MyData[] datas = new MyData[imagesId.length];
		for (int i = 0; i < datas.length; i++) {
			datas[i] = new MyData(imagesId[i]);
		}
		listView = (ListView) findViewById(R.id.fenlei_listview);
		myadapter = new Myadapter(this, datas);
		listView.setAdapter(myadapter);
		listViewListener = new ListViewListener();
		listView.setOnItemClickListener(listViewListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fenlei, menu);
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
				FenleiActivity.this.finish();
			}
		}
	}

	// ListViewListener
	class ListViewListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent intent = new Intent(FenleiActivity.this,CarLibaryActivity.class);
			Log.e("position=" + position, "id=" + id);
			Bundle bundle=new Bundle();
			bundle.putInt(STYLE, position+1);
			intent.putExtras(bundle);
			intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
			startActivity(intent);
		}

	}

}
