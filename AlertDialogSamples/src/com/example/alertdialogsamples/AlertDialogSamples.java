package com.example.alertdialogsamples;

import android.support.v4.app.Fragment;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.os.Build;

public class AlertDialogSamples extends Activity implements View.OnClickListener {
	Button Button1;
	Button Button2;
	//Button toast;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_samples);

        Button1 = (Button) findViewById(R.id.button1);
        Button1.setOnClickListener(this);
        
        Button2 = (Button) findViewById(R.id.button2);
        Button2.setOnClickListener(this);
    }
    
    public void onClick(View view) {
		if (view == Button1) {
			new AlertDialog.Builder(this)
				.setTitle(R.string.button1String)
				.setPositiveButton(R.string.alert_dialog_ok, new DialogInterface.OnClickListener() {
			    	public void onClick(DialogInterface dialog, int whichButton) {
			    	/* 左键事件 */
			    	}
		    	}).setNegativeButton(R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() {
			    	public void onClick(DialogInterface dialog, int whichButton) {
			    	/* 右键事件 */
			    	}
		    	}).show();
		} else if (view == Button2){
			new AlertDialog.Builder(AlertDialogSamples.this)
				.setTitle(R.string.button2String)
				.setMessage(R.string.button2lLongString)
				.setPositiveButton(R.string.alert_dialog_ok, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
					/* 左键事件 */
					}
				})
				.setNeutralButton(R.string.alert_dialog_close, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
					/* 中键事件 */
					}
				}).setNegativeButton(R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
					/* 右键事件 */
					}
				}).show();
		}
	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.alert_dialog_samples, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_alert_dialog_samples, container, false);
            return rootView;
        }
    }

}
