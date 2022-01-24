package test.API.Registration;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import main.ApiConfigs.Body.RegistrationBODY;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

import static main.ApiConfigs.EndPoints.RegistrationEP.registerEP;
import static main.ApiConfigs.EndPoints.RegistrationEP.verifyEmailPhoneEP;
import static main.data.API.RegistrationData.emptyVerificationCode;
import static main.data.API.RegistrationData.inValidVerificationCode;
import static main.utils.Constants.appJson;
import static main.utils.Constants.xAuth;

@Test(groups = {"API"})
public class Post_Register extends BaseTest {
    Response response;
    RegistrationBODY registrationBODY = new RegistrationBODY();
    String register_EP;
    String errorMessage;

    /* Valid Data */

    @Test(testName = "Verify Registration - Register - Set Response Valid")
    public void setResponse_Valid() {
        createRegisterEP_Valid();
        String body = RegistrationBODY.Register_Body();

        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(register_EP)
                .then()
                .extract().response();
    }

    @Test(testName = "Verify Registration - Register Response Status Code is 200.", priority = 1)
    public void verifyResponseStatusCode_Valid() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Response Status Code for EP: '" + register_EP + "' is " + statusCode);
    }

    @Test(testName = "Verify Registration - Register Response Time is less than 5 Sec.", priority = 1)
    public void verifyResponseTime_Valid() {
        response
                .then()
                .assertThat()
                .time(Matchers.lessThan(5000L));
    }

    @Test(testName = "Verify Registration - Register Response has the X-Auth code", priority = 1)
    public void verifyVerificationCode_Valid() {
        String x_Auth = response.jsonPath().get(xAuth);
        logTextOnReport("X-Auth: " + x_Auth);
        Assert.assertNotNull(x_Auth, "Token should not be null");
    }

    @Test(testName = "Verify Registration - Register Response has the _message", priority = 1)
    public void verifyResponseMessage_Valid() {
        String _message = response.jsonPath().get("_message");
        logTextOnReport("Message: " + _message);
        Assert.assertNotNull(_message, "Message should not be null");
    }

    /* InValid Data */
    /* InValid Body */

    @Test(priority = 2, testName = "Verify Registration - InValid Data Body - Register - Set Response")
    public void setResponseForInValidData_Body() {
        createRegisterEP_Valid();

        String body = RegistrationBODY.Register_InValid_Body();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(register_EP)
                .then()
                .extract().response();
    }

    @Test(testName = "Verify Registration - InValid Data Body - Register Response Status Code is 422.", priority = 3)
    public void verifyResponseStatusCode_InValid_Body() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 422, "Response Status Code for EP: '" + register_EP + "' is " + statusCode);
    }

    @Test(testName = "Verify Registration - InValid Data Body - Register Response has the Error", priority = 3)
    public void verifyError_InValid_Body() {
        errorMessage = response.jsonPath().get("_error");
        logTextOnReport("Error Message - InValid Body: " + errorMessage);
        Assert.assertNotNull(errorMessage, "Error Message should be returned");
    }

    /* InValid VerificationCode */

    @Test(priority = 4, testName = "Verify Registration - InValid Data Body - Register - Set Response")
    public void setResponseForInValidData_VerificationCode() {
        createRegisterEP_InValid_Verification();

        String body = RegistrationBODY.Register_Body();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(register_EP)
                .then()
                .extract().response();
    }

    @Test(testName = "Verify Registration - InValid Data Body - Register Response Status Code is 400.", priority = 5)
    public void verifyResponseStatusCode_InValid_VerificationCode() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400, "Response Status Code for EP: '" + register_EP + "' is " + statusCode);
    }

    @Test(testName = "Verify Registration - InValid Data Body - Register Response has the Error", priority = 5)
    public void verifyError_InValid_VerificationCode() {
        errorMessage = response.jsonPath().get("_error");
        logTextOnReport("Error Message - InValid Verification Code: " + errorMessage);
        Assert.assertNotNull(errorMessage, "Error Message should be returned");
    }

    /* Empty Data */
    /* Empty Body */

    @Test(priority = 6, testName = "Verify Registration - Empty Data - Register - Set Response")
    public void setResponseForEmptyData_Body() {
        createRegisterEP_Valid();

        String body = RegistrationBODY.Register_Empty_Body();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(register_EP)
                .then()
                .extract().response();
    }

    @Test(testName = "Verify Registration - Empty Data - Register Response Status Code is 422.", priority = 7)
    public void verifyResponseStatusCode_Empty_Body() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 422, "Response Status Code for EP: '" + register_EP + "' is " + statusCode);
    }

    @Test(testName = "Verify Registration - Empty Data - Register Response has the Error", priority = 7)
    public void verifyError_Empty_Body() {
        errorMessage = response.jsonPath().get("_error");
        logTextOnReport("Error Message - Empty Body: " + errorMessage);
        Assert.assertNotNull(errorMessage, "Error Message: 'missingMandatoryParams' should be returned");
    }

    /* Empty Verification Code */

    @Test(priority = 8, testName = "Verify Registration - Empty Verification Code - Register - Set Response")
    public void setResponseForEmptyData_VerificationCode() {
        createRegisterEP_Empty_Verification();

        String body = RegistrationBODY.Register_Body();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(register_EP)
                .then()
                .extract().response();
    }

    @Test(testName = "Verify Registration - Empty Verification Code - Register Response Status Code is 404.", priority = 9)
    public void verifyResponseStatusCode_Empty_VerificationCode() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 404, "Response Status Code for EP: '" + register_EP + "' is " + statusCode);
    }


    /* Helper Methods */

    @Test(enabled = false)
    public void createRegisterEP_Valid() {
            String body = RegistrationBODY.RegistrationVerify_Body(true);
            Response responseVerificationCode = RestAssured.given()
                    .contentType(appJson)
                    .and()
                    .body(body)
                    .when()
                    .post(verifyEmailPhoneEP)
                    .then()
                    .extract().response();

            String verification_Code = responseVerificationCode.jsonPath().get("verificationCode");

            register_EP = registerEP + verification_Code;
    }

    @Test(enabled = false)
    public void createRegisterEP_InValid_Verification() {
        register_EP = registerEP + inValidVerificationCode;
    }

    @Test(enabled = false)
    public void createRegisterEP_Empty_Verification() {
        register_EP = registerEP + emptyVerificationCode;
    }
}
