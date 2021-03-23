package com.tac.factories;

import com.tac.constants.FrameworkConstants;
import com.tac.driver.DriverManager;
import com.tac.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class ExplicitWaitFactory {

    private ExplicitWaitFactory(){}

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {
        WebElement ele = null;
        if (waitStrategy == WaitStrategy.CLICKABLE) {
            ele = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getEXPLICITWAIT())
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            ele = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getEXPLICITWAIT())
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            ele = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getEXPLICITWAIT())
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.NONE) {
            ele = DriverManager.getDriver().findElement(by);
        }
        return ele;
    }
}
