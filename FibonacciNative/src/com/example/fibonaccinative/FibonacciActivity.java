package com.example.fibonaccinative;

import com.example.fibonaccinative.ComputationTask.Task;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class FibonacciActivity extends Activity implements ComputationListener{

	private EditText inputNumber;
	private TextView resultMsec;
	private TextView result;
	private long start;
	private ProgressDialog dialog;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);
        this.inputNumber = (EditText)this.findViewById(R.id.editText1);
        this.resultMsec = (TextView)this.findViewById(R.id.textView3);
        this.result = (TextView)this.findViewById(R.id.TextView02);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_fibonacci, menu);
        return true;
    }

    
    public void javaTapped(View view){
    	long number = Long.parseLong(inputNumber.getText().toString());
    	start = System.currentTimeMillis();
    	
    	ComputationTask computationTask = new ComputationTask(Task.JAVA, this);
    	computationTask.execute(number);
    	dialog = showWaitDialog();
    }
    
    public void nativeTapped(View view){
    	long number = Long.parseLong(inputNumber.getText().toString());
    	start = System.currentTimeMillis();
    	
    	ComputationTask computationTask = new ComputationTask(Task.NATIVE, this);
    	computationTask.execute(number);
    	dialog = showWaitDialog();
    }
    
    
    private ProgressDialog showWaitDialog(){
    	ProgressDialog dialog = ProgressDialog.show(this, "","Please wait...", true);
    	return dialog;
    }

	public void publishResult(long result) {
		long end = System.currentTimeMillis();
		assignResult(end - start, result);
		dismissWaitDialog();
		dismissKeyboard();
	}
	
	private void assignResult(long timeElapsedInMsec, long computationResult){
    	resultMsec.setText(""+timeElapsedInMsec+" msec");
    	result.setText(""+computationResult);
    }
    
	private void dismissWaitDialog(){
		dialog.dismiss();
	}
	
    private void dismissKeyboard(){
    	InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
    	imm.hideSoftInputFromWindow(inputNumber.getWindowToken(), 0);
    }
}
