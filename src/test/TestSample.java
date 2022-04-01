package test;

import com.aventstack.extentreports.Status;
import main.pageEvents.WEB.HomePageEvents;
import main.pageEvents.WEB.LogInPageEvents;
import main.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSample extends BaseTest{

    public WebDriver driver;
    @BeforeClass
    public void intialize(){
        driver = initializeBrowser();
    }

    @AfterClass
    public void close(){
        closeAndQuitBrowser(driver);
    }

    HomePageEvents homePageEvents = new HomePageEvents(driver);
    LogInPageEvents logInPageEvents = new LogInPageEvents(driver);

    @Test (enabled = false)
    public void verifyHomePageTitle(){
        String title = getTitle();
//        List<List<String>> records =  CommonMethods.ReadCSV("C:\\Users\\Hamza Ashfaq\\Downloads\\SampleCSV.csv");
//
//        for (List<String> recordsList:
//             records) {
//                System.out.println(recordsList);
//        }
//
//        System.out.println(records);

        extentTestLogger.log(Status.INFO,"Got Title from the Website: " + title);
        //extentTestLogger.log(Status.INFO, "Test Data Title: " + HomePageData.title);
        //Assert.assertEquals(title,HomePageData.title);
    }


}
