package main.pageEvents;

import main.data.LogInData;
import main.pageObjects.HomePageElements;
import main.pageObjects.LogInPageElements;
import main.pageObjects.SocialLoginElements;
import main.utils.FetchElement;
import main.utils.Locator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import test.BaseTest;

public class LogInPageEvents {
    FetchElement fetchElement = new FetchElement();

    public String getTitle(){
        return BaseTest.driver.getTitle();
    }

    public void enterEmail(String email){
        fetchElement.getWebElement(Locator.XPath, LogInPageElements.email).sendKeys(email);
    }

    public void enterPassword(String password){
        fetchElement.getWebElement(Locator.XPath, LogInPageElements.password).sendKeys(password);
    }

    public void clickLogInButton(){
        fetchElement.getWebElement(Locator.XPath, LogInPageElements.logInButton).click();
    }

    public void clickOnForgetPassword(){
        fetchElement.getWebElement(Locator.XPath, LogInPageElements.forgetpassword).click();
    }

    public void clickOnGoogleLogo(){
        fetchElement.getWebElement(Locator.XPath, LogInPageElements.socialLoginWithGoogle).click();
    }

    public void clickOnFacebookLogo(){
        fetchElement.getWebElement(Locator.XPath, LogInPageElements.getSocialLoginWithFacebook).click();
    }


}
