package main.pageObjects.WEB;

public interface ForgetPasswordElements {

    String forgetEmail = "email";
    String submitButton = "//button[@type=\"submit\"]";
    String loginAgain = "//span[contains(text(),'Login Again')]";

//    Email Elements

    String emailSignIn = "//a[@data-action = \"sign in\"]";
    String googleEmail = "//input[@type=\"email\"]";
    String nextEmail = "//span[contains(text(),'Next')]";
    String googlePassword = "//input[@type=\"password\"]";
    String nextPassword = "//span[contains(text(),'Next')]";

    String sreachField = "//*[@id=\"gs_lc50\"]/input[1]";
    String forgetPasswordEmail = "//*[@id=\":1\"]//div[@role='main']//table/tbody/tr[1]";
    String resetYourPassword = "//div[@role='listitem'][last()]//tbody//tr//td//strong//a";

//    Reset Password

    String newPassword = "newPassword";
    String confirmNewPassword = "confirmPassword";
    String againSubmit = "//button[@type=\"submit\"]";
    String congratulations = "/html/body/table/tbody/tr/td/div/div[2]/div/div/div[2]/div/strong";


//    SignIn Again

    String email = "//input[@type = \"email\"][@placeholder=\"Email\"]";
    String password = "//input[@name=\"password\"]";
    String logInButton = "//button[@type=\"submit\"]";
    String forgetpassword = "//a[contains(text(),'Forgot Password?')]";
}
