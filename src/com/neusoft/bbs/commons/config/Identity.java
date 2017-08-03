package com.neusoft.bbs.commons.config;
/**
 * 身份
 * @author yangz
 *
 */
public enum Identity {
	/**
	 * 区主
	 */
	AREA {
		@Override
		public int value() {
			return 16;
		}
	},
	/**
	 * 版主
	 */
	MODERATOR {
		@Override
		public int value() {
			return 8;
		}
	},
	/**
	 * 普通用户
	 */
	USER {
		@Override
		public int value() {
			return 4;
		}
	};
	
	public abstract int value();
}
