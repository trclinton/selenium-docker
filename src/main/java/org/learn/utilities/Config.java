package org.learn.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class Config {
    private static final Logger log = LoggerFactory.getLogger(Config.class);
    private static final String DEFAULT_PROPERTIES = "config/default.properties";
    private static Properties properties;

    public static void initilize(){

        //load default properties
        properties = loadProperties();

        //check for any overrides
        Set<String> set = properties.stringPropertyNames();
        for(String key: set){
            if(System.getProperties().containsKey(key)){
                properties.setProperty(key, System.getProperty(key));
            }
        }

        //log
        log.info("Test Properties");
        for(String key: properties.stringPropertyNames()){
            log.info("{}={}", key, properties.getProperty(key));
        }
    }

    public static String get(String key){
        return properties.getProperty(key);
    }

    public static Properties loadProperties(){
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = ResourceLoader.getResourceAsStream(DEFAULT_PROPERTIES);
            properties.load(inputStream);
        } catch (IOException e) {
            log.error("unable to read the properties file {}", DEFAULT_PROPERTIES);
        }
        return properties;
    }
}
