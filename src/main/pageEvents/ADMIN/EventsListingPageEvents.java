package main.pageEvents.ADMIN;

import main.utils.API_DataMethods;
import main.utils.CommonMethods;
import main.utils.FetchElement;
import main.utils.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static main.pageObjects.ADMIN.EventsListingPageElements.*;

public class EventsListingPageEvents extends CommonMethods {

    FetchElement fetchElement = new FetchElement();
    API_DataMethods api_dataMethods = new API_DataMethods();

    /************ API **************/

    public int getOrganizationsCount_API() {
        return api_dataMethods.getOrganizationsCount();
    }

    public int getAllParentCategoriesCount_API() {
        return api_dataMethods.getAllParentCategoriesCount();
    }

    public int getTotalPagesParentEvents_API() {
        return api_dataMethods.getTotalPagesParentEventsCount_Admin();
    }

    /**************** Web ******************/

    public void clickEventsSideBar(){
        fetchElement.getWebElement(Locator.XPath, eventSideBarA_XPath).click();
    }

    public void clickAddNewEventButton(){
        fetchElement.getWebElement(Locator.XPath, addNewEventButton_XPath).click();
    }

    public int getCategorySelectOptionsCount() {
        return getSelectOptions(Locator.Name, categoriesSelect_Name).size();
    }

    public int getOrganizerSelectOptionsCount() {
        return getSelectOptions(Locator.Name, organizationIdSelect_Name).size();
    }
    /******************* Helper Methods *********************/

    public List<WebElement> getSelectOptions(Locator locatorType, String locator){
        Select select = new Select(fetchElement.getWebElement(locatorType, locator));
        List<WebElement> options = select.getAllSelectedOptions();
        return options;
    }


}
