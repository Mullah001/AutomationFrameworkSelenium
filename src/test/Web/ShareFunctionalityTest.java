package test.Web;

import main.pageEvents.WEB.HomePageEvents;
import main.pageEvents.WEB.ShareFunctionalityEvents;
import org.testng.annotations.Test;
import test.BaseTest;
import test.Web.LogIn.LoginTest;

@Test(groups = {"WEB"})
public class ShareFunctionalityTest extends BaseTest {

    LoginTest loginTest = new LoginTest();
    HomePageEvents homePageEvents = new HomePageEvents();
    ShareFunctionalityEvents shareFunctionalityEvents = new ShareFunctionalityEvents();


    @Test(testName = "Verify the share functionality of ticket is working fine", priority = 1)
    public void verifyShareTicketFunctionality(){

        try {
            loginTest.Login("shameem.akhtar@synavos.com", "12345678", "valid");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sleep(3000);
        homePageEvents.clickProfileDropdown();
        homePageEvents.clickProfile();
        shareFunctionalityEvents.clickTicketTab();
        shareFunctionalityEvents.clickShareTicketButton();
        shareFunctionalityEvents.clickCheckBox();
        shareFunctionalityEvents.enetrPhoneNumber();
        shareFunctionalityEvents.enetrName();
        shareFunctionalityEvents.enetrEmail();
        shareFunctionalityEvents.clickShareButton();
    }

    @Test(testName = "Verify the share functionality of pass is working fine", priority = 2, dependsOnMethods = {"verifyShareTicketFunctionality"}, enabled = false)
    public void verifySharePassFunctionality(){
        shareFunctionalityEvents.clickSharePassButton();
        shareFunctionalityEvents.clickCheckBox();
        shareFunctionalityEvents.enetrPhoneNumber();
        shareFunctionalityEvents.enetrName();
        shareFunctionalityEvents.enetrEmail();
        shareFunctionalityEvents.clickShareButton();
    }
}
