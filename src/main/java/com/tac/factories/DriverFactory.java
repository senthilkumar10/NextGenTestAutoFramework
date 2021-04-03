package com.tac.factories;

import com.tac.driver.DriverManager;
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

/**
 * @author senthil
 */
public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver getDriver(String browser) throws MalformedURLException {
        WebDriver driver = null;
        String runmode = ReadPropertyFile.getValue("runmode");

        if (browser.equalsIgnoreCase("chrome")) {
            if (runmode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.CHROME);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            if (runmode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.FIREFOX);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }

}
