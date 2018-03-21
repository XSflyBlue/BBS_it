package com.bysx.bbs.domain;

/***
 * 经验类
 * @author flyblue
 *
 */
public class EXP {
	/***
	 * 经验ID
	 */
    private Long expId;

    /***
     * 用户ID
     */
    private Long userId;

    /***
     * 经验数
     */
    private Long expNum;

    /***
     * 等级ID
     */
    private Long levelId;

    public Long getExpId() {
        return expId;
    }

    public void setExpId(Long expId) {
        this.expId = expId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getExpNum() {
        return expNum;
    }

    public void setExpNum(Long expNum) {
        this.expNum = expNum;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }
}