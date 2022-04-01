package test.Web.PurchaseFlowMovies;

import main.pageEvents.WEB.EventsDetailPageEvents;
import main.pageEvents.WEB.HomePageEvents;
import main.pageEvents.WEB.MoviesDetailPageEvents;
import main.pageEvents.WEB.PurchaseFlowPageEvents;
import main.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

import static main.data.ADMIN.CreateNewEventData.*;

@Test(groups = {"WEB"})
public class MoviesPurchaseFlowTest extends BaseTest {
    PurchaseFlowPageEvents purchaseFlowPageEvents = new PurchaseFlowPageEvents();
    MoviesDetailPageEvents moviesDetailPageEvents = new MoviesDetailPageEvents();
    HomePageEvents homePageEvents = new HomePageEvents();
    EventsDetailPageEvents eventsDetailPageEvents = new EventsDetailPageEvents();

    @Test(testName = "Verify the Purchase Flow")
    public void verifyPurchaseFlow() throws InterruptedException {

        BaseTest.driver.navigate().to(Constants.WebBaseUrl);
        purchaseFlowPageEvents.logInUser();

        homePageEvents.clickOnCountryDropdown();
        homePageEvents.clickOnCountrySearchField();
        homePageEvents.enterCountryName();
        homePageEvents.clickOnCountryName();

        sleep(5000l);

        if(eventCategory == "Movies"){

//          MOVIES PURCHASE FLOW PREREQUISTIES
            homePageEvents.typeTitleInMasterSearch(eventTitle_Standard_Structured);
            homePageEvents.clickMasterSearchResult(eventTitle_Standard_Structured);
            purchaseFlowPageEvents.scroll();
            moviesDetailPageEvents.clickShowTimingSlot();
            moviesDetailPageEvents.clickShowTimingsBuyButton();
        }else if(eventCategory == "Events"){

//          EVENTS PURCHASE FLOW PREREQUISTIES
            homePageEvents.typeTitleInMasterSearch(eventTitle_Standard_Structured);
            homePageEvents.clickMasterSearchResult(eventTitle_Standard_Structured);
            eventsDetailPageEvents.clickOnBuyNowAndSeeDetailsButton(); // For Standard events

//          For Series and recur events

//          eventsDetailPageEvents.getSeeDetailsButton();
//          eventsDetailPageEvents.getSlotSelection();
//          eventsDetailPageEvents.getProcssedToCheckout();
        }

//      PURCHASE FLOW

        purchaseFlowPageEvents.clickAutoSelect();
        purchaseFlowPageEvents.ticketClassesSelection();
        purchaseFlowPageEvents.clickOnProceedToCheckoutButton();
        purchaseFlowPageEvents.clickOnWallet();
        purchaseFlowPageEvents.clickOnWalletPromptPay();

        boolean isSuccess = purchaseFlowPageEvents.isSuccessImagePresent();
        Assert.assertTrue(isSuccess, "Success Message should be displayed");
    }
}
