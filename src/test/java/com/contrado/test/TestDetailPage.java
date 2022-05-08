package com.contrado.test;

import com.contrado.source.BasePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.contrado.source.DetailPage;
import com.contrado.source.ProjectConstants;

public class TestDetailPage extends TestBase {
    DetailPage detailPage = new DetailPage();


    @Override
    public void pageLaunchCheck() {
        Assert.assertEquals(detailPage.isPageLoaded(), true, "FAIL : Page not loaded");
    }

    @Override
    public void verifyPageValid() {
        Assert.assertEquals(detailPage.isPageValid(), true, "FAIL: Page invalid!");
    }

    @Test(priority = 1)
    public void getDetailProductPrice() {
//        TestBase.detailPrice = Integer.parseInt(detailPage.getDetailPagePrice());
        int price = Integer.parseInt(detailPage.getDetailPagePrice());
        ProjectConstants.setDetailProductPrice(price);
    }

    @Test(priority = 2)
    public void comparePrice() {
        Assert.assertEquals(ProjectConstants.getFormProductPrice(), ProjectConstants.getDetailProductPrice(),
                "FAIL : Form and Detail product price mismatch!");
    }

    @Test(priority = 3)
    public void clickAddToWishListBTN() {
        detailPage.clickAddToWishlistBTN();
        detailPage.addWishlistDetailBTN();
    }


}
