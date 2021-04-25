package com.tac.driver;

import com.tac.factories.DriverFactory;
import com.tac.utility.ReadPropertyFile;

import java.util.Objects;

public final class DriverEngine {

    private DriverEngine() {}

    public static void initDriver(String browser){
        if(Objects.isNull(DriverManager.getDriver())){
            DriverManager.setDriver(DriverFactory.getDriver(browser));
            DriverManager.getDriver().get(ReadPropertyFile.getValue("url"));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }

    }


}
