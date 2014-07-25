package com.jw.core;

import org.json.JSONArray;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jw.util.JSONUtil;



/**
 * @author jarrahwu
 * 使用复用的适配器
 */
public abstract class BaseJSONAdapter extends BaseAdapter{

	protected Context mContext;

	protected JSONArray mDataSource;

	public BaseJSONAdapter(Context context){
		mContext = context;
	}

	public int getCount() {
		return mDataSource == null ? 0 : mDataSource.length();
	}

	public Object getItem(int position) {

		return position;
	}

	public long getItemId(int position) {

		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		BaseAbslistCell itemView;
		if (convertView == null) {
			itemView = instanceItemView();
		}else {
			itemView = (BaseAbslistCell)convertView;
		}
		//放置数据
		itemView.setData(JSONUtil.getJsonObjByIndex(mDataSource, position), position);
		//设置item
		configureItem(itemView);

		return itemView;
	}


	/**
	 * 配置item 你可以设置每个item的点击事件什么的，都可以
	 * @param itemView
	 */
	public abstract void configureItem(BaseAbslistCell itemView);

	/**
	 * 初始化你的list中每个Item
	 * @return 返回你每个item的实例化的view (这个view要继承BaseDataItemView);
	 */
	public abstract BaseAbslistCell instanceItemView();


	public void setData(JSONArray jsonArray) {
		mDataSource = jsonArray;
		notifyDataSetChanged();
	}

}
