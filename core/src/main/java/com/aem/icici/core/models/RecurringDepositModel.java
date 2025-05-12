package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class RecurringDepositModel {

    @ValueMapValue
    private String heading;

    @ValueMapValue
    private String details;

    public String getDetails() {
        return details;
    }

    public String getHeadingFirstWord() {
        if (heading == null || heading.isEmpty()) {
            return "";
        }
        String[] parts = heading.split(" ", 2);
        return parts[0];
    }

    public String getHeadingRest() {
        if (heading == null || heading.isEmpty()) {
            return "";
        }
        String[] parts = heading.split(" ", 2);
        return parts.length > 1 ? parts[1] : "";
    }

}
