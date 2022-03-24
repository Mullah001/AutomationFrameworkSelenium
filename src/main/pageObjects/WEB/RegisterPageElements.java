package main.pageObjects.WEB;

public interface RegisterPageElements {

    String clickRegister = "//a[contains(.,'Register')]";
    String email = "email";
    String password = "//input[@name=\"password\"]";
    String name = "name";
    String phoneNumber = "//input[@type=\"tel\"]";
    String termsConditions = "//input[@type=\"checkbox\"]";
    String register = "//button[@type=\"submit\"]";
}
