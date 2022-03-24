package main.pageEvents.WEB;

import main.pageObjects.WEB.LogInPageElements;
import main.utils.FetchElement;
import main.utils.Locator;
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
