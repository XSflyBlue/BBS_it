package com.bysx.bbs.domain;

import java.util.Date;

/***
 * 金币记录类
 * @author flyblue
 *
 */
public class CoinRecord {
	/***
	 * 金币记录ID
	 */
    private Long coinRecordId;

    /***
     * 金币ID
     */
    private Long coinId;

    /***
     * 获取原因
     */
    private String coinCause;

    /***
     * 获取金币数
     */
    private Long coinGetNum;

    /***
     * 获取时间
     */
    private Date coinGetTime;

    public Long getCoinRecordId() {
        return coinRecordId;
    }

    public void setCoinRecordId(Long coinRecordId) {
        this.coinRecordId = coinRecordId;
    }

    public Long getCoinId() {
        return coinId;
    }

    public void setCoinId(Long coinId) {
        this.coinId = coinId;
    }

    public String getCoinCause() {
        return coinCause;
    }

    public void setCoinCause(String coinCause) {
        this.coinCause = coinCause;
    }

    public Long getCoinGetNum() {
        return coinGetNum;
    }

    public void setCoinGetNum(Long coinGetNum) {
        this.coinGetNum = coinGetNum;
    }

    public Date getCoinGetTime() {
        return coinGetTime;
    }

    public void setCoinGetTime(Date coinGetTime) {
        this.coinGetTime = coinGetTime;
    }
}