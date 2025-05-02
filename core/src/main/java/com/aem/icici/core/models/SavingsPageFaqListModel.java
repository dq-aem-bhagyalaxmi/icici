package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

import java.util.ArrayList;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SavingsPageFaqListModel {

    private final Resource resource;

    public SavingsPageFaqListModel(Resource resource) {
        this.resource = resource;
    }

    public List<FaqItem> getFaqItems() {
        List<FaqItem> items = new ArrayList<>();
        Resource faqItemsResource = resource.getChild("faqItems");

        if (faqItemsResource != null) {
            for (Resource faqItem : faqItemsResource.getChildren()) {
                String question = faqItem.getValueMap().get("question", String.class);
                String answer = faqItem.getValueMap().get("answer", String.class);
                if (question != null && answer != null) {
                    items.add(new FaqItem(question, answer));
                }
            }
        }
        return items;
    }

    public static class FaqItem {
        private String question;
        private String answer;

        public FaqItem(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }

        public String getQuestion() {
            return question;
        }

        public String getAnswer() {
            return answer;
        }
    }
}
