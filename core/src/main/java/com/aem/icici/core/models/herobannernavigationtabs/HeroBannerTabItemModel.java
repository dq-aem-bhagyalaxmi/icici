package com.aem.icici.core.models.herobannernavigationtabs;

public class HeroBannerTabItemModel {

    private String tabTitle;
    private String tabLink;

    public HeroBannerTabItemModel(String tabTitle, String tabLink) {
        this.tabTitle = tabTitle;
        this.tabLink = tabLink;
    }

    public String getTabTitle() {
        return tabTitle;
    }

    public String getTabLink() {
        return tabLink;
    }
}
