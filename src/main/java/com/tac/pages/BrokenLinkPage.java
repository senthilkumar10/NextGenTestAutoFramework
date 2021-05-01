package com.tac.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.tac.driver.DriverManager;
import com.tac.utility.LinkUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author senthil
 */
public class BrokenLinkPage extends BasePage {

    private By srcXpath = By.xpath("//*[@src]");


    public List<Integer> allSrcLinksResponseCode() {

        return DriverManager.getDriver()
                .findElements(srcXpath)
                .stream()
                .map(e->e.getAttribute("src"))
                .map(src-> LinkUtils.getResponseCode(src))
                .collect(Collectors.toList());
    }

    public List<String> allSrcLinks() {

        return DriverManager.getDriver()
                .findElements(srcXpath)
                .stream()
                .map(e->e.getAttribute("src"))
                .collect(Collectors.toList());
    }





}
