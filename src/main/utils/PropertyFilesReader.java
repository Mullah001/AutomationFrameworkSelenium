package main.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyFilesReader implements Constants {

    public static Map<String, String> keyVal = new HashMap<String, String>();
    FileReader reader;
    Properties properties = new Properties();

    public PropertyFilesReader() {
        initializeProperties();
    }

    public void initializeReader(String env) {
        try {
            reader = new FileReader(System.getProperty("user.dir") + "//Inputs//" + env + ".properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void initializeProperties() {
        initializeReader(environment);

        try {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getServerURlProp() {
        return properties.getProperty(serverURL);
    }

    public String getPaypalUserName_sb() {
        return properties.getProperty(paypalUserName_sb);
    }

    public String getPaypalPassword_sb() {
        return properties.getProperty(paypalPassword_sb);
    }

    public String getUserName() {
        return properties.getProperty(username);
    }

    public String getPass() {
        return properties.getProperty(password);
    }

    public String getEmail() {
        return properties.getProperty(email);
    }

    public String getUserCredentials() {

        String e_mail = getEmail();
        String pass = getPass();

        return "{\n" +
                "\t\"" + email + "\":\"" + e_mail + "\",\n" +
                "\t\"" + password + "\":\"" + pass + "\"\n" +
                "}";
    }

    public String getBrowser() {
        return properties.getProperty(browser);
    }

    public String getPlatform() {
        return properties.getProperty(platform);
    }

    public Boolean getHeadLess() {
        return Boolean.valueOf(properties.getProperty(headless));
    }

    public Boolean getIsAdmin() {
        return Boolean.valueOf(properties.getProperty(isAdmin));
    }
}
