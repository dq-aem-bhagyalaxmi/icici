package com.aem.icici.core.models;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeaderModel {

    @ValueMapValue
    private String fileReference;

    @ChildResource
    private List<NavItem> links ;

    public String getFileReference() {
        return fileReference;
    }

    public List<NavItem> getLinks() {
        return links;
    }
}
