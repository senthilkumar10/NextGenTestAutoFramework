package com.tac.tests;

import com.tac.driver.DriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends BaseTest{

    /*
        Validate whether title is containing Google Search or google search
        Validate whether the title is not null and length of title is >15 and <100
        Number of links displayed should be 10 or 15
        Check for the links in the pages --> Automation Rocks
     */


    @Test
    public void googleSearchTest(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation Rocks", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();

          /*
        Assert.assertTrue(Objects.nonNull(title),"Title is Null");
        Assert.assertTrue(title.toLowerCase().contains("google search"));
        Assert.assertTrue(title.toLowerCase().matches("\\w.*"+"google search"));
        Assert.assertTrue(title.length() >15);
        Assert.assertTrue(title.length() <100);
         */

        Assertions.assertThat(title.toLowerCase())
                .isNotNull()
                .containsIgnoringCase("google search")
                .matches("\\w.*"+"google search")
                .hasSizeBetween(15,100);


        List<WebElement> ele = DriverManager.getDriver().findElements(By.xpath("//h3/span"));
        /*
        Assert.assertEquals(ele.size(),9);

        boolean isElementFound = false;
        for(WebElement element : ele){
            if (element.getText().toLowerCase().contains("automation rocks")){
                isElementFound = true;
                break;
            }
        }

        Assert.assertTrue(isElementFound,"Automation Rocks not found");

         */

        Assertions.assertThat(ele)
                .hasSize(9)
                .filteredOn(e->e.getText().toLowerCase().contains("automation rocks"));

    }
}
