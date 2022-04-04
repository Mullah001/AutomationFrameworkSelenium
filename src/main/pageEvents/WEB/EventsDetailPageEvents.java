package main.pageEvents.WEB;

import main.utils.CommonMethods;
import main.utils.FetchElement;
import main.utils.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static main.pageObjects.EventsDetailPageElements.*;

public class EventsDetailPageEvents {

    public WebDriver driver;
    CommonMethods commonMethods;
    FetchElement fetchElement;

    public EventsDetailPageEvents(WebDriver driver) {
        this.driver = driver;
        fetchElement = new FetchElement(driver);
        commonMethods = new CommonMethods(driver);
    }

    public void clickOnBuyNowAndSeeDetailsButton() {
        if (commonMethods.IsElementPresentAndVisible(By.xpath(buyNow))) {
            fetchElement.getWebElement(Locator.XPath, buyNow).click();
        } else
            fetchElement.getWebElement(Locator.XPath, seeDetailsButton).click();
    }

    public void getSlotSelection() {
        if (commonMethods.IsElementPresentAndVisible(By.xpath(slotSelection)))
            fetchElement.getWebElement(Locator.XPath, slotSelection).click();
    }

    public void getProcssedToCheckout() {
        if (commonMethods.IsElementPresentAndVisible(By.xpath(procssedToCheckout)))
            fetchElement.getWebElement(Locator.XPath, procssedToCheckout).click();
    }
}
