package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FooterSection {

    @ValueMapValue
    private  String title;

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String fileReference;

    @ValueMapValue
    private String fileReference1;

    @ValueMapValue
    private String text1;

    @ValueMapValue
    private String linkURL;

    @ValueMapValue
    private String icon;

    public String getTitle() {
        return title;
    }

    public String getIcon() {
        return icon;
    }

    public String getLinkURL() {
        return linkURL;
    }

    public String getText1() {
        return text1;
    }

    public String getFileReference1() {
        return fileReference1;
    }

    public String getFileReference() {
        return fileReference;
    }

    public String getText() {
        return text;
    }
}
