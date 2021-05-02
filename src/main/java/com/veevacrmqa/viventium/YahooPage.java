package com.veevacrmqa.viventium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YahooPage extends BasePage {
    private By linkLocators = By.tagName("a");
    private By searchFieldLocator = By.id("ybar-sbq");
    private By searchButtonLocator = By.id("ybar-search");

    public YahooPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getSearchField() {
        return driver.findElement(searchFieldLocator);
    }

    private WebElement getSearchButton() {
        return driver.findElement(searchButtonLocator);
    }

    public void search() {
        getSearchField();
        getSearchButton().click();
    }
}
