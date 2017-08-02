package com.neusoft.bbs.domain.form;

public class FollowForm {
	/***
	 * 关注（记录）ID
	 */
    private Long followId;

    /***
     * 用户ID
     */
    private Long userId;
    
    /***
     * 用户名
     */
    private String username;

    /***
     * 备注
     */
    private String note;
    
    /***
     * 头像（路径）
     */
    private String icon;

    /***
     * 关注用户（被关注者）ID
     */
    private Long followUserId;
    
    /***
     * 被关注用户名
     */
    private String followUsername;
    
    /***
     * 行数
     */
    private String rn;

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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long getFollowUserId() {
		return followUserId;
	}

	public void setFollowUserId(Long followUserId) {
		this.followUserId = followUserId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFollowUsername() {
		return followUsername;
	}

	public void setFollowUsername(String followUsername) {
		this.followUsername = followUsername;
	}

	@Override
	public String toString() {
		return "FollowForm [followId=" + followId + ", userId=" + userId + ", username=" + username + ", note=" + note
				+ ", icon=" + icon + ", followUserId=" + followUserId + ", followUsername=" + followUsername + "]";
	}

	public String getRn() {
		return rn;
	}

	public void setRn(String rn) {
		this.rn = rn;
	}
	
}
