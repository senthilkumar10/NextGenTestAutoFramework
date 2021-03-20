package com.tac.reports;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public final class ExtentReportManager {

    private ExtentReportManager(){}

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    protected static ExtentTest getExtentTest(){
        return extTest.get();
    }

    protected static void setExtentTest(ExtentTest test){
        extTest.set(test);
    }

    protected static void unload(){
        extTest.remove();
    }



}
