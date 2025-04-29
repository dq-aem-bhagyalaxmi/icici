package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
        import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Main Component Model for savingsAccountsTypesSection
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SavingsAccountsTypesSectionModel {

    // Inject the section title
    @ValueMapValue
    private String sectionTitle;

    // Inject account items as a list of resources
    @ChildResource(name = "accountItems")
    private List<Resource> accountItems;

    // Getter for section title
    public String getSectionTitle() {
        return sectionTitle;
    }

    public List<SavingsAccountItemModel> getAccountItems() {
        if (accountItems == null || accountItems.isEmpty()) {
            System.out.println("accountItems is null");
            return Collections.emptyList();
        }

        List<SavingsAccountItemModel> items = new ArrayList<>();
        for (Resource res : accountItems) {
            SavingsAccountItemModel item = res.adaptTo(SavingsAccountItemModel.class);
            if (item != null) {
                items.add(item);
            }
        }

        return items;
    }


    // Inner class for the account item model
    @Model(adaptables = Resource.class)
    public static class SavingsAccountItemModel {

        // Inject account title
        @ValueMapValue
        private String accountTitle;

        // Inject account image path
        @ValueMapValue
        private String accountImagePath;

        // Inject file reference
        @ValueMapValue
        private String fileReference;

        // Getter for account title
        public String getAccountTitle() {
            return accountTitle;
        }

        // Getter for account image path
        public String getAccountImagePath() {
            return accountImagePath;
        }

        // Getter for file reference
        public String getFileReference() {
            return fileReference;
        }
    }
}
