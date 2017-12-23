package fnn.smirl.iconedpopupmenu;

import android.content.*;
import android.support.v7.view.menu.*;
import android.view.*;

public class IconedPopupMenu {
  private OnMenuItemSelectedListener listener;
  
  public IconedPopupMenu(Context context, int menuResId, View anchor) {
	listener = null;
	MenuBuilder builder = new MenuBuilder(context);
	MenuInflater inflater = new MenuInflater(context);
	inflater.inflate(menuResId, builder);
	builder.setCallback(new MenuBuilder.Callback(){

		@Override
		public boolean onMenuItemSelected(MenuBuilder p1, MenuItem p2) {
		  if (listener != null)listener.onMenuItemSelected(p2);
		  return true;
		}

		@Override
		public void onMenuModeChange(MenuBuilder p1) {
		  // TODO: Implement this method
		}
	  });
	MenuPopupHelper helper = new MenuPopupHelper(context,
												 builder, anchor);
	helper.setForceShowIcon(true);

	helper.show();
  }


  public void setOnMenuItemSelectedListener(OnMenuItemSelectedListener listener) {
	this.listener = listener;
  }

  /****** listener of selected menuItem *********/
  public interface OnMenuItemSelectedListener {
	void onMenuItemSelected(MenuItem item);
  }
}
