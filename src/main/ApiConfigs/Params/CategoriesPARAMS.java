package main.ApiConfigs.Params;

import main.utils.CommonMethods;
import org.json.simple.JSONValue;

import java.util.HashMap;
import java.util.Map;

import static main.data.API.CategoriesData.*;
import static main.utils.Constants.xAuth;

public class CategoriesPARAMS {

    static Map<String, String> map = new HashMap<>();

    /******** Categories ********/

    public static String fetchAllCategories_Valid(){
        map.put(xAuth, validToken);

        return JSONValue.toJSONString(map);
    }

    public static String fetchAllCategories_InValid(){
        map.put(xAuth, inValidToken);

        return JSONValue.toJSONString(map);
    }

    public static String fetchAllCategories_Empty(){
        map.put(xAuth, emptyToken);

        return JSONValue.toJSONString(map);
    }
}
