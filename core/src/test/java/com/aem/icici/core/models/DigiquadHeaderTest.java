package com.aem.icici.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
public class DigiquadHeaderTest {
    // Initialize AEM context for testing
    // This context simulates the AEM environment for unit tests
    // It allows us to load resources, adapt them to models, and perform assertions
    // without needing a full AEM instance

    private final AemContext context = new AemContext();

    @BeforeEach
    void setUp() {
    context.addModelsForClasses(DigiquadHeader.class);
    context.load().json("src/test/java/com/aem/icici/core/models/digiquadheader.json",
        "/component");
    
}

    @Test
    void testDigiquadHeaderModel() {
        context.currentResource("/component");
        DigiquadHeader header = context.request().adaptTo(DigiquadHeader.class);

        assertNotNull(header);
        assertEquals("/content/dam/icici/header-images/icici_header_logo.png", header.getLogo());
        assertEquals("18001080", header.getContactNumber());
        assertEquals("https://www.google.com", header.getLogin());

        // Validate Main Navigation
        List<NavItem> mainNav = header.getMainNav();
        assertNotNull(mainNav);
        assertEquals(3, mainNav.size());
        assertEquals("Personal", mainNav.get(0).getLabel());

        // // Validate Second Navigation
        List<NavItem> secondNav = header.getSecondNav();
        assertNotNull(secondNav);
        assertEquals(4, secondNav.size());
        assertEquals("Resources", secondNav.get(0).getLabel());

        // // Validate Flags
        List<FlagItem> flags = header.getFlag();
        assertNotNull(flags);
        assertEquals(2, flags.size());
        assertEquals("India", flags.get(0).getLogotitle());
    }

    @Test
    void testFlagItemModel() {
        context.currentResource("/component");
       
        DigiquadHeader header = context.request().adaptTo(DigiquadHeader.class);
        List<FlagItem> flag = header.getFlag();
        // Validate Flag Item
        assertNotNull(flag);
        assertEquals("India", flag.get(0).getLogotitle());
        assertEquals("/content/dam/icici/header-images/India-flag.svg", flag.get(0).getFile());
    }
    

    @Test   
    void testNavItemModel() {
        context.currentResource("/component");
        DigiquadHeader header = context.request().adaptTo(DigiquadHeader.class);
        List<NavItem> mainNav = header.getMainNav();
        // Validate Nav Item
        assertNotNull(mainNav);
        assertEquals("Personal", mainNav.get(0).getLabel());
        assertEquals("https://www.google.com", mainNav.get(0).getLinkPath());
    }




}
