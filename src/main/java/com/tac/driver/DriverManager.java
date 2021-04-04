package com.tac.driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class DriverManager {

    private DriverManager() {}

    public static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return dr.get();
    }

    static void setDriver(WebDriver driverRefer){
        if (Objects.nonNull(driverRefer)) {
            dr.set(driverRefer);
        }
    }

    static void unload(){
        dr.remove();
    }

}
