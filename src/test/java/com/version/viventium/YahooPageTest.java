package com.version.viventium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class YahooPageTest extends BaseTest{

    @Test
    public void testYahooPage()  {
        YahooPage yp = new YahooPage(driver);
        driver.get("https://www.yahoo.com/");
        driver.manage().window().maximize();

        // Step 1. Assert that we are on the correct page by checking that title = 'Yahoo'
        assertEquals("Yahoo", driver.getTitle());

        // Step 2. Display the count of links under the search bar ('Mail', 'COVID-19', 'News', 'Finance', ...)
        // including 'More...' option
        List<WebElement> allTags = driver.findElements(By.cssSelector("ul[role='presentation'] li a"));
        System.out.println("There are " + allTags.size() + " links on this page");

        // Step 3. Write an enhanced for-each loop that will print each of the links from step 2
        for(int i = 0; i < allTags.size(); i++){
            System.out.println(allTags.get(i).getAttribute("href"));
        }

        // Step 4. Enter 'New York City' in the search bar on the top
        yp.enterSearchValue("New York City"); //You can enter any string to search

        // Step 5. Click Search button
        yp.clickSearchButton();

        // Step 6. Set a 7 second explicit wait for the result of the search
        // Use an appropriate condition of your choice
        assertTrue(new SearchResultPage(driver).isLoaded());

        // Step 7. Click 'Sign In' button on the top right side
        yp.clickSignInButton();

        // Step 8. Display the boolean state of the checkbox next to 'Keep me signed in'
        WebElement checkBox = driver.findElement(By.cssSelector("#persistent"));
        System.out.println("The boolean state of the checkbox is " + checkBox.getAttribute("value"));

        // Step 9. Create a logic that will uncheck the checkbox if it is checked
        if (checkBox.isSelected()){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",checkBox);
        }
    }
}
