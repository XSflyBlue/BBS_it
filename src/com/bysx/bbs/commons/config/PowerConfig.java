package com.bysx.bbs.commons.config;
/**
 * 权限配置
 * @author yangz
 *
 */
public class PowerConfig {
	/**
	 * 未验证通过
	 */
	public static final Short NOT_VALID = 0;
	/**
	 * 正常用户
	 */
	public static final Short USER_ON = valueOfPower(Identity.USER, Status.ON);
	/**
	 * 禁用的用户
	 */
	public static final Short USER_OFF = valueOfPower(Identity.USER, Status.OFF);
	/**
	 * 正常的版主
	 */
	public static final Short MODERATOR_ON = valueOfPower(Identity.MODERATOR, Status.ON);
	/**
	 * 取消的版主
	 */
	public static final Short MODERATOR_OFF = valueOfPower(Identity.MODERATOR, Status.OFF);
	/**
	 * 正常的区主
	 */
	public static final Short AREA_ON = valueOfPower(Identity.AREA, Status.ON);
	/**
	 * 取消的区主
	 */
	public static final Short MAREA_OFF = valueOfPower(Identity.AREA, Status.OFF);
	/**
	 * 算出权限值
	 * @param identity
	 * @param status
	 * @return
	 */
	public static short valueOfPower(Identity identity, Status status) {
		short result = (short) (identity.value() + status.value());
		return result;
	}
}
