package com.aem.icici.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CarouselModel {

    private static final Logger logger = Logger.getLogger(CarouselModel.class.getName());

    @ValueMapValue
    private String carouselTitle;

    @ValueMapValue
    private boolean autoplay;

    @ValueMapValue
    private int autoplaySpeed;

    @ValueMapValue
    private boolean showNav;

    @ValueMapValue
    private boolean showDots;

    @ChildResource(name = "slides")
    private List<Resource> slides;

    private List<Slide> slideList;

    public String getCarouselTitle() {
        return carouselTitle;
    }

    public boolean isAutoplay() {
        return autoplay;
    }

    public int getAutoplaySpeed() {
        return autoplaySpeed;
    }

    public boolean isShowNav() {
        return showNav;
    }

    public boolean isShowDots() {
        return showDots;
    }

    public List<Slide> getSlideList() {
        return slideList;
    }

    public static class Slide {
        private final String slideImage;
        private final String slideTitle;
        private final String slideText;
        private final String socialIcon;

        public Slide(Resource resource) {
            this.slideImage = resource.getValueMap().get("slideImage", String.class);
            this.slideTitle = resource.getValueMap().get("slideTitle", String.class);
            this.slideText = resource.getValueMap().get("slideText", String.class);
            this.socialIcon = resource.getValueMap().get("socialIcon", String.class);
        }

        public String getSlideImage() {
            return slideImage;
        }

        public String getSlideTitle() {
            return slideTitle;
        }

        public String getSlideText() {
            return slideText;
        }

        public String getSocialIcon() {
            return socialIcon;
        }
    }

    @PostConstruct
    protected void init() {
        if (slides != null && !slides.isEmpty()) {
            slideList = slides.stream()
                    .map(Slide::new)
                    .collect(Collectors.toList());
        } else {
            slideList = List.of(); // Initialize as an empty list to avoid null pointer exceptions
            logger.info("No slides found for the carousel.");
        }
    }
}