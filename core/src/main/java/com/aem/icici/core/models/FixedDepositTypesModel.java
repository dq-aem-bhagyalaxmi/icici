package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FixedDepositTypesModel {

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String iconImageReference;

    @ValueMapValue
    private String iconImagePath;

    public String getTitle() {
        return title;
    }

    public String getIconImageReference() {
        return iconImageReference;
    }

    public String getIconImagePath() {
        return iconImagePath;
    }

}

