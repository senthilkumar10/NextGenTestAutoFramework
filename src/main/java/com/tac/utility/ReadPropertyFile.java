package com.tac.utility;

import com.tac.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {

    private ReadPropertyFile() {

    }

    public static String getValue(String key) throws Exception {
        Properties property = new Properties();

        FileInputStream fis = new FileInputStream(FrameworkConstants.getCONFIGFILEPATH());
        property.load(fis);

        if (Objects.isNull(key) || Objects.isNull(property.getProperty(key))) {
            throw new Exception("Property name : " + key + " is not found. Please check config.properties file");
        }

        return property.getProperty(key);
    }

}
