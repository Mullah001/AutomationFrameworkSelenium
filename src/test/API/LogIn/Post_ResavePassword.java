package test.API.LogIn;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import main.ApiConfigs.Body.LogInBODY;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.BaseTest;

import static io.restassured.path.xml.XmlPath.CompatibilityMode.HTML;
import static main.ApiConfigs.EndPoints.LogInEP.*;
import static main.utils.Constants.appJson;

@Test(groups = {"API"})
public class Post_ResavePassword  extends BaseTest {
    Response response;
    LogInBODY loginBody = new LogInBODY();

    /********* Valid Data *********/

    @Test(priority = 0, testName = "Resave Password - Valid - Set Response")
    public void setResponseForValidData() {
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

    @Test(testName = "Resave Password - Valid - Verify Resave Password Response Status Code is 200.", priority = 1)
    public void verifyResponseCode(){
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "Resave Password Response Status");
    }

    @Test (testName = "Resave Password - Valid - Verify logIn Response Time is less than 5 Sec.", priority = 1)
    public void verifyResponseTime(){
        response
                .then()
                .assertThat()
                .time(Matchers.lessThan(5000L));
    }

    @Test(testName = "Resave Password - Valid - Verify logIn Response has the Congratulation Message in HTML", priority = 1)
    public void verifyCongratulationsMessage(){
        XmlPath htmlPath = new XmlPath(HTML, response.getBody().asString());
        Assert.assertTrue(htmlPath.get("html.body").toString().contains("Congratulations!"));
    }

    /********* InValid Data *********/

    @Test(priority = 2, testName = "Resave Password - InValid - Set Response")
    public void setResponseForValidData_InValid() {
        String body = loginBody.reSavePassword_Body_InValid();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(resavePasswordEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Resave Password - InValid - Verify Resave Password Response Status Code is 500.", priority = 3)
    public void verifyResponseCode_InValid(){
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 500, "Resave Password Response Status");
    }

    @Test(testName = "Resave Password - InValid Email - Verify logIn Response has the _error", priority = 3)
    public void verifyError_InValid(){
        String errorMessage = response.jsonPath().get("_error");
        Assert.assertEquals(errorMessage, "No consumer exists ", "Error Message should be 'No consumer exists '");
    }

    /********* Empty Data - Token *********/

    @Test(priority = 4, testName = "Resave Password - Empty Token - Set Response")
    public void setResponseForValidData_Empty_Token() {
        String body = loginBody.reSavePassword_Body_Empty_Token();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(resavePasswordEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Resave Password - Empty Token - Verify Resave Password Response Status Code is 500.", priority = 5)
    public void verifyResponseCode_Empty_Token(){
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 500, "Resave Password Response Status");
    }

    @Test(testName = "Resave Password - Empty Token - Verify logIn Response has the _error", priority = 5)
    public void verifyError_Empty_Token(){
        String errorMessage = response.jsonPath().get("_error");
        Assert.assertEquals(errorMessage, "No consumer exists ", "Error Message should be 'No consumer exists '");
    }

    /********* Empty Data - Password *********/

    @Test(priority = 6, testName = "Resave Password - Empty Password - Set Response")
    public void setResponseForValidData_Empty_Password() {
        String body = loginBody.reSavePassword_Body_Empty_Password();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(resavePasswordEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Resave Password - Empty Password - Verify Resave Password Response Status Code is 422.", priority = 7)
    public void verifyResponseCode_Empty_Password(){
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 422, "Resave Password Response Status");
    }

    @Test(testName = "Resave Password - Empty Password - Verify logIn Response has the _error", priority = 7)
    public void verifyError_Empty_Password(){
        String errorMessage = response.jsonPath().get("_error");
        Assert.assertEquals(errorMessage, "consumer validation failed: password: Please provide a password", "Error Message should be 'consumer validation failed: password: Please provide a password'");
    }



}
