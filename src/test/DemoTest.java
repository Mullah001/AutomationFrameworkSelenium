package test;

import main.pageEvents.DemoPageEvents;
import main.pageObjects.DemoPageElements;
import main.utils.Locator;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Test(groups = {"WEB"})
public class DemoTest extends BaseTest{

    DemoPageEvents demoPageEvents = new DemoPageEvents();
    boolean isElementPresentAndVisible = false;

    /* Test Details:
    Priorities Defined:
    Priority = 0 --> Verify LogIn Display and Presence
    Priority = 1 --> Verify LogIn Functionality
    Priority = 2 --> Verify SignUp Display and Presence
    Priority = 3 --> Verify SignUp Functionality
    * */

    @Test (priority = 0, enabled = false)
    public void verifyUserName_LogIn(){
        isElementPresentAndVisible = false;
        isElementPresentAndVisible = IsElementPresentAndVisible(By.xpath(DemoPageElements.userNameLogin));
        Assert.assertTrue(isElementPresentAndVisible, "UserName from LogIn Page is Present and Visible?");
    }

    @Test (priority = 0, enabled = false)
    public void verifyPassword_LogIn(){
        isElementPresentAndVisible = false;
        isElementPresentAndVisible = IsElementPresentAndVisible(By.xpath(DemoPageElements.passwordLogin));
        Assert.assertTrue(isElementPresentAndVisible, "Password from LogIn Page is Present and Visible?");
    }

    @Test(priority = 0)
    public void verifyLogInFunctionality() throws InterruptedException {
        Thread.sleep(500L);
        demoPageEvents.TypeUserNameLogIn();
        Thread.sleep(500L);
        demoPageEvents.TypePasswordLogIn();
        Thread.sleep(500L);
        demoPageEvents.ClickLogInBtn_LogIn();
    }

    @Test (priority = 1, enabled = false)
    public void verifySignUpBtn_LogIn(){
        demoPageEvents.ClickSignUpBtn_LogIn();
    }

    @Test (priority = 1, enabled = false)
    public void verifyNoAccountText(){
        String noAccountTextSite = demoPageEvents.getNoAccountText();
        Assert.assertEquals(noAccountTextSite, DemoPageElements.noAccountText,"Verify No Account Text");
    }

    @Test(priority = 2, enabled = false)
    public void verifyEmail_SignUp(){
        demoPageEvents.clickSignUpWithWait();
        isElementPresentAndVisible = false;
        isElementPresentAndVisible = IsElementPresentAndVisible(By.xpath(DemoPageElements.emailSignUp));
        Assert.assertTrue(isElementPresentAndVisible, "Email from SignUp Page is Present and Visible?");
    }

    @Test(priority = 2, enabled = false)
    public void verifyFullName_SignUp(){
        demoPageEvents.clickSignUpWithWait();
        isElementPresentAndVisible = false;
        isElementPresentAndVisible = IsElementPresentAndVisible(By.xpath(DemoPageElements.fullNameSignUp));
        Assert.assertTrue(isElementPresentAndVisible, "FullName from SignUp Page is Present and Visible?");
    }

    @Test(priority = 2, enabled = false)
    public void verifyUserName_SignUp(){
        demoPageEvents.clickSignUpWithWait();
        isElementPresentAndVisible = false;
        isElementPresentAndVisible = IsElementPresentAndVisible(By.xpath(DemoPageElements.userNameSignUp));
        Assert.assertTrue(isElementPresentAndVisible, "UserName from SignUp Page is Present and Visible?");
    }

    @Test(priority = 2, enabled = false)
    public void verifyPassword_SignUp(){
        demoPageEvents.clickSignUpWithWait();
        isElementPresentAndVisible = false;
        isElementPresentAndVisible = IsElementPresentAndVisible(By.xpath(DemoPageElements.passwordSignUp));
        Assert.assertTrue(isElementPresentAndVisible, "Password from SignUp Page is Present and Visible?");
    }

    @Test(priority = 3, enabled = false)
    public void verifySignUpFunctionality(){
        demoPageEvents.clickSignUpWithWait();
        demoPageEvents.TypeEmailSignUp();
        demoPageEvents.TypeFullNameSignUp();
        demoPageEvents.TypeUserNameSignUp();
        demoPageEvents.TypePasswordSignUp();
        demoPageEvents.ClickSignUpBtn_SignUp();
    }

    @Test (priority = 3, enabled = false)
    public void verifyHaveAccountText(){
        demoPageEvents.clickSignUpWithWait();
        String haveAnAccountText = demoPageEvents.getHaveAnAccountText();
        Assert.assertEquals(haveAnAccountText,DemoPageElements.haveAnAccountText,"Verify Have an Account Text");
    }

    @Test (priority = 3, enabled = false)
    public void verifyLogInBtn_SignUp(){
        demoPageEvents.clickSignUpWithWait();
        demoPageEvents.ClickLogInBtn_SignUp();
    }

}
