package com.neusoft.bbs.commons.util;
/**
 * 字符串转换工具
 * @author yangz
 *
 */
public class StringUtils {

	public static String dbFieldToJava(String name1) {
		name1 = name1.toLowerCase();
		StringBuilder builder = new StringBuilder();
		if(name1.contains("_")) {
			String arr[] = name1.split("_");
			for (int i = 0; i < arr.length; i++) {
				if(i > 0) {
					arr[i] = (arr[i].charAt(0)+"").toUpperCase()+arr[i].substring(1);
				}
				builder.append(arr[i]);
			}
			return builder.toString();
		}
		return name1;
	}
}
