package com.neusoft.bbs.domain;

/***
 * 帮助分类（类型）类
 * @author flyblue
 *
 */
public class HelpType {
	/***
	 * 帮助分类ID
	 */
    private Long helpTypeId;

    /***
     * 帮助分类名称
     */
    private String helpTypeName;

    public Long getHelpTypeId() {
        return helpTypeId;
    }

    public void setHelpTypeId(Long helpTypeId) {
        this.helpTypeId = helpTypeId;
    }

    public String getHelpTypeName() {
        return helpTypeName;
    }

    public void setHelpTypeName(String helpTypeName) {
        this.helpTypeName = helpTypeName;
    }
}