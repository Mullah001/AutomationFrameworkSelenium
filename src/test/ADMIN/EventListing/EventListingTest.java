package test.ADMIN.EventListing;

import main.pageEvents.ADMIN.EventsListingPageEvents;
import main.pageEvents.WEB.MoviesPageEvents;
import org.testng.annotations.Test;
import test.BaseTest;

@Test(groups = {"WEB"})
public class EventListingTest  extends BaseTest {

    EventsListingPageEvents eventsListingPageEvents = new EventsListingPageEvents();
    int actualCount, expectedCount;
}
