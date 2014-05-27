package com.example.testjumpwithreturnvalue;

import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class SendResult extends Activity {

	private OnClickListener mCorkyListener = new OnClickListener() {
		public void onClick(View v) {
			setResult(RESULT_OK, (new Intent()).setAction("Corky!"));
			finish();
		}
	};
	private OnClickListener mVioletListener = new OnClickListener() {
		public void onClick(View v) {
			setResult(RESULT_OK, (new Intent()).setAction("Violet!"));
			finish();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send_result);

		final Button mButton1 = (Button) findViewById(R.id.button1);
		final Button mButton2 = (Button) findViewById(R.id.button2);
		mButton1.setOnClickListener(mCorkyListener); // 设置监听者的类
		mButton2.setOnClickListener(mVioletListener); // 设置监听者的类
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.send_result, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_send_result,
					container, false);
			return rootView;
		}
	}

}
