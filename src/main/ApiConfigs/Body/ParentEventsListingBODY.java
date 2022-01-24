package main.ApiConfigs.Body;

import org.json.simple.JSONValue;

import java.util.HashMap;
import java.util.Map;

import static main.data.API.ParentEventsListingData.*;

public class ParentEventsListingBODY {

    static Map<String, Object> map = new HashMap<>();

    /******** Fetch Parent Events For Consumers ********/

    public static String fetchParentEventsConsumers_Body() {


        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured));
        map.put("upcoming", Boolean.valueOf(upcoming));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize));


        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_InValid_Paginate() {

        map.put("country", country);
        map.put("isFeatured", isFeatured);
        map.put("upcoming", upcoming);
        map.put("paginate", inValidPaginate);
        map.put("page", page);
        map.put("pageSize", pageSize);


        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_InValid_Country() {

        map.put("country", inValidCountry);
        map.put("isFeatured", Boolean.valueOf(isFeatured));
        map.put("upcoming", Boolean.valueOf(upcoming));
        map.put("paginate", Boolean.valueOf(inValidPaginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize));


        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_Empty_Paginate() {

        map.put("country", country);
        map.put("isFeatured", Boolean.valueOf(isFeatured));
        map.put("upcoming", Boolean.valueOf(upcoming));
        map.put("paginate", emptyPaginate);
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize));


        return JSONValue.toJSONString(map);
    }

    public static String fetchParentEventsConsumers_Body_Empty_Country() {

        map.put("country", emptyCountry);
        map.put("isFeatured", Boolean.valueOf(isFeatured));
        map.put("upcoming", Boolean.valueOf(upcoming));
        map.put("paginate", Boolean.valueOf(paginate));
        map.put("page", page);
        map.put("pageSize", new Integer(pageSize));


        return JSONValue.toJSONString(map);
    }
}
