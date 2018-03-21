package com.bysx.bbs.domain;

/***
 * 帮助主题类
 * @author flyblue
 *
 */
public class HelpTheme {
	/***
	 * 帮助主题ID
	 */
    private Long helpThemeId;

    /***
     * 帮助主题名称
     */
    private String helpThemeName;

    /***
     * 所属分类ID
     */
    private Long helpTypeId;

    /***
     * 帮助内容
     */
    private String helpContent;

    public Long getHelpThemeId() {
        return helpThemeId;
    }

    public void setHelpThemeId(Long helpThemeId) {
        this.helpThemeId = helpThemeId;
    }

    public String getHelpThemeName() {
        return helpThemeName;
    }

    public void setHelpThemeName(String helpThemeName) {
        this.helpThemeName = helpThemeName;
    }

    public Long getHrlpTypeId() {
        return helpTypeId;
    }

    public void setHrlpTypeId(Long helpTypeId) {
        this.helpTypeId = helpTypeId;
    }

    public String getHelpContent() {
        return helpContent;
    }

    public void setHelpContent(String helpContent) {
        this.helpContent = helpContent;
    }
}