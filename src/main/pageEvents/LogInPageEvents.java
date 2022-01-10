package main.pageEvents;

import main.data.LogInData;
import main.pageObjects.LogInPageElements;
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

    public void enterEmail(){
        fetchElement.getWebElement(Locator.Name, LogInPageElements.email).sendKeys(LogInData.email);
    }

    public void enterPassword(){
        fetchElement.getWebElement(Locator.Name, LogInPageElements.password).sendKeys(LogInData.password);
    }

    public void clickLogInButton(){
        fetchElement.getWebElement(Locator.XPath, LogInPageElements.logInButton).click();
    }

    public boolean verifyLogInSuccess(){
       return fetchElement.getWebElement(Locator.XPath, LogInPageElements.userLogged).isDisplayed();
    }
}
