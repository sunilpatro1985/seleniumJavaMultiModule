package testCases;

import base.utils.App;
import base.driver.BaseTest;
import base.utils.ExtentReport;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class TestLogin extends BaseTest {
    WebDriverWait wait;

    @Test
    public void VeirfyValidLogin() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        ProductsPage productPage = new ProductsPage();


        loginPage.login(App.validUserName,App.validPassword);
            Thread.sleep(2000);
            productPage.waitForProduct();
            ExtentReport.getTest().log(Status.INFO, "login Successful");
            Thread.sleep(2000);
    }

}
