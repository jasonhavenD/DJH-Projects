package com.secondbike.mine_libary;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.secondbike.SecondBike.R;

public class Myadapter extends BaseAdapter {

	private Context context;// 承接上下文
	private MyData data[];

	public Myadapter(Context context, MyData[] data) {
		super();
		this.context = context;
		this.data = data;
	}

	/**
	 * 当前数据长度
	 */
	@Override
	public int getCount() {

		return data.length;
	}

	/**
	 * 每一条数据的item
	 */
	@Override
	public Object getItem(int position) {
		return data[position];
	}

	/**
	 * 每一条数据的id
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}

	/**
	 * 需要加载的视图
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.mine_item, null);// 加载一个视图
		}
		TextView tv = (TextView) convertView.findViewById(R.id.mine_tv);// 加载视图里面的控件-名称
		tv.setText(data[position].getName());

		Drawable drawable = parent.getResources().getDrawable(
				data[position].getImageId());
		Drawable right = parent.getResources()
				.getDrawable(R.drawable.btn_fuhao);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(),
				drawable.getMinimumHeight());
		right.setBounds(0, 0, right.getMinimumWidth(), right.getMinimumHeight());
		tv.setCompoundDrawables(drawable, null, right, null); // 设置图标

		return convertView;
	}
}
