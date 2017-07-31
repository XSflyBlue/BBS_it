package com.neusoft.bbs.domain;

public class HelpTheme {
    private Long helpThemeId;

    private String helpThemeName;

    private Long hrlpTypeId;

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
        return hrlpTypeId;
    }

    public void setHrlpTypeId(Long hrlpTypeId) {
        this.hrlpTypeId = hrlpTypeId;
    }

    public String getHelpContent() {
        return helpContent;
    }

    public void setHelpContent(String helpContent) {
        this.helpContent = helpContent;
    }
}