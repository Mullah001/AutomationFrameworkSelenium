package main.ApiConfigs.Body;

import org.json.simple.JSONValue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static main.data.API.MoviesListingData.*;


public class MoviesListingBODY {
    static Map<String, Object> map = new HashMap<>();

    /******** Fetch Trending Events Category Wise ********/

    public static String FetchTrendingEventsCat_Body(){
        map.put("paginate",paginate);
        map.put("page",page);
        map.put("pageSize",pageSize);
        map.put("categories", Arrays.asList(categories));

        return JSONValue.toJSONString(map);
    }

    public static String FetchTrendingEventsCat_Body_InValid_Pagination(){
        map.put("paginate",inValidPaginate);
        map.put("page",page);
        map.put("pageSize",pageSize);
        map.put("categories", Arrays.asList(categories));

        return JSONValue.toJSONString(map);
    }

    public static String FetchTrendingEventsCat_Body_InValid_Cat(){
        Map<String, String> map = new HashMap<>();

        map.put("paginate",paginate);
        map.put("page",page);
        map.put("pageSize",pageSize);
        map.put("categories", inValidCategories);

        return JSONValue.toJSONString(map);
    }

    public static String FetchTrendingEventsCat_Body_Empty_Pagination(){
        map.put("paginate",emptyPaginate);
        map.put("page",page);
        map.put("pageSize",pageSize);
        map.put("categories", Arrays.asList(categories));

        return JSONValue.toJSONString(map);
    }

    public static String FetchTrendingEventsCat_Body_Empty_Cat(){
        map.put("paginate",paginate);
        map.put("page",page);
        map.put("pageSize",pageSize);
        map.put("categories", Arrays.asList(emptyCategories));

        return JSONValue.toJSONString(map);
    }
}
