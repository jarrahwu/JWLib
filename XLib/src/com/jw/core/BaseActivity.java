package com.jw.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.androidquery.AQuery;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * @author JarrahWu
 */
public abstract class BaseActivity extends Activity {

	protected AQuery mAq;

	/**
	 * 当调用setContentView(title , contentView) 的时候,
	 * 这个就是这两个子View 的父容器
	 */
	protected LinearLayout mViewContainer;

	protected LayoutInflater mInflater;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mAq = new AQuery(this);
		setupViews();
	}

	protected abstract void setupViews();

	protected void requestNoTitle() {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	}
	/**
	 * 
	 * @param v
	 * @param methodName
	 */
	protected void bindClickEvent(final View v, final String methodName) {
		v.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				try {
					Method method = BaseActivity.this.getClass().getMethod(
							methodName, new java.lang.Class[] { View.class });
					method.invoke(BaseActivity.this, v);
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}

			}
		});
	}

	protected void showToast(String text) {
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onDestroy() {
		mAq.ajaxCancel();
		super.onDestroy();
	}


	protected void initInflater() {
		if (mInflater == null)
			mInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	}

	public LayoutInflater getLayoutInflater() {
		if (mInflater == null) {
			initInflater();
		}
		return mInflater;
	}

	/**
	 * 查找fragment 并返回对应的类型
	 * 
	 * @param id
	 * @param claz
	 * @return
	 */
	public <T extends Fragment> T findFragmentBy(int id, Class<T> claz) {
		@SuppressWarnings("unchecked")
		T t = (T) getFragmentManager().findFragmentById(id);
		return t;
	}

	/**
	 * Activity跳转
	 * 
	 * @param cls
	 */
	public void skipTo(Class<?> cls) {
		Intent i = new Intent();
		i.setClass(this, cls);
		startActivity(i);
	}

	protected View findView(int id) {
		View v = null;
		v = findViewById(id);
		if (v == null) {
			Log.e("can not find view id", "~~~~~~~");
		}
		return v;
	}

	@SuppressWarnings("unchecked")
	public <T extends View> T findView(int view_id, Class<T> clz) {
		return (T) findView(view_id);
	}

	protected void setAppBackground(int res) {
		mViewContainer.setBackgroundResource(res);
	}

	public void gone(View v) {
		v.setVisibility(View.GONE);
	}

	public void visible(View v) {
		v.setVisibility(View.VISIBLE);
	}

	public void invisible(View v) {
		v.setVisibility(View.INVISIBLE);
	}

	public void gone(int id) {
		findView(id).setVisibility(View.GONE);
	}

	public void visible(int id) {
		findView(id).setVisibility(View.VISIBLE);
	}

	public void invisible(int id) {
		findView(id).setVisibility(View.INVISIBLE);
	}

}
