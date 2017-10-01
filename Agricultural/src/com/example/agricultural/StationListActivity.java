package com.example.agricultural;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StationListActivity extends Activity {
	
	private Button enterStation1;
	private Button enterStation2;
	private Button enterStation3;
	private Button enterStation4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stationlist);
		
		enterStation1=(Button)findViewById(R.id.station_1);
		enterStation2=(Button)findViewById(R.id.station_2);
		enterStation3=(Button)findViewById(R.id.station_3);
		enterStation4=(Button)findViewById(R.id.station_4);
		
		enterStation1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intents = new Intent();
				if(AgriApplication.getInstance().getUserType()== AgriApplication.USER_TYPE_DOCTOR){
					intents.setClass(StationListActivity.this, UserListActivity.class);
				}else{
					intents.setClass(StationListActivity.this, DoctorListActivity.class);
				}
				
				startActivity(intents);
			}
		});
		enterStation2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intents = new Intent();
				if(AgriApplication.getInstance().getUserType()== AgriApplication.USER_TYPE_DOCTOR){
					intents.setClass(StationListActivity.this, UserListActivity.class);
				}else{
					intents.setClass(StationListActivity.this, DoctorListActivity.class);
				}
				startActivity(intents);
			}
		});
		enterStation3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intents = new Intent();
				if(AgriApplication.getInstance().getUserType()== AgriApplication.USER_TYPE_DOCTOR){
					intents.setClass(StationListActivity.this, UserListActivity.class);
				}else{
					intents.setClass(StationListActivity.this, DoctorListActivity.class);
				}
				startActivity(intents);
			}
		});
		enterStation4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intents = new Intent();
				if(AgriApplication.getInstance().getUserType()== AgriApplication.USER_TYPE_DOCTOR){
					intents.setClass(StationListActivity.this, UserListActivity.class);
				}else{
					intents.setClass(StationListActivity.this, DoctorListActivity.class);
				}
				startActivity(intents);
			}
		});
	}
}
