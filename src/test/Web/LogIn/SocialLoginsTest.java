package test.Web.LogIn;

import main.pageEvents.WEB.HomePageEvents;
import main.pageEvents.WEB.LogInPageEvents;
import main.pageEvents.WEB.SocialLoginEvents;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

@Test(groups = "WEB")
public class SocialLoginsTest extends BaseTest {

    public WebDriver driver;
    SocialLoginEvents socialLoginEvents;
    HomePageEvents homePageEvents;
    LogInPageEvents logInPageEvents;

    @BeforeClass
    public void intialize() {
        driver = initializeBrowser();
        socialLoginEvents = new SocialLoginEvents(driver);
        homePageEvents = new HomePageEvents(driver);
        logInPageEvents = new LogInPageEvents(driver);
    }

    @AfterClass
    public void close() {
        closeAndQuitBrowser(driver);
    }


    @Test(testName = "Verify that log in with google functionality is working", enabled = false)
    public void socialLoginWithGoogle() throws InterruptedException {
        homePageEvents.clickOnSignIn();
        Thread.sleep(2000);
        logInPageEvents.clickOnGoogleLogo();

        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        socialLoginEvents.enterGoogleEmail();
        socialLoginEvents.clickOnEmailNext();
        Thread.sleep(2000);
        socialLoginEvents.enterGooglePassword();
        socialLoginEvents.clickOnPasswordNext();
        Thread.sleep(5000);

        driver.switchTo().window(winHandleBefore);
        Thread.sleep(5000);
        String homePageTitle = driver.getTitle();
        Assert.assertEquals(homePageTitle, "Home", "User is logged in with there google email");
    }

//    @Test
//    public void socialLoginWithFacebook() throws InterruptedException {
//        homePageEvents.clickOnSignIn();
//
//        Thread.sleep(2000);
//        logInPageEvents.clickOnFacebookLogo();
//
//        String winHandleBefore = driver.getWindowHandle();
//        for(String winHandle : driver.getWindowHandles()){
//            driver.switchTo().window(winHandle);
//        }
//    }

}
