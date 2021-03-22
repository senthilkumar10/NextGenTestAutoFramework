package com.tac.constants;

public final class FrameworkConstants {

    //Declaring the class as final so that no one can extend the class
    //Created a private constructor to prevent creating objects for this class


    private FrameworkConstants() {

    }

    private static final String CHROMEDRIVERPATH = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver";
    private static final String FIREFOXDRIVERPATH = System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver";
    private static final String CONFIGFILEPATH = "./config.properties";
    private static final String EXTENTREPORTPATH = "./extent-test-output";
    private static final String TESTEXECEXCELPATH = System.getProperty("user.dir") + "/src/test/resources/runmanager/TestData.xlsx";

    public static String getExtentreportpath() {
        return EXTENTREPORTPATH+"/TestReport_"+System.currentTimeMillis()+".html";
    }

    public static String getTestexecexcelpath() {
        return TESTEXECEXCELPATH;
    }

    public static int getEXPLICITWAIT() {
        return EXPLICITWAIT;
    }

    private static final int EXPLICITWAIT = 10;

    public static String getCHROMEDRIVERPATH() {
        return CHROMEDRIVERPATH;
    }

    public static String getFirefoxdriverpath() {
        return FIREFOXDRIVERPATH;
    }

    public static String getCONFIGFILEPATH() {
        return CONFIGFILEPATH;
    }
}
