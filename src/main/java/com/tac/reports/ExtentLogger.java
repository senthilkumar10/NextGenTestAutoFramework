package com.tac.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tac.utility.ScreenshotUtil;

public final class ExtentLogger {

    private ExtentLogger(){}

    public static void pass(String message){
        ExtentReportManager.getExtentTest().pass(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getBase64Image()).build());
    }

    public static void fail(String message){
        ExtentReportManager.getExtentTest().fail(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getBase64Image()).build());
    }

    public static void skip(String message){
        ExtentReportManager.getExtentTest().skip(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getBase64Image()).build());
    }



}
