package com.test.framework.commons;

/**
 * The class is set the urls list.
 */
public class PathUrls {
    /**
     * The constructor as initial.
     */
    protected PathUrls() {
    }

    /**
     * The home url.
     */
    public static final String HOME =
            "HTTP://www.automationpractice.com";




    /**
     * The sub class is set the URLs list should be redirect to.
     */
    public static class RedirectTo {
        public static final CharSequence HOME_PAGE_PATH = "/index.php" ;

        /**
         *The constructor as initial.
         */
        protected RedirectTo() {
        }

        /**
         * ORDER_LIST_PAGE variable is contains url of the order page.
         */
        public static final String ORDER_LIST_PAGE_PATH =
                "/index.php?controller=order";
        /**
         * AUTHENTICATION_PAGE variable  is contains
         * url of the authentication page.
         */
        public static final String AUTHENTICATION_PAGE =
                "/index.php?controller=authentication";
        /**
         * ACCOUNT_CREATION_PAGE variable is contains the
         * url of the create the account page.
         */
        public static final String CREATE_ACCOUNT_PAGE =
                "#account-creation";
        /**
         *SHIPPING_PAGE variable is contains the url of the shipping page.
         */
        public static final String SHIPPING_PAGE_PATH =
                "/index.php?controller=order&multi-shipping=";
        /**
         *PAYMENT_METHOD_PAGE variable is contains the url
         *  of the payment method page.
         */
        public static final String PAYMENT_METHOD_PAGE_PATH =
                "/index.php?fc=module&"
                        + "module=bankwire&controller=payment";
        /**
         *ORDER_CONFIRMATION variable is contains the url
         *  of the order confirmation page.
         */
        public static final String ORDER_CONFIRMATION_PAGE_PATH =
                "/index.php?controller="
                        + "order-confirmation&id_cart=";
        /**
         *PAYMENT_PAGE variable is contains the url of the payment page.
         */
        public static final String PAYMENT_PAGE_PATH =
                "/index.php?fc=module&"
                        + "module=bankwire&controller=payment";
    }
}
