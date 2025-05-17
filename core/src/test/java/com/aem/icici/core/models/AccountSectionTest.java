package com.aem.icici.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

@ExtendWith(AemContextExtension.class)
public class AccountSectionTest {

    final AemContext context = new AemContext();

    @BeforeEach
    void setUp(){

//        context.addModelsForClasses(AccountSectionModel.class);
        context.addModelsForClasses(AccountSectionModel.LinkItem.class);
        context.load().json("src/test/resources/accountSection/accountsection.json",
                "/component");
    }

    @Test
    void getLinksTest(){
        context.currentResource("/component/links/item0");
        AccountSectionModel.LinkItem model = context.currentResource().adaptTo(AccountSectionModel.LinkItem.class);

        Assertions.assertNotNull(model);

        Assertions.assertEquals("Sample1",model.getText());
    }


//    @Test
//    void getLinksTest(){
//        context.currentResource("/component");
//        AccountSectionModel model = context.currentResource().adaptTo(AccountSectionModel.class);
//        Assertions.assertNotNull(model);
//
//        List<AccountSectionModel.LinkItem> links =  model.getLinks();
//        Assertions.assertNotNull(links);
//
//        Assertions.assertEquals("Sample1",model.getLinks().get(0).getText());
//    }

}
