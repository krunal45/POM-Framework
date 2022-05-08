package com.contrado.test;

import com.contrado.source.ProjectConstants;
import com.contrado.source.WishlistPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWishlistPage extends TestBase {
    WishlistPage wishlistPage = new WishlistPage();

    @Override
    public void pageLaunchCheck() {
        Assert.assertEquals(wishlistPage.isPageLoaded(), true, "FAIL : Page not loaded");
    }

    @Override
    public void verifyPageValid() {
        Assert.assertEquals(wishlistPage.isPageValid(), true, "FAIL: Page invalid!");
    }

    @Test(priority = 1)
    public void verifyProductName() {
        Assert.assertEquals(wishlistPage.getWishListProduct(), "KIDS BASIC T-SHIRT", "FAIL : Product Name do not match!");
    }

    @Test(priority = 2)
    public void verifyProductPrice() {
        Assert.assertEquals(Integer.parseInt(wishlistPage.getWishListPrice()), ProjectConstants.getDetailProductPrice(), "FAIL : Wishlist product price do not match");
    }
}
