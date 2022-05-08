package com.contrado.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.contrado.source.ProjectConstants;
import com.contrado.source.SearchPage;

public class TestSearchPage extends TestBase {
    SearchPage searchPage = new SearchPage();

    @Override
    @BeforeTest
    public void pageLaunchCheck() {
        Assert.assertEquals(searchPage.isPageLoaded(), true, "FAIL: Page not loaded");
    }

    @Override
    @BeforeTest
    public void verifyPageValid() {
        Assert.assertEquals(searchPage.isPageValid(), true, "FAIL : Page Invalid");
    }


    @Test(priority = 1, dataProvider = "inputData")
    public void searchProduct(String searchTerm) {
        searchPage.searchTshirt(searchTerm);
    }

    @Test(priority = 2, dependsOnMethods = "searchProduct")
    public void getFormProductPrice() {
//        TestBase.formPrice = Integer.parseInt(searchPage.getKidsTshirtFormPrice());
        int price = Integer.parseInt(searchPage.getKidsTshirtFormPrice());
        ProjectConstants.setFormProductPrice(price);
    }

    @Test(priority = 3)
    public void clickProductLink() {
        searchPage.clickBasicTshirtLink();
    }
}