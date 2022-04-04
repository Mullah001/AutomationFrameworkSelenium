package main.pageEvents.WEB;

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

import static main.pageObjects.WEB.MoviesPageElements.*;
import static main.utils.CommonMethods.sleep;

public class MoviesPageEvents {

    public WebDriver driver;
    CommonMethods commonMethods;
    FetchElement fetchElement;
    API_DataMethods api_dataMethods = new API_DataMethods();

    public MoviesPageEvents(WebDriver driver) {
        this.driver = driver;
        fetchElement = new FetchElement(driver);
        commonMethods = new CommonMethods(driver);
    }
    
    public void loadMoviesURLFromHeader() {
        String url = fetchElement.getWebElement(Locator.XPath, moviesLinkA_XPath).getAttribute("href");
        driver.navigate().to(url);
    }

    /*********************** Search Bar *********************/

    /******* Keyword *******/

    public String getKeywordPlaceholder() {
        return fetchElement.getWebElement(Locator.Name, keywordInput_Name).getAttribute("placeholder");
    }

    public void typeTextKeyword(String text) {
        fetchElement.getWebElement(Locator.Name, keywordInput_Name).sendKeys(text);
    }

    public void typeKeywordAndSearch(String text) {
        typeTextKeyword(text);
        clickOnSearchButton();
    }

    public int getKeywordCountByText_API(String text) {
        return api_dataMethods.getEventsCountBySearchText_Movies(text);
    }

    /******* Categories ******/

    public void clickCategoriesDropDown() {
        fetchElement.getWebElement(Locator.XPath, categoriesDiv_XPath).click();
    }

    public List<WebElement> getCategoriesList() {
        clickCategoriesDropDown();
        sleep(2000L);
        return fetchElement.getListOfWebElements(Locator.XPath, categoriesListLi_XPath);
    }

    public ArrayList<String> getCategoriesListNames() {
        ArrayList<String> namesList = new ArrayList<String>();
        for (WebElement item :
                getCategoriesList()) {
            String name = item.getText();
            namesList.add(name);
        }
        return namesList;
    }

    public int getCategoryCountByText_API(String text) {
        return api_dataMethods.getEventsCountByCategory_Movies(text);
    }

    public void selectCategoryByText(String text) {
        clickCategoriesDropDown();

        String path = categoriesListLi_XPath + "[text()='" + text + "']";

        fetchElement.getWebElement(Locator.XPath, path).click();
    }

    /******* Cities ******/

    public void clickCityDropDown() {
        fetchElement.getWebElement(Locator.XPath, cityDiv_XPath).click();
    }

    public List<WebElement> getCityList() {
        clickCityDropDown();
        sleep(2000L);
        return fetchElement.getListOfWebElements(Locator.XPath, cityListLi_XPath);
    }

    public ArrayList<String> getCityListNames() {
        ArrayList<String> namesList = new ArrayList<String>();
        for (WebElement item :
                getCityList()) {
            String name = item.getText();
            namesList.add(name);
        }
        return namesList;
    }

    public int getCityCountByText_API(String text) {
        return api_dataMethods.getEventsCountByCity_Movies(text);
    }

    public void selectCityByText(String text) {
        clickCityDropDown();

        String path = cityListLi_XPath + "[text()='" + text + "']";

        fetchElement.getWebElement(Locator.XPath, path).click();
    }

    /******* Time Range ******/

    public void clickTimeRangeDropDown() {
        fetchElement.getWebElement(Locator.XPath, timeRangeDiv_XPath).click();
    }

    public List<WebElement> getTimeRangeList() {
        clickTimeRangeDropDown();
        sleep(2000L);
        return fetchElement.getListOfWebElements(Locator.XPath, timeRangeListLi_XPath);
    }

    public ArrayList<String> getTimeRangeListNames() {
        clickTimeRangeDropDown();

        ArrayList<String> namesList = new ArrayList<String>();
        for (WebElement item :
                getTimeRangeList()) {
            String name = item.getText();
            namesList.add(name);
        }
        return namesList;
    }

    public void selectTimeRangeByText(String text) {
        clickTimeRangeDropDown();

        String path = timeRangeListLi_XPath + "[text()='" + text + "']";

        fetchElement.getWebElement(Locator.XPath, path).click();
    }

    /******* Search Button ******/

    public void clickOnSearchButton() {
        fetchElement.getWebElement(Locator.XPath, searchButton_XPath).click();
    }

    /******** Movies List *******/

    public int getMoviesListCount() {
        return fetchElement.getListOfWebElements(Locator.XPath, moviesListingDiv_XPath).size();
    }

    /************ Error Message *************/

    public boolean isErrorMessagePresent() {
        return commonMethods.IsElementPresent(By.xpath(noRecordErrorDiv_XPath));
    }

    /******************************** Slider *********************************/

    public int getSliderChildCount() {
        return fetchElement.getListOfWebElements(Locator.XPath, sliderDiv_XPath).size();
    }

    public int getSliderChildCount_API() {
        return api_dataMethods.getChildrenCount_Movies_AllSubCategories();
    }

    /******************************* Top Movies ******************************/

    public String getTopMoviesText_TopMovies() {
        return fetchElement.getWebElement(Locator.XPath, topMoviesH2_XPath).getText();
    }

    public int getListItemsCount_TopMovies() {
        return fetchElement.getListOfWebElements(Locator.XPath, topMoviesImg_XPath).size();
    }

    public int getMoviesCount_TopMovies_API() {
        return api_dataMethods.getMoviesCount_TopMovies();
    }

    public List<WebElement> getListItemsElements_TopMovies() {
        return fetchElement.getListOfWebElements(Locator.XPath, topMoviesImg_XPath);
    }

    public ArrayList getListItemsName_TopMovies() {
        int count = getListItemsCount_TopMovies();
        ArrayList<String> movieNames = new ArrayList<String>();

        for (int i = 0; i < count; i++) {
            String path = topMoviesIteratorStart_XPath + "[" + (i + 1) + "]" + topMoviesIteratorEnd_XPath;
            String movieName = fetchElement.getWebElement(Locator.XPath, path).getAttribute("alt");
            movieNames.add(movieName);
        }

        return movieNames;
    }

    public void clickFirstListItem_TopMovies() {
        fetchElement.getWebElement(Locator.XPath, topMoviesImg_XPath).click();
    }

    public String getFirstListItemName_TopMovies() {
        String path = topMoviesIteratorStart_XPath + "[1]" + topMoviesIteratorEnd_XPath;
        return fetchElement.getWebElement(Locator.XPath, path).getAttribute("alt").split("-")[0].trim();
    }

    public String getFirstItemName_TopMovies_API() {
        return api_dataMethods.getFirstMovieName_TopMovies();
    }

    public String getExploreMoviesButtonText_TopMovies() {
        return fetchElement.getWebElement(Locator.XPath, exploreMoviesButton_XPath).getText();
    }

    public void clickExploreMoviesButton_TopMovies() {
        fetchElement.getWebElement(Locator.XPath, exploreMoviesButton_XPath).click();
    }

    /******************************** Movies Details Page *************************/

    public String getTitle_MoviesDetails() {
        commonMethods.waitForElementPresent(By.className(movieTitleDiv_ClassName), 20);
        return fetchElement.getWebElement(Locator.ClassName, movieTitleDiv_ClassName).getText();
    }

    /*************************** Trending Movies *************************/

    public String getTrendingMoviesText_TrendingMovies() {
        return fetchElement.getWebElement(Locator.XPath, trendingMoviesTextSpan_XPath).getText();
    }

    public int getListItemsCount_TrendingMovies() {
        return fetchElement.getListOfWebElements(Locator.XPath, trendingMoviesImg_XPath).size();
    }

    public int getMoviesCount_TrendingMovies_API() {
        return api_dataMethods.getMoviesCount_TrendingMovies();
    }

    public void clickFirstListItem_TrendingMovies() {
        fetchElement.getWebElement(Locator.XPath, trendingMoviesImg_XPath).click();
    }

    public String getFirstListItemName_TrendingMovies() {
        return fetchElement.getWebElement(Locator.XPath, trendingMoviesImg_XPath).getAttribute("alt");
    }

    public String getFirstItemName_TrendingMovies_API() {
        return api_dataMethods.getFirstMovieName_TrendingMovies();
    }

    public String getSeeAllButtonText_TrendingMovies() {
        return fetchElement.getWebElement(Locator.XPath, trendingSeeAllButton_XPath).getText();
    }

    public void clickSeeAllButton_TrendingMovies() {
        fetchElement.getWebElement(Locator.XPath, trendingSeeAllButton_XPath).click();
    }

    /********************** UpComing Movies **************************/

    public String getUpComingMoviesText_UpComingMovies() {
        return fetchElement.getWebElement(Locator.XPath, upComingMoviesTextSpan_XPath).getText();
    }

    public int getListItemsCount_UpComingMovies() {
        return fetchElement.getListOfWebElements(Locator.XPath, upComingMoviesImg_XPath).size();
    }

    public int getMoviesCount_UpComingMovies_API() {
        return api_dataMethods.getMoviesCount_UpComingMovies();
    }

    public void clickFirstListItem_UpComingMovies() {
        fetchElement.getWebElement(Locator.XPath, upComingMoviesImg_XPath).click();
    }

    public String getFirstListItemName_UpComingMovies() {
        return fetchElement.getWebElement(Locator.XPath, upComingMoviesImg_XPath).getAttribute("alt");
    }

    public String getFirstItemName_UpComingMovies_API() {
        return api_dataMethods.getFirstMovieName_UpComingMovies();
    }

    public String getSeeAllButtonText_UpComingMovies() {
        return fetchElement.getWebElement(Locator.XPath, upComingSeeAllButton_XPath).getText();
    }

    public void clickSeeAllButton_UpComingMovies() {
        fetchElement.getWebElement(Locator.XPath, upComingSeeAllButton_XPath).click();
    }

    /********************** Showing in Cinemas Movies **************************/

    public String getShowingInCinemasMoviesText_ShowingInCinemasMovies() {
        return fetchElement.getWebElement(Locator.XPath, showingInCinemasMoviesTextSpan_XPath).getText();
    }

    public int getListItemsCount_ShowingInCinemasMovies() {
        return fetchElement.getListOfWebElements(Locator.XPath, showingInCinemasMoviesImg_XPath).size();
    }

    public int getMoviesCount_ShowingInCinemasMovies_API() {
        return api_dataMethods.getMoviesCount_ShowingInCinemasMovies();
    }

    public void clickFirstListItem_ShowingInCinemasMovies() {
        fetchElement.getWebElement(Locator.XPath, showingInCinemasMoviesImg_XPath).click();
    }

    public String getFirstListItemName_ShowingInCinemasMovies() {
        return fetchElement.getWebElement(Locator.XPath, showingInCinemasMoviesImg_XPath).getAttribute("alt");
    }

    public String getFirstItemName_ShowingInCinemasMovies_API() {
        return api_dataMethods.getFirstMovieName_ShowingInCinemasMovies();
    }

    public String getSeeAllButtonText_ShowingInCinemasMovies() {
        return fetchElement.getWebElement(Locator.XPath, showingInCinemasSeeAllButton_XPath).getText();
    }

    public void clickSeeAllButton_ShowingInCinemasMovies() {
        fetchElement.getWebElement(Locator.XPath, showingInCinemasSeeAllButton_XPath).click();
    }

}
