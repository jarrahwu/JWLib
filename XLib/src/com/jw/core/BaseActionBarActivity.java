package com.jw.core;

import com.jw.util.L;

import android.app.ActionBar;
import android.view.View;

public abstract class BaseActionBarActivity extends BaseActivity{
		
	@Override
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		configureActionBar(getActionBar());
	}
	
	@Override
	public void setContentView(View view) {
		super.setContentView(view);
		configureActionBar(getActionBar());
	}

	protected void configureActionBar(ActionBar actionBar) {
		L.red(actionBar);
	}
}
