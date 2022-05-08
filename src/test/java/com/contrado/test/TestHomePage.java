package com.contrado.test;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import com.contrado.source.*;

public class TestHomePage extends TestBase {
    HomePage homePage = new HomePage();

    @Override
    @BeforeTest
    public void pageLaunchCheck() {
        Assert.assertEquals(homePage.isPageLoaded(), true, "FAIL : Page not loaded!");
    }

    @Override
    @BeforeTest
    public void verifyPageValid() {
        Assert.assertEquals(homePage.isPageValid(), true, "FAIL : Page Invalid!");
    }

    @Test(priority = 1)
    public void clickSearch() {
        homePage.closePopUpWindow();
        homePage.clickSearchBTN();
    }


}
