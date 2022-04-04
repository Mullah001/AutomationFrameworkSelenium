package main.pageEvents.WEB;

import main.data.Web.HomePageData;
import main.utils.API_DataMethods;
import main.utils.CommonMethods;
import main.utils.FetchElement;
import main.utils.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static main.data.Web.HomePageData.*;
import static main.pageObjects.WEB.HomePageElements.*;
import static main.utils.CommonMethods.sleep;

public class HomePageEvents {

    public WebDriver driver;
    FetchElement fetchElement = null;
    CommonMethods commonMethods;

    public HomePageEvents(WebDriver driver){
        this.driver = driver;
       fetchElement = new FetchElement(driver);
       commonMethods = new CommonMethods(driver);
    }

    API_DataMethods apiDataMethods = new API_DataMethods();

    public void clickOnSignIn(){
        fetchElement.getWebElement(Locator.CssSelector, signIn).click();
    }

    public String getTopEventsHeading(){
        return fetchElement.getWebElement(Locator.XPath, topEventHeading).getText();
    }

    public String getTopEventsSubHeading(){
        return fetchElement.getWebElement(Locator.XPath, topEventSubHeading).getText();
    }

    public ArrayList<String> getTopEventsTitles(){
        ArrayList topEventsTitlesArray = new ArrayList();
        List <WebElement>  topEventsTitle = fetchElement.getListOfWebElements(Locator.XPath, topEventsTtile);
        for (int i = 0; i < topEventsTitle.size(); i++){
            String name = topEventsTitle.get(i).getText();
            topEventsTitlesArray.add(name);
        }
        return topEventsTitlesArray;
    }

    public boolean getTopEventsCategories(){
        ArrayList topEventsCategoriesArray = new ArrayList();
        ArrayList topEventsCategoriesAPI = apiDataMethods.getCategories_Title_TopEvent();
        int  topEventsCategoriesCount = fetchElement.getListOfWebElements(Locator.XPath,topEventsgalleryContent).size();
        for (int i = 0; i < topEventsCategoriesCount; i++){
            String name = topEventsCategoriesAPI.get(i).toString();
            String path = "//div[contains(@class,'gallery-items')]/a["+(i+1)+"]//div[@class='listing-item-cat']/p/span";
            List<WebElement> elements = fetchElement.getListOfWebElements(Locator.XPath, path);
            int count = elements.size();
            for (int j = 0; j < count; j++)
            {
                if (!name.contains(elements.get(j).getText().replace(",","").replace(" ","").replace("&","")))
                {
             return false;
                }
            }
            topEventsCategoriesArray.add(name);
        }
        return true;
    }

    public String getUpComingEventsHeading(){
        return fetchElement.getWebElement(Locator.XPath, upComingEventsHeadingXPath).getText();
    }

    public String getUpComingEventsSubHeading(){
        return fetchElement.getWebElement(Locator.XPath, upComingEventsSubHeadingXPath).getText();
    }

    public boolean getUpcomingEventsSize() {
        int apiCount = apiDataMethods.getEvents_Title_UpComingEvents().size();
        int webCount = fetchElement.getListOfWebElements(Locator.XPath, upcomingeventsCount).size();
        return apiCount == webCount;
    }

    public boolean getUpcomingEventstitle(){
        ArrayList eventtitlesAPI = apiDataMethods.getEvents_Title_UpComingEvents();
        String title = fetchElement.getWebElement(Locator.XPath, upcomingEventTitle).getAttribute("title");
        for (int i = 0; i < eventtitlesAPI.size(); i++) {
            if(eventtitlesAPI.contains(title)){
                return true;
            }
            return false;
        }
        return false;
    }

    public void getUpcomingEventsVenues(){
        ArrayList webVenuesArray = new ArrayList();
        ArrayList apiVenues = apiDataMethods.getEvents_VenuesName_UpComingEvents();
        System.out.println(apiVenues);
        int webVenuesCount = fetchElement.getListOfWebElements(Locator.XPath, upComingEventsVenue).size();
        for (int i = 0; i < webVenuesCount; i++) {
            String name = apiVenues.get(i).toString();
        }

    }

    public void getUpcomingEventsDate(){
        ArrayList apiDates = apiDataMethods.getEvents_Date_UpComingEvents();
        System.out.println("API "+apiDates);
        String date = fetchElement.getWebElement(Locator.XPath, upComingEventsDate).getText();
        System.out.println("Web "+date);
    }

    public boolean getDescription(){
        String description = fetchElement.getWebElement(Locator.XPath, upComingEventsDescription).getText();
        ArrayList apiDescription = apiDataMethods.getEvents_Description_UpComingEvents();
        for (int i = 0; i < apiDescription.size(); i++) {
            if(apiDescription.contains(description)){
                return true;
            }
            return false;
        }
        return false;

    }

    public void getUpcomingEventsPrice(){
        String price = fetchElement.getWebElement(Locator.XPath, upComingEventsPrice).getText();
        String sorprice =price.replace("-", "").replace("GHS", "").replace("Buy", "");
        System.out.println(sorprice);
        ArrayList apiMinPrices = apiDataMethods.getEvents_eventMinimumTicketClassPrice_UpComingEvents();
        ArrayList apiMaxPrice = apiDataMethods.getEvents_eventMaximumTicketClassPrice_UpComingEvents();
        System.out.println(apiMinPrices +" " +apiMaxPrice);
    }

    public boolean getEventsCategories(){
        List<WebElement> eventsCategories = fetchElement.getListOfWebElements(Locator.XPath, eventsCategoriesXPath);
        ArrayList eventsCategoriesData = HomePageData.eventsCategories;
        for (int i = 0; i < eventsCategories.size(); i++) {
            String cat = eventsCategories.get(i).getText();
            fetchElement.getWebElement(Locator.XPath, nextArrow).click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(eventsCategoriesData.contains(eventsCategories)){
                return true;
            }
            return false;
        }
        return false;
    }

    //Footer events

    public boolean getExploreLinksText() {
        List<WebElement> links = fetchElement.getListOfWebElements(Locator.XPath, exploreLinks);
        ArrayList exploreText = new ArrayList();
        for (int i = 0; i < links.size(); i++) {
            String text = links.get(i).getText();
            exploreText.add(text);
        }
        if(exploreText.equals(footerExploreLinksText)){
            return true;
        }
        return false;
    }

    public boolean getExploreLinksTitle() throws InterruptedException {
        List<WebElement> links = fetchElement.getListOfWebElements(Locator.XPath, exploreLinks);
        ArrayList titleList = new ArrayList();
        for (int i = 0; i < links.size()-1; i++) {
            links.get(i).click();
            Thread.sleep(2000);
            String title = driver.getTitle();
            titleList.add(title);
        }
        if(titleList.equals(footerExploreLinksTitle)){
            return true;
        }
        return false;
    }

    public void getExploreLinksWorking() throws InterruptedException {
        List<WebElement> links = fetchElement.getListOfWebElements(Locator.XPath, exploreLinks);
        for (int i = 0; i < links.size(); i++) {
            links.get(i).click();
            Thread.sleep(2000);
            driver.navigate().back();
        }

    }


    public boolean getcategoriesLinksText() {
        List<WebElement> links = fetchElement.getListOfWebElements(Locator.XPath, categoriesLinks);
        ArrayList categoriesText = new ArrayList();
        for (int i = 0; i < links.size(); i++) {
            String text = links.get(i).getText();
            categoriesText.add(text);
        }
        if(categoriesText.equals(footerCategoriesLinksText)){
            return true;
        }
        return false;
    }

    public boolean getCategoriesLinksTitle() throws InterruptedException {
        List<WebElement> links = fetchElement.getListOfWebElements(Locator.XPath, categoriesLinks);
        ArrayList titleList = new ArrayList();
        for (int i = 0; i < links.size(); i++) {
            links.get(i).click();
            Thread.sleep(2000);
            String title = driver.getTitle();
            titleList.add(title);
        }
        if(titleList.equals(footerCategoriesLinksTitle)){
            return true;
        }
        return false;
    }

    public void getCategoriesLinksWorking() throws InterruptedException {
        List<WebElement> links = fetchElement.getListOfWebElements(Locator.XPath, categoriesLinks);
        for (int i = 0; i < links.size(); i++) {
            links.get(i).click();
            Thread.sleep(2000);
            driver.navigate().back();
        }
    }

    public boolean getFacebookLink() throws InterruptedException {
        fetchElement.getWebElement(Locator.XPath, facebookLink).click();
        for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
        }
        Thread.sleep(1000);
        String url = driver.getCurrentUrl();
        if(url.toLowerCase().contains("facebook")){
            return true;
        }
        return false;
    }

    public boolean getInstaLink() throws InterruptedException {
        fetchElement.getWebElement(Locator.XPath, instaLink).click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(1000);
        String url = driver.getCurrentUrl();
        if(url.toLowerCase().contains("instagram")){
            return true;
        }
        return false;

    }

    public boolean getTwitterLink() throws InterruptedException {
        fetchElement.getWebElement(Locator.XPath, twitterLink).click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(1000);
        String url = driver.getCurrentUrl();
        if(url.toLowerCase().contains("twitter")){
            return true;
        }
        return false;

    }

    public boolean getYoutubeLink() throws InterruptedException {
        fetchElement.getWebElement(Locator.XPath, youtubeLink).click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(1000);
        String url = driver.getCurrentUrl();
        if(url.toLowerCase().contains("youtube")){
            return true;
        }
        return false;

    }

    public boolean getWhatsappLink() throws InterruptedException {
        fetchElement.getWebElement(Locator.XPath, whatsappLink).click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(1000);
        String url = driver.getCurrentUrl();
        if(url.toLowerCase().contains("whatsapp")){
            return true;
        }
        return false;

    }

    public boolean clicOnTermofConditionLink(){
        fetchElement.getWebElement(Locator.XPath, termsOfService).click();
        String text = fetchElement.getWebElement(Locator.XPath, termsServiceHeading).getText();
        if(termServiceText.equals(text)){
            return true;
        }
        return false;
    }

    public boolean clicOnPrivacyPolicyLink(){
        fetchElement.getWebElement(Locator.XPath, privacyPolicy).click();
        String text = fetchElement.getWebElement(Locator.XPath, privacyPolicyHeading).getText();
        if(privaciPolicy.equals(text)){
            return true;
        }
        return false;
    }

    public boolean getRightReserved(){
        String text = fetchElement.getWebElement(Locator.XPath, rightReserved).getText();
        if(rightReservedtext.equals(text)){
            return true;
        }
        return false;
    }

    public boolean getAddress(){
        String text = fetchElement.getWebElement(Locator.XPath, address).getText();
        if(ticktlakeAddress.equals(text)){
            return true;
        }
        return false;
    }

    public void clickOnCountryDropdown(){
        fetchElement.getWebElement(Locator.XPath, countryDropdown).click();
    }
    public void clickOnCountrySearchField(){
        fetchElement.getWebElement(Locator.XPath, countryField).click();
    }
    public void enterCountryName(){
        fetchElement.getWebElement(Locator.XPath, countryField).sendKeys("United Arab Emirates");
    }

    public void clickOnCountryName(){
        fetchElement.getWebElement(Locator.XPath, countryName).click();
    }

    private String getNewEventTitle(String title)
    {
        return "//input[@placeholder='Search']/following-sibling::div//*[text()='" + title +"']";
    }

    public void typeTitleInMasterSearch(String search){
        fetchElement.getWebElement(Locator.XPath, searchField).sendKeys(search);
    }
    public void clickMasterSearchResult(String title) throws InterruptedException {
        Thread.sleep(3000);
        fetchElement.getWebElement(Locator.XPath, getNewEventTitle(title)).click();
    }

//  Profile dropdown

    public void clickProfileDropdown(){
        commonMethods.waitForElementPresentAndVisible(By.xpath(profileDropdown), 10);
        fetchElement.getWebElement(Locator.XPath, profileDropdown).click();
    }

    public void clickProfile(){
        sleep(3000L);
        fetchElement.getWebElement(Locator.XPath, profile).click();
    }
}