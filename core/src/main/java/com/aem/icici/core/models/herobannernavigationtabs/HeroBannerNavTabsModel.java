package com.aem.icici.core.models.herobannernavigationtabs;

import com.adobe.cq.export.json.ComponentExporter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.ArrayList;
import java.util.List;

@Model(
        adaptables = Resource.class,
        adapters = {HeroBannerNavTabsModel.class, ComponentExporter.class},
        resourceType = "icici/components/herobanner-navigation-tabs",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class HeroBannerNavTabsModel implements ComponentExporter {

    @ValueMapValue
    private String[] tabTitle;

    @ValueMapValue
    private String[] tabLink;

    public List<HeroBannerTabItemModel> getTabs() {
        List<HeroBannerTabItemModel> tabs = new ArrayList<>();
        if (tabTitle != null && tabLink != null) {
            int length = Math.min(tabTitle.length, tabLink.length);
            for (int i = 0; i < length; i++) {
                tabs.add(new HeroBannerTabItemModel(tabTitle[i], tabLink[i]));
            }
        }
        return tabs;
    }

    @Override
    public String getExportedType() {
        return "icici/components/herobanner-navigation-tabs";
    }
}
