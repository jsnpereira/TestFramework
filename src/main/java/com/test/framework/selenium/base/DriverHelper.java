package com.test.framework.selenium.base;


import com.test.framework.exceptions.NotSelectLocatorType;
import com.test.framework.selenium.manager.LocalDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DriverHelper {

    public static void navigation(String url) {
        LocalDriverHelper.driver().get(url);
        loading();
    }

    public static void QuitDriver() {
        LocalDriverHelper.driver().quit();
    }

    public static void loading() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(final WebDriver driver) {
                String status = ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState").toString();
                return ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(LocalDriverHelper.driver(), 30);
        wait.until(pageLoadCondition);
    }

    public static void waitForElementVisible(final WebElement element) {
        WebDriverWait wait = new WebDriverWait(LocalDriverHelper.driver(), 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void WaitForElementTextVisible(final WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(LocalDriverHelper.driver(), 30);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static WebElement getElement(String locator, LocatorType locatorType) throws NotSelectLocatorType {
        return getElement(Locator.getBy(locator, locatorType));
    }
    public static WebElement getElement(By locator) throws NotSelectLocatorType {
        return LocalDriverHelper.driver().findElement(locator);
    }

    public static void moveToElement(final WebElement element) {
        Actions action = new Actions(LocalDriverHelper.driver());
        action.moveToElement(element).build().perform();
    }

    public static void scrollToViewElement(final WebElement element) throws NotSelectLocatorType {
        ((JavascriptExecutor) LocalDriverHelper.driver()).
                executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void waitElementBeClicked(final WebElement element) {
        WebDriverWait wait = new WebDriverWait(
                LocalDriverHelper.driver(), 3);
        final WebElement until = wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void typeTextInput(final WebElement element, String text){
        typeTextInput(element, text, false);
    }

    public static void typeTextInput(final WebElement element, String text, Boolean clean){
        if (clean) {
            element.clear();
        }
        element.sendKeys(text);
    }

    public static void selectItemOnDropDown(final WebElement element, final String value) {
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }

    public static void redirectTo(final String url) {
        WebDriverWait wait = new WebDriverWait(
                LocalDriverHelper.driver(),30);
        wait.until(ExpectedConditions.urlContains(url));
        loading();
    }

    public static void selectItemVisibleOnDropDown(WebElement countriesListDropdown, String value) {
        Select dropdown = new Select(countriesListDropdown);
        dropdown.selectByVisibleText(value);
    }

    public static String getCurrentURL() {
        return LocalDriverHelper.driver().getCurrentUrl();
    }
}
