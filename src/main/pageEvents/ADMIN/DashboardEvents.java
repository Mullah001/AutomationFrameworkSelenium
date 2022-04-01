package main.pageEvents.ADMIN;

import main.utils.FetchElement;
import main.utils.Locator;
import org.openqa.selenium.WebDriver;

import static main.data.ADMIN.Venues.VenuesData.nameValue;
import static main.pageObjects.ADMIN.DashboardElements.sideVenues;
import static main.pageObjects.ADMIN.Venues.VenuesElements.nameField;

public class DashboardEvents {

    public WebDriver driver;

    public DashboardEvents(WebDriver driver){
        this.driver = driver;
    }

    FetchElement fetchElement = new FetchElement(driver);

    public void clickOnVenuesModule(){
        fetchElement.getWebElement(Locator.XPath, sideVenues).click();
    }
}
