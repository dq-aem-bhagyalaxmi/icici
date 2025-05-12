package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FixedDepositImmediateOverdraftModel {

    @ValueMapValue
    private String heading;

    @ValueMapValue
    private String details;

    @ValueMapValue
    private String imageReference;

    @ValueMapValue
    private String imagePath;

    @ChildResource
    private List<FdOverdraftButtons> buttons;

    public String getHeading() {
        return heading;
    }

    public String getDetails() {
        return details;
    }

    public String getImageReference() {
        return imageReference;
    }

    public String getImagePath() {
        return imagePath;
    }

    public List<FdOverdraftButtons> getButtons() {
        return buttons;
    }

    @Model(adaptables = Resource.class)
    public static class FdOverdraftButtons {

        @ValueMapValue
        private String buttonLabel;

        @ValueMapValue
        private String linkPath;

        public String getButtonLabel() {
            return buttonLabel;
        }

        public String getLinkPath() {
            return linkPath;
        }
    }
}

