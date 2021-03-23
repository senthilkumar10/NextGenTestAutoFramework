package com.tac.utility;

import com.tac.constants.FrameworkConstants;
import com.tac.customexceptions.FrameworkExceptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {

    private ReadPropertyFile() {}

    public static String getValue(String key) {
        Properties property = new Properties();

        try(FileInputStream fis =  new FileInputStream(FrameworkConstants.getCONFIGFILEPATH())) {
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (Objects.isNull(key) || Objects.isNull(property.getProperty(key))) {
            throw new FrameworkExceptions("Property name : " + key + " is not found. Please check config.properties file");
        }

        return property.getProperty(key);
    }

}
