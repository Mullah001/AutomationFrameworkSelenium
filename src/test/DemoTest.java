package test;

import org.testng.annotations.Test;

@Test(groups = {"WEB"})
public class DemoTest extends BaseTest{

    @Test(testName = "demo test", enabled = false)
    public void verifyUserName_LogIn(){
        System.out.println("Dummy Test");
    }
}
