package main.pageEvents.WEB;

import main.utils.CommonMethods;
import main.utils.FetchElement;
import main.utils.Locator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static main.data.WEB.LogInData.email_Shameem;
import static main.pageObjects.WEB.ShareFunctionalityElements.*;
import static main.utils.CommonMethods.sleep;

public class ShareFunctionalityEvents {

    public WebDriver driver;
    FetchElement fetchElement;
    CommonMethods commonMethods;

    public ShareFunctionalityEvents(WebDriver driver) {
        this.driver = driver;
        fetchElement = new FetchElement(driver);
        commonMethods = new CommonMethods(driver);

    }

    public void clickTicketTab() {
        sleep(3000L);
        fetchElement.getWebElement(Locator.XPath, ticketTab).click();
    }

    public void clickShareTicketButton() {
        sleep(2000L);
        fetchElement.getWebElement(Locator.XPath, shareTicketButton).click();
    }

    public void clickSharePassButton() {
        sleep(2000L);
        fetchElement.getWebElement(Locator.XPath, sharePassButton).click();
    }

    public void clickCheckBox() {
        sleep(2000L);
        fetchElement.getWebElement(Locator.XPath, checkBox).click();
    }

    public void enetrPhoneNumber(WebDriver driver) {
        sleep(2000L);
        commonMethods.clearAndTypeIfPresentAndVisible(phoneNumberField, "0460730678");
    }

    public void enetrName(WebDriver driver) {
        sleep(2000L);
        commonMethods.clearAndTypeIfPresentAndVisible(nameField, "Shameem");
    }

    public void enetrEmail(WebDriver driver) {
        sleep(2000L);
        commonMethods.clearAndTypeIfPresentAndVisible(emailField, email_Shameem);
    }

    public void clickShareButton() {
        sleep(2000L);
        fetchElement.getWebElement(Locator.XPath, shareButton).click();
    }
}
