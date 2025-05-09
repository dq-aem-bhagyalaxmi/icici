package com.aem.icici.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Create_fixedDepositeModel {

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String videoURL;

    @ValueMapValue
    private String link1;

    @ValueMapValue
    private String buttontext1;

    @ValueMapValue
    private String link2;

    @ValueMapValue
    private String buttontext2;


    public String getTitle() {
        return title;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public String getLink1() {
        return link1;
    }

    public String getButtontext1() {
        return buttontext1;
    }

    public String getLink2() {
        return link2;
    }

    public String getButtontext2() {
        return buttontext2;
    }

    @ChildResource
    private List<FeatureItem> featuresTab;

    public List<FeatureItem> getFeaturesTab() {
        return featuresTab;
    }



    @Model(adaptables = Resource.class)
    public static class  FeatureItem {

        @ValueMapValue
        private String featureText;

        public String getFeatureText() {
            return featureText;
        }
    }

}
