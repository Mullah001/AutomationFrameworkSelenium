package main.pageObjects;

public interface LogInPageElements {
    String email = "//input[@type = \"email\"][@placeholder=\"Email\"]";
    String password = "//input[@name=\"password\"]";
    String logInButton = "//button[@type=\"submit\"]";
    String forgetpassword = "//a[contains(text(),'Forgot Password?')]";
    String socialLoginWithGoogle = "//*[@id=\"tab-1\"]/div/form/div[2]/button/div";
    String getSocialLoginWithFacebook = "//*[@id=\"tab-1\"]/div/form/div[2]/span/button";
}
