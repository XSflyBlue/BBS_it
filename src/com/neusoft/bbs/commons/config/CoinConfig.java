package com.neusoft.bbs.commons.config;

/**
 * 金币配置类
 * 
 * @author yangz
 *
 */
public class CoinConfig {
	/**
	 * 类型：签到
	 */
	public final static Long TYPE_SIGNED = 1L;

	/**
	 * 类型：回复
	 */
	public final static Long TYPE_REPLY = 2L;

	/**
	 * 根据类型获取金币数
	 * 
	 * @param type
	 * @return
	 */
	public static Long valueOfCoinType(Long type) {
		if(type == TYPE_SIGNED) {
			return 10L;
		}else if(type == TYPE_REPLY) {
			return 20L;
		}
		return 0L;
	}
}
