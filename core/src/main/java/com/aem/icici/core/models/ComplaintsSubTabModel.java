package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ComplaintsSubTabModel {

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String title2;

    public String getTitle2() {
        return title2;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @ChildResource
    private List<FooterleftSide> footerleft;

    public List<FooterleftSide> getFooterleft() {
        return footerleft;
    }



    @Model(adaptables = Resource.class)
    public static class FooterleftSide{
        @ValueMapValue
        private String text2;

        @ValueMapValue
        private String link;

        public String getText2() {
            return text2;
        }

        public String getLink() {
            return link;
        }
    }

    @ChildResource
    private List<FooterrightSide> footerright;

    public List<FooterrightSide> getFooterright() {
        return footerright;
    }
    @Model(adaptables = Resource.class)
    public static class FooterrightSide{
        @ValueMapValue
        private String text3;

        @ValueMapValue
        private String link3;

        public String getText3() {
            return text3;
        }

        public String getLink3() {
            return link3;
        }
    }


}
