package com.example.testmotionevent2;

import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends Activity {
	private static final String TAG = "TestMotionEvent2";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new TestMotionView(this));
	}

	public class TestMotionView extends View {

		private Paint mPaint = new Paint();
		private int mAction;
		private float mX;
		private float mY;

		public TestMotionView(Context context) {
			super(context);

			this.mAction = MotionEvent.ACTION_UP;
			this.mX = 0;
			this.mY = 0;
		}

		@Override
		protected void onDraw(Canvas canvas) {
			Paint paint = this.mPaint;
			canvas.drawColor(Color.WHITE);

			switch (mAction) {
			case MotionEvent.ACTION_MOVE:
				paint.setColor(Color.RED);
				break;
			case MotionEvent.ACTION_UP:
				paint.setColor(Color.GREEN);
				break;
			case MotionEvent.ACTION_DOWN:
				paint.setColor(Color.BLUE);
				break;
			}
			canvas.drawCircle(this.mX, this.mY, 100, paint);
			setTitle("A = " + mAction + " [" + mX + "," + mY + "]");
		}

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			this.mAction = event.getAction();
			this.mX = event.getX();
			this.mY = event.getY();
			Log.v(TAG, "Action=" + this.mAction);
			Log.v(TAG, "(" + this.mX + "," + this.mY + ")");
			invalidate();
			return true;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
