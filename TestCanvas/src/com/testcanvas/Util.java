package com.testcanvas;

import android.content.Context;
import android.util.DisplayMetrics;

public class Util {

	private final DisplayMetrics metrics;
	
	
	public Util(Context context) {
		metrics = context.getResources().getDisplayMetrics();
	}
	
	public int pxToDp(int px) {
	    int dp = (int) ((px/metrics.density)+0.5);
	    return dp;
	}
	
	public int dpToPx(int dp) {
		return (int)((dp * metrics.density) + 0.5);
	}
}
