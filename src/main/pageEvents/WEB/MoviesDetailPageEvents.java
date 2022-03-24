package main.pageEvents.WEB;

import main.utils.CommonMethods;
import main.utils.FetchElement;
import main.utils.Locator;
import org.openqa.selenium.By;
import test.BaseTest;

import static main.pageObjects.WEB.MoviesDetailPageElements.*;

public class MoviesDetailPageEvents extends CommonMethods {
    FetchElement fetchElement = new FetchElement();
    LogInPageEvents logInPageEvents = new LogInPageEvents();
    HomePageEvents homePageEvents = new HomePageEvents();
    long sleepSeconds = 1500L;
    int waitSeconds = 20;

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

}
