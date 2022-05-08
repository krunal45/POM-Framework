package com.contrado.source;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ConfigProperties {
    public static String browserName;
    public static String applicationEnvironment;
    public static String applicationUrl;
    public static int ExplicitWaitTimeoutDurationInSeconds;
    public static int ImplicitWaitTimeoutDurationInSeconds;
    public static WebDriver driver;

    static {
        try {
            FileUtil.loadPropertiesFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        browserName = FileUtil.getProperty("browserName");
        applicationEnvironment = FileUtil.getProperty("applicationEnvironment");
        applicationUrl = FileUtil.getProperty("applicationUrl");
        ExplicitWaitTimeoutDurationInSeconds = Integer.parseInt(FileUtil.getProperty("ExplicitWaitTimeoutDurationInSeconds"));
        ImplicitWaitTimeoutDurationInSeconds = Integer.parseInt(FileUtil.getProperty("ImplicitWaitTimeoutDurationInSeconds"));
    }

    public static void setDriverInstance(WebDriver driver) {
        ConfigProperties.driver = driver;
    }

    public static WebDriver getDriverInstance() {
        return ConfigProperties.driver;
    }

}
