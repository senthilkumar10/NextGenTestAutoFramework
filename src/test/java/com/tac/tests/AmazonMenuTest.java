package com.tac.tests;

import com.tac.customannotations.FrameworkAnnotations;
import com.tac.enums.CategoryType;
import com.tac.pages.AmazonHamburgerMainMenuPage;
import com.tac.pages.AmazonHomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public class AmazonMenuTest extends BaseTest{


    @FrameworkAnnotations(Authors = {"Senthil","Kumar"},Catagories = {CategoryType.MINIREGRESSION,CategoryType.SMOKE})
    @Test
    public void verifyBooksPageTitle(Map<String,String> data){
        String title =  new AmazonHomePage().clickHamburger()
         .clicklinkBooks().getTitle();

        Assertions.assertThat(title)
                .containsIgnoringCase(data.get("Title"));


    }

}
