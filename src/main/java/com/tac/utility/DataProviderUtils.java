package com.tac.utility;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {

    private static List<Map<String, String>> list = new ArrayList<>();

    @DataProvider
    public static Object[] getData(Method m){

        String testName = m.getName();

        if(list.isEmpty()){
            list = ExcelUtils.getTestExecutionDetails("TestData");
        }

        List<Map<String, String>> filteredList = new ArrayList<>();

        for(int i=0;i<list.size();i++){

            if(list.get(i).get("MethodName").equalsIgnoreCase(testName) &&
                    list.get(i).get("Execution Flag").equalsIgnoreCase("yes")){
                    filteredList.add(list.get(i));
            }

        }
        return filteredList.toArray();
    }
}
