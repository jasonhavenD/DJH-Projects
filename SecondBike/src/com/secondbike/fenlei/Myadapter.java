package com.secondbike.fenlei;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

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
					R.layout.fenlei_item, null);// 加载一个视图
		}
		// TextView tv = (TextView) convertView.findViewById(R.id.mine_tv);//
		// 加载视图里面的控件-名称
		// tv.setText(data[position].getName());

		ImageView image = (ImageView) convertView.findViewById(R.id.mine_tv);

		Drawable drawable = parent.getResources().getDrawable(
				data[position].getImageId());
		drawable.setBounds(0, 0, drawable.getMinimumWidth(),
				drawable.getMinimumHeight());
		image.setImageDrawable(drawable);
		// tv.setCompoundDrawables(drawable, null, null, null); // 设置图标

		return convertView;
	}
}
