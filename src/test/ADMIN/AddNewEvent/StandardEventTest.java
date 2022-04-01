package test.ADMIN.AddNewEvent;

import main.pageEvents.ADMIN.CreateNewEventPageEvents;
import org.junit.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

@Test(groups = {"WEB"})
public class StandardEventTest extends BaseTest {

    CreateNewEventPageEvents createNewEventPageEvents = new CreateNewEventPageEvents();

    @Test(testName = "Verify Standard - Structured Event Creation Flow")
    public void verifyStandardEventCreation_Structured() {

        createNewEventPageEvents.FillBasicInformation_Standard_Structured();
        createNewEventPageEvents.FillDetails_Standard_Structured();

        Assert.assertTrue(createNewEventPageEvents.isEventListingPresent());
    }

    @Test(testName = "Verify Standard - UnStructured Event Creation Flow", priority = 1, enabled = false)
    public void verifyStandardEventCreation_UnStructured() {

        createNewEventPageEvents.FillBasicInformation_Standard_UnStructured();
        createNewEventPageEvents.FillTicketClass_Standard_UnStructured();
        createNewEventPageEvents.FillDetails_Standard_UnStructured();

        Assert.assertTrue(createNewEventPageEvents.isEventListingPresent());
    }
}
