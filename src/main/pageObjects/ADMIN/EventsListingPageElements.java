package main.pageObjects.ADMIN;

public interface EventsListingPageElements {

    String eventSideBarA_XPath = "//span[text()='Events']/parent::a";

    String categoriesSelect_Name = "categories";
    String organizationIdSelect_Name = "organizationId";

    String searchInput_XPath = "//label[text()='Search']/following-sibling::div/input";

    String addNewEventButton_XPath = "//button[text()='Add New Event']";

    String listingTableDiv_Class = "table-responsive";
}
