package com.testcanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class CustomView extends LinearLayout {

	private volatile int translateY = 0;
	
	private static final String TAG = "CustomView";
	
	private Util util;

	private Handler mHandler = new Handler();
	private static final int TIMES = 25 * 5;

	private final long interval = 1000l / 25l; // 40msec, 25fps

	public CustomView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CustomView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		util = new Util(context);
		space = util.dpToPx(50);
		marginX = util.dpToPx(10);
		paint.setColor(Color.WHITE);
		paint.setStyle(Style.FILL);
		//paint.setTextAlign(Align.);
		paint.setTextSize(util.dpToPx(32));
		// inflate(context, R.layout.custom_view, null);
	}
	
	
	
	private final Paint paint = new Paint();

	private final int space;
	private final int marginX;
	
	private final Rect r = new Rect();
	
	
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		int top = ((View)getParent()).getTop();
		//this.getGlobalVisibleRect(r);
		
		
		int topDp = util.pxToDp(top);
		Log.d(TAG, ""+topDp);
		int bottomDp = util.pxToDp(this.getBottom());
		Log.d(TAG, ""+bottomDp);
		canvas.drawColor(Color.BLACK);
		canvas.translate(0, translateY);
		canvas.drawText("0", marginX, topDp+ 0, paint);
		canvas.drawText("1", marginX, topDp+ space, paint);
		canvas.drawText("2", marginX, topDp+ space*2, paint);
		canvas.drawText("3", marginX, topDp+ space*3, paint);
		canvas.drawText("4", marginX, topDp+ space*4, paint);
		canvas.drawText("5", marginX, topDp+ space*5, paint);
		canvas.drawText("6", marginX, topDp+ space*6, paint);
		canvas.drawText("7", marginX, topDp+ space*7, paint);
		canvas.drawText("8", marginX, topDp+ space*8, paint);
		canvas.drawText("9", marginX, topDp+ space*9, paint);
		
		

	}

	private volatile int times = 0;

	public void startToTranslate() {
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				if(times < TIMES) {
					translateY -= util.dpToPx(5);
					
					invalidate();
					times++;
					mHandler.postDelayed(this, interval);
				}
			}

		}, interval);
	}
	
	
}
