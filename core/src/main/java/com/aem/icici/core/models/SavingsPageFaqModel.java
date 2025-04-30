package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SavingsPageFaqModel {

    @ChildResource(name = "faqItems")
    private Resource faqItems;

    private List<FaqItem> faqList;

    @PostConstruct
    protected void init() {
        if (faqItems != null) {
            faqList = new ArrayList<>();
            for (Resource child : faqItems.getChildren()) {
                FaqItem item = child.adaptTo(FaqItem.class);
                if (item != null) {
                    faqList.add(item);
                }
            }
        } else {
            faqList = Collections.emptyList();
        }
    }

    public List<FaqItem> getFaqList() {
        return faqList;
    }

    @Model(adaptables = Resource.class)
    public static class FaqItem {

        @ValueMapValue
        private String question;

        @ValueMapValue
        private String answer;

        public String getQuestion() {
            return question;
        }

        public String getAnswer() {
            return answer;
        }
    }
}
