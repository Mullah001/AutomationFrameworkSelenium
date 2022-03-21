package main.pageEvents.ADMIN;

import main.utils.FetchElement;
import main.utils.Locator;

import static main.data.ADMIN.Venues.VenuesData.nameValue;
import static main.pageObjects.ADMIN.DashboardElements.sideVenues;
import static main.pageObjects.ADMIN.Venues.VenuesElements.nameField;

public class DashboardEvents {

    FetchElement fetchElement = new FetchElement();

    public void clickOnVenuesModule(){
        fetchElement.getWebElement(Locator.XPath, sideVenues).click();
    }
}
