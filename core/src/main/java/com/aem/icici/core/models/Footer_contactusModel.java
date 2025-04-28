package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class Footer_contactusModel {

    @ValueMapValue
    private String linkURL;

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String icon;

    public String getLinkURL() {
        return linkURL;
    }

    public String getTitle() {
        return title;
    }

    public String getIcon() {
        return icon;
    }
}
