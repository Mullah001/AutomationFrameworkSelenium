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

import static main.ApiConfigs.EndPoints.ParentEventsListingEP.fetchTrendingEventsEP;
import static main.utils.Constants.appJson;

@Test(groups = {"API"})
public class Post_FetchTrendingEvents extends BaseTest {
    Response response;
    ParentEventsListingBODY parentEventsListingBODY = new ParentEventsListingBODY();

    /********* Valid Data *********/

    @Test(testName = "Fetch Trending Events - Valid - Set Response")
    public void setResponseForValidData() {
        String body = parentEventsListingBODY.fetchTrendingEvents_Body();

        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchTrendingEventsEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Fetch Trending Events - Valid - Verify Fetch Trending Events Response Status Code is 200.", priority = 1)
    public void verifyResponseCode() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "LogIn Response Status");
    }

    @Test(testName = "Fetch Trending Events - Valid - Verify Fetch Trending Events Response Time is less than 5 Sec.", priority = 1)
    public void verifyResponseTime() {
        response
                .then()
                .assertThat()
                .time(Matchers.lessThan(5000L));
    }

    @Test(testName = "Fetch Trending Events - Valid - Verify Fetch Trending Events Response has the TotalDocs", priority = 1)
    public void verifyTotalDocs() {
        int totalDocs = response.jsonPath().get("totalDocs");
        Assert.assertNotNull(totalDocs, "TotalDocs should not be null");
    }

    @Test(testName = "Fetch Trending Events - Valid - Verify Fetch Trending Events Response has the Limit", priority = 1)
    public void verifyLimit() {
        int limit = response.jsonPath().get("limit");
        Assert.assertNotNull(limit, "limit should not be null");
    }

    @Test(testName = "Fetch Trending Events - Valid - Verify Fetch Trending Events Response has the page", priority = 1)
    public void verifyPage() {
        int page = response.jsonPath().get("page");
        Assert.assertEquals(page, 1, "page should be '" + ParentEventsListingData.page + "'");
    }

    @Test(testName = "Fetch Trending Events - Valid - Verify Fetch Trending Events Response has the totalPages", priority = 1)
    public void verifyTotalPages() {
        int totalPages = response.jsonPath().get("totalPages");
        Assert.assertNotNull(totalPages, "totalPages should not be null");
    }

    @Test(testName = "Fetch Trending Events - Valid - Verify Fetch Trending Events Response has the pagingCounter", priority = 1)
    public void verifyPagingCounter() {
        int pagingCounter = response.jsonPath().get("pagingCounter");
        Assert.assertNotNull(pagingCounter, "pagingCounter should not be null");
    }

    @Test(testName = "Fetch Trending Events - Valid - Verify Fetch Trending Events Response has the eventsCount", priority = 1)
    public void verifyEventsCount() {
        ArrayList data = response.jsonPath().get("data");
        Assert.assertTrue(data.size() > 3, "Events count should be greater than '3'");
    }

    /********* InValid Data - Paginate *********/

    @Test(priority = 2, testName = "Fetch Trending Events - InValid Paginate - Set Response")
    public void setResponse_InValid_Paginate() {
        String body = parentEventsListingBODY.fetchTrendingEvents_Body_InValid_Paginate();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchTrendingEventsEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Fetch Trending Events - InValid Paginate - Verify Fetch Trending Events Response Status Code is 500.", priority = 3)
    public void verifyResponseCode_InValid_Paginate() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 500, "LogIn Response Status");
    }

    @Test(testName = "Fetch Trending Events - InValid Paginate - Verify Fetch Trending Events Response has the _error", priority = 3)
    public void verifyError_InValid_Paginate() {
        String errorMessage = response.jsonPath().get("_error");
        Assert.assertEquals(errorMessage, "Unexpected token h in JSON at position 0", "Error Message should be 'Unexpected token h in JSON at position 0'");
    }

    /********* InValid Data - Country *********/

    @Test(priority = 4, testName = "Fetch Trending Events - InValid Country - Set Response")
    public void setResponse_InValid_Country() {
        String body = parentEventsListingBODY.fetchTrendingEvents_Body_InValid_Country();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchTrendingEventsEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Fetch Trending Events - InValid Country - Verify Fetch Trending Events Response Status Code is 200.", priority = 5)
    public void verifyResponseCode_InValid_Country() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "LogIn Response Status");
    }

    @Test(testName = "Fetch Trending Events - InValid Country - Verify Fetch Trending Events Response has the eventsCount", priority = 5)
    public void verifyEventsCount_InValid_Country() {
        ArrayList data = response.jsonPath().get("data");
        Assert.assertEquals(data.size(), 0, "Events count should be '0'");
    }

    /********* Empty Data - Paginate *********/

    @Test(priority = 6, testName = "Fetch Trending Events - Empty Paginate - Set Response")
    public void setResponse_Empty_Paginate() {
        String body = parentEventsListingBODY.fetchTrendingEvents_Body_Empty_Paginate();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchTrendingEventsEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Fetch Trending Events - Empty Paginate - Verify Fetch Trending Events Response Status Code is 500.", priority = 7)
    public void verifyResponseCode_Empty_Paginate() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 500, "LogIn Response Status");
    }

    @Test(testName = "Fetch Trending Events - Empty Paginate - Verify Fetch Trending Events Response has the _error", priority = 7)
    public void verifyError_Empty_Paginate() {
        String errorMessage = response.jsonPath().get("_error");
        Assert.assertEquals(errorMessage, "Unexpected end of JSON input", "Error Message should be 'Unexpected end of JSON input'");
    }

    /********* Empty Data - Country *********/

    @Test(priority = 8, testName = "Fetch Trending Events - Empty Country - Set Response")
    public void setResponse_Empty_Country() {
        String body = parentEventsListingBODY.fetchTrendingEvents_Body_Empty_Country();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchTrendingEventsEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Fetch Trending Events - Empty Country - Verify Fetch Trending Events Response Status Code is 200.", priority = 9)
    public void verifyResponseCode_Empty_Country() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "LogIn Response Status");
    }


}
