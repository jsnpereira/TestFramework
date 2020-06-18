package com.test.framework.exceptions;

/**
 * This class is throw if user not defined the locator type on test.
 */
public class NotSelectLocatorType extends Exception {

    /**
     * @param message set the message value should be show on log.
     */
  public NotSelectLocatorType(final String message) {
      super(message);
  }
}
