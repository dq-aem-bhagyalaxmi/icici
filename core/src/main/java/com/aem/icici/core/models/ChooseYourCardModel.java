package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class ChooseYourCardModel {

    @ValueMapValue
    private String sectionTitle;

    @ValueMapValue
    private String exploreAll;

    @ValueMapValue
    private String business;

    @ChildResource(name = "links")
    private List<Resource> links;

    public String getSectionTitle() {
        return sectionTitle;
    }

    public String getExploreAll() {
        return exploreAll;
    }

    public String getBusiness() {
        return business;
    }

    public List<CardLink> getLinks() {
        if (links == null) return Collections.emptyList();

        List<CardLink> items = new ArrayList<>();
        for (Resource res : links) {
            CardLink card = res.adaptTo(CardLink.class);
            if (card != null) {
                items.add(card);
            }
        }
        return items;
    }
    @Model(adaptables = Resource.class)
    public static class CardLink {

        @ValueMapValue
        private String cardTitle;

        @ValueMapValue
        private String fileReference;

        @ValueMapValue
        private String cardImagePath;

        @ValueMapValue
        private String sapphiroText;

        @ValueMapValue
        private String bestFor;

        @ValueMapValue
        private String cardDescription;

        @ValueMapValue
        private String applydetails;

        public String getCardTitle() {
            return cardTitle;
        }

        public String getFileReference() {
            return fileReference;
        }

        public String getCardImagePath() {
            return cardImagePath;
        }

        public String getSapphiroText() {
            return sapphiroText;
        }

        public String getBestFor() {
            return bestFor;
        }

        public String getCardDescription() {
            return cardDescription;
        }

        public String getApplydetails() {
            return applydetails;
        }
    }
}
