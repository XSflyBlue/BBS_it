package com.neusoft.bbs.commons.util;
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
	
	public static void main(String[] args) {
		String ss= "<h4>发表新贴子</h4><><><><>";
		System.out.println(htmlspecialchars(ss));
	}
}
