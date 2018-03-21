package com.bysx.bbs.commons.config;
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
		public short value() {
			return 16;
		}
	},
	/**
	 * 版主
	 */
	MODERATOR {
		@Override
		public short value() {
			return 8;
		}
	},
	/**
	 * 普通用户
	 */
	USER {
		@Override
		public short value() {
			return 4;
		}
	};
	
	public abstract short value();
}
