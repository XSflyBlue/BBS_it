package com.neusoft.bbs.domain;

/***
 * 金币类
 * @author flyblue
 *
 */
public class Coin {
	/***
	 * 金币ID
	 */
    private Long coinId;

    /***
     * 用户ID
     */
    private Long userId;

    /***
     * 金币数
     */
    private Long coinNum;

    public Long getCoinId() {
        return coinId;
    }

    public void setCoinId(Long coinId) {
        this.coinId = coinId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCoinNum() {
        return coinNum;
    }

    public void setCoinNum(Long coinNum) {
        this.coinNum = coinNum;
    }
}