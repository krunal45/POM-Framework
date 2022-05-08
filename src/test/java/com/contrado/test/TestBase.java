package com.contrado.test;

import org.testng.annotations.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.contrado.source.BasePage;
import com.contrado.source.ConfigProperties;
import com.contrado.source.HomePage;

public abstract class TestBase {
    public static Logger logger = Logger.getLogger(BasePage.class);

    public abstract void pageLaunchCheck();

    public abstract void verifyPageValid();

    @BeforeSuite
    @DataProvider
    public Object[][] inputData() throws Exception {
        Object[][] testData = ExcelUtility.getTableArray("src/test/resources/TestData/QA/InputData.xls", "Sheet1");
        return testData;
    }

    @AfterSuite
    public void tearDown() {
        BasePage.closeWindow();
        logger.info("Closed browser");
    }

}
