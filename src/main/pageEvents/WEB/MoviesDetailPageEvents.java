package main.pageEvents.WEB;

import main.utils.CommonMethods;
import main.utils.FetchElement;
import main.utils.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static main.pageObjects.WEB.MoviesDetailPageElements.*;
import static main.utils.CommonMethods.sleep;

public class MoviesDetailPageEvents {

    public WebDriver driver;
    CommonMethods commonMethods;

    public MoviesDetailPageEvents(WebDriver driver) {
        this.driver = driver;
        fetchElement = new FetchElement(driver);
        logInPageEvents = new LogInPageEvents(driver);
        homePageEvents = new HomePageEvents(driver);
        commonMethods = new CommonMethods(driver);
    }

    FetchElement fetchElement;
    LogInPageEvents logInPageEvents;
    HomePageEvents homePageEvents;
    long sleepSeconds = 1500L;
    int waitSeconds = 20;

    public void clickOnMoviesLink() {
        commonMethods.waitForElementPresent(By.xpath(moviesLinkA_XPath), waitSeconds);
        fetchElement.getWebElement(Locator.XPath, moviesLinkA_XPath).click();
        sleep(sleepSeconds);
    }

    public void clickGodFatherMovie() {
        commonMethods.waitForElementPresent(By.xpath(godFatherImg_XPath), 15);
        fetchElement.getWebElement(Locator.XPath, godFatherImg_XPath).click();
        sleep(sleepSeconds);
    }

    public void clickShowTimingSlot() {
        commonMethods.waitForElementPresent(By.xpath(showTimingSlotDiv_XPath), waitSeconds);
        fetchElement.getWebElement(Locator.XPath, showTimingSlotDiv_XPath).click();
        sleep(sleepSeconds);
    }

    public void clickShowTimingsBuyButton() {
        sleep(sleepSeconds);
        fetchElement.getWebElement(Locator.XPath, showTimingsBuyButton_XPath).click();
        sleep(sleepSeconds);
    }

}
