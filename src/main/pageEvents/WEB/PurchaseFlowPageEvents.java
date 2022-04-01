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

public class PurchaseFlowPageEvents extends CommonMethods {

    public WebDriver driver;

    public PurchaseFlowPageEvents(WebDriver driver){
        this.driver = driver;
    }

    FetchElement fetchElement = new FetchElement(driver);
    LogInPageEvents logInPageEvents = new LogInPageEvents(driver);
    HomePageEvents homePageEvents = new HomePageEvents(driver);
    long sleepSeconds = 1500L;
    int waitSeconds = 20;

    public void logInUser(){
        homePageEvents.clickOnSignIn();

        sleep(sleepSeconds);

        waitForElementPresent( By.xpath(LogInPageElements.email),waitSeconds);
        logInPageEvents.enterEmail(email_Shameem);
        sleep(sleepSeconds);
        logInPageEvents.enterPassword(password_Shameem);
        sleep(sleepSeconds);

        logInPageEvents.clickLogInButton();
    }


    public void clickAutoSelect() {
        waitForElementPresent( By.xpath(autoSelectInput_XPath), waitSeconds);
        fetchElement.getWebElement(Locator.XPath, autoSelectInput_XPath).click();
        sleep(sleepSeconds);
    }

    public void ticketClassesSelection() {
        waitForElementPresent( By.xpath(ticketclasses), waitSeconds);
        List<WebElement> ticketClasses = fetchElement.getListOfWebElements(Locator.XPath, ticketclasses);
        for (int i = 0; i<ticketClasses.size(); i++){
            ticketClasses.get(i).sendKeys("2");
        }
        sleep(sleepSeconds);
    }


    public void clickOnProceedToCheckoutButton() {
        waitForElementPresent( By.xpath(proceedToCheckoutButton_XPath), waitSeconds);
        sleep(sleepSeconds);
        fetchElement.getWebElement(Locator.XPath, proceedToCheckoutButton_XPath).click();
        sleep(sleepSeconds);
    }

    public void clickOnWallet() {
        waitForElementPresent( By.xpath(walletDiv_XPath), waitSeconds);
        fetchElement.getWebElement(Locator.XPath, walletDiv_XPath).click();
        sleep(sleepSeconds);
    }

    public void clickOnWalletPromptPay() {
        waitForElementPresent( By.xpath(walletPromptPayButton_XPath), waitSeconds);
        fetchElement.getWebElement(Locator.XPath, walletPromptPayButton_XPath).click();
        sleep(sleepSeconds);
    }

    public boolean isSuccessImagePresent(){
        waitForElementPresent( By.xpath(successImg_XPath), waitSeconds);
        return IsElementPresent(By.xpath(successImg_XPath));
    }

    public void scroll(){
        waitForElementPresent( By.xpath(godFatherImg_XPath), waitSeconds);
        sleep(sleepSeconds);
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 500);");
        } else {
            throw new IllegalStateException("This driver does not support JavaScript!");
        }
    }



}
