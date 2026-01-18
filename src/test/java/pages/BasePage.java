package pages;

import base.driver.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    // Helper method to get wait dynamically for the current thread
    private WebDriverWait getWait() {
        return new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(20));
    }

    protected void click(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void type(By locator, String text) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    protected String getText(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public int size(By byLocator){
        return PageDriver.getCurrentDriver()
                .findElements(byLocator)
                .size();
    }

    public List<WebElement> getEls(By byLocator){
        return PageDriver.getCurrentDriver()
                .findElements(byLocator);
    }

    public void selectByOption(By byLocator, String option){
        Select select = new Select(PageDriver.getCurrentDriver().findElement(byLocator));
        select.selectByVisibleText(option);
    }

    public void waitForEl(By byLocator){
        getWait().until(ExpectedConditions.presenceOfElementLocated(byLocator));
    }

}
