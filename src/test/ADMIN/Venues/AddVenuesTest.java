package test.ADMIN.Venues;

import main.pageEvents.ADMIN.DashboardEvents;
import main.pageEvents.ADMIN.Venues.VenuesPageEvents;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.ADMIN.LogIn.LogInTest;
import test.BaseTest;

@Test(groups = {"ADMIN"})
public class AddVenuesTest extends BaseTest {

    public WebDriver driver;
    VenuesPageEvents venuesPageEvents;
    DashboardEvents dashboardEvents;

    @BeforeClass
    public void intialize() {
        driver = initializeBrowser();

        venuesPageEvents = new VenuesPageEvents(driver);
        dashboardEvents = new DashboardEvents(driver);
    }

    @AfterClass
    public void close() {
        closeAndQuitBrowser(driver);
    }

    @Test(testName = "login")
    public void login() {
        LogInTest log = new LogInTest();
        log.verifyLogIn_Valid();
    }

    @Test(priority = 1, testName = "Verify that By Venues module navigation lin is working")
    public void verifyVenueLink() {
        dashboardEvents.clickOnVenuesModule();
    }

    @Test(priority = 2, testName = "Click on the add new venues button")
    public void verifyNameField() {
        venuesPageEvents.clickOnAddVenue();
    }

    @Test(priority = 3, testName = "Filling venues form")
    public void verifyVenuesForm() {
        venuesPageEvents.enterName();
        venuesPageEvents.enterDecription();
        venuesPageEvents.enterLatitude();
        venuesPageEvents.enterLongitude();
        venuesPageEvents.slectCountry();
        venuesPageEvents.slectCity();
        venuesPageEvents.enterAddress();
        venuesPageEvents.enterPostalCode();
        venuesPageEvents.enterSeatingCapacity();
    }
}
