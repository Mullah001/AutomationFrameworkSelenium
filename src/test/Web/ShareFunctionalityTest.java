package test.Web;

import main.pageEvents.WEB.HomePageEvents;
import main.pageEvents.WEB.ShareFunctionalityEvents;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;
import test.Web.LogIn.LoginTest;

@Test(groups = {"WEB"})
public class ShareFunctionalityTest extends BaseTest {

    public WebDriver driver;
    LoginTest loginTest = null;
    HomePageEvents homePageEvents = null;
    ShareFunctionalityEvents shareFunctionalityEvents = null;

    @BeforeClass
    public void intialize() {
        driver = initializeBrowser();
        loginTest = new LoginTest();
        homePageEvents = new HomePageEvents(driver);
        shareFunctionalityEvents = new ShareFunctionalityEvents(driver);
    }

    @AfterClass
    public void close() {
        closeAndQuitBrowser(driver);
    }


    @Test(testName = "Verify the share functionality of ticket is working fine", priority = 1)
    public void verifyShareTicketFunctionality() {

        try {
            loginTest.Login("ataib.ahmad@synavos.com", "123456", "valid");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sleep(3000);
        homePageEvents.clickProfileDropdown();
        homePageEvents.clickProfile();
        shareFunctionalityEvents.clickTicketTab();
        shareFunctionalityEvents.clickShareTicketButton();
        shareFunctionalityEvents.clickCheckBox();
        shareFunctionalityEvents.enetrPhoneNumber(driver);
        shareFunctionalityEvents.enetrName(driver);
        shareFunctionalityEvents.enetrEmail(driver);
        shareFunctionalityEvents.clickShareButton();
    }

    @Test(testName = "Verify the share functionality of pass is working fine", priority = 2, dependsOnMethods = {"verifyShareTicketFunctionality"}, enabled = false)
    public void verifySharePassFunctionality() {
        shareFunctionalityEvents.clickSharePassButton();
        shareFunctionalityEvents.clickCheckBox();
        shareFunctionalityEvents.enetrPhoneNumber(driver);
        shareFunctionalityEvents.enetrName(driver);
        shareFunctionalityEvents.enetrEmail(driver);
        shareFunctionalityEvents.clickShareButton();
    }
}
