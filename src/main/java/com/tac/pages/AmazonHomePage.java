package com.tac.pages;

import com.tac.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class AmazonHomePage extends BasePage {

    private By id = By.id("nav-hamburger-menu");

    public AmazonHamburgerMainMenuPage clickHamburger(){
        click(id, WaitStrategy.CLICKABLE,"Hamburger Link");
        return new AmazonHamburgerMainMenuPage();
    }



}
