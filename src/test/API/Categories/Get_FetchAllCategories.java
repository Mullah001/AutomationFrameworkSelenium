package test.API.Categories;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import main.ApiConfigs.Params.CategoriesPARAMS;
import main.utils.API_DataMethods;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

import java.util.ArrayList;

import static main.ApiConfigs.EndPoints.CategoriesEP.fetchAllCategoriesEP;
import static main.utils.Constants.*;

@Test(groups = {"API"})
public class Get_FetchAllCategories extends BaseTest {
    CategoriesPARAMS categoriesPARAMS = new CategoriesPARAMS();
    Response response;

    /********* Valid Data *********/

    @Test(testName = "Fetch All Categories - Valid - Set Response")
    public void setResponseForValidData() {
        String token = categoriesPARAMS.fetchAllCategories_Valid();

        response = RestAssured.given()
                .contentType(textPlain)
                .and()
                .header(xAuth, token)
                .when()
                .get(fetchAllCategoriesEP)
                .then()
                .extract().response();
    }

    @Test(testName = "Fetch All Categories - Valid - Verify Fetch All Categories Response Status Code is 200.", priority = 1)
    public void verifyResponseCode() {
        //System.out.println(response.prettyPrint());
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "Fetch All Categories Response Status");
    }

    @Test(testName = "Fetch All Categories - Valid - Verify Fetch All Categories Response Time is less than 5 Sec.", priority = 1)
    public void verifyResponseTime() {
        response
                .then()
                .assertThat()
                .time(Matchers.lessThan(5000L));
    }

    @Test(testName = "Fetch All Categories - Valid - Verify Fetch All Categories Response has the categoriesCount", priority = 1)
    public void verifyCategoriesCount() {
        ArrayList data = response.jsonPath().get("data");
        Assert.assertEquals(data.size(), 4, "Categories count should be '4'");
    }
}
