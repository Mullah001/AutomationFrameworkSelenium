package main.pageEvents.ADMIN.Venues;

import main.utils.FetchElement;
import main.utils.Locator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static main.pageObjects.ADMIN.Venues.VenuesElements.*;
import static main.data.ADMIN.Venues.VenuesData.*;
import static main.pageObjects.ADMIN.Venues.VenuesElements.description;

public class VenuesPageEvents {

    public WebDriver driver;
    FetchElement fetchElement;

    public VenuesPageEvents(WebDriver driver) {
        this.driver = driver;
        fetchElement = new FetchElement(driver);
    }

    public void clickOnAddVenue() {
        fetchElement.getWebElement(Locator.XPath, addVenueButton).click();
    }

    public void enterName() {
        fetchElement.getWebElement(Locator.XPath, nameField).sendKeys(nameValue);
    }

    public void enterDecription() {
        fetchElement.getWebElement(Locator.XPath, description).sendKeys(description);
    }

    public void enterLatitude() {
        fetchElement.getWebElement(Locator.XPath, latitude).sendKeys(latitudeValue);
    }

    public void enterLongitude() {
        fetchElement.getWebElement(Locator.XPath, longitude).sendKeys(longitudeValue);
    }

    public void slectCountry() {
        WebElement countryElement = fetchElement.getWebElement(Locator.XPath, getCountry);
        Select select = new Select(countryElement);
        select.selectByVisibleText("Pakistan");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(select.getFirstSelectedOption().getText());
    }


    public void slectCity() {
        WebElement cityElement = fetchElement.getWebElement(Locator.XPath, city);
        Select select = new Select(cityElement);
        select.selectByVisibleText("Lahore");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(select.getFirstSelectedOption().getText());
    }

    public void enterAddress() {
        fetchElement.getWebElement(Locator.XPath, address).sendKeys(addressValue);
    }

    public void enterPostalCode() {
        fetchElement.getWebElement(Locator.XPath, postalCode).sendKeys(postalCodeValue);
    }

    public void enterSeatingCapacity() {
        fetchElement.getWebElement(Locator.XPath, seatingCapacity).sendKeys(seatingCapacityValue);
    }
}
