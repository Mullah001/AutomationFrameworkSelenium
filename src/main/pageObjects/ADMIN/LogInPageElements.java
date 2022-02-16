package main.pageObjects.ADMIN;

public interface LogInPageElements {

    String userName_XPath = "//input[@placeholder='Username']";
    String password_XPath = "//input[@placeholder='Password']";

    String logInButton_XPath = "//form[@id='loginform']//button";

    String dashboardSideBar_Id = "sidebarbg";
}
