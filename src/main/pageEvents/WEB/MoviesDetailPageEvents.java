package main.pageEvents.WEB;

import main.utils.CommonMethods;
import main.utils.FetchElement;
import main.utils.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.BaseTest;

import static main.pageObjects.WEB.MoviesDetailPageElements.*;

public class MoviesDetailPageEvents extends CommonMethods {

    public WebDriver driver;

    public MoviesDetailPageEvents(WebDriver driver){
        this.driver = driver;
    }

    FetchElement fetchElement = new FetchElement(driver);
    LogInPageEvents logInPageEvents = new LogInPageEvents(driver);
    HomePageEvents homePageEvents = new HomePageEvents(driver);
    long sleepSeconds = 1500L;
    int waitSeconds = 20;

    public void clickOnMoviesLink() {
        waitForElementPresent( By.xpath(moviesLinkA_XPath), waitSeconds);
        fetchElement.getWebElement(Locator.XPath, moviesLinkA_XPath).click();
        sleep(sleepSeconds);
    }

    public void clickGodFatherMovie() {
        waitForElementPresent( By.xpath(godFatherImg_XPath), 15);
        fetchElement.getWebElement(Locator.XPath, godFatherImg_XPath).click();
        sleep(sleepSeconds);
    }

    public void clickShowTimingSlot() {
        waitForElementPresent( By.xpath(showTimingSlotDiv_XPath), waitSeconds);
        fetchElement.getWebElement(Locator.XPath, showTimingSlotDiv_XPath).click();
        sleep(sleepSeconds);
    }

    public void clickShowTimingsBuyButton() {
        sleep(sleepSeconds);
        fetchElement.getWebElement(Locator.XPath, showTimingsBuyButton_XPath).click();
        sleep(sleepSeconds);
    }

}
