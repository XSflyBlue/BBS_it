package com.neusoft.bbs.domain;

/***
 * （两类）版主类
 * @author flyblue
 *
 */
public class Moderator {
	/***
	 * 版主记录ID
	 */
    private Long moderatorId;

    /***
     * 区域（板块或分区）ID
     */
    private Short areaId;
    
    /***
     * 版主类型
     * 
     */
    private Short moderatorType;
    
    /***
     * 用户ID
     */
    private Short userId;

    public Long getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(Long moderatorId) {
        this.moderatorId = moderatorId;
    }

    public Short getModeratorType() {
        return moderatorType;
    }

    public void setModeratorType(Short moderatorType) {
        this.moderatorType = moderatorType;
    }

	public Short getAreaId() {
		return areaId;
	}

	public void setAreaId(Short areaId) {
		this.areaId = areaId;
	}

	public Short getUserId() {
		return userId;
	}

	public void setUserId(Short userId) {
		this.userId = userId;
	}
}