package main.data.API;

public interface ParentEventsListingData {

    /*********** Fetch Parent Events *********/

    String organizationId_all = "all";
    String pageSize_15 = "15";
    String type_all = "all";
    String isPermission_false = "false";
    String isPublished_false = "false";

    /************ Fetch Parent Events For Consumers **************/
    /************ Fetch Trending Events **************/

    /* Valid Data */

    String country = "Ghana";
    String countryPakistan = "Pakistan";
    String isFeatured_true = "true";
    String isFeatured_false = "false";
    String isDraft_false = "false";
    String upcoming = "true";
    String upcoming_false = "false";
    String paginate = "true";
    String isPublished = "true";
    String page = "1";
    String pageSizeWeb_4 = "4";
    String pageSize_5 = "5";
    String pageSizeWeb_6 = "6";
    String pageSizeWeb_20 = "20";
    String[] categories = {"6174af3692a109001a9dc7cd"};
    String[] moviesCategoryID = {"6174af3692a109001a9dc6bc"};

    /* InValid Data */

    String inValidCountry = "lol";
    String inValidPaginate = "hello";

    /* Empty Data */

    String emptyCountry = "";
    String emptyPaginate = "";

    /************ Fetch Nearby Parent Events For Consumers **************/

    /* Valid Data */

    String latitude = "31.5451";
    String longitude = "74.3407";
    //paginate - page - pageSize - country

    /* InValid Data */

    String inValidLatitude = "31.5451";
    String inValidLongitude = "74.3407";

    /* Empty Data */
    String emptyLatitude = "";
    String emptyLongitude = "";






}
