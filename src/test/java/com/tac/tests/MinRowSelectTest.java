package com.tac.tests;

import com.tac.customannotations.FrameworkAnnotations;
import com.tac.enums.CategoryType;
import com.tac.pages.MinPriceRowPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * @author senthil
 */
public class MinRowSelectTest extends BaseTest{

    @FrameworkAnnotations(Authors = {"Senthil","Kumar"},Catagories = {CategoryType.MINIREGRESSION,CategoryType.SMOKE})
    @Test
    public void testMinRowSelection(Map<String,String> data) {
        MinPriceRowPage minPriceRowPage = new MinPriceRowPage();
                minPriceRowPage.selectMinRow();
        String status = minPriceRowPage.getStatus();
        Assertions.assertThat(status)
                .isEqualTo("PASS");

    }


}
