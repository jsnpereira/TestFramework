package com.test.framework.selenium.base;

import com.test.framework.exceptions.NotSelectLocatorType;
import org.openqa.selenium.By;

/**
 * This class is set the elements located on page.
 */
public class Locator {
    /**
     * The constructor as initial.
     */
    protected Locator() {
    }

    /**
     * @param locator Set the locator value.
     * @param locatorType Set the locator type
     * @return Get the element located on page.
     * @throws NotSelectLocatorType throw the exception
     * if it not defined locator type.
    */
    public static By getBy(final String locator,
                           final LocatorType locatorType)
            throws NotSelectLocatorType {
        switch (locatorType) {
            case XPATH:
                return By.xpath(locator);
            case CSS_SELECTOR:
                return By.cssSelector(locator);
            case NAME:
                return By.name(locator);
            case LINK_TEXT:
                return By.linkText(locator);
            case ID:
                return By.id(locator);
            case TAG_NAME:
                return By.tagName(locator);
            case CLASS:
                return By.className(locator);
            default:
                throw new
                NotSelectLocatorType("The locator type wasn't defined");
        }
    }
}
