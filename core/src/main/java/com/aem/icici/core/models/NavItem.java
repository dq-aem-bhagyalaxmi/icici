package com.aem.icici.core.models;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NavItem {

    @ValueMapValue
    private String label;

    @ValueMapValue
    private String linkPath;


    public String getLabel() {
        return label;
    }

    public String getLinkPath() {
        return linkPath;
    }
}
