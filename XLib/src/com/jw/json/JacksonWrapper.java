package com.jw.json;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;


public class JacksonWrapper {
	
	/**
	 * 读取jsonobject 数据 然后转换为对象处理
	 * @param obj json对象
	 * @param valueType 保存的对象类型
	 * @return
	 */
	public static <T> T fromJSONObject(JSONObject obj, Class<T> valueType) {
		ObjectMapper objectMapper = new ObjectMapper();
		T ret = null;
		try {
			ret = objectMapper.readValue(obj.toString(), valueType);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	/**
	 * 读取json 文件 然后转换为对象处理
	 * @param file json文件
	 * @param valueType 保存的对象类型
	 * @return
	 */
	public static <T> T fromJSONFile(File file, Class<T> valueType) {
		ObjectMapper objectMapper = new ObjectMapper();
		T ret = null;
		try {
			ret = objectMapper.readValue(file, valueType);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
}
