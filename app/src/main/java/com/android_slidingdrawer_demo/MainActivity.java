package com.android_slidingdrawer_demo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity implements OnClickListener {
	private static Button slideButton, b1, b2, b3;
	private static TextView textView;
	private static SlidingDrawer slidingDrawer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		slideButton = (Button) findViewById(R.id.slideButton);
		slidingDrawer = (SlidingDrawer) findViewById(R.id.SlidingDrawer);
		b1 = (Button) findViewById(R.id.Button01);
		b2 = (Button) findViewById(R.id.Button02);
		b3 = (Button) findViewById(R.id.Button03);
		textView = (TextView) findViewById(R.id.text);

		// Setting Listeners to all buttons and textview
		setListeners();

		// Listeners for sliding drawer
		slidingDrawer.setOnDrawerOpenListener(new OnDrawerOpenListener() {
			@Override
			public void onDrawerOpened() {

				// Change button text when slider is open
				slideButton.setText("Close");
			}
		});

		slidingDrawer.setOnDrawerCloseListener(new OnDrawerCloseListener() {
			@Override
			public void onDrawerClosed() {

				// Change button text when slider is close
				slideButton.setText("Open");
			}
		});
	}

	// Listeners method
	void setListeners() {
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		textView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		// Toast shown on sliding drawer items click
		if (v.getId() == R.id.text) {
			Toast.makeText(MainActivity.this, textView.getText() + " Clicked",
					Toast.LENGTH_SHORT).show();
		} else {
			Button b = (Button) v;
			Toast.makeText(MainActivity.this, b.getText() + " Clicked",
					Toast.LENGTH_SHORT).show();
		}
	}
}
