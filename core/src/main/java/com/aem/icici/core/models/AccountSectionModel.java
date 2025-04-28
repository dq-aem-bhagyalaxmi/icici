package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class AccountSectionModel {

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String title1;

    @ValueMapValue
    private String link1;

    @ChildResource(name = "links")
    private List<LinkItem> links;

    public String getTitle() {
        return title;
    }

    public String getTitle1() {
        return title1;
    }

    public String getLink1() {
        return link1;
    }

    public List<LinkItem> getLinks() {
        return links;
    }



    @Model(adaptables = Resource.class)
    public static class LinkItem {
        @ValueMapValue
        private String text;

        @ValueMapValue
        private String link;

        @ValueMapValue
        private String icon;

        public String getText() {
            return text;
        }

        public String getLink() {
            return link;
        }

        public String getIcon() {
            return icon;
        }
    }
}
