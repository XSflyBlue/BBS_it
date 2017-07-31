package com.neusoft.bbs.domain;

import java.util.Date;

public class CoinRecord {
    private Long coinRecordId;

    private Long coinId;

    private String coinCause;

    private Long coinGetNum;

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