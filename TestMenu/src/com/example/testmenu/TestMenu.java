package com.example.testmenu;

import android.support.v4.app.Fragment;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class TestMenu extends Activity {
	
	private static final String TAG = "TestMenu";
	private Button mButton;
	
	public static final int RED_MENU_ID = Menu.FIRST;
	public static final int GREEN_MENU_ID = Menu.FIRST + 1;
	public static final int BLUE_MENU_ID = Menu.FIRST + 2;
	public TestMenu() { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_menu);

        mButton = (Button) findViewById(R.id.color_button);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(0, RED_MENU_ID, 0, R.string.red);
        menu.add(0, GREEN_MENU_ID, 0, R.string.green);
        menu.add(0, BLUE_MENU_ID, 0, R.string.blue);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        
        switch(item.getItemId()){
        case RED_MENU_ID:
        	mButton.setBackgroundColor(Color.RED);
        	mButton.setText(R.string.red);
        	return true;
        case GREEN_MENU_ID:
        	mButton.setBackgroundColor(Color.GREEN);
        	mButton.setText(R.string.green);
        	return true;
        case BLUE_MENU_ID:
        	mButton.setBackgroundColor(Color.BLUE);
        	mButton.setText(R.string.blue);
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
            View rootView = inflater.inflate(R.layout.fragment_test_menu, container, false);
            return rootView;
        }
    }

}
