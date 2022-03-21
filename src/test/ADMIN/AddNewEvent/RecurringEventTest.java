package test.ADMIN.AddNewEvent;

import main.pageEvents.ADMIN.CreateNewEventPageEvents;
import org.junit.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

@Test(groups = {"WEB"})
public class RecurringEventTest extends BaseTest {

    CreateNewEventPageEvents createNewEventPageEvents = new CreateNewEventPageEvents();

    @Test (testName = "Verify Recurring - Structured Event Creation Flow")
    public void verifyRecurring_Structured(){
        createNewEventPageEvents.FillBasicInformation_Recurring_Structured();
        createNewEventPageEvents.FillDetails_Recurring_Structured();

        Assert.assertTrue(createNewEventPageEvents.isEventListingPresent());
    }
}
