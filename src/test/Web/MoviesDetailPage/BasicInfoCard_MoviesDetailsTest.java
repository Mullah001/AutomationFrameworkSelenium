package test.Web.MoviesDetailPage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import test.BaseTest;

public class BasicInfoCard_MoviesDetailsTest extends BaseTest {
    public WebDriver driver;
    @BeforeClass
    public void intialize(){
        driver = initializeBrowser();
    }

    @AfterClass
    public void close(){
        closeAndQuitBrowser(driver);
    }
}
