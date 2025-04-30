package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SavingsPageEligibilityAccordionModel {

    @ValueMapValue
    private String mainHeading;

    @ValueMapValue
    private String firstSectionTitle;

    @ValueMapValue
    private String firstSectionContent;

    @ValueMapValue
    private String secondSectionTitle;

    @ValueMapValue
    private String secondSectionContent;


    public String getMainHeading() {
        return mainHeading != null ? mainHeading : "Default Main Heading";
    }

    public String getFirstSectionTitle() {
        return firstSectionTitle != null ? firstSectionTitle : "First Section Title";
    }

    public String getFirstSectionContent() {
        return firstSectionContent != null ? firstSectionContent : "First section content goes here.";
    }

    public String getSecondSectionTitle() {
        return secondSectionTitle != null ? secondSectionTitle : "Second Section Title";
    }

    public String getSecondSectionContent() {
        return secondSectionContent != null ? secondSectionContent : "Second section content goes here.";
    }
}
