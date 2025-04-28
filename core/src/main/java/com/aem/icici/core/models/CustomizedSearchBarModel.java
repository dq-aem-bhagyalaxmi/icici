package com.aem.icici.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CustomizedSearchBarModel {

    @ValueMapValue
    private String searchText;

    @ValueMapValue
    private String leftIconRef;

    @ValueMapValue
    private String rightIconRef;

    private String placeholder;

    @PostConstruct
    protected void init() {
        placeholder = (searchText != null && !searchText.isEmpty()) ? searchText : "Search something here...";
    }

    public String getSearchText() {
        return searchText;
    }

    public String getLeftIconRef() {
        return leftIconRef;
    }

    public String getRightIconRef() {
        return rightIconRef;
    }

    public String getPlaceholder() {
        return placeholder;
    }
}