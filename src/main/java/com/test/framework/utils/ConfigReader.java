package com.test.framework.utils;

import com.test.framework.commons.Settings;
import com.test.framework.selenium.base.BrowserType;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private String currentDirectory = System.getProperty("user.dir");
    private static String filePath = "/src/test/java/configs/config.properties";

    public static void setUpSettings() throws IOException {
        ConfigReader configReader = new ConfigReader();
        configReader.readProperty();
    }

    private void readProperty() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream(currentDirectory + filePath);
        properties.load(inputStream);
        Settings.baseURL = properties.getProperty("base.url");
        Settings.browserType = BrowserType.valueOf(properties.getProperty("browser.type"));
        Settings.gridURL = properties.getProperty("selenium.grid.url");
    }


}
