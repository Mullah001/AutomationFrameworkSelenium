package main.pageObjects.WEB;

public interface MoviesDetailsPageElements {

    String titleDiv_ClassName = "title";

    String categoriesDiv_XPath = "//div[contains(@class,'detailCardContent')]//div[contains(@class,'cardMain')]/div[@class='col']";

    String priceRangeDiv_ClassName = "priceRange";

    String castImg_XPath = "//img[@alt='cast']";

    String shareButton_XPath = "//div[contains(@class,'buyShareWishButton')]//div[contains(@class,'Share')]/button";

    String buyTicketButton_XPath = "//div[contains(@class,'buyShareWishButton')]//div[contains(@class,'Add')]/button";

    String descriptionTitleDiv_XPath = "//div[contains(@class,'descriptinContainer')]/div[1]";

    String descriptionTextDiv_XPath = "//div[contains(@class,'descriptinContainer')]/div[2]";

    String trailerTitleDiv_XPath = "//div[contains(@class,'descriptinContainer')]/following-sibling::div/div[contains(@class,'trailerTitle')]";

    String trailerVideosSpan_XPath = "//div[contains(@class,'descriptinContainer')]/following-sibling::div/div/span";

    String showTimingsTitleDiv_XPath = "//div[contains(@class,'showTimingsTitle')]";

    String showTimingsDatesSelect_XPath = "//section[contains(@class,'ShowTimings')]//select";

    String cinemaNameDiv_XPath = "//div[contains(@class,'cinemaName')]";

    String showTimingsDiv_XPath = "//div[contains(@class,'showTimings_')]";

    String showBuyButton_XPath = "//div[contains(@class,'cinemaTime')]//button";


}
