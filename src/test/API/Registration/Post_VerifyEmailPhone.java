package test.API.Registration;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import main.ApiConfigs.Body.RegistrationBODY;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.BaseTest;

import static main.ApiConfigs.EndPoints.RegistrationEP.verifyEmailPhone;
import static main.utils.Constants.appJson;

public class Post_VerifyEmailPhone extends BaseTest {
    Response response;
    RegistrationBODY registrationBODY = new RegistrationBODY();
    int messageDisplayCount = 0;

    String verificationCode;

    @BeforeTest
    public void beforeTestMethod(){
        String body = registrationBODY.RegistrationVerify_Body();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(verifyEmailPhone)
                .then()
                .extract().response();

        if(messageDisplayCount == 0) {
            System.out.println("Registration: " + response.jsonPath().get("_message"));
            messageDisplayCount++;
        }
    }

    @Test(testName = "Verify logIn Response Status Code is 200.")
    public void verifyResponseCode(){
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "LogIn Response Status");
    }

    @Test (testName = "Verify logIn Response Time is less than 5 Sec.")
    public void verifyResponseTime(){
        response
                .then()
                .assertThat()
                .time(Matchers.lessThan(5000L));
    }

    @Test(testName = "Verify logIn Response has the Token")
    public void verifyToken(){
        //System.out.println(response.asPrettyString());
        verificationCode = response.jsonPath().get("verificationCode");
        System.out.println("verificationCode: " + verificationCode);
        Assert.assertNotNull(verificationCode, "Token should not be null");
    }

    @Test(testName = "Register user", priority = 1)
    public void verifyRegister(){

    }


}
