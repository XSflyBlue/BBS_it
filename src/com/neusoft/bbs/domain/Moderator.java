package com.neusoft.bbs.domain;

/***
 * （两类）版主类
 * @author flyblue
 *
 */
public class Moderator {
	/***
	 * 版主ID
	 */
    private Long moderatorId;

    /***
     * 板块ID
     */
    private Short sectionId;

    /***
     * 版主类型
     * 
     */
    private Short moderatorType;

    public Long getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(Long moderatorId) {
        this.moderatorId = moderatorId;
    }

    public Short getSectionId() {
        return sectionId;
    }

    public void setSectionId(Short sectionId) {
        this.sectionId = sectionId;
    }

    public Short getModeratorType() {
        return moderatorType;
    }

    public void setModeratorType(Short moderatorType) {
        this.moderatorType = moderatorType;
    }
}