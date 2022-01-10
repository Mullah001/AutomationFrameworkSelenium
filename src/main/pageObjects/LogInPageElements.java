package main.pageObjects;

public interface LogInPageElements {
    String email = "email";
    String password = "password";
    String logInButton = "//button[@class='log-submit-btn']";
    String userLogged = "//span[@id='headerNavUserMenu']//span[@class='username-wrp']";
}
