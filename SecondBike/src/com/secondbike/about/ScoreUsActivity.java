package com.secondbike.about;

import com.secondbike.SecondBike.R;
import com.secondbike.SecondBike.SysApplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreUsActivity extends Activity {

	private Button cancel, submit;
	private ButtonListener buttonListner;
	private TextView content;
	RatingBar ratingbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.score_us);
		SysApplication.getInstance().addActivity(this);
		Intent intent = getIntent();
		init();
	}

	public void init() {
		cancel = (Button) findViewById(R.id.cancel);
		buttonListner = new ButtonListener();
		cancel.setOnClickListener(buttonListner);
		submit = (Button) findViewById(R.id.submit);
		submit.setOnClickListener(buttonListner);
		content = (TextView) findViewById(R.id.content);
		ratingbar = (RatingBar) findViewById(R.id.ratingBar1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.score_us, menu);
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

	// 按钮监听器
	public class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			if (id == R.id.cancel) {
				ScoreUsActivity.this.finish();
			} else if (id == R.id.submit) {
				String contentString = content.getText().toString();
				float score = ratingbar.getRating();
				if (score == 0) {
					Toast.makeText(ScoreUsActivity.this, "亲，请打分！",
							Toast.LENGTH_SHORT).show();
					return;
				}

				DiagListener diagListener = new DiagListener();
				AlertDialog.Builder builder = new AlertDialog.Builder(
						ScoreUsActivity.this, AlertDialog.THEME_HOLO_LIGHT);
				builder.setTitle("提交结果");
				builder.setMessage("提交成功！");
				builder.setPositiveButton("确定", diagListener);
				AlertDialog dialog = builder.create();
				dialog.show();

			}
		}
	}

	class DiagListener implements
			android.content.DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			ScoreUsActivity.this.finish();
		}

	}
}
