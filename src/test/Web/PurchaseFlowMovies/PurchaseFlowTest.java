package test.Web.PurchaseFlowMovies;

import main.pageEvents.PurchaseFlowMoviesPageEvents;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

import static main.pageObjects.PurchaseFlowPageElements.*;

@Test(groups = {"WEB"})
public class PurchaseFlowTest extends BaseTest {
    PurchaseFlowMoviesPageEvents purchaseFlowMoviesPageEvents = new PurchaseFlowMoviesPageEvents();

    @Test(testName = "Verify the Purchase Flow")
    public void verifyPurchaseFlow(){
        purchaseFlowMoviesPageEvents.logInUser();

        purchaseFlowMoviesPageEvents.clickOnMoviesLink();

        purchaseFlowMoviesPageEvents.scroll();
        purchaseFlowMoviesPageEvents.clickGodFatherMovie();

        purchaseFlowMoviesPageEvents.clickShowTimingSlot();

        purchaseFlowMoviesPageEvents.clickShowTimingsBuyButton();

        purchaseFlowMoviesPageEvents.clickAutoSelect();

        purchaseFlowMoviesPageEvents.typeGoldenRegular();
        purchaseFlowMoviesPageEvents.typeBusinessRegular();
        purchaseFlowMoviesPageEvents.typeBusinessTableRegular();
        purchaseFlowMoviesPageEvents.typeVIPTableRegular();

        purchaseFlowMoviesPageEvents.clickOnProceedToCheckoutButton();

        purchaseFlowMoviesPageEvents.clickOnWallet();

        purchaseFlowMoviesPageEvents.clickOnWalletPromptPay();

        boolean isSuccess = purchaseFlowMoviesPageEvents.isSuccessImagePresent();

        Assert.assertTrue(isSuccess, "Success Message should be displayed");
    }
}
