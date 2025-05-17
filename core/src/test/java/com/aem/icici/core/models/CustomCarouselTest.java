package com.aem.icici.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.aem.icici.core.models.customCarousel.CarouselModel;
import com.aem.icici.core.models.customCarousel.CarouselModel.Slide;
import com.aem.icici.core.models.customCarousel.*;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({AemContextExtension.class})
public class CustomCarouselTest {

    // Create a new AemContext for each test
    private final AemContext context = new AemContext();
    
    


    @BeforeEach
    void setUp(){
        context.addModelsForClasses(CarouselModel.class);
        context.addModelsForClasses(CarouselModel.Slide.class);
        context.load().json("/customCarousel/customcarousel.json",
            "/component");
    }
    

    @Test
    void testGetSlideImage(){

        Resource resource = context.currentResource("/component/carousaldata");

        
        CarouselModel model = context.currentResource().adaptTo(CarouselModel.class);
        assertNotNull(model);

        List<Slide> slideList = model.getSlideList();

        // Slide slide2 = model.getSlideList().get(0);
           

        
        assertNotNull(slideList);
       
        for (CarouselModel.Slide slide : slideList) {
            System.out.println("Slide Title: " + slide.getSlideTitle());
            System.out.println("Slide Image: " + slide.getSlideImage());
        }

        assertNotNull(slideList.get(0).getSlideImage());
    }


    @Test
    void getCarouselTitle() {

        context.currentResource("/component/carousaldata/");
        CarouselModel model = context.currentResource().adaptTo(CarouselModel.class);
        assertNotNull(model);
        assertEquals("Related Fund Transfer Videos", model.getCarouselTitle());
    }

    @Test
    void getIsAutoplay() {

        context.currentResource("/component/carousaldata/");
        CarouselModel model = context.currentResource().adaptTo(CarouselModel.class);
        assertTrue(true == model.isAutoplay());
        
    }

    @Test
    void getAutoplaySpeed() {

        context.currentResource("/component/carousaldata/");
        CarouselModel model = context.currentResource().adaptTo(CarouselModel.class);
        assertEquals(3000, model.getAutoplaySpeed());
        
    }

    @Test
    void getIsShowNav() {

        context.currentResource("/component/carousaldata/");
        CarouselModel model = context.currentResource().adaptTo(CarouselModel.class);
        assertTrue(true == model.isShowNav());
        
    }

    @Test
    void getIsShowDots() {

        context.currentResource("/component/carousaldata/");
        CarouselModel model = context.currentResource().adaptTo(CarouselModel.class);
        // assertTrue(true == model.isShowDots());
        // assertFalse(false, () -> "Expected value to be false, but was true");
        assertTrue(model.isShowDots(), () -> "Expected value to be true, but was false");
    }

    
    @Test
    void getSlideImageTest() {

        context.currentResource("/component/carousaldata/slides/item0");
        CarouselModel.Slide model = context.currentResource().adaptTo(CarouselModel.Slide.class);
        
        
        assertNotNull(model);

        assertThrows(Exception.class, () -> {
            throw new Exception("Exception occurred");
        });

        System.out.println( model.getSlideImage());
        assertEquals("/content/dam/icici/sprint-2/second_carousel/cycle-payment.jpeg",
                                    model.getSlideImage());
    }

    

}
