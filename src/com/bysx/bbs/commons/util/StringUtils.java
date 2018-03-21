package com.bysx.bbs.commons.util;
/**
 * 字符串转换工具
 * @author yangz
 *
 */
public class StringUtils {

	/**
	 * DB字段转Java驼峰命名
	 * @param name1
	 * @return
	 */
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
	/**
	 * html特殊字符串还原
	 * @param str
	 * @return
	 */
	public static String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
	/**
	 * 判断字符串是否不为空
	 * @param strings
	 * @return 不为空返回true，否则false
	 */
	public static boolean isNotNullString(String ...strings) {
		for(String str: strings) {
			if(str == null || str.trim().equals("")) {
				return false;
			}
		}
		return true;
	}
}
