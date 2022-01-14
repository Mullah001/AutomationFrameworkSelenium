package test.API.LogIn;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import main.ApiConfigs.Body.LogInBODY;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.BaseTest;

import static main.ApiConfigs.EndPoints.LogInEP.*;
import static main.utils.Constants.appJson;

@Test(groups = {"API"})
public class Post_ResavePassword  extends BaseTest {
    Response response;
    LogInBODY loginBody = new LogInBODY();

    @BeforeTest
    public void beforeTestMethod(){
        String body = loginBody.reSavePassword_Body();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(resavePasswordEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Verify Resave Password Response Status Code is 200.")
    public void verifyResponseCode(){
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "Resave Password Response Status");
    }
}
