package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class Herobanner_sendmoneyModel {

    @ValueMapValue
    private String text1;

    @ValueMapValue
    private String text2;

    @ValueMapValue
    private String text3;

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String imageicon;

    @ValueMapValue
    private String link;

    @ChildResource
    private List<ImageItem> imagelists;

    public List<ImageItem> getImagelists() {
        return imagelists;
    }

    @Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
    public static class ImageItem{
        @ValueMapValue
        private String image;

        public String getImage() {

            return image;
        }

    }


    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public String getText3() {
        return text3;
    }

    public String getTitle() {
        return title;
    }

    public String getImageicon() {
        return imageicon;
    }

    public String getLink() {
        return link;
    }
}
