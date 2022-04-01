package main.pageObjects.ADMIN;

import static main.data.ADMIN.CreateNewEventData.*;

public interface CreateNewEventPageElements {

    /********** Dashboard **********/

    public String standardCardH5_XPath = "//h5[text()='Standard Event']";
    public String seriesOfEventCardH5_XPath = "//h5[text()='Series of Event']";
    public String recurringEventCardH5_XPath = "//h5[text()='Recurring Event']";

    /******** Create Event Flow **********/

    String modalHeaderH5_XPath = "//h5[text()='Create Event Flow']";

    String structuredRadioLabel_XPath = "//span[text()='Structured']/parent::label";
    String unStructuredRadioLabel_XPath = "//span[text()='Unstructured']/parent::label";

    String createEventButton_XPath = "//button[text()='Create Event']";
    String cancelButton_XPath = "//button[text()='Cancel']";

    String scheduleH4_XPath = "//h4[text()='Schedule']";

    /********** Create New * Event **********/

    /****** Basic information ********/

    String titleInput_Name = "title";
    String currencySelect_Name = "currency";
    String categoriesSpan_XPath = "//span[text()='Please Select Category']/..";
    String eventsCategorySpan_XPath = "//*[@id='SvgjsSvg1001']/following-sibling::div//ul//span[@title='" +eventCategory +"']";
    String categoriesTextLabel_XPath = "//label[text()='Categories']";
    String descriptionTextArea_Name = "description";
    String imdbUrlInput_Name = "imdbUrl";
    //Tags - Not in use
    String bannerImgInput_XPath = "//label[text()='Upload Banner Image']/..//input[@type='file' and @accept='image/*']";
    String emailInput_XPAth = "//input[@type='email']";
    String mobileInput_Name = "mobile";
    String saveButton_XPath = "//button[text()='Save']";
    String errorPopupDiv_XPath = "//div[@class='swal-title' and text()='Error']";

    String savedMessageDiv_XPath = "//div[@class='message' and contains(text(),'information saved')]";
    String eventSlotSavedSuccessfullyDiv_XPath = "//div[@class='message' and contains(text(),'Event Slot saved SuccessFully')]";

    String nextButton_Id = "next-button";

    /*********** Ticket Classes *********/

    String addMoreTicketClassButton_XPath = "//button[text()='+ Add More']";
    String emptyNameTicketClassInput_XPath = "//input[@name='ticketClassName' and @value='VIP']/../../../../following-sibling::div//input[@name='ticketClassName']";
    String emptyColorTicketClassInput_XPath = "//input[@name='ticketClassName' and @value='VIP']/../../../../following-sibling::div//input[@name='ticketClassColor']";

    /********** Details ********/

    String isFeaturedSelect_Name = "isFeatured";
    String isTicketsPasswordProtectedSelect_Name = "isTicketsPasswordProtected";

    //Sample Date Time Format - 02/22/2022 12:00 AM
    String eventStartDateInput_XPath = "//label[text()='Event Starting Date Time']/parent::div/following-sibling::div//input";
    String eventStartDateDayTd_XPath = "//label[text()='Event Starting Date Time']/parent::div/following-sibling::div//td[text()='" + eventStartDateTime_Day + "' and not(contains(@class,'rdtDisabled'))]";
    String eventEndDateInput_XPath = "//label[text()='Event Ending Date Time']/parent::div/following-sibling::div//input";
    String eventEndDateDayTd_XPath = "//label[text()='Event Ending Date Time']/parent::div/following-sibling::div//td[text()='" + eventEndDateTime_Day + "' and not(contains(@class,'rdtDisabled'))]";
    String entryStartDateInput_XPath = "//label[text()='Entry Starting Date Time']/parent::div/following-sibling::div//input";
    String entryStartDateDayTd_XPath = "//label[text()='Entry Starting Date Time']/parent::div/following-sibling::div//td[text()='" + entryStartDateTime_Day + "' and not(contains(@class,'rdtDisabled'))]";
    String entryCloseDateInput_XPath = "//label[text()='Entry Closing Date Time']/parent::div/following-sibling::div//input";
    String entryCloseDateDayTd_XPath = "//label[text()='Entry Closing Date Time']/parent::div/following-sibling::div//td[text()='" + entryCloseDateTime_Day + "' and not(contains(@class,'rdtDisabled'))]";

    String eventStart_Details_Label_XPath = "//label[text()='Event Start Date']";
    String eventStart_Details_DateInput_XPath = "//label[text()='Event Start Date']/parent::div//input";
    String eventStart_Details_DateDayTd_XPath = "//label[text()='Event Start Date']/parent::div//td[text()='" + eventStartDateTime_Day + "']";
    String eventEnd_Details_DateInput_XPath = "//label[text()='Event End Date']/parent::div//input";
    String eventEnd_Details_DateDayTd_XPath = "//label[text()='Event End Date']/parent::div//td[text()='" + eventEndDateTime_Day + "']";

    String venueSelect_Name = "venueId";
    String seatingPlanSelect_Name = "chartId";

    String addVenueButton_XPath = "//button[text()='Add Venue']";

    /*** Sale Price ***/

    String economyTicketSalePriceInput_XPath = "//input[@value='ECONOMY']/../following-sibling::div/input[@name='ticketClassPrice']";
    String goldenTicketSalePriceInput_XPath = "//input[@value='GOLDEN']/../following-sibling::div/input[@name='ticketClassPrice']";
    String businessTicketSalePriceInput_XPath = "//input[@value='BUSINESS']/../following-sibling::div/input[@name='ticketClassPrice']";
    String businessTableTicketSalePriceInput_XPath = "//input[@value='BUSINESS-TABLE']/../following-sibling::div/input[@name='ticketClassPrice']";
    String vipTableTicketSalePriceInput_XPath = "//input[@value='VIP-TABLE']/../following-sibling::div/input[@name='ticketClassPrice']";
    String standardTicketSalePriceInput_XPath = "//input[@value='STANDARD']/../following-sibling::div/input[@name='ticketClassPrice']";
    String vipTicketSalePriceInput_XPath = "//input[@value='VIP']/../following-sibling::div/input[@name='ticketClassPrice']";
    String customTicketSalePriceInput_XPath = "//input[@value='" + ticketClassName + "']/../following-sibling::div/input[@name='ticketClassPrice']";

    /*** Base Price ***/
    String economyTicketBasePriceInput_XPath = "//input[@value='ECONOMY']/../following-sibling::div/input[@name='ticketClassBasePrice']";
    String goldenTicketBasePriceInput_XPath = "//input[@value='GOLDEN']/../following-sibling::div/input[@name='ticketClassBasePrice']";
    String businessTicketBasePriceInput_XPath = "//input[@value='BUSINESS']/../following-sibling::div/input[@name='ticketClassBasePrice']";
    String businessTableTicketBasePriceInput_XPath = "//input[@value='BUSINESS-TABLE']/../following-sibling::div/input[@name='ticketClassBasePrice']";
    String vipTableTicketBasePriceInput_XPath = "//input[@value='VIP-TABLE']/../following-sibling::div/input[@name='ticketClassBasePrice']";
    String standardTicketBasePriceInput_XPath = "//input[@value='STANDARD']/../following-sibling::div/input[@name='ticketClassBasePrice']";
    String vipTicketBasePriceInput_XPath = "//input[@value='VIP']/../following-sibling::div/input[@name='ticketClassBasePrice']";
    String customTicketBasePriceInput_XPath = "//input[@value='" + ticketClassName + "']/../following-sibling::div/input[@name='ticketClassBasePrice']";

    /*** Available Tickets ***/
    String eventSalePriceses = "//div[contains(text(),'Class Name')]/parent::div/following-sibling::div//input[@name='ticketClassPrice']";
    String eventBasePriceses = "//div[contains(text(),'Class Name')]/parent::div/following-sibling::div//input[@name='ticketClassBasePrice']";


    String businessTicketAvailableTicketsInput_XPath = "//input[@value='BUSINESS']/../following-sibling::div/input[@name='availableTickets']";
    String standardTicketAvailableTicketsInput_XPath = "//input[@value='STANDARD']/../following-sibling::div/input[@name='availableTickets']";
    String vipTicketAvailableTicketsInput_XPath = "//input[@value='VIP']/../following-sibling::div/input[@name='availableTickets']";

    String detailsPageBannerImageInput_XPath = "//h4[text()='Banner Image']/../following-sibling::div//input[@type='file' and @accept='image/*']";

    String onlySaveEventButton_XPath = "//span[text()='Only Save Event']/..";
    String saveAndPublishEventButton_XPath = "//span[text()='Yes Save & Publish']/..";

    /*** Slots ***/

    String addSlotButton_XPath = "//button[text()='Add Slot']";

    String addEventSlotH5_XPath = "//h5[text()='Add Event Slot']";

    String eventSlot_startDateTimeInput_XPath = "//label[text()='Start Date Time']/parent::div//input";
    String eventSlot_startDateDayTd_XPath = "//label[text()='Start Date Time']/parent::div//td[text()='" + eventStartDateTime_Day + "']";
    String eventSlot_endDateTimeInput_XPath = "//label[text()='End Date Time']/parent::div//input";
    String eventSlot_endDateDayTd_XPath = "//label[text()='End Date Time']/parent::div//td[text()='" + eventEndDateTime_Day + "']";

    String eventSlot_entryStartDateTimeInput_XPath = "//label[text()='Entry Start']/parent::div//input";
    String eventSlot_entryStartDateDayTd_XPath = "//label[text()='Entry Start']/parent::div//td[text()='" + entryStartDateTime_Day + "']";
    String eventSlot_entryCloseDateTimeInput_XPath = "//label[text()='Entry Close']/parent::div//input";
    String eventSlot_entryCloseDateDayTd_XPath = "//label[text()='Entry Close']/parent::div//td[text()='" + entryCloseDateTime_Day + "']";

    String eventSlotStartTimeInput_XPath = "//label[text()='Event Slot Start Time']/parent::div//input";

    String modalAddSlotButton_XPath = "//div[@class='modal-body']//button[text()='Add Slot']";
    String slotModalHeaderH5_XPath = "//h5[@class='modal-title']";

    //titleInput_Name
    String agendaSlotInput_Name = "agenda";
    //descriptionTextArea_Name
    //isFeatured
    //PasswordProte
    //isFeaturedSelect_Name
    //isTicketsPasswordProtectedSelect_Name
    //sale price
    //base price
    //bannerImage

    /**** Add Venue Modal ****/

//    String addVenueModalP_XPath = "//div[@class='card-header']/p[.='Add a venue']";
//    String venueNameInput_Id = "name";
//    String venueDescriptionInput_Id = "description";
//    String venueLatitudeInput_Id = "latitude";
//    String venueLongitudeInput_Id = "longitude";
//    String venueCountrySelect_Id = "country";
//    String venueCitySelect_Id = "city";
//    String venueAddressInput_Id = "address";
//    String venuePostalCodeInput_Id = "postalCode";
//    String venueSeatingCapacityInput_Id = "seatingCapacity";


}
