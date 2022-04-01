package main.pageObjects.WEB;

import static main.data.ADMIN.CreateNewEventData.*;

public interface HomePageElements {
    String signIn = ".sign-in";
    String heroTitle = "//div[@class='home-intro']/h2";


//    Top events

    String topEventContentContainer = "//section[@id='sec2']/div[@class='content-container']";
    String topEventHeading = topEventContentContainer + "/div/div";
    String topEventSubHeading = topEventContentContainer + "/div/p";

    String topEventsgalleryContent =  "//div[contains(@class,'gallery-items')]/a//div[@class='listing-item-cat']";
    String topEventsTtile = topEventsgalleryContent + "/h3";
    String topeventsCategories = topEventsgalleryContent + "/p/span";
    String topEventsDate = topEventsgalleryContent + "/p/time";


//    Upcoming Events

    String upComingEventsContainer = "//section[@class='up-coming-events slider-section-background']";
    String upComingEventsContent = upComingEventsContainer + "/div[@class='content-container']";
    String upComingEventsHeadingXPath = upComingEventsContent + "/div/div";
    String upComingEventsSubHeadingXPath = upComingEventsContent + "/div/p";

    String upcomingeventsCount = "//section[contains(@class,'up-coming-events')]//div[@class='slick-track']//div[contains(@class,'slick-slide') and not(contains(@class,'slick-cloned'))]";
    String upComingEventsCard = "//div[@class='slick-track']/div[@aria-hidden='false'][1]";
    String upComingEventsCardInfo = upComingEventsCard + "//div[@class='geodir-category-content-title-item']";
    String upcomingEventTitle = upComingEventsCardInfo + "/h3/a/span";
    String upComingEventsVenue = upComingEventsCardInfo + "//div[1]//span";
    String upComingEventsDate = upComingEventsCardInfo + "//div[2]//span";
    String upComingEventsDescription = upComingEventsCardInfo + "//div[3]//span";
    String upComingEventsPrice = upComingEventsCard + "//div[@class='geodir-category-footer fl-wrap']/a";



//    Events Categories
    String eventsCategoriesXPath = "//h4[@class='title-sin_map']/a";
    String nextArrow = "//*[@id=\"wrapper\"]/div/div[2]/section/div[2]/div/div[2]/div/div/div/div[2]/div[2]/img";



//    Footer

    String mainFooter = "//footer[@class='main-footer']";
    String innerFooter = mainFooter + "//div[@class='footer-inner']";
    String subFooter = mainFooter + "//div[@class='sub-footer']";
    String exploreLinks = innerFooter + "//div[@class='content-container']//h3[contains(text(), 'Explore')]/following-sibling::div[1]/ul/li/a";
    String categoriesLinks = innerFooter + "//div[@class='content-container']//h3[contains(text(), 'Categories')]/../following-sibling::div[1]/ul/li/a";
    String socialMediaLinks = innerFooter + "//div[@class='content-container']//div[@class='footer-social-btns']/ul/li";
    String facebookLink = socialMediaLinks + "[1]";
    String instaLink = socialMediaLinks + "[2]";
    String twitterLink = socialMediaLinks + "[3]";
    String youtubeLink = socialMediaLinks + "[4]";
    String whatsappLink = socialMediaLinks + "[5]";

    String termsOfService = subFooter + "//ul/li[1]";
    String termsServiceHeading = "//h5[@class='top-heading underline']";
    String privacyPolicy = subFooter + "//ul/li[2]";
    String privacyPolicyHeading = "//h5[@class='top-heading']";
    String rightReserved = "//div[@class='copyright']";
    String address = innerFooter + "//ul[@class='footer-contacts fl-wrap footer-second-widget']/li[2]";

//  Country Selection

    String countryDropdown = "//button[@id='select_flag_button']";
    String countryField = "//div[@class='filterBox']/input";
    String countryName = "//div[@class='filterBox']/following-sibling::li/span/span";

    //Master Search

    String searchField = "//div[@role='combobox']/input[@placeholder='Search']";
    String searchResult = "//input[@placeholder='Search']/following-sibling::div//*[text()='" + eventTitle_Standard_Structured +"']";

//  Profile Dropdown

    String profileDropdown = "//span[@class='username-wrp']";
    String profile = "//ul[@class='hu-menu-vis']/li/a[contains(text(),'Profile')]";

}
