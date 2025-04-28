package com.aem.icici.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OfferCardDetailsModel {

    @ValueMapValue
    private String offerSectionTitle;

    @ValueMapValue
    private String fileName;

    @ValueMapValue
    private String fileReference;

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String textContent;

    @ValueMapValue
    private String cardBadge;

    @ValueMapValue
    private String link1;

    @ValueMapValue
    private String linkText1;

    @ValueMapValue
    private String link2;

    @ValueMapValue
    private String linkText2;

    public String getOfferSectionTitle() {
        return offerSectionTitle;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileReference() {
        return fileReference;
    }

    public String getTitle() {
        return title;
    }

    public String getTextContent() {
        return textContent;
    }

    public String getCardBadge() {
        return cardBadge;
    }

    public String getLink1() {
        return link1;
    }

    public String getLinkText1() {
        return linkText1;
    }

    public String getLink2() {
        return link2;
    }

    public String getLinkText2() {
        return linkText2;
    }
}