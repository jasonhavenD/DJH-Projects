package com.example.agricultural;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class UserListActivity extends Activity {
	
	private Button beginButton;
	private Button stopButton;
	
	private ImageView userBackImageView;
	private TextView userTitleText;
	private TextView userTitleIconText;
	private Button userCloseButton;
	
	private ListView userListView=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_list_activity);
		
		beginButton = (Button)findViewById(R.id.begain_button);
		stopButton=(Button)findViewById(R.id.stop_button);
		userBackImageView =(ImageView)findViewById(R.id.user_back_icon);
		userTitleText=(TextView)findViewById(R.id.user_title_text);
		userTitleIconText=(TextView)findViewById(R.id.user_icon_text);
		userCloseButton = (Button)findViewById(R.id.user_close_icon);
		
		userListView=(ListView)findViewById(R.id.user_list);
		List<Map<String, Object>> list=getData();  
		userListView.setAdapter(new UserListAdapter(this, list));
        userListView.setOnItemClickListener(new ItemClickListener());
		
		beginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intents = new Intent();
				intents.setClass(UserListActivity.this, OnlineTalkActivity.class);
				startActivity(intents);
			}
		});
		
		stopButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		userBackImageView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		userTitleText.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		userTitleIconText.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		userCloseButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		
	}
	
	public List<Map<String, Object>> getData(){  
        List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();  
        
		
		for (int i = 0; i < 5; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("icon", R.drawable.online_title_icon);
			map.put("name", "咨询用户00"+(i+1));
			map.put("state", R.drawable.user_go_icon);
			list.add(map);
		}
         
        return list;  
    }
	
	 private final class ItemClickListener implements OnItemClickListener{  
		  
	        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {  
//	            ListView listView = (ListView) parent;  
//	            HashMap<String, Object> data = (HashMap<String, Object>) listView.getItemAtPosition(position);  
//	            String personid = data.get("id").toString();  
//	            Toast.makeText(getApplicationContext(), personid, 1).show(); 
//	            
	            	Intent intents = new Intent();
					intents.setClass(UserListActivity.this, OnlineTalkActivity.class);
					startActivity(intents);

	        }  
	    } 

}
