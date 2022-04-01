package main.utils;

public interface Constants {
    String WebBaseUrl = "https://qa.ticketlake.com/";
String adminBaseUrl = "https://admin.qa.ticketlake.com/";
    //String adminBaseUrl = "https://swvl.com/travel";

    //How Many times we will retry if Test fails
    int retryCount = 0;

    String environment = "QA_Environment";
    String serverURL = "ServerURL";
    String username = "username";
    String password = "password";
    String email = "email";
    String paypalUserName_sb = "paypalUserName_sb";
    String paypalPassword_sb = "paypalPassword_sb";

    /* ContentTypes */
    String appJson = "application/json";
    String textPlain = "text/plain";

    /* Auth Types */
    String xAuth = "X-Auth";

    String yesText = "Yes";
    String noText = "No";

    /*  */
//    String browser = "chrome";
//    boolean headless = false;
//    String platform = "WEB";
}