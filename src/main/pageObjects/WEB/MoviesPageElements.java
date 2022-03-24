package main.pageObjects.WEB;

public interface MoviesPageElements {

    String moviesLinkA_XPath = "//div[contains(@class,'main-menu')]/nav/ul/li/a[text()='Movies']";

    /***************** Search Bar ********************/

    String keywordInput_Name = "search";

    String categoriesDiv_XPath = "//div[@title='All Categories']/..";
    String categoriesListLi_XPath = "//li[.='All Categories']/following-sibling::li";

    String cityDiv_XPath = "//div[@title='All Cities']/..";
    String cityListLi_XPath = "//li[.='All Cities']/following-sibling::li";

    String timeRangeDiv_XPath = "//input[@value='Any Time']//parent::div";
    String timeRangeListLi_XPath = "//li[.='Any Time']/following-sibling::li";

    String searchButton_XPath = "//div[@id='wrapper']//button";

    String moviesListingDiv_XPath = "//div[contains(@class,'moviesImagesWrp')]/div/div";

    String noRecordErrorDiv_XPath = "//div[text()='Sorry, No Movies Found.']";

    /******************* Slider ***********************/

    String sliderDiv_XPath = "//div[@class='slick-track']/div[not(contains(@class,'slick-cloned'))]";

    String horrorP_XPath = "//div[@class='slick-slide']//p[text()='Horror']";

    /**************** Top Movies ******************/

    String topMoviesH2_XPath = "//div[@class='moviesImagesWrp']//h2";

    String topMoviesImg_XPath = "//div[@class='moviesImagesWrp']//div[contains(@class,'topMoviesImageContainer')]//img[not(@alt='img')]";

    String topMoviesIteratorStart_XPath = "//div[@class='moviesImagesWrp']//div[@class='m-0 row']/div";

    String topMoviesIteratorEnd_XPath = "//div[contains(@class,'topMoviesImageContainer')]//img[not(@alt='img')]";

    String exploreMoviesButton_XPath = "//button[contains(@class,'exploreMoviesBtn')]";

    /**************** Movies Details *******************/

    String movieTitleDiv_ClassName = "title";

    /****************** Trending Movies ********************/

    String trendingMoviesTextSpan_XPath = "//div[@class='moviesImagesWrp']/div[2]//span[contains(@class,'headingText')]";

    String trendingSeeAllButton_XPath = "//div[@class='moviesImagesWrp']/div[2]//button[contains(@class,'seeAllBtn') and not(contains(@class,'Small'))]";

    String trendingMoviesImg_XPath = "//div[@class='moviesImagesWrp']/div[2]//img";

    /****************** Showing in Cinemas Movies ********************/

    String showingInCinemasMoviesTextSpan_XPath = "//div[@class='moviesImagesWrp']/div[3]//span[contains(@class,'headingText')]";

    String showingInCinemasSeeAllButton_XPath = "//div[@class='moviesImagesWrp']/div[3]//button[contains(@class,'seeAllBtn') and not(contains(@class,'Small'))]";

    String showingInCinemasMoviesImg_XPath = "//div[@class='moviesImagesWrp']/div[3]//img";

    /****************** UpComing Movies ********************/

    String upComingMoviesTextSpan_XPath = "//div[@class='moviesImagesWrp']/div[4]//span[contains(@class,'headingText')]";

    String upComingSeeAllButton_XPath = "//div[@class='moviesImagesWrp']/div[4]//button[contains(@class,'seeAllBtn') and not(contains(@class,'Small'))]";

    String upComingMoviesImg_XPath = "//div[@class='moviesImagesWrp']/div[4]//img";

}
