package com.neusoft.bbs.domain;

/***
 * 关注好友（用户）类
 * @author flyblue
 *
 */
public class Follow {
	/***
	 * 关注（记录）ID
	 */
    private Long followId;

    /***
     * 用户ID
     */
    private Long userId;

    /***
     * 备注
     */
    private String note;

    /***
     * 关注用户（被关注者）ID
     */
    private Long followUserId;

    public Long getFollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getFollowUserId() {
        return followUserId;
    }

    public void setFollowUserId(Long followUserId) {
        this.followUserId = followUserId;
    }
}