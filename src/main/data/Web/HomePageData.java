package main.data.Web;

import java.util.ArrayList;
import java.util.Arrays;

public interface HomePageData {

//    Top Events Data

    String topEventsHeading = "Top Events";
    String topEventsSubHeading = "Navigate through number of outrageous events happening around";

    //    Upcoming Events Data

    String upComingEventsHeading = "Upcoming Events";
    String upComingEventsSubHeading = "Chalk out your entertainment by exploring the upcoming events based on your preferences";

    ArrayList eventsCategories = new ArrayList(Arrays.asList("Awards", "Seminars", "Conferences", "Tedx"));

//    Footer Data

    ArrayList footerExploreLinksText = new ArrayList(Arrays.asList("About Us", "Contact Us", "Event Organizers", "Publish an Event"));
    ArrayList footerExploreLinksTitle = new ArrayList(Arrays.asList("About Us", "Contact Us", "Organizers"));

    ArrayList footerCategoriesLinksText = new ArrayList(Arrays.asList("Sports", "Tours", "Movies", "Events"));
    ArrayList footerCategoriesLinksTitle = new ArrayList(Arrays.asList("Sports", "Tours", "Movies", "Home"));

    String termServiceText = "TERMS OF SERVICE";
    String privaciPolicy = "Privacy Policy";
    String rightReservedtext = "© Ticketlake 2020 - All Rights Reserved";
    String ticktlakeAddress = "Odotei Tsui Avenue, Dzorwulu (GA-121-9846) - Accra, Ghana";

}
