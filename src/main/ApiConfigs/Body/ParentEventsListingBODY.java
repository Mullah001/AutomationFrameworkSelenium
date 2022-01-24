package main.ApiConfigs.Body;

import org.json.simple.JSONValue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static main.data.API.ParentEventsListingData.*;

public class ParentEventsListingBODY {

    static Map<String, Object> map = new HashMap<>();

    /******** Fetch Parent Events For Consumers ********/

    public static String fetchParentEventsConsumers_Body() {


        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("upcoming", Boolean.valueOf(upcoming));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize));


        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_InValid_Paginate() {

        map.put("country", country);
        map.put("isFeatured", isFeatured_true);
        map.put("upcoming", upcoming);
        map.put("paginate", inValidPaginate);
        map.put("page", page);
        map.put("pageSize", pageSize);


        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_InValid_Country() {

        map.put("country", inValidCountry);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("upcoming", Boolean.valueOf(upcoming));
        map.put("paginate", Boolean.valueOf(inValidPaginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize));


        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_Empty_Paginate() {

        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("upcoming", Boolean.valueOf(upcoming));
        map.put("paginate", emptyPaginate);
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize));


        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_Empty_Country() {

        map.put("country", emptyCountry);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("upcoming", Boolean.valueOf(upcoming));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize));


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

    public static String fetchParentEventsConsumers_Body_Web_UpComingEvents() {

        map.put("country", countryPakistan);
        map.put("categories", Arrays.asList(categories));
        map.put("isFeatured", Boolean.valueOf(isFeatured_false));
        map.put("isDraft", Boolean.valueOf(isDraft_false));
        map.put("isPublished", Boolean.valueOf(isPublished));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSizeWeb_20));


        return JSONValue.toJSONString(map);
    }

    /******** Fetch Trending Events ********/

    public static String fetchTrendingEvents_Body() {


        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize));


        return JSONValue.toJSONString(map);
    }

    public static String fetchTrendingEvents_Body_InValid_Paginate() {

        map.put("country", country);
        map.put("isFeatured", isFeatured_true);
        map.put("paginate", inValidPaginate);
        map.put("page", page);
        map.put("pageSize", pageSize);


        return JSONValue.toJSONString(map);
    }

    public static String fetchTrendingEvents_Body_InValid_Country() {

        map.put("country", inValidCountry);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("paginate", Boolean.valueOf(inValidPaginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize));


        return JSONValue.toJSONString(map);
    }

    public static String fetchTrendingEvents_Body_Empty_Paginate() {

        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("paginate", emptyPaginate);
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize));


        return JSONValue.toJSONString(map);
    }

    public static String fetchTrendingEvents_Body_Empty_Country() {

        map.put("country", emptyCountry);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize));


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
        map.put("pageSize", new Integer(pageSize));


        return JSONValue.toJSONString(map);
    }

    public static String fetchNearbyParentEventsConsumers_Body_InValid_Latitude() {


        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("latitude", inValidLatitude);
        map.put("longitude", new Float(longitude));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize));


        return JSONValue.toJSONString(map);
    }

    public static String fetchNearbyParentEventsConsumers_Body_InValid_Longitude() {


        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("latitude", new Float(latitude));
        map.put("longitude", inValidLongitude);
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize));


        return JSONValue.toJSONString(map);
    }

    public static String fetchNearbyParentEventsConsumers_Body_InValid_Paginate() {

        map.put("country", country);
        map.put("isFeatured", isFeatured_true);
        map.put("latitude", new Float(latitude));
        map.put("longitude", new Float(longitude));
        map.put("paginate", inValidPaginate);
        map.put("page", page);
        map.put("pageSize", pageSize);


        return JSONValue.toJSONString(map);
    }

    public static String fetchNearbyParentEventsConsumers_Body_InValid_Country() {

        map.put("country", inValidCountry);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("latitude", new Float(latitude));
        map.put("longitude", new Float(longitude));
        map.put("paginate", Boolean.valueOf(inValidPaginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize));


        return JSONValue.toJSONString(map);
    }

    public static String fetchNearbyParentEventsConsumers_Body_Empty_Paginate() {

        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("latitude", new Float(latitude));
        map.put("longitude", new Float(longitude));
        map.put("paginate", emptyPaginate);
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize));


        return JSONValue.toJSONString(map);
    }

    public static String fetchNearbyParentEventsConsumers_Body_Empty_Country() {

        map.put("country", emptyCountry);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("latitude", new Float(latitude));
        map.put("longitude", new Float(longitude));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize));


        return JSONValue.toJSONString(map);
    }

    public static String fetchNearbyParentEventsConsumers_Body_Empty_Latitude() {

        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("latitude", emptyLatitude);
        map.put("longitude", new Float(longitude));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize));


        return JSONValue.toJSONString(map);
    }

    public static String fetchNearbyParentEventsConsumers_Body_Empty_Longitude() {

        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured_true));
        map.put("latitude", new Float(latitude));
        map.put("longitude", emptyLongitude);
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize));


        return JSONValue.toJSONString(map);
    }

}
