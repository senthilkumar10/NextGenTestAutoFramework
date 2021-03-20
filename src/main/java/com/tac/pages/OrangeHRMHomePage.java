package com.tac.pages;

import com.tac.enums.WaitStrategy;
import com.tac.reports.ExtentLogger;
import com.tac.reports.ExtentReportManager;
import org.openqa.selenium.By;

public final class OrangeHRMHomePage extends BasePage {

    private final By linkWelcome = By.id("welcome");
    private final By linkLogout = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickLinkWelcome(){
        click(linkWelcome, WaitStrategy.CLICKABLE);
        ExtentLogger.pass("Successfully Clicked the link welcome");
        return this;
    }

    public OrangeHRMLoginPage clickLogout(){
        click(linkLogout, WaitStrategy.CLICKABLE);
        ExtentLogger.pass("Successfully Clicked the link logout");
        return new OrangeHRMLoginPage();
    }



}
