package com.version.viventium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YahooPage extends BasePage {
    private By searchFieldLocator = By.id("ybar-sbq");
    private By searchButtonLocator = By.id("ybar-search");
    private By signInButtonLocator = By.className("text");

    public YahooPage(WebDriver driver) {
        super(driver);
    }

    public  void enterSearchValue(String value) {
        driver.findElement(searchFieldLocator).sendKeys(value);
    }

    public void clickSearchButton(){
        driver.findElement(searchButtonLocator).click();
    }
    public void clickSignInButton(){
        driver.findElement(signInButtonLocator).click();
    }
}
