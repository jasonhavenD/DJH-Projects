package com.example.agricultural;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class LoginActivity extends Activity {

	private Button loginButton;
	private RadioGroup userTypeRadioGroup;
	private EditText userEditText;
	private EditText passwordEditText;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        AgriApplication.getInstance().setUserType(AgriApplication.USER_TYPE_NORMAL);
        loginButton = (Button)findViewById(R.id.login_button);
        userTypeRadioGroup = (RadioGroup)findViewById(R.id.usertype_rg);
        userEditText = (EditText)findViewById(R.id.user_edit);
        passwordEditText = (EditText)findViewById(R.id.password_edit);
        
        loginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(userEditText.getText().length()==0){
					Toast.makeText(getApplicationContext(), R.string.user_empty_text, Toast.LENGTH_LONG).show();
					return;
				}else if(passwordEditText.getText().length()==0){
					Toast.makeText(getApplicationContext(),R.string.pwd_empty_text, Toast.LENGTH_LONG).show();
					return;
				}else{
					
					Intent intents = new Intent();
					intents.setClass(LoginActivity.this, StationListActivity.class);
					startActivity(intents);
					finish();
				}
				
			}
		});
        
        userTypeRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				int radioButtonId = group.getCheckedRadioButtonId();
				
				if(radioButtonId == R.id.doctor){
					AgriApplication.getInstance().setUserType(AgriApplication.USER_TYPE_DOCTOR);
					Log.e("walle","radioButtonId:doctor");
				}else if(radioButtonId == R.id.normal){
					AgriApplication.getInstance().setUserType(AgriApplication.USER_TYPE_NORMAL);
					Log.e("walle","radioButtonId:normal");
				}
				
				
			}
		});
    }
}
