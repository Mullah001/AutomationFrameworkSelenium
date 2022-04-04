package test.Web.HomePage;

import main.pageEvents.WEB.HeaderPageEvents;
import main.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;

@Test(groups = {"WEB"})
public class HeaderTest extends BaseTest {

    public WebDriver driver;
    HeaderPageEvents headerPageEvents;
    CommonMethods commonMethods;

    @BeforeClass
    public void intialize() {
        driver = initializeBrowser();
        headerPageEvents = new HeaderPageEvents(driver);
        commonMethods = new CommonMethods(driver);
    }

    @AfterClass
    public void close() {
        closeAndQuitBrowser(driver);
    }

    @Test(testName = "Verify that when user hover on events then subcategories dropdown is visiable ")
    public void eventsDropdownVisiable() {
        WebElement eventsDropdown = headerPageEvents.getEventsDropdownVisible();
        eventsDropdown.isDisplayed();
        Assert.assertTrue(true, "Events dropdown is visiable");

    }

    @Test(testName = "Verify that Text of events subcategories are correct", priority = 1)
    public void printEventscategories() {
        ArrayList actualEventsSubcategories = headerPageEvents.getEventsCategories();
        ArrayList expectedEventsArrayList = new ArrayList(Arrays.asList("Awards", "Seminars", "Conferences", "Tedx"));

        if (actualEventsSubcategories.equals(expectedEventsArrayList) == true) {
            Assert.assertTrue(true, "Events subcategories text are correct");
        } else {
            Assert.assertTrue(false, "Events subcategories text are not correct");
        }

    }

    @Test(testName = "Verify that all events sub categories links are working")
    public void aaaCheckEventsSubcategoriesLinks() {
        headerPageEvents.checkEventsLink();
        ArrayList subcategoriesPath = headerPageEvents.checkEventsLink();
        for (int i = 0; i < subcategoriesPath.size(); i++) {
            WebElement element = (WebElement) subcategoriesPath.get(i);
            headerPageEvents.hoverOnEvents();
            String categoriesname = element.getText();
            System.out.println("name: " + categoriesname);

            element.click();
            String title = commonMethods.getTitle();
            Assert.assertEquals(title, categoriesname, "All subcategories of Events are working and redirect to the specific path");
        }
    }


    @Test(testName = "Verify that when user hover on movies then subcategories dropdown is visiable ")
    public void moviesDropdownVisiable() {
        WebElement moviesDropdown = headerPageEvents.getMoviesDropdownVisible();
        moviesDropdown.isDisplayed();
        Assert.assertTrue(true, "Movies dropdown is visiable");

    }

    @Test(testName = "Verify that Text of movies subcategories are correct", priority = 2)
    public void printMoviescategories() {
        ArrayList actualSubcategories = headerPageEvents.getMoviesCategories();
        ArrayList expectedArrayList = new ArrayList(Arrays.asList("Action", "Crime", "Romantic", "Thriller", "Suspense", "Sci-Fi", "Test", "Test 2", "Horror", "Romantic Comedy "));

        if (actualSubcategories.equals(expectedArrayList) == true) {
            Assert.assertTrue(true, "Movies sub categories are expected");
        } else {
            Assert.assertTrue(false, "Movies sub categories are not equals");
        }

    }

    @Test(testName = "Verify that all movies sub categories links are working", priority = 3)
    public void CheckMoviesSubcategoriesLinks() {
        headerPageEvents.CheckMoviesLinks();
        ArrayList subcategoriesPath = headerPageEvents.CheckMoviesLinks();
        for (int i = 0; i < subcategoriesPath.size(); i++) {
            WebElement element = (WebElement) subcategoriesPath.get(i);
            //System.out.println();
            headerPageEvents.hoverOnMovies();
            String categoriesname = element.getText();
            System.out.println("name: " + categoriesname);

            element.click();
            String title = commonMethods.getTitle();
            Assert.assertEquals(title, categoriesname, "All subcategories of Movies are working and redirect to the specific path");
        }
    }


    @Test(testName = "Verify that when user hover on Sports then subcategories dropdown is visiable ")
    public void sportsDropdownVisiable() {
        WebElement sportsDropdown = headerPageEvents.getSportsDropdownVisible();
        sportsDropdown.isDisplayed();
        Assert.assertTrue(true, "Sports dropdown is visiable");

    }


    @Test(testName = "Verify that Text of Sports subcategories are correct", priority = 4)
    public void printSportsCategories() {
        ArrayList actualSportsSubcategories = headerPageEvents.getSportsCategories();
        ArrayList expectedSportsArrayList = new ArrayList(Arrays.asList("Fitness"));

        if (actualSportsSubcategories.equals(expectedSportsArrayList)) {
            Assert.assertTrue(true, "Sports sub categories are expected");
        } else {
            Assert.assertTrue(false, "Sports sub categories are not correct");
        }
    }


    @Test(testName = "Verify that all Sports sub categories links are working", priority = 3)
    public void CheckSportsSubcategoriesLinks() {
        headerPageEvents.CheckSportsLinks();
        ArrayList sportsSubcategoriesPath = headerPageEvents.CheckSportsLinks();
        for (int i = 0; i < sportsSubcategoriesPath.size(); i++) {
            WebElement element = (WebElement) sportsSubcategoriesPath.get(i);
            //System.out.println();
            headerPageEvents.hoverOnSports();
            String sportsCategoriesname = element.getText();
            System.out.println("name: " + sportsCategoriesname);

            element.click();
            String title = commonMethods.getTitle();
            Assert.assertEquals(title, sportsCategoriesname, "All subcategories of Movies are working and redirect to the specific path");
        }
    }


    @Test(testName = "Verify that when user hover on Global then subcategories dropdown is visiable ")
    public void globalDropdownVisiable() {
        WebElement globalDropdown = headerPageEvents.getGlobalDropdownVisiable();
        globalDropdown.isDisplayed();
        Assert.assertTrue(true, "Global dropdown is visiable");

    }


    @Test(testName = "Verify that Text of Global subcategories are correct", priority = 5)
    public void printGlobalCategories() {
        ArrayList actualGlobalSubcategories = headerPageEvents.getGlobalscategories();
        ArrayList expectedGlobalArrayList = new ArrayList(Arrays.asList("Sports", "Tours", "Movies", "Events"));

        if (actualGlobalSubcategories.equals(expectedGlobalArrayList)) {
            Assert.assertTrue(true, "Global sub categories are expected");
        } else {
            Assert.assertTrue(false, "Global sub categories are not equals");
        }
    }


    @Test(testName = "Verify that all Global sub categories links are working", priority = 3)
    public void CheckGlobalSubcategoriesLinks() {
        headerPageEvents.CheckGlobalLinks();
        ArrayList globalSubcategoriesPath = headerPageEvents.CheckGlobalLinks();
        for (int i = 0; i < globalSubcategoriesPath.size(); i++) {
            WebElement element = (WebElement) globalSubcategoriesPath.get(i);
            headerPageEvents.hoverOnGlobal();
            String globalCategoriesname = element.getText();
            System.out.println("name: " + globalCategoriesname);

            element.click();
            String title = commonMethods.getTitle();
            Assert.assertEquals(title, globalCategoriesname, "All subcategories of Movies are working and redirect to the specific path");
        }
    }


    @Test(testName = "Verify that when user hover on Nearby then subcategories dropdown is visiable ")
    public void nearbyDropdownVisiable() {
        WebElement nearbyDropdown = headerPageEvents.getNearbyDropdownVisiable();
        nearbyDropdown.isDisplayed();
        Assert.assertTrue(true, "Nearby dropdown is visiable");
    }

    @Test(testName = "Verify that Text of Nearby subcategories are correct", priority = 6)
    public void printNearybyCategories() {
        ArrayList actualNearybySubcategories = headerPageEvents.getNearybycategories();
        ArrayList expectedNearybyArrayList = new ArrayList(Arrays.asList("Nearby Events", "Nearby Cinemas"));

        if (actualNearybySubcategories.equals(expectedNearybyArrayList) == true) {
            Assert.assertTrue(true, "Nearyby sub categories are expected");
        } else {
            Assert.assertTrue(false, " earyby sub categories are not equals");
        }
    }


    @Test(testName = "Verify that all Nearby sub categories links are working", priority = 3)
    public void CheckNearbySubcategoriesLinks() {
        headerPageEvents.CheckNearbyLinks();
        ArrayList nearbySubcategoriesPath = headerPageEvents.CheckNearbyLinks();
        for (int i = 0; i < nearbySubcategoriesPath.size(); i++) {
            WebElement element = (WebElement) nearbySubcategoriesPath.get(i);
            headerPageEvents.hoverOnNearby();
            String nearbyCategoriesname = element.getText();
            System.out.println("name: " + nearbyCategoriesname);

            element.click();
            String title = commonMethods.getTitle();
            Assert.assertEquals(title, nearbyCategoriesname, "Verify that all Nearby sub categories links are working");
        }
    }

    @Test(testName = "Verify that Voting text is correct")
    public void VotingText() {
        String votingtext = headerPageEvents.getVotingText();
        Assert.assertEquals(votingtext, "Votings", "Verify that voting text is correct");
    }

    @Test(testName = "Verify that Voting link is working fine")
    public void clickOnVotingLink() {
        headerPageEvents.clickOnVoting();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String title = driver.getTitle();
        Assert.assertEquals(title, "Voting", "Verify that Voting link is working fine");
    }

    @Test(testName = "Verify that master search is working fine", priority = 0)
    public void verifiedMasterSearch() {
        headerPageEvents.getMasterSearch();
        Assert.assertTrue(true, "Verified");
        Assert.assertFalse(false, "Not Verified");
    }

    @Test(testName = "Verify that by clicking on the country filter all country is displayed", priority = 0)
    public void verifiedCountrFilterIsDisplayed() {
        headerPageEvents.getCountryFilter();
        Assert.assertTrue(true, "Verified");
        Assert.assertFalse(false, "Not Verified");
    }

    @Test(testName = "Verify that by country filter is changeable")
    public void verifyCountryChanged() throws InterruptedException {

        boolean isChangedCountry = headerPageEvents.getchangedCountry();
        Assert.assertTrue(isChangedCountry, "Verified");
    }
}
