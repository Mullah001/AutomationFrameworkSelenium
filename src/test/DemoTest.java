package test;

import org.testng.annotations.Test;

@Test(groups = {"WEB"})
public class DemoTest extends BaseTest{

    @Test
    public void verifyUserName_LogIn(){
        System.out.println("Dummy Test");
    }
}
