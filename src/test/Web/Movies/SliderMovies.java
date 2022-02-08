package test.Web.Movies;

import main.pageEvents.MoviesPageEvents;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

@Test(groups = {"WEB"})
public class SliderMovies extends BaseTest {

    MoviesPageEvents moviesPageEvents = new MoviesPageEvents();
    int actualCount, expectedCount;

    @Test(testName = "Verify Sub Categories - Movies")
    public void verifySubCategories_Movies(){
        actualCount = moviesPageEvents.getSliderChildCount();

        expectedCount = moviesPageEvents.getSliderChildCount_API();

        Assert.assertEquals(actualCount, expectedCount, "Slider Unique Values should be equal to Sub Categories of the Movies Category");
    }
}
