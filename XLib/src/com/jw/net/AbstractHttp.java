package com.jw.net;

import org.json.JSONObject;

import android.text.TextUtils;
import com.android.volley.RequestQueue;

/**
 * 基于volley的http wrapper 
 *
 * @param <T>
 */
public abstract class AbstractHttp<T extends AbstractHttp<T>> {

	public T mSelf;


	private HttpCallBack mCb;

	//cookie pair
	private String mCookieKey;
	private String mCookieValue;

	private String mUrl;

	private JSONObject mPostObject;

	@SuppressWarnings("unchecked")
	public T self() {
		return (T) this;
	}

	public T get(HttpCallBack callback) {
		callback(callback);
		BaseHttpRequst request = new BaseHttpRequst(mUrl, null, mCb, mCb);
		assertCookie(request);
		//执行
		getQueue().add(request);
		return self();
	}

	public T post(HttpCallBack callback) {
		callback(callback);
		BaseHttpRequst request = new BaseHttpRequst(mUrl, mPostObject, mCb, mCb);
		assertCookie(request);
		//执行
		getQueue().add(request);
		return self();
	}
	
	public void assertCookie(BaseHttpRequst request) {
		// set cookie
		if (!TextUtils.isEmpty(getCookieKey())&& !TextUtils.isEmpty(getCookieValue()))
			request.addRequstHeader(getCookieKey(), getCookieValue());
	}

	public T url(String url) {
		mUrl = url;
		return self();
	}
	
	public String getUrl() {
		return mUrl;
	}
	
	public  T  callback(HttpCallBack cb) {
		mCb = cb;
		return self();
	}
	
	public T cookie(String key, String value){
		mCookieKey = key;
		mCookieValue = value;
		return self();
	}

	public String getCookieValue() {
		return mCookieValue;
	}

	public String getCookieKey() {
		return mCookieKey;
	}
	
	/**
	 * 重写这个方法,用来获取Volley的队列
	 * @return
	 */
	public abstract RequestQueue getQueue();
	
//------------Application sample ----------------//
	
//public class TheApplication extends Application{
//	
//	public static TheApplication mInstance;
//	
//	private RequestQueue mQueue;
//	
//	
//	@Override
//	public void onCreate() {
//		super.onCreate();
//		mInstance = this;
//		mQueue = Volley.newRequestQueue(this);
//	}
//	
//	
//	public static synchronized TheApplication getInstance() {
//		return mInstance;
//	}
//	
//	public RequestQueue getQueue() {
//		return mQueue;
//	}
//}
}
