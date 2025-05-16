package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DomesticFundTransfer {

    @ValueMapValue
   private String sectionTitle;

    @ChildResource(name="cardItems")
    private List<CardItem> cardItems;

    public String getSectionTitle() {
        return sectionTitle;
    }

    public List<CardItem> getCardItems() {
        return cardItems;
    }

    @Model(adaptables = Resource.class)
    public static class CardItem {

        @ValueMapValue
        private String iconImageReference;

        @ValueMapValue
        private String hoverDescription;

        @ValueMapValue
        private String cardTitle;

        @ValueMapValue
        private String hoverTitle;

        @ValueMapValue
        private String backgroundImageReference;

        @ValueMapValue
        private String backgroundColor;

        public String getIconImageReference() {
            return iconImageReference;
        }

        public String getHoverDescription() {
            return hoverDescription;
        }

        public String getCardTitle() {
            return cardTitle;
        }

        public String getHoverTitle() {
            return hoverTitle;
        }

        public String getBackgroundImageReference() {
            return backgroundImageReference;
        }

        public String getBackgroundColor() {
            return backgroundColor;
        }



    }
}
