package com.tac.utility;

public final class DynamicXpathUtils {

    private DynamicXpathUtils(){}

    public static String clickOnSubMenuItem(String xpath, String menutext){
        return String.format(xpath, menutext);
    }

}
