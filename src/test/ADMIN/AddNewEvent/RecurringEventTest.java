package test.ADMIN.AddNewEvent;

import main.pageEvents.ADMIN.CreateNewEventPageEvents;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

@Test(groups = {"WEB"})
public class RecurringEventTest extends BaseTest {

    public WebDriver driver;
    CreateNewEventPageEvents createNewEventPageEvents;
    @BeforeClass
    public void intialize(){
        driver = initializeBrowser();
        createNewEventPageEvents = new CreateNewEventPageEvents(driver);

    }

    @AfterClass
    public void close(){
        closeAndQuitBrowser(driver);
    }

    @Test (testName = "Verify Recurring - Structured Event Creation Flow")
    public void verifyRecurring_Structured(){
        createNewEventPageEvents.FillBasicInformation_Recurring_Structured();
        createNewEventPageEvents.FillDetails_Recurring_Structured();

        Assert.assertTrue(createNewEventPageEvents.isEventListingPresent());
    }
}
