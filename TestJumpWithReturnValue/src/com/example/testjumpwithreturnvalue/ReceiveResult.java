package com.example.testjumpwithreturnvalue;

import android.support.v4.app.Fragment;
import android.text.Editable;
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
import android.widget.TextView;
import android.os.Build;

public class ReceiveResult extends Activity {

	static final private int GET_CODE = 0;
	private TextView mResults;
	
	private OnClickListener mGetListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(ReceiveResult.this, SendResult.class);
			startActivityForResult(intent, GET_CODE);
		}
	};
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == GET_CODE) {
			Editable text = (Editable)mResults.getText();
			if (resultCode == RESULT_CANCELED) {
				text.append("(cancelled)");
			} else {
				text.append("(okay ");
				text.append(Integer.toString(resultCode));
				text.append(") ");
				if (intent != null) {
					text.append(intent.getAction());
				}
				text.append("\n");
			}
		}
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receive_result);
        
        // Retrieve the TextView widget that will display results.  
        mResults = (TextView)findViewById(R.id.results);  
  
        // This allows us to later extend the text buffer.  
        mResults.setText(mResults.getText(), TextView.BufferType.EDITABLE); 

        final Button mButton1 = (Button) findViewById(R.id.get);
		mButton1.setOnClickListener(mGetListener); // 设置监听者的类
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.receive_result, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_receive_result, container, false);
            return rootView;
        }
    }

}
