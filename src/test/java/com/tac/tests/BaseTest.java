package com.tac.tests;

import com.tac.driver.DriverEngine;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public class BaseTest {

    @BeforeMethod
    public void setUp(Object[] data) {
        Map<String,String> map = (Map<String, String>) data[0];
        DriverEngine.initDriver(map.get("Browser"));
    }


    @AfterMethod
    public void tearDown(){
        DriverEngine.quitDriver();
    }

}
