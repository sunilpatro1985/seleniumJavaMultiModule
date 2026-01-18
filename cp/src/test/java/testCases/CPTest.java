package testCases;

import base.testUtils.BaseTest;
import org.testng.annotations.Test;
import base.driver.PageDriver;
import pages.HomePage;
import pages.ProductPage;

public class CPTest extends BaseTest {

    @Test
    public static void CPTest1() throws InterruptedException {
        HomePage homePage = new HomePage();
        ProductPage prodPage = new ProductPage();
        homePage.navigateToMenPage();
        System.out.println("current items count " + prodPage.getCurrentPageItems().size());
        //System.out.println(PageDriver.getCurrentDriver());
    }
}

