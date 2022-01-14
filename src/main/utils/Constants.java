package main.utils;

public interface Constants {
    String baseUrl = "http://127.0.0.1:5501/index.html";

    //How Many times we will retry if Test fails
    int retryCount = 2;

    String environment = "QA_Environment";
    String serverURL = "ServerURL";
    String username = "username";
    String password = "password";

    /* ContentTypes */
    String appJson = "application/json";

    /* Auth Types */
    String xAuth = "X-Auth";
}