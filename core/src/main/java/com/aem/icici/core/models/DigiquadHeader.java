package com.aem.icici.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(
        adaptables = {Resource.class, SlingHttpServletRequest.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DigiquadHeader {

    @ValueMapValue
    private String logo;

    @ValueMapValue
    private String contactNumber;

    @ValueMapValue
    private String login;

    @ChildResource
    private List<NavItem> mainNav;

    @ChildResource
    private List<NavItem> secondNav;

    @ChildResource(name = "links")
    private List<FlagItem> flag;

    public String getLogo() {
        return logo;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getLogin() {
        return login;
    }

    public List<NavItem> getMainNav() {
        return mainNav;
    }

    public List<NavItem> getSecondNav() {
        return secondNav;
    }

    public List<FlagItem> getFlag() {
        return flag;
    }
}
