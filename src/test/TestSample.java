package test;

import com.aventstack.extentreports.Status;
import main.pageEvents.WEB.HomePageEvents;
import main.pageEvents.WEB.LogInPageEvents;
import main.utils.CommonMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSample extends BaseTest{
    HomePageEvents homePageEvents = new HomePageEvents();
    LogInPageEvents logInPageEvents = new LogInPageEvents();

    @Test (enabled = false)
    public void verifyHomePageTitle(){
        String title = CommonMethods.getTitle(driver);
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
