package com.seconbike.carlibary;

import java.util.ArrayList;

import com.secondbike.SecondBike.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Myadapter extends BaseAdapter {

	private Context context;// 承接上下文
	private ArrayList<MyData> datas;

	public Myadapter(Context context, ArrayList<MyData> datas) {
		super();
		this.context = context;
		this.datas=datas;
	}
	
	/**
	 * 当前数据长度
	 */
	@Override
	public int getCount() {
		if(datas==null){
			return 0;
		}else{
			return datas.size();
		}
	}

	/**
	 * 每一条数据的item
	 */
	@Override
	public Object getItem(int position) {
		return datas.get(position);
	}

	/**
	 * 每一条数据的id
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}

	public boolean remove(int position){
		if(datas.isEmpty()){
			return false;
		}
		if(datas.size()==1){
			datas.remove(position);
			return false;
		}
		if(position>=0&&position<datas.size()){
			datas.remove(position);
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 需要加载的视图
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.car,
					null);// 加载一个视图得到一个实体convertView
		}
		TextView tv = (TextView) convertView.findViewById(R.id.textview1);// 加载视图里面的控件-名称
		tv.setText(datas.get(position).getName());

		TextView tv1 = (TextView) convertView.findViewById(R.id.price);// 加载视图里面的控件-价格
		tv1.setText(String.valueOf(datas.get(position).getPrice()));

		TextView tv2 = (TextView) convertView.findViewById(R.id.borrow_label);// 加载视图里面的控件-可租
		if (datas.get(position).isRentable()) {
			tv2.setText("可租");
		} else {
			tv2.setText("不可租");
		}

		TextView tv3 = (TextView) convertView.findViewById(R.id.borrow_price);// 加载视图里面的控件-租金
		tv3.setText(String.valueOf(String.valueOf(datas.get(position).getRentPrice())));

		ImageView imageView = (ImageView) convertView.findViewById(R.id.image);// 加载图片
		imageView.setImageResource(datas.get(position).getImageid());

		return convertView;
	}
	
	
}
