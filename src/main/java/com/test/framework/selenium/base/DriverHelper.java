package com.test.framework.selenium.base;


import com.test.framework.exceptions.NotSelectLocatorType;
import com.test.framework.selenium.manager.LocalDriverHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    public WebElement getElement(String locator, LocatorType locatorType) throws NotSelectLocatorType {
        return LocalDriverHelper.driver().findElement(Locator.getBy(locator, locatorType));
    }

    protected static void moveToElement(final WebElement element) {
        Actions action = new Actions(LocalDriverHelper.driver());
        action.moveToElement(element).build().perform();
    }

    public static void redirectTo(final String url) {
        WebDriverWait wait = new WebDriverWait(
                LocalDriverHelper.driver(),30);
        wait.until(ExpectedConditions.urlContains(url));
        loading();
    }

}
