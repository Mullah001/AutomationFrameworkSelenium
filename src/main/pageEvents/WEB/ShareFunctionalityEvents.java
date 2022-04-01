package main.pageEvents.WEB;

import main.utils.CommonMethods;
import main.utils.FetchElement;
import main.utils.Locator;
import org.openqa.selenium.WebElement;

import static main.data.Web.LogInData.email_Shameem;
import static main.pageObjects.WEB.ShareFunctionalityElements.*;

public class ShareFunctionalityEvents extends CommonMethods {

    FetchElement fetchElement = new FetchElement();

    public void clickTicketTab(){
        sleep(3000L);
        fetchElement.getWebElement(Locator.XPath, ticketTab).click();
    }
    public void clickShareTicketButton(){
        sleep(2000L);
        fetchElement.getWebElement(Locator.XPath, shareTicketButton).click();
    }
    public void clickSharePassButton(){
        sleep(2000L);
        fetchElement.getWebElement(Locator.XPath, sharePassButton).click();
    }

    public void clickCheckBox(){
        sleep(2000L);
        fetchElement.getWebElement(Locator.XPath, checkBox).click();
    }
    public void enetrPhoneNumber(){
        sleep(2000L);
        clearAndTypeIfPresentAndVisible(phoneNumberField, "0460730678");
    }
    public void enetrName(){
        sleep(2000L);
        clearAndTypeIfPresentAndVisible(nameField, "email_Shameem");
    }
    public void enetrEmail(){
        sleep(2000L);
        clearAndTypeIfPresentAndVisible(emailField, email_Shameem);
    }
    public void clickShareButton(){
        sleep(2000L);
        fetchElement.getWebElement(Locator.XPath, shareButton).click();
    }
}
