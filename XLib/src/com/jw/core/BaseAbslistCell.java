package com.jw.core;

import org.json.JSONObject;

import android.content.Context;
import android.util.AttributeSet;


/**
 * @author JarrahWu
 * listView 的 每个 item 的基类
 */
public abstract class BaseAbslistCell extends BaseView{

	protected JSONObject mData;

	protected int mPosition;

	public BaseAbslistCell(Context context) {
		super(context);
	}

	public BaseAbslistCell(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	/**
	 * 设置数据
	 * @param data
	 * @param position
	 */
	public void setData(JSONObject data, int position) {
		mData = data;
		mPosition = position;
		onDispatchData(data);
	}

	public int getPosition() {
		// TODO Auto-generated method stub
		return mPosition;
	}

	public JSONObject getData() {
		return mData;
	}

	/**
	 * 分配数据
	 * @param data
	 */
	public abstract void onDispatchData(JSONObject data);

}
