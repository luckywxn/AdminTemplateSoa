package com.strongculture.service.common.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
    public static String get(String key){
        Properties prop = new Properties();
        try{
            InputStream in=PropertiesUtils.class.getClassLoader().getResourceAsStream("application.properties");
            prop.load(in);
            return prop.getProperty(key);
        }catch (Exception err){
            err.printStackTrace();
        }
        return null;
    }
}
