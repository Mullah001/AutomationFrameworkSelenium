package test.Web.Movies;

import main.pageEvents.MoviesPageEvents;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;

import static main.data.WEB.MoviesData.*;

@Test(groups = {"WEB"})
public class TrendingMovies_Movies extends BaseTest {

    MoviesPageEvents moviesPageEvents = new MoviesPageEvents();
    int actualCount, expectedCount;
    String actualText, expectedText;

//    @BeforeMethod
//    public void beforeMethodMethod() {
//        moviesPageEvents.clickMoviesFromHeader();
//    }

    @Test(testName = "Verify Trending Movies Text")
    public void verifyTrendingMoviesText() {
        moviesPageEvents.clickMoviesFromHeader();

        actualText = moviesPageEvents.getTrendingMoviesText_TrendingMovies();
        expectedText = trendingMoviesText;

        Assert.assertEquals(actualText, expectedText, "Trending Movies Heading Text should be '" + trendingMoviesText + "'");
    }

    @Test(testName = "Verify Trending Movies List Items Count", priority = 1)
    public void verifyTrendingMoviesCount() {
        moviesPageEvents.clickMoviesFromHeader();

        actualCount = moviesPageEvents.getListItemsCount_TrendingMovies();

        expectedCount = moviesPageEvents.getMoviesCount_TrendingMovies_API();

        Assert.assertEquals(actualCount, expectedCount, "Trending Movies List Items Count should be '" + expectedCount + "'");
    }

    @Test(testName = "Verify Movie Name from API response", priority = 2)
    public void verifyTrendingMovieName() {
        moviesPageEvents.clickMoviesFromHeader();

        actualText = moviesPageEvents.getFirstListItemName_TrendingMovies();
        expectedText = moviesPageEvents.getFirstItemName_TrendingMovies_API();

        Assert.assertEquals(actualText, expectedText, "Trending Movies List Items Names should be the same as API");
    }

    @Test(testName = "Verify Movie Item is navigating to the Movie Details page", priority = 3, enabled = false)
    public void verifyMovieItemNavigation() {
        moviesPageEvents.clickMoviesFromHeader();

        moviesPageEvents.clickFirstListItem_TrendingMovies();

        actualText = moviesPageEvents.getTitle_MoviesDetails();
        expectedText = moviesPageEvents.getFirstItemName_TrendingMovies_API();

        Assert.assertEquals(actualText, expectedText, "Movie Detail Page Title Name should be equal to '" + expectedText + "'");
    }

    @Test(testName = "Verify See All Button Text", priority = 4)
    public void verifySeeAllBtnText() {
        moviesPageEvents.clickMoviesFromHeader();

        actualText = moviesPageEvents.getSeeAllButtonText_TrendingMovies();
        expectedText = seeAllText;

        Assert.assertEquals(actualText, expectedText, "See All Button Text should be equal to '" + expectedText + "'");
    }

    @Test(testName = "Verify See All Button Navigating to the View More Movies Page", priority = 5)
    public void verifySeeAllNavigation() {
        moviesPageEvents.clickMoviesFromHeader();

        moviesPageEvents.clickSeeAllButton_TrendingMovies();

        sleep(3000L);

        actualText = getCurrentURL();
        expectedText = viewMoreMoviesURL;

        Assert.assertEquals(actualText, expectedText, "See All Button should navigate to View More Movies Page");
    }

}
