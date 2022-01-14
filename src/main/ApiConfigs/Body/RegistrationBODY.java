package main.ApiConfigs.Body;

import org.json.simple.JSONValue;

import java.util.HashMap;
import java.util.Map;

import static main.data.RegistrationData.email;
import static main.data.RegistrationData.phoneNumber;

public class RegistrationBODY {

    static Map<String, String> map = new HashMap<>();

    public static String RegistrationVerify_Body(){
        map.put("email",email);
        map.put("phoneNumber",phoneNumber);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }
}
