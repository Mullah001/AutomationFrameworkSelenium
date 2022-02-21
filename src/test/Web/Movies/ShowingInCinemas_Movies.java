package test.Web.Movies;

import main.pageEvents.MoviesPageEvents;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

import static main.data.WEB.MoviesData.*;

@Test(groups = {"WEB"})
public class ShowingInCinemas_Movies extends BaseTest {

    MoviesPageEvents moviesPageEvents = new MoviesPageEvents();
    int actualCount, expectedCount;
    String actualText, expectedText;

//    @BeforeMethod
//    public void beforeMethodMethod() {
//        moviesPageEvents.clickMoviesFromHeader();
//    }

    @Test(testName = "Verify Showing In Cinemas Movies Text")
    public void verifyShowingInCinemasMoviesText() {
        moviesPageEvents.loadMoviesURLFromHeader();

        actualText = moviesPageEvents.getShowingInCinemasMoviesText_ShowingInCinemasMovies();
        expectedText = showingInCinemasMoviesText;

        Assert.assertEquals(actualText, expectedText, "Showing In Cinemas Movies Heading Text should be '" + showingInCinemasMoviesText + "'");
    }

    @Test(testName = "Verify Showing In Cinemas Movies List Items Count", priority = 1)
    public void verifyShowingInCinemasMoviesCount() {
        moviesPageEvents.loadMoviesURLFromHeader();

        actualCount = moviesPageEvents.getListItemsCount_ShowingInCinemasMovies();

        expectedCount = moviesPageEvents.getMoviesCount_ShowingInCinemasMovies_API();

        Assert.assertEquals(actualCount, expectedCount, "Showing In Cinemas Movies List Items Count should be '" + expectedCount + "'");
    }

    @Test(testName = "Verify Movie Name from API response", priority = 2)
    public void verifyShowingInCinemasMovieName() {
        moviesPageEvents.loadMoviesURLFromHeader();

        actualText = moviesPageEvents.getFirstListItemName_ShowingInCinemasMovies().split("-")[0].trim();
        expectedText = moviesPageEvents.getFirstItemName_ShowingInCinemasMovies_API();

        Assert.assertEquals(actualText, expectedText, "Showing In Cinemas Movies List Items Names should be the same as API");
    }

    @Test(testName = "Verify Movie Item is navigating to the Movie Details page", priority = 3)
    public void verifyMovieItemNavigation() {
        moviesPageEvents.loadMoviesURLFromHeader();

        sleep(2000L);
        moviesPageEvents.clickFirstListItem_ShowingInCinemasMovies();

        actualText = moviesPageEvents.getTitle_MoviesDetails();
        expectedText = moviesPageEvents.getFirstItemName_ShowingInCinemasMovies_API();

        Assert.assertEquals(actualText, expectedText, "Movie Detail Page Title Name should be equal to '" + expectedText + "'");
    }

    @Test(testName = "Verify See All Button Text", priority = 4, enabled = false)
    public void verifySeeAllBtnText() {
        moviesPageEvents.loadMoviesURLFromHeader();

        actualText = moviesPageEvents.getSeeAllButtonText_ShowingInCinemasMovies();
        expectedText = seeAllText;

        Assert.assertEquals(actualText, expectedText, "See All Button Text should be equal to '" + expectedText + "'");
    }

    @Test(testName = "Verify See All Button Navigating to the View More Movies Page", priority = 5, enabled = false)
    public void verifySeeAllNavigation() {
        moviesPageEvents.loadMoviesURLFromHeader();

        moviesPageEvents.clickSeeAllButton_ShowingInCinemasMovies();

        sleep(3000L);

        actualText = getCurrentURL();
        expectedText = viewMoreMoviesURL;

        Assert.assertEquals(actualText, expectedText, "See All Button should navigate to View More Movies Page");
    }

}
