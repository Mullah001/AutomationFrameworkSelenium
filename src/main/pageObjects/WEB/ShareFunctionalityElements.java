package main.pageObjects.WEB;

public interface ShareFunctionalityElements {

    String ticketTab = "//ul[@class='dasboard-menu-wrap']/li/a[contains(text(),'Ticket')]";
    String shareTicketButton = "//div[@class='shareTicketButton ']/button[contains(text(),'Share Ticket')]";
    String sharePassButton = "//div[@class='shareTicketButton ']/button[contains(text(),'Share Pass')]";
    String checkBox = "//div[@class='ant-checkbox-group']/label[1]/span[1]/input";
    String phoneNumberField = "//input[@placeholder='Phone Number']";
    String nameField = "//input[@name='shareTicketName']";
    String emailField = "//input[@name='shareTicketEmail']";
    String shareButton = "//button[@type='submit']";
}
