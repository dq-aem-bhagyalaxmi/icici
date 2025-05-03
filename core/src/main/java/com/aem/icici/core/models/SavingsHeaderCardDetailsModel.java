package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class SavingsHeaderCardDetailsModel {

    @ValueMapValue
    private String image;

    @ValueMapValue
    private String cardTitle;

    public String getImage() {
        return image;
    }

    public String getCardTitle() {
        return cardTitle;
    }
}