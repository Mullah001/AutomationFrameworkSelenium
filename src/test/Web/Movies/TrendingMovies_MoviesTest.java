package test.Web.Movies;

import main.pageEvents.WEB.MoviesPageEvents;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

import static main.data.Web.MoviesData.*;

@Test(groups = {"WEB"})
public class TrendingMovies_MoviesTest extends BaseTest {

    public WebDriver driver;
    @BeforeClass
    public void intialize(){
        driver = initializeBrowser();
    }

    @AfterClass
    public void close(){
        closeAndQuitBrowser(driver);
    }

    MoviesPageEvents moviesPageEvents = new MoviesPageEvents(driver);
    int actualCount, expectedCount;
    String actualText, expectedText;

//    @BeforeMethod
//    public void beforeMethodMethod() {
//        moviesPageEvents.clickMoviesFromHeader();
//    }

    @Test(testName = "Verify Trending Movies Text")
    public void verifyTrendingMoviesText() {
        moviesPageEvents.loadMoviesURLFromHeader();

        actualText = moviesPageEvents.getTrendingMoviesText_TrendingMovies();
        expectedText = trendingMoviesText;

        Assert.assertEquals(actualText, expectedText, "Trending Movies Heading Text should be '" + trendingMoviesText + "'");
    }

    @Test(testName = "Verify Trending Movies List Items Count", priority = 1)
    public void verifyTrendingMoviesCount() {
        moviesPageEvents.loadMoviesURLFromHeader();

        actualCount = moviesPageEvents.getListItemsCount_TrendingMovies();

        expectedCount = moviesPageEvents.getMoviesCount_TrendingMovies_API();

        Assert.assertEquals(actualCount, expectedCount, "Trending Movies List Items Count should be '" + expectedCount + "'");
    }

    @Test(testName = "Verify Movie Name from API response", priority = 2)
    public void verifyTrendingMovieName() {
        moviesPageEvents.loadMoviesURLFromHeader();

        actualText = moviesPageEvents.getFirstListItemName_TrendingMovies();
        expectedText = moviesPageEvents.getFirstItemName_TrendingMovies_API();

        Assert.assertEquals(actualText, expectedText, "Trending Movies List Items Names should be the same as API");
    }

    @Test(testName = "Verify Movie Item is navigating to the Movie Details page", priority = 3, enabled = false)
    public void verifyMovieItemNavigation() {
        moviesPageEvents.loadMoviesURLFromHeader();

        moviesPageEvents.clickFirstListItem_TrendingMovies();

        actualText = moviesPageEvents.getTitle_MoviesDetails();
        expectedText = moviesPageEvents.getFirstItemName_TrendingMovies_API();

        Assert.assertEquals(actualText, expectedText, "Movie Detail Page Title Name should be equal to '" + expectedText + "'");
    }

    @Test(testName = "Verify See All Button Text", priority = 4)
    public void verifySeeAllBtnText() {
        moviesPageEvents.loadMoviesURLFromHeader();

        actualText = moviesPageEvents.getSeeAllButtonText_TrendingMovies();
        expectedText = seeAllText;

        Assert.assertEquals(actualText, expectedText, "See All Button Text should be equal to '" + expectedText + "'");
    }

    @Test(testName = "Verify See All Button Navigating to the View More Movies Page", priority = 5)
    public void verifySeeAllNavigation() {
        moviesPageEvents.loadMoviesURLFromHeader();

        moviesPageEvents.clickSeeAllButton_TrendingMovies();

        sleep(3000L);

        actualText = getCurrentURL();
        expectedText = viewMoreMoviesURL;

        Assert.assertEquals(actualText, expectedText, "See All Button should navigate to View More Movies Page");
    }

}
