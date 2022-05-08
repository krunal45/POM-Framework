package com.contrado.source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailPage extends BasePage {
    public DetailPage() {
        DetailPage.driver = ConfigProperties.getDriverInstance();
        PageFactory.initElements(DetailPage.driver, this);
    }

    @FindBy(xpath = "//div[@class='product__info-price pricing']/span[@class='price-current']")
    private WebElement detailPagePriceElement;
    @FindBy(xpath = "//span[@id='js-wish-text']")
    private WebElement addToWishlistBTN;
    @FindBy(xpath = "//a[@id='wish-header']//*[name()='svg']")
    private WebElement wishListDetail;

    @Override
    public boolean isPageValid() {
        // TODO Auto-generated method stub
        return detailPagePriceElement.isDisplayed();
    }

    @Override
    public boolean isPageLoaded() {
        // TODO Auto-generated method stub
        return detailPagePriceElement.isDisplayed();
    }

    public String getDetailPagePrice() {
        return detailPagePriceElement.getText().replace("£", "").replace(".00", "");
    }

    public void clickAddToWishlistBTN() {
        addToWishlistBTN.click();
        logger.info("Clicked on add to wishlist Button");
    }

    public void addWishlistDetailBTN() {
        wishListDetail.click();
        logger.info("Clicked on wishlist Detail");
        ConfigProperties.setDriverInstance(DetailPage.driver);
    }
}
