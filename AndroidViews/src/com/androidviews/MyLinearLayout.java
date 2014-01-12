package com.androidviews;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class MyLinearLayout extends LinearLayout {

	private static final String TAG = MyLinearLayout.class.getSimpleName();

	
	private View firstView;
	private View secondView;
	
	
	public MyLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		
	}
	
	public void onFinishInflate() {
		super.onFinishInflate();
		firstView = findViewById(R.id.first_view);
		secondView = findViewById(R.id.second_view);
	}
	
	//NOT CALLED
//	public void onScrollChanged(int l, int t, int oldl, int oldt) {
//		super.onScrollChanged(l, t, oldl, oldt);
//		Log.d(TAG, "t, oldt:"+t+","+oldt);
//	}
//	
//	
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int measureSizeWidth = MeasureSpec.getSize(widthMeasureSpec);
		int measureSizeHeight = MeasureSpec.getSize(heightMeasureSpec);
		Log.d(TAG,  "container w,h: "+measureSizeWidth+", "+measureSizeHeight);
		
		int firstH = firstView.getMeasuredHeight();
		int secondH = secondView.getMeasuredHeight();
		
		Log.d(TAG, "first h: "+firstH+", second H: "+secondH);
		
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		
	}

}
