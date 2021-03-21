package com.tac.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer {

    private int count = 0;
    private int retries = 1;


    @Override
    public boolean retry(ITestResult result) {
        boolean value = count<retries;
        count++;
        return value;
    }
}
