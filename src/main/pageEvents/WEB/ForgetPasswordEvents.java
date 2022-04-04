package main.pageEvents.WEB;

import main.pageObjects.WEB.ForgetPasswordElements;
import main.pageObjects.WEB.LogInPageElements;
import main.utils.DProvider;
import main.utils.FetchElement;
import main.utils.Locator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ForgetPasswordEvents {

    public WebDriver driver;
    DProvider dProvider;
    FetchElement fetchElement;

    public ForgetPasswordEvents(WebDriver driver) {
        this.driver = driver;
        dProvider = new DProvider(driver);
        fetchElement = new FetchElement(driver);
    }

    public void enterForgetPasswordEmail() {
        fetchElement.getWebElement(Locator.Id, ForgetPasswordElements.forgetEmail).sendKeys("shameem.akhtar@synavos.com");
    }

    public void clickOnSubmitButton() {
        fetchElement.getWebElement(Locator.XPath, ForgetPasswordElements.submitButton).click();
    }

    public void clickLoginAgain() {
        fetchElement.getWebElement(Locator.XPath, ForgetPasswordElements.loginAgain).click();
    }

    public void clickOnGmailSignIn() {
        fetchElement.getWebElement(Locator.XPath, ForgetPasswordElements.emailSignIn).click();
    }

    public void enterGoogleEmail() {
        fetchElement.getWebElement(Locator.XPath, ForgetPasswordElements.googleEmail).sendKeys(dProvider.getResetEmail());
    }

    public void clickOnEmailNext() {
        fetchElement.getWebElement(Locator.XPath, ForgetPasswordElements.nextEmail).click();
    }

    public void enterGooglePassword() {
        fetchElement.getWebElement(Locator.XPath, ForgetPasswordElements.googlePassword).sendKeys(dProvider.getEmailPassword());
    }

    public void clickOnPasswordNext() {
        fetchElement.getWebElement(Locator.XPath, ForgetPasswordElements.nextPassword).click();
    }

    public void enterInSearchField() {
        fetchElement.getWebElement(Locator.XPath, ForgetPasswordElements.sreachField).sendKeys("in:inbox");
    }

    public void pressEnterOnsearchField() {
        fetchElement.getWebElement(Locator.XPath, ForgetPasswordElements.sreachField).sendKeys(Keys.RETURN);
    }

    public void clickOnForgetPasswordEmail() {
        fetchElement.getWebElement(Locator.XPath, ForgetPasswordElements.forgetPasswordEmail).click();
    }

    public String getResetyourPasswordHref() {
        String href = "";
        href = fetchElement.getWebElement(Locator.XPath, ForgetPasswordElements.resetYourPassword).getAttribute("href");
        return href;
    }

    public void enterNewPassword() {
        fetchElement.getWebElement(Locator.Id, ForgetPasswordElements.newPassword).sendKeys(dProvider.getResetNewPassword());
    }

    public void enterConfirmPassword() {
        fetchElement.getWebElement(Locator.Id, ForgetPasswordElements.confirmNewPassword).sendKeys(dProvider.getResetNewConfirmPassword());
    }

    public void againSubmit() {
        fetchElement.getWebElement(Locator.XPath, ForgetPasswordElements.againSubmit).click();
    }

    public String getTextCongratulations() {
        String ongratulations = fetchElement.getWebElement(Locator.XPath, ForgetPasswordElements.congratulations).getText();
        return ongratulations;
    }

    public void enterEmail() {
        fetchElement.getWebElement(Locator.XPath, LogInPageElements.email).sendKeys(dProvider.getResetEmail());
    }

    public void enterPassword() {
        fetchElement.getWebElement(Locator.XPath, LogInPageElements.password).sendKeys(dProvider.getResetNewPassword());
    }

    public void clickLogInButton() {
        fetchElement.getWebElement(Locator.XPath, LogInPageElements.logInButton).click();
    }
}
