package com.bysx.bbs.commons.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet工具
 * @author yangz
 *
 */
public class ServletUtils {

	/**
	 * 根据方法名去调用方法，注意的是：方法签名必须是 void func(HttpServletRequest req, HttpServletResponse resp)。
	 * @param obj 
	 * @param methodName
	 * @param req
	 * @param resp
	 */
	public static void invoke(Object obj, String methodName,HttpServletRequest req, HttpServletResponse resp) {
		Class<?> clazz = obj.getClass();
		if(methodName!=null && !methodName.trim().equals("")) {
			try {
				Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
				if(method != null) {
					try {
						method.setAccessible(true);
						method.invoke(obj, req, resp);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
	}
}
