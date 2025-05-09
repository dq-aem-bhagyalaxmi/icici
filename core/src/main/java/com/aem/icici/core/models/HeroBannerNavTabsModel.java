package com.aem.icici.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(
        adaptables = org.apache.sling.api.resource.Resource.class,
        adapters = {HeroBannerNavTabsModel.class, ComponentExporter.class},
        resourceType = "icici/components/herobanner-navigation-tabs", // ✅ adjust this if needed
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class HeroBannerNavTabsModel implements ComponentExporter {

    @ChildResource(name = "links")
    private List<LinkItem> links;

    public List<LinkItem> getLinks() {
        return links;
    }

    @Override
    public String getExportedType() {
        return "icici/components/herobanner-navigation-tabs"; // ✅ same resourceType here
    }

    // Static inner Class for Link Items
    @Model(adaptables = org.apache.sling.api.resource.Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
    public static class LinkItem {

        @ValueMapValue
        private String label;

        @ValueMapValue
        private String linkPath;

        public String getLabel() {
            return label;
        }

        public String getLinkPath() {
            return linkPath;
        }
    }
}
