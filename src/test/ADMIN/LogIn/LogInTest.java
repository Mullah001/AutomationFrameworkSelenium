package test.ADMIN.LogIn;

import main.pageEvents.ADMIN.LogInPageEvents;
import main.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

import javax.sql.CommonDataSource;

import static main.pageObjects.ADMIN.LogInPageElements.*;

@Test(groups = {"ADMIN"})
public class LogInTest extends BaseTest {

    public WebDriver driver;
    LogInPageEvents logInPageEvents;
    CommonMethods commonMethods;
    @BeforeClass
    public void intialize(){
        driver = initializeBrowser();
        logInPageEvents = new LogInPageEvents(driver);
        commonMethods = new CommonMethods(driver);

    }

    @AfterClass
    public void close(){
        closeAndQuitBrowser(driver);
    }


    @Test(testName = "Verify logIn with Valid Data")
    public void verifyLogIn_Valid(){
        logInPageEvents.logIn_Valid();

        logInPageEvents.waitForDashboardToLoad();

        boolean isDashboardLoaded = commonMethods.IsElementPresentAndVisible(By.id(dashboardSideBar_Id));

        Assert.assertTrue(isDashboardLoaded, "Dashboard should be loaded with Valid Data");
    }

    @Test(testName = "Verify logIn with InValid Data", priority = 1)
    public void verifyLogIn_InValid(){
        logInPageEvents.logIn_InValid();

        logInPageEvents.waitForDashboardToLoad();

        boolean isDashboardLoaded = commonMethods.IsElementPresentAndVisible(By.id(dashboardSideBar_Id));

        Assert.assertFalse(isDashboardLoaded, "Dashboard should not be loaded with InValid Data");
    }

    @Test(testName = "Verify logIn with Empty Data", priority = 2)
    public void verifyLogIn_Empty(){
        logInPageEvents.logIn_Empty();

        logInPageEvents.waitForDashboardToLoad();

        boolean isDashboardLoaded = commonMethods.IsElementPresentAndVisible(By.id(dashboardSideBar_Id));

        Assert.assertFalse(isDashboardLoaded, "Dashboard should not be loaded with Empty Data");
    }

}
