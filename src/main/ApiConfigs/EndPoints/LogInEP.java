package main.ApiConfigs.EndPoints;

public interface LogInEP {

    /************ Consumer ***************/

    String loginEP = "/api/v1/consumers/login";

    String logInWithGoogleEP = "/api/v1/consumers/login-with-google";

    String forgotPasswordEP = "/api/v1/consumers/forgot-password/";

    String resavePasswordEP = "/api/v1/consumers/resave-password";

    /****************** Admin ******************/

    String loginEP_Admin = "/api/v1/admins/login";
}
