package com.tac.tests;

import com.tac.driver.DriverEngine;
import com.tac.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest {

    @BeforeMethod
    public void setUp() throws Exception {
        DriverEngine.initDriver();
    }


    @AfterMethod
    public void tearDown(){
        DriverEngine.quitDriver();
    }

    @AfterSuite
    public void afterSuite() throws IOException {
        ExtentReport.flushReport();
    }

}
