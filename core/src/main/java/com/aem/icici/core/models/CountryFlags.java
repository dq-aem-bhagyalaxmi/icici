package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CountryFlags {

    @ValueMapValue
    private String logotitle;

    @ValueMapValue
    private String logopath;

    @ValueMapValue
    private String flag;

    public String getLogotitle() {
        return logotitle;
    }

    public String getLogopath() {
        return logopath;
    }

    public String getFlag() {
        return flag;
    }
}
