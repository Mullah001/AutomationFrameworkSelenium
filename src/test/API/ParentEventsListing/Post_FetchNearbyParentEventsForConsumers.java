package test.API.ParentEventsListing;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import main.ApiConfigs.Body.ParentEventsListingBODY;
import main.data.API.ParentEventsListingData;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

import java.util.ArrayList;

import static main.ApiConfigs.EndPoints.ParentEventsListingEP.fetchNearbyParentEventsForConsumerEP;
import static main.utils.Constants.appJson;

@Test(groups = {"API"})
public class Post_FetchNearbyParentEventsForConsumers extends BaseTest {
    Response response;
    ParentEventsListingBODY parentEventsListingBODY = new ParentEventsListingBODY();

    /********* Valid Data *********/

    @Test(testName = "Fetch Nearby Parent Events For Consumers - Valid - Set Response")
    public void setResponseForValidData() {
        String body = parentEventsListingBODY.fetchNearbyParentEventsConsumers_Body();

        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchNearbyParentEventsForConsumerEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - Valid - Verify Fetch Nearby Parent Events For Consumers Response Status Code is 200.", priority = 1)
    public void verifyResponseCode() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "LogIn Response Status");
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - Valid - Verify Fetch Nearby Parent Events For Consumers Response Time is less than 5 Sec.", priority = 1)
    public void verifyResponseTime() {
        response
                .then()
                .assertThat()
                .time(Matchers.lessThan(5000L));
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - Valid - Verify Fetch Nearby Parent Events For Consumers Response has the TotalDocs", priority = 1)
    public void verifyTotalDocs() {
        int totalDocs = response.jsonPath().get("totalDocs");
        Assert.assertNotNull(totalDocs, "TotalDocs should not be null");
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - Valid - Verify Fetch Nearby Parent Events For Consumers Response has the Limit", priority = 1)
    public void verifyLimit() {
        int limit = response.jsonPath().get("limit");
        Assert.assertNotNull(limit, "limit should not be null");
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - Valid - Verify Fetch Nearby Parent Events For Consumers Response has the page", priority = 1)
    public void verifyPage() {
        int page = response.jsonPath().get("page");
        Assert.assertEquals(page, 1, "page should be '" + ParentEventsListingData.page + "'");
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - Valid - Verify Fetch Nearby Parent Events For Consumers Response has the totalPages", priority = 1)
    public void verifyTotalPages() {
        int totalPages = response.jsonPath().get("totalPages");
        Assert.assertNotNull(totalPages, "totalPages should not be null");
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - Valid - Verify Fetch Nearby Parent Events For Consumers Response has the pagingCounter", priority = 1)
    public void verifyPagingCounter() {
        int pagingCounter = response.jsonPath().get("pagingCounter");
        Assert.assertNotNull(pagingCounter, "pagingCounter should not be null");
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - Valid - Verify Fetch Nearby Parent Events For Consumers Response has the venueIds", priority = 1)
    public void verifyVenueIds() {
        ArrayList venueIds = response.jsonPath().get("venueIds");
        Assert.assertTrue(venueIds.size() > 0, "venueIds should be more than 0");
    }

    /********* InValid Data - Paginate *********/

    @Test(priority = 2, testName = "Fetch Nearby Parent Events For Consumers - InValid Paginate - Set Response")
    public void setResponse_InValid_Paginate() {
        String body = parentEventsListingBODY.fetchNearbyParentEventsConsumers_Body_InValid_Paginate();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchNearbyParentEventsForConsumerEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - InValid Paginate - Verify Fetch Nearby Parent Events For Consumers Response Status Code is 500.", priority = 3)
    public void verifyResponseCode_InValid_Paginate() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 500, "LogIn Response Status");
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - InValid Paginate - Verify Fetch Nearby Parent Events For Consumers Response has the _error", priority = 3)
    public void verifyError_InValid_Paginate() {
        String errorMessage = response.jsonPath().get("_error");
        Assert.assertEquals(errorMessage, "Unexpected token h in JSON at position 0", "Error Message should be 'Unexpected token h in JSON at position 0'");
    }

    /********* InValid Data - Latitude *********/

    @Test(priority = 4, testName = "Fetch Nearby Parent Events For Consumers - InValid Latitude - Set Response")
    public void setResponse_InValid_Latitude() {
        String body = parentEventsListingBODY.fetchNearbyParentEventsConsumers_Body_InValid_Latitude();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchNearbyParentEventsForConsumerEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - InValid Latitude - Verify Fetch Nearby Parent Events For Consumers Response Status Code is 500.", priority = 5)
    public void verifyResponseCode_InValid_Latitude() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 500, "LogIn Response Status");
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - InValid Latitude - Verify Fetch Nearby Parent Events For Consumers Response has the _error", priority = 5)
    public void verifyError_InValid_Latitude() {
        int errorMessage = response.jsonPath().get("_error");
        Assert.assertEquals(errorMessage, 2, "Error Message should be '2'");
    }

    /********* InValid Data - Longitude *********/

    @Test(priority = 6, testName = "Fetch Nearby Parent Events For Consumers - InValid Longitude - Set Response")
    public void setResponse_InValid_Longitude() {
        String body = parentEventsListingBODY.fetchNearbyParentEventsConsumers_Body_InValid_Longitude();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchNearbyParentEventsForConsumerEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - InValid Longitude - Verify Fetch Nearby Parent Events For Consumers Response Status Code is 500.", priority = 7)
    public void verifyResponseCode_InValid_Longitude() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 500, "LogIn Response Status");
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - InValid Longitude - Verify Fetch Nearby Parent Events For Consumers Response has the _error", priority = 7)
    public void verifyError_InValid_Longitude() {
        int errorMessage = response.jsonPath().get("_error");
        Assert.assertEquals(errorMessage, 2, "Error Message should be '2'");
    }

    /********* InValid Data - Country *********/

    @Test(priority = 8, testName = "Fetch Nearby Parent Events For Consumers - InValid Country - Set Response")
    public void setResponse_InValid_Country() {
        String body = parentEventsListingBODY.fetchNearbyParentEventsConsumers_Body_InValid_Country();
        System.out.println(body);
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchNearbyParentEventsForConsumerEP)
                .then()
                .extract().response();

    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - InValid Country - Verify Fetch Nearby Parent Events For Consumers Response Status Code is 200.", priority = 9)
    public void verifyResponseCode_InValid_Country() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "LogIn Response Status");
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - InValid Country - Verify Fetch Nearby Parent Events For Consumers Response has the eventsCount", priority = 9)
    public void verifyEventsCount_InValid_Country() {
        ArrayList data = response.jsonPath().get("data");
        Assert.assertEquals(data.size(), 0, "Events count should be '0'");
    }

    /********* Empty Data - Paginate *********/

    @Test(priority = 10, testName = "Fetch Nearby Parent Events For Consumers - Empty Paginate - Set Response")
    public void setResponse_Empty_Paginate() {
        String body = parentEventsListingBODY.fetchNearbyParentEventsConsumers_Body_Empty_Paginate();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchNearbyParentEventsForConsumerEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - Empty Paginate - Verify Fetch Nearby Parent Events For Consumers Response Status Code is 500.", priority = 11)
    public void verifyResponseCode_Empty_Paginate() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 500, "LogIn Response Status");
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - Empty Paginate - Verify Fetch Nearby Parent Events For Consumers Response has the _error", priority = 11)
    public void verifyError_Empty_Paginate() {
        String errorMessage = response.jsonPath().get("_error");
        Assert.assertEquals(errorMessage, "Unexpected end of JSON input", "Error Message should be 'Unexpected end of JSON input'");
    }

    /********* Empty Data - Country *********/

    @Test(priority = 12, testName = "Fetch Nearby Parent Events For Consumers - Empty Country - Set Response")
    public void setResponse_Empty_Country() {
        String body = parentEventsListingBODY.fetchNearbyParentEventsConsumers_Body_Empty_Country();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchNearbyParentEventsForConsumerEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - Empty Country - Verify Fetch Nearby Parent Events For Consumers Response Status Code is 200.", priority = 13)
    public void verifyResponseCode_Empty_Country() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "LogIn Response Status");
    }

    /********* Empty Data - Longitude *********/

    @Test(priority = 14, testName = "Fetch Nearby Parent Events For Consumers - Empty Longitude - Set Response")
    public void setResponse_Empty_Longitude() {
        String body = parentEventsListingBODY.fetchNearbyParentEventsConsumers_Body_Empty_Longitude();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchNearbyParentEventsForConsumerEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - Empty Longitude - Verify Fetch Nearby Parent Events For Consumers Response Status Code is 500.", priority = 15)
    public void verifyResponseCode_Empty_Longitude() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 500, "LogIn Response Status");
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - Empty Longitude - Verify Fetch Nearby Parent Events For Consumers Response has the _error", priority = 15)
    public void verifyError_Empty_Longitude() {
        int errorMessage = response.jsonPath().get("_error");
        Assert.assertEquals(errorMessage, 2, "Error Message should be '2'");
    }

    /********* Empty Data - Latitude *********/

    @Test(priority = 16, testName = "Fetch Nearby Parent Events For Consumers - Empty Latitude - Set Response")
    public void setResponse_Empty_Latitude() {
        String body = parentEventsListingBODY.fetchNearbyParentEventsConsumers_Body_Empty_Latitude();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchNearbyParentEventsForConsumerEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - Empty Latitude - Verify Fetch Nearby Parent Events For Consumers Response Status Code is 500.", priority = 17)
    public void verifyResponseCode_Empty_Latitude() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 500, "LogIn Response Status");
    }

    @Test(testName = "Fetch Nearby Parent Events For Consumers - Empty Latitude - Verify Fetch Nearby Parent Events For Consumers Response has the _error", priority = 17)
    public void verifyError_Empty_Latitude() {
        int errorMessage = response.jsonPath().get("_error");
        Assert.assertEquals(errorMessage, 2, "Error Message should be '2'");
    }


}