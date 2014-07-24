package com.jw.json;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * jackson 的用法
 * 
 * bean 的声明：
 * 1.如果bean里面没有 @JsonIgnoreProperties(ignoreUnknown=true) 那么bean里面声明的变量都会被读取
 * 但是如果json数据的数量比变量数要多的话，就会报错。声明这个注解可以避免一些没有声明到出错的情况
 * 2.如果不想读取某些json对应的值 可以使用@JsonIgnoreProperties({"key_a","key_b"})
 * 3. JSONObject 对应 LinkedHashMap<String,Object> 
 * 	  array		 对应 ArrayList<Object> 或者 ArrayList<T> T 为bean里面的匿名类 就是 static class，匿名类也要进行属性解析，声明变量
 * 	  JSON null  对应 java null
 */
@JsonIgnoreProperties({"a","b"})
public class JacksonUsage {
	
}
