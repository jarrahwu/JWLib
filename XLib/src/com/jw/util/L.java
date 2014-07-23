package com.jw.util;

import android.util.Log;

public class L {
	
	public static void red(Object obj) {
		Log.e("XLog", obj.toString());
	}
	
	public static void yellow(Object obj) {
		Log.w("XLog", obj.toString());
	}
	
}
