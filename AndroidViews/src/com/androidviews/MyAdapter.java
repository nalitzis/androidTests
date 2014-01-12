package com.androidviews;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<Cell>{

	private Context mContext;
	private LayoutInflater mInflater;
	

	
	public MyAdapter(Context context, int resource, int textViewResourceId) {
		super(context, resource, textViewResourceId);
		mContext = context;
		mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	
	public View getView (int position, View convertView, ViewGroup parent) {
		if(convertView == null) {
			convertView = mInflater.inflate(R.layout.cell, null);
		}
		cellSetup(position, convertView);
		return convertView;
	}
	
	
	private void cellSetup(int position, View convertView) {
		TextView tv = (TextView)convertView.findViewById(R.id.mytextView);
		ImageView imgView = (ImageView)convertView.findViewById(R.id.myimageview);
		Cell cell = getItem(position);
		tv.setText(cell.getText());
		imgView.setImageResource(R.drawable.ic_launcher);
	}

}
