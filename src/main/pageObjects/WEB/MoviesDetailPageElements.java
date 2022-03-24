package main.pageObjects.WEB;

public interface MoviesDetailPageElements {

    String moviesLinkA_XPath = "//div[contains(@class,'main-menu')]/nav/ul/li/a[text()='Movies']";

    String godFatherImg_XPath = "//div[@class='moviesImagesWrp']/div[1]//div[contains(@class,'topMoviesImageContainer')]/img[contains(@alt,'Godfather')]";

    String showTimingSlotDiv_XPath = "//div[contains(@class,'cinemaTime')]//div[contains(@class,'showTimings')]";

    String showTimingsBuyButton_XPath = "//div[contains(@class,'cinemaTime')]//button";
}
