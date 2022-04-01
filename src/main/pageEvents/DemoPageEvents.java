package main.pageEvents;

import main.data.DemoData;
import main.pageObjects.DemoPageElements;
import main.utils.FetchElement;
import main.utils.Locator;
import org.openqa.selenium.WebDriver;

public class DemoPageEvents {

    public WebDriver driver;

    public DemoPageEvents(WebDriver driver){
        this.driver = driver;
    }

    FetchElement fetchElement = new FetchElement(driver);
    long waitSeconds = 1500L;

    public void TypeUserNameLogIn(){
        fetchElement.getWebElement(Locator.XPath, DemoPageElements.userNameLogin).sendKeys(DemoData.userNameLogIn);
    }

    public void TypeUserNameSignUp(){
        fetchElement.getWebElement(Locator.XPath, DemoPageElements.userNameSignUp).sendKeys(DemoData.userNameSignUp);
    }

    public void TypePasswordLogIn(){
        fetchElement.getWebElement(Locator.XPath, DemoPageElements.passwordLogin).sendKeys(DemoData.passwordLogIn);
    }

    public void TypePasswordSignUp(){
        fetchElement.getWebElement(Locator.XPath, DemoPageElements.passwordSignUp).sendKeys(DemoData.passwordSignUp);
    }

    public void TypeFullNameSignUp(){
        fetchElement.getWebElement(Locator.XPath, DemoPageElements.fullNameSignUp).sendKeys(DemoData.fullNameSignUp);
    }

    public void TypeEmailSignUp(){
        fetchElement.getWebElement(Locator.XPath, DemoPageElements.emailSignUp).sendKeys(DemoData.emailSignUp);
    }

    public void ClickLogInBtn_LogIn(){
        fetchElement.getWebElement(Locator.Id, DemoPageElements.contLoginBtn).click();
    }

    public void ClickSignUpBtn_LogIn(){
        fetchElement.getWebElement(Locator.Id, DemoPageElements.infoSignUpBtn).click();
    }

    public void ClickLogInBtn_SignUp(){
        fetchElement.getWebElement(Locator.Id, DemoPageElements.infoLoginBtn).click();
    }

    public void ClickSignUpBtn_SignUp(){
        fetchElement.getWebElement(Locator.Id, DemoPageElements.contSignUpBtn).click();
    }

    public String getHaveAnAccountText(){
        return fetchElement.getWebElement(Locator.XPath, DemoPageElements.haveAnAccountTextPath).getText();
    }

    public String getNoAccountText(){
        return fetchElement.getWebElement(Locator.XPath, DemoPageElements.noAccountTextPath).getText();
    }

    public void clickSignUpWithWait(){
        ClickSignUpBtn_LogIn();
        try {
            Thread.sleep(waitSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
