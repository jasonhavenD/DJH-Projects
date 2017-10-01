package com.secondbike.SecondBike;

import java.util.ArrayList;
import java.util.List;

import com.seconbike.carlibary.MyData;
import com.secondbike.blinktophone.BlinkActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CarDetailActivity extends Activity {

	private Button cancel;
	private ButtonListener buttonListener;
	private ViewPager viewpager;
	private List<View> list;
	private ViewGroup group;
	private ImageView imageviews[];
	private ImageView imageview;
	private TextView link;
	private TextViewListener listener;
	//
	private TextView bikenametv, pricetv, rentpricetv, colortv, unametv,
			contacttv, QQtv, expressiontv, rentlabeltv;
	public static String carDetail = "carDetail";
	//
	private String bikename, price, rentprice, color, uname, contact, QQ,
			rentable, expression;

	//
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.car_detail);
		SysApplication.getInstance().addActivity(this);
		init();
		initDetail();
	}

	public void init() {
		link = (TextView) findViewById(R.id.link);
		listener = new TextViewListener();
		link.setOnClickListener(listener);
		cancel = (Button) findViewById(R.id.cancel);
		buttonListener = new ButtonListener();
		cancel.setOnClickListener(buttonListener);
		viewpager = (ViewPager) findViewById(R.id.viewPager);
		View view1 = getLayoutInflater().inflate(R.layout.item01, null);
		View view2 = getLayoutInflater().inflate(R.layout.item02, null);
		View view3 = getLayoutInflater().inflate(R.layout.item03, null);
		list = new ArrayList<View>();
		list.add(view1);
		list.add(view2);
		list.add(view3);
		viewpager.setAdapter(new Myadaper());
		//
		group = (ViewGroup) findViewById(R.id.viewGroup);
		// 有多少个图就有多少个点
		imageviews = new ImageView[list.size()];
		LinearLayout.LayoutParams margin = new LinearLayout.LayoutParams(10, 10);
		margin.setMargins(10, 0, 0, 0);
		for (int i = 0; i < imageviews.length; i++) {
			imageview = new ImageView(this);
			imageview.setLayoutParams(margin);
			imageview.setPadding(10, 0, 10, 0);
			imageviews[i] = imageview;

			// 默认第一张被选中
			if (i == 0) {
				imageviews[i].setBackgroundResource(R.drawable.point_select);
				imageviews[i].setSelected(true);
			} else {
				imageviews[i].setBackgroundResource(R.drawable.point_normal);
				imageviews[i].setSelected(false);
			}
			group.addView(imageviews[i]);
		}

		// 监听viewpager
		viewpager.setOnPageChangeListener(new ViewPagerListener());
	}

	public void initDetail() {
		bikenametv = (TextView) findViewById(R.id.bikename);
		pricetv = (TextView) findViewById(R.id.price);
		rentpricetv = (TextView) findViewById(R.id.rentprice);
		colortv = (TextView) findViewById(R.id.color);
		unametv = (TextView) findViewById(R.id.uname);
		contacttv = (TextView) findViewById(R.id.contact);
		QQtv = (TextView) findViewById(R.id.QQ);
		expressiontv = (TextView) findViewById(R.id.expression);
		rentlabeltv = (TextView) findViewById(R.id.Rentlabel);
		// 获取数据
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		if (bundle != null) {
			Log.e("cardetail:", "bundle!=null");// ok
			SharedPreferences sharedPreferences = getSharedPreferences(
					DengluActivity.PREFERENCE_NAME, DengluActivity.MODE);
			MyData car = (MyData) bundle.getSerializable(carDetail);
			bikename = car.getName();
			price = String.valueOf(car.getPrice());
			color = car.getColor();
			uname = sharedPreferences.getString(XiugaiAccountActivity.NICHENG,
					"昵称");
			contact = sharedPreferences.getString(BlinkActivity.PHONE, "手机号");
			QQ = sharedPreferences.getString(XiugaiAccountActivity.QQ, "QQ");
			expression = sharedPreferences.getString(GuacheActivity.EXPRESSION,
					car.getExpress());
			if (car.isRentable()) {
				rentable = new String("可租");
				rentprice = String.valueOf(car.getRentPrice());
			} else {
				rentable = new String("不可租");
				rentprice = new String("");
			}
			bikenametv.setText(bikename);
			pricetv.setText(price);
			rentpricetv.setText(rentprice);
			colortv.setText(color);
			rentlabeltv.setText(rentable);
			unametv.setText(uname);
			contacttv.setText(contact);
			QQtv.setText(QQ);
			expressiontv.setText(expression);
			Log.e("cardetail:", "name=" + bikename + ",price=" + price
					+ ",rentprice" + rentprice + ",rentable" + rentable
					+ ",color" + color);// ok
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.car_detail, menu);
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

	class TextViewListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			if (v.getId() == R.id.link) {
				Intent intent = new Intent(CarDetailActivity.this,
						ContactSolderActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
			}
		}

	}

	// 按钮监听器
	class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			if (id == R.id.cancel) {
				CarDetailActivity.this.finish();
			}
		}
	}

	class ViewPagerListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageSelected(int arg0) {
			for (int i = 0; i < imageviews.length; i++) {
				imageviews[arg0].setBackgroundResource(R.drawable.point_select);
				imageviews[i].setSelected(true);
				if (arg0 != i) {
					imageviews[i]
							.setBackgroundResource(R.drawable.point_normal);
					imageviews[i].setSelected(false);
				}
			}

		}

	}

	class Myadaper extends PagerAdapter {

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager) container).removeView(list.get(position));
		}

		@Override
		public Object instantiateItem(View container, int position) {
			((ViewPager) container).addView(list.get(position));
			return list.get(position);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

	}
}
