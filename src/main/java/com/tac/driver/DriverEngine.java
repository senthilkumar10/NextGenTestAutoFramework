package com.tac.driver;

import com.tac.utility.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public final class DriverEngine {

    private DriverEngine() {
    }

    public static void initDriver(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            if (Objects.isNull(DriverManager.getDriver())) {
                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver(new ChromeDriver());

            }
        }else if(browser.equalsIgnoreCase("firefox")){
            if (Objects.isNull(DriverManager.getDriver())) {
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver(new FirefoxDriver());
            }
        }

        DriverManager.getDriver().get(ReadPropertyFile.getValue("url"));

    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }

    }


}
