package test.Web;

import main.pageEvents.HomePageEvents;
import main.pageEvents.LogInPageEvents;
import main.utils.DProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

@Test(groups = {"WEB"})
public class Login extends BaseTest {

    LogInPageEvents logInPageEvents = new LogInPageEvents();
    HomePageEvents homePageEvents = new HomePageEvents();

    @Test(dataProvider = "signInData", dataProviderClass = DProvider.class, enabled = false)
    public void Login(String email, String password, String check) throws InterruptedException {
        homePageEvents.clickOnSignIn();
        logInPageEvents.enterEmail(email);
        logInPageEvents.enterPassword(password);
        logInPageEvents.clickLogInButton();
        Thread.sleep(10000);
        String homePageTitle = driver.getTitle();
        switch (check){
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