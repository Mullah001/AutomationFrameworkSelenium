package main.ApiConfigs.Body;

import main.utils.CommonMethods;
import org.json.simple.JSONValue;

import java.util.HashMap;
import java.util.Map;

import static main.data.API.RegistrationData.*;

public class RegistrationBODY {

    static Map<String, String> map = new HashMap<>();

    public static String RegistrationVerify_Body(boolean isNew) {
        String email = validEmail;
        String phoneNumber = validPhoneNumber;
        if (isNew){
            email = CommonMethods.generateRandomEmail();
            phoneNumber = CommonMethods.generateRandomPhoneNumber();
        }
        map.put("email", email);
        map.put("phoneNumber", phoneNumber);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }

    public static String RegistrationVerify_Invalid_Body() {
        map.put("email", invalidEmail);
        map.put("phoneNumber", invalidPhoneNumber);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }

    public static String RegistrationVerify_Empty_Body() {
        map.put("email", emptyEmail);
        map.put("phoneNumber", emptyPhoneNumber);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }

    public static String Register_Body() {
        map.put("name", validName);
        map.put("password", validPassword);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }

    public static String Register_InValid_Body() {
        map.put("name", inValidName);
        map.put("password", inValidPassword);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }

    public static String Register_Empty_Body() {
        map.put("name", emptyName);
        map.put("password", emptyPassword);

        String jsonText = JSONValue.toJSONString(map);
        return jsonText;
    }
}
