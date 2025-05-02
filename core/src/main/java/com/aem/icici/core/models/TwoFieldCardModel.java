package com.aem.icici.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TwoFieldCardModel {

    @ChildResource(name = "cards")
    private List<Resource> cards;

    public List<Card> getCards() {
        if (cards == null) {
            return Collections.emptyList();
        }
        List<Card> cardItems = new ArrayList<>();
        for (Resource card : cards) {
            cardItems.add(new Card(card));
        }
        return cardItems;
    }

    public static class Card {

        private final Resource resource;

        public Card(Resource resource) {
            this.resource = resource;
        }

        @ValueMapValue(name = "image")
        private String image;

        @ValueMapValue(name = "text")
        private String text;

        public String getImage() {
            return resource.getValueMap().get("image", String.class);
        }

        public String getText() {
            return resource.getValueMap().get("text", String.class);
        }
    }
}

