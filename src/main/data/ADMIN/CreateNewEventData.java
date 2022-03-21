package main.data.ADMIN;

public interface CreateNewEventData {

    /********** Basic Information **********/

    /*** Basic Info ***/
    String eventTitle_Standard_Structured = "Automation Standard Structured";
    String eventTitle_Standard_UnStructured = "Automation Standard UnStructured";
    String eventTitle_Series_Structured = "Automation Series Structured";
    String eventTitle_Series_UnStructured = "Automation Series UnStructured";
    String eventTitle_Recurring_Structured = "Automation Recurring Structured";
    String eventTitle_Recurring_UnStructured = "Automation Recurring UnStructured";


    String currency = "GHS";
    String eventDescription_Standard_Structured = "Standard - Structured Event Description.";
    String eventDescription_Standard_UnStructured = "Standard - UnStructured Event Description.";
    String eventDescription_Series_Structured = "Series - Structured Event Description.";
    String eventDescription_Series_UnStructured = "Series - UnStructured Event Description.";
    String eventDescription_Recurring_Structured = "Recurring - Structured Event Description.";
    String eventDescription_Recurring_UnStructured = "Recurring - UnStructured Event Description.";


    String imdbRatingLink = "";
    String bannerImageAbsolutePath = "C:\\Users\\Hamza Ashfaq\\Pictures\\Picasa\\Exports\\Desktop\\World Wide Expo.jpg";

    /*** Event Contact Details ***/
    String contactEmail = "hamza@automation.com";
    String mobileNumber = "03123456789";

    /************** Ticket Classes *********/

    String ticketClassName = "CUSTOM-TICKET";
    String ticketClassColor = "#4287f5";

    /************** Details ***************/

    /**** Slot ****/

    String eventTitleSeries_Structured_Slot = "Automation Title Series Structured Slot";
    String eventAgendaSeries_Structured_Slot = "Automation Agenda Series Structured Slot";
    String slotDescription_Series_Structured = "Series - Structured Slot Description.";

    String eventTitleSeries_UnStructured_Slot = "Automation Title Series UnStructured Slot";
    String eventAgendaSeries_UnStructured_Slot = "Automation Agenda Series UnStructured Slot";
    String slotDescription_Series_UnStructured = "Series - UnStructured Slot Description.";

    /***** Recurring ****/

    String eventTitleRecurring_Standard_Details = "Automation Title Recurring Structured Details";
    String eventAgendaRecurring_Standard_Details = "Automation Agenda Recurring Structured Details";
    String slotDescription_Recurring_Structured = "Recurring - Structured Slot Description Details.";

    /*** Schedule ***/

    String eventStartDateTime_Day = "23";
    String eventEndDateTime_Day = "26";
    String entryStartDateTime_Day = "23";
    String entryCloseDateTime_Day = "26";

    String eventStartDateTime_Day2 = "24";
    String eventEndDateTime_Day2 = "25";
    String entryStartDateTime_Day2 = "24";
    String entryCloseDateTime_Day2 = "25";

    /*** Venue ***/

    String zaidiStudioText = "Zaidi studios";

    /*** Seating Plan ***/
    String zaidisStudioText = "Zaidi's Studio";

    /*** Available Tickets ***/

    String businessAvailablePrice = "30";
    String vipAvailablePrice = "20";
    String standardAvailablePrice = "100";

    /*** Sale Price ***/

    String economySalePrice = "3.00";
    String goldenSalePrice = "5.50";
    String businessSalePrice = "10.70";
    String businessTableSalePrice = "13.20";
    String vipSalePrice = "16";
    String vipTableSalePrice = "19";
    String standardSalePrice = "8";
    String customTicketSalePrice = "15";

    /*** Base Price ***/

    String economyBasePrice = "2";
    String goldenBasePrice = "4";
    String businessBasePrice = "9";
    String businessTableBasePrice = "12";
    String vipBasePrice = "15";
    String vipTableBasePrice = "18";
    String standardBasePrice = "7";
    String customTicketBasePrice = "12";

    /*** Banner Image - Details ***/

    String bannerImageAbsolutePath_Details = "C:\\Users\\Hamza Ashfaq\\Pictures\\Picasa\\Exports\\Desktop\\World Wide Expo.jpg";

}
