package com.neusoft.bbs.domain;

/***
 * （用户）等级类
 * 参考数据
 * @author flyblue
 *
 */
public class Level {
	/***
	 * （用户）等级ID
	 */
    private Long levelId;

    /***
     * 等级名称
     */
    private String levelName;

    /***
     * 经验值
     */
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