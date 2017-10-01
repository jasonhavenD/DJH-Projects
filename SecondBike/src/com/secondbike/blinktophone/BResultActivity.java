package com.secondbike.blinktophone;

import com.secondbike.SecondBike.DengluActivity;
import com.secondbike.SecondBike.R;
import com.secondbike.SecondBike.SysApplication;
import com.secondbike.SecondBike.ZhuceActivity;
import com.secondbike.user.MySQLiteOpenHelper;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BResultActivity extends Activity {
	private TextView result;
	private Button next;
	private ButtonListener buttonListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bresult);
		SysApplication.getInstance().addActivity(this);
		Intent intent = getIntent();
		init();// 初始化

	}

	public void init() {
		next = (Button) findViewById(R.id.next);
		buttonListener = new ButtonListener();
		next.setOnClickListener(buttonListener);
		result = (TextView) findViewById(R.id.result);
		result.setText("绑定成功！");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bresult, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			if (id == R.id.next) {
				Intent intent = new Intent(BResultActivity.this,
						DengluActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//
				startActivity(intent);

			}

		}
	}
}
