package com.tac.tests;

import com.tac.customannotations.FrameworkAnnotations;
import com.tac.enums.CategoryType;
import com.tac.pages.CheckBoxPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @author senthil
 */
public class CheckBoxFunctionalProg extends BaseTest{

    @FrameworkAnnotations(Authors = {"Senthil","Kumar"},Catagories = {CategoryType.MINIREGRESSION,CategoryType.SMOKE})
    @Test
    public void testCheckBox(Map<String,String> data){
        List<WebElement> allLinks = new CheckBoxPage().allCheckboxElements();

        //Select all checkbox
        allLinks.stream()
                .forEach(ele->ele.click());

        //Unselect all checkbox
        allLinks.stream()
                .forEach(ele->ele.click());

        Predicate<List<WebElement>> allMale = tdList -> tdList.get(1).getText().equalsIgnoreCase("male");
        Predicate<List<WebElement>> allFemale = tdList -> tdList.get(1).getText().equalsIgnoreCase("female");
        Predicate<List<WebElement>> allGender = allMale.or(allFemale);
        Predicate<List<WebElement>> allAu = tdList -> tdList.get(2).getText().equalsIgnoreCase("au");
        Predicate<List<WebElement>> allFemaleAU = allFemale.and(allAu);

        CheckBoxPage checkBoxPage = new CheckBoxPage();

        checkBoxPage.selectRows(allMale);
        checkBoxPage.selectRows(allFemale);
        checkBoxPage.selectRows(allGender);
        checkBoxPage.selectRows(allAu);
        checkBoxPage.selectRows(allFemaleAU);



    }



}
