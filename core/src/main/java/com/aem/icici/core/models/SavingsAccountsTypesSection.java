package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
        import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SavingsAccountsTypesSection{

    @ValueMapValue
    private String sectionTitle;

    @ChildResource(name = "accountItems")
    private List<SavingsAccountItemModel> accountItems;

    public String getSectionTitle() {
        return sectionTitle;
    }

    public List<SavingsAccountItemModel> getAccountItems() {

        return accountItems;
    }

    @Model(adaptables = Resource.class)
    public static class SavingsAccountItemModel {

        @ValueMapValue
        private String accountTitle;

        @ValueMapValue
        private String accountImagePath;

        @ValueMapValue
        private String fileReference;

        public String getAccountTitle() {
            return accountTitle;
        }

        public String getAccountImagePath() {
            return accountImagePath;
        }

        public String getFileReference() {
            return fileReference;
        }
    }
}
