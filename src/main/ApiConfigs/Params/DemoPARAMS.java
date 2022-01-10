package main.ApiConfigs.Params;

import java.util.HashMap;
import java.util.Map;

public interface DemoPARAMS {
    Map<String, String> map = new HashMap<>();

    static Map<String, String> params(){
        map.put("page", "2");

        return map;
    }
}
