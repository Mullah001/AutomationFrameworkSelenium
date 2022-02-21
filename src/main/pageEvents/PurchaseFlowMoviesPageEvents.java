package main.pageEvents;

import main.pageObjects.LogInPageElements;
import main.utils.CommonMethods;
import main.utils.FetchElement;
import main.utils.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import test.BaseTest;

import static main.data.WEB.LogInData.email_Shameem;
import static main.data.WEB.LogInData.password_Shameem;
import static main.data.WEB.PurchaseFlowData.*;
import static main.pageObjects.PurchaseFlowPageElements.*;

public class PurchaseFlowMoviesPageEvents extends CommonMethods {
    FetchElement fetchElement = new FetchElement();
    LogInPageEvents logInPageEvents = new LogInPageEvents();
    HomePageEvents homePageEvents = new HomePageEvents();
    long sleepSeconds = 1500L;
    int waitSeconds = 20;

    public void logInUser(){
        homePageEvents.clickOnSignIn();

        sleep(sleepSeconds);

        waitForElementPresent(BaseTest.driver, By.xpath(LogInPageElements.email),waitSeconds);
        logInPageEvents.enterEmail(email_Shameem);
        sleep(sleepSeconds);
        logInPageEvents.enterPassword(password_Shameem);
        sleep(sleepSeconds);

        logInPageEvents.clickLogInButton();
    }

    public void clickOnMoviesLink() {
        waitForElementPresent(BaseTest.driver, By.xpath(moviesLinkA_XPath), waitSeconds);
        fetchElement.getWebElement(Locator.XPath, moviesLinkA_XPath).click();
        sleep(sleepSeconds);
    }

    public void clickGodFatherMovie() {
        waitForElementPresent(BaseTest.driver, By.xpath(godFatherImg_XPath), 15);
        fetchElement.getWebElement(Locator.XPath, godFatherImg_XPath).click();
        sleep(sleepSeconds);
    }

    public void clickShowTimingSlot() {
        waitForElementPresent(BaseTest.driver, By.xpath(showTimingSlotDiv_XPath), waitSeconds);
        fetchElement.getWebElement(Locator.XPath, showTimingSlotDiv_XPath).click();
        sleep(sleepSeconds);
    }

    public void clickShowTimingsBuyButton() {
        sleep(sleepSeconds);
        fetchElement.getWebElement(Locator.XPath, showTimingsBuyButton_XPath).click();
        sleep(sleepSeconds);
    }

    public void clickAutoSelect() {
        waitForElementPresent(BaseTest.driver, By.xpath(autoSelectInput_XPath), waitSeconds);
        fetchElement.getWebElement(Locator.XPath, autoSelectInput_XPath).click();
        sleep(sleepSeconds);
    }

    public void typeGoldenRegular() {
        waitForElementPresent(BaseTest.driver, By.xpath(goldenRegularInput_XPath), waitSeconds);
        fetchElement.getWebElement(Locator.XPath, goldenRegularInput_XPath).sendKeys(goldenTickets);
        sleep(sleepSeconds);
    }

    public void typeBusinessRegular() {
        sleep(sleepSeconds);
        fetchElement.getWebElement(Locator.XPath, businessRegularInput_XPath).sendKeys(businessTickets);
        sleep(sleepSeconds);
    }

    public void typeBusinessTableRegular() {
        sleep(sleepSeconds);
        fetchElement.getWebElement(Locator.XPath, businessTableRegularInput_XPath).sendKeys(businessTableTickets);
        sleep(sleepSeconds);
    }

    public void typeVIPTableRegular() {
        sleep(sleepSeconds);
        fetchElement.getWebElement(Locator.XPath, vipTableRegularInput_XPath).sendKeys(vipTableTickets);
        sleep(sleepSeconds);
    }

    public void clickOnProceedToCheckoutButton() {
        waitForElementPresent(BaseTest.driver, By.xpath(proceedToCheckoutButton_XPath), waitSeconds);
        sleep(sleepSeconds);
        fetchElement.getWebElement(Locator.XPath, proceedToCheckoutButton_XPath).click();
        sleep(sleepSeconds);
    }

    public void clickOnWallet() {
        waitForElementPresent(BaseTest.driver, By.xpath(walletDiv_XPath), waitSeconds);
        fetchElement.getWebElement(Locator.XPath, walletDiv_XPath).click();
        sleep(sleepSeconds);
    }

    public void clickOnWalletPromptPay() {
        waitForElementPresent(BaseTest.driver, By.xpath(walletPromptPayButton_XPath), waitSeconds);
        fetchElement.getWebElement(Locator.XPath, walletPromptPayButton_XPath).click();
        sleep(sleepSeconds);
    }

    public boolean isSuccessImagePresent(){
        waitForElementPresent(BaseTest.driver, By.xpath(successImg_XPath), waitSeconds);
        return IsElementPresent(By.xpath(successImg_XPath));
    }

    public void scroll(){
        waitForElementPresent(BaseTest.driver, By.xpath(godFatherImg_XPath), waitSeconds);
        sleep(sleepSeconds);
        if (BaseTest.driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) BaseTest.driver).executeScript("window.scrollTo(0, 500);");
        } else {
            throw new IllegalStateException("This driver does not support JavaScript!");
        }
    }



}
