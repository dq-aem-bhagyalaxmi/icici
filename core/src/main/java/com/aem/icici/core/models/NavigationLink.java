package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class NavigationLink {

    @ValueMapValue
    private String label;

    @ValueMapValue(name = "linkPath")
    private String linkPath;

    @ValueMapValue
    private String target;

    public String getLabel() {
        return label;
    }

    public String getLinkPath() {
        return linkPath;
    }

    public String getTarget() {
        return target;
    }
}
