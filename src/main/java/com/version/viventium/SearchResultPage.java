package com.version.viventium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends BasePage {
    private By topSearchField = By.id("yschsp");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(topSearchField)).isDisplayed();
    }
}
