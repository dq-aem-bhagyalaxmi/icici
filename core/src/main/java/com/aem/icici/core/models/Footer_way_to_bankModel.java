
package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Footer_way_to_bankModel {

    @ValueMapValue
    private  String title;

    @ValueMapValue
    private String link1;



    public String getTitle() {
        return title;
    }

    public String getLink1() {
        return link1;
    }



    @ChildResource(name = "links")
    private List<LinkItem> links;

    public List<LinkItem> getLinks() {
        return links;
    }

    @Model(adaptables = Resource.class)
    public static class LinkItem {

        @ValueMapValue
        private String text;

        @ValueMapValue
        private String link;

        public String getText() {
            return text;
        }

        public String getLink() {
            return link;
        }
    }
}
