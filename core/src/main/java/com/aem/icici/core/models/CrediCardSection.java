package com.aem.icici.core.models;

import org.apache.sling.api.adapter.Adaptable;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables  = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CrediCardSection {

    @ValueMapValue
    private String sectionTitle;

    @ValueMapValue
    private String leftText;

    @ValueMapValue
    private String leftLinkURL;

    @ValueMapValue
    private String rightText;

    @ChildResource
    private List<CardItems> cardItems;

    public String getSectionTitle() {

        return sectionTitle;
    }
    public String getLeftText() {

        return leftText;
    }
    public String getLeftLinkURL() {

        return leftLinkURL;
    }
    public String getRightText() {

        return rightText;
    }
    public List<CardItems> getCardItems(){
        return cardItems;
    }

    @Model(adaptables = Resource.class)
    public static class CardItems{


        @ValueMapValue
        private String cardTitle;

        @ValueMapValue
        private String cardTitleLink;

        @ValueMapValue
        private String cardLabel;

        @ValueMapValue
        private String cardBadge;

        @ValueMapValue
        private String fileReference;

        @ValueMapValue
        private String cardImagePath;

        @ValueMapValue
        private String cardTitleText;

        @ValueMapValue
        private String cardSubText;

        @ValueMapValue
        private String ctaLinks;

        public String getCardTitle() {

            return cardTitle;
        }

        public String getCardTitleLink() {

            return cardTitleLink;
        }

        public String getCardLabel() {

            return cardLabel;
        }

        public String getCardBadge() {

            return cardBadge;
        }
        public String getCardImagePath() {

            return cardImagePath;
        }
        public String getFileReference() {

            return fileReference;
        }
        public String getCardTitleText() {

            return cardTitleText;
        }
        public String getCardSubText() {

            return cardSubText;
        }
        public String getCtaLinks() {

            return ctaLinks;
        }
    }
}
