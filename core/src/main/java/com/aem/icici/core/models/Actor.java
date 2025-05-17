package com.aem.icici.core.models;

import java.util.List;
import java.util.Map;



public interface Actor {
    String getFirstName();
    String getLastName();
    boolean getIsProfessor();
    String getTitle();
    String getRequestAttribute();
    String getHomePageName();
    String getLastModifiedBy();
    List<String> getBooks();
    List<Map<String, String>> getBookDetailsWithMap();



    
} 