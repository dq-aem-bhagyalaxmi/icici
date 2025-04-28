package com.aem.icici.core.models;

import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.export.json.ComponentExporter;
import org.apache.sling.api.resource.Resource;

import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Named;
import java.util.List;

@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class HeaderNavigation {

    @ValueMapValue
    @Default(values = "")
    private String logo;

    @ValueMapValue
    @Default(values = "")
    private String contactNumber;

    @ValueMapValue
    @Default(values = "")
    private String login;

    @ChildResource(name = "mainNav")
    private List<NavigationLink> mainNav;

    @ChildResource(name = "secondNav")
    private List<NavigationLink> secondNav;

    public String getLogo() {
        return logo;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getLogin() {
        return login;
    }

    public List<NavigationLink> getMainNav() {
        return mainNav;
    }

    public List<NavigationLink> getSecondNav() {
        return secondNav;
    }


}
