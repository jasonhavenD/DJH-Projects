package com.example.agricultural;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OnlineTalkActivity extends Activity {
	
	private Button checkoutButton;
	private Button closeButton;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.online_talk);
		
		checkoutButton=(Button)findViewById(R.id.checkout_button);
		closeButton=(Button)findViewById(R.id.close_button);
		
		
		checkoutButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		closeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		
	}

}
