package com.aem.icici.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(
        adaptables = Resource.class,
        adapters = {SavingsHeaderHeroBannerModel.class, ComponentExporter.class},
        resourceType = "icici/components/savings-page-head-banner",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class SavingsHeaderHeroBannerModel implements ComponentExporter {

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String description;

    @ValueMapValue
    private String buttonText;

    @ValueMapValue
    private String buttonLink;

    @ChildResource(name = "cards")
    private List<SavingsHeaderCardDetailsModel> cards;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getButtonText() {
        return buttonText;
    }

    public List<SavingsHeaderCardDetailsModel> getCards() {
        return cards;
    }

    public String getButtonLink() {
        return buttonLink;
    }
    @Override
    public String getExportedType() {
        return "icici/components/savings-page-head-banner";
    }
}