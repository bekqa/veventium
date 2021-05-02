package com.veevacrmqa.studio;

import com.veevacrmqa.viventium.SearchResultPage;
import com.veevacrmqa.viventium.YahooPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class YahooPageTest extends BaseTest{
    @Test
    public void testYahooPage() throws InterruptedException {
        driver.get("https://www.yahoo.com/");
        driver.manage().window().maximize();

        // Step 1. Assert that we are on the correct page by checking that title = 'Yahoo'
        assertEquals("Yahoo", driver.getTitle());

        // Step 2. Display the count of links under the search bar ('Mail', 'COVID-19', 'News', 'Finance', ...)
        // including 'More...' option
        List<WebElement> allTags = driver.findElements(By.tagName("a"));
        System.out.println("There are " + allTags.size() + " links on this page");

        // Step 3. Write an enhanced for-each loop that will print each of the links from step 2
        for(int i = 0; i < allTags.size(); i++){
            System.out.println(allTags.get(i).getAttribute("href"));
        }

        // Step 4. Enter 'New York City' in the search bar on the top
        driver.findElement(By.id("ybar-sbq")).sendKeys("New York City");

        // Step 5. Click Search button
        driver.findElement(By.id("ybar-search")).click();

        // Step 6. Set a 7 second explicit wait for the result of the search
        // Use an appropriate condition of your choice
        assertTrue(new SearchResultPage(driver).isLoaded());

        // Step 7. Click 'Sign In' button on the top right side
        //driver.findElement(By.className("text")).click();

        // Step 8. Display the boolean state of the checkbox next to 'Keep me signed in'
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='persistent']"));
        System.out.println("The boolean state of the checkbox is " + checkBox.getAttribute("value"));

        // Step 9. Create a logic that will uncheck the checkbox if it is checked
        Actions act=new Actions(driver);
        if (checkBox.isSelected()){
            act.moveToElement(checkBox).click().perform();
        }







    }
}
