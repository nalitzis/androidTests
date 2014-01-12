package com.androidviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class MyListView extends ListView{

	MyAdapter mMyAdapter;
	
	public MyListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mMyAdapter = new MyAdapter(context.getApplicationContext(), R.layout.cell, R.id.mytextView);
		setAdapter(mMyAdapter);
	}
	

}
