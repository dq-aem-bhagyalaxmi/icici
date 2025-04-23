package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class Footer_dialnumberModel {

    @ValueMapValue
    private String linkURL;

    @ValueMapValue
    private String fileReference;

    @ValueMapValue
    private String title;

    public String getLinkURL() {
        return linkURL;
    }

    public String getFileReference() {
        return fileReference;
    }

    public String getTitle() {
        return title;
    }
}
