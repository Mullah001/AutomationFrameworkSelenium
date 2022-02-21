package main.pageEvents.ADMIN;

import main.utils.CommonMethods;
import main.utils.FetchElement;
import main.utils.Locator;
import org.openqa.selenium.By;
import test.BaseTest;

import static main.data.ADMIN.LogInData.*;
import static main.pageObjects.ADMIN.LogInPageElements.*;

public class LogInPageEvents extends CommonMethods {
    FetchElement fetchElement = new FetchElement();

    public void enterUserName(String userName) {
        fetchElement.getWebElement(Locator.XPath, userName_XPath).sendKeys(userName);
    }

    public void enterPassword(String password) {
        fetchElement.getWebElement(Locator.XPath, password_XPath).sendKeys(password);
    }

    public void clickLogInButton() {
        fetchElement.getWebElement(Locator.XPath, logInButton_XPath).click();
    }

    public void waitForDashboardToLoad(){
        waitForElementPresentAndVisible(BaseTest.driver, By.id(dashboardSideBar_Id), 15);
    }

    public void logIn_Valid(){
        enterUserName(userName_Master);
        enterPassword(password_Master);

        clickLogInButton();
    }

    public void logIn_InValid(){
        enterUserName(inValidUserName);
        enterPassword(inValidPassword);

        clickLogInButton();
    }

    public void logIn_Empty(){
        enterUserName(emptyUserName);
        enterPassword(emptyPassword);

        clickLogInButton();
    }
}
