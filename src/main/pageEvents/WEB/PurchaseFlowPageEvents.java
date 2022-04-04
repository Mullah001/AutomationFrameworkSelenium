package main.pageEvents.WEB;

import main.pageObjects.WEB.LogInPageElements;
import main.utils.CommonMethods;
import main.utils.FetchElement;
import main.utils.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.BaseTest;

import java.util.List;

import static main.data.WEB.LogInData.email_Shameem;
import static main.data.WEB.LogInData.password_Shameem;
import static main.pageObjects.WEB.MoviesDetailPageElements.godFatherImg_XPath;
import static main.pageObjects.WEB.PurchaseFlowPageElements.*;
import static main.utils.CommonMethods.sleep;

public class PurchaseFlowPageEvents {

    public WebDriver driver;
    CommonMethods commonMethods;
    FetchElement fetchElement;
    LogInPageEvents logInPageEvents;
    HomePageEvents homePageEvents;
    long sleepSeconds = 1500L;
    int waitSeconds = 20;

    public PurchaseFlowPageEvents(WebDriver driver) {
        this.driver = driver;
        fetchElement = new FetchElement(driver);
        logInPageEvents = new LogInPageEvents(driver);
        homePageEvents = new HomePageEvents(driver);
        commonMethods = new CommonMethods(driver);
    }

    public void logInUser() {
        homePageEvents.clickOnSignIn();

        sleep(sleepSeconds);

        commonMethods.waitForElementPresent(By.xpath(LogInPageElements.email), waitSeconds);
        logInPageEvents.enterEmail(email_Shameem);
        sleep(sleepSeconds);
        logInPageEvents.enterPassword(password_Shameem);
        sleep(sleepSeconds);

        logInPageEvents.clickLogInButton();
    }


    public void clickAutoSelect() {
        commonMethods.waitForElementPresent(By.xpath(autoSelectInput_XPath), waitSeconds);
        fetchElement.getWebElement(Locator.XPath, autoSelectInput_XPath).click();
        sleep(sleepSeconds);
    }

    public void ticketClassesSelection() {
        commonMethods.waitForElementPresent(By.xpath(ticketclasses), waitSeconds);
        List<WebElement> ticketClasses = fetchElement.getListOfWebElements(Locator.XPath, ticketclasses);
        for (int i = 0; i < ticketClasses.size(); i++) {
            ticketClasses.get(i).sendKeys("2");
        }
        sleep(sleepSeconds);
    }


    public void clickOnProceedToCheckoutButton() {
        commonMethods.waitForElementPresent(By.xpath(proceedToCheckoutButton_XPath), waitSeconds);
        sleep(sleepSeconds);
        fetchElement.getWebElement(Locator.XPath, proceedToCheckoutButton_XPath).click();
        sleep(sleepSeconds);
    }

    public void clickOnWallet() {
        commonMethods.waitForElementPresent(By.xpath(walletDiv_XPath), waitSeconds);
        fetchElement.getWebElement(Locator.XPath, walletDiv_XPath).click();
        sleep(sleepSeconds);
    }

    public void clickOnWalletPromptPay() {
        commonMethods.waitForElementPresent(By.xpath(walletPromptPayButton_XPath), waitSeconds);
        fetchElement.getWebElement(Locator.XPath, walletPromptPayButton_XPath).click();
        sleep(sleepSeconds);
    }

    public boolean isSuccessImagePresent() {
        commonMethods.waitForElementPresent(By.xpath(successImg_XPath), waitSeconds);
        return commonMethods.IsElementPresent(By.xpath(successImg_XPath));
    }

    public void scroll() {
        commonMethods.waitForElementPresent(By.xpath(godFatherImg_XPath), waitSeconds);
        sleep(sleepSeconds);
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 500);");
        } else {
            throw new IllegalStateException("This driver does not support JavaScript!");
        }
    }


}
