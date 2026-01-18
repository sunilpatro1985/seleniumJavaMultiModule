package pages;

import base.driver.PageDriver;
import base.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage {

    By shop_mens = By.linkText("Men");
    By productItems = By.cssSelector(".product-card.row");
    public List<WebElement> getCurrentPageItems(){
        // Wait for product cards to load
        waitForEls(productItems);

        // List all items on the current page
        return PageDriver.getCurrentDriver().findElements(productItems);
    }

    public void listAllItemsAcrossPages() {

        int pageCounter = 1;
        boolean hasNextPage = true;

        while (hasNextPage) {
            System.out.println("--- Scraping Page: " + pageCounter + " ---");


            for (WebElement product : getCurrentPageItems()) {
                try {
                    // Adjust selectors based on actual DOM (Commonly .product-card-title and .price-card)
                    String name = product.findElement(By.cssSelector(".product-card-title")).getText();
                    String price = product.findElement(By.cssSelector(".price-card")).getText();
                    System.out.println("Item: " + name + " | Price: " + price);
                } catch (NoSuchElementException e) {
                    // Fallback for different card structures
                }
            }

            // Check for Pagination - Find the "Next Page" arrow/button
            try {
                // Selector for the Next Page button (usually an 'aria-label' or specific class)
                WebElement nextButton = PageDriver.getCurrentDriver().findElement(By.xpath("//a[@aria-label='next page']"));

                if (nextButton.isDisplayed() && nextButton.isEnabled()) {
                    ((JavascriptExecutor) PageDriver.getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", nextButton);
                    nextButton.click();
                    pageCounter++;
                    // Short sleep or wait for URL change to ensure page transition
                    Thread.sleep(2000);
                } else {
                    hasNextPage = false;
                }
            } catch (Exception e) {
                System.out.println("No more pages found or error navigating.");
                hasNextPage = false;
            }
        }
    }


}
