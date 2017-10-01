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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DoctorListActivity extends Activity {
	

	
	private ImageView backImageView;
	private TextView doctorTitleText;
	private TextView doctorTitleIconText;
	private ListView doctorListView=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctor_list_activity);
		

		backImageView =(ImageView)findViewById(R.id.doctor_back_icon);
		doctorTitleText=(TextView)findViewById(R.id.doctor_title_text);
		doctorTitleIconText=(TextView)findViewById(R.id.docor_icon_text);
		doctorListView=(ListView)findViewById(R.id.doctor_list);  
        List<Map<String, Object>> list=getData();  
        doctorListView.setAdapter(new DoctorListAdapter(this, list));
        doctorListView.setOnItemClickListener(new ItemClickListener());
		
		backImageView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		doctorTitleText.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		doctorTitleIconText.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
	public List<Map<String, Object>> getData(){  
        List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();  
        
            Map<String, Object> map=new HashMap<String, Object>(); 
            
            map.put("icon", R.drawable.online_title_icon);  
            map.put("name", "问亚军");  
            map.put("state_text", "(在线)");  
            map.put("info", "渭南市农业科学研究所高级农艺师");  
            map.put("waitNumber", "排队人数：98");  
            map.put("state", R.drawable.online_state_icon);  
            list.add(map);  
            Map<String, Object> map1=new HashMap<String, Object>();
            map1.put("icon", R.drawable.online_title_icon);  
            map1.put("name", "赵老师");  
            map1.put("state_text", "(在线)");  
            map1.put("info", "杨凌区农业科学研究所高级农艺师");  
            map1.put("waitNumber", "排队人数：92");  
            map1.put("state", R.drawable.online_state_icon);  
            list.add(map1);  
            Map<String, Object> map2=new HashMap<String, Object>();
            map2.put("icon", R.drawable.online_title_icon);  
            map2.put("name", "王老师");  
            map2.put("state_text", "(在线)");  
            map2.put("info", "杨凌区农业科学研究所高级农艺师");  
            map2.put("waitNumber", "排队人数：0");  
            map2.put("state", R.drawable.online_state_icon);  
            list.add(map2);  
            Map<String, Object> map3=new HashMap<String, Object>();
            map3.put("icon", R.drawable.offline_title_icon);  
            map3.put("name", "高站长");  
            map3.put("state_text", "(离线)");  
            map3.put("info", "西安市农业科学研究所高级农艺师");  
            map3.put("waitNumber", "排队人数：0");  
            map3.put("state", R.drawable.offline_state_icon);  
            list.add(map3);  
            Map<String, Object> map4=new HashMap<String, Object>();
            map4.put("icon", R.drawable.offline_title_icon);  
            map4.put("name", "黄先生");  
            map4.put("state_text", "(离线)");  
            map4.put("info", "北京市农业科学研究所高级农艺师");  
            map4.put("waitNumber", "排队人数：0");  
            map4.put("state", R.drawable.offline_state_icon);  
            list.add(map4);  
  
         
        return list;  
    }
	
	 private final class ItemClickListener implements OnItemClickListener{  
		  
	        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {  
//	            ListView listView = (ListView) parent;  
//	            HashMap<String, Object> data = (HashMap<String, Object>) listView.getItemAtPosition(position);  
//	            String personid = data.get("id").toString();  
//	            Toast.makeText(getApplicationContext(), personid, 1).show(); 
//	            
	            if(position == 0||position==1){
	            	Intent intents = new Intent();
					intents.setClass(DoctorListActivity.this, WaitAndInfoActivity.class);
					startActivity(intents);
	            }else if(position==2){
	            	Intent intents = new Intent();
					intents.setClass(DoctorListActivity.this, OnlineTalkActivity.class);
					startActivity(intents);
	            }else{
	            	Toast.makeText(getApplicationContext(), "专家不在线", Toast.LENGTH_SHORT).show();
	            }
	        }  
	    }  

}
