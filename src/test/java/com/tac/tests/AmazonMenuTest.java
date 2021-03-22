package com.tac.tests;

import com.tac.pages.AmazonHamburgerMainMenuPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class AmazonMenuTest extends BaseTest{



    @Test
    public void verifyBooksPageTitle(){
        AmazonHamburgerMainMenuPage hamburgerMainMenuPage = new AmazonHamburgerMainMenuPage();
        String title =  hamburgerMainMenuPage.clicklinkBooks().getTitle();

        Assertions.assertThat(title)
                .containsIgnoringCase("Books");


    }

}
