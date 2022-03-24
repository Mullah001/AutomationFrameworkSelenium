package main.pageObjects.WEB;

public interface SocialLoginElements {

//    Google login


    String googleEmail = "//input[@type=\"email\"]";
    String nextEmail = "//span[contains(text(),\"Next\")]";
    String googlePassword = "//input[@type=\"password\"]";
    String nextPassword = "//span[contains(text(),\"Next\")]";

//    Facebook Login

    String createNewAccount = "//a[contains(text(), \"Create New Account\")]";
    String alreadyHaveAnAccount = "//a[contains(text(), \"Already have an account?\")]";
    String facebookEmail = "email";
    String facebookPassword = "pas";
    String facebookLoginButton = "loginbutton";
}
