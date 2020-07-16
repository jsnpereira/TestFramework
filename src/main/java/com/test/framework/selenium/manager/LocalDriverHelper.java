package com.test.framework.selenium.manager;

import com.test.framework.selenium.base.DriverHelper;
import org.openqa.selenium.remote.RemoteWebDriver;


public class LocalDriverHelper {

    private static ThreadLocal<RemoteWebDriver> driverThreadLocal = new ThreadLocal<>();

    public static RemoteWebDriver driver() {
        return driverThreadLocal.get();
    }

    public static void setDriver(RemoteWebDriver driverThreadLocal) {
        LocalDriverHelper.driverThreadLocal.set(driverThreadLocal);
    }
}
