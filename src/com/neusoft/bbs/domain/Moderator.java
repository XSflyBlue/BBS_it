package com.neusoft.bbs.domain;

public class Moderator {
    private Long moderatorId;

    private Short sectionId;

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