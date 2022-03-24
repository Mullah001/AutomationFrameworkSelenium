package main.pageEvents.WEB;

import main.pageObjects.WEB.RegisterPageElements;
import main.utils.FetchElement;
import main.utils.Locator;

public class RegisterPageEvents {

    FetchElement fetchElement = new FetchElement();

    public void clickRegisterTop(){
        fetchElement.getWebElement(Locator.XPath, RegisterPageElements.clickRegister).click();
    }

    public void enterEmail(String email){
        fetchElement.getWebElement(Locator.Id, RegisterPageElements.email).sendKeys(email);
    }
    public void enterPassword(String password){
        fetchElement.getWebElement(Locator.XPath, RegisterPageElements.password).sendKeys(password);
    }

    public void enterName(String name){
        fetchElement.getWebElement(Locator.Id, RegisterPageElements.name).sendKeys(name);
    }

    public void entrPhoneNumber(String phoneNumber){
        fetchElement.getWebElement(Locator.XPath, RegisterPageElements.phoneNumber).sendKeys(phoneNumber);
    }

    public void checktermAndConditions(){
        fetchElement.getWebElement(Locator.XPath, RegisterPageElements.termsConditions).click();
    }

    public void clickOnRegisterButton(){
        fetchElement.getWebElement(Locator.XPath, RegisterPageElements.register).click();
    }
}