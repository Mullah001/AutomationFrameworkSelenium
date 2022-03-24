package test.Web.PurchaseFlowMovies;

import main.pageEvents.MoviesDetailPageEvents;
import main.pageEvents.PurchaseFlowPageEvents;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

@Test(groups = {"WEB"})
public class PurchaseFlowTest extends BaseTest {
    PurchaseFlowPageEvents purchaseFlowPageEvents = new PurchaseFlowPageEvents();
    MoviesDetailPageEvents moviesDetailPageEvents = new MoviesDetailPageEvents();

    @Test(testName = "Verify the Purchase Flow")
    public void verifyPurchaseFlow(){
        purchaseFlowPageEvents.logInUser();

        moviesDetailPageEvents.clickOnMoviesLink();

        purchaseFlowPageEvents.scroll();
        moviesDetailPageEvents.clickGodFatherMovie();

        moviesDetailPageEvents.clickShowTimingSlot();

        moviesDetailPageEvents.clickShowTimingsBuyButton();

        purchaseFlowPageEvents.clickAutoSelect();

        purchaseFlowPageEvents.ticketClassesSelection();

        purchaseFlowPageEvents.clickOnProceedToCheckoutButton();

        purchaseFlowPageEvents.clickOnWallet();

        purchaseFlowPageEvents.clickOnWalletPromptPay();

        boolean isSuccess = purchaseFlowPageEvents.isSuccessImagePresent();

        Assert.assertTrue(isSuccess, "Success Message should be displayed");
    }
}
