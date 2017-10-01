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

public class UserListAdapter extends BaseAdapter {
	
	private List<Map<String, Object>> data;  
    private LayoutInflater layoutInflater;  
    private Context context;  
    public UserListAdapter(Context context,List<Map<String, Object>> data){  
        this.context=context;  
        this.data=data;  
        this.layoutInflater=LayoutInflater.from(context);  
    }
    
    public final class UserView{  
        public ImageView icon;  
        public TextView name;  
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
		
		UserView mUserView=null;  
        if(convertView==null){  
            mUserView=new UserView();  
            // get view  
            convertView=layoutInflater.inflate(R.layout.user_list, null);  
            mUserView.icon=(ImageView)convertView.findViewById(R.id.user_list_icon);  
            mUserView.name=(TextView)convertView.findViewById(R.id.user_list_name);  
            mUserView.state=(ImageView)convertView.findViewById(R.id.user_list_state);
            convertView.setTag(mUserView);  
        }else{  
            mUserView=(UserView)convertView.getTag();  
        }  
        //bind data

        mUserView.icon.setImageResource((Integer)data.get(position).get("icon"));  
        mUserView.name.setText((String)data.get(position).get("name"));  
        mUserView.state.setImageResource((Integer)data.get(position).get("state"));  
        return convertView;  
    } 

}
