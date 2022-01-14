package test.API.LogIn;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import main.ApiConfigs.Body.LogInBODY;
import main.ApiConfigs.EndPoints.LogInEP;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.BaseTest;

import static main.data.LogInData.forgotEmail;
import static main.utils.Constants.appJson;

@Test(groups = {"API"})
public class Get_ForgotPassword  extends BaseTest {
    Response response;
    LogInBODY loginBody = new LogInBODY();
    int messageDisplayCount = 0;

    @BeforeTest
    public void beforeTestMethod(){

        String forgotPassword_EP = LogInEP.forgotPasswordEP + forgotEmail;

        response = RestAssured.given()
                .contentType(appJson)
                .when()
                .get(forgotPassword_EP);

        if(messageDisplayCount == 0) {
            System.out.println("Forgot Password: " + response.jsonPath().get("_message"));
            messageDisplayCount++;
        }
    }

    @Test(testName = "Verify Forgot Password Response Status Code is 200.")
    public void verifyResponseCode(){
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "Forgot Password Response Status");
    }

    @Test (testName = "Verify Forgot Password Response Time is less than 5 Sec.")
    public void verifyResponseTime(){
        response
                .then()
                .assertThat()
                .time(Matchers.lessThan(5000L));
    }

    @Test(testName = "Verify Forgot Password Response has the message field")
    public void verifyMessage(){
        //System.out.println(response.asPrettyString());
        String message = response.jsonPath().get("_message");
        Assert.assertNotNull(message, "Message Field should not be null");
    }
}
