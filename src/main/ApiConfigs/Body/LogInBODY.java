package main.ApiConfigs.Body;


import org.json.simple.JSONValue;

import java.util.HashMap;
import java.util.Map;

import static main.data.LogInData.*;

public class LogInBODY {

    static Map<String, String> map = new HashMap<>();

    public static String logIn_Body(){
        map.put("email",email);
        map.put("password",password);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }

    public static String logInWithGoogle_Body(){
        map.put("token",token);
        map.put("CLIENT_ID",CLIENT_ID);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }

    public static String reSavePassword_Body(){
        map.put("resetToken",resetToken);
        map.put("new_password",new_password);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }

}
