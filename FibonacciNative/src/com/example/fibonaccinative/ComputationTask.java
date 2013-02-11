package com.example.fibonaccinative;

import android.os.AsyncTask;

public class ComputationTask extends AsyncTask<Long, Void, Long> {
	private Task task;
	private ComputationListener listener;
	
	enum Task{
		NATIVE,
		JAVA
	};
	
	ComputationTask(Task task, ComputationListener listener){
		this.task = task;
		this.listener = listener;
	}
	
	@Override
	protected Long doInBackground(Long... arg0) {
		long input = arg0[0];
		long result = 0;
		switch(task){
		case NATIVE:
			result = FibLib.fibNR(input);
			break;
		case JAVA:
			result = FibLib.fibJR(input);
			break;
		}
		return result;
	}
	
	protected void onPostExecute(Long result){
		listener.publishResult(result);
	}

}
