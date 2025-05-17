package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = Resource.class , defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PremiumAccountsCard{

    @ValueMapValue
    private String  title;

    @ValueMapValue
    private String iconImageReference;

    @ValueMapValue
    private String iconImagePath;

    @ValueMapValue
    private String iconText;

    @ValueMapValue
    private String  description;

    @ValueMapValue
    private String imageReference;

    @ChildResource(name = "buttonItems")
    private List<ButtonItems> buttonItems;

    @ValueMapValue
    private String backgroundColor;

    public String getTitle() {
        return title;
    }

    public String getIconImageReference() {
        return iconImageReference;
    }

    public String getIconImagePath() {
        return iconImagePath;
    }

    public String getIconText() {
        return iconText;
    }

    public String getDescription() {
        return description;
    }

    public String getImageReference() {
        return imageReference;
    }

    public List<ButtonItems> getButtonItems() {
        return buttonItems;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    @Model(adaptables = Resource.class)
    public static class ButtonItems {

        @ValueMapValue
        private String buttonText;

        @ValueMapValue
        private String buttonLink;

        public String getButtonText() {
            return buttonText;
        }

        public String getButtonLink() {
            return buttonLink;
        }

    }
}

