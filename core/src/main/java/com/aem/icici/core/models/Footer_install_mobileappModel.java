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
public class Footer_install_mobileappModel {

    @ValueMapValue
    private String title;

    public String getTitle() {
        return title;
    }

    @ChildResource(name = "links")
    private List<LinkItem> links;

    public List<LinkItem> getLinks() {

        return links;
    }



    @Model(adaptables = Resource.class)
    public static class LinkItem {
        @ValueMapValue
        private String link;

        @ValueMapValue
        private String fileReference;

        public String getLink() {
            return link;
        }

        public String getFileReference() {

            return fileReference;
        }
    }

}
