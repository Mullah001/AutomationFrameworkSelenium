package test.Web;

import main.pageEvents.ForgetPasswordEvents;
import main.pageEvents.HomePageEvents;
import main.pageEvents.LogInPageEvents;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

@Test(groups = {"WEB"})
public class ForgetPassword extends BaseTest {

    LogInPageEvents logInPageEvents = new LogInPageEvents();
    ForgetPasswordEvents forgetPasswordEvents = new ForgetPasswordEvents();
    HomePageEvents homePageEvents = new HomePageEvents();

    @Test(testName = "Verify that forget password functionality is working fine")
    public void forgetPassword() throws InterruptedException {
        homePageEvents.clickOnSignIn();
        logInPageEvents.clickOnForgetPassword();
        forgetPasswordEvents.enterForgetPasswordEmail();
        forgetPasswordEvents.clickOnSubmitButton();
        Thread.sleep(2000);
        forgetPasswordEvents.clickLoginAgain();
        driver.get("https://mail.google.com");

        forgetPasswordEvents.clickOnGmailSignIn();
        forgetPasswordEvents.enterGoogleEmail();
        forgetPasswordEvents.clickOnEmailNext();
        Thread.sleep(2000);
        forgetPasswordEvents.enterGooglePassword();
        forgetPasswordEvents.clickOnPasswordNext();

        forgetPasswordEvents.enterInSearchField();
        forgetPasswordEvents.pressEnterOnsearchField();
        Thread.sleep(2000);
        forgetPasswordEvents.clickOnForgetPasswordEmail();
        Thread.sleep(5000);
        String href = forgetPasswordEvents.getResetyourPasswordHref();

        driver.navigate().to(href);
        forgetPasswordEvents.enterNewPassword();
        forgetPasswordEvents.enterConfirmPassword();
        forgetPasswordEvents.againSubmit();
        Thread.sleep(2000);
        String congratulationsText = forgetPasswordEvents.getTextCongratulations();
        Assert.assertEquals(congratulationsText, "Congratulations!", "Password has been updated successfully.");

    }
    @Test(testName = "Verify that after successfull forget password user ia able to login with new password")
    public void loginwithNewPassword() throws InterruptedException {
        driver.get("https://qa.ticketlake.com/");
        Thread.sleep(5000);

        homePageEvents.clickOnSignIn();
        forgetPasswordEvents.enterEmail();
        forgetPasswordEvents.enterPassword();
        forgetPasswordEvents.clickLogInButton();

        Thread.sleep(2000);
        String homePageTitle = driver.getTitle();
        Assert.assertEquals(homePageTitle, "Home", "User has been logged in with new password");
    }
}
