package com.contrado.source;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BasePage {
    public static WebDriver driver;
    public static Logger logger = Logger.getLogger(BasePage.class);


    public void setLogFilePath(String path) {
        PropertyConfigurator.configure(path);
    }

    public static void browserSetup(String browser) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
        } else if (browser.equals("IEEdge")) {
            WebDriverManager.edgedriver().setup();
        } else if (browser.equals("Safari")) {
            WebDriverManager.safaridriver().setup();
        } else {
            logger.info("Browser not supported. Please choose from i)chrome ii)firefox iii)IEEdge or iv)Safari");
        }
    }

    public static void launchBrowser(String browser) {
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("IEEdge")) {
            driver = new EdgeDriver();
        } else if (browser.equals("Safari")) {
            driver = new SafariDriver();
        } else {
            logger.info("Browser not supported. Please choose from i)chrome ii)firefox iii)IEEdge or iv)Safari");
        }
        ConfigProperties.setDriverInstance(driver);
    }

    public static void openAppURL(String url) {
        driver.get(url);
        logger.info("Opened url " + url);
    }


    public static void ImplicitlyWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProperties.ImplicitWaitTimeoutDurationInSeconds));
    }

    public static void explicitlyWait(WebElement elementXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigProperties.ExplicitWaitTimeoutDurationInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(elementXpath));
    }

    public static void closeTab() {
        driver.close();
        logger.info("Tab closed");
    }

    public static void closeWindow() {
        driver.quit();
        logger.info("Window closed");
    }

    public abstract boolean isPageValid();

    public abstract boolean isPageLoaded();


}
