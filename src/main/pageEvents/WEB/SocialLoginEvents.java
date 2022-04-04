package main.pageEvents.WEB;

import main.pageObjects.WEB.ForgetPasswordElements;
import main.pageObjects.WEB.LogInPageElements;
import main.pageObjects.WEB.SocialLoginElements;
import main.utils.DProvider;
import main.utils.FetchElement;
import main.utils.Locator;
import org.openqa.selenium.WebDriver;

public class SocialLoginEvents {

    public WebDriver driver;
    FetchElement fetchElement;
    DProvider dProvider;

    public SocialLoginEvents(WebDriver driver) {
        this.driver = driver;
        fetchElement = new FetchElement(driver);
        dProvider = new DProvider(driver);
    }

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

    public void clickonCreateNewAccount() {
        fetchElement.getWebElement(Locator.XPath, SocialLoginElements.createNewAccount).click();
    }

    public void clickOnAlreadyHaveAnAccount() {
        fetchElement.getWebElement(Locator.XPath, SocialLoginElements.alreadyHaveAnAccount).click();
    }

    public void clickOnFacebookEmail() {
        fetchElement.getWebElement(Locator.Id, SocialLoginElements.facebookEmail).sendKeys(dProvider.getFacebookId());
    }

    public void clickOnFacebookPassword() {
        fetchElement.getWebElement(Locator.Id, SocialLoginElements.facebookPassword).sendKeys(dProvider.getEmailPassword());
    }

    public void clickOnFacebookLoginButton() {
        fetchElement.getWebElement(Locator.Id, SocialLoginElements.facebookLoginButton).click();
    }
}
