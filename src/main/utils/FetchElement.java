package main.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.BaseTest;

import java.util.List;

public class FetchElement {

    public WebDriver driver;

    public FetchElement(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getWebElement(Locator locator, String locatorValue){
        switch (locator){
            case Id:
                return driver.findElement(By.id(locatorValue));
            case CssSelector:
                return driver.findElement(By.cssSelector(locatorValue));
            case TagName:
                return driver.findElement(By.tagName(locatorValue));
            case Name:
                return driver.findElement(By.name(locatorValue));
            case LinkText:
                return driver.findElement(By.linkText(locatorValue));
            case ClassName:
                return driver.findElement(By.className(locatorValue));
            case XPath:
            default:
                return driver.findElement(By.xpath(locatorValue));
        }
    }

    public List<WebElement> getListOfWebElements(Locator locator, String locatorValue){
        switch (locator){
            case Id:
                return driver.findElements(By.id(locatorValue));
            case CssSelector:
                return driver.findElements(By.cssSelector(locatorValue));
            case TagName:
                return driver.findElements(By.tagName(locatorValue));
            case Name:
                return driver.findElements(By.name(locatorValue));
            case LinkText:
                return driver.findElements(By.linkText(locatorValue));
            case ClassName:
                return driver.findElements(By.className(locatorValue));
            case XPath:
            default:
                return driver.findElements(By.xpath(locatorValue));
        }
    }
}
