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
    @BeforeClass
    public void intialize(){
        driver = initializeBrowser();
    }

    @AfterClass
    public void close(){
        closeAndQuitBrowser(driver);
    }

    CreateNewEventPageEvents createNewEventPageEvents = new CreateNewEventPageEvents(driver);

    @Test (testName = "Verify Recurring - Structured Event Creation Flow")
    public void verifyRecurring_Structured(){
        createNewEventPageEvents.FillBasicInformation_Recurring_Structured();
        createNewEventPageEvents.FillDetails_Recurring_Structured();

        Assert.assertTrue(createNewEventPageEvents.isEventListingPresent());
    }
}
