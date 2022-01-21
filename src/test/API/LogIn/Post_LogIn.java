package test.API.LogIn;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import main.ApiConfigs.Body.LogInBODY;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.BaseTest;

import static main.ApiConfigs.EndPoints.LogInEP.loginEP;
import static main.ApiConfigs.EndPoints.RegistrationEP.verifyEmailPhoneEP;
import static main.utils.Constants.appJson;

@Test(groups = {"API"})
public class Post_LogIn extends BaseTest {
    Response response;
    LogInBODY loginBody = new LogInBODY();

    /********* Valid Data *********/

    @Test(priority = 0, testName = "LogIn - Valid - Set Response")
    public void setResponseForValidData() {
        String body = loginBody.logIn_Body();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(loginEP)
                .then()
                .extract().response();
    }

    @Test(testName = "LogIn - Valid - Verify logIn Response Status Code is 200.", priority = 1)
    public void verifyResponseCode(){
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "LogIn Response Status");
    }

    @Test (testName = "LogIn - Valid - Verify logIn Response Time is less than 5 Sec.", priority = 1)
    public void verifyResponseTime(){
        response
                .then()
                .assertThat()
                .time(Matchers.lessThan(5000L));
    }

    @Test(testName = "LogIn - Valid - Verify logIn Response has the Token", priority = 1)
    public void verifyToken(){
        //System.out.println(response.asPrettyString());
        String X_Auth = response.jsonPath().get("X-Auth");
        Assert.assertNotNull(X_Auth, "Token should not be null");
    }

    @Test(testName = "LogIn - Valid - Verify logIn Response has the Consumer Name", priority = 1)
    public void verifyName(){
        String consumerName = response.jsonPath().get("consumer.name");
        Assert.assertNotNull(consumerName, "Consumer Name should not be null");
    }

    @Test(testName = "LogIn - Valid - Verify logIn Response has the Consumer Email", priority = 1)
    public void verifyEmail(){
        String consumerEmail = response.jsonPath().get("consumer.email");
        Assert.assertNotNull(consumerEmail, "Consumer Email should not be null");
    }

    @Test(testName = "LogIn - Valid - Verify logIn Response has the Consumer PhoneNumber", priority = 1)
    public void verifyPhoneNumber(){
        String consumerPhoneNumber = response.jsonPath().get("consumer.phoneNumber");
        Assert.assertNotNull(consumerPhoneNumber, "Consumer PhoneNumber should not be null");
    }

    /********** In Valid Data - Email **********/

    @Test(priority = 2, testName = "LogIn - InValid Email - Set Response")
    public void setResponseForValidData_InValid_Email() {
        String body = loginBody.logIn_Body_InValid_Email();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(loginEP)
                .then()
                .extract().response();
    }

    @Test(testName = "LogIn - InValid Email - Verify logIn Response Status Code is 401.", priority = 3)
    public void verifyResponseCode_InValid_Email(){
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 401, "LogIn - InValid Email - Response Status");
    }

    @Test(testName = "LogIn - InValid Email - Verify logIn Response has the _error", priority = 3)
    public void verifyError_InValid_Email(){
        String errorMessage = response.jsonPath().get("_error");
        Assert.assertEquals(errorMessage, "User does not exist", "Error Message should be 'User does not exist'");
    }

    /********** In Valid Data - Password **********/

    @Test(priority = 4, testName = "LogIn - InValid Password - Set Response")
    public void setResponseForValidData_InValid_Password() {
        String body = loginBody.logIn_Body_InValid_Password();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(loginEP)
                .then()
                .extract().response();
    }

    @Test(testName = "LogIn - InValid Password - Verify logIn Response Status Code is 401.", priority = 5)
    public void verifyResponseCode_InValid_Password(){
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 401, "LogIn - InValid Password - Response Status");
    }

    @Test(testName = "LogIn - InValid Password - Verify logIn Response has the _error", priority = 5)
    public void verifyError_InValid_Password(){
        String errorMessage = response.jsonPath().get("_error");
        Assert.assertEquals(errorMessage, "Invalid credentials", "Error Message should be 'Invalid credentials'");
    }

    /********** Empty Data **********/

    @Test(priority = 6, testName = "LogIn - Empty Data - Set Response")
    public void setResponseForValidData_Empty() {
        String body = loginBody.logIn_Body_Empty();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(loginEP)
                .then()
                .extract().response();
    }

    @Test(testName = "LogIn - Empty Data - Verify logIn Response Status Code is 400.", priority = 7)
    public void verifyResponseCode_InValid_Empty(){
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 400, "LogIn - InValid Password - Response Status");
    }

    @Test(testName = "LogIn - Empty Data - Verify logIn Response has the _error", priority = 7)
    public void verifyError_InValid_Empty(){
        String errorMessage = response.jsonPath().get("_error");
        Assert.assertEquals(errorMessage, "Both Email & Password are required", "Error Message should be 'Both Email & Password are required'");
    }


}
