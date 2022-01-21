package test.API.MoviesListing;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import main.ApiConfigs.Body.MoviesListingBODY;
import main.data.API.MoviesListingData;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

import java.util.ArrayList;

import static main.ApiConfigs.EndPoints.MoviesListingEP.*;
import static main.utils.Constants.appJson;

@Test(groups = {"API"})
public class Post_FetchTrendingEventsCat extends BaseTest {
    Response response;
    MoviesListingBODY moviesListingBODY = new MoviesListingBODY();

    /********* Valid Data *********/

    @Test(testName = "Fetch Trending Events Category Wise - Valid - Set Response")
    public void setResponseForValidData() {
        String body = MoviesListingBODY.FetchTrendingEventsCat_Body();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchTrendingEventsCatEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Fetch Trending Events Category Wise - Valid - Verify Fetch Trending Events Category Wise Response Status Code is 200.", priority = 1)
    public void verifyResponseCode() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "LogIn Response Status");
    }

    @Test(testName = "Fetch Trending Events Category Wise - Valid - Verify Fetch Trending Events Category Wise Response Time is less than 5 Sec.", priority = 1)
    public void verifyResponseTime() {
        response
                .then()
                .assertThat()
                .time(Matchers.lessThan(5000L));
    }

    @Test(testName = "Fetch Trending Events Category Wise - Valid - Verify Fetch Trending Events Category Wise Response has the TotalDocs", priority = 1)
    public void verifyTotalDocs() {
        int totalDocs = response.jsonPath().get("totalDocs");
        Assert.assertNotNull(totalDocs, "TotalDocs should not be null");
    }

    @Test(testName = "Fetch Trending Events Category Wise - Valid - Verify Fetch Trending Events Category Wise Response has the Limit", priority = 1)
    public void verifyLimit() {
        int limit = response.jsonPath().get("limit");
        Assert.assertNotNull(limit, "limit should not be null");
    }

    @Test(testName = "Fetch Trending Events Category Wise - Valid - Verify Fetch Trending Events Category Wise Response has the page", priority = 1)
    public void verifyPage() {
        int page = response.jsonPath().get("page");
        Assert.assertEquals(page, 4, "page should be '" + MoviesListingData.page + "'");
    }

    @Test(testName = "Fetch Trending Events Category Wise - Valid - Verify Fetch Trending Events Category Wise Response has the totalPages", priority = 1)
    public void verifyTotalPages() {
        int totalPages = response.jsonPath().get("totalPages");
        Assert.assertNotNull(totalPages, "totalPages should not be null");
    }

    @Test(testName = "Fetch Trending Events Category Wise - Valid - Verify Fetch Trending Events Category Wise Response has the pagingCounter", priority = 1)
    public void verifyPagingCounter() {
        int pagingCounter = response.jsonPath().get("pagingCounter");
        Assert.assertNotNull(pagingCounter, "pagingCounter should not be null");
    }

    @Test(testName = "Fetch Trending Events Category Wise - Valid - Verify Fetch Trending Events Category Wise Response has the eventsCount", priority = 1)
    public void verifyEventsCount() {
        ArrayList data = response.jsonPath().get("data");
        Assert.assertEquals(data.size(), 2, "Events count should be '2'");
    }

    /********* InValid Data - Paginate *********/

    @Test(priority = 2, testName = "Fetch Trending Events Category Wise - InValid Paginate - Set Response")
    public void setResponse_InValid_Paginate() {
        String body = MoviesListingBODY.FetchTrendingEventsCat_Body_InValid_Pagination();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchTrendingEventsCatEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Fetch Trending Events Category Wise - InValid Paginate - Verify Fetch Trending Events Category Wise Response Status Code is 500.", priority = 3)
    public void verifyResponseCode_InValid_Paginate() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 500, "LogIn Response Status");
    }

    @Test(testName = "Fetch Trending Events Category Wise - InValid Paginate - Verify Fetch Trending Events Category Wise Response has the _error", priority = 3)
    public void verifyError_InValid_Paginate() {
        String errorMessage = response.jsonPath().get("_error");
        Assert.assertEquals(errorMessage, "Unexpected token h in JSON at position 0", "Error Message should be 'Unexpected token h in JSON at position 0'");
    }

    /********* InValid Data - Categories *********/

    @Test(priority = 4, testName = "Fetch Trending Events Category Wise - InValid Categories - Set Response")
    public void setResponse_InValid_Categories() {
        String body = MoviesListingBODY.FetchTrendingEventsCat_Body_InValid_Cat();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchTrendingEventsCatEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Fetch Trending Events Category Wise - InValid Categories - Verify Fetch Trending Events Category Wise Response Status Code is 500.", priority = 5)
    public void verifyResponseCode_InValid_Categories() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 500, "LogIn Response Status");
    }

    @Test(testName = "Fetch Trending Events Category Wise - InValid Categories - Verify Fetch Trending Events Category Wise Response has the _error", priority = 5)
    public void verifyError_InValid_Categories() {
        int errorMessage = response.jsonPath().get("_error");
        Assert.assertEquals(errorMessage, 2, "Error Message should be '2'");
    }

    /********* Empty Data - Paginate *********/

    @Test(priority = 6, testName = "Fetch Trending Events Category Wise - Empty Paginate - Set Response")
    public void setResponse_Empty_Paginate() {
        String body = MoviesListingBODY.FetchTrendingEventsCat_Body_Empty_Pagination();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchTrendingEventsCatEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Fetch Trending Events Category Wise - Empty Paginate - Verify Fetch Trending Events Category Wise Response Status Code is 500.", priority = 7)
    public void verifyResponseCode_Empty_Paginate() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 500, "LogIn Response Status");
    }

    @Test(testName = "Fetch Trending Events Category Wise - Empty Paginate - Verify Fetch Trending Events Category Wise Response has the _error", priority = 7)
    public void verifyError_Empty_Paginate() {
        String errorMessage = response.jsonPath().get("_error");
        Assert.assertEquals(errorMessage, "Unexpected end of JSON input", "Error Message should be 'Unexpected end of JSON input'");
    }

    /********* Empty Data - Categories *********/

    @Test(priority = 8, testName = "Fetch Trending Events Category Wise - Empty Categories - Set Response")
    public void setResponse_Empty_Categories() {
        String body = MoviesListingBODY.FetchTrendingEventsCat_Body_Empty_Cat();
        response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchTrendingEventsCatEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Fetch Trending Events Category Wise - Empty Categories - Verify Fetch Trending Events Category Wise Response Status Code is 200.", priority = 9)
    public void verifyResponseCode_Empty_Categories() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "LogIn Response Status");
    }

    @Test(testName = "Fetch Trending Events Category Wise - Empty Categories - Verify Fetch Trending Events Category Wise Response has the TotalDocs = 0", priority = 9)
    public void verifyTotalDocs_Empty_Categories() {
        int totalDocs = response.jsonPath().get("totalDocs");
        Assert.assertEquals(totalDocs, 0, "TotalDocs should be '0'");
    }

}
