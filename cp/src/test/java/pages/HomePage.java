package pages;

import base.driver.PageDriver;
import base.pages.BasePage;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class HomePage extends BasePage {
            //By menu_Shop = By.xpath("//span[contains(text(),'Shop')]");
            By menu_Shop = By.xpath("(//span[contains(text(),'Shop')])[1]");

            By closeButton = By.xpath("//div[text()='x' and contains(@class, 'right-3')]");

            By ignoreBtn = By.id("onetrust-close-btn-container");

    By captcha = By.className("recaptcha-checkbox-checkmark");

            public void navigateToMenPage() throws InterruptedException {
                //click(captcha);
                waitForPageLoad();
                Thread.sleep(2000);
                click(closeButton);
                Thread.sleep(1000);
                click(ignoreBtn);
                Thread.sleep(2000);
                click(menu_Shop);
                ArrayList<String> tabs = new ArrayList<String>(PageDriver.getCurrentDriver().getWindowHandles());
                PageDriver.getCurrentDriver().switchTo().window(tabs.get(1)); // Switch to the new tab

                Thread.sleep(2000);

            }




}
