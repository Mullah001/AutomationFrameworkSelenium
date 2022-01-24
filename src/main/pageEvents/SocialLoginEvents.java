package main.pageEvents;

import main.pageObjects.ForgetPasswordElements;
import main.pageObjects.LogInPageElements;
import main.pageObjects.SocialLoginElements;
import main.utils.DProvider;
import main.utils.FetchElement;
import main.utils.Locator;

public class SocialLoginEvents extends DProvider {

    FetchElement fetchElement = new FetchElement();
    DProvider dProvider = new DProvider();


    public void enterGoogleEmail() {
        fetchElement.getWebElement(Locator.XPath, SocialLoginElements.googleEmail).sendKeys(dProvider.getGoogleEmail());
    }

    public void clickOnEmailNext() {
        fetchElement.getWebElement(Locator.XPath, SocialLoginElements.nextEmail).click();
    }

    public void enterGooglePassword() {
        fetchElement.getWebElement(Locator.XPath, SocialLoginElements.googlePassword).sendKeys(dProvider.getGooglePasswrod());
    }

    public void clickOnPasswordNext() {
        fetchElement.getWebElement(Locator.XPath, SocialLoginElements.nextPassword).click();
    }

    //Facebook Events



    public void clickonCreateNewAccount(){
        fetchElement.getWebElement(Locator.XPath, SocialLoginElements.createNewAccount).click();
    }

    public void clickOnAlreadyHaveAnAccount(){
        fetchElement.getWebElement(Locator.XPath, SocialLoginElements.alreadyHaveAnAccount).click();
    }

    public void clickOnFacebookEmail(){
        fetchElement.getWebElement(Locator.Id, SocialLoginElements.facebookEmail).sendKeys(dProvider.getFacebookId());
    }

    public void clickOnFacebookPassword(){
        fetchElement.getWebElement(Locator.Id, SocialLoginElements.facebookPassword).sendKeys(dProvider.getEmailPassword());
    }

    public void clickOnFacebookLoginButton(){
        fetchElement.getWebElement(Locator.Id, SocialLoginElements.facebookLoginButton).click();
    }
}
