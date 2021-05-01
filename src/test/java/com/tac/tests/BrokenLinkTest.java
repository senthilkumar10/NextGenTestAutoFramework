package com.tac.tests;

import com.tac.customannotations.FrameworkAnnotations;
import com.tac.enums.CategoryType;
import com.tac.pages.AmazonHomePage;
import com.tac.pages.BrokenLinkPage;
import com.tac.utility.LinkUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author senthil
 *
 * URL - https://the-internet.herokuapp.com/broken_images
 *
 */
public class BrokenLinkTest extends BaseTest{

    @FrameworkAnnotations(Authors = {"Senthil","Kumar"},Catagories = {CategoryType.MINIREGRESSION,CategoryType.SMOKE})
    @Test
    public void checkBrokenLinks(Map<String,String> data) {
        List<String> allSRCLinks = new BrokenLinkPage().allSrcLinks();

        allSRCLinks.stream()
                .forEach(
                       s-> System.out.println(LinkUtils.getResponseCode(s) + " :: "+s)
                );


    }

}
