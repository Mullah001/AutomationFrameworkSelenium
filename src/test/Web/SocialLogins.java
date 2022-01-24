package test.Web;

import main.pageEvents.HomePageEvents;
import main.pageEvents.LogInPageEvents;
import main.pageEvents.SocialLoginEvents;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

@Test(groups = "WEB")
public class SocialLogins extends BaseTest {

    SocialLoginEvents socialLoginEvents = new SocialLoginEvents();
    HomePageEvents homePageEvents = new HomePageEvents();
    LogInPageEvents logInPageEvents = new LogInPageEvents();

    @Test(testName = "log in with google")
    public void socialLoginWithGoogle() throws InterruptedException {
        homePageEvents.clickOnSignIn();
        Thread.sleep(2000);
        logInPageEvents.clickOnGoogleLogo();

        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
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
        Assert.assertEquals(homePageTitle , "Home", "User is logged in with there google email");
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
