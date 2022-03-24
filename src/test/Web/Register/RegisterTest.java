package test.Web.Register;

import main.pageEvents.WEB.HomePageEvents;
import main.pageEvents.WEB.RegisterPageEvents;
import main.utils.DProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

@Test(groups = {"WEB"})
public class RegisterTest extends BaseTest {

    RegisterPageEvents registerPageEvents = new RegisterPageEvents();
    HomePageEvents homePageEvents = new HomePageEvents();

    @Test(testName = "Verify that registration functionality is working with valid, invalid and empty data.",dataProvider = "signUpData",dataProviderClass = DProvider.class)
    public void Register(String email, String password, String name, String phoneNumber, boolean isValid) throws InterruptedException {
        homePageEvents.clickOnSignIn();
        registerPageEvents.clickRegisterTop();
        registerPageEvents.enterEmail(email);
        registerPageEvents.enterPassword(password);
        registerPageEvents.enterName(name);
        registerPageEvents.entrPhoneNumber(phoneNumber);
        registerPageEvents.checktermAndConditions();
        registerPageEvents.clickOnRegisterButton();
        Thread.sleep(10000);
        String homePageTitle = driver.getTitle();
        if(isValid){
            Assert.assertEquals(homePageTitle, "Home", "Verify that user is able to sign up");
        }else{
            Assert.assertEquals(homePageTitle, "Sign in", "Verify that user is able to sign up");

        }


    }

}
