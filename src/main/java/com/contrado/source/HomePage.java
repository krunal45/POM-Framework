package com.contrado.source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage() {
        browserSetup(ConfigProperties.browserName);
        launchBrowser(ConfigProperties.browserName);
        openAppURL(ConfigProperties.applicationUrl);
        HomePage.driver = ConfigProperties.getDriverInstance();
        PageFactory.initElements(HomePage.driver, this);
    }

    @FindBy(xpath = "//span[@class='search js-searchfield js-search-focus js-open-search']")
    private WebElement searchBTNElement;


    @Override
    public boolean isPageValid() {
        // TODO Auto-generated method stub
        return searchBTNElement.isDisplayed();
    }

    @Override
    public boolean isPageLoaded() {
        // TODO Auto-generated method stub
        return searchBTNElement.isDisplayed();
    }

    public void clickSearchBTN() {
        searchBTNElement.click();
        logger.info("Clicked on search button");
        ConfigProperties.setDriverInstance(HomePage.driver);
    }

    public void closePopUpWindow() {
        WebElement ele = driver.findElement(By.xpath("//span[@id='scloseWebsite']"));
        explicitlyWait(ele);
        ele.click();
    }


}
