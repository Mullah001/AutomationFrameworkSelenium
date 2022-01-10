package test;

import com.aventstack.extentreports.Status;
import main.data.HomePageData;
import main.pageEvents.HomePageEvents;
import main.pageEvents.LogInPageEvents;
import main.utils.CommonMethods;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSample extends BaseTest{
    HomePageEvents homePageEvents = new HomePageEvents();
    LogInPageEvents logInPageEvents = new LogInPageEvents();

    @Test (enabled = false)
    public void verifyHomePage(){
        String heroText = homePageEvents.getHeroText();
        Assert.assertEquals(heroText, HomePageData.heroText);
    }

    @Test (enabled = false)
    public void verifyHomePageTitle(){
        String title = CommonMethods.getTitle();
//        List<List<String>> records =  CommonMethods.ReadCSV("C:\\Users\\Hamza Ashfaq\\Downloads\\SampleCSV.csv");
//
//        for (List<String> recordsList:
//             records) {
//                System.out.println(recordsList);
//        }
//
//        System.out.println(records);

        extentTestLogger.log(Status.INFO,"Got Title from the Website: " + title);
        extentTestLogger.log(Status.INFO, "Test Data Title: " + HomePageData.title);
        Assert.assertEquals(title,HomePageData.title);
    }

    public void checkLogInFunctionality() {
        homePageEvents.clickOnSignInButton();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.titleIs("Sign in"),
                ExpectedConditions.titleIs("Home")));

        logInPageEvents.enterEmail();
        logInPageEvents.enterPassword();
        logInPageEvents.clickLogInButton();

        Assert.assertTrue(logInPageEvents.verifyLogInSuccess());
    }
}
