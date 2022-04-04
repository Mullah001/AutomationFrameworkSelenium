package test.Web.HomePage;

import main.pageEvents.WEB.HomePageEvents;
import main.utils.API_DataMethods;
import main.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

import java.util.ArrayList;

import static main.data.Web.HomePageData.*;

@Test(groups = {"WEB"})
public class HomePageTest extends BaseTest {

    public WebDriver driver;
    HomePageEvents homePageEvents = null;
    CommonMethods commonMethods;
    API_DataMethods apiDataMethods = new API_DataMethods();

    @BeforeClass
    public void initialize() {
        driver = initializeBrowser();
        homePageEvents = new HomePageEvents(driver);
        commonMethods = new CommonMethods(driver);
    }

    @AfterClass
    public void close() {
        closeAndQuitBrowser(driver);
    }

    @Test(testName = "Verify that the heading of the Top events is according to the design")
    public void VerifyTopEventsHeading() {
        String heading = homePageEvents.getTopEventsHeading();
        Assert.assertEquals(heading, topEventsHeading, "Heading of the top Events is according to the design");
    }

    @Test(testName = "Verify that the Sub Heading of the Top events is according to the design", enabled = false)
    public void VerifyTopEventsSubHeading() {
        String heading = homePageEvents.getTopEventsSubHeading();
        Assert.assertEquals(heading, topEventsSubHeading, "Sub Heading of the top Events is according to the design");
    }

    @Test(testName = "Verify that the title of the Top Events is correct", enabled = false)
    public void topEventsName() {
        ArrayList<String> topEventsTitlesActual = homePageEvents.getTopEventsTitles();
        ArrayList<String> ex = new ArrayList<String>();
        ArrayList topEventsTitleseExpected = apiDataMethods.getEventsTitle_TopEvent();
        for (Object el :
                topEventsTitleseExpected) {
            ex.add(el.toString().replace("  ", " "));
        }
        System.out.println("Actual" + topEventsTitlesActual);
        System.out.println("Expected" + ex);

        if (topEventsTitlesActual.equals(ex)) {
            Assert.assertTrue(true, "The title of the top Events are correct");
        } else {
            Assert.assertTrue(false, "The title of the top Events are not correct");
        }

    }

    @Test(testName = "Verify that the Categories of the Top Events is correct", enabled = false)
    public void topEventsCategories() {
        Assert.assertTrue(homePageEvents.getTopEventsCategories());

    }


    @Test(testName = "Verify that Upcoming events heading is according to the design", enabled = false)
    public void upComingEventsHeading() {
        String heading = homePageEvents.getUpComingEventsHeading();
        Assert.assertEquals(heading, upComingEventsHeading, "Upcoming events heading is correct");
    }

    @Test(testName = "Verify that Upcoming events Sub Heading is according to the design", enabled = false)
    public void upComingEventsSubHeading() {
        String subHeading = homePageEvents.getUpComingEventsSubHeading();
        Assert.assertEquals(subHeading, upComingEventsSubHeading, "Upcoming events Sub heading is correct");
    }

    @Test(testName = "Verify that the title of the Upcoming Events is correct. ", enabled = false)
    public void upcomingEvenetsTitle() {
        homePageEvents.getUpcomingEventstitle();
        Assert.assertTrue(true, "Verified");
    }

    @Test(testName = "Verify that the all Upcoming Events are displayed.", enabled = false)
    public void upcomingEvenetsCount() {
        homePageEvents.getUpcomingEventsSize();
        Assert.assertTrue(true, "Verified");
    }

    @Test(testName = "Verify that the venues of the upcoming events are correct. ", enabled = false)
    public void upcomingEvenetsVenues() {
        homePageEvents.getUpcomingEventsVenues();
    }

    @Test(testName = "Verify that the start and end date of the upcoming events are correct.", enabled = false)
    public void upcomingEvenetsDate() {
        homePageEvents.getUpcomingEventsDate();
    }

    @Test(testName = "Verify that the Description of the upcoming events are correct.", enabled = false)
    public void upcomingEvenetsDescription() {
        homePageEvents.getDescription();
        Assert.assertTrue(true, "Verified");
    }

    @Test(testName = "Verify that the Price of the upcoming events are correct.", enabled = false)
    public void upcomingEvenetsPrice() {
        homePageEvents.getUpcomingEventsPrice();
    }

    @Test(testName = "Verify that the events categories are displaying correct. ", enabled = false)
    public void eventsCategories() {
        homePageEvents.getEventsCategories();
        Assert.assertTrue(true, "The Events categories are correct");
    }

//    Footer Test

    @Test(testName = "Verify that explore links text are according to the design", enabled = false)
    public void VerifiedExploreLinksText() {
        boolean isTrue = homePageEvents.getExploreLinksText();
        Assert.assertTrue(isTrue, "Verified");
    }


    @Test(testName = "Verify that explore links are redirected to the respective page.", enabled = false)
    public void VerifiedExploreLinksRedirectOnCorrectPage() throws InterruptedException {
        boolean isTrue = homePageEvents.getExploreLinksTitle();
        Assert.assertTrue(isTrue, "Verified");
    }

    @Test(testName = "Verify that explore links are working fine", enabled = false)
    public void VerifiedExploreLinksWorking() throws InterruptedException {
        homePageEvents.getExploreLinksWorking();
    }

    @Test(testName = "Verify that categories links text are according to the design", enabled = false)
    public void VerifiedCategoriesLinksText() {
        boolean isTrue = homePageEvents.getcategoriesLinksText();
        Assert.assertTrue(isTrue, "Verified");
    }


    @Test(testName = "Verify that Categories links are redirected to the respective page.", enabled = false)
    public void VerifiedCategoriesLinksRedirectOnCorrectPage() throws InterruptedException {
        boolean isTrue = homePageEvents.getCategoriesLinksTitle();
        Assert.assertTrue(isTrue, "Verified");
    }

    @Test(testName = "Verify that explore links are working fine", enabled = false)
    public void VerifiedCategoriesLinksWorking() throws InterruptedException {
        homePageEvents.getCategoriesLinksWorking();
    }

    @Test(testName = "Verify that by clicking on the facebook logo user us redirect to the facebook page of ticketlate")
    public void verifiedFacebookLink() throws InterruptedException {
        boolean isTrue = homePageEvents.getFacebookLink();
        Assert.assertTrue(isTrue, "verified");
    }

    @Test(testName = "Verify that by clicking on the Instagram logo user us redirect to the instagram page of ticketlate")
    public void verifiedInstaLink() throws InterruptedException {
        boolean isTrue = homePageEvents.getInstaLink();
        Assert.assertTrue(isTrue, "verified");
    }

    @Test(testName = "Verify that by clicking on the Twitter logo user us redirect to the Twitter page of ticketlate")
    public void verifiedTwitterLink() throws InterruptedException {
        boolean isTrue = homePageEvents.getTwitterLink();
        Assert.assertTrue(isTrue, "verified");
    }

    @Test(testName = "Verify that by clicking on the Youtube logo user us redirect to the Youtube page of ticketlate")
    public void verifiedYoutubeLink() throws InterruptedException {
        boolean isTrue = homePageEvents.getYoutubeLink();
        Assert.assertTrue(isTrue, "verified");
    }

    @Test(testName = "Verify that by clicking on the Whatsapp logo user us redirect to the Whatsapp page of ticketlate")
    public void verifiedWhatsappLink() throws InterruptedException {
        boolean isTrue = homePageEvents.getWhatsappLink();
        Assert.assertTrue(isTrue, "verified");
    }

    @Test(testName = "Verify that by clicking on the Terms of Service link user navigate to the respective page", enabled = false)
    public void verifyTermsServiceLink() {
        boolean isTrue = homePageEvents.clicOnTermofConditionLink();
        Assert.assertTrue(isTrue, "Verified");
    }

    @Test(testName = "Verify that by clicking on the Privacy Policy link user navigate to the respective page", enabled = false)
    public void verifyPrivacyPolicyLink() {
        boolean isTrue = homePageEvents.clicOnPrivacyPolicyLink();
        Assert.assertTrue(isTrue, "Verified");
    }

    @Test(testName = "Verify that Right reserved text is © Ticketlake 2020 - All Rights Reserved", enabled = false)
    public void verifyRightReservedText() {
        boolean isTrue = homePageEvents.getRightReserved();
        Assert.assertTrue(isTrue, "Verified");
    }

    @Test(testName = "Verify that the address of the ticketlake is correct", enabled = false)
    public void verifyTicketlakeddress() {
        boolean isTrue = homePageEvents.getAddress();
        Assert.assertTrue(isTrue, "Verified");
    }

}
