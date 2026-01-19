package testCases;

import base.testUtils.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class DP2Test extends BaseTest {
    @Test
    public static void CPTest1() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.scrollTillEnd();
        homePage.verifyFooterLinks();
        homePage.exportFooterLinksToCsv();
    }
}

