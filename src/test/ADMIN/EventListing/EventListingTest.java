package test.ADMIN.EventListing;

import main.pageEvents.ADMIN.EventsListingPageEvents;
import main.pageEvents.WEB.MoviesPageEvents;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

@Test(groups = {"WEB"})
public class EventListingTest  extends BaseTest {

    public WebDriver driver;
    @BeforeClass
    public void intialize(){
        driver = initializeBrowser();
    }

    @AfterClass
    public void close(){
        closeAndQuitBrowser(driver);
    }

    EventsListingPageEvents eventsListingPageEvents = new EventsListingPageEvents(driver);
    int actualCount, expectedCount;
}
