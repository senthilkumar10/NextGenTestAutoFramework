package com.tac.tests;

import com.tac.pages.OrangeHRMLoginPage;
import com.tac.reports.ExtentReport;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest {

    @Test(dataProvider="LoginPageTestData")
    public void loginLogoutTest(String userName,String Password) {

        ExtentReport.createReport("Login Logout");

        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage();

        String title = loginPage
                .enterUserName(userName).enterPassword(Password).clickLogin()
                .clickLinkWelcome().clickLogout().getTitle();

        Assertions.assertThat(title).containsIgnoringCase("OrangeHRM");

    }


    @DataProvider(name = "LoginPageTestData",parallel = true)
    public Object[][] getTestData(){
        return new Object[][]{
                {"Admin","admin123"},
                {"Admin","admin123"}
        };
    }

}
