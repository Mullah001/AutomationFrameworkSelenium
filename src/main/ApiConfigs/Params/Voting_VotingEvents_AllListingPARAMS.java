package main.ApiConfigs.Params;


import java.util.HashMap;
import java.util.Map;

public interface Voting_VotingEvents_AllListingPARAMS {
    Map<String, String> map = new HashMap<>();

    static Map<String, String> params(){
        map.put("limit", "5");
        map.put("sortBy", "_id");
        map.put("sortOrder", "1");

        return map;
    }

}
