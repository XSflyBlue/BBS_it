package com.neusoft.bbs.commons.config;
/**
 * 状态
 * @author yangz
 *
 */
public enum Status {
	/**
	 * 正常
	 */
	ON {
		@Override
		public int value() {
			return 1;
		}
	},
	/**
	 * 关闭或禁用
	 */
	OFF {
		@Override
		public int value() {
			return 2;
		}
	};
	public abstract int value();
}
