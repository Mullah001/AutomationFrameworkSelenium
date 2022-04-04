package test.ADMIN.EventListing;

import main.pageEvents.ADMIN.EventsListingPageEvents;
import main.pageEvents.WEB.MoviesPageEvents;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

@Test(groups = {"WEB"})
public class EventListingTest extends BaseTest {

    public WebDriver driver;
    EventsListingPageEvents eventsListingPageEvents;

    @BeforeClass
    public void intialize() {
        driver = initializeBrowser();
        eventsListingPageEvents = new EventsListingPageEvents(driver);

    }

    @AfterClass
    public void close() {
        closeAndQuitBrowser(driver);
    }

    int actualCount, expectedCount;
}
