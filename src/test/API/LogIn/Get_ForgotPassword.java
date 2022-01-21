package test.API.LogIn;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import main.ApiConfigs.EndPoints.LogInEP;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

import static main.data.API.LogInData.*;
import static main.utils.Constants.appJson;

@Test(groups = {"API"})
public class Get_ForgotPassword extends BaseTest {
    Response response;

    /********* Valid Data ********/

    @Test(priority = 0, testName = "LogIn - Forgot Password - Valid - Set Response")
    public void setResponseForValidData() {
        String forgotPassword_EP = LogInEP.forgotPasswordEP + forgotEmail;

        response = RestAssured.given()
                .contentType(appJson)
                .when()
                .get(forgotPassword_EP)
                .then()
                .extract().response();
    }

    @Test(testName = "Verify Forgot Password Response Status Code is 200.", priority = 1)
    public void verifyResponseCode() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Forgot Password Response Status");
    }

    @Test(testName = "Verify Forgot Password Response Time is less than 5 Sec.", priority = 1)
    public void verifyResponseTime() {
        response
                .then()
                .assertThat()
                .time(Matchers.lessThan(5000L));
    }

    @Test(testName = "Verify Forgot Password Response has the message", priority = 1)
    public void verifyMessage() {
        String message = response.jsonPath().get("_message");
        Assert.assertEquals(message, "Link to reset password has been sent to your email", "Message should be 'Link to reset password has been sent to your email'");
    }

    /********* InValid Data ********/

    @Test(priority = 2, testName = "LogIn - Forgot Password - InValid - Set Response")
    public void setResponseForValidData_InValid() {
        String forgotPassword_EP = LogInEP.forgotPasswordEP + inValidForgotEmail;

        response = RestAssured.given()
                .contentType(appJson)
                .when()
                .get(forgotPassword_EP)
                .then()
                .extract().response();
    }

    @Test(testName = "InValid - Verify Forgot Password Response Status Code is 404.", priority = 3)
    public void verifyResponseCode_InValid() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 404, "Forgot Password Response Status");
    }

    @Test(testName = "InValid - Verify Forgot Password Response has the message", priority = 3)
    public void verifyMessage_InValid() {
        String errorMessage = response.jsonPath().get("_error");
        Assert.assertEquals(errorMessage, "No consumer exist with email " + inValidForgotEmail, "Message should be 'No consumer exist with email " + inValidForgotEmail + "'");
    }

    /********* Empty Data ********/

    @Test(priority = 2, testName = "LogIn - Forgot Password - Empty - Set Response")
    public void setResponseForValidData_Empty() {
        String forgotPassword_EP = LogInEP.forgotPasswordEP + emptyForgotEmail;

        response = RestAssured.given()
                .contentType(appJson)
                .when()
                .get(forgotPassword_EP)
                .then()
                .extract().response();
    }

    @Test(testName = "Empty - Verify Forgot Password Response Status Code is 404.", priority = 3)
    public void verifyResponseCode_Empty() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 404, "Forgot Password Response Status");
    }


}
