package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TransferFundsAnywhere_anytimeModel {
    @ValueMapValue
    private String title;

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String link;

    @ValueMapValue
    private String mainImage;

    @ChildResource
    private List<imgbutton> imagebutton;

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getLink() {
        return link;
    }

    public List<imgbutton> getImagebutton() {
        return imagebutton;
    }

    public String getMainImage() {
        return mainImage;
    }

    @Model(adaptables = Resource.class)
    public static class imgbutton{

        @ValueMapValue
        private String image;

        @ValueMapValue
        private String text1;

        public String getImage() {
            return image;
        }

        public String getText1() {
            return text1;
        }
    }
}
