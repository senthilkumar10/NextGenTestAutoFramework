package com.tac.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.tac.driver.DriverManager;
import com.tac.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author senthil
 */
public class MinPriceRowPage extends BasePage{

    private By tableRow = By.xpath("//*[@id='prods']//tr");
    private By verifyBtn = By.id("result");
    private By statusLabel = By.id("status");

    public void selectMinRow(){
        List<WebElement> allRows = DriverManager.getDriver().findElements(tableRow);

        Optional<List<WebElement>> td = allRows.stream()
                .skip(1)
                .map(x -> x.findElements(By.tagName("td")))
                .min(Comparator.comparing(tdList -> Integer.parseInt(tdList.get(2).getText())));

        if(td.isPresent()){
            List<WebElement> elements = td.get();
            elements.get(3).findElement(By.tagName("input")).click();
        }

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    public void clickVerifyBtn(){
        click(verifyBtn, WaitStrategy.CLICKABLE,"Verify Button");
    }

    public String getStatus(){
        clickVerifyBtn();
        return DriverManager.getDriver().findElement(statusLabel).getText();
    }

}
