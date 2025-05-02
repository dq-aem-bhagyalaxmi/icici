package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;
@Model(adaptables = Resource.class , defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TransferFundsAbroadModel {

    @ValueMapValue
    private String title;

    @ChildResource(name = "CardItems")
    private List<CardItem> cardItems;

    public String getTitle() {

        return title;
    }

    public List<CardItem> getCardItems() {
        return cardItems;
    }

    @Model(adaptables = Resource.class)
    public static class CardItem{

        @ValueMapValue
        private String fileReference;

        @ValueMapValue
        private String cardDescription;

        @ValueMapValue
        private String ctaText;

        @ValueMapValue
        private String ctaLink;

        public String getFileReference() {

            return fileReference;
        }

        public String getCardDescription() {

            return cardDescription;
        }

        public String getCtaText() {

            return ctaText;
        }

        public String getCtaLink() {

            return ctaLink;

        }

    }
}
