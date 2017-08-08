package com.neusoft.bbs.commons.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 * VO工具
 * @author yangz
 * @version 1.0
 */
public class FormToObjUtils {
	
	private static SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 自动转换前台参数
	 * @param req
	 * @param type
	 * @return
	 */
	public static <T>T parseToObject(HttpServletRequest req, Class<T> type) {
		if(type == null) {
			throw new RuntimeException("空的类型!");
		}
		T t = null;
		try {
			t = type.newInstance();
			Field[] fields = type.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				Method setter = checkSetter(type,field);
				try {
					String value = req.getParameter(field.getName());
					if(value != null) {
						value = value.trim();
					}
					if(value != null && !"".equals(value.trim())) {
						//类型
						if(field.getType()==Integer.class) {
							setter.invoke(t, Integer.parseInt(value));
						}else if(field.getType() == Boolean.class) {
							setter.invoke(t, Boolean.parseBoolean(value));
						}else if(field.getType() == Short.class) {
							setter.invoke(t, Short.parseShort(value));
						}else if(field.getType() == Long.class) {
							setter.invoke(t, Long.parseLong(value));
						}else if(field.getType() == Date.class) {
							try {
								setter.invoke(t, fmt.parse(value));
							} catch (ParseException e) {
								e.printStackTrace();
							}
						}else {
							setter.invoke(t, value);
						}
					}
				} catch (IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	private static Method checkSetter(Class<?> type, Field field) {
		String fieldName = field.getName();
		String setterName = "set"+(fieldName.charAt(0)+"").toUpperCase()+fieldName.substring(1);
		try {
			Method setter = type.getMethod(setterName, field.getType());
			return setter;
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
}