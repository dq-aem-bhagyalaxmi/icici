package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ComplaintsLevel2Model {
    @ValueMapValue
    private String title;

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String text3;

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getText3() {
        return text3;
    }

    @ChildResource
    private List<ButtonparaLists2> buttonpara;

    public List<ButtonparaLists2> getButtonpara() {
        return buttonpara;
    }

    @Model(adaptables = Resource.class)
    public static class ButtonparaLists2{
        @ValueMapValue
        private String text2;

        @ValueMapValue
        private String text1;

        @ValueMapValue
        private String link;

        public String getText2() {
            return text2;
        }

        public String getText1() {
            return text1;
        }

        public String getLink() {
            return link;
        }
    }
}
