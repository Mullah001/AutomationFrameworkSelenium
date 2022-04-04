package test.Web.Movies;

import main.pageEvents.WEB.MoviesPageEvents;
import main.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

import static main.data.Web.MoviesData.*;
import static main.utils.CommonMethods.sleep;

@Test(groups = {"WEB"})
public class TopMovies_MoviesTest extends BaseTest {

    public WebDriver driver;
    MoviesPageEvents moviesPageEvents;
    CommonMethods commonMethods;

    @BeforeClass
    public void intialize() {
        driver = initializeBrowser();
        moviesPageEvents = new MoviesPageEvents(driver);
        commonMethods = new CommonMethods(driver);
    }

    @AfterClass
    public void close() {
        closeAndQuitBrowser(driver);
    }

    int actualCount, expectedCount;
    String actualText, expectedText;


    @Test(testName = "Verify Top Movies Text")
    public void verifyTopMoviesText() {
        moviesPageEvents.loadMoviesURLFromHeader();

        actualText = moviesPageEvents.getTopMoviesText_TopMovies();
        expectedText = topMoviesText;

        Assert.assertEquals(actualText, expectedText, "Top Movies Heading Text should be '" + topMoviesText + "'");
    }

    @Test(testName = "Verify Top Movies List Items Count", priority = 1)
    public void verifyTopMoviesCount() {
        moviesPageEvents.loadMoviesURLFromHeader();

        actualCount = moviesPageEvents.getListItemsCount_TopMovies();

        expectedCount = moviesPageEvents.getMoviesCount_TopMovies_API();

        Assert.assertEquals(actualCount, expectedCount, "Top Movies List Items Count should be '" + expectedCount + "'");
    }

    @Test(testName = "Verify Movie Name from API response", priority = 2)
    public void verifyTopMovieName() {
        moviesPageEvents.loadMoviesURLFromHeader();

        actualText = moviesPageEvents.getFirstListItemName_TopMovies();
        expectedText = moviesPageEvents.getFirstItemName_TopMovies_API();

        Assert.assertEquals(actualText, expectedText, "Top Movies List Items Names should be the same as API");
    }

    @Test(testName = "Verify Movie Item is navigating to the Movie Details page", priority = 3)
    public void verifyMovieItemNavigation() {
        moviesPageEvents.loadMoviesURLFromHeader();

        moviesPageEvents.clickFirstListItem_TopMovies();

        actualText = moviesPageEvents.getTitle_MoviesDetails();
        expectedText = moviesPageEvents.getFirstItemName_TopMovies_API();

        Assert.assertEquals(actualText, expectedText, "Movie Detail Page Title Name should be equal to '" + expectedText + "'");
    }

    @Test(testName = "Verify Explore Movie Button Text", priority = 4)
    public void verifyExploreMovieBtnText() {
        moviesPageEvents.loadMoviesURLFromHeader();

        actualText = moviesPageEvents.getExploreMoviesButtonText_TopMovies();
        expectedText = exploreAllMoviesText;

        Assert.assertEquals(actualText, expectedText, "Explore Movie Button Text should be equal to '" + expectedText + "'");
    }

    @Test(testName = "Verify Explore Movie Button Navigating to the View More Movies Page", priority = 5)
    public void verifyExploreMovieNavigation() {
        moviesPageEvents.loadMoviesURLFromHeader();

        moviesPageEvents.clickExploreMoviesButton_TopMovies();

        sleep(3000L);

        actualText = commonMethods.getCurrentURL();
        expectedText = viewMoreMoviesURL;

        Assert.assertEquals(actualText, expectedText, "Explore Movie Button should navigate to View More Movies Page");
    }

}
