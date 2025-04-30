package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DigitalBankingSolutionsModel {

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String tab1Title;

    @ValueMapValue
    private String tab2Title;

    @ValueMapValue
    private String actorImageTab1;

    @ValueMapValue
    private String actorImageTab2;

    @ChildResource(name = "featuresTab1")
    private List<FeatureItem> featuresTab1;

    @ChildResource(name = "featuresTab2")
    private List<FeatureItem> featuresTab2;

    @ChildResource
    private List<ImageItem> uploadimg;

    public String getTitle() {
        return title;
    }

    public String getTab1Title() {
        return tab1Title;
    }

    public String getTab2Title() {
        return tab2Title;
    }

    public String getActorImageTab1() {
        return actorImageTab1;
    }

    public String getActorImageTab2() {
        return actorImageTab2;
    }

    public List<FeatureItem> getFeaturesTab1() {
        return featuresTab1;
    }

    public List<FeatureItem> getFeaturesTab2() {
        return featuresTab2;
    }

    public List<ImageItem> getUploadimg() {
        return uploadimg;
    }

    @Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
    public static class FeatureItem {
        @ValueMapValue
        private String featureText;


        public String getFeatureText() {
            return featureText;
        }

    }

    @Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
    public static class ImageItem{
        @ValueMapValue
        private String image;

        @ValueMapValue
        private String link;

        public String getImage() {
            return image;
        }

        public String getLink() {
            return link;
        }
    }

}

