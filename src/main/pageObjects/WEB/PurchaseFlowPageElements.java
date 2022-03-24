package main.pageObjects.WEB;

public interface PurchaseFlowPageElements {


    String autoSelectInput_XPath = "//input[@name='autoSelection']";

    String ticketclasses = "//div[@class='butTicketClassContainer']/div/div/div[2]/div/input";

    String proceedToCheckoutButton_XPath = "//button[text()='Proceed to Checkout']";

    String walletDiv_XPath = "//div[@class='payment-wrp']//div[@class='payment-gateway-box false']";

    String paypalDiv_XPath = "//img[@alt='paypal-logo']//ancestor::div[contains(@class,'payment-gateway-box')]";

    String walletPromptPayButton_XPath = "//button[contains(@class,'wallet-prompt_submit')]";

    String successImg_XPath = "//img[@alt='Success']";


}
