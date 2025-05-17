package com.aem.icici.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.aem.icici.core.models.aboutUs.AboutUsModel;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
public class AboutUsTest {

    private final AemContext context = new AemContext();


    @BeforeEach
    void setUp(){
        context.addModelsForClasses(AboutUsModel.class);
        context.load().json("/aboutUs/aboutus.json", "/component");
    }

    @Test
    void getTitleTest() {
        context.currentResource("/component");
        AboutUsModel aboutUsModel = context.request().adaptTo(AboutUsModel.class);
        assertEquals("About Us", aboutUsModel.getTitle());

    }

    @Test
    void getBackgroundColorTest() {
        context.currentResource("/component");
        AboutUsModel aboutUsModel = context.request().adaptTo(AboutUsModel.class);
        assertEquals("#fff7eb", aboutUsModel.getBackgroundColor());
    }

    @Test
    void getCardParagraphTest() {
        context.currentResource("/component/content1");
        AboutUsModel aboutUsModel = context.request().adaptTo(AboutUsModel.class);
        assertEquals("ICICI Bank offers a wide range of banking products and financial services to corporate and retail customers through a variety of delivery channels and through its group companies.", 
                aboutUsModel.getParagraph());
    }

    @Test
    void getCardButtonTextTest() {
        context.currentResource("/component/content1");
        AboutUsModel aboutUsModel = context.request().adaptTo(AboutUsModel.class);
        assertEquals("KNOW MORE", aboutUsModel.getButtonText());
    }

    @Test
    void getCardButtonLinkTest() {
        context.currentResource("/component/content1");
        AboutUsModel aboutUsModel = context.request().adaptTo(AboutUsModel.class);
        assertEquals("https://www.google.com", aboutUsModel.getButtonLink());
    }

    @Test
    void getCardTitleSizeTest() {
        context.currentResource("/component/content1");
        AboutUsModel aboutUsModel = context.request().adaptTo(AboutUsModel.class);
        assertEquals("small", aboutUsModel.getTitleSize());
    }

    @Test
    void getCardTitleColorTest() {
        context.currentResource("/component/content1");
        AboutUsModel aboutUsModel = context.request().adaptTo(AboutUsModel.class);
        assertEquals("#111111", aboutUsModel.getTitleColor());
    }

    @Test
    void getCardParagraphSizeTest() {
        context.currentResource("/component/content1");
        AboutUsModel aboutUsModel = context.request().adaptTo(AboutUsModel.class);
        assertEquals("small", aboutUsModel.getParagraphSize());
    }

    @Test
    void getCardParagraphColorTest() {
        context.currentResource("/component/content1");
        AboutUsModel aboutUsModel = context.request().adaptTo(AboutUsModel.class);
        assertEquals("#AAAAAA", aboutUsModel.getParagraphColor());
    }

    @Test
    void getCardButtonStyleTest() {
        context.currentResource("/component/content1");
        AboutUsModel aboutUsModel = context.request().adaptTo(AboutUsModel.class);
        assertEquals("primary", aboutUsModel.getButtonStyle());
    }

    @Test
    void getCardButtonColorTest() {
        context.currentResource("/component/content1");
        AboutUsModel aboutUsModel = context.request().adaptTo(AboutUsModel.class);
        assertEquals("#FF851B", aboutUsModel.getButtonColor());
        assertNotNull(aboutUsModel);
        
    }

    @Test
    void getCardTitleTest() {
        context.currentResource("/component/content1");
        AboutUsModel aboutUsModel = context.request().adaptTo(AboutUsModel.class);
        assertEquals("ICICI Group Companies", aboutUsModel.getTitle());
    }
    
}
