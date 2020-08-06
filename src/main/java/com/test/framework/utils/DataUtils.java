package com.test.framework.utils;

import java.util.Random;

/**
 *This class is generate the new value string.
 */
public final class DataUtils {
    /**
     *ALPHA_NUMERIC_STRING variable will be run the random.
     */
    private static final String ALPHA_NUMERIC_STRING
            = "abcdefghijklmnopqrstuvwxyz"
            + "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /**
     * The constructor as initial.
     */
    private DataUtils() {
    }

    /**
     * @param length Set the number will be length on string value
     * @return Get the new value generated
     */
    public static String getNewString(final int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(ALPHA_NUMERIC_STRING
                    .charAt(random.nextInt(
                        ALPHA_NUMERIC_STRING.length())));
        }
        return sb.toString();
    }

    public static String createEmail(final String username,
                                     final String domain) {
        return createEmail(username,domain, false);
    }

    /**
     * @param username Set the email's username
     * @param domain Set the email's domain
     * @return Get the email generated
     */
    public static String createEmail(final String username,
                                     final String domain, Boolean onlyLowCase) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer(username + "+");
        for (int i = 0; i < 6; i++) {
            sb.append(ALPHA_NUMERIC_STRING.charAt(
                    random.nextInt(ALPHA_NUMERIC_STRING.length())));
        }
        sb.append("@" + domain);
        if (onlyLowCase){
            return sb.toString().toLowerCase();
        } else {
            return sb.toString();
        }
    }
}
