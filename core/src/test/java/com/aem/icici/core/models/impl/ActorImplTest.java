package com.aem.icici.core.models.impl;

import com.aem.icici.core.models.Actor;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class ActorImplTest {

    private final AemContext context = new AemContext();

    Actor actor;

    @BeforeEach
    void setUp()
    {
        context.addModelsForClasses(ActorImpl.class);
        context.load().json("src/test/resources/actor.json","/component");
        context.load().json("src/test/resources/page.json","/page");
    }

    @Test
    void getBooks() {
        context.currentResource("/component/actor/");
        actor = context.request().adaptTo(Actor.class);

        assertEquals(4,actor.getBooks().size());
        assertEquals("AEM",actor.getBooks().get(3));

    }

    @Test
    void getNullBooksTest()
    {
        context.currentResource("/component/actor-empty-books");
        actor = context.request().adaptTo(Actor.class);

        assertEquals(0,actor.getBooks().size());
    }

    @Test
    void getFirstName() {
        final String expected = "AEM";
        actor = context.request().adaptTo(Actor.class);
        String actual = actor.getFirstName();
        context.currentResource("/component/actor");

        assertEquals(expected,actual);
    }

    @Test
    void getLastName() {
        final String expected = "GEEKS";
        actor = context.request().adaptTo(Actor.class);
        String actual = actor.getLastName();
        context.currentResource("/component/actor");

        assertEquals(expected,actual);
    }

    @Test
    void getIsProfessor() {
        context.currentResource("/component/actor");
        actor = context.request().adaptTo(Actor.class);
        assertEquals(false,actor.getIsProfessor());

    }

    @Test
    void getPageTitle() {
        context.currentPage("/page/currentPage");
        actor = context.request().adaptTo(Actor.class);
//        assertNull(actor);


        assertEquals("Author Bio",actor.getTitle());
    }

    @Test
    void getRequestAttribute() {
    }

    @Test
    void getHomePageName() {
    }

    @Test
    void getLastModifiedBy() {
    }

    @Test
    void authorName() {
    }

    @Test
    void getBookDetailsWithMap() {
        Resource resource = context.currentResource("/component/actor");
        actor = context.request().adaptTo(Actor.class);

        assertEquals(2, actor.getBookDetailsWithMap().size());
        assertEquals("2000",actor.getBookDetailsWithMap().get(0).get("publishyear"));
//        assertThrows(Exception.class, () ->  {
//            actor.getBookDetailsWithMap();
//        });

    }


}