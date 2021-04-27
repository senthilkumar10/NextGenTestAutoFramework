package com.tac.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.tac.driver.DriverManager;
import com.tac.factories.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author senthil
 */
public class CheckBoxPage extends BasePage {

    private By checkboxXpath = By.xpath("//input[@type='checkbox']");
    private By entireTable = By.tagName("tr");


    public List<WebElement> allCheckboxElements() {
        return DriverManager.getDriver().findElements(checkboxXpath);
    }


    public void selectRows(Predicate<List<WebElement>> selectionCriteria) {
        DriverManager.getDriver().findElements(entireTable).stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td")))
                .filter(tdList -> tdList.size() == 4)
                .filter(selectionCriteria)
                .map(tdList -> tdList.get(3))
                .map(td -> td.findElement(By.tagName("input")))
                .forEach(WebElement::click);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);

    }


}
