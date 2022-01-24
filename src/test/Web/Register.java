package test.Web;

import main.pageEvents.HomePageEvents;
import main.pageEvents.RegisterPageEvents;
import main.utils.DProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

@Test(groups = {"WEB"})
public class Register extends BaseTest {

    RegisterPageEvents registerPageEvents = new RegisterPageEvents();
    HomePageEvents homePageEvents = new HomePageEvents();

    @Test(dataProvider = "signUpData",dataProviderClass = DProvider.class, enabled = false)
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
