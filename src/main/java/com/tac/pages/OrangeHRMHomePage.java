package com.tac.pages;

import com.tac.enums.WaitStrategy;
import com.tac.reports.ExtentLogger;
import com.tac.reports.ExtentReportManager;
import org.openqa.selenium.By;

public final class OrangeHRMHomePage extends BasePage {

    private final By linkWelcome = By.id("welcome");
    private final By linkLogout = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickLinkWelcome(){
        click(linkWelcome, WaitStrategy.CLICKABLE, "Link Welcome");
        return this;
    }

    public OrangeHRMLoginPage clickLogout(){
        click(linkLogout, WaitStrategy.CLICKABLE, "Link Logout");
        return new OrangeHRMLoginPage();
    }



}
