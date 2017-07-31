package com.neusoft.bbs.domain;

public class Level {
    private Long levelId;

    private String levelName;

    private Long expValue;

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Long getExpValue() {
        return expValue;
    }

    public void setExpValue(Long expValue) {
        this.expValue = expValue;
    }
}