package main.pageEvents;

import main.pageObjects.HomePageElements;
import main.utils.FetchElement;
import main.utils.Locator;

public class HomePageEvents {

    FetchElement fetchElement = new FetchElement();

    public void clickOnSignIn(){
        fetchElement.getWebElement(Locator.CssSelector, HomePageElements.signIn).click();
    }

}