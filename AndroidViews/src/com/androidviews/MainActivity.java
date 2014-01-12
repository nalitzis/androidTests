package com.androidviews;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;

public class MainActivity extends Activity implements ScrollViewListener{

	private static final String TAG = MainActivity.class.getSimpleName();
	
	private Button mListViewButton;
	private MyScrollView mScrollView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mScrollView = (MyScrollView)findViewById(R.id.my_scrollview);
		mScrollView.setScrollViewListener(this);
		mListViewButton = (Button)findViewById(R.id.my_button);
		mListViewButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), ListViewActivity.class));
			}
			
		});
	}

	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}




	@Override
	public void onScrollChanged(ScrollView scrollView, int x, int y, int oldx,
			int oldy) {
		Log.d(TAG, "t, oldt:"+y+","+oldy);
	}

}
