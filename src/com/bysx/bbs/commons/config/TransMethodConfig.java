package com.bysx.bbs.commons.config;
/**
 * 事务方法配置
 * @author yangz
 *
 */

import java.util.ArrayList;
import java.util.List;

public class TransMethodConfig {

	/**
	 * 事务方法集合
	 */
	public static final List<String> TRANS_MEHTODS = new ArrayList<String>();
	
	{
		TRANS_MEHTODS.add("add");
		TRANS_MEHTODS.add("del");
		TRANS_MEHTODS.add("set");
	}
	
	/**
	 * 判断是否符合事务方法
	 * @param methodName
	 * @return 如果符合返回true，否则false
	 */
	public static boolean isTransMethod(String methodName) {
		for(String m: TRANS_MEHTODS) {
			if(methodName.startsWith(m)) {
				return true;
			}
		}
		return false;
	}
}
