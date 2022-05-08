package com.contrado.source;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage extends BasePage {
    public WishlistPage() {
        WishlistPage.driver = ConfigProperties.getDriverInstance();
        PageFactory.initElements(WishlistPage.driver, this);
    }

    @FindBy(xpath = "//h1[@class='banner--page__title'][contains(text(),'Wishlist')]")
    private WebElement pageTitle;
    @FindBy(xpath = "//div[@class='card--image__price']")
    private WebElement wishListPrice;
    @FindBy(xpath = "//div[@class='card--image__title']")
    private WebElement wishListProduct;


    @Override
    public boolean isPageValid() {
        return pageTitle.isDisplayed();
    }

    @Override
    public boolean isPageLoaded() {
        return pageTitle.isDisplayed();
    }

    public String getWishListPrice() {
        return wishListPrice.getText().replace("FROM £", "").replace(".00", "");
    }

    public String getWishListProduct() {
        return wishListProduct.getText();
    }
}