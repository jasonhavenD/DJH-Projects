package com.example.agricultural;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WaitAndInfoActivity extends Activity {

	private ImageView backImageView;
	private TextView waitTitleText;
	private TextView waitTitleIconText;
	private Button expressButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.waitandinfo);

		backImageView = (ImageView) findViewById(R.id.wait_back_icon);
		waitTitleText = (TextView) findViewById(R.id.wait_title_text);
		waitTitleIconText = (TextView) findViewById(R.id.wait_icon_text);
		expressButton = (Button) findViewById(R.id.wait_express_button);

		backImageView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		waitTitleText.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		waitTitleIconText.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		expressButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intents = new Intent();
				intents.setClass(WaitAndInfoActivity.this, OnlineTalkActivity.class);
				startActivity(intents);
				finish();
			}
		});
		
		
	}

}
