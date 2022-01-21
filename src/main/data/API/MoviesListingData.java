package main.data.API;

public interface MoviesListingData {

    /**************** Fetch Trending Events Category Wise ******************/

    /* Valid Data */

    String paginate = "true";
    String page = "4";
    String pageSize = "2";
    String[] categories = { "6174af3692a109001a9dc6bc" };

    /* InValid Data */

    String inValidPaginate = "hello";
    String inValidCategories = "6174af3692a109001a9dc6bc" ;

    /* Empty Data */

    String emptyPaginate = "";
    String[] emptyCategories = { "" };

}
