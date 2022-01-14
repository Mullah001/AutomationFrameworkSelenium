package test.API.LogIn;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import main.ApiConfigs.Body.LogInBODY;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.BaseTest;

import static main.ApiConfigs.EndPoints.LogInEP.logInWithGoogleEP;
import static main.utils.Constants.appJson;

@Test(groups = {"API"})
public class Post_LogInWithGoogle extends BaseTest {
    Response response;
    LogInBODY loginBody = new LogInBODY();
    int messageDisplayCount = 0;

    @BeforeTest
    public void beforeTestMethod(){
        String body = loginBody.logInWithGoogle_Body();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(logInWithGoogleEP)
                .then()
                .extract().response();

        if(messageDisplayCount == 0) {
            System.out.println("LogIn With Google: " + response.jsonPath().get("_message"));
            messageDisplayCount++;
        }
    }

    @Test(testName = "Verify logIn with Google Response Status Code is 200.")
    public void verifyResponseCode(){
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "Login with Google Response Status");
    }

    @Test (testName = "Verify logIn with Google Response Time is less than 5 Sec.")
    public void verifyResponseTime(){
        response
                .then()
                .assertThat()
                .time(Matchers.lessThan(5000L));
    }

    @Test(testName = "Verify Login with Google Response has the Token")
    public void verifyToken(){
        //System.out.println(response.asPrettyString());
        String X_Auth = response.jsonPath().get("X-Auth");
        Assert.assertNotNull(X_Auth, "Token should not be null");
    }

    @Test(testName = "LogIn With Google - Verify User Exist")
    public void verifyUserExist(){
        boolean isExist = response.jsonPath().getBoolean("isExist");
        Assert.assertTrue(isExist, "User Exists should Exist");
    }

    @Test(testName = "Verify Login with Google Response has the Consumer Name")
    public void verifyName(){
        String consumerName = response.jsonPath().get("consumer.name");
        Assert.assertNotNull(consumerName, "Consumer Name should not be null");
    }

    @Test(testName = "Verify Login with Google Response has the Consumer Email")
    public void verifyEmail(){
        String consumerEmail = response.jsonPath().get("consumer.email");
        Assert.assertNotNull(consumerEmail, "Consumer Email should not be null");
    }

    @Test(testName = "Verify Login with Google Response has the Consumer PhoneNumber")
    public void verifyPhoneNumber(){
        String consumerPhoneNumber = response.jsonPath().get("consumer.phoneNumber");
        Assert.assertNotNull(consumerPhoneNumber, "Consumer PhoneNumber should not be null");
    }
}
