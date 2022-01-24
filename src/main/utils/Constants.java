package main.utils;

public interface Constants {
    String baseUrl = "https://qa.ticketlake.com/";

    //How Many times we will retry if Test fails
    int retryCount = 0;

    String environment = "QA_Environment";
    String serverURL = "ServerURL";
    String username = "username";
    String password = "password";

    /* ContentTypes */
    String appJson = "application/json";

    /* Auth Types */
    String xAuth = "X-Auth";
}