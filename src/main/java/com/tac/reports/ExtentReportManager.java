package com.tac.reports;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class ExtentReportManager {

    private ExtentReportManager(){}

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    static ExtentTest getExtentTest(){
        return extTest.get();
    }

    static void setExtentTest(ExtentTest test){
        if(Objects.nonNull(test)){
            extTest.set(test);
        }
    }

    static void unload(){
        extTest.remove();
    }



}
