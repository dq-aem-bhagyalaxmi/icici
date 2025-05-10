package com.aem.icici.core.models.aboutUs;



import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = {SlingHttpServletRequest.class, Resource.class},
    adapters = AboutUsModel.class,
    resourceType = "icici/components/about_us",
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class AboutUsModel {

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String paragraph;

    @ValueMapValue
    private String buttonText;

    @ValueMapValue
    private String buttonLink;

    @ValueMapValue
    private String backgroundColor;

    // Style properties
    @ValueMapValue
    private String titleSize;

    @ValueMapValue
    private String titleColor;

    @ValueMapValue
    private String paragraphSize;

    @ValueMapValue
    private String paragraphColor;

    @ValueMapValue
    private String buttonStyle;

    @ValueMapValue
    private String buttonColor;


    // Getters
    public String getTitle() {
        return title;
    }

    public String getParagraph() {
        return paragraph;
    }

    public String getButtonText() {
        return buttonText;
    }

    public String getButtonLink() {
        return buttonLink;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getTitleSize() {
        return titleSize;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public String getParagraphSize() {
        return paragraphSize;
    }

    public String getParagraphColor() {
        return paragraphColor;
    }

    public String getButtonStyle() {
        return buttonStyle;
    }

    public String getButtonColor() {
        return buttonColor;
    }
}