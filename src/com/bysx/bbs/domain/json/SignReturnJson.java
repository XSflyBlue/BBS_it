package com.bysx.bbs.domain.json;

/**
 * 签到结果json返回
 * 
 * @author Tony
 *
 */
public class SignReturnJson {
	/**
	 * 签到结果
	 */
	private String signResult;
	/**
	 * 已签到天数
	 */
	private int singedDays;

	public String getSignResult() {
		return signResult;
	}

	public void setSignResult(String signResult) {
		this.signResult = signResult;
	}

	public int getSingedDays() {
		return singedDays;
	}

	public void setSingedDays(int singedDays) {
		this.singedDays = singedDays;
	}

	@Override
	public String toString() {
		return "SignReturnJson [signResult=" + signResult + ", singedDays=" + singedDays + "]";
	}

}
