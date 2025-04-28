package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ActionButtonModel {

    @ValueMapValue
    private String label;

    @ValueMapValue
    private String link;

    @ValueMapValue
    private String iconPath;

    private String finalLabel;
    private String finalLink;
    private String finalIconPath;

    @PostConstruct
    protected void init() {
        finalLabel = (label != null && !label.isEmpty()) ? label : "Click Me";
        finalLink = (link != null && !link.isEmpty()) ? link : "#";
        finalIconPath = (iconPath != null && !iconPath.isEmpty()) ? iconPath : "/content/dam/default-icon.png";
    }

    public String getLabel() {
        return finalLabel;
    }

    public String getLink() {
        return finalLink;
    }

    public String getIconPath() {
        return finalIconPath;
    }
}
