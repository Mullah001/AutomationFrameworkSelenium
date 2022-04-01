package test.Web.Movies;

import main.pageEvents.WEB.MoviesPageEvents;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

@Test(groups = {"WEB"})
public class SliderMoviesTest extends BaseTest {

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

    @Test(testName = "Verify Sub Categories - Movies")
    public void verifySubCategories_Movies(){
        actualCount = moviesPageEvents.getSliderChildCount();

        expectedCount = moviesPageEvents.getSliderChildCount_API();

        Assert.assertEquals(actualCount, expectedCount, "Slider Unique Values should be equal to Sub Categories of the Movies Category");
    }
}
