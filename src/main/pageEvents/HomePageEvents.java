package main.pageEvents;

import main.pageObjects.HomePageElements;
import main.utils.FetchElement;
import main.utils.Locator;
import test.BaseTest;

public class HomePageEvents {

    FetchElement fetchElement = new FetchElement();

    public void clickOnSignInButton(){
        fetchElement.getWebElement(Locator.XPath,HomePageElements.loginButton).click();
    }

    public String getHeroText() {
        BaseTest.extentTestLogger.info("Verifying Home Page Hero Text.");
        return fetchElement.getWebElement(Locator.XPath, HomePageElements.heroTitle).getText();
    }
}