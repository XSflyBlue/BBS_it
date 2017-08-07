package com.neusoft.bbs.domain.form;

import java.util.Date;

/**
 * 帖子表单类
 * 
 * @author yangmiao
 *
 */
public class PostForm {

	/***
	 * 帖子ID
	 */
	private Long postId;

	/***
	 * 用户ID
	 */
	private Long userId;

	/***
	 * 板块ID
	 * 
	 */
	private Long sectionId;

	/***
	 * 帖子类型
	 * 
	 */
	private Short postType;

	/***
	 * 主题内容
	 */
	private String themeContent;

	/***
	 * 发布时间
	 */
	private Date issueTime;

	/***
	 * 发布IP
	 */
	private String issueIp;

	/***
	 * 阅读次数
	 */
	private Long hitNum;

	/***
	 * 回复总数
	 */
	private Long answerSum;

	/***
	 * 是否高亮显示
	 */
	private Short isHighlight;

	/***
	 * 高亮操作的用户ID（包含取消）
	 */
	private Long highlightUserId;

	/***
	 * 标题颜色
	 */
	private String titleColor;

	/***
	 * 是否置顶
	 */
	private Short isOverhead;

	/***
	 * 置顶操作的用户ID（包含取消）
	 */
	private Long overheadUserId;

	/***
	 * 置顶操作的原因
	 */
	private String overheadCause;

	/***
	 * （帖子）是否关闭
	 */
	private Short isClose;

	/***
	 * 关闭帖子的用户ID（包含取消）
	 */
	private Long switchUserId;

	/***
	 * 关闭帖子的原因
	 */
	private String switchCause;

	/***
	 * （帖子）是否精华
	 */
	private Short isElite;

	/***
	 * 推荐（帖子）用户ID（包含取消精华）
	 */
	private Long recomUserId;

	/***
	 * 推荐（帖子）为精华的有效期
	 */
	private Date recomValidity;

	/***
	 * （帖子）是否隐藏
	 */
	private Short isHidden;

	/***
	 * （帖子）隐藏原因
	 */
	private String hiddenCause;

	/***
	 * 隐藏（帖子的）用户ID
	 */
	private Long hiddenUserId;

	/***
	 * 是否有附件
	 */
	private Short isAccessory;

	/***
	 * 编辑（帖子的）用户ID
	 */
	private Long editUserId;

	/***
	 * 编辑（帖子的）时间
	 */
	private Date editTime;

	/***
	 * 帖子标题
	 */
	private String postTitle;

	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 分页数
	 */
	private Long rn;
	
	/**
	 * 跟帖数
	 */
	private String commentNum;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getRn() {
		return rn;
	}

	public void setRn(Long rn) {
		this.rn = rn;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public Short getPostType() {
		return postType;
	}

	public void setPostType(Short postType) {
		this.postType = postType;
	}

	public String getThemeContent() {
		return themeContent;
	}

	public void setThemeContent(String themeContent) {
		this.themeContent = themeContent;
	}

	public Date getIssueTime() {
		return issueTime;
	}

	public void setIssueTime(Date issueTime) {
		this.issueTime = issueTime;
	}

	public String getIssueIp() {
		return issueIp;
	}

	public void setIssueIp(String issueIp) {
		this.issueIp = issueIp;
	}

	public Long getHitNum() {
		return hitNum;
	}

	public void setHitNum(Long hitNum) {
		this.hitNum = hitNum;
	}

	public Long getAnswerSum() {
		return answerSum;
	}

	public void setAnswerSum(Long answerSum) {
		this.answerSum = answerSum;
	}

	public Short getIsHighlight() {
		return isHighlight;
	}

	public void setIsHighlight(Short isHighlight) {
		this.isHighlight = isHighlight;
	}

	public Long getHighlightUserId() {
		return highlightUserId;
	}

	public void setHighlightUserId(Long highlightUserId) {
		this.highlightUserId = highlightUserId;
	}

	public String getTitleColor() {
		return titleColor;
	}

	public void setTitleColor(String titleColor) {
		this.titleColor = titleColor;
	}

	public Short getIsOverhead() {
		return isOverhead;
	}

	public void setIsOverhead(Short isOverhead) {
		this.isOverhead = isOverhead;
	}

	public Long getOverheadUserId() {
		return overheadUserId;
	}

	public void setOverheadUserId(Long overheadUserId) {
		this.overheadUserId = overheadUserId;
	}

	public String getOverheadCause() {
		return overheadCause;
	}

	public void setOverheadCause(String overheadCause) {
		this.overheadCause = overheadCause;
	}

	public Short getIsClose() {
		return isClose;
	}

	public void setIsClose(Short isClose) {
		this.isClose = isClose;
	}

	public Long getSwitchUserId() {
		return switchUserId;
	}

	public void setSwitchUserId(Long switchUserId) {
		this.switchUserId = switchUserId;
	}

	public String getSwitchCause() {
		return switchCause;
	}

	public void setSwitchCause(String switchCause) {
		this.switchCause = switchCause;
	}

	public Short getIsElite() {
		return isElite;
	}

	public void setIsElite(Short isElite) {
		this.isElite = isElite;
	}

	public Long getRecomUserId() {
		return recomUserId;
	}

	public void setRecomUserId(Long recomUserId) {
		this.recomUserId = recomUserId;
	}

	public Date getRecomValidity() {
		return recomValidity;
	}

	public void setRecomValidity(Date recomValidity) {
		this.recomValidity = recomValidity;
	}

	public Short getIsHidden() {
		return isHidden;
	}

	public void setIsHidden(Short isHidden) {
		this.isHidden = isHidden;
	}

	public String getHiddenCause() {
		return hiddenCause;
	}

	public void setHiddenCause(String hiddenCause) {
		this.hiddenCause = hiddenCause;
	}

	public Long getHiddenUserId() {
		return hiddenUserId;
	}

	public void setHiddenUserId(Long hiddenUserId) {
		this.hiddenUserId = hiddenUserId;
	}

	public Short getIsAccessory() {
		return isAccessory;
	}

	public void setIsAccessory(Short isAccessory) {
		this.isAccessory = isAccessory;
	}

	public Long getEditUserId() {
		return editUserId;
	}

	public void setEditUserId(Long editUserId) {
		this.editUserId = editUserId;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	@Override
	public String toString() {
		return "PostForm [userName=" + userName + ", rn=" + rn + ", postId=" + postId + ", userId=" + userId
				+ ", sectionId=" + sectionId + ", postType=" + postType + ", themeContent=" + themeContent
				+ ", issueTime=" + issueTime + ", issueIp=" + issueIp + ", hitNum=" + hitNum + ", answerSum="
				+ answerSum + ", isHighlight=" + isHighlight + ", highlightUserId=" + highlightUserId + ", titleColor="
				+ titleColor + ", isOverhead=" + isOverhead + ", overheadUserId=" + overheadUserId + ", overheadCause="
				+ overheadCause + ", isClose=" + isClose + ", switchUserId=" + switchUserId + ", switchCause="
				+ switchCause + ", isElite=" + isElite + ", recomUserId=" + recomUserId + ", recomValidity="
				+ recomValidity + ", isHidden=" + isHidden + ", hiddenCause=" + hiddenCause + ", hiddenUserId="
				+ hiddenUserId + ", isAccessory=" + isAccessory + ", editUserId=" + editUserId + ", editTime="
				+ editTime + ", postTitle=" + postTitle + "]";
	}

	public String getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(String commentNum) {
		this.commentNum = commentNum;
	}

}
