package test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import main.utils.Constants;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static main.ApiConfigs.EndPoints.DemoEP.listUsersEP;

@Test(groups = {"API"})
public class Get_Demo extends BaseTest implements Constants {

    Response response;

    @BeforeTest
    public void beforeTestMethod(){
        response = RestAssured.given()
                .contentType(appJson)
                .when()
                .get(listUsersEP);


    }

    @Test (testName = "Verify List Users Response Status Code is 200.", enabled = false)
    public void verifyListUsersResStatus(){
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "List Users Response Status");
    }

    @Test (testName = "Verify List Users Response Time is less than 5 Sec.", enabled = false)
    public void verifyListUsersResTime(){
        response
                .then()
                .assertThat()
                .time(Matchers.lessThan(1000L));
    }

}
