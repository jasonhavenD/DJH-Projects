package com.secondbike.SecondBike;

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class GuacheActivity extends Activity {

	private Button cancel, submit;
	private ButtonListener buttonListner;
	private EditText name, price, rent, color, QQ, contact, address, moto;
	private ImageView loadimage;
	private ImageListener imageListener;
	private final int REQUSET = 0;
	public final static  String EXPRESSION="expression";
	private static final int PHOTO_REQUEST_CAREMA = 1;// 拍照
	private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
	private static final int PHOTO_REQUEST_CUT = 3;// 结果
	private static final String PHOTO_FILE_NAME = "temp_photo.jpg";
    private File tempFile;
	// private PopupMenu popupMenu;
	// private PopupMenuListener popupmenuListener;
	// private Button popbtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guache);
		SysApplication.getInstance().addActivity(this);
		Intent i = getIntent();
		init();// 初始化
	}

	public void init() {
		cancel = (Button) findViewById(R.id.cancel);
		buttonListner = new ButtonListener();
		submit = (Button) findViewById(R.id.submit);
		submit.setOnClickListener(buttonListner);
		cancel.setOnClickListener(buttonListner);
		//
		name = (EditText) findViewById(R.id.name);
		price = (EditText) findViewById(R.id.price);
		rent = (EditText) findViewById(R.id.rent);
		color = (EditText) findViewById(R.id.color);
		QQ = (EditText) findViewById(R.id.QQ);
		contact = (EditText) findViewById(R.id.contact);
		address = (EditText) findViewById(R.id.address);
		moto = (EditText) findViewById(R.id.moto);
		loadimage = (ImageView) findViewById(R.id.loadimage);
		imageListener = new ImageListener();
		loadimage.setOnClickListener(imageListener);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_MENU){
			return true;
		}else if(keyCode==KeyEvent.KEYCODE_BACK){
			return true;
		}
		return false;
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.guache, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.photo) {
			// Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			// startActivityForResult(intent, PHOTO_REQUEST_CAREMA);
			// 激活相机
			Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
			// 判断存储卡是否可以用，可用进行存储
			if (hasSdcard()) {
				tempFile = new File(Environment.getExternalStorageDirectory(),
						PHOTO_FILE_NAME);
				// 从文件中创建uri
				Uri uri = Uri.fromFile(tempFile);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
			}
			// 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CAREMA
			startActivityForResult(intent, PHOTO_REQUEST_CAREMA);

			return true;
		} else if (id == R.id.local) {
			// 激活系统图库，选择一张图片
			Intent intent = new Intent(Intent.ACTION_PICK);
			intent.setType("image/*");
			// 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_GALLERY
			startActivityForResult(intent, PHOTO_REQUEST_GALLERY);

			return true;
		} else if (id == R.id.quxiao) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/*
     * 剪切图片
     */
    private void crop(Uri uri) {
        // 裁剪图片意图
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // 裁剪框的比例，1：1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);

        intent.putExtra("outputFormat", "JPEG");// 图片格式
        intent.putExtra("noFaceDetection", true);// 取消人脸识别
        intent.putExtra("return-data", true);
        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CUT
        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }

    /*
     * 判断sdcard是否被挂载
     */
    private boolean hasSdcard() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PHOTO_REQUEST_GALLERY) {
            // 从相册返回的数据
            if (data != null) {
                // 得到图片的全路径
                Uri uri = data.getData();
                crop(uri);
            }

        } else if (requestCode == PHOTO_REQUEST_CAREMA) {
        	if(resultCode==RESULT_OK)
            // 从相机返回的数据
            if (hasSdcard()) {
                crop(Uri.fromFile(tempFile));
            } else {
                Toast.makeText(GuacheActivity.this, "未找到存储卡，无法存储照片！", 0).show();
            }

        } else if (requestCode == PHOTO_REQUEST_CUT) {
            // 从剪切图片返回的数据
            if (data != null) {
//                Bitmap bitmap = data.getParcelableExtra("data");
//                this.iv_image.setImageBitmap(bitmap);
            	Bitmap bmPhoto = (Bitmap) data.getExtras().get("data");
				ImageView imageView = new ImageView(this);
				imageView.setImageBitmap(bmPhoto);
				Display display = getWindowManager().getDefaultDisplay();
				int width = display.getWidth();
				LinearLayout.LayoutParams PARA = new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.WRAP_CONTENT,
						LinearLayout.LayoutParams.WRAP_CONTENT);
				imageView.setLayoutParams(PARA);
				imageView.setAdjustViewBounds(true);
				imageView.setMaxWidth(width * 3);
				imageView.setMaxHeight(width * 2);
				GridLayout layout = (GridLayout) findViewById(R.id.gridlayout);
				layout.addView(imageView);
            }
            try {
                // 将临时文件删除
                tempFile.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        super.onActivityResult(requestCode, resultCode, data);
    }

	// 按钮监听器
	class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			if (id == R.id.cancel) {
				GuacheActivity.this.finish();
			} else if (id == R.id.submit) {
				String nameString = name.getText().toString();
				String priceString = price.getText().toString();
				String contactString = contact.getText().toString();
				if (nameString.length() == 0 || priceString.length() == 0
						|| contactString.length() == 0) {
					DiagListener diagListener = new DiagListener();
					AlertDialog.Builder builder = new AlertDialog.Builder(
							GuacheActivity.this, AlertDialog.THEME_HOLO_LIGHT);
					builder.setTitle("我要挂车");
					builder.setMessage("必填项不能缺省！");
					builder.setNegativeButton("确定", diagListener);
					AlertDialog dialog = builder.create();
					dialog.show();
					return;
				}

				// 提交成功
				DiagListener diagListener = new DiagListener();
				AlertDialog.Builder builder = new AlertDialog.Builder(
						GuacheActivity.this, AlertDialog.THEME_HOLO_LIGHT);
				builder.setTitle("提交结果");
				builder.setMessage("提交成功！");
				builder.setPositiveButton("确定", diagListener);
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		}
	}
	
	class ImageListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// 弹出菜单
			GuacheActivity.this.openOptionsMenu();
		}

	}

	class DiagListener implements
			android.content.DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			if (which == AlertDialog.BUTTON_POSITIVE) {
				GuacheActivity.this.finish();
			}
		}
	}
}
