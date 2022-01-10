package main.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.BaseTest;

import java.util.List;

public class FetchElement {

    public WebElement getWebElement(Locator locator, String locatorValue){
        switch (locator){
            case Id:
                return BaseTest.driver.findElement(By.id(locatorValue));
            case CssSelector:
                return BaseTest.driver.findElement(By.cssSelector(locatorValue));
            case TagName:
                return BaseTest.driver.findElement(By.tagName(locatorValue));
            case Name:
                return BaseTest.driver.findElement(By.name(locatorValue));
            case LinkText:
                return BaseTest.driver.findElement(By.linkText(locatorValue));
            case ClassName:
                return BaseTest.driver.findElement(By.className(locatorValue));
            case XPath:
            default:
                return BaseTest.driver.findElement(By.xpath(locatorValue));
        }
    }

    public List<WebElement> getListOfWebElements(Locator locator, String locatorValue){
        switch (locator){
            case Id:
                return BaseTest.driver.findElements(By.id(locatorValue));
            case CssSelector:
                return BaseTest.driver.findElements(By.cssSelector(locatorValue));
            case TagName:
                return BaseTest.driver.findElements(By.tagName(locatorValue));
            case Name:
                return BaseTest.driver.findElements(By.name(locatorValue));
            case LinkText:
                return BaseTest.driver.findElements(By.linkText(locatorValue));
            case ClassName:
                return BaseTest.driver.findElements(By.className(locatorValue));
            case XPath:
            default:
                return BaseTest.driver.findElements(By.xpath(locatorValue));
        }
    }
}
