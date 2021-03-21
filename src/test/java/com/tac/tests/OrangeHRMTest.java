package com.tac.tests;

import com.tac.listeners.RetryFailedTest;
import com.tac.pages.OrangeHRMLoginPage;
import com.tac.utility.DataProviderUtils;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public class OrangeHRMTest extends BaseTest {

    @Test
    public void loginLogoutTest(Map<String,String> data) {

        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage();

        String title = loginPage
                .enterUserName(data.get("userName")).enterPassword(data.get("Password")).clickLogin()
                .clickLinkWelcome().clickLogout().getTitle();

        Assertions.assertThat(title).containsIgnoringCase("OrangeHRM");

    }

    @Test
    public void newTest(Map<String,String> data) {

        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage();

        String title = loginPage
                .enterUserName(data.get("userName")).enterPassword(data.get("Password")).clickLogin()
                .clickLinkWelcome().clickLogout().getTitle();

        Assertions.assertThat(title).containsIgnoringCase("OrangeHRM");

    }

}
