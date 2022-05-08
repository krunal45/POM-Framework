package com.contrado.source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SearchPage extends BasePage {
    public SearchPage() {
        SearchPage.driver = ConfigProperties.getDriverInstance();
        PageFactory.initElements(SearchPage.driver, this);
    }

    @FindBy(xpath = "//input[@qa-id='trueSearch']")
    private WebElement searchTextBoxElement;
    @FindBy(xpath = "//div[@class='card--image__title' and @meta-unique-id='PNW_1061']/../div[@data-price='@item.Price']")
    private WebElement kidsBasicTshirtFormPrice;
    @FindBy(xpath = "//div[@meta-unique-id='PNW_1061']")
    private WebElement kidsBasicTshirtLink;

    @Override
    public boolean isPageValid() {
        // TODO Auto-generated method stub
        return searchTextBoxElement.isDisplayed();
    }

    @Override
    public boolean isPageLoaded() {
        // TODO Auto-generated method stub
        return searchTextBoxElement.isDisplayed();
    }

    public void searchTshirt(String itemToSearch) {
        searchTextBoxElement.click();
        searchTextBoxElement.sendKeys(itemToSearch);
    }

    public String getKidsTshirtFormPrice() {
        explicitlyWait(kidsBasicTshirtFormPrice);
        return kidsBasicTshirtFormPrice.getText().replace("\n", "").replace("from£", "");
    }

    public void clickBasicTshirtLink() {
        explicitlyWait(kidsBasicTshirtLink);
        kidsBasicTshirtLink.click();
        logger.info("Clicked on basic T-shirt Link");
        ConfigProperties.setDriverInstance(SearchPage.driver);
    }

}
