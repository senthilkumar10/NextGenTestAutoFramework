package com.tac.pages;

import com.tac.driver.DriverManager;
import com.tac.enums.WaitStrategy;
import com.tac.factories.ExplicitWaitFactory;
import com.tac.reports.ExtentLogger;
import org.openqa.selenium.By;


public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy, String eleName){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by).click();
        ExtentLogger.pass(eleName + " is Clicked");
    }

    protected void enterText(By by, String value,WaitStrategy waitStrategy, String eleName){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by).sendKeys(value);
        ExtentLogger.pass(value +" is successfully entered in "+ eleName);
    }

    protected String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }

}
