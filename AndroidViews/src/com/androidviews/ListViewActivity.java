package com.androidviews;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class ListViewActivity extends Activity{
	
	private static final String TAG = ListViewActivity.class.getSimpleName();
	public static final long SLEEP_TIME_IN_MS = 1000;
	private MyAdapter mAdapter;
	private MyListView mMyListView;
	private volatile boolean mStopped = true;
	
	private Handler mMainThreadHandler;
	private CellUpdater mCellUpdater;
	private DynamicUpdater mDynamicUpdater;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_layout);
		mMyListView = (MyListView)findViewById(R.id.mylistview);
		mAdapter = (MyAdapter)mMyListView.getAdapter();
		mMainThreadHandler = new Handler(Looper.getMainLooper());
		mCellUpdater = new CellUpdater();
		mDynamicUpdater = new DynamicUpdater();
	}
	
	public void onResume() {
		super.onResume();
		startDynamicUpdater();
	}

	
	private void startDynamicUpdater() {
		mStopped = false;
		Thread t = new Thread(mDynamicUpdater);
		t.start();
	}
	
	private void stopDynamicUpdater() {
		mStopped = true;
	}
	
	public void onPause() {
		super.onPause();
		stopDynamicUpdater();
	} 
	
	
	private class DynamicUpdater implements Runnable {

		
		@Override
		public void run() {
			while(!mStopped) {
				Cell c = createCell();
				postOnAdapter(c);
				try {
					Thread.sleep(SLEEP_TIME_IN_MS);
				} catch (InterruptedException e) {
					mStopped = true;
					Log.d(TAG, "stopped dynamic updater");
				} 
			}
		}
		
	}
	
	/**
	 * post new cell on main thread
	 * @param c
	 */
	private void postOnAdapter(Cell c) {
		mCellUpdater.setCurrentCell(c);
		mMainThreadHandler.post(mCellUpdater);
	}
	
	private class CellUpdater implements Runnable {
		private volatile Cell mCurrentCell = null;
		
		public void setCurrentCell(Cell c) {
			mCurrentCell = c;
		}
		
		@Override
		public void run() {
			mAdapter.add(mCurrentCell);
		}
		
	}
	
	private Cell createCell() {
		Cell c = new Cell(null, "" + (int)(1000.0d * Math.random()));
		return c;
	}
}
