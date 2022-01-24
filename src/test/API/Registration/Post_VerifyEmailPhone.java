package test.API.Registration;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import main.ApiConfigs.Body.RegistrationBODY;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.BaseTest;

import static main.ApiConfigs.EndPoints.RegistrationEP.verifyEmailPhoneEP;
import static main.utils.Constants.appJson;

@Test(groups = {"API"})
public class Post_VerifyEmailPhone extends BaseTest {
    Response response;
    RegistrationBODY registrationBODY = new RegistrationBODY();
    String errorMessage;

    /* Valid Data */

    @Test(priority = 0, testName = "Verify Registration - Verify Email & Phone - Set Response")
    public void setResponseForValidData() {
        String body = registrationBODY.RegistrationVerify_Body(false);
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(verifyEmailPhoneEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Verify Registration - Verify Email & Phone Response Status Code is 200.", priority = 1)
    public void verifyResponseStatusCode_Valid() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "Response Status Code for EP: '" + verifyEmailPhoneEP + "' is " + statusCode);
    }

    @Test(testName = "Verify Registration - Verify Email & Phone Response Time is less than 5 Sec.", priority = 1)
    public void verifyResponseTime_Valid() {
        response
                .then()
                .assertThat()
                .time(Matchers.lessThan(5000L));
    }

    @Test(testName = "Verify Registration - Verify Email & Phone Response has the verification code", priority = 1)
    public void verifyVerificationCode_Valid() {
        String verificationCode = response.jsonPath().get("verificationCode");
        Assert.assertNotNull(verificationCode, "Token should not be null");
    }

    /* InValid Data */

    @Test(priority = 2, testName = "Verify Registration - InValid Data - Verify Email & Phone - Set Response")
    public void setResponseForInValidData(){
        String body = registrationBODY.RegistrationVerify_Invalid_Body();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(verifyEmailPhoneEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Verify Registration - InValid Data - Verify Email & Phone Response Status Code is 404.", priority = 3)
    public void verifyResponseStatusCode_InValid() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 404, "Response Status Code for EP: '" + verifyEmailPhoneEP + "' is " + statusCode);
    }

    @Test(testName = "Verify Registration - InValid Data - Verify Email & Phone Response has the Error", priority = 3)
    public void verifyError_InValid() {
        errorMessage = response.jsonPath().get("_error");
        Assert.assertNotNull(errorMessage, "Error Message should be returned");
    }

    /* Empty Data */

    @Test(priority = 4, testName = "Verify Registration - Empty Data - Verify Email & Phone - Set Response")
    public void setResponseForEmptyData(){
        String body = registrationBODY.RegistrationVerify_Empty_Body();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(verifyEmailPhoneEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Verify Registration - Empty Data - Verify Email & Phone Response Status Code is 400.", priority = 5)
    public void verifyResponseStatusCode_Empty() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 400, "Response Status Code for EP: '" + verifyEmailPhoneEP + "' is " + statusCode);
    }

    @Test(testName = "Verify Registration - Empty Data - Verify Email & Phone Response has the Error", priority = 5)
    public void verifyError_Empty() {
        errorMessage = response.jsonPath().get("_error");
        Assert.assertNotNull(errorMessage, "Error Message: 'missingMandatoryParams' should be returned");
    }

}
