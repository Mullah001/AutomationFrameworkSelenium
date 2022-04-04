package main.pageEvents.WEB;

import main.pageObjects.WEB.HeaderpageElements;
import main.utils.FetchElement;
import main.utils.Locator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

import static main.pageObjects.WEB.HeaderpageElements.*;

public class HeaderPageEvents {

    public WebDriver driver;
    FetchElement fetchElement;

    public HeaderPageEvents(WebDriver driver) {
        this.driver = driver;
        fetchElement = new FetchElement(driver);
    }

    public void hoverOnEvents() {
        Actions action = new Actions(driver);
        WebElement events = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.events);
        action.moveToElement(events).build().perform();
    }

    public WebElement getEventsDropdownVisible() {
        hoverOnEvents();
        return fetchElement.getWebElement(Locator.XPath, HeaderpageElements.eventsDropdown);
    }

    public ArrayList getEventsCategories() {
        hoverOnEvents();
        ArrayList eventSubCategories = new ArrayList();

        int eventCategoriesSize = fetchElement.getListOfWebElements(Locator.XPath, HeaderpageElements.eventsCategories).size();
        for (int i = 0; i < eventCategoriesSize; i++) {

            String name = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.eventsCategories + "[" + (i + 1) + "]").getText();
            eventSubCategories.add(name);
        }
        return eventSubCategories;
    }


    public ArrayList checkEventsLink() {

        ArrayList eventsSubCategories = new ArrayList();
        int eventsCategoriesSize = fetchElement.getListOfWebElements(Locator.XPath, HeaderpageElements.eventsCategories).size();
        for (int i = 0; i < eventsCategoriesSize; i++) {
            WebElement eventsElement = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.eventsCategories + "[" + (i + 1) + "]");
            eventsSubCategories.add(eventsElement);
        }
        return eventsSubCategories;

    }


    public void hoverOnMovies() {
        Actions action = new Actions(driver);
        WebElement movies = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.movies);
        action.moveToElement(movies).build().perform();

    }

    public WebElement getMoviesDropdownVisible() {
        hoverOnMovies();
        WebElement moviesDropdown = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.moviesDropdown);
        return moviesDropdown;
    }

    public ArrayList getMoviesCategories() {
        hoverOnMovies();
        ArrayList movieSubCategories = new ArrayList();

        int moviesCategoriesSize = fetchElement.getListOfWebElements(Locator.XPath, HeaderpageElements.moviesCategories).size();
        for (int i = 0; i < moviesCategoriesSize; i++) {


            String name = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.moviesCategories + "[" + (i + 1) + "]").getText();
            //System.out.println("n: " + name);
            movieSubCategories.add(name);
        }

        return movieSubCategories;
    }

    public ArrayList CheckMoviesLinks() {

        ArrayList subCategories = new ArrayList();
        int categoriesSize = fetchElement.getListOfWebElements(Locator.XPath, HeaderpageElements.moviesCategories).size();
        for (int i = 0; i < categoriesSize; i++) {
            WebElement moviesElement = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.moviesCategories + "[" + (i + 1) + "]");
            subCategories.add(moviesElement);
        }
        return subCategories;

    }


    public void hoverOnSports() {
        Actions action = new Actions(driver);
        WebElement sports = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.sports);
        action.moveToElement(sports).build().perform();
    }

    public WebElement getSportsDropdownVisible() {
        hoverOnSports();
        WebElement sportsDropdown = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.sportsDropdown);
        return sportsDropdown;
    }

    public ArrayList getSportsCategories() {
        hoverOnSports();
        ArrayList sportsSubCategories = new ArrayList();

        int sportsCategoriesSize = fetchElement.getListOfWebElements(Locator.XPath, HeaderpageElements.sportsCategories).size();
        for (int i = 0; i < sportsCategoriesSize; i++) {


            String name = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.sportsCategories + "[" + (i + 1) + "]").getText();
            sportsSubCategories.add(name);
        }
        return sportsSubCategories;
    }

    public ArrayList CheckSportsLinks() {

        ArrayList sportsSubCategories = new ArrayList();
        int sportsCategoriesSize = fetchElement.getListOfWebElements(Locator.XPath, HeaderpageElements.sportsCategories).size();
        for (int i = 0; i < sportsCategoriesSize; i++) {
            WebElement moviesElement = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.sportsCategories + "[" + (i + 1) + "]");
            sportsSubCategories.add(moviesElement);
        }
        return sportsSubCategories;

    }

    public void hoverOnGlobal() {
        Actions action = new Actions(driver);
        WebElement global = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.global);
        action.moveToElement(global).build().perform();
    }

    public WebElement getGlobalDropdownVisiable() {
        hoverOnGlobal();
        WebElement GlobalDropdown = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.globalDropdown);
        return GlobalDropdown;
    }

    public ArrayList getGlobalscategories() {
        hoverOnGlobal();
        ArrayList globalSubCategories = new ArrayList();

        int globalCategoriesSize = fetchElement.getListOfWebElements(Locator.XPath, HeaderpageElements.globalCategories).size();
        for (int i = 0; i < globalCategoriesSize; i++) {


            String name = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.globalCategories + "[" + (i + 1) + "]").getText();
            globalSubCategories.add(name);
        }
        return globalSubCategories;
    }

    public ArrayList CheckGlobalLinks() {

        ArrayList globalSubCategories = new ArrayList();
        int globalCategoriesSize = fetchElement.getListOfWebElements(Locator.XPath, HeaderpageElements.globalCategories).size();
        for (int i = 0; i < globalCategoriesSize; i++) {
            WebElement sportsElement = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.globalCategories + "[" + (i + 1) + "]");
            globalSubCategories.add(sportsElement);
        }
        return globalSubCategories;

    }

    public void hoverOnNearby() {
        Actions action = new Actions(driver);
        WebElement nearby = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.nearby);
        action.moveToElement(nearby).build().perform();
    }

    public WebElement getNearbyDropdownVisiable() {
        hoverOnNearby();
        WebElement nearbyDropdown = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.nearbyDropdown);
        return nearbyDropdown;
    }

    public ArrayList getNearybycategories() {
        hoverOnNearby();
        ArrayList nearybySubCategories = new ArrayList();

        int nearybyCategoriesSize = fetchElement.getListOfWebElements(Locator.XPath, HeaderpageElements.nearbyCategories).size();
        for (int i = 0; i < nearybyCategoriesSize; i++) {


            String name = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.nearbyCategories + "[" + (i + 1) + "]").getText();
            nearybySubCategories.add(name);
        }
        return nearybySubCategories;
    }


    public ArrayList CheckNearbyLinks() {

        ArrayList nearbySubCategories = new ArrayList();
        int nearybyCategoriesSize = fetchElement.getListOfWebElements(Locator.XPath, HeaderpageElements.nearbyCategories).size();
        for (int i = 0; i < nearybyCategoriesSize; i++) {
            WebElement nearbyElement = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.nearbyCategories + "[" + (i + 1) + "]");
            nearbySubCategories.add(nearbyElement);
        }
        return nearbySubCategories;

    }

    public String getVotingText() {
        String votingText = fetchElement.getWebElement(Locator.XPath, HeaderpageElements.voting).getText();
        return votingText;
    }

    public void clickOnVoting() {
        fetchElement.getWebElement(Locator.XPath, HeaderpageElements.voting).click();
    }

    public boolean getMasterSearch() {
        fetchElement.getWebElement(Locator.XPath, masterSearch).sendKeys("learn");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (fetchElement.getWebElement(Locator.XPath, masterSearchResult).isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean getCountryFilter() {
        fetchElement.getWebElement(Locator.XPath, countryFilter).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (fetchElement.getWebElement(Locator.XPath, countryFilterListing).isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean getchangedCountry() throws InterruptedException {
        getCountryFilter();
        fetchElement.getWebElement(Locator.XPath, countrFilterInput).sendKeys("Ghana");
        Thread.sleep(1000);
        fetchElement.getWebElement(Locator.XPath, newCountry).click();
        Thread.sleep(1000);
        String newCountry = fetchElement.getWebElement(Locator.XPath, getNewCountryName).getText();
        System.out.println(newCountry);
        String n = "GH";
        if (newCountry.equals(n)) {
            return true;
        }
        return false;
    }

}
