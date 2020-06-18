package com.test.framework.selenium.manager;

import com.test.framework.selenium.base.BasePage;

public class PageContext {

    private static ThreadLocal<BasePage> localCurrentPage  = new ThreadLocal<>();

    public static BasePage getCurrentPage() {
        return localCurrentPage.get();
    }

    public static void setCurrentPage(BasePage driverThreadLocal) {
        localCurrentPage.set(driverThreadLocal);
    }
}
