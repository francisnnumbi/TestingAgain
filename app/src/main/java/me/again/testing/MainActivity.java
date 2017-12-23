package me.again.testing;

import android.app.*;
import android.os.*;
import android.support.v7.app.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import android.support.v4.view.*;
import fnn.smirl.iconedpopupmenu.*;

public class MainActivity extends AppCompatActivity {
 Button btn;
 
 private GestureDetectorCompat mGDetector;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);
	btn = (Button) findViewById(R.id.mainButton);
	btn.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View p1) {
		  IconedPopupMenu pop = new IconedPopupMenu(MainActivity.this, R.menu.popmenu, p1);
		  pop.setOnMenuItemSelectedListener(new IconedPopupMenu.OnMenuItemSelectedListener(){

			  @Override
			  public void onMenuItemSelected(MenuItem item) {
				toastIt(item.getTitle() + " selected");
			  }
			});
		  }
	  });
	
	  mGDetector = new GestureDetectorCompat(this, new GestureListener());
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
	mGDetector.onTouchEvent(event);
	return super.onTouchEvent(event);
  }
  
  
  
  private void toastIt(String text){
	Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
  }
  
  class GestureListener extends GestureDetector.SimpleOnGestureListener {

	@Override
	public boolean onSingleTapConfirmed(MotionEvent e) {
	  toastIt("tap at ["+(int)e.getX() + ";" + (int)e.getY() + "]");
	  return super.onSingleTapConfirmed(e);
	}
	
  }
}
