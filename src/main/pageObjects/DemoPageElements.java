package main.pageObjects;

import org.openqa.selenium.By;

public interface DemoPageElements {

    /****** IDs ******/
    String contLoginBtn = "cont-logIn";
    String contSignUpBtn = "cont-signUp";
    String infoLoginBtn = "info-logIn";
    String infoSignUpBtn = "info-signUp";

    /******** XPATHs ********/
    String userNameLogin = "//div[@class='form-item log-in']//input[@name='Username']";
    String passwordLogin = "//div[@class='form-item log-in']//input[@name='Password']";

    String emailSignUp = "//div[@class='form-item sign-up']//input[@name='email']";
    String fullNameSignUp = "//div[@class='form-item sign-up']//input[@name='fullName']";
    String userNameSignUp = "//div[@class='form-item sign-up']//input[@name='Username']";
    String passwordSignUp = "//div[@class='form-item sign-up']//input[@name='Password']";

    String haveAnAccountTextPath = "//p[text()='Have an account?']";
    String noAccountTextPath = "//p[text()='No account?']";

    /********* TEXTs *********/
    String haveAnAccountText = "Have an account?";
    String noAccountText = "No account?";

}
