package test.Web.Movies;

import main.pageEvents.WEB.MoviesPageEvents;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

import java.util.List;

import static main.data.Web.MoviesData.*;

@Test(groups = {"WEB"})
public class SearchBarMoviesTest extends BaseTest {

    public WebDriver driver;
    MoviesPageEvents moviesPageEvents;
    @BeforeClass
    public void intialize(){
        driver = initializeBrowser();
        moviesPageEvents = new MoviesPageEvents(driver);

    }

    @AfterClass
    public void close(){
        closeAndQuitBrowser(driver);
    }

    int actualCount, expectedCount;

    @Test(testName = "Verify that keyword field placeholder is '" + keywordPlaceholder + "'", priority = 0)
    public void verifyKeywordPlaceholder() {
        initializerMethod();

        String actualPlaceholder = moviesPageEvents.getKeywordPlaceholder();

        Assert.assertEquals(actualPlaceholder, keywordPlaceholder, "Keyword Placeholder should be '" + keywordPlaceholder + "'");
    }

    @Test(testName = "Verify the type event for keyword field", priority = 0)
    public void verifyKeywordResult() {
        initializerMethod();

        moviesPageEvents.typeKeywordAndSearch(keywordText_Valid);

        expectedCount = moviesPageEvents.getKeywordCountByText_API(keywordText_Valid);

        actualCount = moviesPageEvents.getMoviesListCount();

        Assert.assertEquals(actualCount, expectedCount, "Keyword Search result count should be equal to the API response count");
    }

    @Test(testName = "Verify Category Dropdown have options", priority = 1)
    public void verifyCategoryOptions() {
        initializerMethod();

        List<String> elements = moviesPageEvents.getCategoriesListNames();

        Assert.assertTrue(elements.size() > 0, "Category Options size should be greater than '0'");
    }

    @Test(testName = "Verify Category option gives correct results against Category", priority = 1)
    public void verifyCategoryResult() {
        initializerMethod();

        moviesPageEvents.selectCategoryByText(category_Valid);

        actualCount = moviesPageEvents.getMoviesListCount();

        expectedCount = moviesPageEvents.getCategoryCountByText_API(category_Valid);

        Assert.assertEquals(actualCount, expectedCount, "Category result count should be equal to API result");
    }

    @Test(testName = "Verify City Dropdown have options", priority = 2)
    public void verifyCityOptions() {
        initializerMethod();

        List<String> elements = moviesPageEvents.getCityListNames();

        Assert.assertTrue(elements.size() > 0, "City Options size should be greater than '0'");
    }

    @Test(testName = "Verify City option gives correct results against City", priority = 2)
    public void verifyCityResult() {
        initializerMethod();

        moviesPageEvents.selectCityByText(city_Valid);

        actualCount = moviesPageEvents.getMoviesListCount();

        expectedCount = moviesPageEvents.getCityCountByText_API(city_Valid);

        Assert.assertEquals(actualCount, expectedCount, "City result count should be equal to API result");
    }

    @Test(testName = "Verify Time Range Dropdown have options", priority = 3)
    public void verifyTimeRangeOptions() {
        initializerMethod();

        List<String> elements = moviesPageEvents.getTimeRangeListNames();

        Assert.assertTrue(elements.size() > 0, "Time Range Options size should be greater than '0'");
    }

    /*************** InValid Data ***************/

    @Test(testName = "Verify the type event for keyword field - InValid Data", priority = 0)
    public void verifyKeywordResult_InValid() {
        setMaxTimeout(10);
        initializerMethod();

        moviesPageEvents.typeKeywordAndSearch(keywordText_InValid);

        Assert.assertTrue(moviesPageEvents.isErrorMessagePresent(), "Error Message should be display for InValid data");
    }

    @Test(testName = "Verify Category option - InValid Data", priority = 1)
    public void verifyCategoryResult_InValid() {
        setMaxTimeout(10);
        initializerMethod();

        Assert.assertThrows(NoSuchElementException.class, () -> moviesPageEvents.selectCategoryByText(category_InValid));
    }

    @Test(testName = "Verify City option - InValid Data", priority = 2)
    public void verifyCityResult_InValid() {
        setMaxTimeout(10);
        initializerMethod();

        Assert.assertThrows(NoSuchElementException.class, () -> moviesPageEvents.selectCityByText(city_InValid));
    }


    /* Helper Methods */

    @Test(enabled = false)
    public void initializerMethod() {
        loadMoviesSearchURL();
        resetCounts();
    }

    @Test(enabled = false)
    public void resetCounts() {
        actualCount = 0;
        expectedCount = 0;
    }


}
