package com.bysx.bbs.commons.util;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * JSON工具
 * @author yangz
 *
 */
public class JSONUtils {
	
	private static Gson gson;
	static{
		GsonBuilder gsonbuilder = new GsonBuilder().serializeNulls();
		gson = gsonbuilder.create();
	}
	/**
	 * 返回JSON到前台
	 * @param response
	 * @param obj
	 */
	public static void writeJSON(HttpServletResponse response,Object obj) {
		try {
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().append(gson.toJson(obj));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}