package com.bysx.bbs.commons.util;

import java.util.Random;

/**
 * 密码工具
 * @author yangz
 *
 */
public class PasswordUtils {
	
	private static Random random;
	
	static{
		random = new Random();
	}

	/**
	 * 创建指定长度的随机数字密码
	 * @param len
	 * @return
	 */
	public static String createRandomNumPwd(int len) {
		String ret = "";
		for (int i = 0; i < len; i++) {
			ret += random.nextInt(10);
		}
		return ret;
	}
}
