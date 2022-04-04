package main.pageEvents.WEB;

import main.pageObjects.WEB.LogInPageElements;
import main.utils.FetchElement;
import main.utils.Locator;
import org.openqa.selenium.WebDriver;
import test.BaseTest;

public class LogInPageEvents {
    public WebDriver driver;
    FetchElement fetchElement = null;
    public LogInPageEvents(WebDriver driver){
        this.driver = driver;
        fetchElement = new FetchElement(driver);
    }

    public String getTitle(){
        return driver.getTitle();
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
