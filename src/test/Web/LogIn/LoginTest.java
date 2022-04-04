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
    LogInPageEvents logInPageEvents;
    HomePageEvents homePageEvents;
    @BeforeClass
    public void initialize(){
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

        homePageEvents.clickOnSignIn();
        logInPageEvents.enterEmail(email);
        logInPageEvents.enterPassword(password);
        logInPageEvents.clickLogInButton();
        Thread.sleep(3000);
        String homePageTitle = driver.getTitle();
        switch (check) {
            case "inValid":
                Assert.assertEquals(homePageTitle, "Sign in", "Email and phone number are invalid");
                logInPageEvents.clickCrossButton();
                break;
            case "empty":
                Assert.assertEquals(homePageTitle, "Sign in", "Email and phone number are required");
                logInPageEvents.clickCrossButton();
                break;
            case "valid":
                Assert.assertEquals(homePageTitle, "Home", "User is login successfully");
                break;
        }
    }
}
