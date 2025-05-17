package com.aem.icici.core.models.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.wcm.core.components.models.Page;
import com.aem.icici.core.models.Actor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = Actor.class,
        resourceType = ActorImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class ActorImpl implements Actor {
    
    private static final Logger LOG = LoggerFactory.getLogger(ActorImpl.class);
    final protected static String RESOURCE_TYPE="icici/components/home";

    @Inject
    Resource resource;

    @SlingObject
    ResourceResolver resourceResolver;

    @Self
    SlingHttpServletRequest slingHttpServletRequest;

    @RequestAttribute(name = "rAttribute")
    private String reqAttribute;

    @ResourcePath(path="/content/icici/us/en")@Via("resource")
    Resource resourcePage;

    @ScriptVariable
    Page currentPage;

    @ValueMapValue(name = "jcr:title")
    String title;

    @Inject
    @Via("resource")
    @Named("jcr:lastModifiedBy")
    String modifiedBy;

    @Inject
    @Via("resource")
    @Default(values = "AEM")
    private String fname;

    @ValueMapValue
    @Default(values = "GEEKS")
    private String lname;

    @Inject
    @Via("resource")
    private boolean professor;


    @ValueMapValue
    private List<String> books;


    @Override
    public List<String> getBooks() {
        if (books != null) {
            return new ArrayList<String>(books);
        } else {
            return Collections.emptyList();
        }
    }


    @Override
    public String getFirstName() {
        return fname;
    }

    @Override
    public String getLastName() {
        return lname;
    }

    @Override
    public boolean getIsProfessor() {
        return professor;
    }

    @Override
    public String getTitle(){
        return title;
    }



    @Override
    @JsonIgnore
    public String getRequestAttribute() {
        return reqAttribute;
    }

    @Override
    public String getHomePageName(){
        return resourcePage.getName();
    }
    @Override
    public String getLastModifiedBy(){
        return modifiedBy;
    }

    @JsonProperty(value = "auhtor-name")
    public String authorName(){
        return "AEM GEEKS";
    }
    @Override
    public List<Map<String, String>> getBookDetailsWithMap() {
        List<Map<String, String>> bookDetailsMap=new ArrayList<>();
        try {
            Resource bookDetail=resource.getChild("bookdetailswithmap");
            if(bookDetail!=null){
                for (Resource book : bookDetail.getChildren()) {
                    Map<String,String> bookMap=new HashMap<>();
                    bookMap.put("bookname",book.getValueMap().get("bookname",String.class));
                    bookMap.put("booksubject",book.getValueMap().get("booksubject",String.class));
                    bookMap.put("publishyear",book.getValueMap().get("publishyear",String.class));
                    bookDetailsMap.add(bookMap);

                }
            }

        }catch (Exception e){

            LOG.info("\n ERROR while getting Book Details {} ",e.getMessage());
        }
        finally {
            System.out.println("Finally block");
        }
        return bookDetailsMap;
    }


}
