package com.tac.listeners;

import com.tac.utility.ReadPropertyFile;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.yaml.snakeyaml.introspector.PropertyUtils;

public class RetryFailedTest implements IRetryAnalyzer {

    private int count = 0;
    private int retries = 1;


    @Override
    public boolean retry(ITestResult result) {
        boolean value = false;
        try {
            if(ReadPropertyFile.getValue("retryfailedtests").equalsIgnoreCase("yes")){
                value = count<retries;
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }
}
