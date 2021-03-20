package com.tac.tests;

import com.tac.driver.DriverEngine;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() throws Exception {
        DriverEngine.initDriver();
    }


    @AfterMethod
    public void tearDown(){
        DriverEngine.quitDriver();
    }

}
