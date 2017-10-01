package com.secondbike.SecondBike;

import com.secondbike.about.SuggestActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ContactSolderActivity extends Activity {

	private Button cancel,fankui; 
	private ButtonListener buttonlistener;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_solder);
		SysApplication.getInstance().addActivity(this);
		init();
	}
	
	public void init(){
		cancel=(Button) findViewById(R.id.cancel);
		fankui=(Button) findViewById(R.id.fankui);
		buttonlistener=new ButtonListener();
		cancel.setOnClickListener(buttonlistener);
		fankui.setOnClickListener(buttonlistener);
	}
	class ButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			int id=v.getId();
			if(id==R.id.cancel){
				ContactSolderActivity.this.finish();
			}else if(id==R.id.fankui){
				Intent intent=new Intent(ContactSolderActivity.this,SuggestActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
			}
		}
		
	}
	
}
