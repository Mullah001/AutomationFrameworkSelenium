package main.pageObjects;

public interface PurchaseFlowPageElements {

    String moviesLinkA_XPath = "//div[contains(@class,'main-menu')]/nav/ul/li/a[text()='Movies']";

    String godFatherImg_XPath = "//div[@class='moviesImagesWrp']/div[1]//div[contains(@class,'topMoviesImageContainer')]/img[contains(@alt,'Godfather')]";

    String showTimingSlotDiv_XPath = "//div[contains(@class,'cinemaTime')]//div[contains(@class,'showTimings')]";

    String showTimingsBuyButton_XPath = "//div[contains(@class,'cinemaTime')]//button";

    String autoSelectInput_XPath = "//input[@name='autoSelection']";

    String goldenRegularInput_XPath = "//input[@name='golden']";

    String businessRegularInput_XPath = "//input[@name='business']";

    String businessTableRegularInput_XPath = "//input[@name='business-table']";

    String vipTableRegularInput_XPath = "//input[@name='vip-table']";

    String proceedToCheckoutButton_XPath = "//button[text()='Proceed to Checkout']";

    String walletDiv_XPath = "//div[@class='payment-wrp']//div[@class='payment-gateway-box false']";

    String walletPromptPayButton_XPath = "//button[contains(@class,'wallet-prompt_layoutBtn')]";

    String successImg_XPath = "//img[@alt='Success']";


}
