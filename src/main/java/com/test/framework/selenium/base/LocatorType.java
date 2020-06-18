package com.test.framework.selenium.base;

/**
 *This class is set the locator type should be set locator for elements.
 */
public enum LocatorType {
    /**
     *  XPATH locator type value.
     */
    XPATH("XPATH"),
    /**
     * ID locator type value.
     */
    ID("ID"),
    /**
     *CSS_SELECTOR locator type value.
     */
    CSS_SELECTOR("CSS_SELECTOR"),
    /**
     *NAME locator type value.
     */
    NAME("NAME"),
    /**
     *LINK_TEXT locator type value.
     */
    LINK_TEXT("LINK_TEXT"),
    /**
     *TAG_NAME locator type value.
     */
    TAG_NAME("TAG_NAME"),
    /**
     *CLASS locator type value.
     */
    CLASS("CLASS");

    /**
     * Set the locator type value.
     */
    private String type;

    /**
     * @param locatorTypeValue set the locator type value.
     */
    LocatorType(final String locatorTypeValue) {
        this.type = locatorTypeValue;
    }
}
