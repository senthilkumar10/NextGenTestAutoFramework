package com.tac.pages;

import com.tac.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage {

    private final By textboxUsername = By.id("txtUsername");
    private final By textboxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
    private final By buttonLogin = By.id("btnLogin");

    public OrangeHRMLoginPage enterUserName(String userName){
        enterText(textboxUsername,userName, WaitStrategy.PRESENCE,"User Name");
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password){
        enterText(textboxPassword,password,WaitStrategy.PRESENCE,"Password");
        return this;
    }

    public OrangeHRMHomePage clickLogin(){
        click(buttonLogin, WaitStrategy.CLICKABLE,"Login button");
        return new OrangeHRMHomePage();
    }

    public String getTitle(){
        return getPageTitle();
    }

}
