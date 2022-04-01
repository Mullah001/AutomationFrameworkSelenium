package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = {"WEB"})
public class DemoTest extends BaseTest{

    public WebDriver driver;
    @BeforeClass
    public void intialize(){
        driver = initializeBrowser();
    }

    @AfterClass
    public void close(){
        closeAndQuitBrowser(driver);
    }

    @Test(testName = "demo test", enabled = false)
    public void verifyUserName_LogIn(){
        System.out.println("Dummy Test");
    }
}
