package com.tac.pages;

import com.tac.driver.DriverManager;
import com.tac.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public final class AmazonHomePage extends BasePage {

    private By id = By.id("nav-hamburger-menu");
    private By links = By.tagName("a");

    public AmazonHamburgerMainMenuPage clickHamburger(){
        click(id, WaitStrategy.CLICKABLE,"Hamburger Link");
        return new AmazonHamburgerMainMenuPage();
    }

    public List<WebElement> fetchAllLinks(){
        return DriverManager.getDriver().findElements(links);
    }


}
