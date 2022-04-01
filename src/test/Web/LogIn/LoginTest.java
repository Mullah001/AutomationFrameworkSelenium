package test.Web.LogIn;

import main.pageEvents.WEB.HomePageEvents;
import main.pageEvents.WEB.LogInPageEvents;
import main.utils.DProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

@Test(groups = {"WEB"})
public class LoginTest extends BaseTest {
    public WebDriver driver;
    LogInPageEvents logInPageEvents = null;
    HomePageEvents homePageEvents = null;
    @BeforeClass
    public void intialize(){
        driver = initializeBrowser();

        logInPageEvents = new LogInPageEvents(driver);
        homePageEvents = new HomePageEvents(driver);
    }

    @AfterClass
    public void close(){
        closeAndQuitBrowser(driver);
    }


    @Test(testName = "Verify that login functionality is working fine with valid, invalid and Empty data", dataProvider = "signInData", dataProviderClass = DProvider.class)
    public void Login(String email, String password, String check) throws InterruptedException {

        getLocalDateAndTimeString();

        homePageEvents.clickOnSignIn();
        logInPageEvents.enterEmail(email);
        logInPageEvents.enterPassword(password);
        logInPageEvents.clickLogInButton();
        Thread.sleep(10000);
        String homePageTitle = driver.getTitle();
        switch (check) {
            case "inValid":
                Assert.assertEquals(homePageTitle, "Sign in", "Email and phone number are invalid");
                break;
            case "empty":
                Assert.assertEquals(homePageTitle, "Sign in", "Email and phone number are required");
                break;
            case "valid":
                Assert.assertEquals(homePageTitle, "Home", "User is login successfully");
                break;
        }
    }
}
