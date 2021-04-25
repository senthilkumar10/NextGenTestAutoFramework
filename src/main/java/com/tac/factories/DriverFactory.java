package com.tac.factories;

import com.tac.utility.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author senthil
 */
public final class DriverFactory {

    private DriverFactory() {}

    private static WebDriver driver = null;
    private static String runmode = ReadPropertyFile.getValue("runmode");
    private static String seleniumGridURL = ReadPropertyFile.getValue("seleniumgridurl");


    private static final Supplier<WebDriver> chromeSupplier = () -> {
        if (runmode.equalsIgnoreCase("remote")) {
            driver = chromeRemoteDesiredCapabilities();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    };

    private static final Supplier<WebDriver> firefoxSupplier = () -> {
        if (runmode.equalsIgnoreCase("remote")) {
            driver = firefoxRemoteDesiredCapabilities();
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    };

    private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();

    static {
        MAP.put("chrome", chromeSupplier);
        MAP.put("firefox", firefoxSupplier);
    }


    public static WebDriver getDriver(String browser) {
        return MAP.get(browser).get();
    }

    private static WebDriver chromeRemoteDesiredCapabilities() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName(BrowserType.CHROME);
        try {
            driver = new RemoteWebDriver(new URL(seleniumGridURL), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    private static WebDriver firefoxRemoteDesiredCapabilities() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName(BrowserType.FIREFOX);
        try {
            driver = new RemoteWebDriver(new URL(seleniumGridURL), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

}
