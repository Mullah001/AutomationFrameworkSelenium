package test.Web;

import main.pageEvents.WEB.HomePageEvents;
import main.pageEvents.WEB.LogInPageEvents;
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
    LogInPageEvents logInPageEvents;
    HomePageEvents homePageEvents;
    ShareFunctionalityEvents shareFunctionalityEvents;

    @BeforeClass
    public void intialize() {
        driver = initializeBrowser();
        logInPageEvents = new LogInPageEvents(driver);
        homePageEvents = new HomePageEvents(driver);
        shareFunctionalityEvents = new ShareFunctionalityEvents(driver);
    }

    @AfterClass
    public void close() {
        closeAndQuitBrowser(driver);
    }


    @Test(testName = "Verify the share functionality of ticket is working fine")
    public void verifyShareTicketFunctionality() {

        homePageEvents.clickOnSignIn();
        logInPageEvents.enterEmail("ataib.ahmad@synavos.com");
        logInPageEvents.enterPassword("123456");
        logInPageEvents.clickLogInButton();

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
