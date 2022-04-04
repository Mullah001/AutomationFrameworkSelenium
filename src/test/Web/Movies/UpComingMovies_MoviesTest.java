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
public class UpComingMovies_MoviesTest extends BaseTest {

    public WebDriver driver;
    MoviesPageEvents moviesPageEvents;
    CommonMethods commonMethods;

    @BeforeClass
    public void intialize(){
        driver = initializeBrowser();
        moviesPageEvents = new MoviesPageEvents(driver);
        commonMethods = new CommonMethods(driver);

    }

    @AfterClass
    public void close(){
        closeAndQuitBrowser(driver);
    }

    int actualCount, expectedCount;
    String actualText, expectedText;


    @Test(testName = "Verify UpComing Movies Text")
    public void verifyUpComingMoviesText() {
        moviesPageEvents.loadMoviesURLFromHeader();

        actualText = moviesPageEvents.getUpComingMoviesText_UpComingMovies();
        expectedText = upComingMoviesText;

        Assert.assertEquals(actualText, expectedText, "UpComing Movies Heading Text should be '" + upComingMoviesText + "'");
    }

    @Test(testName = "Verify UpComing Movies List Items Count", priority = 1)
    public void verifyUpComingMoviesCount() {
        moviesPageEvents.loadMoviesURLFromHeader();

        actualCount = moviesPageEvents.getListItemsCount_UpComingMovies();

        expectedCount = moviesPageEvents.getMoviesCount_UpComingMovies_API();

        Assert.assertEquals(actualCount, expectedCount, "UpComing Movies List Items Count should be '" + expectedCount + "'");
    }

    @Test(testName = "Verify Movie Name from API response", priority = 2)
    public void verifyUpComingMovieName() {
        moviesPageEvents.loadMoviesURLFromHeader();

        actualText = moviesPageEvents.getFirstListItemName_UpComingMovies();
        expectedText = moviesPageEvents.getFirstItemName_UpComingMovies_API();

        Assert.assertEquals(actualText, expectedText, "UpComing Movies List Items Names should be the same as API");
    }

    @Test(testName = "Verify Movie Item is navigating to the Movie Details page", priority = 3)
    public void verifyMovieItemNavigation() {
        moviesPageEvents.loadMoviesURLFromHeader();

        moviesPageEvents.clickFirstListItem_UpComingMovies();

        actualText = moviesPageEvents.getTitle_MoviesDetails();
        expectedText = moviesPageEvents.getFirstItemName_UpComingMovies_API();

        Assert.assertEquals(actualText, expectedText, "Movie Detail Page Title Name should be equal to '" + expectedText + "'");
    }

    @Test(testName = "Verify See All Button Text", priority = 4)
    public void verifySeeAllBtnText() {
        moviesPageEvents.loadMoviesURLFromHeader();

        actualText = moviesPageEvents.getSeeAllButtonText_UpComingMovies();
        expectedText = seeAllText;

        Assert.assertEquals(actualText, expectedText, "See All Button Text should be equal to '" + expectedText + "'");
    }

    @Test(testName = "Verify See All Button Navigating to the View More Movies Page", priority = 5)
    public void verifySeeAllNavigation() {
        moviesPageEvents.loadMoviesURLFromHeader();

        moviesPageEvents.clickSeeAllButton_UpComingMovies();

        sleep(3000L);

        actualText = commonMethods.getCurrentURL();
        expectedText = viewMoreMoviesURL;

        Assert.assertEquals(actualText, expectedText, "See All Button should navigate to View More Movies Page");
    }

}
