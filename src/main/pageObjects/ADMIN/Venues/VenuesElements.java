package main.pageObjects.ADMIN.Venues;

public interface VenuesElements {
    String venueListing = "//div[@class='table-responsive']//tbody/tr";
    String firstVenueName = "//div[@class='table-responsive']//tbody/tr[1]/td[1]";


    String addVenueButton = "//button[contains(text(), 'Add Venue')]";
    String nameField = "//input[@name='name']";
    String description = "//textarea[@name='description']";
    String latitude = "//input[@name='latitude']";
    String longitude = "//input[@name='longitude']";
    String getCountry = "//select[@name='country']";
    String city = "//select[@name='city']";
    String address = "//input[@name='address']";
    String postalCode = "//input[@name='postalCode']";
    String seatingCapacity = "//input[@name='seatingCapacity']";
    String seatingPlan = "//*[@id='SvgjsSvg1001']/following-sibling::div[1]//div[contains(@class,'ant-select-dropdown--multiple')]//ul//li[2]";
    


}
