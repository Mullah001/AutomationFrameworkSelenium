package main.pageObjects.WEB;

public interface HeaderpageElements {

    String headerLeft = ".headerLeft.col-md-7";
    String menuBase = "//div[@class='headerLeft col-md-7']//ul[@class='parent-menu']";

    String events = menuBase + "/li/a[text()='Events']";
    String eventsCategories = events + "/following-sibling::ul/li";
    String eventsDropdown = events + "/following-sibling::ul";

    String movies = "//div[@class='headerLeft col-md-7']//ul[@class='parent-menu']/li/a[text()='Movies']/..";
    String moviesCategories = "//div[@class='headerLeft col-md-7']//ul[@class='parent-menu']/li/a[text()='Movies']/following-sibling::ul/li";
    String moviesDropdown = "//div[@class='headerLeft col-md-7']//ul[@class='parent-menu']/li/a[text()='Movies']/following-sibling::ul";


    String sports = menuBase + "/li/a[text()='Sports']";
    String sportsCategories = sports + "/following-sibling::ul/li";
    String sportsDropdown = sports + "/following-sibling::ul";

    String global = menuBase + "/li/a[text()='Global']";
    String globalCategories = global + "/following-sibling::ul/li";
    String globalDropdown = global + "/following-sibling::ul";

    String nearby = menuBase + "/li/a[text()='Nearby']";
    String nearbyCategories = nearby + "/following-sibling::ul/li";
    String nearbyDropdown = nearby + "/following-sibling::ul";

    String voting = menuBase + "/li/a[text()='Votings']";

    String masterSearch = "//*[@id=\"main\"]/header/div[2]/div/div/div[2]/div/div[1]/div/div/div/div/div/input";
    String masterSearchResult = "//*[@id='react-autowhatever-1']/ul";

    String countryFilter = "//div[@class='countryContainer']";
    String countryFilterListing = countryFilter + "//ul";
    String countrFilterInput = countryFilterListing + "/div/input";
    String newCountry = countryFilterListing + "/li";
    String getNewCountryName = countryFilter + "//button/span/span";
}
