package main.ApiConfigs.Body;


import org.json.simple.JSONValue;

import java.util.HashMap;
import java.util.Map;

import static main.data.API.LogInData.*;

public class LogInBODY {

    static Map<String, String> map = new HashMap<>();

    /******** Log In - Consumer ********/

    public static String logIn_Body() {
        map.put("email", email);
        map.put("password", password);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }

    public static String logIn_Body_InValid_Email() {
        map.put("email", inValidEmail);
        map.put("password", password);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }

    public static String logIn_Body_InValid_Password() {
        map.put("email", email);
        map.put("password", inValidPassword);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }

    public static String logIn_Body_Empty() {
        map.put("email", emptyEmail);
        map.put("password", emptyPassword);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }

    /******** Log In with Google ********/

    public static String logInWithGoogle_Body() {
        map.put("token", token);
        map.put("CLIENT_ID", CLIENT_ID);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }

    /******** Resave Password ********/

    public static String reSavePassword_Body() {
        map.put("resetToken", resetToken);
        map.put("password", new_password);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }

    public static String reSavePassword_Body_InValid() {
        map.put("resetToken", inValidResetToken);
        map.put("password", new_password);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }

    public static String reSavePassword_Body_Empty_Token() {
        map.put("resetToken", emptyResetToken);
        map.put("password", new_password);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }

    public static String reSavePassword_Body_Empty_Password() {
        map.put("resetToken", resetToken);
        map.put("password", emptyPassword);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }

    /***************** Log In - Admin ******************/

    public static String logIn_Body_Admin() {
        map.put("username", userName_Admin);
        map.put("password", password_Admin);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }

}
