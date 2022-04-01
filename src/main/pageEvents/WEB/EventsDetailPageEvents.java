package main.pageEvents.WEB;

import main.utils.CommonMethods;
import main.utils.FetchElement;
import main.utils.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static main.pageObjects.EventsDetailPageElements.*;

public class EventsDetailPageEvents extends CommonMethods {

    public WebDriver driver;

    public EventsDetailPageEvents(WebDriver driver){
        this.driver = driver;
    }

    FetchElement fetchElement = new FetchElement(driver);

    public void clickOnBuyNowAndSeeDetailsButton() {
        if (IsElementPresentAndVisible(By.xpath(buyNow))) {
            fetchElement.getWebElement(Locator.XPath, buyNow).click();
        } else
            fetchElement.getWebElement(Locator.XPath, seeDetailsButton).click();
    }

    public void getSlotSelection() {
        if (IsElementPresentAndVisible(By.xpath(slotSelection)))
            fetchElement.getWebElement(Locator.XPath, slotSelection).click();
    }

    public void getProcssedToCheckout() {
        if (IsElementPresentAndVisible(By.xpath(procssedToCheckout)))
            fetchElement.getWebElement(Locator.XPath, procssedToCheckout).click();
    }
}
