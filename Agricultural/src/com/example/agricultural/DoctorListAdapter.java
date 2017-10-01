package com.example.agricultural;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DoctorListAdapter extends BaseAdapter {
	
	private List<Map<String, Object>> data;  
    private LayoutInflater layoutInflater;  
    private Context context;  
    public DoctorListAdapter(Context context,List<Map<String, Object>> data){  
        this.context=context;  
        this.data=data;  
        this.layoutInflater=LayoutInflater.from(context);  
    }
    
    public final class DcotorView{  
        public ImageView icon;  
        public TextView name;  
        public TextView state_text;  
        public TextView info;  
        public TextView waitNumber;  
        public ImageView state; 
    } 

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		DcotorView mDoctorView=null;  
        if(convertView==null){  
            mDoctorView=new DcotorView();  
            // get view  
            convertView=layoutInflater.inflate(R.layout.doctor_list, null);  
            mDoctorView.icon=(ImageView)convertView.findViewById(R.id.doctor_list_icon);  
            mDoctorView.name=(TextView)convertView.findViewById(R.id.doctor_list_name);  
            mDoctorView.state_text=(TextView)convertView.findViewById(R.id.doctor_list_state_text);  
            mDoctorView.info=(TextView)convertView.findViewById(R.id.doctor_list_info);  
            mDoctorView.waitNumber=(TextView)convertView.findViewById(R.id.doctor_list_wait_number);
            mDoctorView.state=(ImageView)convertView.findViewById(R.id.doctor_list_state);
            convertView.setTag(mDoctorView);  
        }else{  
            mDoctorView=(DcotorView)convertView.getTag();  
        }  
        //bind data

        mDoctorView.icon.setImageResource((Integer)data.get(position).get("icon"));  
        mDoctorView.name.setText((String)data.get(position).get("name"));  
        mDoctorView.state_text.setText((String)data.get(position).get("state_text"));  
        mDoctorView.info.setText((String)data.get(position).get("info"));  
        mDoctorView.waitNumber.setText((String)data.get(position).get("waitNumber"));  
        mDoctorView.state.setImageResource((Integer)data.get(position).get("state"));  
        return convertView;  
    } 

}
