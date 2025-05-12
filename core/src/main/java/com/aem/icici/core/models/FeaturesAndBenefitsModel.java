package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FeaturesAndBenefitsModel {

    @ChildResource
    private List<FeatureItem> features;

    public List<FeatureItem> getFeatures() {
        return features;
    }

    @Model(adaptables = Resource.class)
    public static class FeatureItem {

        @ValueMapValue
        private String heading;

        @ValueMapValue
        private String details;

        @ValueMapValue
        private String fileReference;

        public String getHeading() {
            return heading;
        }

        public String getDetails() {
            return details;
        }

        public String getFileReference() {
            return fileReference;
        }
    }
}
