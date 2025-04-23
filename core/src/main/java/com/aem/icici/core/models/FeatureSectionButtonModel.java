package com.aem.icici.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Model(
        adaptables = Resource.class,
        adapters = {FeatureSectionButtonModel.class, ComponentExporter.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class FeatureSectionButtonModel implements ComponentExporter {



    @ValueMapValue
    private String buttonText;

    @ValueMapValue
    private String link;

    @ValueMapValue
    private String iconPath;

    @PostConstruct
    protected void init() {
        if (buttonText == null || buttonText.isEmpty()) {
            buttonText = "Click Here";
        }
        if (link == null || link.isEmpty()) {
            link = "https://example.com";
        }
        if (iconPath == null || iconPath.isEmpty()) {
            iconPath = "/content/dam/example-icon.png";
        }
    }

    public String getButtonText() {
        return buttonText;
    }

    public String getLink() {
        return link;
    }

    public String getIconPath() {
        return iconPath;
    }

    @Override
    public String getExportedType() {
        return "icici/components/herobannerimage";
    }
}
