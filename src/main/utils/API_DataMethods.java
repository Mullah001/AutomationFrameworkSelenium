package main.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import main.ApiConfigs.Body.ParentEventsListingBODY;
import main.ApiConfigs.Params.CategoriesPARAMS;
import org.joda.time.DateTime;

import java.util.ArrayList;

import static main.ApiConfigs.EndPoints.CategoriesEP.fetchAllCategoriesEP;
import static main.ApiConfigs.EndPoints.ParentEventsListingEP.fetchParentEventsForConsumerEP;
import static main.utils.Constants.*;
import static main.utils.Constants.appJson;

public class API_DataMethods {

    /********** All Categories - HomePage - API *********/

    public Response getResponse_AllCategories() {
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

        ArrayList data = response.jsonPath().get("data.title");

        return data;
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

    /********** Top Events - HomePage - API *********/

    public Response getResponseForParentEventsForConsumers_TopEvents() {
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

    /********** UpComing Events - HomePage - API *********/

    public Response getResponseForParentEventsForConsumers_UpComingEvents() {
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

    public ArrayList getEvents_Title_UpComingEvents() {
        Response response = getResponseForParentEventsForConsumers_TopEvents();

        ArrayList data = response.jsonPath().get("data.title");

        return data;
    }

    public ArrayList getEvents_Currency_UpComingEvents() {
        Response response = getResponseForParentEventsForConsumers_TopEvents();

        ArrayList data = response.jsonPath().get("data.currency");

        return data;
    }

    public ArrayList getEvents_Description_UpComingEvents() {
        Response response = getResponseForParentEventsForConsumers_TopEvents();

        ArrayList data = response.jsonPath().get("data.description");

        return data;
    }

    public ArrayList getEvents_VenuesName_UpComingEvents() {
        Response response = getResponseForParentEventsForConsumers_TopEvents();

        ArrayList data = response.jsonPath().get("data.venues.name");

        return data;
    }

    public ArrayList getEvents_eventMaximumTicketClassPrice_UpComingEvents() {
        Response response = getResponseForParentEventsForConsumers_TopEvents();

        ArrayList data = response.jsonPath().get("data.eventMaximumTicketClassPrice");

        return data;
    }

    public ArrayList getEvents_eventMinimumTicketClassPrice_UpComingEvents() {
        Response response = getResponseForParentEventsForConsumers_TopEvents();

        ArrayList data = response.jsonPath().get("data.eventMinimumTicketClassPrice");

        return data;
    }

    public ArrayList getEvents_Data_UpComingEvents() {
        Response response = getResponseForParentEventsForConsumers_TopEvents();

        ArrayList startDateTime = response.jsonPath().get("data.startDateTime");
        ArrayList endDateTime = response.jsonPath().get("data.endDateTime");

        ArrayList newData = new ArrayList();

        for (int i = 0; i < startDateTime.size(); i++) {

            DateTime startDateTime_parsedTime = DateTime.parse(startDateTime.get(i).toString());
            DateTime endDateTime_parsedTime = DateTime.parse(endDateTime.get(i).toString());
            String date = startDateTime_parsedTime.toString("EEE") + "," + startDateTime_parsedTime.toString("dd") + " " + startDateTime_parsedTime.toString("MMM")
                    + " to " +
                    endDateTime_parsedTime.toString("EEE") + "," + endDateTime_parsedTime.toString("dd") + " " + endDateTime_parsedTime.toString("MMM");

            newData.add(date);
        }

        return newData;
    }

    public void SampleCallAPI_Data(){
        ArrayList eventsTitle = getEvents_Data_UpComingEvents();

        for (int i = 0; i < eventsTitle.size(); i++) {
            System.out.println("Events Venue Name: " + eventsTitle.get(i));
        }
    }
}
