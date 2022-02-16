package main.ApiConfigs.Body;

import org.json.simple.JSONValue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static main.data.API.ParentEventsListingData.*;

public class ParentEventsListingBODY {

    static Map<String, Object> map = new HashMap<>();

    /********** Fetch Parent Events ************/

    public static String fetchParentEvents_Body() {

        map.put("isFeatured", Boolean.valueOf(isFeatured_false));
        map.put("isPermission", Boolean.valueOf(isPermission_false));
        map.put("isPublished", Boolean.valueOf(isPublished_false));
        map.put("organizationId", organizationId_all);
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("type", type_all);
        map.put("pageSize", new Integer(pageSize_15));


        return JSONValue.toJSONString(map);
    }

    /******** Fetch Parent Events For Consumers ********/

    public static String fetchParentEventsConsumers_Body() {


        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("upcoming", Boolean.valueOf(upcoming));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize_5));


        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_InValid_Paginate() {

        map.put("country", country);
        map.put("isFeatured", isFeatured_true);
        map.put("upcoming", upcoming);
        map.put("paginate", inValidPaginate);
        map.put("page", page);
        map.put("pageSize", pageSize_5);


        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_InValid_Country() {

        map.put("country", inValidCountry);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("upcoming", Boolean.valueOf(upcoming));
        map.put("paginate", Boolean.valueOf(inValidPaginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize_5));


        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_Empty_Paginate() {

        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("upcoming", Boolean.valueOf(upcoming));
        map.put("paginate", emptyPaginate);
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize_5));


        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_Empty_Country() {

        map.put("country", emptyCountry);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("upcoming", Boolean.valueOf(upcoming));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize_5));


        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_Web_TopEvents() {

        map.put("country", countryPakistan);
        map.put("categories", Arrays.asList(categories));
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("isDraft", Boolean.valueOf(isDraft_false));
        map.put("isPublished", Boolean.valueOf(isPublished));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSizeWeb_6));


        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_Web_TopMovies() {

        map.put("country", countryPakistan);
        map.put("categories", Arrays.asList(moviesCategoryID));
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        //map.put("isDraft", Boolean.valueOf(isDraft_false));
        map.put("isPublished", Boolean.valueOf(isPublished));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSizeWeb_6));


        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_Web_Category(String[] categories) {

        map.put("country", countryPakistan);
        map.put("categories", Arrays.asList(categories));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);

        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_Web_City(String[] cities) {

        map.put("country", countryPakistan);
        map.put("categories", Arrays.asList("6174af3692a109001a9dc6bc"));
        map.put("cities", Arrays.asList(cities));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);

        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_Web_Search(String searchText) {

        map.put("country", countryPakistan);
        map.put("categories", Arrays.asList("6174af3692a109001a9dc6bc"));
        map.put("search", searchText);
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);

        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_Web_UpComingEvents() {

        map.put("country", countryPakistan);
        map.put("categories", Arrays.asList(categories));
       // map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("isDraft", Boolean.valueOf(isDraft_false));
        map.put("isPublished", Boolean.valueOf(isPublished));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSizeWeb_20));


        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_Web_UpComingMovies() {

        map.put("country", countryPakistan);
        map.put("categories", Arrays.asList(moviesCategoryID));
        map.put("upcoming", Boolean.valueOf(upcoming));
        map.put("isDraft", Boolean.valueOf(isDraft_false));
        map.put("isPublished", Boolean.valueOf(isPublished));
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSizeWeb_4));


        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_Web_ShowingInCinemasMovies() {

        map.put("country", countryPakistan);
        map.put("categories", Arrays.asList(moviesCategoryID));
        map.put("upcoming", Boolean.valueOf(upcoming_false));
        map.put("isDraft", Boolean.valueOf(isDraft_false));
        map.put("isPublished", Boolean.valueOf(isPublished));
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSizeWeb_4));


        return JSONValue.toJSONString(map);
    }

    /******** Fetch Trending Events ********/

    public static String fetchTrendingEvents_Body() {

        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize_5));

        return JSONValue.toJSONString(map);
    }

    public static String fetchTrendingEvents_Body_TrendingMovies() {

        map.put("country", countryPakistan);
        map.put("categories", Arrays.asList(moviesCategoryID));
        map.put("isPublished", Boolean.valueOf(isPublished));
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSizeWeb_4));

        return JSONValue.toJSONString(map);
    }

    public static String fetchTrendingEvents_Body_InValid_Paginate() {

        map.put("country", country);
        map.put("isFeatured", isFeatured_true);
        map.put("paginate", inValidPaginate);
        map.put("page", page);
        map.put("pageSize", pageSize_5);


        return JSONValue.toJSONString(map);
    }

    public static String fetchTrendingEvents_Body_InValid_Country() {

        map.put("country", inValidCountry);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("paginate", Boolean.valueOf(inValidPaginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize_5));


        return JSONValue.toJSONString(map);
    }

    public static String fetchTrendingEvents_Body_Empty_Paginate() {

        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("paginate", emptyPaginate);
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize_5));


        return JSONValue.toJSONString(map);
    }

    public static String fetchTrendingEvents_Body_Empty_Country() {

        map.put("country", emptyCountry);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize_5));


        return JSONValue.toJSONString(map);
    }

    /******** Fetch Nearby Parent Events For Consumers ********/

    public static String fetchNearbyParentEventsConsumers_Body() {


        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("latitude", new Float(latitude));
        map.put("longitude", new Float(longitude));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize_5));


        return JSONValue.toJSONString(map);
    }

    public static String fetchNearbyParentEventsConsumers_Body_InValid_Latitude() {


        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("latitude", inValidLatitude);
        map.put("longitude", new Float(longitude));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize_5));


        return JSONValue.toJSONString(map);
    }

    public static String fetchNearbyParentEventsConsumers_Body_InValid_Longitude() {


        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("latitude", new Float(latitude));
        map.put("longitude", inValidLongitude);
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize_5));


        return JSONValue.toJSONString(map);
    }

    public static String fetchNearbyParentEventsConsumers_Body_InValid_Paginate() {

        map.put("country", country);
        map.put("isFeatured", isFeatured_true);
        map.put("latitude", new Float(latitude));
        map.put("longitude", new Float(longitude));
        map.put("paginate", inValidPaginate);
        map.put("page", page);
        map.put("pageSize", pageSize_5);


        return JSONValue.toJSONString(map);
    }

    public static String fetchNearbyParentEventsConsumers_Body_InValid_Country() {

        map.put("country", inValidCountry);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("latitude", new Float(latitude));
        map.put("longitude", new Float(longitude));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize_5));


        return JSONValue.toJSONString(map);
    }

    public static String fetchNearbyParentEventsConsumers_Body_Empty_Paginate() {

        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("latitude", new Float(latitude));
        map.put("longitude", new Float(longitude));
        map.put("paginate", emptyPaginate);
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize_5));


        return JSONValue.toJSONString(map);
    }

    public static String fetchNearbyParentEventsConsumers_Body_Empty_Country() {

        map.put("country", emptyCountry);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("latitude", new Float(latitude));
        map.put("longitude", new Float(longitude));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize_5));


        return JSONValue.toJSONString(map);
    }

    public static String fetchNearbyParentEventsConsumers_Body_Empty_Latitude() {

        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("latitude", emptyLatitude);
        map.put("longitude", new Float(longitude));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize_5));


        return JSONValue.toJSONString(map);
    }

    public static String fetchNearbyParentEventsConsumers_Body_Empty_Longitude() {

        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("latitude", new Float(latitude));
        map.put("longitude", emptyLongitude);
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize_5));


        return JSONValue.toJSONString(map);
    }

}
