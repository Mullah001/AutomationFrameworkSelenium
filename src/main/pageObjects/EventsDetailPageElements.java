package main.pageObjects;

public interface EventsDetailPageElements {
    String buyNow = "//button[contains(text(), 'Buy Now')]";
    String seeDetailsButton = "//button[contains(text(),'See Details')]";
    String slotSelection = "//div[@class='eventSlotsContainer row']/div[1]/div/div/img";
    String procssedToCheckout = "//button[contains(text(),'Proceed to Checkout')]";
}
