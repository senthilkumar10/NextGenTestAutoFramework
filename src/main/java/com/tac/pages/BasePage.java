package com.tac.pages;

import com.tac.driver.DriverManager;
import com.tac.enums.WaitStrategy;
import com.tac.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;


public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by).click();
    }

    protected void enterText(By by, String value,WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by).sendKeys(value);
    }

    protected String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }

}
