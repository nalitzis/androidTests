package com.testcanvas;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Canvas;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TestCanvas extends Activity {

	private Button mButton;
	private CustomView mCanvas, mCanvas2, mCanvas3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_canvas);
		mButton = (Button)findViewById(R.id.button1);
		mCanvas = (CustomView)findViewById(R.id.canvas1);
		mCanvas2 = (CustomView)findViewById(R.id.canvas2);
		mCanvas3 = (CustomView)findViewById(R.id.canvas3);
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startAnimation();
			}
		});
	}
	
	private void startAnimation() {
		//mCanvas.startToTranslate();
		//mCanvas2.startToTranslate();
		mCanvas3.startToTranslate();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test_canvas, menu);
		return true;
	}
	


}
