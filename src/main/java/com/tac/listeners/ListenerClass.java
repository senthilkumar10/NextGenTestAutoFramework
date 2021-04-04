package com.tac.listeners;

import com.tac.customannotations.FrameworkAnnotations;
import com.tac.reports.ExtentLogger;
import com.tac.reports.ExtentReport;
import com.tac.utility.ELKUtils;
import org.testng.*;

import java.io.IOException;
import java.util.Arrays;

public class ListenerClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createReport(result.getMethod().getMethodName());
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotations.class).Authors());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotations.class).Catagories());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is Passed");
        ELKUtils.sendDataToELK(result.getMethod().getDescription(),"pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " is Failed");
        ExtentLogger.fail(result.getThrowable().toString() + " is Failed");
        ELKUtils.sendDataToELK(result.getMethod().getDescription(),"fail");
        //ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace())+ " is Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is Skipped");
        ELKUtils.sendDataToELK(result.getMethod().getDescription(),"skip");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
