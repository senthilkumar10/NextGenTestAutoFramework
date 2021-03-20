package com.tac.tests;

import com.tac.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void test1(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium Test Automation", Keys.ENTER);
    }

}
