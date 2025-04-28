package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HerobannerImageDetailsModel {

    @ValueMapValue
    private String image;

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String details;

    public String getImage() {
        return image != null ? image : "/content/dam/icici/";
    }

    public String getTitle() {
        return title != null ? title : "Default Hero Title";
    }

    public String getDetails() {
        return details != null ? details : "Default description for the hero banner.";
    }
}
