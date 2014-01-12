package com.example.testautomatedsimple;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText multiply1;
	private EditText multiply2;
	private TextView resultTextView;
	private Button multiply;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		multiply1 = (EditText)findViewById(R.id.multiply1EditText);
		multiply2 = (EditText)findViewById(R.id.multiply2EditText);
		resultTextView = (TextView)findViewById(R.id.resultText);
		multiply = (Button)findViewById(R.id.multiplyButton);
		multiply.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String multiplyString1 = multiply1.getText().toString();
				String multiplyString2 = multiply2.getText().toString();
				int mult1 = Integer.parseInt(multiplyString1);
				int mult2 = Integer.parseInt(multiplyString2);
				int result = mult1 * mult2;
				resultTextView.setText("" + result);
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
