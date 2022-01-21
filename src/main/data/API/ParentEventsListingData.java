package main.data.API;

public interface ParentEventsListingData {

    /************ Fetch Parent Events For Consumers **************/

    /* Valid Data */

    String country = "Ghana";
    String isFeatured = "true";
    String upcoming = "true";
    String paginate = "true";
    String page = "1";
    String pageSize = "5";

    /* InValid Data */

    String inValidCountry = "Gh";
    String inValidPaginate = "hello";

    /* Empty Data */

    String emptyCountry = "";
    String emptyPaginate = "";



}
