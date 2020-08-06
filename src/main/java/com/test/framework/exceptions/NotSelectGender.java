package com.test.framework.exceptions;

/**
 * This class is throw if user not defined the gender value on test.
 */
public class NotSelectGender extends Exception {

    /**
     * @param message set the message value should be show on log.
     */
  public NotSelectGender(final String message) {
      super(message);
  }
}
