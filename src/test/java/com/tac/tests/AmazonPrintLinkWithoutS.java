package com.tac.tests;

import com.tac.customannotations.FrameworkAnnotations;
import com.tac.enums.CategoryType;
import com.tac.pages.AmazonHomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author senthil
 */
public class AmazonPrintLinkWithoutS extends BaseTest{

    @FrameworkAnnotations(Authors = {"Senthil","Kumar"},Catagories = {CategoryType.MINIREGRESSION,CategoryType.SMOKE})
    @Test
    public void printLinksWithOutS(Map<String,String> data){
        List<WebElement> allLinks = new AmazonHomePage().fetchAllLinks();
        List<String> allLinkText = allLinks.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        Predicate<String> isBlank = ele->ele.trim().length()==0;
        allLinkText.removeIf(isBlank);
        allLinkText.forEach(System.out::println);


        Predicate<String> isContainsS = ele->ele.toLowerCase().trim().contains("s");
        allLinkText.removeIf(isContainsS);

        System.out.println();
        System.out.println("***** After Removing the Link Text contains 'S' || 's' ********");
        System.out.println();

        allLinkText.forEach(System.out::println);
    }

}
