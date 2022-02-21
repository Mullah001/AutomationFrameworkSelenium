package main.utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.ApiConfigs.Body.LogInBODY;
import main.ApiConfigs.Body.ParentEventsListingBODY;
import main.ApiConfigs.Params.CategoriesPARAMS;
import org.joda.time.DateTime;

import java.util.ArrayList;

import static main.ApiConfigs.EndPoints.CategoriesEP.*;
import static main.ApiConfigs.EndPoints.LogInEP.loginEP_Admin;
import static main.ApiConfigs.EndPoints.ParentEventsListingEP.*;
import static main.ApiConfigs.EndPoints.SubCategoriesEP.getAllSubCategoriesEP;
import static main.data.API.SubCategoriesData.moviesId;
import static main.utils.Constants.*;
import static main.utils.Constants.appJson;

public class API_DataMethods {

    /********** All Categories - HomePage - API *********/

    private Response getResponse_AllCategories() {
        String token = CategoriesPARAMS.fetchAllCategories_Valid();

        return RestAssured.given()
                .contentType(textPlain)
                .and()
                .header(xAuth, token)
                .when()
                .get(fetchAllCategoriesEP)
                .then()
                .extract().response();
    }

    public ArrayList getCategoryNames_AllCategories() {
        Response response = getResponse_AllCategories();

        return response.jsonPath().get("data.title");
    }

    public ArrayList getCategories_StartTime_AllCategories() {
        Response response = getResponseForParentEventsForConsumers_TopEvents();

        ArrayList data = response.jsonPath().get("data.startDateTime");
        ArrayList newData = new ArrayList();

        for (int i = 0; i < data.size(); i++) {
            String dataChanged = data.get(i).toString().split("T")[0];
            String[] dataArray = dataChanged.split("-");
            dataChanged = dataArray[2] + "/" + dataArray[1] + "/" + dataArray[0];
            newData.add(dataChanged);
        }

        return newData;
    }

    public ArrayList getSubCategoryNames_AllCategories(String category) {
        int catIndex = findIndexOfCategoryByTitle_AllCategories(category);
        Response response = getResponse_AllCategories();
        ArrayList data = response.jsonPath().get("data[" + catIndex + "].children.title");

        return data;
    }

    public String getCategoryByTitle_AllCategories(String title) {
        ArrayList categoryNames = getCategoryNames_AllCategories();
        String el = "";

        for (Object element :
                categoryNames) {
            if (element.toString().contains(title)) {
                el = element.toString();
            }
        }

        return el;
    }

    public int findIndexOfCategoryByTitle_AllCategories(String title) {
        ArrayList categoryNames = getCategoryNames_AllCategories();
        int elIndex = 0;

        for (int i = 0; i < categoryNames.size(); i++) {
            if (categoryNames.get(i).toString().equals(title)) {
                elIndex = i;
            }
        }

        return elIndex;
    }

    public String getCategoryByIndex_AllCategories(int index) {
        ArrayList categoryNames = getCategoryNames_AllCategories();

        return categoryNames.get(index).toString();
    }

    /************* Sub Categories - Movies - API *************/

    private Response getResponse_AllSubCategories_Movies() {
        String EP = getAllSubCategoriesEP + moviesId;

        return RestAssured.given()
                .contentType(appJson)
                .when()
                .get(EP)
                .then()
                .extract().response();
    }

    public ArrayList getTitles_Movies_AllSubCategories() {
        Response response = getResponse_AllSubCategories_Movies();

        ArrayList data = response.jsonPath().get("data.children.title");

        return data;
    }

    public ArrayList getIDs_Movies_AllSubCategories() {
        Response response = getResponse_AllSubCategories_Movies();

        ArrayList data = response.jsonPath().get("data.children._id");

        return data;
    }

    public int getChildrenCount_Movies_AllSubCategories() {
        Response response = getResponse_AllSubCategories_Movies();

        ArrayList children = response.jsonPath().get("data.children");

        return children.size();
    }

    public String getCategoryID_Movies_AllSubCategories(String title) {
        ArrayList subCatIDs = getIDs_Movies_AllSubCategories();

        ArrayList subCatNames = getTitles_Movies_AllSubCategories();

        for (int i = 0; i < subCatNames.size(); i++) {
            if (subCatNames.get(i).toString().equals(title)) {
                return subCatIDs.get(i).toString();
            }
        }
        return "No ID";
    }

    public String getCityName_Movies_AllSubCategories(String title) {

        ArrayList subCatNames = getTitles_Movies_AllSubCategories();

        for (int i = 0; i < subCatNames.size(); i++) {
            if (subCatNames.get(i).toString().equals(title)) {
                return subCatNames.get(i).toString();
            }
        }
        return "No City Name";
    }

    /*********** Top Movies - Movies - API **************/

    private Response getResponseForParentEventsForConsumers_TopMovies() {
        ParentEventsListingBODY parentEventsListingBODY = new ParentEventsListingBODY();
        String body = parentEventsListingBODY.fetchParentEventsConsumers_Body_Web_TopMovies();

        Response response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchParentEventsForConsumerEP)
                .then()
                .extract().response();

        //System.out.println(response.prettyPrint());
        return response;
    }

    public int getMoviesCount_TopMovies() {
        Response response = getResponseForParentEventsForConsumers_TopMovies();

        ArrayList data = response.jsonPath().get("data");

        return data.size();
    }

    public String getFirstMovieName_TopMovies() {
        Response response = getResponseForParentEventsForConsumers_TopMovies();

        ArrayList data = response.jsonPath().get("data.title");

        return data.get(0).toString();
    }

    /*********** Trending Movies - Movies - API *********/

    private Response getResponseForParentEventsForConsumers_TrendingMovies() {
        ParentEventsListingBODY parentEventsListingBODY = new ParentEventsListingBODY();
        String body = parentEventsListingBODY.fetchTrendingEvents_Body_TrendingMovies();

        Response response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchTrendingEventsEP)
                .then()
                .extract().response();

        //System.out.println(response.prettyPrint());
        return response;
    }

    public int getMoviesCount_TrendingMovies() {
        Response response = getResponseForParentEventsForConsumers_TrendingMovies();

        ArrayList data = response.jsonPath().get("data");

        return data.size();
    }

    public String getFirstMovieName_TrendingMovies() {
        Response response = getResponseForParentEventsForConsumers_TrendingMovies();

        ArrayList data = response.jsonPath().get("data.title");

        return data.get(0).toString();
    }

    /********** Top Events - HomePage - API *********/

    private Response getResponseForParentEventsForConsumers_TopEvents() {
        ParentEventsListingBODY parentEventsListingBODY = new ParentEventsListingBODY();
        String body = parentEventsListingBODY.fetchParentEventsConsumers_Body_Web_TopEvents();

        Response response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchParentEventsForConsumerEP)
                .then()
                .extract().response();

        //System.out.println(response.prettyPrint());
        return response;
    }

    public ArrayList getEventsTitle_TopEvent() {
        Response response = getResponseForParentEventsForConsumers_TopEvents();

        ArrayList data = response.jsonPath().get("data.title");

        return data;
    }

    public ArrayList getCategories_Title_TopEvent() {
        Response response = getResponseForParentEventsForConsumers_TopEvents();

        ArrayList data = response.jsonPath().get("data.categories.title");

        return data;
    }

    public int findIndexOfCategoryByTitle_TopEvent(String title) {
        ArrayList categoryNames = getEventsTitle_TopEvent();
        int elIndex = 0;

        for (int i = 0; i < categoryNames.size(); i++) {
            if (categoryNames.get(i).toString().equals(title)) {
                elIndex = i;
            }
        }

        return elIndex;
    }

    /********** Events for Category - Movies - API *********/

    private Response getResponseForParentEventsForConsumers_Movies_Categories(String title) {
        String categoryID = getCategoryID_Movies_AllSubCategories(title);

        String[] categoryIDs = {categoryID};

        ParentEventsListingBODY parentEventsListingBODY = new ParentEventsListingBODY();

        String body = parentEventsListingBODY.fetchParentEventsConsumers_Body_Web_Category(categoryIDs);

        Response response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchParentEventsForConsumerEP)
                .then()
                .extract().response();

        //System.out.println(response.prettyPrint());
        return response;
    }

    public int getEventsCountByCategory_Movies(String title) {
        Response response = getResponseForParentEventsForConsumers_Movies_Categories(title);

        return response.jsonPath().get("totalDocs");
    }

    private Response getResponseForParentEventsForConsumers_Movies_Cities(String title) {
        String cityName = getCityName_Movies_AllSubCategories(title);

        String[] cityNames = {cityName};

        ParentEventsListingBODY parentEventsListingBODY = new ParentEventsListingBODY();

        String body = parentEventsListingBODY.fetchParentEventsConsumers_Body_Web_City(cityNames);

        Response response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchParentEventsForConsumerEP)
                .then()
                .extract().response();

        //System.out.println(response.prettyPrint());
        return response;
    }

    public int getEventsCountByCity_Movies(String title) {
        Response response = getResponseForParentEventsForConsumers_Movies_Cities(title);

        return response.jsonPath().get("totalDocs");
    }

    private Response getResponseForParentEventsConsumers_Movies_Search(String searchText) {
        ParentEventsListingBODY parentEventsListingBODY = new ParentEventsListingBODY();

        String body = parentEventsListingBODY.fetchParentEventsConsumers_Body_Web_Search(searchText);

        return RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchParentEventsForConsumerEP)
                .then()
                .extract().response();
    }

    public int getEventsCountBySearchText_Movies(String searchText) {
        Response response = getResponseForParentEventsConsumers_Movies_Search(searchText);

        return response.jsonPath().get("totalDocs");
    }

    /********* UpComing Movies - Movies - API ************/

    private Response getResponseForParentEventsForConsumers_UpComingMovies() {
        ParentEventsListingBODY parentEventsListingBODY = new ParentEventsListingBODY();
        String body = parentEventsListingBODY.fetchParentEventsConsumers_Body_Web_UpComingMovies();

        Response response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchParentEventsForConsumerEP)
                .then().extract().response();

        return response;
    }

    public int getMoviesCount_UpComingMovies() {
        Response response = getResponseForParentEventsForConsumers_UpComingMovies();

        ArrayList data = response.jsonPath().get("data");

        return data.size();
    }

    public String getFirstMovieName_UpComingMovies() {
        Response response = getResponseForParentEventsForConsumers_UpComingMovies();

        ArrayList data = response.jsonPath().get("data.title");

        return data.get(0).toString();
    }

    /********* Showing in Cinemas Movies - Movies - API ************/

    private Response getResponseForParentEventsForConsumers_ShowingInCinemasMovies() {
        ParentEventsListingBODY parentEventsListingBODY = new ParentEventsListingBODY();
        String body = parentEventsListingBODY.fetchParentEventsConsumers_Body_Web_ShowingInCinemasMovies();

        Response response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchParentEventsForConsumerEP)
                .then().extract().response();

        return response;
    }

    public int getMoviesCount_ShowingInCinemasMovies() {
        Response response = getResponseForParentEventsForConsumers_ShowingInCinemasMovies();

        ArrayList data = response.jsonPath().get("data");

        return data.size();
    }

    public String getFirstMovieName_ShowingInCinemasMovies() {
        Response response = getResponseForParentEventsForConsumers_ShowingInCinemasMovies();

        ArrayList data = response.jsonPath().get("data.title");

        return data.get(0).toString();
    }

    /********** UpComing Events - HomePage - API *********/

    private Response getResponseForParentEventsForConsumers_UpComingEvents() {
        ParentEventsListingBODY parentEventsListingBODY = new ParentEventsListingBODY();
        String body = parentEventsListingBODY.fetchParentEventsConsumers_Body_Web_UpComingEvents();

        Response response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchParentEventsForConsumerEP)
                .then()
                .extract().response();

        //System.out.println(response.prettyPrint());
        return response;
    }

    public ArrayList getEvents_Title_UpComingEvents() {
        Response response = getResponseForParentEventsForConsumers_UpComingEvents();

        ArrayList data = response.jsonPath().get("data.title");

        return data;
    }

    public ArrayList getEvents_Currency_UpComingEvents() {
        Response response = getResponseForParentEventsForConsumers_UpComingEvents();

        ArrayList data = response.jsonPath().get("data.currency");

        return data;
    }

    public ArrayList getEvents_Description_UpComingEvents() {
        Response response = getResponseForParentEventsForConsumers_UpComingEvents();

        ArrayList data = response.jsonPath().get("data.description");

        return data;
    }

    public ArrayList getEvents_VenuesName_UpComingEvents() {
        Response response = getResponseForParentEventsForConsumers_UpComingEvents();

        ArrayList data = response.jsonPath().get("data.venues.name");

        return data;
    }

    public ArrayList getEvents_eventMaximumTicketClassPrice_UpComingEvents() {
        Response response = getResponseForParentEventsForConsumers_UpComingEvents();

        ArrayList data = response.jsonPath().get("data.eventMaximumTicketClassPrice");

        return data;
    }

    public ArrayList getEvents_eventMinimumTicketClassPrice_UpComingEvents() {
        Response response = getResponseForParentEventsForConsumers_UpComingEvents();

        ArrayList data = response.jsonPath().get("data.eventMinimumTicketClassPrice");

        return data;
    }

    public ArrayList getEvents_Date_UpComingEvents() {
        Response response = getResponseForParentEventsForConsumers_UpComingEvents();

        ArrayList startDateTime = response.jsonPath().get("data.startDateTime");
        ArrayList endDateTime = response.jsonPath().get("data.endDateTime");

        ArrayList newData = new ArrayList();

        for (int i = 0; i < startDateTime.size(); i++) {

            DateTime startDateTime_parsedTime = DateTime.parse(startDateTime.get(i).toString());
            DateTime endDateTime_parsedTime = DateTime.parse(endDateTime.get(i).toString());
            String date = startDateTime_parsedTime.toString("EEE") + "," + startDateTime_parsedTime.toString("dd") + " " + startDateTime_parsedTime.toString("MMM")
                    + " to " +
                    endDateTime_parsedTime.toString("EEE") + "," + endDateTime_parsedTime.toString("dd") + " " + endDateTime_parsedTime.toString("MMM") + " " + endDateTime_parsedTime.toString("yyyy") + " - ";

            newData.add(date);
        }

        return newData;
    }

    public void SampleCallAPI_Data() {
        ArrayList eventsTitle = getEvents_Date_UpComingEvents();

        for (int i = 0; i < eventsTitle.size(); i++) {
            System.out.println("Events Venue Name: " + eventsTitle.get(i));
        }
    }

    /***************** List of Organizations - ADMIN - Events - API *****************/

    private Response getResponseForListOfOrganizations() {
        Response response = RestAssured.given()
                .contentType(appJson)
                .when()
                .get(listOfOrganizationsEP)
                .then().extract().response();

        return response;
    }

    public int getOrganizationsCount() {
        Response response = getResponseForListOfOrganizations();

        ArrayList organizations = response.jsonPath().get("data");

        return organizations.size();
    }

    /************ Fetch All Parent Categories - ADMIN - Events - API *************/

    private Response getResponseForFetchAllParentCategories() {
        Response response = RestAssured.given()
                .contentType(appJson)
                .when()
                .get(fetchAllParentCategoriesEP)
                .then().extract().response();

        return response;
    }

    public int getAllParentCategoriesCount() {
        Response response = getResponseForFetchAllParentCategories();

        ArrayList parentCategories = response.jsonPath().get("data");

        return parentCategories.size();
    }

    /********** Get Auth Token - Admin - API ***********/

    public String getAuthToken_Admin() {
        String body = LogInBODY.logIn_Body_Admin();
        PropertyFilesReader propertyFilesReader = new PropertyFilesReader();

        if (RestAssured.baseURI == null || RestAssured.baseURI.isEmpty())
            RestAssured.baseURI = propertyFilesReader.getServerURlProp();

        Response response = RestAssured.given()
                .contentType(appJson)
                .body(body)
                .post(loginEP_Admin);

        return response.body().jsonPath().get(xAuth).toString();
    }

    /************ Fetch Parent Events - Admin - API *********/

    private Response getResponseForParentEvents_Admin() {
        String body = ParentEventsListingBODY.fetchParentEvents_Body();

        RequestSpecification requestSpec;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader(xAuth, getAuthToken_Admin());
        requestSpec = builder.build();
        RestAssured.requestSpecification = requestSpec;

        Response response = RestAssured.given()
                .contentType(appJson)
                .and()
                .body(body)
                .when()
                .post(fetchParentEventsEP)
                .then()
                .extract().response();

        //System.out.println(response.prettyPrint());
        return response;
    }

    public int getTotalParentEventsCount_Admin() {
        Response response = getResponseForParentEvents_Admin();

        return response.jsonPath().get("totalDocs");
    }

    public int getTotalPagesParentEventsCount_Admin() {
        Response response = getResponseForParentEvents_Admin();

        return response.jsonPath().get("totalPages");
    }
}