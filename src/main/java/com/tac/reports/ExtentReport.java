package com.tac.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tac.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport(){}
    private static ExtentReports extent;

    public static void initReport(){
        if(Objects.isNull(extent)){
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentreportpath());

            //final File CONF = new File("./extentconfig.xml");
            //spark.loadXMLConfig(CONF);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("My Automation Report");
            spark.config().setReportName("Extent Report Demos");


            extent.attachReporter(spark);
        }

    }

    public static void flushReport(){
        if(Objects.nonNull(extent)){
            extent.flush();
        }
        ExtentReportManager.unload();
    }

    public static void createReport(String testcaseName){
        ExtentTest test = extent.createTest(testcaseName);
        ExtentReportManager.setExtentTest(test);
    }

    public static void addAuthors(String[] authors){
        for (String temp:authors) {
            ExtentReportManager.getExtentTest().assignAuthor(temp);
        }
    }

    public static void addCategories(Enum[] categories){
        for (Enum temp:categories) {
            ExtentReportManager.getExtentTest().assignCategory(temp.toString().toLowerCase());
        }
    }

}
